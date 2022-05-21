package sbnz.integracija.example.models;

import java.util.Date;

public class Blokada {
	private static final long serialVersionUID = 1L;
	private Date datumOd;
	private Date datumDo;
	
	
	public Blokada() {
		super();
	}


	public Blokada(Date datumOd, Date datumDo) {
		super();
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}


	public Date getDatumOd() {
		return datumOd;
	}


	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}


	public Date getDatumDo() {
		return datumDo;
	}


	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}
	
	

}
