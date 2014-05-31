package ba.co.edgewise.components.helpers;

import javax.swing.*;

import ba.co.edgewise.jmup.mvc.models.*;

import java.awt.event.*;
import java.text.ParseException;

public class ShowDialogInput {
	 private BossModel b;
	 
	 public ShowDialogInput(String text, Integer tip) throws ParseException
	 {	
		 if(tip == 1)
		 {
		 b = new BossModel();
		 String str = JOptionPane.showInputDialog(null, text, "jMUP", 1);
		 if(str != null)
		 {
			 b.ekstraktToPDF(b.getIstekleRegistracije(), str);
			 JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran ", 
						"jMUP", 1);
		 }
		 }
		 else
		 {
			 b = new BossModel();
			 String str = JOptionPane.showInputDialog(null, text, "jMUP", 1);
			 if(str != null)
			 {
				 b.ekstraktToPDF(b.getBrojDozvola(), str);
				 JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran ", 
							"jMUP", 1);
			 }
		 }
			 
	 }
}

