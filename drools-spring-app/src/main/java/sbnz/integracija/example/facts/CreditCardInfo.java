package sbnz.integracija.example.facts;

import sbnz.integracija.example.data.CardBrand;

public class CreditCardInfo {

	private String userId;
	private double limit;
	private int installments;
	private CardBrand brand;
	private CardStatus cardStatus;
    private DepositStatus typeDeposit;
    private DepositStatus ageDeposit;
    private DepositStatus clientDeposit;
    private double potentialDeposit = 1;
	public CreditCardInfo(String userId, double limit, int installments, CardBrand brand, CardStatus cardStatus,
			DepositStatus typeDeposit, DepositStatus ageDeposit, DepositStatus clientDeposit, double potentialDeposit) {
		super();
		this.userId = userId;
		this.limit = limit;
		this.installments = installments;
		this.brand = brand;
		this.cardStatus = cardStatus;
		this.typeDeposit = typeDeposit;
		this.ageDeposit = ageDeposit;
		this.clientDeposit = clientDeposit;
		this.potentialDeposit = potentialDeposit;
	}
	public CreditCardInfo() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public int getInstallments() {
		return installments;
	}
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	public CardBrand getBrand() {
		return brand;
	}
	public void setBrand(CardBrand brand) {
		this.brand = brand;
	}
	public CardStatus getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(CardStatus cardStatus) {
		this.cardStatus = cardStatus;
	}
	public DepositStatus getTypeDeposit() {
		return typeDeposit;
	}
	public void setTypeDeposit(DepositStatus typeDeposit) {
		this.typeDeposit = typeDeposit;
	}
	public DepositStatus getAgeDeposit() {
		return ageDeposit;
	}
	public void setAgeDeposit(DepositStatus ageDeposit) {
		this.ageDeposit = ageDeposit;
	}
	public DepositStatus getClientDeposit() {
		return clientDeposit;
	}
	public void setClientDeposit(DepositStatus clientDeposit) {
		this.clientDeposit = clientDeposit;
	}
	public double getPotentialDeposit() {
		return potentialDeposit;
	}
	public void setPotentialDeposit(double potentialDeposit) {
		this.potentialDeposit = potentialDeposit;
	}
	
	public void increasePotentialDeposit(double val) {
		this.potentialDeposit += val;
	}
    
    
}
