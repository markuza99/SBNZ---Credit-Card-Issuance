package sbnz.integracija.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.data.User;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.services.BankService;

@RestController
public class BankController {
	private static Logger log = LoggerFactory.getLogger(BankController.class);

	private final BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public User test(@RequestBody CreditCardInfo k) {


		log.debug("User request received for: " + k);
		
		User k1 = bankService.test(k);

		return k1;
	}
	
	
	
	
}
