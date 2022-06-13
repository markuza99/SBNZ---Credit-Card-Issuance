package sbnz.integracija.example.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import sbnz.integracija.example.data.Transaction;

public class TransactionDTO {

	private String payer;
	private String recipient;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;
	private double amount;
	public TransactionDTO(String payer, String recipient, LocalDateTime date, double amount) {
		super();
		this.payer = payer;
		this.recipient = recipient;
		this.date = date;
		this.amount = amount;
	}
	public TransactionDTO(Transaction t) {
		super();
		this.payer = t.getPayer().getCardNumber();
		this.recipient = t.getRecipient().getCardNumber();
		this.date = t.getDate();
		this.amount = t.getAmount();
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
