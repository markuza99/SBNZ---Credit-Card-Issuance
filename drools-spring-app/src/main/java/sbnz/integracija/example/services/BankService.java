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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;

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
import org.springframework.stereotype.Service;

import sbnz.integracija.example.data.CreditCard;
import sbnz.integracija.example.data.Transaction;
import sbnz.integracija.example.data.User;
import sbnz.integracija.example.events.TransactionEvent;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.facts.TransactionInfo;
import sbnz.integracija.example.repositories.CreditCardRepository;
import sbnz.integracija.example.repositories.TransactionRepository;
import sbnz.integracija.example.repositories.UserRepository;
import sbnz.integracija.example.template.BankTemplate;

@Service
@EnableScheduling
public class BankService {

	private static Logger log = LoggerFactory.getLogger(BankService.class);

	private final KieContainer kieContainer;
	private final KieSession kieSession; // DODAO
	private final UserRepository userRepository;
	private final CreditCardRepository creditCardRepository;
	private final TransactionRepository transactionRepository;

	@Autowired
	public BankService(KieContainer kieContainer, KieSession kieSession, UserRepository userRepository,
			CreditCardRepository creditCardRepository, TransactionRepository transactionRepository) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.kieSession = kieSession;
		this.userRepository = userRepository;
		this.creditCardRepository = creditCardRepository;
		this.transactionRepository = transactionRepository;

	}

	public String chain(CreditCardInfo k) {
		User u = getUser(k.getUserId());
		FactHandle fh1 = kieSession.insert(k);
		FactHandle fh2 = kieSession.insert(u);
		kieSession.fireAllRules();
		kieSession.retract(fh1);
		kieSession.retract(fh2);
		userRepository.save(u);

		return "Card created!";
	}
	
	public User getUser(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
	}
	
	public CreditCard getCreditCard(Long id) {
			
		return creditCardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Credit card with id " + id + " not found"));
	}
	
	

	public TransactionEvent transaction(TransactionInfo ti) {
		CreditCard sender = getCreditCard(ti.getPayerId());
		CreditCard recipient = getCreditCard(ti.getRecipientId());

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
		}
		creditCardRepository.save(sender);

		
		
		return null;
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

		return "Success";
	}

}
