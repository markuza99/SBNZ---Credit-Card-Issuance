package sbnz.integracija.example.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.models.Korisnik;

@Service
public class BankService {

	private static Logger log = LoggerFactory.getLogger(BankService.class);

	private final KieContainer kieContainer;

	@Autowired
	public BankService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
	}

	public Korisnik getClassifiedKorisnik(Korisnik k) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(k);
		kieSession.fireAllRules();
		kieSession.dispose();
		return k;
	}
}
