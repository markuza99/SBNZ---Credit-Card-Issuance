package sbnz.integracija.example.models;

public class KarticaInfo {
	
	private double limit;
	private int brRata;
	private BrendKartice brend;
	
	
	public KarticaInfo(double limit, int brRata, BrendKartice brend) {
		super();
		this.limit = limit;
		this.brRata = brRata;
		this.brend = brend;
	}
	public KarticaInfo() {
		super();
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public int getBrRata() {
		return brRata;
	}
	public void setBrRata(int brRata) {
		this.brRata = brRata;
	}
	public BrendKartice getBrend() {
		return brend;
	}
	public void setBrend(BrendKartice brend) {
		this.brend = brend;
	}
	
	
	
	
	

}
