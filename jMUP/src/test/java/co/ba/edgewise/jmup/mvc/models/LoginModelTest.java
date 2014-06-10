package co.ba.edgewise.jmup.mvc.models;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		assertTrue(lm.provjeriPodatke("boss", getMD5("Boss1")));
	}
	@Test
	public void testProvjeriNevalidnePodatke() {
		assertFalse(lm.provjeriPodatke("amra", "boss"));
	}
	
	public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
