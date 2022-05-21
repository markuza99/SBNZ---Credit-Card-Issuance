package sbnz.integracija.example.models;

import java.util.Date;

public class Transakcija {

	private static final long serialVersionUID = 1L;
	private TipTransakcije tipTransakcije;
	private Date datum;
	private double iznos;
	
	public Transakcija() {
		super();
	}

	public Transakcija(TipTransakcije tipTransakcije, Date datum, double iznos) {
		super();
		this.tipTransakcije = tipTransakcije;
		this.datum = datum;
		this.iznos = iznos;
	}

	public TipTransakcije getTipTransakcije() {
		return tipTransakcije;
	}

	public void setTipTransakcije(TipTransakcije tipTransakcije) {
		this.tipTransakcije = tipTransakcije;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	
	
}
