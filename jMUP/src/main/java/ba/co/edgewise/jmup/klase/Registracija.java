package ba.co.edgewise.jmup.klase;

import java.util.Date;

public class Registracija {
	int id;
	String registarskaOznaka;
	Date datumRegistrovanja;
	Date datumIsteka;
	Vozilo vozilo;
	Osoba osoba;
	public Registracija() {
		super();
	}
	
	public Registracija(int id, String registarskaOznaka,
			Date datumRegistrovanja, Date datumIsteka, Vozilo vozilo,
			Osoba osoba) {
		super();
		this.id = id;
		this.registarskaOznaka = registarskaOznaka;
		this.datumRegistrovanja = datumRegistrovanja;
		this.datumIsteka = datumIsteka;
		this.vozilo = vozilo;
		this.osoba = osoba;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistarskaOznaka() {
		return registarskaOznaka;
	}
	public void setRegistarskaOznaka(String registarskaOznaka) {
		this.registarskaOznaka = registarskaOznaka;
	}
	public Date getDatumRegistrovanja() {
		return datumRegistrovanja;
	}
	public void setDatumRegistrovanja(Date datumRegistrovanja) {
		this.datumRegistrovanja = datumRegistrovanja;
	}
	public Date getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	public Vozilo getVozilo() {
		return vozilo;
	}
	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}
	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	
}
