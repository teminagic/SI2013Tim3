package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
		Vozilo vozilo =vd.get(2);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1);
		Registracija r=new Registracija(100, "123-K-456", new Date(), new Date(), vozilo, osoba);
		
		assertTrue(reg.create(r));
	}
	@Test
	public void testGet(){
		assertNotNull(reg.get(1));
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
		Vozilo vozilo =vd.get(65);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1464);
		Registracija r=new Registracija(100, "123-B-456", new Date(), new Date(), vozilo, osoba);
		
		ArrayList<Registracija> registracije=reg.getAll();
		for(Registracija regist: registracije){
			if(regist.getRegistarskaOznaka().equals("A23-M-459"))
				assertTrue(reg.update(regist.getId(), r));
		}
	}
	@Test
	public void testDelete(){
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(2);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1);
		Registracija r=new Registracija(100, "A23-M-459", new Date(), new Date(), vozilo, osoba);
		reg.create(r);
		
		ArrayList<Registracija> registracije=reg.getAll();
		for(Registracija regist: registracije){
			if(regist.getRegistarskaOznaka().equals("A23-M-459"))
				assertTrue(reg.delete(regist.getId()));
		}
	}
	
}
