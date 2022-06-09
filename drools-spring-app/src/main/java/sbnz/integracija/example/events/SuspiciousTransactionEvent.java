package sbnz.integracija.example.events;

import java.util.Date;

import org.kie.api.definition.type.Role;


@Role(Role.Type.EVENT)
public class SuspiciousTransactionEvent {
	private Long payerId;
	private String reason;
	private Date id;
	public SuspiciousTransactionEvent(Long payerId, String reason, Date id) {
		super();
		this.payerId = payerId;
		this.reason = reason;
		this.id = id;
	}
	public SuspiciousTransactionEvent() {
		super();
	}
	public Long getPayerId() {
		return payerId;
	}
	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getId() {
		return id;
	}
	public void setId(Date id) {
		this.id = id;
	}
	
	

}
