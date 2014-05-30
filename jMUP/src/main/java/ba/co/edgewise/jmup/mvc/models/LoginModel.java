package ba.co.edgewise.jmup.mvc.models;

import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class LoginModel {
	private Uposlenik uposlenik;
	private UposlenikDAO uDAO;
	
	public Uposlenik getUposlenik() {
		return uposlenik;
	}
	public void setUposlenik(Uposlenik uposlenik) {
		this.uposlenik = uposlenik;
	}
	public UposlenikDAO getuDAO() {
		return uDAO;
	}
	public void setuDAO(UposlenikDAO uDAO) {
		this.uDAO = uDAO;
	}
	
	public Boolean provjeriPodatke(String korisnickoIme, String korisnickaSifra){
		Boolean result = false;
		
		uDAO = new UposlenikDAO();
		uposlenik = uDAO.get(korisnickoIme);
		
		if (uposlenik != null)
		{
			if (uposlenik.getPassword().equals(korisnickaSifra))
				result=true;
		}
		
		return result;
	}
}
