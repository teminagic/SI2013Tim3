package ba.co.edgewise.jmup.klase;

import java.util.Date;

public class Registracija {
	int id;

	Date datumRegistrovanja;
	Date datumIsteka;
	Integer vozilo;
	Integer osoba;
	public Registracija() {
		super();
	}
	
	public Registracija(int id,
			Date datumRegistrovanja, Date datumIsteka, Integer vozilo,
			Integer osoba) {
		super();
		this.id = id;
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
	public Integer getVozilo() {
		return vozilo;
	}
	public void setVozilo(Integer vozilo) {
		this.vozilo = vozilo;
	}
	public Integer getOsoba() {
		return osoba;
	}
	public void setOsoba(Integer osoba) {
		this.osoba = osoba;
	}
	
	
}
