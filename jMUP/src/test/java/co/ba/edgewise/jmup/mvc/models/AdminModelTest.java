package co.ba.edgewise.jmup.mvc.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;
import ba.co.edgewise.jmup.enums.TipUposlenika;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.mvc.models.AdminModel;

public class AdminModelTest {

	AdminModel am;
	Uposlenik u, u2;
	@Before
	public void setUp(){
		am=new AdminModel();
		u=new Uposlenik(3, "Amra", "Dervic", "amra", "amra", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		u2=new Uposlenik(3, "Amra", "Prezime", "amrad", "amra", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		am.setUposlenik(u);
	}
	@After
	public void CleanUp(){
		am.brisanjeKorisnika();
	}
	@Test
	public void testKreiranjaUposlenika() {
		Uposlenik u3 = new Uposlenik(3, "Amra", "Prezime", "niko", "amra", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		am.setUposlenik(u3);
		assertTrue(am.kreiranjeKorisnika());
		am.brisanjeKorisnika();
	}
	@Test
	public void testModifikovanjaKorisnika(){
		am.setUposlenik(u2);
		assertTrue(am.modifikovanjeKorisnika());
	}
	@Test
	public void testBrisanjaKorisnika(){
		am.setUposlenik(u2);
		am.kreiranjeKorisnika();
		assertTrue(am.brisanjeKorisnika());
	}
	@Test
	public void testDohvatanjeSvihUsera(){
		ArrayList<Uposlenik>uposlenici=am.dohvatiSveUsere();
		for(int i=0; i<uposlenici.size(); i++)
			assertNotNull(uposlenici.get(i).getId());
	}
	@Test
	public void testDohvatanjaUseraPoImenu(){
		ArrayList<Uposlenik>uposlenici;
		uposlenici=am.dohvatiUserePretraga("Amra", TipPretrageUposlenika.IME);
		for(int i=0; i<uposlenici.size(); i++)
			assertNotNull(uposlenici.get(i).getId());
	}
	@Test
	public void testDohvatanjaUseraPoPrezimenu(){
		ArrayList<Uposlenik>uposlenici;
		uposlenici=am.dohvatiUserePretraga("Dervic", TipPretrageUposlenika.PREZIME);
		for(int i=0; i<uposlenici.size(); i++)
			assertNotNull(uposlenici.get(i).getId());
	}
	@Test
	public void testDohvatanjaUseraPoUsername(){
		ArrayList<Uposlenik>uposlenici;
		uposlenici=am.dohvatiUserePretraga("amra", TipPretrageUposlenika.USERNAME);
		for(int i=0; i<uposlenici.size(); i++)
			assertNotNull(uposlenici.get(i).getId());
	}

}
