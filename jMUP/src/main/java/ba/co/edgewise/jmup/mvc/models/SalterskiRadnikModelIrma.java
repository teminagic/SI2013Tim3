package ba.co.edgewise.jmup.mvc.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.daldao.daos.*;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;

public class SalterskiRadnikModelIrma {

	public void dodajVozilo(VrstaVozila vrsta, String marka, String tip,
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
		Vozilo vozilo= new Vozilo(0,vrsta,marka,tip,
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
