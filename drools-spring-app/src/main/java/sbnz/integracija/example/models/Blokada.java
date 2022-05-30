package sbnz.integracija.example.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Blokada {
	private static final long serialVersionUID = 1L;
	private LocalDate datumOd;
	private LocalDate datumDo;
	
	
	public Blokada() {
		super();
	}


	public Blokada(LocalDate datumOd, LocalDate datumDo) {
		super();
		this.datumOd = datumOd;
		this.datumDo = datumDo;
	}
	
	public long getDifferenceDays() {
		LocalDate startTime = LocalDate.now().minusYears(3);
		if(datumOd.isAfter(startTime)) {
			startTime = datumOd;
		}
	    return ChronoUnit.DAYS.between(startTime, datumDo);
	}


	public LocalDate getDatumOd() {
		return datumOd;
	}


	public void setDatumOd(LocalDate datumOd) {
		this.datumOd = datumOd;
	}


	public LocalDate getDatumDo() {
		return datumDo;
	}


	public void setDatumDo(LocalDate datumDo) {
		this.datumDo = datumDo;
	}
	
	

}
