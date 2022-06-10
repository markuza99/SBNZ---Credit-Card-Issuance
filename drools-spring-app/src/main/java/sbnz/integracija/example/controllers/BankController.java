package sbnz.integracija.example.controllers;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.config.TokenProvider;
import sbnz.integracija.example.data.AuthToken;
import sbnz.integracija.example.data.LoginUser;
import sbnz.integracija.example.data.User;
import sbnz.integracija.example.events.TransactionEvent;
import sbnz.integracija.example.exceptions.EntityNotFoundException;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.facts.TransactionInfo;
import sbnz.integracija.example.services.BankService;
import sbnz.integracija.example.template.BankTemplate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BankController {
	private static Logger log = LoggerFactory.getLogger(BankController.class);

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
	private final BankService bankService;

	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
	
	@RequestMapping(value = "/chain", method = RequestMethod.GET, produces = "application/json")
	public String chain(@RequestBody CreditCardInfo k) {


		log.debug("User request received for: " + k);
		
		String res = bankService.chain(k);

		return res;
	}
	
	@RequestMapping(value = "/template", method = RequestMethod.GET, produces = "application/json")
	public String template(@RequestBody BankTemplate t) throws IOException, MavenInvocationException {


		log.debug("Template request received for: " + t);
		
		String k1 = bankService.doTemplate(t);

		return k1;
	}
	
	@RequestMapping(value = "/bank", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BANKER')")
    public String getProducts() {
        return "SAMO BANKAR VIDI";
    }
	
	
	@RequestMapping(value = "/trans", method = RequestMethod.GET, produces = "application/json")
	public TransactionEvent transaction(@RequestBody TransactionInfo ti) {

		log.debug("Transaction request received for: " + ti);
		
		TransactionEvent k1 = bankService.transaction(ti);
		return k1;
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity(noSuchElementException.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	
	
}
