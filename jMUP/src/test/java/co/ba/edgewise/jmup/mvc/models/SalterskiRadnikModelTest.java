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
		assertTrue(srm.DodajVozaca("Amra", "Dervic", "adresa", "mjesto", "opcina", false, "1234567891567"));
	}
	@Test
	public void testDodavanjeVlasnicke(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(106);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1508);
		assertTrue(srm.DodajVlasnicku("123a321", vozilo.getRegOznaka(), osoba.getJmbg_Id()));
	}
	/*@Test
	public void testDodavanjeRegistracije(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(106);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1508);
		srm.DodajRegistracijuISaobracajnu("123n321", vozilo.getRegOznaka(), osoba.getJmbg_Id(), odKad, doKad)
		
		srm.setRegistracija(r);
		srm.dodajRegistraciju();
	}*/
	@Test
	public void testDodavanjaVozila() {
		assertTrue(srm.dodajVozilo("123-K-767", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina", "A3", "dsada3434", "oblikKaroserije", 1999, 55, 5, 5, 5.3, 5, 5, 5, EkoKarakteristike.EURO1, true, new Date(), 4, 4, VrstaGoriva.BENZIN.toString(), "342432dfrdf", VrstaMotora.DIESEL.toString()));
	}
}
