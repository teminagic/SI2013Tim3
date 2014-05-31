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
		Osoba o = new Osoba(1324, "1345991198221", "Prezime", "Ime", "Prebivaliste", true); 
		osoba.create(o);
		assertNotNull(osoba.get(1352));
	}
	@Test
	public void testNotNullGet() { 
		assertNotNull(osoba.get(1352).getJmbg_Id());
	}
	@Test
	public void testNullGet() { 
		
		assertNull(osoba.get(13235).getJmbg_Id());
	}
	@Test
	public void testGetAll() { 
		List<Osoba> osobe=osoba.getAll();
		for(int i=0; i<osobe.size(); i++)
			assertNotNull(osobe.get(i).getId());
	}
	@Test
	public void testGetByIme() { 
		List<Osoba> osobe=osoba.getByIme("Ime");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByPrezime() { 
		List<Osoba> osobe=osoba.getByPrezime("Prezime");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByImeiPrezime() { 
		List<Osoba> osobe=osoba.getByImeiPrezime("Ime", "Prezime");
		assertEquals(osobe.size(), 0, 10000);
	}
	@Test
	public void testGetByJmbg() { 
		assertNotNull(osoba.getByJMBG("1345991198322"));
	}
	@Test
	public void testUpdate() { 
		Osoba o = new Osoba(1324, "1345991198322", "Dervic", "Amra", "Prebivaliste", true); 
		assertTrue(osoba.update(1352, o));
	}
	@Test
	public void testDelete() { 
		Osoba o = new Osoba(1323, "1345991198333", "Dervic", "Amra", "Prebivaliste", true); 
		osoba.create(o);
		assertTrue(osoba.delete(1353));
	}
	

}
