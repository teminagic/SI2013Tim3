package co.ba.edgewise.jmup.klase;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.enums.*;

public class MotorTest {

	@Test
	public void testMotorIntegerIntegerIntegerStringStringString() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getId());
	}

	@Test
	public void testMotor() {
		Motor m=new Motor();
		assertNull(m.getBrojMotora());
	}

	@Test
	public void testGetId() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getId());	}

	@Test
	public void testSetId() {
		Motor m=new Motor();
		m.setId(104);
	}

	@Test
	public void testGetZapreminaMotora() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getZapreminaMotora());
	}

	@Test
	public void testSetZapreminaMotora() {
		Motor m=new Motor();
		m.setZapreminaMotora(300);
	}

	@Test
	public void testGetMaxSnaga() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getMaxSnaga());
	}

	@Test
	public void testSetMaxSnaga() {
		Motor m=new Motor();
		m.setMaxSnaga(500);
	}

	@Test
	public void testGetVrstaGoriva() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getVrstaGoriva());
	}

	@Test
	public void testSetVrstaGoriva() {
		Motor m=new Motor();
		m.setVrstaGoriva("dizel");
	}

	@Test
	public void testGetBrojMotora() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getBrojMotora());
	}

	@Test
	public void testSetBrojMotora() {
		Motor m=new Motor();
		m.setBrojMotora("17");
	}

	@Test
	public void testGetVrstaMotora() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(m.getVrstaMotora());
	}

	@Test
	public void testSetVrstaMotora() {
		Motor m=new Motor();
		m.setVrstaMotora("WANKEL");
	}

}
