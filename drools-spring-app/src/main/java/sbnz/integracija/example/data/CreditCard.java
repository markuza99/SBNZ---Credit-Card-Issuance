package sbnz.integracija.example.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sbnz.integracija.example.facts.CreditCardInfo;

@Entity
@Table(name="CREDITCARDS")
public class CreditCard {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "card_number")
	private String cardNumber;
	
    @Enumerated(EnumType.STRING)
	@Column(name = "card_brand")
	private CardBrand cardBrand;
	
	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	@Column(name = "card_limit")
	private double limit;

	@Column(name = "deposit")
	private double deposit;
	
	@Column(name = "installments")
	private int installments;
	
	@Column(name = "is_blocked")
	private boolean isBlocked;
	
	@Column(name = "is_warned")
	private boolean isWarned;
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	
	@OneToMany(mappedBy="recipient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Transaction> inflows;
    
    @OneToMany(mappedBy="payer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Transaction> outflows;

	public CreditCard() {
	}
	


	public CreditCard(CreditCardInfo creditCardInfo) {
		this.cardBrand = creditCardInfo.getBrand();
		this.cardNumber = generateCardNumber();
		this.expirationDate = LocalDate.now().plusYears(3);
		this.limit = creditCardInfo.getLimit();
		this.deposit = creditCardInfo.getLimit() * creditCardInfo.getPotentialDeposit();
		this.installments = creditCardInfo.getInstallments();
	}






	public CreditCard(Long id, String cardNumber, CardBrand cardBrand, LocalDate expirationDate, double limit,
			double deposit, int installments, User user, Set<Transaction> inflows, Set<Transaction> outflows) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardBrand = cardBrand;
		this.expirationDate = expirationDate;
		this.limit = limit;
		this.deposit = deposit;
		this.installments = installments;
		this.user = user;
		this.inflows = inflows;
		this.outflows = outflows;
	}

	


	public CreditCard(Long id, String cardNumber, CardBrand cardBrand, LocalDate expirationDate, double limit,
			double deposit, int installments, boolean isBlocked, User user, Set<Transaction> inflows,
			Set<Transaction> outflows) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardBrand = cardBrand;
		this.expirationDate = expirationDate;
		this.limit = limit;
		this.deposit = deposit;
		this.installments = installments;
		this.isBlocked = isBlocked;
		this.user = user;
		this.inflows = inflows;
		this.outflows = outflows;
	}

	
	



	public CreditCard(Long id, String cardNumber, CardBrand cardBrand, LocalDate expirationDate, double limit,
			double deposit, int installments, boolean isBlocked, boolean isWarned, User user, Set<Transaction> inflows,
			Set<Transaction> outflows) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardBrand = cardBrand;
		this.expirationDate = expirationDate;
		this.limit = limit;
		this.deposit = deposit;
		this.installments = installments;
		this.isBlocked = isBlocked;
		this.isWarned = isWarned;
		this.user = user;
		this.inflows = inflows;
		this.outflows = outflows;
	}



	public void addInflow(Transaction transaction) {
		inflows.add(transaction);
	}
	
	public void addOutflows(Transaction transaction) {
		outflows.add(transaction);
	}
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Transaction> getInflows() {
		return inflows;
	}

	public void setInflows(Set<Transaction> inflows) {
		this.inflows = inflows;
	}

	public Set<Transaction> getOutflows() {
		return outflows;
	}

	public void setOutflows(Set<Transaction> outflows) {
		this.outflows = outflows;
	}



	public CardBrand getCardBrand() {
		return cardBrand;
	}



	public void setCardBrand(CardBrand cardBrand) {
		this.cardBrand = cardBrand;
	}



	public int getInstallments() {
		return installments;
	}

	


	public boolean isBlocked() {
		return isBlocked;
	}






	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}


	




	public boolean isWarned() {
		return isWarned;
	}



	public void setWarned(boolean isWarned) {
		this.isWarned = isWarned;
	}



	public void setInstallments(int installments) {
		this.installments = installments;
	}
	
	private String generateCardNumber()
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "0123456789";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(12);
  
        for (int i = 0; i < 12; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
  
	
    
	
    

}
