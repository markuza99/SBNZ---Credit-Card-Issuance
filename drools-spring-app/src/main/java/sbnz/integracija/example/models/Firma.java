package sbnz.integracija.example.models;

import java.util.Date;

public class Firma {

	private static final long serialVersionUID = 1L;
	private String naziv;
	private OblikOrganizovanja oblikOrganizovanja;
	private double visinaPrihoda;
	private Date datumOsnivanja;
	private int brojZaposlenih;
	private Blokada blokada;
	
	public Firma() {
		super();
	}

	public Firma(String naziv, OblikOrganizovanja oblikOrganizovanja, double visinaPrihoda, Date datumOsnivanja,
			int brojZaposlenih, Blokada blokada) {
		super();
		this.naziv = naziv;
		this.oblikOrganizovanja = oblikOrganizovanja;
		this.visinaPrihoda = visinaPrihoda;
		this.datumOsnivanja = datumOsnivanja;
		this.brojZaposlenih = brojZaposlenih;
		this.blokada = blokada;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public OblikOrganizovanja getOblikOrganizovanja() {
		return oblikOrganizovanja;
	}

	public void setOblikOrganizovanja(OblikOrganizovanja oblikOrganizovanja) {
		this.oblikOrganizovanja = oblikOrganizovanja;
	}

	public double getVisinaPrihoda() {
		return visinaPrihoda;
	}

	public void setVisinaPrihoda(double visinaPrihoda) {
		this.visinaPrihoda = visinaPrihoda;
	}

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public int getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setBrojZaposlenih(int brojZaposlenih) {
		this.brojZaposlenih = brojZaposlenih;
	}

	public Blokada getBlokada() {
		return blokada;
	}

	public void setBlokada(Blokada blokada) {
		this.blokada = blokada;
	}
	
	
	
	
}
