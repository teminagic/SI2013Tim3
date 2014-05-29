package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;

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

	VoziloDAO vdao = new VoziloDAO();
	Vozilo vozilo1=vdao.get(1);
	BojaVozila boja1=new BojaVozila(Boja.CRVENA, vozilo1, NijansaBoje.STANDARDNA, VrstaBoje.OBICNA, "tip" );
	
	@Before
	public void testSetUp(){
		//pokusaj poslije napraviti..javlja mi null exception
	}
	
	@Test
	public void testCreate() {
		BojeVozilaDAO bojeVozila=new BojeVozilaDAO();
		bojeVozila.create(boja1);
		assertNotNull(bojeVozila.get(boja1.getVozilo().getId()));
	}
	
	@Test
	public void testGet() {
		BojeVozilaDAO bojeVozila=new BojeVozilaDAO();
		bojeVozila.create(boja1);
		assertEquals(bojeVozila.get(boja1.getVozilo().getId()).getBoja(),Boja.CRVENA);
		
	}

}
