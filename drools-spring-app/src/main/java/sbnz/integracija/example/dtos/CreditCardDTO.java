package sbnz.integracija.example.dtos;

import java.time.LocalDate;

import sbnz.integracija.example.data.CreditCard;

public class CreditCardDTO {
	
	private Long id;
	private String cardNumber;
	private String cardBrand;
	private String cardOwner;
	private boolean isBlocked;
	private boolean isWarned;
	private double limit;
	private double deposit;
	private LocalDate expirationDate;
	
	public CreditCardDTO(CreditCard cc) {
		super();
		this.id = cc.getId();
		this.cardNumber = cc.getCardNumber();
		this.cardBrand = cc.getCardBrand().toString();
		this.cardOwner = cc.getUser().getUsername() + " "+ cc.getUser().getFirstName() + " " + cc.getUser().getLastName();
		this.isBlocked = cc.isBlocked();
		this.limit = cc.getLimit();
		this.deposit = cc.getDeposit();
		this.expirationDate = cc.getExpirationDate();
		this.isWarned = cc.isWarned();
	}
	
	
	
	



	public CreditCardDTO(Long id, String cardNumber, String cardBrand, String cardOwner, boolean isBlocked,
			boolean isWarned, double limit, double deposit, LocalDate expirationDate) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardBrand = cardBrand;
		this.cardOwner = cardOwner;
		this.isBlocked = isBlocked;
		this.isWarned = isWarned;
		this.limit = limit;
		this.deposit = deposit;
		this.expirationDate = expirationDate;
	}







	public CreditCardDTO() {
		super();
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

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}



	public boolean isBlocked() {
		return isBlocked;
	}



	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
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



	public LocalDate getExpirationDate() {
		return expirationDate;
	}



	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}







	public boolean isWarned() {
		return isWarned;
	}







	public void setWarned(boolean isWarned) {
		this.isWarned = isWarned;
	}
	
	
	
	

}
