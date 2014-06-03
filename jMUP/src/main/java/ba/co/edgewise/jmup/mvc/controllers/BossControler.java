package ba.co.edgewise.jmup.mvc.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ba.co.edgewise.jmup.klase.Log;
import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.mvc.models.AdminModel;
import ba.co.edgewise.jmup.mvc.models.LoginModel;
import ba.co.edgewise.jmup.mvc.views.AdminView;
import ba.co.edgewise.jmup.mvc.views.Login;
import ba.co.edgewise.jmup.daldao.daos.LogDAO;
import ba.co.edgewise.jmup.enums.SaobracajnaPretraga;
import ba.co.edgewise.jmup.enums.VlasnickaPretraga;
import ba.co.edgewise.jmup.enums.VozacPretraga;
import ba.co.edgewise.jmup.enums.VoziloPretraga;
import ba.co.edgewise.jmup.klase.Log;
import ba.co.edgewise.jmup.mvc.models.*;
import ba.co.edgewise.jmup.mvc.views.*;
import ba.co.edgewise.components.helpers.ShowDialogInput;

public class BossControler {
	private BossModel model;
	private BossView view;
	private boolean odjavaBossa;
	private Uposlenik user;

	public BossControler(BossView view, BossModel model) {
		super();
		this.view = view;
		this.model = model;
		odjavaBossa = false;
	}
	public void control() {
		// Listener za pocetnu
		JButton pocetna= this.view.getMeni().getOpcije().getBtnPocetna();
		pocetna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelPocetnu();
			};			
		});
		//Listener za odjavu
		JButton odjava = this.view.getMeni().getOpcije().getBtnOdjava();
		odjava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(JOptionPane.showOptionDialog(view, "Eventualne promjene nece biti spa\u0161ene. "
					 		+ "\u017Delite li se odjaviti?",
							"Potvrda odjave", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, new String[] {"Da", "Ne"}, "default")== JOptionPane.OK_OPTION)
						{
					    	setOdjavaBossa(true);
							odjaviSkroz();
							Login view = new Login();
							LoginModel model = new LoginModel();
							LoginController controler = new LoginController(view, model);
							controler.control();
							LogDAO lDAO = new LogDAO();
							Log log = new Log(0, user.getKorisnickoIme(), new Date(),
									"Odjava sa sistema", "Korisnik: " + user.getKorisnickoIme());
							lDAO.create(log);
				        }
				       
				} catch (Exception izuzetak) {
					izuzetak.printStackTrace();//
				}
			};		
		});	
		
		//Izvjestaji
		 		JButton izvjestaj= this.view.getMeni().getOpcije().getBtnIzradaIzvjetaja();
		 		izvjestaj.addMouseListener(new MouseAdapter() {
		 			@Override
		 			public void mouseClicked(MouseEvent e) {
		 				 prikaziPanelIzvjestaji();
		 				};		
		 		});
	   //LOGOVI
		   	JButton logovi = view.getMeni().getOpcije().getBtnPregledLogova();
				logovi.addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0) {
						nextLogovi();
					}
				});
		
		
		//PRETRAGA
		// Pretraga - Prikaz osnovnog panela
		JButton salterskaPretraga= this.view.getMeni().getOpcije().getBtnPretraga();
		salterskaPretraga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prikaziPanelPretraga();
			};
			
		});
		
		// Pretraga - Prikaz panela Vozilo
		final JRadioButton rbVozilo = this.view.getStrana2().getRbVozilo();
		rbVozilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVozilo.isSelected()) {
					prikaziPanelPretragaVozila();
				}
			};
		});
		
		// Pretraga - Prikaz panela Vozac
		final JRadioButton rbVozac = this.view.getStrana2().getRbVozac();
		rbVozac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVozac.isSelected()) {
					prikaziPanelPretragaVozaca();
				}
			};
		});
		// Pretraga - Prikaz panela Saobracajna
		final JRadioButton rbSaobracajna = this.view.getStrana2().getRbSaobracajna();
		rbSaobracajna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbSaobracajna.isSelected()) {
					prikaziPanelPretragaSaobracajnih();
				}
			};
		});
		// Pretraga - Prikaz panela Vlasnicka
		final JRadioButton rbVlasnicka = this.view.getStrana2().getRbVlasnicka();
		rbVlasnicka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVlasnicka.isSelected()) {
					prikaziPanelPretragaVlasnickih();
				}
			};
		});
		//??
		JTable table = view.getStrana2().getPanel_vozilo().getTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
				public void valueChanged(ListSelectionEvent e) {
					ListSelectionModel lsm = (ListSelectionModel)e.getSource();
					view.getStrana2().getBtn_modifikuj().setEnabled(!lsm.isSelectionEmpty());
				//	view.getStrana2().getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
				}
			});
		// Klik na button Pretrazi
		JButton pretrazi = view.getStrana2().getBtnPretrazi();
		pretrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pretrazi();
			}
		});
	}
	public void odjaviSkroz()
	{
		if(isOdjavaBossa() == true)
			this.view.dispose();
	}
	public boolean isOdjavaBossa() {
		return odjavaBossa;
	}
	public void setOdjavaBossa(boolean odjavaBossa) {
		this.odjavaBossa = odjavaBossa;
	}
	void prikaziPanelPocetnu()
	{
		view.prikaziPocetnu();
	}
	//PRETRAGA
			void prikaziPanelPretraga()
			{
				//Prikaz panela pretraga
				view.prikaziPretragu();
				//Defaultni - Vozila
				prikaziPanelPretragaVozila();
			}
			
			void prikaziPanelIzvjestaji()
			 	{
			 		view.prikaziIzvjestaje();
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
			void prikaziPanelPretragaVozila() {
				//Baza
				view.getStrana2().getPanel_vozilo().getModel().clearAll();
				view.getStrana2().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
				//Comboboxi
				this.view.getStrana2().getCb_parametri().removeAllItems();
				this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VoziloPretraga.values()));		
				//Prikaz
				this.view.getStrana2().prikaziPretraguVozila();
			}
			void prikaziPanelPretragaVozaca() {
				//Baza
				view.getStrana2().getPanel_vozac().getModel().clearAll();
				view.getStrana2().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
				//Comboxi
				this.view.getStrana2().getCb_parametri().removeAllItems();
				this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VozacPretraga.values()));		
				//Prikaz
				this.view.getStrana2().prikaziPretraguVozaca();
			}
			void prikaziPanelPretragaSaobracajnih() {
				view.getStrana2().getPanel_saobracajna().getModel().clearAll();
				view.getStrana2().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
				this.view.getStrana2().getCb_parametri().removeAllItems();
				this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(SaobracajnaPretraga.values()));		
				this.view.getStrana2().prikaziPretraguSaobracajne();
			}
			void prikaziPanelPretragaVlasnickih() {
				view.getStrana2().getPanel_vlasnicka().getModel().clearAll();
				view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
				this.view.getStrana2().getCb_parametri().removeAllItems();
				this.view.getStrana2().getCb_parametri().setModel(new DefaultComboBoxModel(VlasnickaPretraga.values()));		
				this.view.getStrana2().prikaziPretraguVlasnicke();
			}
			private void pretrazi() {	
				final JRadioButton rbVozilo = this.view.getStrana2().getRbVozilo();
				final JRadioButton rbVozac = this.view.getStrana2().getRbVozac();
				final JRadioButton rbSaobracajna = this.view.getStrana2().getRbSaobracajna();
				final JRadioButton rbVlasnicka = this.view.getStrana2().getRbVlasnicka();
				if(rbVozilo.isSelected()) pretraziVozila();
				else if(rbVozac.isSelected()) pretraziVozace();
				else if(rbSaobracajna.isSelected()) pretraziSaobracajne();
				else if(rbVlasnicka.isSelected()) pretraziVlasnicke();
			}
			void pretraziVozila() {
				view.getStrana2().getPanel_vozilo().getModel().clearAll();
				String parametar = view.getStrana2().getTb_unosPretrage().getText();
				VoziloPretraga kriterij = (VoziloPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
				if(parametar.equals("")) {
					view.getStrana2().getPanel_vozilo().getModel().addAll(model.dohvatiSvaVozila());
				} else {
					view.getStrana2().getPanel_vozilo().getModel().addAll(model.pretragaVozilo(parametar,kriterij.toString()));
				}
			}
			void pretraziVozace() {
				view.getStrana2().getPanel_vozac().getModel().clearAll();
				String parametar = view.getStrana2().getTb_unosPretrage().getText();
				VozacPretraga kriterij = (VozacPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
				if(parametar.equals("")) {
					view.getStrana2().getPanel_vozac().getModel().addAll(model.dohvatiSveVozace());
				} else {
					view.getStrana2().getPanel_vozac().getModel().addAll(model.pretragaVozac(parametar,kriterij.toString()));
				}
			}
			void pretraziSaobracajne() {
				view.getStrana2().getPanel_saobracajna().getModel().clearAll();
				String parametar = view.getStrana2().getTb_unosPretrage().getText();
				SaobracajnaPretraga kriterij = (SaobracajnaPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
				if(parametar.equals("")) {
					view.getStrana2().getPanel_saobracajna().getModel().addAll(model.dohvatiSveSaobracajne());
				} else {
					view.getStrana2().getPanel_saobracajna().getModel().addAll(model.pretragaSaobracajna(parametar,kriterij.toString()));
				}
			}
			void pretraziVlasnicke() {
				view.getStrana2().getPanel_vlasnicka().getModel().clearAll();
				String parametar = view.getStrana2().getTb_unosPretrage().getText();
				VlasnickaPretraga kriterij = (VlasnickaPretraga)view.getStrana2().getCb_parametri().getSelectedItem();
				if(parametar.equals("")) {
					view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.dohvatiSveVlasnicke());
				} else {
					view.getStrana2().getPanel_vlasnicka().getModel().addAll(model.pretragaVlasnicka(parametar,kriterij.toString()));
				}
			}
}
