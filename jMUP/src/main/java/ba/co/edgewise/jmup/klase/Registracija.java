package ba.co.edgewise.jmup.klase;

// mislim da samo prvi import treba,
// ali evo i ostali ukoliko bude trebalo format usaglasiti
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Registracija {
	String regOznaka;
	Date odKada;
	Date doKada; // "do" je rezervisana rijec
	
	public Registracija(String regOznaka, Date odKada, Date doKada){
		this.regOznaka = regOznaka;
		this.odKada = odKada;
		this.doKada = doKada;
	}

	public String getRegOznaka() {
		return regOznaka;
	}

	public void setRegOznaka(String regOznaka) {
		this.regOznaka = regOznaka;
	}

	public Date getOdKada() {
		return odKada;
	}

	public void setOdKada(Date odKada) {
		this.odKada = odKada;
	}

	public Date getDoKada() {
		return doKada;
	}

	public void setDoKada(Date doKada) {
		this.doKada = doKada;
	}
}
