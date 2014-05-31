package ba.co.edgewise.jmup.mvc.models;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.RegistracijaDAO;
import ba.co.edgewise.jmup.daldao.daos.SaobracajnaDAO;
import ba.co.edgewise.jmup.daldao.daos.VlasnickaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;

public class SalterskiRadnikModel {
	
	//Private fields
	private Osoba vozac;
	private Vozilo vozilo;
	private Saobracajna saobracajna;
	private Vlasnicka vlasnicka;
	private Registracija registracija;

	//Private DAOs
	private VoziloDAO voziloDAO;
	private OsobaDAO osobaDAO;
	private SaobracajnaDAO saobracajnaDAO;
	private VlasnickaDAO vlasnickaDAO;
	private RegistracijaDAO registracijaDAO;
	
	//Constructors
	public SalterskiRadnikModel() {
		super();
		vozac = new Osoba();
		vozilo = new Vozilo();
		saobracajna = new Saobracajna();
		vlasnicka = new Vlasnicka();
		registracija = new Registracija();
		
		voziloDAO = new VoziloDAO();
		osobaDAO = new OsobaDAO();
		saobracajnaDAO = new SaobracajnaDAO();
		vlasnickaDAO = new VlasnickaDAO();
		registracijaDAO = new RegistracijaDAO();
	}
	
	//Dodavanje
	public Boolean dodajVozaca()
	{
		Boolean success = osobaDAO.create(vozac);
		vozac = this.osobaDAO.getByJMBG(vozac.getJmbg_Id());
		return success;
	}
	
	public Boolean dodajVozilo()
	{
		Boolean success = voziloDAO.create(vozilo);
		vozilo = voziloDAO.getByReg(vozilo.getRegistarskaOznaka());
		return success;
	}
	
	public Boolean dodajVlasnicku()
	{
		return vlasnickaDAO.create(vlasnicka);
	}
	
	public Boolean dodajRegistraciju()
	{
		return registracijaDAO.create(registracija);
	}
	
	
	//getters and setters

	public Osoba getVozac() {
		return vozac;
	}

	public void setVozac(Osoba vozac) {
		this.vozac = vozac;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public Saobracajna getSaobracajna() {
		return saobracajna;
	}

	public void setSaobracajna(Saobracajna saobracajna) {
		this.saobracajna = saobracajna;
	}
	
	public Vlasnicka getVlasnicka() {
		return vlasnicka;
	}

	public void setVlasnicka(Vlasnicka vlasnicka) {
		this.vlasnicka = vlasnicka;
	}

	public Registracija getRegistracija() {
		return registracija;
	}

	public void setRegistracija(Registracija registracija) {
		this.registracija = registracija;
	}
}