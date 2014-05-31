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
		Vozilo vozilo =vd.get(65);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352);
		Saobracajna sa = new Saobracajna("17", vozilo, osoba);
		saDAO.create(sa);
		assertNotNull(saDAO.get("17"));
	}

	@Test
	public void testGet() {
		assertNotNull(saDAO.get("17"));
	}

	@Test
	public void testGetAll() {
		List<Saobracajna> saobracajne=saDAO.getAll();
		for(int i=0; i<saobracajne.size(); i++)
			assertNotNull(saDAO.get(saobracajne.get(i).getBrojDozvole()));
	}

	@Test
	public void testGetByPotvrda() {
		assertNotNull(saDAO.getByPotvrda("17"));
	}

	@Test
	public void testGetByName() {
		assertNotNull(saDAO.getByName(17));
	}

	@Test
	public void testGetByReg() {
		assertNotNull(saDAO.getByReg(17));
	}

	@Test
	public void testUpdate() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(67);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352);
		Saobracajna sa = new Saobracajna("17", vozilo, osoba);
		//vlDAO.create(vl);
		assertTrue(saDAO.update("17", sa));
	}

	@Test
	public void testDelete() {
		VoziloDAO vd=new VoziloDAO();
		Vozilo vozilo =vd.get(67);
		OsobaDAO od=new OsobaDAO();
		Osoba osoba=od.get(1352	);
		Saobracajna vl = new Saobracajna("21", vozilo, osoba);
		saDAO.create(vl);
		assertTrue(saDAO.delete("21"));
	}

}
