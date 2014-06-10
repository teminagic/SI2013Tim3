package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ba.co.edgewise.jmup.components.KorisnikKreiranje;
import ba.co.edgewise.jmup.daldao.daos.LogDAO;
import ba.co.edgewise.jmup.enums.Status;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;
import ba.co.edgewise.jmup.enums.TipUposlenika;
import ba.co.edgewise.jmup.klase.Log;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.mvc.models.AdminModel;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.views.AdminView;
import ba.co.edgewise.jmup.mvc.views.Login;

public class AdminController {
	private AdminView view;
	private AdminModel model;
	private Uposlenik user;
	private WindowAdapter windowControler;

	public AdminController(AdminView view, AdminModel model, Uposlenik user) {
		super();
		this.view = view;
		this.model = model;
		this.user = user;
	}

	public void control() {
		meniControl();
		
		windowControler = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showOptionDialog(view, "Da li \u017Eelite iza\u0107i iz aplikacije i odjaviti se?",
						"Potvrda izlaza", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, new String[] {"Da", "Ne"}, "default") 
						== JOptionPane.OK_OPTION){
					view.setVisible(false);
					view.dispose();
					LogDAO lDAO = new LogDAO();
					Log log = new Log(0, user.getKorisnickoIme(), new Date(),
							"Odjava sa sistema", "Korisnik: " + user.getKorisnickoIme());
					lDAO.create(log);
				}
			}
		};
		this.view.addWindowListener(windowControler);

		JButton izradiBackup = view.getStrana6().getBtnIzradaBackupa();
		izradiBackup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: implement
				izradiBackup();
			}
		});
		
		JButton restoreBackup = view.getStrana6().getBtnRestoreBackupa();
		restoreBackup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: implement
				restoreBackupa();
			}
		});

		
		JButton spasiKorisnika = view.getStrana2().getBtSpasiKorisnika();
		spasiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				postaviIKreirajKorisnika();
			}
		});
		
		JButton pretrazi = view.getStrana3().getBtnPronaiKorisnika();
		pretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pretraziKorisnike();
			}
		});
		
		JButton modifikuj = view.getStrana3().getBtnModifikuj();
		modifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextModificiranje();
			}
		});
		
		JButton spasiModifikacije = view.getStrana4().getBtSpasiuposlenika();
		spasiModifikacije.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				spasiModifikacije();
			}
		});
		
		JButton izbrisi = view.getStrana3().getBtnIzbrisiKorisnika();
		izbrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				izbrisiKorisnika();
			}
		});
		
		JTable table = view.getStrana3().getTable();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				view.getStrana3().getBtnModifikuj().setEnabled(!lsm.isSelectionEmpty());
				view.getStrana3().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
			}
		});
	}

	private void meniControl() {
		
		JButton backup = view.getMeni().getOpcije().getBtnIzradaBackupa();
		backup.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				nextBackup();
			}
		});
		
		JButton pocetna = view.getMeni().getOpcije().getBtnPocetna();
		pocetna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextPocetna();
			}
		});

		JButton kreiranjeKorisnika = view.getMeni().getOpcije()
				.getBtnKreiranjeKorisnika();
		kreiranjeKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextKreiranje();
			}
		});

		JButton pretragaKorisnika = view.getMeni().getOpcije()
				.getBtnPretragaKorisnika();
		pretragaKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextPretraga();
			}
		});
		
		JButton logovi = view.getMeni().getOpcije().getBtnPregledLogova();
		logovi.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextLogovi();
			}
		});
		
		JButton odjava = view.getMeni().getOpcije().getBtnOdjava();
		odjava.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nextOdjava();
			}
		});
	}

	private void nextOdjava() {
		if(JOptionPane.showOptionDialog(view, "Da li se stvarno \u017Eelite odjaviti?",
				"Potvrda izlaza", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, new String[] {"Da", "Ne"}, "default") 
				== JOptionPane.OK_OPTION){
			view.setVisible(false);
			view.dispose();
			LogDAO lDAO = new LogDAO();
			Log log = new Log(0, user.getKorisnickoIme(), new Date(),
					"Odjava sa sistema", "Korisnik: " + user.getKorisnickoIme());
			lDAO.create(log);
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login view = new Login();
						LoginModel model = new LoginModel();
						LoginController controler = new LoginController(view, model);
						controler.control();
					} catch (Exception e) {
						e.printStackTrace();//
					}
				}
			});
		}
	}
	
	private void nextModificiranje() {
		int rowSelected = view.getStrana3().getTable().getSelectedRow();
		Uposlenik temp = view.getStrana3().getModel().getData().get(rowSelected);
		view.getStrana4().setUposlenik(temp);
		view.getStrana4().postaviVrijednosti();
		view.getSadrzaj().getNaslov().postaviNaslov("Modificiranje korisnika");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Modificiranje korisnika");
	}
	
	private void nextLogovi()
	{
		view.getSadrzaj().getNaslov().postaviNaslov("Pregled historije promjena");
		
		view.getStrana5().getModel().clearAll();
		view.getStrana5().getModel().addAll(model.dohvatiLogove());
		
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Pregled historije promjena");
	}
	
	private void nextBackup() {
		view.getSadrzaj().getNaslov().postaviNaslov("Backup");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Backup");
	}
	
	private void nextPocetna() {
		view.getSadrzaj().getNaslov().postaviNaslov("Po\u010Detna");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Po\u010Detna");
	}

	private void nextKreiranje() {
		view.getSadrzaj().getNaslov().postaviNaslov("Kreiranje korisnika");
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Dodavanje korisnika");
	}

	private void nextPretraga() {
		view.getSadrzaj().getNaslov().postaviNaslov("Pretraga korisnika");
		view.getStrana3().getModel().clearAll();
		view.getStrana3().getModel().addAll(model.dohvatiSveUsere());
		JPanel cards = view.getSadrzaj().getPanelSadrzaj();
		CardLayout tmp = (CardLayout) cards.getLayout();
		tmp.show(cards, "Pretraga korisnika");
	}
	
	

	private void postaviIKreirajKorisnika() {
		KorisnikKreiranje sadrzaj = view.getStrana2();
		Uposlenik tmp = new Uposlenik();
		try {
			tmp.setIme(sadrzaj.getTfIme().getText());
			tmp.setPrezime(sadrzaj.getTfPrezime().getText());
			tmp.setKorisnickoIme(sadrzaj.getTfKorisnickoIme().getText());
			String tempPass = new String(sadrzaj.getPwdSifra().getPassword());
			if (tempPass.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$"))
			{
				tmp.setPassword(tempPass);
			} else
			{
				JOptionPane.showOptionDialog(view,
						"<html>Korisnička šifra nije u pravom formatu!<br>"
						+ "Format korisničke šifre:<br>"
						+ " - Korisnička šifra mora biti između 4 i 16 karaktera <br>"
						+ " - Korisnička šifra se moze sastojati samo od slova i brojeva, bez afrikata <br>"
						+ " - Korisnička šifra mora u sebi sadržati najmanje po jedno veliko i malo slovo, te jedan broj</html>",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
				return;
			}
			tmp.setStatus((Status) sadrzaj.getCbStatusKorisnickogRacuna()
					.getSelectedItem());
			tmp.setTip((TipUposlenika) sadrzaj.getCbTipKorisnickogRacuna()
					.getSelectedItem());
			this.model.setUposlenik(tmp);
		} catch (IllegalArgumentException e){
			JOptionPane.showOptionDialog(view,
					e.getMessage(),
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
			return;
		}
		
		
		if (model.kreiranjeKorisnika()) {
			JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no dodan.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default");
			
			LogDAO lDAO = new LogDAO();
			Log log = new Log(0, user.getKorisnickoIme(), new Date(),
					"Kreiranje novog korisnika", "Korisničko ime = " + tmp.getKorisnickoIme());
			lDAO.create(log);
			
		} else {
			JOptionPane.showOptionDialog(view,
					"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
							+ "Molimo vas da poku\u0161ate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
		};
	}
	
	private void spasiModifikacije(){
		try {
			view.getStrana4().postaviKorisnika();
			String tempPass = view.getStrana4().getUposlenik().getPassword();
			if (tempPass.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$"))
			{
				model.setUposlenik(view.getStrana4().getUposlenik());
			} else
			{
				JOptionPane.showOptionDialog(view,
						"<html>Korisnička šifra nije u pravom formatu!<br>"
						+ "Format korisničke šifre:<br>"
						+ " - Korisnička šifra mora biti između 4 i 16 karaktera <br>"
						+ " - Korisnička šifra se moze sastojati samo od slova i brojeva, bez afrikata <br>"
						+ " - Korisnička šifra mora u sebi sadržati najmanje po jedno veliko i malo slovo, te jedan broj</html>",
						"Kreiranje korisnika", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
						"default");
				return;
			}
		} catch (IllegalArgumentException e){
			JOptionPane.showOptionDialog(view,
					e.getMessage(),
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
			return;
		}
		
		if (model.modifikovanjeKorisnika()) {
			if(JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no modificiran.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default")==JOptionPane.OK_OPTION) {
				nextPretraga();
				LogDAO lDAO = new LogDAO();
				Log log = new Log(0, user.getKorisnickoIme(), new Date(),
						"Modifikovanje korisnika", 
						"Korisničko ime = " + model.getUposlenik().getKorisnickoIme());
				lDAO.create(log);
			}
		} else {
			JOptionPane.showOptionDialog(view,
					"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
							+ "Molimo vas da poku\u0161ate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
		};
		
	}
	
	private void izbrisiKorisnika(){
		int rowSelected = view.getStrana3().getTable().getSelectedRow();
		Uposlenik temp = view.getStrana3().getModel().getData().get(rowSelected);
		model.setUposlenik(temp);
		if (model.brisanjeKorisnika()) {
			if(JOptionPane.showOptionDialog(view, "Korisnik uspje\u0161no izbrisan.",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Uredu" }, "default") == JOptionPane.OK_OPTION){
				
				nextPretraga();
				
				LogDAO lDAO = new LogDAO();
				Log log = new Log(0, user.getKorisnickoIme(), new Date(),
						"Brisanje korisnika", 
						"Korisničko ime = " + model.getUposlenik().getKorisnickoIme());
				lDAO.create(log);
			}
		} else {
			JOptionPane.showOptionDialog(view,
					"Do\u0161lo je do gre\u0161ke prilikom upisivanja u bazu. "
							+ "Molimo vas da poku\u0161ate ponovo",
					"Kreiranje korisnika", JOptionPane.OK_OPTION,
					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
					"default");
		};
		nextPretraga();
	}
	
	private void pretraziKorisnike() {
		view.getStrana3().getModel().clearAll();
		String kriterij = view.getStrana3().getTfPodaci().getText();
		TipPretrageUposlenika tip = (TipPretrageUposlenika)
				view.getStrana3().getCbPoljePretrage().getSelectedItem();
		if(kriterij.equals("")) {
			view.getStrana3().getModel().addAll(
					model.dohvatiSveUsere());
		} else {
			view.getStrana3().getModel().addAll(
					model.dohvatiUserePretraga(kriterij, tip));
		}
	}
	
	private void izradiBackup() {
		JFileChooser saveFile = new JFileChooser();
    	FileFilter filter = new FileNameExtensionFilter("SQL skripta", new String[]{"sql"});
    	saveFile.setFileFilter(filter);
    	saveFile.addChoosableFileFilter(filter);
    	saveFile.setAcceptAllFileFilterUsed(false);
        saveFile.showSaveDialog(view);
        String filepath = new String();
        if (saveFile.getSelectedFile() != null){
        	filepath = saveFile.getSelectedFile().getAbsolutePath();
        	int begin = filepath.length() - 4;
        	if (!filepath.substring(begin).equals(".sql"))
        		filepath += ".sql";
        }
        
        String dbHost = "localhost";
        String dbName = "sql339553";
        String dbUser = "root";
        String dbPass = "root";
        
        String executeCmd = "mysqldump --single-transaction --host=" + dbHost + " --user=" + dbUser
        		+ " --password=" + dbPass + " " + dbName + " --ignore-table="+ dbName + ".logovi"+ " > " + filepath;
        
        String[] cmd = {"cmd", "/c", executeCmd};
        
        try {
        	Process runtimeProcess = Runtime.getRuntime().exec(cmd);
            int processComplete = runtimeProcess.waitFor();
            
            if (processComplete == 0) {
            	JOptionPane.showOptionDialog(view,
    					"Backup je uspje\u0161no kreiran",
    					"Kreiranje backup-a", JOptionPane.OK_OPTION,
    					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Uredu" },
    					"default");
            } else {
            	JOptionPane.showOptionDialog(view,
    					"Došlo je do gre\u0161ke prilikom izrade backupa. Molimo Vas da poku\u0161ate ponovo.",
    					"Kreiranje backup-a", JOptionPane.OK_OPTION,
    					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
    					"default");
            }
            
        } catch (IOException | InterruptedException ex)
        {
        	ex.printStackTrace();
        }
        
        LogDAO lDAO = new LogDAO();
		Log log = new Log(0, user.getKorisnickoIme(), new Date(),
				"Kreiranje backup-a", "Korisnik: " + user.getKorisnickoIme());
		lDAO.create(log);
	}
	
	public void restoreBackupa() {
		JFileChooser saveFile = new JFileChooser();
    	FileFilter filter = new FileNameExtensionFilter("SQL skripta", new String[]{"sql"});
    	saveFile.setFileFilter(filter);
    	saveFile.addChoosableFileFilter(filter);
    	saveFile.setAcceptAllFileFilterUsed(false);
        saveFile.showOpenDialog(view);
        String filepath = new String();
        
        if (saveFile.getSelectedFile() != null){
        	filepath = saveFile.getSelectedFile().getAbsolutePath();
        	int begin = filepath.length() - 4;
        	if (!filepath.substring(begin).equals(".sql"))
        		filepath += ".sql";
        }
                
        String dbHost = "localhost";
        String dbName = "sql339553";
        String dbUser = "root";
        String dbPass = "root";
        
        String executeCmd = "mysql --host=" + dbHost + " --user=" + dbUser
        		+ " --password=" + dbPass + " " + dbName + " < " + filepath;
        
        
        String[] cmd = {"cmd", "/c", executeCmd};
        System.out.println(executeCmd);
        
        try {
        	Process runtimeProcess = Runtime.getRuntime().exec(cmd);
            int processComplete = runtimeProcess.waitFor();
            
            if (processComplete == 0) {
            	JOptionPane.showOptionDialog(view,
    					"Uspje\u0161an povratak na predhodno stanje",
    					"Povratak na backup", JOptionPane.OK_OPTION,
    					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Uredu" },
    					"default");
            } else {
            	JOptionPane.showOptionDialog(view,
    					"Došlo je do gre\u0161ke prilikom povratak na backup. Molimo Vas da poku\u0161ate ponovo.",
    					"Kreiranje backup-a", JOptionPane.OK_OPTION,
    					JOptionPane.ERROR_MESSAGE, null, new String[] { "Uredu" },
    					"default");
            }
            
        } catch (IOException | InterruptedException ex)
        {
        	ex.printStackTrace();
        }
        
        LogDAO lDAO = new LogDAO();
		Log log = new Log(0, user.getKorisnickoIme(), new Date(),
				"Restore backup-a", "Korisnik: " + user.getKorisnickoIme());
		lDAO.create(log);
	}
}
