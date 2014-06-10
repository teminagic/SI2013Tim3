package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.List;

import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Osoba;
import ba.co.edgewise.jmup.klase.Vozilo;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.daldao.daos.SaobracajnaDAO;

import org.junit.Test;

public class SaobracajnaDAOTest {

	SaobracajnaDAO saDAO = new SaobracajnaDAO();
	
	@Test
	public void testCreate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(2);
		Saobracajna sa = new Saobracajna("188", vozilo, osoba);
		assertTrue(saDAO.create(sa));
	}

	@Test
	public void testGet() {
		assertNotNull(saDAO.get("188"));
	}

	@Test
	public void testGetAll() {
		List<Saobracajna> saobracajne=saDAO.getAll();
		for(int i=0; i<saobracajne.size(); i++)
			assertNotNull(saDAO.get(saobracajne.get(i).getBrojDozvole()));
	}

	@Test
	public void testGetByPotvrda() {
		assertNotNull(saDAO.getByPotvrda("188"));
	}

	@Test
	public void testGetByName() {
		assertNotNull(saDAO.getByName(1));
	}

	@Test
	public void testGetByReg() {
		assertNotNull(saDAO.getByReg(1));
	}

	@Test
	public void testUpdate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(1);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1);
		Saobracajna sa = new Saobracajna("174343", vozilo, osoba);
		//vlDAO.create(vl);
		assertTrue(saDAO.update("188", sa));
	}

	@Test
	public void testDelete() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(2);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1);
		Saobracajna vl = new Saobracajna("21", vozilo, osoba);
		saDAO.create(vl);
		assertTrue(saDAO.delete("21"));
	}

}
