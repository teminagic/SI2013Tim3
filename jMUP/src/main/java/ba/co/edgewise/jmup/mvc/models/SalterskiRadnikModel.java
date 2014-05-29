package ba.co.edgewise.jmup.mvc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.RegistracijaDAO;
import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vozilo;

// U klasi ce se nalaziti metode koje su potrebne da opisu posao salterskog radnika
// Sve se radi sa dal dao-om, a obicne klase sluze radi "lakseg i intuituvnijeg prenosa podataka"

public class SalterskiRadnikModel {
	
	public Boolean DodajRegistraciju(Integer idDozvole, String regOznaka, String jmbg, Date odKad, Date doKad)
	{
		OsobaDAO oDAO = new OsobaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		Osoba o = oDAO.getByJMBG(jmbg);
		Vozilo vozilica = vDAO.getByReg(regOznaka);
		Registracija registracija = new Registracija(idDozvole, regOznaka, odKad, doKad, vozilica, o);
		RegistracijaDAO rDAO = new RegistracijaDAO();
		return rDAO.create(registracija);
	}
	public Boolean DodajVozaca(String ime, String prezime, String adresa, String mjesto, String opcina, boolean pravno, String jmbg, String id)
	{
		String prebivaliste = adresa + " " + mjesto + " " + opcina;
		
		Osoba osoba = new Osoba(0, jmbg, prezime, ime, prebivaliste, pravno);
		System.out.println(jmbg + " " + prezime + " " + ime + " " +prebivaliste + " " +pravno);
		OsobaDAO oDAO = new OsobaDAO();
		return oDAO.create(osoba);
	}
	public void dodajVozilo(String registarske, VrstaVozila vrsta, String marka, String tip,
			String model, String brojSasije, String oblikKaroserije,
			int godinaProizvodnje, int maxTehnickaDozvoljenaMasa,
			int masaVozila, int dopustenaNosivost,Double odnosSnageIMase, Integer brojMjestaZaSjedenje,
			Integer brojMjestaZaStajanje, Integer brojMjestaZaLezanje,
			EkoKarakteristike ekoKarakteristika, Boolean katalizator,
			Date datumPregleda, Integer zapreminaMotora, Integer maxSnaga,
			String vrstaGoriva, String brojMotora, String vrstaMotora) 
	{
		//Dodavanje motora
		Motor motor_temp =  new Motor(0, zapreminaMotora, maxSnaga, vrstaGoriva, brojMotora, vrstaMotora);
		MotorDAO mDAO_temp = new MotorDAO();
		mDAO_temp.create(motor_temp);
		//Izvlacenje motora iz baze
		List<Motor> listaMotora = new ArrayList<Motor>();
		MotorDAO mDAO = new MotorDAO();
		listaMotora = mDAO.getAll();
		Motor motor = listaMotora.get(listaMotora.size()-1);
		//Dodavanje vozila
		Vozilo vozilo= new Vozilo(0,registarske,vrsta,marka,tip,
			model,brojSasije,oblikKaroserije,
			godinaProizvodnje, maxTehnickaDozvoljenaMasa,
			masaVozila,dopustenaNosivost,motor,
			odnosSnageIMase, brojMjestaZaSjedenje,
			brojMjestaZaStajanje, brojMjestaZaLezanje,
			ekoKarakteristika, katalizator,
			datumPregleda);
		VoziloDAO vDAO = new VoziloDAO();
		//Kreiraj vozilo
		vDAO.create(vozilo);
	}
}
