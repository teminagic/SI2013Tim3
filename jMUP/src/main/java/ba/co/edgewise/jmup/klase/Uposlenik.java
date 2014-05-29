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
		this.id = id;
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
		this.korisnickoIme = korisnickoIme;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public TipUposlenika getTip() {
		return tip;
	}
	public void setTip(TipUposlenika tip) {
		this.tip = tip;
	}
	
	public Object[] toObjectArray() {
		return new Object[]{this.ime, this.prezime, this.korisnickoIme, this.tip, this.status};
	}
}
