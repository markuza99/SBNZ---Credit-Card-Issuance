package sbnz.integracija.example.models;

import java.util.Date;

public class Korisnik {

	private static final long serialVersionUID = 1L;

    private String jmbg;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private boolean klijentBanke;
    private double visinaZaduzenja;
    private double visinaPotrosackeKorpe;
    private int penali;
    private TipZaposlenja tipZaposlenja;
    private Ugovor ugovor;
    private Kartica kartica;
	
    public Korisnik() {
		super();
	}

	public Korisnik(String jmbg, String ime, String prezime, Date datumRodjenja, boolean klijentBanke,
			double visinaZaduzenja, double visinaPotrosackeKorpe, int penali) {
		super();
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.klijentBanke = klijentBanke;
		this.visinaZaduzenja = visinaZaduzenja;
		this.visinaPotrosackeKorpe = visinaPotrosackeKorpe;
		this.penali = penali;
	}
	
	

	public Korisnik(String jmbg, String ime, String prezime, Date datumRodjenja, boolean klijentBanke,
			double visinaZaduzenja, double visinaPotrosackeKorpe, int penali, TipZaposlenja tipZaposlenja,
			Ugovor ugovor, Kartica kartica) {
		super();
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.klijentBanke = klijentBanke;
		this.visinaZaduzenja = visinaZaduzenja;
		this.visinaPotrosackeKorpe = visinaPotrosackeKorpe;
		this.penali = penali;
		this.tipZaposlenja = tipZaposlenja;
		this.ugovor = ugovor;
		this.kartica = kartica;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public boolean isKlijentBanke() {
		return klijentBanke;
	}

	public void setKlijentBanke(boolean klijentBanke) {
		this.klijentBanke = klijentBanke;
	}

	public double getVisinaZaduzenja() {
		return visinaZaduzenja;
	}

	public void setVisinaZaduzenja(double visinaZaduzenja) {
		this.visinaZaduzenja = visinaZaduzenja;
	}

	public double getVisinaPotrosackeKorpe() {
		return visinaPotrosackeKorpe;
	}

	public void setVisinaPotrosackeKorpe(double visinaPotrosackeKorpe) {
		this.visinaPotrosackeKorpe = visinaPotrosackeKorpe;
	}

	public int getPenali() {
		return penali;
	}

	public void setPenali(int penali) {
		this.penali = penali;
	}

	public TipZaposlenja getTipZaposlenja() {
		return tipZaposlenja;
	}

	public void setTipZaposlenja(TipZaposlenja tipZaposlenja) {
		this.tipZaposlenja = tipZaposlenja;
	}

	public Ugovor getUgovor() {
		return ugovor;
	}

	public void setUgovor(Ugovor ugovor) {
		this.ugovor = ugovor;
	}

	public Kartica getKartica() {
		return kartica;
	}

	public void setKartica(Kartica kartica) {
		this.kartica = kartica;
	}

	@Override
	public String toString() {
		return "Korisnik [jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja
				+ ", klijentBanke=" + klijentBanke + ", visinaZaduzenja=" + visinaZaduzenja + ", visinaPotrosackeKorpe="
				+ visinaPotrosackeKorpe + ", penali=" + penali + ", tipZaposlenja=" + tipZaposlenja + "]";
	}
    
	
    
    
}
