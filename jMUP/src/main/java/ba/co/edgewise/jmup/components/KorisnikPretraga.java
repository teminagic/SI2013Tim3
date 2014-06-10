package ba.co.edgewise.jmup.components;
import javax.swing.JPanel;
import ba.co.edgewise.components.helpers.TableModelKorisnik;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class KorisnikPretraga extends JPanel {
	private static final long serialVersionUID = 5037184707341253170L;
	private GridBagLayout gridBagLayout;
	private JPanel panel;
	private JLabel lblPodaci;
	private JButton btnPronaiKorisnika;
	private JTextField tfPodaci;
	private JTable table;
	private JScrollPane tablePane;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPoljePretrage;
	private TableModelKorisnik model;
	private JButton btnModifikuj;
	private JButton btnIzbrisiKorisnika;

	public KorisnikPretraga() {
		
		//methods for layout initialization
		layoutSet();
		panelSet();
		labelSet();
		inputSet();
		uiControlSet();
		buttonSet();
	
	}
	
	//methods for layout & control initialization
		public void layoutSet() {
			
			gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 300, 100, 100, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 5, 0};
			gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
		
		}
		
		public void panelSet() {
			
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Pretraga Uposlenika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 3;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 1;
			add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 60, 109, 111, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 112, 16, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
		}
		
		public void labelSet() {
			
			lblPodaci = new JLabel("Podaci:");
			GridBagConstraints gbc_lblPodaci = new GridBagConstraints();
			gbc_lblPodaci.insets = new Insets(0, 0, 5, 5);
			gbc_lblPodaci.anchor = GridBagConstraints.EAST;
			gbc_lblPodaci.gridx = 1;
			gbc_lblPodaci.gridy = 0;
			panel.add(lblPodaci, gbc_lblPodaci);
		}
		
		public void inputSet() {
			
			tfPodaci = new JTextField();
			GridBagConstraints gbc_tfPodaci = new GridBagConstraints();
			gbc_tfPodaci.insets = new Insets(0, 0, 5, 5);
			gbc_tfPodaci.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPodaci.gridx = 2;
			gbc_tfPodaci.gridy = 0;
			panel.add(tfPodaci, gbc_tfPodaci);
			tfPodaci.setColumns(10);
			
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void uiControlSet() {
			
			cbPoljePretrage = new JComboBox(TipPretrageUposlenika.values());
			GridBagConstraints gbc_cbPoljePretrage = new GridBagConstraints();
			gbc_cbPoljePretrage.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbPoljePretrage.insets = new Insets(0, 0, 5, 5);
			gbc_cbPoljePretrage.gridx = 3;
			gbc_cbPoljePretrage.gridy = 0;
			panel.add(cbPoljePretrage, gbc_cbPoljePretrage);
			
			tablePane = new JScrollPane();
			GridBagConstraints gbc_tablePane = new GridBagConstraints();
			gbc_tablePane.insets = new Insets(0, 0, 5, 5);
			gbc_tablePane.gridwidth = 5;
			gbc_tablePane.fill = GridBagConstraints.BOTH;
			gbc_tablePane.gridx = 1;
			gbc_tablePane.gridy = 1;
			panel.add(tablePane, gbc_tablePane);
			
			setModel(new TableModelKorisnik());
			setTable(new JTable(getModel()));
			getModel().addTableModelListener(getTable());
			getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePane.setViewportView(getTable());

		}
		
		public void buttonSet() {
			
			btnPronaiKorisnika = new JButton("Prona\u0111i korisnika");
			GridBagConstraints gbc_btnPronaiKorisnika = new GridBagConstraints();
			gbc_btnPronaiKorisnika.insets = new Insets(0, 0, 5, 5);
			gbc_btnPronaiKorisnika.gridx = 5;
			gbc_btnPronaiKorisnika.gridy = 0;
			panel.add(btnPronaiKorisnika, gbc_btnPronaiKorisnika);
			
			btnModifikuj = new JButton("Modifikuj");
			btnModifikuj.setEnabled(false);
			GridBagConstraints gbc_btnModifikuj = new GridBagConstraints();
			gbc_btnModifikuj.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnModifikuj.insets = new Insets(0, 0, 5, 5);
			gbc_btnModifikuj.gridx = 2;
			gbc_btnModifikuj.gridy = 2;
			add(btnModifikuj, gbc_btnModifikuj);
			
			btnIzbrisiKorisnika = new JButton("Izbri\u0161i");
			btnIzbrisiKorisnika.setEnabled(false);
			GridBagConstraints gbc_btnIzbrisiKorisnika = new GridBagConstraints();
			gbc_btnIzbrisiKorisnika.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnIzbrisiKorisnika.insets = new Insets(0, 0, 5, 5);
			gbc_btnIzbrisiKorisnika.gridx = 3;
			gbc_btnIzbrisiKorisnika.gridy = 2;
			add(btnIzbrisiKorisnika, gbc_btnIzbrisiKorisnika);
			
			
			//action listener
			/*btnPronaiKorisnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String filter = tfPodaci.getText();
					TipPretrageUposlenika parametar = (TipPretrageUposlenika)cbPoljePretrage.getSelectedItem();
					model.setData(FiltriraniKorisnici(filter, parametar));
				}
			});
			
			btnModifikuj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Uposlenik k = Login.korisnici.get(table.getSelectedRow());
					KorisnikModificiranje modifikacija = new KorisnikModificiranje(k);
					modifikacija.PopuniUposlenika();
					parent.setModifikacija(modifikacija);
					parent.getSadrzaj().getPanelSadrzaj().add(modifikacija, "Modificiranje korisnika");
					CardLayout cl = (CardLayout)parent.getSadrzaj().getPanelSadrzaj().getLayout(); 
					cl.show(parent.getSadrzaj().getPanelSadrzaj(), "Modificiranje korisnika");
					parent.getSadrzaj().getNaslov().postaviNaslov("Modificiranje korisnika");
				}
			});*/
		}
	
	
	//methods
	/*static private ArrayList<Uposlenik> FiltriraniKorisnici(String filter, TipPretrageUposlenika parametar)
	{
		ArrayList<Uposlenik> rezultat = new ArrayList<Uposlenik>();
		switch (parametar) {
			case IME:
				for(Uposlenik k: Login.korisnici)
					if (k.getIme().contains(filter)) rezultat.add(k);
				break;
			case PREZIME:
				for(Uposlenik k: Login.korisnici)
					if (k.getPrezime().contains(filter)) rezultat.add(k);
				break;
			case USERNAME:
				for(Uposlenik k: Login.korisnici)
					if (k.getPassword().contains(filter)) rezultat.add(k);
				break;
		}
		return rezultat;
	}*/
	
	//getters & setters
	@SuppressWarnings("rawtypes")
	public JComboBox getCbPoljePretrage() {
		return cbPoljePretrage;
	}
	public JTextField getTfPodaci() {
		return tfPodaci;
	}
	public JButton getBtnModifikuj() {
		return btnModifikuj;
	}
	public JButton getBtnIzbrisiKorisnika() {
		return btnIzbrisiKorisnika;
	}

	public TableModelKorisnik getModel() {
		return model;
	}

	private void setModel(TableModelKorisnik model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	private void setTable(JTable table) {
		this.table = table;
	}
	
	public JButton getBtnPronaiKorisnika() {
		return btnPronaiKorisnika;
	}
}
