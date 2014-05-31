package ba.co.edgewise.jmup.mvc.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.daldao.daos.*;

import java.awt.Color;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.codec.Base64.OutputStream;


public class BossModel {

	private VlasnickaDAO _vlasnickaDAO;
	private SaobracajnaDAO _saobracajnaDAO;
	private VoziloDAO _voziloDAO;
	private OsobaDAO _osobaDAO;
	private MotorDAO _motorDAO;

	public BossModel() {
		_vlasnickaDAO = new VlasnickaDAO();
		_saobracajnaDAO = new SaobracajnaDAO();
		_voziloDAO = new VoziloDAO();
		_osobaDAO = new OsobaDAO();
		_motorDAO = new MotorDAO();
	}

	public ArrayList<Vozilo> pretragaVozilo(String parametar, String kriterij) {

		switch (kriterij) {
		case "Registarska oznaka":
			ArrayList<Vozilo> v = new ArrayList<Vozilo>();
			Vozilo v1 = _voziloDAO.getByReg(parametar);
			v.add(v1);
			return (v == null) ? null : v;
		case "Godina proizvodnje":
			ArrayList<Vozilo> v2 = _voziloDAO.getByDate(Integer
					.parseInt(parametar));
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

	public ArrayList<Osoba> pretragaVozac(String parametar, String kriterij) {

		switch (kriterij) {
		case "Ime":
			ArrayList<Osoba> o = _osobaDAO.getByIme(parametar);
			return (o == null) ? null : o;
		case "Prezime":
			ArrayList<Osoba> o1 = _osobaDAO.getByPrezime(parametar);
			return (o1 == null) ? null : o1;
		case "JMBG":
			// iako dobijam samo 1 osobu zbog povratne vrijednosti metode vracam
			// listu (da sve svedem na jednu metodu)
			ArrayList<Osoba> o2 = new ArrayList<>();
			o2.add(_osobaDAO.getByJMBG(parametar));
			return (o2 == null) ? null : o2;
		}
		return null;
	}

	public ArrayList<Saobracajna> pretragaSaobracajna(String parametar,
			String kriterij) {

		switch (kriterij) {
		// fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to
		// optimizujem
		// logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
			String[] ip = parametar.split(" ");
			ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
			ArrayList<Saobracajna> s1 = new ArrayList<>();
			for (Osoba osoba : temp) {
				s1.add(_saobracajnaDAO.getByName(osoba.getId()));
			}
			return (s1 == null) ? null : s1;

			// vraca Array i ako ima samo 1 result zbog povratnog tipa metode
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

	public ArrayList<Vlasnicka> pretragaVlasnicka(String parametar,
			String kriterij) {

		switch (kriterij) {
		// fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to
		// optimizujem
		// logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
			String[] ip = parametar.split(" ");
			ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
			ArrayList<Vlasnicka> vl1 = new ArrayList<>();
			for (Osoba osoba : temp) {
				vl1.add(_vlasnickaDAO.getByVlasnik(osoba.getId()));
			}
			return (vl1 == null) ? null : vl1;

			// vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
			Vozilo vt = _voziloDAO.getByReg(parametar);
			ArrayList<Vlasnicka> vl2 = new ArrayList<>();
			vl2.add(_vlasnickaDAO.getByVozilo(vt.getId()));
			return (vl2 == null) ? null : vl2;

		case "JMBG":
			Osoba o = _osobaDAO.getByJMBG(parametar);
			ArrayList<Vlasnicka> vl3 = new ArrayList<>();
			vl3.add(_vlasnickaDAO.getByVlasnik(o.getId()));
			return (vl3 == null) ? null : vl3;

		case "Broj potvrde":
			ArrayList<Vlasnicka> vl4 = new ArrayList<>();
			vl4.add(_vlasnickaDAO.get(parametar));
			return (vl4 == null) ? null : vl4;
		}

		return null;
	}

	public Motor getMotorByVozilo(Integer id) {
		Vozilo temp = _voziloDAO.get(id);
		return (temp == null) ? null : temp.getMotor();
	}

	@SuppressWarnings("deprecation")
	public void ekstraktToPDF(ArrayList<String> podaci, String path) {
		try { 
			@SuppressWarnings("deprecation")
			
			FileOutputStream file = new FileOutputStream(new File(path));
			 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
 
            document.open();
            document.add(new Paragraph("Izvještaj " +  new Date().getDate() + "." + new Date().getMonth() + "." + new Date().getYear()));
            for ( String s : podaci) {
            	document.add(new Paragraph(s.toString()));
			}
          
            document.close();
            file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean modifikacijaVozilo(ArrayList<Vozilo> kolekcija)
	{
		
	}
	

	public static void main(String[] args) {

		BossModel b = new BossModel();
		ArrayList<Vozilo> v = new ArrayList<>();
		ArrayList<Osoba> o = new ArrayList<>();
		ArrayList<Saobracajna> s = new ArrayList<>();
		ArrayList<Vlasnicka> vl = new ArrayList();
		ArrayList<String> pdf = new ArrayList<String>();
		pdf.add("Vlasnik Kemo je bio kuci");
		pdf.add("Vlasnik Kemo je bio kuci2");
		pdf.add("Vlasnik Kemo je bio kuci3"); 
		pdf.add("Vlasnik Kemo je bio kuci4");
		// vl = b.pretragaVlasnicka("s", "JMBG");
		// v = b.pretragaVozilo("BMW","Marka vozila");
		// o = b.pretragaVozac("Dervic", "Prezime");
		 s = b.pretragaSaobracajna( "Amra Dervic" , "Ime i prezime");
		//b.ekstraktToPDF(pdf);

	}

}
