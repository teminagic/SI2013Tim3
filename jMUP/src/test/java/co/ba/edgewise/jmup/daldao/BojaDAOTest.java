package co.ba.edgewise.jmup.daldao;

import org.junit.Before;
import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.BojaDAO;
import ba.co.edgewise.jmup.enums.Boja;
import junit.framework.TestCase;

public class BojaDAOTest extends TestCase {
	
	private BojaDAO boja=new BojaDAO();
	
	@Test
	public void testExistingGet(){
		assertEquals(boja.get(1), Boja.CRNA);
		assertEquals(boja.get(2), Boja.CRVENA);
		assertEquals(boja.get(3), Boja.ZUTA);
		assertEquals(boja.get(4), Boja.PLAVA);
		assertEquals(boja.get(5), Boja.ZELENA);
	}
	
	@Test
	public void testNullGet(){
		assertNull(boja.get(6));
	}
	@Test
	public void testGetID(){
		assertEquals(boja.getID(Boja.CRNA), 1., 0);
		assertEquals(boja.getID(Boja.CRVENA), 2., 0);
		assertEquals(boja.getID(Boja.ZUTA), 3., 0);
		assertEquals(boja.getID(Boja.PLAVA), 4., 0);
		assertEquals(boja.getID(Boja.ZELENA), 5., 0);
	}
}
