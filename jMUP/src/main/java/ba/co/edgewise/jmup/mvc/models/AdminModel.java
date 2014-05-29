package ba.co.edgewise.jmup.mvc.models;

import java.util.ArrayList;

import ba.co.edgewise.jmup.daldao.daos.UposlenikDAO;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;
import ba.co.edgewise.jmup.klase.Uposlenik;

public class AdminModel {
	private Uposlenik uposlenik;
	private UposlenikDAO uDAO = new UposlenikDAO();
	
	public Boolean kreiranjeKorisnika(){
		return uDAO.create(uposlenik);
	}
	public ArrayList<Uposlenik> dohvatiSveUsere() {
		return uDAO.getAll();
	}
	
	public ArrayList<Uposlenik> dohvatiUserePretraga(String kriterij, TipPretrageUposlenika tip){
		ArrayList<Uposlenik> result = new ArrayList<Uposlenik>();
		switch (tip){
		case IME:
			ArrayList<Uposlenik> tmp1 = uDAO.getAllByIme(kriterij);
			return (tmp1==null)?result:tmp1;
		case PREZIME:
			ArrayList<Uposlenik> tmp2 = uDAO.getAllByPrezime(kriterij);
			return (tmp2==null)?result:tmp2;
		case USERNAME:
			result.add(uDAO.get(kriterij));
			return result;
		}
		return result;
	}
	
	public Uposlenik getUposlenik() {
		return uposlenik;
	}

	public void setUposlenik(Uposlenik uposlenik) {
		this.uposlenik = uposlenik;
	}
}
