package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.RegistracijaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Registracija;
import ba.co.edgewise.jmup.klase.Vozilo;

public class RegistracijaDAOTest {

	RegistracijaDAO reg=new RegistracijaDAO();
	@Test
	public void testCreate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(5);
		Registracija r=new Registracija(100, "123a456", new Date(), new Date(), vozilo, osoba);
		
		reg.create(r);
		assertNotNull(reg.get(100));
	}
	@Test
	public void testGet(){
		assertNotNull(reg.get(100).getId());
	}
	@Test
	public void testGetAll(){
		List<Registracija> registracije=reg.getAll();
		for(int i=0; i<registracije.size(); i++)
			assertNotNull(reg.get(registracije.get(i).getId()));
	}
	@Test
	public void testUpdate(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(5);
		Registracija r=new Registracija(100, "123b456", new Date(), new Date(), vozilo, osoba);
		
		assertTrue(reg.update(100, r));
	}
	@Test
	public void testDelete(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(5);
		Registracija r=new Registracija(1050, "123b456", new Date(), new Date(), vozilo, osoba);
		reg.create(r);
		
		assertTrue(reg.delete(1050));
	}
	
}
