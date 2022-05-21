package sbnz.integracija.example.models;

import java.util.Date;

public class Ugovor {

	private static final long serialVersionUID = 1L;
	private Date datumPocetka;
	private Date datumIsteka;
	private double plata;
	private Firma firma;
	public Ugovor() {
		super();
	}
	public Ugovor(Date datumPocetka, Date datumIsteka, double plata, Firma firma) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumIsteka = datumIsteka;
		this.plata = plata;
		this.firma = firma;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Date getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	public Firma getFirma() {
		return firma;
	}
	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	
	
}
