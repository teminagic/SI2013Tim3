package ba.co.edgewise.jmup.mvc.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.daldao.daos.*;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.codec.Base64.OutputStream;


public class BossModel {

	private VlasnickaDAO _vlasnickaDAO;
	private SaobracajnaDAO _saobracajnaDAO;
	private VoziloDAO _voziloDAO;
	private OsobaDAO _osobaDAO;
	private MotorDAO _motorDAO;
	private RegistracijaDAO _regDao;
	private LogDAO _logDAO = new LogDAO();

	public BossModel() {
		_vlasnickaDAO = new VlasnickaDAO();
		_saobracajnaDAO = new SaobracajnaDAO();
		_voziloDAO = new VoziloDAO();
		_osobaDAO = new OsobaDAO();
		_motorDAO = new MotorDAO();
		_regDao = new RegistracijaDAO();
	}
	public ArrayList<Vozilo> dohvatiSvaVozila() {
		return (ArrayList<Vozilo>) _voziloDAO.getAll();
	}
	public ArrayList<Osoba> dohvatiSveVozace() {
		return (ArrayList<Osoba>) _osobaDAO.getAll();
	}
	public ArrayList<Saobracajna> dohvatiSveSaobracajne() {
		return (ArrayList<Saobracajna>) _saobracajnaDAO.getAll();
	}
	public ArrayList<Vlasnicka> dohvatiSveVlasnicke() {
		return (ArrayList<Vlasnicka>) _vlasnickaDAO.getAll();
	}

	// deaktivacija
	public Boolean brisanjeVozila(Vozilo vozilo){
		return _voziloDAO.delete(vozilo.getId());
	}
	public Boolean brisanjeVozaca(Osoba osoba){
		return _osobaDAO.delete(osoba.getId());
	}
	public Boolean brisanjeVlasnicke(Vlasnicka vlasnicka){
		return _vlasnickaDAO.delete(vlasnicka.getBrojDozvole());
	}
	public Boolean brisanjeS(Vozilo vozilo){
		return _voziloDAO.delete(vozilo.getId());
	}

public ArrayList<Vozilo> pretragaVozilo( String parametar, String kriterij ) {
		
		switch (kriterij){
			case "Registarska oznaka":
				ArrayList<Vozilo> v = new ArrayList<Vozilo>();;
				Vozilo v1 = _voziloDAO.getByReg(parametar);
				if(v1 == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				v.add(v1);
				return (v == null) ? null : v;
			case "Godina proizvodnje":
				ArrayList<Vozilo> v2 = _voziloDAO.getByDate(Integer.parseInt(parametar));
				if(v2 == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				return (v2 == null) ? null : v2;
			case "Vrsta vozila":
				ArrayList<Vozilo> v3 = _voziloDAO.getByType(parametar);
				if(v3 == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				return (v3 == null) ? null : v3;
			case "Marka vozila":
				ArrayList<Vozilo> v4 = _voziloDAO.getByMark(parametar);
				if(v4 == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				return (v4 == null) ? null : v4;
			}
		
		return null;
	}
	
	public ArrayList<Osoba> pretragaVozac( String parametar, String kriterij ) {
		
		switch(kriterij){
			case "Ime":
				ArrayList<Osoba> o = _osobaDAO.getByIme(parametar);
				if(o == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				return (o == null) ? null : o;
			case "Prezime":
				ArrayList<Osoba> o1 = _osobaDAO.getByPrezime(parametar);
				if(o1 == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
				return (o1 == null) ? null : o1;
			case "JMBG":
				// iako dobijam samo 1 osobu zbog povratne vrijednosti metode vracam listu (da sve svedem na jednu metodu)
				ArrayList<Osoba> o2 = new ArrayList<>(); 
				o2.add(_osobaDAO.getByJMBG(parametar));
				if(o2.get(0) == null)
					JOptionPane.showMessageDialog(null, "Nema rezultata");
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
			if(temp == null){
				JOptionPane.showMessageDialog(null, "Nema rezultata");
				return null;
			}
			ArrayList<Saobracajna> s1 = new ArrayList<>();
			for (Osoba osoba : temp) {
				s1.add(_saobracajnaDAO.getByName(osoba.getId()));
			}
			return (s1 == null) ? null : s1;
	
			//vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
			Vozilo vt = _voziloDAO.getByReg(parametar);
			if(vt == null){
				JOptionPane.showMessageDialog(null, "Nema rezultata");
				return null;
			}
			ArrayList<Saobracajna> s2 = new ArrayList<>();
			s2.add(_saobracajnaDAO.getByReg(vt.getId()));
			return (s2 == null) ? null : s2;
		
		case "JMBG vozača":
			Osoba o = _osobaDAO.getByJMBG(parametar);
			if(o == null)
			{
				JOptionPane.showMessageDialog(null, "Nema rezultata");
				return null;
			}
			ArrayList<Saobracajna> s3 = new ArrayList<>();
			s3.add(_saobracajnaDAO.getByName(o.getId()));	
			return (s3 == null) ? null : s3;
			
		case "Broj potvrde":
			ArrayList<Saobracajna> s4 = _saobracajnaDAO.getByPotvrda(parametar);
			if(s4 == null)
				JOptionPane.showMessageDialog(null, "Nema rezultata");
			return (s4 == null) ? null : s4;
		}
				
		return null;
	}
	
	public ArrayList<Vlasnicka> pretragaVlasnicka ( String parametar, String kriterij ) {
		
		switch(kriterij){
		//fejlat ce ako se ukuca prezime pa ime ali nemam vremena da to optimizujem
		//logika je lose uradena ali nemma vremena za pametnije
		case "Ime i prezime":
		String [] ip = parametar.split(" ");
		ArrayList<Osoba> temp = _osobaDAO.getByImeiPrezime(ip[0], ip[1]);
		if(temp == null){
			JOptionPane.showMessageDialog(null, "Nema rezultata");
			return null;
		}
		ArrayList<Vlasnicka> vl1 = new ArrayList<>();
		for (Osoba osoba : temp) {
			vl1.add(_vlasnickaDAO.getByVlasnik(osoba.getId()));
		}
		return (vl1 == null) ? null : vl1;

		//vraca Array i ako ima samo 1 result zbog povratnog tipa metode
		case "Registarska oznaka":
		Vozilo vt = _voziloDAO.getByReg(parametar);
		if(vt == null)
		{
			JOptionPane.showMessageDialog(null, "Nema rezultata");
			return null;
		}
		ArrayList<Vlasnicka> vl2 = new ArrayList<>();
		vl2.add(_vlasnickaDAO.getByVozilo(vt.getId()));
		return (vl2 == null) ? null : vl2;
		
		case "JMBG vlasnika":
		Osoba o = _osobaDAO.getByJMBG(parametar);
		if(o == null)
		{
			JOptionPane.showMessageDialog(null, "Nema rezultata");
			return null;
		}
		ArrayList<Vlasnicka> vl3 = new ArrayList<>();
		vl3.add(_vlasnickaDAO.getByVlasnik(o.getId()));	
		return (vl3 == null) ? null : vl3;
		
		case "Broj potvrde":
		ArrayList<Vlasnicka> vl4 = new ArrayList<>();
		vl4.add(_vlasnickaDAO.get(parametar));
		vl4.add(_vlasnickaDAO.get(parametar));
		if(vl4.get(0) == null)
			JOptionPane.showMessageDialog(null, "Nema rezultata");
		return (vl4 == null) ? null : vl4;
		}
				
		return null;
	}


	
	public Motor getMotorByVozilo(Integer id) {
		Vozilo temp = _voziloDAO.get(id);
		return (temp == null) ? null : temp.getMotor();
	}

	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean ekstraktToPDF(ArrayList<String> podaci, String path, String poruka) {
		try { 
			@SuppressWarnings("deprecation")

			FileOutputStream file = new FileOutputStream(new File(path));

            Document document = new Document();
            PdfWriter.getInstance(document, file);
 
            document.open();
            document.addTitle("JMUP");
            document.addSubject("Izvještaj");
            document.addKeywords("Izvještaj JMUP");
            
            
        	document.add(new Paragraph("JMUP"));
            document.add(new Paragraph("Izvjestaj kreiran: " +  new Date().getDate() + "." + new Date().getMonth() + "."));
            document.add(new Paragraph(poruka));
            if(podaci.size() == 0)
            {
            	document.add(new Paragraph("Nema nevazecih tablica"));
            }
            else
            {
            for ( String s : podaci) {
            	document.add(new Paragraph(s.toString()));
			}
            }
            document.close();
            file.close();
            return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//modifikacija
	public boolean modifikacijaVozilo(Integer id, Vozilo v)
	{
		return _voziloDAO.update(id, v);
	}

	public boolean modifikacijaOsoba(Integer id, Osoba o)
	{
		return _osobaDAO.update(id, o);
	}

	public boolean modifikacijaVlasnicka(String brojDozvole, Vlasnicka v)
	{
		return _vlasnickaDAO.update(brojDozvole, v);
	}

	public boolean modifikacijaSaobracajna(String brojDozvole, Saobracajna s)
	{
		return _saobracajnaDAO.update(brojDozvole, s);
	}

	//za izvjestaj podaci
	public ArrayList<String> getIstekleRegistracije() throws ParseException
	{
		//return _voziloDAO.getAllRegistracijeDeaktivirane() ;
		return _regDao.getAllRegistracijeIstekle();
	}

	public ArrayList<String> getBrojDozvola(){

		ArrayList<String> temp = new ArrayList<>();
		temp.add(_saobracajnaDAO.getBrojSaobracajnih());
		temp.add("Broj izdatih vlasnickih: ");
		temp.add(_vlasnickaDAO.getBrojVlasnickih());

		return temp;

	}
	


	public ArrayList<Log> dohvatiLogove(){
		return _logDAO.getAll();
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