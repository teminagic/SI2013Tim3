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
	 //registracije
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
				success = b.ekstraktToPDF(b.getIstekleRegistracije(), path, "Ne vazece registracije su: ");
				if(success)
		 			  JOptionPane.showMessageDialog(null, "Izvje\u0161taj je kreiran ", "jMUP", 1);
		 		  else
		 			  JOptionPane.showMessageDialog(null, "Do\u0161lo je do gre\u0161ke, provjerite lokaciju za snimanje da nije za\u0161ti\u0107ena", "jMUP", 1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 			  JOptionPane.showMessageDialog(null, "Do\u0161lo je do gre\u0161ke, provjerite lokaciju za snimanje da nije za\u0161ti\u0107ena", "jMUP", 1);
	 			
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
	 		  success = b.ekstraktToPDF(b.getBrojDozvola(), path, "Broj izdatih saobracajnih: ");
	 		  if(success)
				  JOptionPane.showMessageDialog(null, "Izvje\u0161taj je kreiran ", "jMUP", 1);
			  else
				  JOptionPane.showMessageDialog(null, "Do\u0161lo je do gre\u0161ke, provjerite lokaciju za snimanje da nije za\u0161ti\u0107ena", "jMUP", 1);
	 		  

	        }
	 }
}











