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
	public Uposlenik(int id, String ime, String prezime,
			BufferedImage slikaKorisnika, String korisnickoIme,
			String password, Status status, TipUposlenika tip) {
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
	public Uposlenik(int id, String ime, String prezime, String korisnickoIme,
			String password, Status status, TipUposlenika tip) {
		this.setId(id);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setKorisnickoIme(korisnickoIme);
		this.setPassword(password);
		this.setStatus(status);
		this.setTip(tip);
	}

	// Konstruktor bez parametara
	public Uposlenik() {
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
		if (!ime.matches("[A-ZČĆŠŽĐ][a-zA-Z\\s\\-ČčĆćŠšĐđŽž]+"))
			throw new IllegalArgumentException("<html>Ime nije u pravom formatu!<br>"
					+ "Format imena:<br>"
					+ " - Prvo slovo mora biti veliko <br>"
					+ " - Ime može sadržavati slova, prazna mjesta i -</html>");
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (!prezime.matches("[A-ZČĆŠŽĐ][a-zA-Z\\s\\-ČčĆćŠšĐđŽž]+"))
			throw new IllegalArgumentException("<html>Prezime nije u pravom formatu!<br>"
					+ "Format prezimena:<br>"
					+ " - Prvo slovo mora biti veliko <br>"
					+ " - Prezime može sadržavati slova, prazna mjesta i -</html>");
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
		if (!korisnickoIme.matches("[a-zA-Z0-9]+"))
			throw new IllegalArgumentException(
					"<html>Korisničko ime nije u pravom formatu!<br>"
					+ "Format korisničkog imena:<br>"
					+ " - Korisničko ime se može sastojati od slova engleskog alfabeta i brojeva</html>");
		this.korisnickoIme = korisnickoIme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		//if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$"))
		//	throw new IllegalArgumentException("Šifra nije u pravom formatu");
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
		return new Object[] { this.ime, this.prezime, this.korisnickoIme,
				this.tip, this.status };
	}
}
