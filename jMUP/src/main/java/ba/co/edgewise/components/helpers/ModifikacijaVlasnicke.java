package ba.co.edgewise.components.helpers;

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
	
	public void modificirajVlasnicku(){
		VozacModifikacija tmp = view.getStrana14();
		tmp.postaviVozaca();
		vlasnicka.setVlasnik(tmp.getVozac());
		
		VoziloModifikacija tmp2 = view.getStrana15();
		tmp2.postaviVozilo();
		vlasnicka.setVozilo(tmp2.getVozilo());
		
		if (oDAO.update(vlasnicka.getVlasnik().getId(), vlasnicka.getVlasnik()) &&
				vDAO.update(vlasnicka.getVozilo().getId(), vlasnicka.getVozilo())){
			JOptionPane.showOptionDialog(view, "Vlasnička uspje\u0161no modifikovana.",
					"Modifikovanje vlasničke", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
		}
	}

	public Vlasnicka getVlasnicka() {
		return vlasnicka;
	}

	public void setVlasnicka(Vlasnicka vlasnicka) {
		this.vlasnicka = vlasnicka;
	}
	
	 
}
