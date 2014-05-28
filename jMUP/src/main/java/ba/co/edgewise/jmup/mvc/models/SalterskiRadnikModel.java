package ba.co.edgewise.jmup.mvc.models;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Uposlenik;

// U klasi ce se nalaziti metode koje su potrebne da opisu posao salterskog radnika
// Sve se radi sa dal dao-om, a obicne klase sluze radi "lakseg i intuituvnijeg prenosa podataka"

public class SalterskiRadnikModel {
	
	private Osoba osoba;
	private OsobaDAO oDAO;
	
	public void DodajVozaca(String ime, String prezime, String adresa, String mjesto, String opcina, boolean pravno, String jmbg, String id)
	{
		String prebivaliste = adresa + " " + mjesto + " " + opcina;
		
		osoba = new Osoba(0, jmbg, prezime, ime, prebivaliste, pravno);
		System.out.println(jmbg + " " + prezime + " " + ime + " " +prebivaliste + " " +pravno);
		oDAO = new OsobaDAO();
		oDAO.create(osoba);
	}
}
