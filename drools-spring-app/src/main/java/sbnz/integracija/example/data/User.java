package sbnz.integracija.example.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="USERS")
public class User {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ucid")
	private String ucid;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "username")
    private String username;

	@Column(name = "password")
    @JsonIgnore
    private String password;

	@Column(name = "email")
    private String email;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "indebtedness_amount")
	private double indebtednessAmount;
	
	@Column(name = "basket_of_goods")
	private double basketOfGoods;
	
	@Column(name = "penalties")
	private int penalties;
	
	@Column(name = "bank_client")
	private boolean isBankClient;
	
	@OneToOne
	@JoinColumn(name = "contract_id", referencedColumnName = "id")
	private Contract contract;

	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CreditCard> creditCards;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
            @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
	
	
	public User() {
	}
	
	




	public User(Long id, String ucid, String firstName, String lastName, String username, String password, String email,
			LocalDate birthday, double indebtednessAmount, double basketOfGoods, int penalties, boolean isBankClient,
			Contract contract, Set<CreditCard> creditCards, Set<Role> roles) {
		super();
		this.id = id;
		this.ucid = ucid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.indebtednessAmount = indebtednessAmount;
		this.basketOfGoods = basketOfGoods;
		this.penalties = penalties;
		this.isBankClient = isBankClient;
		this.contract = contract;
		this.creditCards = creditCards;
		this.roles = roles;
	}


	




	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public Set<Role> getRoles() {
		return roles;
	}






	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}






	public void addCreditCard(CreditCard creditCard) {
		creditCard.setUser(this);
		creditCards.add(creditCard);
	}


	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}






	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUcid() {
		return ucid;
	}

	public void setUcid(String ucid) {
		this.ucid = ucid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public double getIndebtednessAmount() {
		return indebtednessAmount;
	}

	public void setIndebtednessAmount(double indebtednessAmount) {
		this.indebtednessAmount = indebtednessAmount;
	}

	public double getBasketOfGoods() {
		return basketOfGoods;
	}

	public void setBasketOfGoods(double basketOfGoods) {
		this.basketOfGoods = basketOfGoods;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public boolean isBankClient() {
		return isBankClient;
	}

	public void setBankClient(boolean isBankClient) {
		this.isBankClient = isBankClient;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	 
	
	
	
	
}
