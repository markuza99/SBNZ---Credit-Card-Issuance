package sbnz.integracija.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.models.Korisnik;
import sbnz.integracija.example.services.BankService;

@RestController
public class BankController {
	private static Logger log = LoggerFactory.getLogger(BankController.class);

	private final BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public Korisnik getQuestions(@RequestBody Korisnik k) {


		log.debug("User request received for: " + k);
		
		Korisnik k1 = bankService.getClassifiedKorisnik(k);

		return k1;
	}
	
	
	
}
