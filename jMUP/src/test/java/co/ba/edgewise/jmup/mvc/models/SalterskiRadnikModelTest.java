package co.ba.edgewise.jmup.mvc.models;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.BojeVozilaDAO;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.VrstaGoriva;
import ba.co.edgewise.jmup.enums.VrstaMotora;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.SalterskiRadnikModel;

public class SalterskiRadnikModelTest {

	private SalterskiRadnikModel srm;
	@Before
	public void setUp(){
		srm=new SalterskiRadnikModel();
	}
	@Test
	public void testDodavanjaVozaca() {
		Osoba vozac = new Osoba(1324, "1345991198257", "Prezimenko", "Imenko", "Prebivaliste", true); 
		srm.setVozac(vozac);
		assertTrue(srm.dodajVozaca());
	}
	@Test
	public void testDodavanjeVlasnicke(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(65);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352);
		Vlasnicka vl = new Vlasnicka("20", vozilo, osoba);
		
		srm.setVlasnicka(vl);
		srm.dodajVlasnicku();
	}
	@Test
	public void testDodavanjeRegistracije(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(65);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1);
		Registracija r=new Registracija(100, new Date(), new Date(), vozilo.getId(), osoba.getId());
		
		srm.setRegistracija(r);
		srm.dodajRegistraciju();
	}
	@Test
	public void testDodavanjaVozila() {
		Motor m=new Motor(104, 2030, 280, VrstaGoriva.BENZIN, "566j56gf5", VrstaMotora.DIESEL);
		BojeVozilaDAO bd=new BojeVozilaDAO();
		BojaVozila boja=new BojaVozila();
		boja=bd.get(67);
		Vozilo v = new Vozilo(17, VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300, 50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date(), "1234a45", Status.AKTIVAN, boja, m ); 
		
		srm.setVozilo(v);
		assertTrue(srm.dodajVozilo());
	}
}
