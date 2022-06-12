package sbnz.integracija.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEMPLATE")
public class BankTemplate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "basket_of_goods")
	private double basketOfGoods;

	
	public BankTemplate() {
		super();
	}

	public BankTemplate(double basketOfGoods) {
		super();
		this.basketOfGoods = basketOfGoods;
	}
	
	

	public BankTemplate(Long id, double basketOfGoods) {
		super();
		this.id = id;
		this.basketOfGoods = basketOfGoods;
	}

	public double getBasketOfGoods() {
		return basketOfGoods;
	}

	public void setBasketOfGoods(double basketOfGoods) {
		this.basketOfGoods = basketOfGoods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
