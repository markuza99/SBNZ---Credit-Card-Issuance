package sbnz.integracija.example.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Firma {

	private static final long serialVersionUID = 1L;
	private String naziv;
	private OblikOrganizovanja oblikOrganizovanja;
	private double visinaPrihoda;
	private LocalDate datumOsnivanja;
	private int brojZaposlenih;
	private List<Blokada> blokade;
	
	public Firma() {
		super();
	}
	
	public Firma(String naziv, OblikOrganizovanja oblikOrganizovanja, double visinaPrihoda, LocalDate datumOsnivanja,
			int brojZaposlenih, List<Blokada> blokade) {
		super();
		this.naziv = naziv;
		this.oblikOrganizovanja = oblikOrganizovanja;
		this.visinaPrihoda = visinaPrihoda;
		this.datumOsnivanja = datumOsnivanja;
		this.brojZaposlenih = brojZaposlenih;
		this.blokade = blokade;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public int getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setBrojZaposlenih(int brojZaposlenih) {
		this.brojZaposlenih = brojZaposlenih;
	}

	public List<Blokada> getBlokade() {
		return blokade;
	}

	public void setBlokade(List<Blokada> blokade) {
		this.blokade = blokade;
	}
	
	
	
	
	
	
}
