package ba.co.edgewise.components.helpers;

import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.components.VozacModifikacija;
import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.klase.Saobracajna;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class ModifikacijaSaobracajne{

	SalterskiRadnikView view;
	OsobaDAO oDAO = new OsobaDAO();
	VoziloDAO vDAO = new VoziloDAO();
	Saobracajna saobracajna;

	public ModifikacijaSaobracajne(SalterskiRadnikView view) {
		super();
		this.view = view;
	}
	
	public void modificirajSaobracajnu(){
		VozacModifikacija tmp = view.getStrana12();
		tmp.postaviVozaca();
		saobracajna.setKorisnik(tmp.getVozac());
		
		VoziloModifikacija tmp2 = view.getStrana13();
		tmp2.postaviVozilo();
		saobracajna.setVozilo(tmp2.getVozilo());
		
		if (oDAO.update(saobracajna.getKorisnik().getId(), saobracajna.getKorisnik()) &&
				vDAO.update(saobracajna.getVozilo().getId(), saobracajna.getVozilo())){
			JOptionPane.showOptionDialog(view, "Saobraćajna uspje\u0161no modifikovana.",
					"Modifikovanje saobraćajne", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
		}
	}
	
	public Saobracajna getSaobracajna() {
		return saobracajna;
	}

	public void setSaobracajna(Saobracajna saobracajna) {
		this.saobracajna = saobracajna;
	}
}
