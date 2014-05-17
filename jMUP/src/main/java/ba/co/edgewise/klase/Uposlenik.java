package ba.co.edgewise.jmup.klase;

import java.awt.image.*;

public class Uposlenik {
	
	private String ime;
	private String prezime;
	// evo kako treba raditi sa slikama:
	// http://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
	private BufferedImage slikaKorisnika;
	private String korisnickoIme;
	private String password;
	private Boolean status; // aktivan = true ili neaktivan = false
	
	// Konstruktor sa parametrima
	public Uposlenik(String ime, String prezime, BufferedImage slikaKorisnika, String korisnickoIme, String password, Boolean status)
	{
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setSlikaKorisnika(slikaKorisnika);
		this.setKorisnickoIme(korisnickoIme);
		this.setPassword(password);
		this.setStatus(status);
	}
	// Konstruktor bez parametara
	public Uposlenik () {
	}
	private String getIme() {
		return ime;
	}
	private void setIme(String ime) {
		this.ime = ime;
	}
	private String getPrezime() {
		return prezime;
	}
	private void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	private BufferedImage getSlikaKorisnika() {
		return slikaKorisnika;
	}
	private void setSlikaKorisnika(BufferedImage slikaKorisnika) {
		this.slikaKorisnika = slikaKorisnika;
	}
	private String getKorisnickoIme() {
		return korisnickoIme;
	}
	private void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	private String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	private Boolean getStatus() {
		return status;
	}
	private void setStatus(Boolean status) {
		this.status = status;
	}
	
}
