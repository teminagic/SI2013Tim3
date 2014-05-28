package ba.co.edgewise.jmup.mvc.models;
import java.util.Date;

import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.daldao.daos.*;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;

public class SalterskiRadnikModelIrma {

	private Vozilo vozilo;
	private VoziloDAO vDAO;
	
	public Vozilo getVozilo() {
		return vozilo;
	}
	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}
	public VoziloDAO getvDAO() {
		return vDAO;
	}
	public void setvDAO(VoziloDAO vDAO) {
		this.vDAO = vDAO;
	}
	
	public void dodajVozilo(Integer id, VrstaVozila vrsta, String marka, String tip,
			String model, String brojSasije, String oblikKaroserije,
			int godinaProizvodnje, int maxTehnickaDozvoljenaMasa,
			int masaVozila, int dopustenaNosivost,Double odnosSnageIMase, Integer brojMjestaZaSjedenje,
			Integer brojMjestaZaStajanje, Integer brojMjestaZaLezanje,
			EkoKarakteristike ekoKarakteristika, Boolean katalizator,
			Date datumPregleda,Integer zapreminaMotora, Integer maxSnaga,
			String vrstaGoriva, String brojMotora, String vrstaMotora) 
	{
		Motor motor =  new Motor(null, zapreminaMotora, maxSnaga,vrstaGoriva, brojMotora, vrstaMotora);
		MotorDAO mDAO = new MotorDAO();
		mDAO.create(motor);
		
		vozilo= new Vozilo(id,vrsta,marka,tip,
			model,brojSasije,oblikKaroserije,
			godinaProizvodnje, maxTehnickaDozvoljenaMasa,
			masaVozila,dopustenaNosivost,motor,
			odnosSnageIMase, brojMjestaZaSjedenje,
			brojMjestaZaStajanje, brojMjestaZaLezanje,
			ekoKarakteristika, katalizator,
			datumPregleda);
		vDAO = new VoziloDAO();
		vDAO.create(vozilo);	
	}
}
