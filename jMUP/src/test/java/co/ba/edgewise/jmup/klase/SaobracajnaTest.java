package co.ba.edgewise.jmup.klase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.klase.Saobracajna;

public class SaobracajnaTest {

	@Test
	public void testSaobracajna() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		Osoba o = new Osoba();
		Saobracajna sa = new Saobracajna();
		assertNull(sa.getKorisnik());
	}

	@Test
	public void testSaobracajnaStringVoziloOsoba() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true);
		Saobracajna vl = new Saobracajna("17",v,o);
		assertNotNull(vl.getKorisnik());
	}

	@Test
	public void testGetBrojDozvole() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true);
		Saobracajna vl = new Saobracajna("17",v,o);
		assertNotNull(vl.getBrojDozvole());
	}

	@Test
	public void testSetBrojDozvole() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		Osoba o = new Osoba();
		Saobracajna sa = new Saobracajna();
		sa.setBrojDozvole("23");
	}

	@Test
	public void testGetVozilo() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true);
		Saobracajna vl = new Saobracajna("17",v,o);
		assertNotNull(vl.getVozilo());
	}

	@Test
	public void testSetVozilo() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		Osoba o = new Osoba();
		Saobracajna sa = new Saobracajna();
		sa.setVozilo(v);
	}

	@Test
	public void testGetKorisnik() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true);
		Saobracajna vl = new Saobracajna("17",v,o);
		assertNotNull(vl.getKorisnik());
	}

	@Test
	public void testSetKorisnik() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		Osoba o = new Osoba(13245, "1708990175555", "Asotic", "Amar", "Ilidza", true);
		Saobracajna sa = new Saobracajna();
		sa.setKorisnik(o);
	}


}
