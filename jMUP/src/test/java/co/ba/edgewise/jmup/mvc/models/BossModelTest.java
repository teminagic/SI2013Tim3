package co.ba.edgewise.jmup.mvc.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.BojeVozilaDAO;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.mvc.models.BossModel;

public class BossModelTest {
	
	BossModel bm;
	
	@Before
	public void setUp(){
		bm=new BossModel();
	}
	@Test
	public void testDohvatanjaSvihVozila() {
		ArrayList<Vozilo> vozila=bm.dohvatiSvaVozila();
		for(int i=0; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}
	@Test
	public void testDohvatanjaSvihVozaca() {
		ArrayList<Osoba> vozaci=bm.dohvatiSveVozace();
		for(int i=0; i<vozaci.size(); i++)
			assertNotNull(vozaci.get(i).getId());
	}
	@Test
	public void testDohvatanjaSvihSaobracajnih() {
		ArrayList<Saobracajna> saobracajneDozvole=bm.dohvatiSveSaobracajne();
		for(int i=0; i<saobracajneDozvole.size(); i++)
			assertNotNull(saobracajneDozvole.get(i).getBrojDozvole());
	}
	@Test
	public void testDohvatanjaSvihVlasnickih() {
		ArrayList<Vlasnicka> vlasnickeDozvole=bm.dohvatiSveVlasnicke();
		for(int i=0; i<vlasnickeDozvole.size(); i++)
			assertNotNull(vlasnickeDozvole.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaPoRegitraciji(){
		ArrayList<Vozilo>vozila=bm.pretragaVozilo("424", "Registarska oznaka");
		for(int i=0; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}
	@Test
	public void testPretragaPoGodiniProizvodnje(){
		ArrayList<Vozilo>vozila=bm.pretragaVozilo("1999", "Godina proizvodnje");
		for(int i=0; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}
	@Test
	public void testPretragaPoVrstiVozila(){
		ArrayList<Vozilo>vozila=bm.pretragaVozilo(VrstaVozila.AUTOBUS.toString(), "Vrsta vozila");
		for(int i=0; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}
	@Test
	public void testPretragaPoMarkaVozila(){
		ArrayList<Vozilo>vozila=bm.pretragaVozilo("Škoda", "Marka vozila");
		for(int i=0; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}
	@Test
	public void testPretragaVozacPoImenu(){
		ArrayList<Osoba>vozaci=bm.pretragaVozac("Amra", "Ime");
		for(int i=0; i<vozaci.size(); i++)
			assertNotNull(vozaci.get(i).getId());
	}
	@Test
	public void testPretragaVozacPoPrezimenu(){
		ArrayList<Osoba>vozaci=bm.pretragaVozac("Amra", "Prezime");
		for(int i=0; i<vozaci.size(); i++)
			assertNotNull(vozaci.get(i).getId());
	}
	@Test
	public void testPretragaVozacPoJMBG(){
		ArrayList<Osoba>vozaci=bm.pretragaVozac("1345991198322", "JMBG");
		for(int i=0; i<vozaci.size(); i++)
			assertNotNull(vozaci.get(i).getId());
	}
	@Test
	public void testPretragaSaobracajnaPoImeiPrezime(){
		ArrayList<Saobracajna>saobracajne=bm.pretragaSaobracajna("Amra Dervic", "Ime i prezime");
		for(int i=0; i<saobracajne.size(); i++)
			assertNotNull(saobracajne.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaSaobracajnaPoRegistarskaOznaka(){
		ArrayList<Saobracajna>saobracajne=bm.pretragaSaobracajna("424", "Registarska oznaka");
		assertEquals(saobracajne.size(), 1);
	}
	@Test
	public void testPretragaSaobracajnaPoJMBG(){
		ArrayList<Saobracajna>saobracajne=bm.pretragaSaobracajna("1345991198322", "JMBG");
		for(int i=0; i<saobracajne.size(); i++)
			assertNotNull(saobracajne.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaSaobracajnaPoBrojPotvrde(){
		ArrayList<Saobracajna>saobracajne=bm.pretragaSaobracajna("17", "Broj potvrde");
		for(int i=0; i<saobracajne.size(); i++)
			assertNotNull(saobracajne.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaVlasnikaPoImeiPrezime(){
		ArrayList<Vlasnicka>vlasnicke=bm.pretragaVlasnicka("Amra Dervic", "Ime i prezime");
		for(int i=0; i<vlasnicke.size(); i++)
			assertNotNull(vlasnicke.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaVlasnickaPoRegistarskaOznaka(){
		ArrayList<Vlasnicka>vlasnicke=bm.pretragaVlasnicka("424", "Registarska oznaka");
		assertEquals(vlasnicke.size(), 1);
	}
	@Test
	public void testPretragaVlasnickaPoJMBG(){
		ArrayList<Vlasnicka>vlasnicke=bm.pretragaVlasnicka("1345991198322", "JMBG");
		for(int i=0; i<vlasnicke.size(); i++)
			assertNotNull(vlasnicke.get(i).getBrojDozvole());
	}
	@Test
	public void testPretragaVlasnickaPoBrojPotvrde(){
		ArrayList<Vlasnicka>vlasnicke=bm.pretragaVlasnicka("17", "Broj potvrde");
		for(int i=0; i<vlasnicke.size(); i++)
			assertNotNull(vlasnicke.get(i).getBrojDozvole());
	}
	@Test
	public void testGetMotorByVozilo(){
		Motor m=bm.getMotorByVozilo(67);
		assertNotNull(m.getBrojMotora());
	}
	@Test
	public void testModifikacijeVozila(){
		BojeVozilaDAO bd=new BojeVozilaDAO();
		BojaVozila boja=new BojaVozila();
		boja=bd.get(67);
		MotorDAO md=new MotorDAO();
		Motor motor=new Motor();
		motor=md.get(120);
		Vozilo v = new Vozilo(17, VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300, 50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date(), "1234a45", Status.AKTIVAN, boja, motor ); 
		assertTrue(bm.modifikacijaVozilo(67, v));
	}
	@Test
	public void testModifikacijeOsoba(){
		Osoba o = new Osoba(1324, "1345991198322", "Dervic", "Amra", "Prebivaliste", true);
		assertTrue(bm.modifikacijaOsoba(1352, o));
	}
	@Test
	public void testModifikacijeVlasnicka(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(67);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352);
		Vlasnicka vl = new Vlasnicka("17", vozilo, osoba);
		assertTrue(bm.modifikacijaVlasnicka("17", vl));
	}
	@Test
	public void testModifikacijeSaobracajna(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(67);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352);
		Saobracajna sa = new Saobracajna("17", vozilo, osoba);
		assertTrue(bm.modifikacijaSaobracajna("17", sa));
	}
}
