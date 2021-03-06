package sbnz.integracija.example.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TRANSACTIONS")
public class Transaction {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date")
	private LocalDateTime date;
	
	@Column(name = "amount")
	private double amount;
	
	@ManyToOne
    @JoinColumn(name="payer_id")
    private CreditCard payer;
	
	@ManyToOne
    @JoinColumn(name="recipient_id")
    private CreditCard recipient;

	public Transaction() {
	}

	
	
	public Transaction(LocalDateTime date, double amount, CreditCard payer, CreditCard recipient) {
		super();
		this.date = date;
		this.amount = amount;
		this.payer = payer;
		this.recipient = recipient;
	}



	public Transaction(Long id, LocalDateTime date, double amount, CreditCard payer, CreditCard recipient) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.payer = payer;
		this.recipient = recipient;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public CreditCard getPayer() {
		return payer;
	}

	public void setPayer(CreditCard payer) {
		this.payer = payer;
	}

	public CreditCard getRecipient() {
		return recipient;
	}

	public void setRecipient(CreditCard recipient) {
		this.recipient = recipient;
	}

}
