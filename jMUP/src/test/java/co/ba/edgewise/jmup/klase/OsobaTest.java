package co.ba.edgewise.jmup.klase;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.co.edgewise.jmup.klase.Osoba;

public class OsobaTest {

	
	@Test
	public void testOsoba() {
		Osoba o = new Osoba(); 
		assertNull(o.getPrezime());
	}

	@Test
	public void testOsobaIntStringStringStringStringBoolean() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getId());
	}

	@Test
	public void testGetId() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getId());
	}

	@Test
	public void testSetId() {
		Osoba o = new Osoba();
		o.setId(13245);
	}

	@Test
	public void testGetJmbg_Id() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getJmbg_Id());
	}

	@Test
	public void testSetJmbg_Id() {
		Osoba o = new Osoba();
		o.setJmbg_Id("1708990175555");
	}

	@Test
	public void testGetPrezime() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getPrezime());
	}

	@Test
	public void testSetPrezime() {
		Osoba o = new Osoba();
		o.setPrezime("Asotic");
	}

	@Test
	public void testGetIme() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getIme());
	}

	@Test
	public void testSetIme() {
		Osoba o = new Osoba();
		o.setIme("Amar");
	}

	@Test
	public void testGetPrebivaliste() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertNotNull(o.getPrebivaliste());
	}

	@Test
	public void testSetPrebivaliste() {
		Osoba o = new Osoba();
		o.setPrebivaliste("Ilidza");
	}

	@Test
	public void testIsPravnoLice() {
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true); 
		assertTrue(o.isPravnoLice());
	}

	@Test
	public void testSetPravnoLice() {
		Osoba o = new Osoba();
		o.setPravnoLice(true);
	}

}
