package ba.co.edgewise.jmup.mvc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.daldao.daos.*;

public class BossModel {
	
	private VlasnickaDAO _vlasnickaDAO;
	private SaobracajnaDAO _saobracajnaDAO;
	private VoziloDAO _voziloDAO;
	private OsobaDAO _osobaDAO;
	
	
	public BossModel() {
		_vlasnickaDAO = new VlasnickaDAO();
		_saobracajnaDAO = new SaobracajnaDAO();
		_voziloDAO = new VoziloDAO();
		_osobaDAO = new OsobaDAO();
	}
	
	public ArrayList<Vozilo> pretragaVozilo( String parametar, String kriterij ) {
		
		switch (kriterij){
		case "Registarska oznaka":
			ArrayList<Vozilo> v = new ArrayList<Vozilo>();
			Vozilo v1 = _voziloDAO.getByReg(parametar);
			v.add(v1);
			return (v == null) ? null : v;
		case "Godina proizvodnje":
			ArrayList<Vozilo> v2 = _voziloDAO.getByDate(Integer.parseInt(parametar));
			return (v2 == null) ? null : v2;
		case "Vrsta vozila":
			ArrayList<Vozilo> v3 = _voziloDAO.getByType(parametar);
			return (v3 == null) ? null : v3;
		case "Marka vozila":
			ArrayList<Vozilo> v4 = _voziloDAO.getByMark(parametar);
			return (v4 == null) ? null : v4;
		}
		
		return null;
	}
	
	public ArrayList<Osoba> pretragaVozac( String parametar, String kriterij ) {
		
		switch(kriterij){
		case "Ime":
			ArrayList<Osoba> o = _osobaDAO.getByIme(parametar);
			return (o == null) ? null : o;
		case "Prezime":
			ArrayList<Osoba> o1 = _osobaDAO.getByPrezime(parametar);
			return (o1 == null) ? null : o1;
		case "JMBG":
			ArrayList<Osoba> o2 = _osobaDAO.getByJMBG(parametar);
			return (o2 == null) ? null : o2;
		}
		return null;
	}
	
	public ArrayList<Saobracajna> pretragaSaobracajna ( String parametar, String kriterij ) {
		
				
		return null;
	}
	
	

	public static void main(String[] args) {
		BossModel b = new BossModel();
		ArrayList<Vozilo> v = new ArrayList<>();
		ArrayList<Osoba> o = new ArrayList<>();

		//v = b.pretragaVozilo("BMW","Marka vozila");
		o = b.pretragaVozac("Dervic", "Prezime");
	}

}
