package sbnz.integracija.example.models;

import java.time.LocalDate;
import java.util.Date;

public class Korisnik {

	private static final long serialVersionUID = 1L;

    private String jmbg;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private boolean klijentBanke;
    private double visinaZaduzenja;
    private double visinaPotrosackeKorpe;
    private int penali;
    private Ugovor ugovor;
    private Kartica kartica;
    private KarticaInfo karticaInfo;
    
    private StatusKartice statusKartice;
    private DepozitStatus depozitZaTip;
    private DepozitStatus depozitZaStarost;
    private DepozitStatus depozitZaKlijenta;
    private double potencijalniDepozit = 1;
	
    public Korisnik() {
		super();
	}
    

	public Korisnik(String jmbg, String ime, String prezime, LocalDate datumRodjenja, boolean klijentBanke,
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
	
	



	public Korisnik(String jmbg, String ime, String prezime, LocalDate datumRodjenja, boolean klijentBanke,
			double visinaZaduzenja, double visinaPotrosackeKorpe, int penali, Ugovor ugovor, Kartica kartica,
			KarticaInfo karticaInfo, StatusKartice statusKartice, DepozitStatus depozitZaTip,
			DepozitStatus depozitZaStarost, DepozitStatus depozitZaKlijenta, double potencijalniDepozit) {
		super();
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.klijentBanke = klijentBanke;
		this.visinaZaduzenja = visinaZaduzenja;
		this.visinaPotrosackeKorpe = visinaPotrosackeKorpe;
		this.penali = penali;
		this.ugovor = ugovor;
		this.kartica = kartica;
		this.karticaInfo = karticaInfo;
		this.statusKartice = statusKartice;
		this.depozitZaTip = depozitZaTip;
		this.depozitZaStarost = depozitZaStarost;
		this.depozitZaKlijenta = depozitZaKlijenta;
		this.potencijalniDepozit = potencijalniDepozit;
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

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
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

	public KarticaInfo getKarticaInfo() {
		return karticaInfo;
	}

	public void setKarticaInfo(KarticaInfo karticaInfo) {
		this.karticaInfo = karticaInfo;
	}

	public StatusKartice getStatusKartice() {
		return statusKartice;
	}

	public void setStatusKartice(StatusKartice statusKartice) {
		this.statusKartice = statusKartice;
	}


	

	public DepozitStatus getDepozitZaTip() {
		return depozitZaTip;
	}


	public void setDepozitZaTip(DepozitStatus depozitZaTip) {
		this.depozitZaTip = depozitZaTip;
	}


	public DepozitStatus getDepozitZaStarost() {
		return depozitZaStarost;
	}


	public void setDepozitZaStarost(DepozitStatus depozitZaStarost) {
		this.depozitZaStarost = depozitZaStarost;
	}


	public DepozitStatus getDepozitZaKlijenta() {
		return depozitZaKlijenta;
	}


	public void setDepozitZaKlijenta(DepozitStatus depozitZaKlijenta) {
		this.depozitZaKlijenta = depozitZaKlijenta;
	}


	public double getPotencijalniDepozit() {
		return potencijalniDepozit;
	}


	public void setPotencijalniDepozit(double potencijalniDepozit) {
		this.potencijalniDepozit = potencijalniDepozit;
	}

	public void increasePotencijalniDepozit(double val) {
		this.potencijalniDepozit += val;
	}
	
	
	
	


	
    
    
}
