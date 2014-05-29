package ba.co.edgewise.jmup.mvc.models;

import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class AdminModel {
	private Uposlenik uposlenik;
	private UposlenikDAO uDAO;
	
	public Boolean kreiranjeKorisnika(){
		uDAO = new UposlenikDAO();
		return uDAO.create(uposlenik);
	}
	
	public Uposlenik getUposlenik() {
		return uposlenik;
	}

	public void setUposlenik(Uposlenik uposlenik) {
		this.uposlenik = uposlenik;
	}
}
