package ba.co.edgewise.jmup.klase;

import java.awt.image.*;

import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.TipUposlenika;

public class Uposlenik {
	
	private int id;
	private String ime;
	private String prezime;
	// evo kako treba raditi sa slikama:
	// http://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
	private BufferedImage slikaKorisnika;
	private String korisnickoIme;
	private String password;
	private Status status; // aktivan = true ili neaktivan = false
	private TipUposlenika tip;
	
	// Konstruktor sa parametrima
	public Uposlenik(int id, String ime, String prezime, BufferedImage slikaKorisnika, String korisnickoIme, String password, Status status, TipUposlenika tip)
	{
		this.setId(id);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setSlikaKorisnika(slikaKorisnika);
		this.setKorisnickoIme(korisnickoIme);
		this.setPassword(password);
		this.setStatus(status);
		this.setTip(tip);
	}
	// Konstruktor bez slike - Irma dodala za probu :)
	public Uposlenik(int id, String ime, String prezime, String korisnickoIme, String password, Status status, TipUposlenika tip)
	{
		this.setId(id);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setKorisnickoIme(korisnickoIme);
		this.setPassword(password);
		this.setStatus(status);
		this.setTip(tip);
	}
	// Konstruktor bez parametara
	public Uposlenik () {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(praznoPolje(String.valueOf(id))) throw new IllegalArgumentException("Polje id je prazno.");
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(praznoPolje(ime)) throw new IllegalArgumentException("Polje ime je prazno.");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if(praznoPolje(prezime)) throw new IllegalArgumentException("Polje prezime je prazno.");
		this.prezime = prezime;
	}
	public BufferedImage getSlikaKorisnika() {
		return slikaKorisnika;
	}
	public void setSlikaKorisnika(BufferedImage slikaKorisnika) {
		this.slikaKorisnika = slikaKorisnika;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		if(praznoPolje(korisnickoIme)) throw new IllegalArgumentException("Polje korisnicko ime je prazno.");
		this.korisnickoIme = korisnickoIme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(praznoPolje(korisnickoIme)) throw new IllegalArgumentException("Polje šifra je prazno.");
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		if(praznoPolje(status.toString())) throw new IllegalArgumentException("Polje status je prazno.");
		this.status = status;
	}
	public TipUposlenika getTip() {
		return tip;
	}
	public void setTip(TipUposlenika tip) {
		if(praznoPolje(tip.toString())) throw new IllegalArgumentException("Polje tip je prazno.");
		this.tip = tip;
	}
	
	public Object[] toObjectArray() {
		return new Object[]{this.ime, this.prezime, this.korisnickoIme, this.tip, this.status};
	}
	
	private boolean praznoPolje(String varijabla){
	    String EMPTY_STRING = "";
	    return (varijabla == null) || (varijabla.trim().equals(EMPTY_STRING));
	  }
}
