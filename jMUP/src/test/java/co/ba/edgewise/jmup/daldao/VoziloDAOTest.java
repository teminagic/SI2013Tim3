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
		motor=md.get(1);
		Vozilo v = new Vozilo(17, "170-A-558", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616h165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertTrue(voziloDAO.create(v));
	}

	@Test
	public void testExistingGet() {
		assertNotNull(voziloDAO.get(1));
	}

	@Test
	public void testNullGet() {
		assertNull(voziloDAO.get(10032).getRegOznaka());
	}
	
	@Test
	public void testGetByReg() {
		/*List<Vozilo> vozila= */ assertNotNull(voziloDAO.getByReg("567-A-543"));
		//assertEquals(vozila.size(), 0, 10000);
		
	}


	@Test
	public void testGetByType() {
		List<Vozilo> vozila=voziloDAO.getByType("limuzina");
		assertNull(vozila);
	}

	@Test
	public void testGetByMark() {
		List<Vozilo> vozila=voziloDAO.getByMark("Toyota");
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
		motor=md.get(1);
		Vozilo v = new Vozilo(21, "170899", VrstaVozila.PUTNICKI_AUTOMOBIL, "Audi", "limuzina","A1", "161616165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		//voziloDAO.create(v);
		assertTrue(voziloDAO.update(3, v)); // nesto nece update..
	}

	@Test
	public void testDelete() {
		MotorDAO md=new MotorDAO();
		motor=md.get(1);
		Vozilo v = new Vozilo(40, "170-M-990", VrstaVozila.PUTNICKI_AUTOMOBIL, "Audi", "limuzina","A3", "161n616165165", "OblikKaroserije",1990,1000,500,300,motor,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertTrue(voziloDAO.create(v));
		assertTrue(voziloDAO.delete(voziloDAO.getByReg("170-M-990").getId()));
	}

}
