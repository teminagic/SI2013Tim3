package ba.co.edgewise.components.helpers;

import javax.swing.JOptionPane;

import ba.co.edgewise.jmup.components.VozacModifikacija;
import ba.co.edgewise.jmup.daldao.daos.OsobaDAO;
import ba.co.edgewise.jmup.mvc.views.SalterskiRadnikView;

public class ModifikacijaVozaca {

	SalterskiRadnikView view;
	OsobaDAO oDAO = new OsobaDAO();

	public ModifikacijaVozaca(SalterskiRadnikView view) {
		super();
		this.view = view;
	}
	
	public void modificirajVozaca(){
		VozacModifikacija tmp = view.getStrana11();
		tmp.postaviVozaca();
		
		if (oDAO.update(tmp.getVozac().getId(), tmp.getVozac())){
			JOptionPane.showOptionDialog(view, "Voza\u010D uspje\u0161no modifikovan.",
					"Modifikovanje voza\u010Da", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
		}
	}

}
