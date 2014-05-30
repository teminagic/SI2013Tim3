package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.klase.Motor;
import junit.framework.TestCase;

public class VoziloDAOTest extends TestCase {

	private Motor motor = new Motor();
	private Vozilo vozilo = new Vozilo();
	private VoziloDAO voziloDAO = new VoziloDAO();
	
	@Test
	public void testCreate() {
		
		// nesto zeza, ujutro nastavim
		
	}

	@Test
	public void testExistingGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByReg() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
