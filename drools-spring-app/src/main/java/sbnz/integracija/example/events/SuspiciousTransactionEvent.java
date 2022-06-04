package sbnz.integracija.example.events;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.kie.api.definition.type.Role.Type;

@Role(Type.EVENT)
@Timestamp("executionTime")
public class SuspiciousTransactionEvent {
	private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Long clientId;
    private Double totalAmount;
	public SuspiciousTransactionEvent(Date executionTime, Long clientId, Double totalAmount) {
		super();
		this.executionTime = executionTime;
		this.clientId = clientId;
		this.totalAmount = totalAmount;
	}
	public SuspiciousTransactionEvent() {
		super();
	}
	public Date getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    
}


