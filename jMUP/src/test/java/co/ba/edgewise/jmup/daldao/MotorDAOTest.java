package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.klase.Motor;

public class MotorDAOTest {
	
	MotorDAO motor=new MotorDAO();
	
	@Test
	public void testCreate() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertNotNull(motor.create(m));
	}
	@Test
	public void testNotNullGet(){
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		assertEquals(m.getMaxSnaga(), motor.get(136).getMaxSnaga());
		assertEquals(m.getVrstaGoriva(), motor.get(136).getVrstaGoriva());
		assertEquals(m.getVrstaMotora(), motor.get(136).getVrstaMotora());
		assertEquals(m.getZapreminaMotora(), motor.get(136).getZapreminaMotora());
	}
	@Test
	public void testNullGet(){
		assertNull(motor.get(123113).getId());
	}
	@Test
	public void testGetAll(){
		List<Motor> motori=motor.getAll();
		for(int i=0; i<motori.size(); i++)
		{
			assertNotNull(motori.get(i).getId());
		}
	}
	@Test
	public void testUpdate(){
		Motor m=new Motor(104, 200, 800, "dizel", "5", "OTTO");
		assertTrue(motor.update(136, m));
	}
	@Test
	public void testDelete(){
		Motor m=new Motor(1004, 200, 800, "dizel", "5", "OTTO");
		motor.create(m);
		assertTrue(motor.delete(137));
	}

}
