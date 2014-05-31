package ba.co.edgewise.jmup.klase;

import java.util.Date;

import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.VrstaVozila;


public class Vozilo {

	// dodati privatne atribute za vozilo
	private Integer id;
	private VrstaVozila vrsta;
	private String marka; 
	private String tip;
	private String model;
	private String brojSasije;
	private String oblikKaroserije;
	private int godinaProizvodnje;
	private int maxTehnickaDozvoljenaMasa;
	private int MasaVozila;
	private int DopustenaNosivost;
	private Double odnosSnageIMase;
	private Integer brojMjestaZaSjedenje;
	private Integer brojMjestaZaStajanje;
	private Integer brojMjestaZaLezanje;
	private EkoKarakteristike ekoKarakteristika;
	private Boolean katalizator;
	private Date datumPregleda;
	private String registarskaOznaka;
	private Status statusVozila;
	
	private BojaVozila bojaVozila = new BojaVozila();
	private Motor motor = new Motor();
	
	public Vozilo(Integer id, VrstaVozila vrsta, String marka, String tip,
			String model, String brojSasije, String oblikKaroserije,
			int godinaProizvodnje, int maxTehnickaDozvoljenaMasa,
			int masaVozila, int dopustenaNosivost, Double odnosSnageIMase,
			Integer brojMjestaZaSjedenje, Integer brojMjestaZaStajanje,
			Integer brojMjestaZaLezanje, EkoKarakteristike ekoKarakteristika,
			Boolean katalizator, Date datumPregleda, String registarskaOznaka,
			Status statusVozila, BojaVozila bojaVozila, Motor motor) {
		super();
		this.id = id;
		this.vrsta = vrsta;
		this.marka = marka;
		this.tip = tip;
		this.model = model;
		this.brojSasije = brojSasije;
		this.oblikKaroserije = oblikKaroserije;
		this.godinaProizvodnje = godinaProizvodnje;
		this.maxTehnickaDozvoljenaMasa = maxTehnickaDozvoljenaMasa;
		MasaVozila = masaVozila;
		DopustenaNosivost = dopustenaNosivost;
		this.odnosSnageIMase = odnosSnageIMase;
		this.brojMjestaZaSjedenje = brojMjestaZaSjedenje;
		this.brojMjestaZaStajanje = brojMjestaZaStajanje;
		this.brojMjestaZaLezanje = brojMjestaZaLezanje;
		this.ekoKarakteristika = ekoKarakteristika;
		this.katalizator = katalizator;
		this.datumPregleda = datumPregleda;
		this.registarskaOznaka = registarskaOznaka;
		this.statusVozila = statusVozila;
		this.bojaVozila = bojaVozila;
		this.motor = motor;
	}



	public Vozilo() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public VrstaVozila getVrsta() {
		return vrsta;
	}



	public void setVrsta(VrstaVozila vrsta) {
		this.vrsta = vrsta;
	}



	public String getMarka() {
		return marka;
	}



	public void setMarka(String marka) {
		this.marka = marka;
	}



	public String getTip() {
		return tip;
	}



	public void setTip(String tip) {
		this.tip = tip;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getBrojSasije() {
		return brojSasije;
	}



	public void setBrojSasije(String brojSasije) {
		this.brojSasije = brojSasije;
	}



	public String getOblikKaroserije() {
		return oblikKaroserije;
	}



	public void setOblikKaroserije(String oblikKaroserije) {
		this.oblikKaroserije = oblikKaroserije;
	}



	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}



	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}



	public int getMaxTehnickaDozvoljenaMasa() {
		return maxTehnickaDozvoljenaMasa;
	}



	public void setMaxTehnickaDozvoljenaMasa(int maxTehnickaDozvoljenaMasa) {
		this.maxTehnickaDozvoljenaMasa = maxTehnickaDozvoljenaMasa;
	}



	public int getMasaVozila() {
		return MasaVozila;
	}



	public void setMasaVozila(int masaVozila) {
		MasaVozila = masaVozila;
	}



	public int getDopustenaNosivost() {
		return DopustenaNosivost;
	}



	public void setDopustenaNosivost(int dopustenaNosivost) {
		DopustenaNosivost = dopustenaNosivost;
	}



	public Double getOdnosSnageIMase() {
		return odnosSnageIMase;
	}



	public void setOdnosSnageIMase(Double odnosSnageIMase) {
		this.odnosSnageIMase = odnosSnageIMase;
	}



	public Integer getBrojMjestaZaSjedenje() {
		return brojMjestaZaSjedenje;
	}



	public void setBrojMjestaZaSjedenje(Integer brojMjestaZaSjedenje) {
		this.brojMjestaZaSjedenje = brojMjestaZaSjedenje;
	}



	public Integer getBrojMjestaZaStajanje() {
		return brojMjestaZaStajanje;
	}



	public void setBrojMjestaZaStajanje(Integer brojMjestaZaStajanje) {
		this.brojMjestaZaStajanje = brojMjestaZaStajanje;
	}



	public Integer getBrojMjestaZaLezanje() {
		return brojMjestaZaLezanje;
	}



	public void setBrojMjestaZaLezanje(Integer brojMjestaZaLezanje) {
		this.brojMjestaZaLezanje = brojMjestaZaLezanje;
	}



	public EkoKarakteristike getEkoKarakteristika() {
		return ekoKarakteristika;
	}



	public void setEkoKarakteristika(EkoKarakteristike ekoKarakteristika) {
		this.ekoKarakteristika = ekoKarakteristika;
	}



	public Boolean getKatalizator() {
		return katalizator;
	}



	public void setKatalizator(Boolean katalizator) {
		this.katalizator = katalizator;
	}



	public Date getDatumPregleda() {
		return datumPregleda;
	}



	public void setDatumPregleda(Date datumPregleda) {
		this.datumPregleda = datumPregleda;
	}



	public String getRegistarskaOznaka() {
		return registarskaOznaka;
	}



	public void setRegistarskaOznaka(String registarskaOznaka) {
		this.registarskaOznaka = registarskaOznaka;
	}



	public Status getStatusVozila() {
		return statusVozila;
	}



	public void setStatusVozila(Status statusVozila) {
		this.statusVozila = statusVozila;
	}



	public BojaVozila getBojaVozila() {
		return bojaVozila;
	}



	public void setBojaVozila(BojaVozila bojaVozila) {
		this.bojaVozila = bojaVozila;
	}



	public Motor getMotor() {
		return motor;
	}



	public void setMotor(Motor motor) {
		this.motor = motor;
	}



	public Object[] toObjectArray() {
		return new Object[]{				
			this.registarskaOznaka,
			this.godinaProizvodnje,
			this.vrsta,
			this.marka,
			this.statusVozila
		};
	}
}

	