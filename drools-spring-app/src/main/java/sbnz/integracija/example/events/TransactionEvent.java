package sbnz.integracija.example.events;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import sbnz.integracija.example.facts.TransactionInfo;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
public class TransactionEvent {
	
	private Date executionTime;
    private Long payerId;
    private Long recipientId;
    private Double totalAmount;
	public TransactionEvent() {
		super();
	}
	
	public TransactionEvent(TransactionInfo ti) {
		this.executionTime = new Date();
		this.payerId = ti.getPayerId();
		this.recipientId = ti.getRecipientId();
		this.totalAmount = ti.getTotalAmount();
	}
	public TransactionEvent(Long payerId, Long recipientId, Double totalAmount) {
		this.executionTime = new Date();
		this.payerId = payerId;
		this.recipientId = recipientId;
		this.totalAmount = totalAmount;
	}
	public TransactionEvent(Date executionTime, Long payerId, Long recipientId, Double totalAmount) {
		super();
		this.executionTime = executionTime;
		this.payerId = payerId;
		this.recipientId = recipientId;
		this.totalAmount = totalAmount;
	}
	public Date getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
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
