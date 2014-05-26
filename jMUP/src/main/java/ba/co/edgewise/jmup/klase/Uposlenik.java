package ba.co.edgewise.jmup.klase;

import java.awt.image.*;

import ba.co.edgewise.enums.TipUposlenika;

public class Uposlenik {
	
	private String ime;
	private String prezime;
	// evo kako treba raditi sa slikama:
	// http://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
	private BufferedImage slikaKorisnika;
	private String korisnickoIme;
	private String password;
	private Boolean status; // aktivan = true ili neaktivan = false
	private TipUposlenika tip;
	
	// Konstruktor sa parametrima
	public Uposlenik(String ime, String prezime, BufferedImage slikaKorisnika, String korisnickoIme, String password, Boolean status, TipUposlenika tip)
	{
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setSlikaKorisnika(slikaKorisnika);
		this.setKorisnickoIme(korisnickoIme);
		this.setPassword(password);
		this.setStatus(status);
		this.setTip(tip);
	}
	// Konstruktor bez slike - Irma dodala za probu :)
	public Uposlenik(String ime, String prezime, String korisnickoIme, String password, Boolean status, TipUposlenika tip)
	{
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public TipUposlenika getTip() {
		return tip;
	}
	public void setTip(TipUposlenika tip) {
		this.tip = tip;
	}
}
