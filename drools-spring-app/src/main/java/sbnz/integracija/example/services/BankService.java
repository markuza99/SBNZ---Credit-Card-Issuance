package sbnz.integracija.example.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.data.CreditCard;
import sbnz.integracija.example.data.Transaction;
import sbnz.integracija.example.data.User;
import sbnz.integracija.example.dtos.CreditCardDTO;
import sbnz.integracija.example.events.TransactionEvent;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.facts.TransactionInfo;
import sbnz.integracija.example.repositories.BankTemplateRepository;
import sbnz.integracija.example.repositories.CreditCardRepository;
import sbnz.integracija.example.repositories.TransactionRepository;
import sbnz.integracija.example.repositories.UserRepository;
import sbnz.integracija.example.template.BankTemplate;

@Service(value = "bankService")
@EnableScheduling
public class BankService implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(BankService.class);

	private final KieContainer kieContainer;
	private final KieSession kieSession; // DODAO
	private final UserRepository userRepository;
	private final CreditCardRepository creditCardRepository;
	private final TransactionRepository transactionRepository;
	private final BankTemplateRepository bankTemplateRepository;


	@Autowired
	public BankService(KieContainer kieContainer, KieSession kieSession, UserRepository userRepository,
			CreditCardRepository creditCardRepository, TransactionRepository transactionRepository,BankTemplateRepository bankTemplateRepository) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.kieSession = kieSession;
		this.userRepository = userRepository;
		this.creditCardRepository = creditCardRepository;
		this.transactionRepository = transactionRepository;
		this.bankTemplateRepository = bankTemplateRepository;

	}
	
	public List<CreditCardDTO> getCreditCards() {
		return creditCardRepository.findAll().stream()
		        .map(cc -> new CreditCardDTO(cc))
		        .collect(Collectors.toList());
	}

	public String chain(CreditCardInfo k) {
		User u = getUser(k.getUserId());
		int cardNum = u.getCreditCards().size();
		FactHandle fh1 = kieSession.insert(k);
		FactHandle fh2 = kieSession.insert(u);
		int rules = kieSession.fireAllRules();
		kieSession.retract(fh1);
		kieSession.retract(fh2);
		if(rules == 0) {
			return "Request denied: Request, client, contract or company information are invalid! ";
		}
		if(u.getCreditCards().size() == cardNum) {
			return "Request denied: Potential deposit is too big!";
		}

		userRepository.save(u);

		return "Success: Card created successfully!";
	}
	

	
	public User getUser(String id) {
		
		return userRepository.findByUsername(id).orElseThrow(() -> new NoSuchElementException("User with username " + id + " not found"));
	}
	
	public CreditCard getCreditCard(Long id) {
			
		return creditCardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Credit card with id " + id + " not found"));
	}
	
	

	public String transaction(TransactionInfo ti) {
		CreditCard sender = getCreditCard(ti.getPayerId());
		CreditCard recipient = getCreditCard(ti.getRecipientId());
		String result = "";
		kieSession.insert(new TransactionEvent(ti));
		FactHandle fh1 = kieSession.insert(sender);
		FactHandle fh = kieSession.insert(new Date());
		kieSession.fireAllRules();
		kieSession.retract(fh);
		kieSession.retract(fh1);
		
		if(!sender.isBlocked()) {
			Transaction transaction = new Transaction(LocalDate.now(), ti.getTotalAmount(), sender, recipient);
			sender.addOutflows(transaction);
			recipient.addInflow(transaction);
			if(sender.isWarned()) {
				result = "Transaction Warning";
			} else {
				result = "Transaction Successful";
			}
		} else {
			result = "Transaction Blocked";
		}
		creditCardRepository.save(sender);
		return result;
		
		
	}

	private String compileTemplate(BankTemplate bt, String rule) {

		List<BankTemplate> templateModels = new ArrayList<>();

		templateModels.add(bt);

		try (InputStream inputStream = new FileInputStream(
				"../drools-spring-kjar/src/main/resources/sbnz/integracija/templates/" + rule)) {
			ObjectDataCompiler compiler = new ObjectDataCompiler();
			String drl = compiler.compile(templateModels, inputStream);
			return drl;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void writeCompiledTemplate(String compiledRules, String rule) throws IOException {
		File file = new File("../drools-spring-kjar/src/main/resources/sbnz/integracija/" + rule);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(compiledRules);
		}
	}

	public String doTemplate(BankTemplate dto) throws IOException, MavenInvocationException {

		String drl = compileTemplate(dto, "validate-user.drt");
		this.writeCompiledTemplate(drl, "validate-user-rules.drl");
		sbnz.integracija.example.data.BankTemplate bt = bankTemplateRepository.findById((long) 1).get();
		bt.setBasketOfGoods(dto.getBasketOfGoods());
		bankTemplateRepository.save(bt);
		return "Success";
	}
	
	public String getBasketOfGoods() {
		
		return Double.toString(bankTemplateRepository.findById((long) 1).get().getBasketOfGoods());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = getUser(username);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorities;
    }

}
