package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.daldao.daos.VlasnickaDAO;

import org.junit.Test;

public class VlasnickaDAOTest {

	VlasnickaDAO vlDAO = new VlasnickaDAO();
	
	@Test
	public void testCreate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(2);
		Vlasnicka vl = new Vlasnicka("175D", vozilo, osoba);
		assertTrue(vlDAO.create(vl));
	}

	@Test
	public void testGet() {
		assertNotNull(vlDAO.get("22486D"));
	}

	@Test
	public void testGetByVlasnik() {
		assertNotNull(vlDAO.getByVlasnik(2));
	}

	@Test
	public void testGetByVozilo() {
		assertNotNull(vlDAO.getByVozilo(1));
	}

	@Test
	public void testGetAll() {
		List<Vlasnicka> vlasnicke=vlDAO.getAll();
		for(int i=0; i<vlasnicke.size(); i++)
			assertNotNull(vlDAO.get(vlasnicke.get(i).getBrojDozvole()));
	}

	@Test
	public void testUpdate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(2);
		Vlasnicka vl = new Vlasnicka("17", vozilo, osoba);
		//vlDAO.create(vl);
		assertTrue(vlDAO.update("175D", vl)); 
	}

	@Test
	public void testDelete() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(2);
		Vlasnicka vl = new Vlasnicka("21", vozilo, osoba);
		vlDAO.create(vl);
		assertTrue(vlDAO.delete("21"));
	}

}
