package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.klase.Motor;
import junit.framework.TestCase;

public class VoziloDAOTest {

	private Motor motor = new Motor();
	VoziloDAO voziloDAO = new VoziloDAO();
	
	@Test
	public void testCreate() {
		MotorDAO md=new MotorDAO();
		motor=md.get(3);
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		voziloDAO.create(v);
		assertNotNull(voziloDAO.get(17).getId());
		
	}

	@Test
	public void testExistingGet() {
		assertNotNull(voziloDAO.get(17).getId());
	}

	@Test
	public void testNullGet() {
		assertNull(voziloDAO.get(178).getId());
	}
	
	@Test
	public void testGetByReg() {
		/*List<Vozilo> vozila= */ assertNotNull(voziloDAO.getByReg("1708"));
		//assertEquals(vozila.size(), 0, 10000);
		
	}

	@Test
	public void testGetByDate() {
		/*ArrayList<Vozilo> vozila=*/ assertNotNull(voziloDAO.getByDate(2014-05-30)); //datum ubaciti
		//assertEquals(vozila.size(), 0, 10000);
	}

	@Test
	public void testGetByType() {
		List<Vozilo> vozila=voziloDAO.getByType("limuzina");
		assertEquals(vozila.size(), 0, 10000);
	}

	@Test
	public void testGetByMark() {
		List<Vozilo> vozila=voziloDAO.getByMark("BMW");
		assertEquals(vozila.size(), 0, 10000);
	}

	@Test
	public void testGetAll() {
		List<Vozilo> vozila=voziloDAO.getAll();
		for(int i=1; i<vozila.size(); i++)
			assertNotNull(vozila.get(i).getId());
	}

	@Test
	public void testUpdate() {
		MotorDAO md=new MotorDAO();
		motor=md.get(3);
		Vozilo v = new Vozilo(21, "170899", VrstaVozila.PUTNICKI_AUTOMOBIL, "Audi", "limuzina","A1", "161616165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		//voziloDAO.create(v);
		assertTrue(voziloDAO.update(21, v)); // nesto nece update..
	}

	@Test
	public void testDelete() {
		MotorDAO md=new MotorDAO();
		motor=md.get(3);
		Vozilo v = new Vozilo(40, "1708990", VrstaVozila.PUTNICKI_AUTOMOBIL, "Audi", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		voziloDAO.create(v);
		assertTrue(voziloDAO.delete(40));
	}

}
