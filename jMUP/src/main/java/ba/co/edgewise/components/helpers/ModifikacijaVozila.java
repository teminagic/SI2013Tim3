package ba.co.edgewise.components.helpers;

import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.components.VoziloModifikacija;
import ba.co.edgewise.jmup.daldao.daos.BojeVozilaDAO;
import ba.co.edgewise.jmup.daldao.daos.VoziloDAO;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class ModifikacijaVozila {
	
	SalterskiRadnikView view;
	VoziloDAO vDAO = new VoziloDAO();
	BojeVozilaDAO bvDAO = new BojeVozilaDAO();
	
	
	
	public ModifikacijaVozila(SalterskiRadnikView view) {
		super();
		this.view = view;
	}

	public void modificirajVozilo(){
		VoziloModifikacija tmp = view.getVoziloModifikacija();
		tmp.postaviVozilo();
		
		if (vDAO.update(tmp.getVozilo().getId(), tmp.getVozilo()) && 
				bvDAO.update(tmp.getBoja().getId(), tmp.getBoja())){
			JOptionPane.showOptionDialog(view, "Vozilo uspješno modifikovano.",
					"Modifikovanje vozila", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
		}
	}

}
