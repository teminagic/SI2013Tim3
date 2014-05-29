package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.TipUposlenikaDAO;
import ba.co.edgewise.jmup.enums.TipUposlenika;
import junit.framework.TestCase;

public class TipUposlenikaDAOTest extends TestCase {

	private TipUposlenikaDAO tipUposlenika = new TipUposlenikaDAO();
	
	@Test
	public void testExistingGet() {
		assertEquals(tipUposlenika.get(1), TipUposlenika.ADMINISTRATOR);
		assertEquals(tipUposlenika.get(2), TipUposlenika.SALTERSKI_RADNIK);
		assertEquals(tipUposlenika.get(3), TipUposlenika.MENADZER);
	}

	@Test
	public void testGetID() {
		assertEquals(tipUposlenika.getID(TipUposlenika.ADMINISTRATOR), 1., 0);
		assertEquals(tipUposlenika.getID(TipUposlenika.SALTERSKI_RADNIK), 2., 0);
		assertEquals(tipUposlenika.getID(TipUposlenika.MENADZER), 3., 0);
	}

	@Test
	public void testNullGet(){
		assertNull(tipUposlenika.get(4));
	}
	
	@Test
	public void testNotNullGet(){
		assertNotNull(tipUposlenika.get(1));
	}

}
