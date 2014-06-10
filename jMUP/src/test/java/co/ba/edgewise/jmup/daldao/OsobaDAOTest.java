package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.klase.Osoba;

public class OsobaDAOTest {

	OsobaDAO osoba=new OsobaDAO();
	
	@Test
	public void testCreate() {
		Osoba o = new Osoba(1324, "134599", "Asotić", "Amar", "Ilirska Ilidža Ilidža", true); 
		assertTrue(osoba.create(o));
	}
	@Test
	public void testNotNullGet() { 
		assertNotNull(osoba.getByJMBG("134599"));
	}
	@Test
	public void testNullGet() { 
		assertNull(osoba.getByJMBG("134599545345"));
	}
	@Test
	public void testGetAll() { 
		List<Osoba> osobe=osoba.getAll();
		for(int i=0; i<osobe.size(); i++)
			assertNotNull(osobe.get(i).getId());
	}
	@Test
	public void testGetByIme() { 
		List<Osoba> osobe=osoba.getByIme("Amra");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByPrezime() { 
		List<Osoba> osobe=osoba.getByPrezime("Dervić");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByImeiPrezime() { 
		List<Osoba> osobe=osoba.getByImeiPrezime("Amra", "Dervić");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByJmbg() { 
		assertNotNull(osoba.getByJMBG("167"));
	}
	@Test
	public void testUpdate() { 
		Osoba o = new Osoba(1324, "1345991198322", "Dervic", "Amra", "Kalinska Travnik Travnik", true); 
		assertTrue(osoba.update(1324, o));
	}
	@Test
	public void testDelete() { 
		Osoba o = new Osoba(1323, "1345991198333", "Prezimenko", "Imenko", "Prebivaliste", true); 
		osoba.create(o);
		assertTrue(osoba.delete(osoba.getByJMBG("1345991198333").getId()));
	}
	

}
