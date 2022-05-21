package sbnz.integracija.example.models;

import java.util.Date;

public class Kartica {
	private static final long serialVersionUID = 1L;
	private BrendKartice brendKartice;
	private int brojRata;
	private Date periodVazenja;
	private double limit;
	private double depozit;
	private TekuciRacun tekuciRacun;
	
	public Kartica() {
		super();
	}
	
	public Kartica(BrendKartice brendKartice, int brojRata, Date periodVazenja, double limit, double depozit,
			TekuciRacun tekuciRacun) {
		super();
		this.brendKartice = brendKartice;
		this.brojRata = brojRata;
		this.periodVazenja = periodVazenja;
		this.limit = limit;
		this.depozit = depozit;
		this.tekuciRacun = tekuciRacun;
	}

	public BrendKartice getBrendKartice() {
		return brendKartice;
	}

	public void setBrendKartice(BrendKartice brendKartice) {
		this.brendKartice = brendKartice;
	}

	public int getBrojRata() {
		return brojRata;
	}

	public void setBrojRata(int brojRata) {
		this.brojRata = brojRata;
	}

	public Date getPeriodVazenja() {
		return periodVazenja;
	}

	public void setPeriodVazenja(Date periodVazenja) {
		this.periodVazenja = periodVazenja;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getDepozit() {
		return depozit;
	}

	public void setDepozit(double depozit) {
		this.depozit = depozit;
	}

	public TekuciRacun getTekuciRacun() {
		return tekuciRacun;
	}

	public void setTekuciRacun(TekuciRacun tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}
	
	
	
	 

}
