package sbnz.integracija.example.data;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANIES")
public class Company {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "company_type")
	private CompanyType companyType;
	
	@Column(name = "income")
	private double income;
	
	@Column(name = "establishment_date")
	private LocalDate establishmentDate;
	
	@OneToMany(mappedBy="company", fetch = FetchType.EAGER)
	private Set<Blockade> blockades;
	
	@OneToMany(mappedBy="company", fetch = FetchType.EAGER)
	private Set<Contract> contracts;

	public Company() {
	}





	public Company(Long id, String name, CompanyType companyType, double income, LocalDate establishmentDate,
			Set<Blockade> blockades, Set<Contract> contracts) {
		this.id = id;
		this.name = name;
		this.companyType = companyType;
		this.income = income;
		this.establishmentDate = establishmentDate;
		this.blockades = blockades;
		this.contracts = contracts;
	}


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public LocalDate getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(LocalDate establishmentDate) {
		establishmentDate = establishmentDate;
	}

	public Set<Blockade> getBlockades() {
		return blockades;
	}

	public void setBlockades(Set<Blockade> blockades) {
		this.blockades = blockades;
	}



	public Set<Contract> getContracts() {
		return contracts;
	}



	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
