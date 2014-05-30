package co.ba.edgewise.jmup.daldao;

import static org.junit.Assert.*;

import java.util.List;

import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.enums.*;

import org.junit.Test;

public class UposlenikDAOTest {

	UposlenikDAO upoDAO = new UposlenikDAO();
	
	@Test
	public void testCreate() {
		Uposlenik u = new Uposlenik(17, "Amar", "Asotic", "aasotic","aasotic", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		upoDAO.create(u);
		assertNotNull(upoDAO.get(17));
	}

	@Test
	public void testGetInteger() {
		assertNotNull(upoDAO.get(17));
	}

	@Test
	public void testGetString() {
		assertNotNull(upoDAO.get("Amar"));
	}

	@Test
	public void testGetAll() {
		List<Uposlenik> uposlenici=upoDAO.getAll();
		for(int i=0; i<uposlenici.size(); i++)
			assertNotNull(upoDAO.get(uposlenici.get(i).getId()));
	}

	@Test
	public void testGetAllByIme() {
		assertNotNull(upoDAO.getAllByIme("Amar"));
	}

	@Test
	public void testGetAllByPrezime() {
		assertNotNull(upoDAO.getAllByPrezime("Asotic"));
	}

	@Test
	public void testUpdate() {
		Uposlenik u = new Uposlenik(17, "Amar", "Asotic", "aasotic","aasotic", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		upoDAO.create(u);
		assertTrue(upoDAO.update(17, u));
	}

	@Test
	public void testDelete() {
		Uposlenik u = new Uposlenik(21, "Amar2", "Asotic2", "aasotic","aasotic", Status.AKTIVAN, TipUposlenika.ADMINISTRATOR);
		upoDAO.create(u);
		assertTrue(upoDAO.delete(21));
	}

}
