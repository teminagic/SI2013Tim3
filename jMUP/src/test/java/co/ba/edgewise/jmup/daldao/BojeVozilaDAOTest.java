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
		BojaVozila boja1=new BojaVozila(Boja.CRVENA, vozilo1.getId(), NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila=new BojeVozilaDAO();
		bojeVozila.create(boja1);
		assertNotNull(bojeVozila.get(boja1.getVoziloId()));
	}
	
	@Test
	public void testGet() {
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(Boja.CRVENA, vozilo1.getId(), NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		
		assertEquals(bojeVozila.get(boja1.getVoziloId()).getBoja(),Boja.CRVENA);
		assertEquals(bojeVozila.get(boja1.getVoziloId()).getTip(), "tip");
		assertEquals(bojeVozila.get(boja1.getVoziloId()).getNijansa(), NijansaBoje.STANDARDNA);
		assertEquals(bojeVozila.get(boja1.getVoziloId()).getVrsta(), VrstaBoje.OBICNA);
		assertEquals(bojeVozila.get(boja1.getVoziloId()).getVoziloId(), vozilo1.getId());
	}
	
	@Test
	public void testGetAll(){
		bojeVozila=new BojeVozilaDAO();
		VoziloDAO vdao = new VoziloDAO();
		List<BojaVozila> bojaVozila=bojeVozila.getAll();
		
		for(int i=1; i<bojaVozila.size(); i++)
		{
			assertNotNull(bojaVozila.get(i).getVoziloId());
		}
	}
	@Test
	public void testUpdate(){
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(67);
		BojaVozila boja1=new BojaVozila(Boja.CRVENA, vozilo1.getId(), NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		BojaVozila boja2=new BojaVozila(Boja.CRNA, vozilo1.getId(), NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		
		assertTrue(bojeVozila.update(vozilo1.getId(), boja2));
	}
	@Test
	public void testDelete(){
		bojeVozila=new BojeVozilaDAO();
		
		VoziloDAO vdao = new VoziloDAO();
		Vozilo vozilo1=vdao.get(65);
		BojaVozila boja1=new BojaVozila(Boja.CRVENA, vozilo1.getId(), NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
		bojeVozila.create(boja1);
		
		assertTrue(bojeVozila.delete(vozilo1.getId()));
	}
	

}
