package co.ba.edgewise.jmup.mvc.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.TipUposlenika;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.mvc.models.LoginModel;

public class LoginModelTest {

	LoginModel lm;
	UposlenikDAO uDAO;
	@Before
	public void setUp(){
		lm=new LoginModel();
		uDAO=new UposlenikDAO();
		lm.setuDAO(uDAO);
	}
	@Test
	public void testProvjeriValidnePodatke() {
		assertTrue(lm.provjeriPodatke("boss", "boss"));
	}
	@Test
	public void testProvjeriNevalidnePodatke() {
		assertFalse(lm.provjeriPodatke("amra", "boss"));
	}

}
