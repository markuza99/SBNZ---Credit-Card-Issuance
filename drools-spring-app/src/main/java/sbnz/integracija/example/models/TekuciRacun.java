package sbnz.integracija.example.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TekuciRacun {
	private static final long serialVersionUID = 1L;
	private String brojRacuna;
	private Date datumOtvaranja;
	private List<Transakcija> transakcije;
	
	public TekuciRacun() {
		super();
		this.transakcije = new ArrayList<Transakcija>();
	}
	
	

	public TekuciRacun(String brojRacuna, Date datumOtvaranja) {
		super();
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.transakcije = new ArrayList<Transakcija>();
	}



	public TekuciRacun(String brojRacuna, Date datumOtvaranja, List<Transakcija> transakcije) {
		super();
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.transakcije = transakcije;
	}
	
	

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public List<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	
	
	
	
	
	
}
