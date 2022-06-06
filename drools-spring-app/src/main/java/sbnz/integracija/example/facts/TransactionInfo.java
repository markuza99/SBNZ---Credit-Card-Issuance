package sbnz.integracija.example.facts;

public class TransactionInfo {

	private Long payerId;
    private Long recipientId;
    private Double totalAmount;
	public TransactionInfo(Long payerId, Long recipientId, Double totalAmount) {
		super();
		this.payerId = payerId;
		this.recipientId = recipientId;
		this.totalAmount = totalAmount;
	}
	public TransactionInfo() {
		super();
	}
	public Long getPayerId() {
		return payerId;
	}
	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}
	public Long getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    
}
