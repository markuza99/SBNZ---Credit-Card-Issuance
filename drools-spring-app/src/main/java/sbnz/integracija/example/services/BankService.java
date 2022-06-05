package sbnz.integracija.example.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.data.User;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.repositories.UserRepository;

@Service
public class BankService {

	private static Logger log = LoggerFactory.getLogger(BankService.class);

	private final KieContainer kieContainer;
	private final KieSession kieSession; //DODAO
	private final UserRepository userRepository;

	@Autowired
	public BankService(KieContainer kieContainer, UserRepository userRepository) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.kieSession = kieContainer.newKieSession(); //DODAO
		this.userRepository = userRepository;

	}


	
	public User test(CreditCardInfo k) {
		User u = userRepository.findById(k.getUserId()).get();
		kieSession.insert(k);
		kieSession.insert(u);
		kieSession.fireAllRules();
		userRepository.save(u);
		return null;
	}
}
