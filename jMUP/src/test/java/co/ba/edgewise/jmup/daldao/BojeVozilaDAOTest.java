package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.BojeVozilaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.enums.Boja;
import ba.co.edgewise.jmup.enums.EkoKarakteristike;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.enums.VrstaVozila;
import ba.co.edgewise.jmup.klase.BojaVozila;
import ba.co.edgewise.jmup.klase.Motor;
import ba.co.edgewise.jmup.klase.Vozilo;

public class BojeVozilaDAOTest extends TestCase{
	
	BojeVozilaDAO bojeVozila;
	
	
	@Before
	public void testSetUp(){
		//pokusaj poslije napraviti..javlja mi null exception
	}
	
	@Test
	public void testCreate() {
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(178,Boja.CRVENA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila=new BojeVozilaDAO();
		bojeVozila.create(boja1);
		assertNotNull(bojeVozila.get(boja1.getVozilo().getId()));
	}
	
	@Test
	public void testGet() {
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(178,Boja.CRVENA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getBoja(),Boja.CRVENA);
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getTip(), "tip");
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getNijansa(), NijansaBoje.STANDARDNA);
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getVrsta(), VrstaBoje.OBICNA);
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getVozilo().getRegOznaka(), vozilo1.getRegOznaka());
	}
	
	@Test
	public void testGetAll(){
		//ovu sam mozda odradila nelogicno..tj mozda testiram isto. 
		//eventualno kad zamijenimo bazu mozemo testirati na velicinu baze tj.
		//assertEquals(bojaVozila.size(), "ta velicina baze");
		bojeVozila=new BojeVozilaDAO();
		VoziloDAO vdao = new VoziloDAO();
		List<BojaVozila> bojaVozila=bojeVozila.getAll();
		
		for(int i=1; i<bojaVozila.size(); i++)
		{
			//Vozilo vozilo=vdao.get(bojaVozila.get(i).getVozilo().getId());
			//assertEquals(bojeVozila.get(bojaVozila.get(i).getVozilo().getId()).getVozilo().getRegOznaka(), vozilo.getRegOznaka());
			assertNotNull(bojaVozila.get(i).getVozilo().getId());
		}
	}
	@Test
	public void testUpdate(){
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(178,Boja.CRVENA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		BojaVozila boja2=new BojaVozila(178,Boja.CRNA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		
		assertTrue(bojeVozila.update(vozilo1.getId(), boja2));
	}
	@Test
	public void testDelete(){
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(178,Boja.CRVENA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		
		assertTrue(bojeVozila.delete(vozilo1.getId()));
	}
	

}
