package co.ba.edgewise.jmup.klase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.MotorDAO;
import ba.co.edgewise.jmup.enums.*;
import ba.co.edgewise.jmup.klase.*;

public class VoziloTest {

	@Test
	public void testVoziloIntegerStringVrstaVozilaStringStringStringStringStringIntIntIntIntMotorDoubleIntegerIntegerIntegerEkoKarakteristikeBooleanDate() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getId());
	}

	@Test
	public void testVozilo() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		assertNull(v.getBrojMjestaZaLezanje());	
	}

	@Test
	public void testGetId() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getId());
	}

	@Test
	public void testSetId() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		v.setId(21);
	}

	@Test
	public void testGetRegOznaka() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getRegOznaka());
	}

	@Test
	public void testSetRegOznaka() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setRegOznaka("170890");
	}

	@Test
	public void testGetVrsta() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getVrsta());
	}

	@Test
	public void testSetVrsta() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setVrsta(VrstaVozila.MOTOCIKL);
	}

	@Test
	public void testGetMarka() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getMarka());
	}

	@Test
	public void testSetMarka() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setMarka("AUDI");
	}

	@Test
	public void testGetTip() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getTip());
	}

	@Test
	public void testSetTip() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setTip("limuzina");
	}

	@Test
	public void testGetModel() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getModel());
	}

	@Test
	public void testSetModel() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setModel("A4");
	}

	@Test
	public void testGetBrojSasije() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getBrojSasije());
	}

	@Test
	public void testSetBrojSasije() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setBrojSasije("124578963698");
	}

	@Test
	public void testGetOblikKaroserije() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getOblikKaroserije());
	}

	@Test
	public void testSetOblikKaroserije() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setOblikKaroserije("oblik");
	}

	@Test
	public void testGetGodinaProizvodnje() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getGodinaProizvodnje());
	}

	@Test
	public void testSetGodinaProizvodnje() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setGodinaProizvodnje(1990);
	}

	@Test
	public void testGetMaxTehnickaDozvoljenaMasa() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getMaxTehnickaDozvoljenaMasa());
	}

	@Test
	public void testSetMaxTehnickaDozvoljenaMasa() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setMaxTehnickaDozvoljenaMasa(400);
	}

	@Test
	public void testGetMasaVozila() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getMasaVozila());
	}

	@Test
	public void testSetMasaVozila() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setMasaVozila(800);
	}

	@Test
	public void testGetDopustenaNosivost() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getDopustenaNosivost());
	}

	@Test
	public void testSetDopustenaNosivost() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setDopustenaNosivost(1000);
	}

	@Test
	public void testGetMotor() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getMotor());
	}

	@Test
	public void testSetMotor() {
		Motor m=new Motor();
		Vozilo v = new Vozilo(); 
		v.setMotor(m);
	}

	@Test
	public void testGetOdnosSnageIMase() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getOdnosSnageIMase());
	}

	@Test
	public void testSetOdnosSnageIMase() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setOdnosSnageIMase(59.46);
	}

	@Test
	public void testGetBrojMjestaZaSjedenje() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getBrojMjestaZaSjedenje());
	}

	@Test
	public void testSetBrojMjestaZaSjedenje() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setBrojMjestaZaSjedenje(5);
	}

	@Test
	public void testGetBrojMjestaZaStajanje() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getBrojMjestaZaStajanje());
	}

	@Test
	public void testSetBrojMjestaZaStajanje() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setBrojMjestaZaStajanje(8);
	}

	@Test
	public void testGetBrojMjestaZaLezanje() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getBrojMjestaZaLezanje());
	}

	@Test
	public void testSetBrojMjestaZaLezanje() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setBrojMjestaZaLezanje(10);
	}

	@Test
	public void testGetEkoKarakteristika() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getEkoKarakteristika());
	}

	@Test
	public void testSetEkoKarakteristika() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setEkoKarakteristika(EkoKarakteristike.KONVENCIONALNO);
	}

	@Test
	public void testGetKatalizator() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getKatalizator());
	}

	@Test
	public void testSetKatalizator() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setKatalizator(true);
	}

	@Test
	public void testGetDatumPregleda() {
		Motor m=new Motor(104, 200, 80, "dizel", "5", "OTTO");
		Vozilo v = new Vozilo(17, "1708", VrstaVozila.PUTNICKI_AUTOMOBIL, "BMW", "limuzina","A3", "161616165165", "OblikKaroserije",1990,1000,500,300,m,50.1,5,4,3,EkoKarakteristike.EURO2, true, new Date() ); 
		assertNotNull(v.getDatumPregleda());
	}

	@Test
	public void testSetDatumPregleda() {
		Motor m = new Motor();
		Vozilo v = new Vozilo();
		v.setDatumPregleda(new Date());
	}

}
