package ba.co.edgewise.jmup.mvc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.RegistracijaDAO;
import ba.co.edgewise.jmup.daldao.daos.SaobracajnaDAO;
import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.daldao.daos.VlasnickaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;

// U klasi ce se nalaziti metode koje su potrebne da opisu posao salterskog radnika
// Sve se radi sa dal dao-om, a obicne klase sluze radi "lakseg i intuituvnijeg prenosa podataka"

public class SalterskiRadnikModel {
	private VlasnickaDAO _vlasnickaDAO;
	private SaobracajnaDAO _saobracajnaDAO;
	private VoziloDAO _voziloDAO;
	private OsobaDAO _osobaDAO;
	public SalterskiRadnikModel() {
		_vlasnickaDAO = new VlasnickaDAO();
		_saobracajnaDAO = new SaobracajnaDAO();
		_voziloDAO = new VoziloDAO();
		_osobaDAO = new OsobaDAO();
	}
	public Boolean PromijeniVlasnika(String brojDozvole, String jmbg){
		OsobaDAO oDAO = new OsobaDAO();
		Osoba v = oDAO.getByJMBG(jmbg);
		VlasnickaDAO vlDAO = new VlasnickaDAO();
		Vlasnicka vl = vlDAO.get(brojDozvole);
		vl.setVlasnik(v);
		return vlDAO.update(brojDozvole, vl);
	}
	public Boolean OvjeriRegistraciju(String brojDozvole, Date odKad, Date doKad)
	{
		SaobracajnaDAO sDAO = new SaobracajnaDAO();
		Saobracajna s = sDAO.get(brojDozvole);
		Vozilo v = s.getVozilo();
		//
		RegistracijaDAO rDAO = new RegistracijaDAO();
		return rDAO.updateSaIDVozila(v.getId(), odKad, doKad);
	}
	public Boolean DodajRegistracijuISaobracajnu(String brojDozvole, String regOznaka, String jmbg, Date odKad, Date doKad)
	{
		SaobracajnaDAO sDAO = new SaobracajnaDAO();
		OsobaDAO oDAO = new OsobaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		
		Osoba o = oDAO.getByJMBG(jmbg);
		Vozilo vozilica = vDAO.getByReg(regOznaka);
		Saobracajna s = new Saobracajna(brojDozvole,vozilica,o);
		
		sDAO.create(s);
		Registracija registracija = new Registracija(0, regOznaka, odKad, doKad, vozilica, o);
		RegistracijaDAO rDAO = new RegistracijaDAO();
	
		return rDAO.create(registracija);
	}
	
	public Boolean DodajSaobracajnu(String brojDozvole, String regOznaka, String jmbg)
	{
		SaobracajnaDAO sDAO = new SaobracajnaDAO();
		OsobaDAO oDAO = new OsobaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		
		Osoba o = oDAO.getByJMBG(jmbg);
		Vozilo vozilica = vDAO.getByReg(regOznaka);
		Saobracajna s = new Saobracajna(brojDozvole,vozilica,o);
		
		return sDAO.create(s);
	}
	
	public Boolean DodajRegistracijuIVlasnicku(String brojDozvole, String regOznaka, String jmbg, Date odKad, Date doKad)
	{
		VlasnickaDAO sDAO = new VlasnickaDAO();
		OsobaDAO oDAO = new OsobaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		
		Osoba o = oDAO.getByJMBG(jmbg);
		Vozilo vozilica = vDAO.getByReg(regOznaka);
		Vlasnicka s = new Vlasnicka(brojDozvole,vozilica,o);
		
		sDAO.create(s);
		Registracija registracija = new Registracija(0, regOznaka, odKad, doKad, vozilica, o);
		RegistracijaDAO rDAO = new RegistracijaDAO();
	
		return rDAO.create(registracija);
	}
	public Boolean DodajVlasnicku(String brojDozvole, String regOznaka, String jmbg)
	{
		VlasnickaDAO sDAO = new VlasnickaDAO();
		OsobaDAO oDAO = new OsobaDAO();
		VoziloDAO vDAO = new VoziloDAO();
		
		Osoba o = oDAO.getByJMBG(jmbg);
		Vozilo vozilica = vDAO.getByReg(regOznaka);
		Vlasnicka s = new Vlasnicka(brojDozvole,vozilica,o);
		
		return sDAO.create(s);
	}
	public Boolean DodajVozaca(String ime, String prezime, String adresa, String mjesto, String opcina, boolean pravno, String jmbg_id)
	{
		String prebivaliste = adresa + " " + mjesto + " " + opcina;
		
		Osoba osoba = new Osoba(0, jmbg_id, prezime, ime, prebivaliste, pravno);
		//System.out.println(jmbg + " " + prezime + " " + ime + " " +prebivaliste + " " +pravno);
		OsobaDAO oDAO = new OsobaDAO();
		return oDAO.create(osoba);
	}
	public boolean dodajVozilo(String registarske, VrstaVozila vrsta, String marka, String tip,
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
		return vDAO.create(vozilo);
	}
	public Boolean provjeriBrojSaobracajne(String brojDozvole)
	{
		SaobracajnaDAO s = new SaobracajnaDAO();
		ArrayList<Saobracajna> saobracajne = s.getByPotvrda(brojDozvole);
		if(saobracajne.size()!=0)
			return true;
		return false;
	}
	//PRETRAGA
	public ArrayList<Vozilo> dohvatiSvaVozila() {
		return (ArrayList<Vozilo>) _voziloDAO.getAll();
	}
	public ArrayList<Osoba> dohvatiSveVozace() {
		return (ArrayList<Osoba>) _osobaDAO.getAll();
	}
	public ArrayList<Saobracajna> dohvatiSveSaobracajne() {
		return (ArrayList<Saobracajna>) _saobracajnaDAO.getAll();
	}
	public ArrayList<Vlasnicka> dohvatiSveVlasnicke() {
		return (ArrayList<Vlasnicka>) _vlasnickaDAO.getAll();
	}
	public ArrayList<Vozilo> pretragaVozilo( String parametar, String kriterij ) {
		
		switch (kriterij){
			case "Registarska oznaka":
				ArrayList<Vozilo> v = new ArrayList<Vozilo>();
				Vozilo v1 = _voziloDAO.getByReg(parametar);
				v.add(v1);
				return (v == null) ? null : v;
			case "Godina proizvodnje":
				ArrayList<Vozilo> v2 = _voziloDAO.getByDate(Integer.parseInt(parametar));
				return (v2 == null) ? null : v2;
			case "Vrsta vozila":
				ArrayList<Vozilo> v3 = _voziloDAO.getByType(parametar);
				return (v3 == null) ? null : v3;
			case "Marka vozila":
				ArrayList<Vozilo> v4 = _voziloDAO.getByMark(parametar);
				return (v4 == null) ? null : v4;
			}
		
		return null;
	}
	
	public ArrayList<Osoba> pretragaVozac( String parametar, String kriterij ) {
		
		switch(kriterij){
			case "Ime":
				ArrayList<Osoba> o = _osobaDAO.getByIme(parametar);
				return (o == null) ? null : o;
			case "Prezime":
				ArrayList<Osoba> o1 = _osobaDAO.getByPrezime(parametar);
				return (o1 == null) ? null : o1;
			case "JMBG":
				// iako dobijam samo 1 osobu zbog povratne vrijednosti metode vracam listu (da sve svedem na jednu metodu)
				ArrayList<Osoba> o2 = new ArrayList<>(); 
				o2.add(_osobaDAO.getByJMBG(parametar));
				return (o2 == null) ? null : o2;
			}
		return null;
	}
	
	public ArrayList<Saobracajna> pretragaSaobracajna ( String parametar, String kriterij ) {
		
		switch(kriterij){
		//fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to optimizujem
		//logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
			String [] ip = parametar.split(" ");
			ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
			ArrayList<Saobracajna> s1 = new ArrayList<>();
			for (Osoba osoba : temp) {
				s1.add(_saobracajnaDAO.getByName(osoba.getId()));
			}
			return (s1 == null) ? null : s1;
	
			//vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
			Vozilo vt = _voziloDAO.getByReg(parametar);
			ArrayList<Saobracajna> s2 = new ArrayList<>();
			s2.add(_saobracajnaDAO.getByReg(vt.getId()));
			return (s2 == null) ? null : s2;
		
		case "JMBG vozaÄ�a":
			Osoba o = _osobaDAO.getByJMBG(parametar);
			ArrayList<Saobracajna> s3 = new ArrayList<>();
			s3.add(_saobracajnaDAO.getByName(o.getId()));	
			return (s3 == null) ? null : s3;
			
		case "Broj potvrde":
			ArrayList<Saobracajna> s4 = _saobracajnaDAO.getByPotvrda(parametar);
			return (s4 == null) ? null : s4;
		}
				
		return null;
	}
	
	public ArrayList<Vlasnicka> pretragaVlasnicka ( String parametar, String kriterij ) {
		
		switch(kriterij){
		//fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to optimizujem
		//logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
		String [] ip = parametar.split(" ");
		ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
		ArrayList<Vlasnicka> vl1 = new ArrayList<>();
		for (Osoba osoba : temp) {
			vl1.add(_vlasnickaDAO.getByVlasnik(osoba.getId()));
		}
		return (vl1 == null) ? null : vl1;

		//vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
		Vozilo vt = _voziloDAO.getByReg(parametar);
		ArrayList<Vlasnicka> vl2 = new ArrayList<>();
		vl2.add(_vlasnickaDAO.getByVozilo(vt.getId()));
		return (vl2 == null) ? null : vl2;
		
		case "JMBG vlasnika":
		Osoba o = _osobaDAO.getByJMBG(parametar);
		ArrayList<Vlasnicka> vl3 = new ArrayList<>();
		vl3.add(_vlasnickaDAO.getByVlasnik(o.getId()));	
		return (vl3 == null) ? null : vl3;
		
		case "Broj potvrde":
		ArrayList<Vlasnicka> vl4 = new ArrayList<>();
		vl4.add(_vlasnickaDAO.get(parametar));
		return (vl4 == null) ? null : vl4;
		}
				
		return null;
	}
	//Modifikacija vozila
	public void updateujVozilo(String registarske, VrstaVozila vrsta, String marka, String tip,
			String model, String brojSasije, String oblikKaroserije,
			int godinaProizvodnje, int maxTehnickaDozvoljenaMasa,
			int masaVozila, int dopustenaNosivost,Double odnosSnageIMase, Integer brojMjestaZaSjedenje,
			Integer brojMjestaZaStajanje, Integer brojMjestaZaLezanje,
			EkoKarakteristike ekoKarakteristika, Boolean katalizator,
			Date datumPregleda, Integer zapreminaMotora, Integer maxSnaga,
			String vrstaGoriva, String brojMotora, String vrstaMotora) 
	{
		//Update motora
		Motor motor_temp =  new Motor(0, zapreminaMotora, maxSnaga, vrstaGoriva, brojMotora, vrstaMotora);
		MotorDAO mDAO_temp = new MotorDAO();
		// OTKUD MI ID?
		// 	mDAO_temp.update(motor_temp);
		
		//Izvlacenje motora iz baze
		MotorDAO mDAO = new MotorDAO();
		
		//ID?
		// Motor motor = mDAO.getById();
		
		//update vozila
	/*	Vozilo vozilo= new Vozilo(0,registarske,vrsta,marka,tip,
			model,brojSasije,oblikKaroserije,
			godinaProizvodnje, maxTehnickaDozvoljenaMasa,
			masaVozila,dopustenaNosivost,motor,
			odnosSnageIMase, brojMjestaZaSjedenje,
			brojMjestaZaStajanje, brojMjestaZaLezanje,
			ekoKarakteristika, katalizator,
			datumPregleda);
		VoziloDAO vDAO = new VoziloDAO();*/
		//Kreiraj vozilo
	//	vDAO.update(vozilo);
	}
}
