package sbnz.integracija.example.data;

import java.time.Duration;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BLOCKADES")
public class Blockade {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

	public Blockade() {
	}

	public Blockade(Long id, LocalDate startDate, LocalDate endDate, Company company) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.company = company;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public long getDifferenceDays() {
		LocalDate startTime = LocalDate.now().minusYears(3);
		if(startDate.isAfter(startTime)) {
			startTime = startDate;
		}
		return Duration.between(startTime.atTime(0, 0), endDate.atTime(0, 0)).toDays();
	}
	
	
}
