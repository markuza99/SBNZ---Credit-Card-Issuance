package sbnz.integracija.example.controllers;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.config.TokenProvider;
import sbnz.integracija.example.data.AuthToken;
import sbnz.integracija.example.data.LoginUser;
import sbnz.integracija.example.data.User;
import sbnz.integracija.example.dtos.CreditCardDTO;
import sbnz.integracija.example.dtos.TransactionDTO;
import sbnz.integracija.example.events.TransactionEvent;
import sbnz.integracija.example.exceptions.EntityNotFoundException;
import sbnz.integracija.example.facts.CreditCardInfo;
import sbnz.integracija.example.facts.TransactionInfo;
import sbnz.integracija.example.services.BankService;
import sbnz.integracija.example.template.BankTemplate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/bank")
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
	
	@PreAuthorize("hasAnyAuthority('ROLE_BANKER','ROLE_CLIENT')")
	@RequestMapping(value = "/chain", method = RequestMethod.POST, produces = "application/json")
	public String chain(@RequestBody CreditCardInfo k) {


		log.debug("User request received for: " + k);
		
		String res = bankService.chain(k);

		return res;
	}
	
    @PreAuthorize("hasAuthority('ROLE_BANKER')")
	@RequestMapping(value = "/template", method = RequestMethod.POST, produces = "application/json")
	public String template(@RequestBody BankTemplate t) throws IOException, MavenInvocationException {


		log.debug("Template request received for: " + t);
		
		String k1 = bankService.doTemplate(t);

		return k1;
	}
    
    @PreAuthorize("hasAuthority('ROLE_BANKER')")
	@RequestMapping(value = "/basket", method = RequestMethod.GET, produces = "application/json")
	public String basket() throws IOException, MavenInvocationException {

		return bankService.getBasketOfGoods();
	}
    
	@PreAuthorize("hasAnyAuthority('ROLE_BANKER','ROLE_CLIENT')")
	@RequestMapping(value = "/cards", method = RequestMethod.GET, produces = "application/json")
	public List<CreditCardDTO> getCards() throws IOException, MavenInvocationException {

		return bankService.getCreditCards();
	}
	
	
	@PreAuthorize("hasAnyAuthority('ROLE_BANKER','ROLE_CLIENT')")
	@RequestMapping(value = "/cards/{username}", method = RequestMethod.GET, produces = "application/json")
	public List<CreditCardDTO> getCardsForUser(@PathVariable("username") String username) throws IOException, MavenInvocationException {

		return bankService.getCreditCardsForUser(username);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_BANKER','ROLE_CLIENT')")
	@RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<TransactionDTO> getTransactionsForUser(@PathVariable("id") Long id) throws IOException, MavenInvocationException {

		return bankService.getTransactionsForCard(id);
	}
	
	@RequestMapping(value = "/bank", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasAuthority('ROLE_BANKER')")
    public String getProducts() {
        return "SAMO BANKAR VIDI";
    }
	
	@PreAuthorize("hasAnyAuthority('ROLE_BANKER','ROLE_CLIENT')")
	@RequestMapping(value = "/trans", method = RequestMethod.POST, produces = "application/json")
	public String transaction(@RequestBody TransactionInfo ti) {

		log.debug("Transaction request received for: " + ti);
		
		String k1 = bankService.transaction(ti);
		return k1;
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity(noSuchElementException.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	
	
}
