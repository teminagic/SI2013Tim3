package ba.co.edgewise.jmup.klase;

import java.util.Date;

public class Log {

	Integer id;
	String username;
	Date datum;
	String akcija;
	String opis;
	
	/**
	 * Konstruktori
	 */
	public Log() {
	}

	public Log(Integer id, String username, Date datum, String akcija,
			String opis) {
		super();
		this.id = id;
		this.username = username;
		this.datum = datum;
		this.akcija = akcija;
		this.opis = opis;
	}

	/**
	 * Get-eri i Set-eri
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Object[] toObjectArray() {
		return new Object[] { this.username, this.datum, this.akcija,
				this.opis};
	}

}
