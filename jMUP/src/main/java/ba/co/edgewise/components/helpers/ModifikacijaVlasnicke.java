package ba.co.edgewise.components.helpers;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.components.VozacModifikacija;
import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Vlasnicka;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class ModifikacijaVlasnicke{

	SalterskiRadnikView view;
	OsobaDAO oDAO = new OsobaDAO();
	VoziloDAO vDAO = new VoziloDAO();
	Vlasnicka vlasnicka;

	public ModifikacijaVlasnicke(SalterskiRadnikView view) {
		super();
		this.view = view;
	}
	
	public boolean modificirajVlasnicku(){
		VozacModifikacija tmp = view.getStrana14();
		tmp.postaviVozaca();
		vlasnicka.setVlasnik(tmp.getVozac());
		
		VoziloModifikacija tmp2 = view.getStrana15();
		tmp2.postaviVozilo();
		vlasnicka.setVozilo(tmp2.getVozilo());
		if(provjeriPopunjenostVozaca()==true && provjeriPopunjenostUnosVozila()==true ){
			if (oDAO.update(vlasnicka.getVlasnik().getId(), vlasnicka.getVlasnik()) &&
					vDAO.update(vlasnicka.getVozilo().getId(), vlasnicka.getVozilo())){
				JOptionPane.showOptionDialog(view, "Vlasnička uspje\u0161no modifikovana.",
						"Modifikovanje vlasničke", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return true;
			}
			else{
				JOptionPane.showOptionDialog(view, "Unesite ispravno parametre.",
						"Modifikovanje vlasničke", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			}
		}
		return false;
	}
	
	public boolean provjeriPopunjenostVozaca() {
		String ip = "^[A-z]+$";
		String ipn="^[A-zšđžčćŠĐŽČĆ]+$";
		if (!vlasnicka.getVlasnik().getIme().matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Ime se mora sastojati samo od slova.", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		if (!vlasnicka.getVlasnik().getPrezime().matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Prezime se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		String[] part = vlasnicka.getVlasnik().getPrebivaliste().split(" ");
		
		if (!part[0].matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Op\u0107ina se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if (!part[1].matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Mjesto se mora sastojati samo od slova.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		
		
		if (!part[2]
				.matches("^[a-zA-Z0-9šđžčćŠĐŽČĆ]+"
						+ "\\s?[a-zA-Z0-9šđžčćŠĐŽČĆ]+$")) {
			JOptionPane.showOptionDialog(view,
					"Neispravna adresa. Primjer unosa: \"Adresa 54\".",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if (vlasnicka.getVlasnik().isPravnoLice()==false && 
				!vlasnicka.getVlasnik().getJmbg_Id()
						.matches("^(\\d{13})$")) {
			JOptionPane.showOptionDialog(view,
					"JMBG se mora sastojati od 13 cifara", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		// jmbg
		if (vlasnicka.getVlasnik().isPravnoLice()==false && 
				vlasnicka.getVlasnik().getJmbg_Id()
						.matches("^(\\d{13})$")) {
			String _jmbg = vlasnicka.getVlasnik().getJmbg_Id();
			char[] jmbgNiz = _jmbg.toCharArray();

			// provjerava godinu rodjenja
			char[] niz = new char[3];
			_jmbg.getChars(4, 7, niz, 0);

			int year = Calendar.getInstance().get(Calendar.YEAR);
			int pomGodina = 100 * (Character.getNumericValue(niz[0])) + 10
					* (Character.getNumericValue(niz[1]))
					+ Character.getNumericValue(niz[2]);
			if (niz[0] == '0') {
				pomGodina += 2000;
			} else
				pomGodina += 1000;
			if (pomGodina < 1900) {
				JOptionPane
						.showOptionDialog(
								view,
								"Unesena godina rodjenja ne moze biti manja od 1900 godine.",
								"Unos jmbg", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
				return false;
			} else if (pomGodina > year) {
				JOptionPane
						.showOptionDialog(
								view,
								"Unesena godina rodjenja ne moze biti veca od tekuce godine.",
								"Unos jmbg", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
				return false;
			}
			// provjerava mjesec rodjenja
			char[] m_niz = new char[2];
			_jmbg.getChars(2, 4, m_niz, 0);
			int pomMjesec = 10 * Character.getNumericValue(m_niz[0])
					+ Character.getNumericValue(m_niz[1]);
			if (pomMjesec < 1 || pomMjesec > 12) {
				JOptionPane
						.showOptionDialog(
								view,
								"Uneseni mjesec rodjenja nema ispravnu vrijednost(treca i cetvrta cifra).",
								"Unos jmbg", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
				return false;
			}
			// provjerava da li je godina prestupna
			int[] dani = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (((pomGodina % 4) == 0)
					&& (((pomGodina % 100) != 0) || ((pomGodina % 400) == 0)))
				dani[1] = 29;
			// provjerava dan rodjenja
			char[] d_niz = new char[2];
			_jmbg.getChars(0, 2, d_niz, 0);
			int pomDan = 10 * Character.getNumericValue(d_niz[0])
					+ Character.getNumericValue(d_niz[1]);
			if (pomDan > dani[pomMjesec - 1] || pomDan < 1) {
				JOptionPane
						.showOptionDialog(
								view,
								"Uneseni dan rodjenja nema ispravnu vrijednost(prva i druga cifra).",
								"Unos jmbg", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
				return false;
			}

			// kontrolni zbir
			int zbir = 0;
			for (int i = 0; i < 6; i++)
				zbir += (7 - i)
						* (Character.getNumericValue(jmbgNiz[i]) + Character
								.getNumericValue(jmbgNiz[6 + i]));
			int ostatak = zbir % 11;
			int razlika = 11 - ostatak;
			// kontrola
			if (ostatak == 1) {
				JOptionPane.showOptionDialog(view,
						"Uneseni maticni broj nije ispravan. Ostatak=1.",
						"Unos jmbg", JOptionPane.OK_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Uredu" }, "default");
				return false;
			} else if (ostatak == 0) // ako je ostatak=0 i kontrolna cifra =0,
										// maticni ispravan
			{
				if (Character.getNumericValue(jmbgNiz[12]) != 0)
					JOptionPane
							.showOptionDialog(
									view,
									"Uneseni maticni broj nije ispravan. Ostatak=0, kontrolna cifra!=0.",
									"Unos jmbg", JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Uredu" }, "default");
				return false;
			} else if (razlika != Character.getNumericValue(jmbgNiz[12])) {
				JOptionPane
						.showOptionDialog(
								view,
								"Uneseni maticni broj nije ispravan. razlika!=kontrolna cifra.",
								"Unos jmbg", JOptionPane.OK_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Uredu" }, "default");
				return false;
			}
		}
		if (vlasnicka.getVlasnik().isPravnoLice()==true && 
				!vlasnicka.getVlasnik().getJmbg_Id().matches("^\\d+$")) {
			JOptionPane.showOptionDialog(view,
					"ID se mora sastojati od cifara", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else
			return true;

	}
	
	public boolean provjeriPopunjenostUnosVozila() {
		String ip = "^[A-z]+$";
		String no = "^\\d+$";
		String ipn= "^[A-zšđžčćŠĐŽČĆ]+$";

		//if (!view.getVoziloDodavanje().getTf_tipVozila().getText().matches(ipn)) {
		if(!vlasnicka.getVozilo().getTip().matches(ipn)){
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli tip vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!vlasnicka.getVozilo().getModel()
				.matches("^[a-zA-Z0-9šđžčćŠĐŽČĆ]+$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli model vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!vlasnicka.getVozilo().getMarka()
				.matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli marku vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getGodinaProizvodnje()).matches("^(\\d{4})$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli godinu proizvodnje vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Double.toString(vlasnicka.getVozilo().getOdnosSnageIMase())
				.matches("^[0-9]+\\.?[0-9]*$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli odnos snage i mase vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getBrojMjestaZaSjedenje())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za sjedenje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getBrojMjestaZaStajanje())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za stajanje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getBrojMjestaZaLezanje())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj mjesta za lezanje.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!vlasnicka.getVozilo().getOblikKaroserije()
				.matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli karoseriju za vozilo.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!vlasnicka.getVozilo().getBrojSasije()
				.matches("^[a-zA-Z0-9šđžčćŠĐŽČĆ]+$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj  \u0161asije vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getMotor().getZapreminaMotora())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre \u0161no ste unijeli zapreminu motora.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getMotor().getMaxSnaga())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli max snagu motora.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!vlasnicka.getVozilo().getMotor().getBrojMotora()
				.matches("^[a-zA-Z0-9]+$")) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli broj motora.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} /*else if (!Integer.toString(vlasnicka.getVozilo().
				.matches(ipn)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli boju vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
			
		} */else if (!Integer.toString(vlasnicka.getVozilo().getMaxTehnickaDozvoljenaMasa())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli max dozvoljenu masu vozila.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getMasaVozila())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli masu vozila.", "Unos vozila",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		} else if (!Integer.toString(vlasnicka.getVozilo().getDopustenaNosivost())
				.matches(no)) {
			JOptionPane.showOptionDialog(view,
					"Pogre\u0161no ste unijeli dopustivu nosivost za vozilo.",
					"Unos vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}

		Date d = new Date();
		if (vlasnicka.getVozilo().getGodinaProizvodnje() <= 1900
				&& vlasnicka.getVozilo().getGodinaProizvodnje() > d.getYear()) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validnu godinu.", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		/*
		java.util.Date pregled = (java.util.Date) this.view
				.getVoziloDodavanje().getDatePickerDatumPregleda().getModel()
				.getValue();

		if (pregled.after(d)) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validan datum pregleda.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		*/
		if(vlasnicka.getVozilo().getDatumPregleda().before(d)){
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validan datum pregleda.",
					"Unos voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			return false;
		}
		if(!vlasnicka.getVozilo().getRegOznaka()
				.matches("^\\d{3}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")
				&& !vlasnicka.getVozilo().getRegOznaka()
						.matches(
								"^[AEJKMTO]{1}\\d{2}[-]{1}[AEJKMTO]{1}[-]{1}\\d{3}$")) {
			JOptionPane.showOptionDialog(view,
					"Morate unijeti validnu registraciju.", "Unos voza\u010Da",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, new String[] { "Uredu" }, "default");
			return false;
		}
		return true;
	}

	public Vlasnicka getVlasnicka() {
		return vlasnicka;
	}

	public void setVlasnicka(Vlasnicka vlasnicka) {
		this.vlasnicka = vlasnicka;
	}
	
	 
}
