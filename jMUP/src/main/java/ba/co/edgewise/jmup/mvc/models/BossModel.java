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
			// iako dobijam samo 1 osobu zbog povratne vrijednosti metode vracam listu (da sve svedem na jednu metodu)
			ArrayList<Osoba> o2 = new ArrayList<>(); 
			o2.add(_osobaDAO.getByJMBG(parametar));
			return (o2 == null) ? null : o2;
		}
		return null;
	}
	
	public ArrayList<Saobracajna> pretragaSaobracajna ( String parametar, String kriterij ) {
		
		switch(kriterij){
		//fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to optimizujem
		//logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
		String [] ip = parametar.split(" ");
		ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
		ArrayList<Saobracajna> s1 = new ArrayList<>();
		for (Osoba osoba : temp) {
			s1.add(_saobracajnaDAO.getByName(osoba.getId()));
		}
		return (s1 == null) ? null : s1;

		//vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
		Vozilo vt = _voziloDAO.getByReg(parametar);
		ArrayList<Saobracajna> s2 = new ArrayList<>();
		s2.add(_saobracajnaDAO.getByReg(vt.getId()));
		return (s2 == null) ? null : s2;
		
		case "JMBG":
		Osoba o = _osobaDAO.getByJMBG(parametar);
		ArrayList<Saobracajna> s3 = new ArrayList<>();
		s3.add(_saobracajnaDAO.getByName(o.getId()));	
		return (s3 == null) ? null : s3;
		
		case "Broj potvrde":
		ArrayList<Saobracajna> s4 = _saobracajnaDAO.getByPotvrda(parametar);
		return (s4 == null) ? null : s4;
		}
				
		return null;
	}
	
	

	public static void main(String[] args) {
		BossModel b = new BossModel();
		ArrayList<Vozilo> v = new ArrayList<>();
		ArrayList<Osoba> o = new ArrayList<>();
		ArrayList<Saobracajna> s = new ArrayList<>();

		//v = b.pretragaVozilo("BMW","Marka vozila");
		//o = b.pretragaVozac("Dervic", "Prezime");
		s = b.pretragaSaobracajna( "b" , "JMBG");
		
	}

}