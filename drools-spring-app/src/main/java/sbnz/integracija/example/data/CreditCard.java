package sbnz.integracija.example.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	@OneToOne(mappedBy = "creditCard")
    private User user;
	
	@OneToMany(mappedBy="recipient")
	private Set<Transaction> inflows;
    
    @OneToMany(mappedBy="payer")
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
