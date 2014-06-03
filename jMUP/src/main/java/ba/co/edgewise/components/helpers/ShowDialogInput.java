package ba.co.edgewise.components.helpers;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import ba.co.edgewise.jmup.mvc.models.*;

import java.awt.event.*;
import java.io.File;
import java.text.ParseException;

public class ShowDialogInput {
	 private BossModel b;

	 public ShowDialogInput(String text, Integer tip) throws ParseException
	 {	
		 if(tip == 1)
		 {
			 	filePickerReg();
		 
		 }
		 else
		 {
			 	filePickerBr();
		 }
	
	 }
	 
	  public void filePickerReg()
	 {
		  JFileChooser fileChooser=new JFileChooser("C:/");	
		  fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		  fileChooser.setFileFilter(filter);
		  int returnValue = fileChooser.showSaveDialog(null);
		  if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          String path =selectedFile.getAbsolutePath() + ".pdf";
	          b = new BossModel();
	          boolean success;
	 		  try {
				success = b.ekstraktToPDF(b.getIstekleRegistracije(), path);
				if(success)
		 			  JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran ", "jMUP", 1);
		 		  else
		 			  JOptionPane.showMessageDialog(null, "Doslo je do greske, provjerite lokaciju za snimanje da nije zasticena", "jMUP", 1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 			  JOptionPane.showMessageDialog(null, "Doslo je do greske, provjerite lokaciju za snimanje da nije zasticena", "jMUP", 1);

			}
	 		 
	          
	        }
		  
	 }
	  
	 public void filePickerBr()
	 {
		 JFileChooser fileChooser=new JFileChooser("C:/");	
		  fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		  fileChooser.setFileFilter(filter);
		  int returnValue = fileChooser.showSaveDialog(null);
		  if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          String path =selectedFile.getAbsolutePath() + ".pdf";
	          b = new BossModel();
	          boolean success;
	 		  success = b.ekstraktToPDF(b.getBrojDozvola(), path);
	 		  if(success)
				  JOptionPane.showMessageDialog(null, "Izvjestaj je kreiran ", "jMUP", 1);
			  else
				  JOptionPane.showMessageDialog(null, "Doslo je do greske, provjerite lokaciju za snimanje da nije zasticena", "jMUP", 1);
	 		  

	        }
	 }
}











