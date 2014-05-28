package ba.co.edgewise.jmup.components;
//
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import ba.co.edgewise.jmup.klase.Uposlenik;
import ba.co.edgewise.jmup.enums.TipPretrageUposlenika;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KorisnikPretraga extends JPanel {
/*
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
	TableModel model;
	KorisnikPretraga self = this;
	private JButton btnModifikuj;
	private JButton btnIzbrisiKorisnika;
	private AdminFrame parent;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public KorisnikPretraga() {
		
		//methods for layout initialization
		layoutSet();
		panelSet();
		labelSet();
		inputSet();
		uiControlSet();
		buttonSet();
	
	}
	
	//Abstract Table class
	class TableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = -263608234994707920L;
		
		private String[] columnNames = {
				"Ime",
				"Prezime",
				"KorisniÄ�ko ime",
				"Tip raÄ�una",
				"Status"
		};
		private ArrayList<Uposlenik> data;
		
		public TableModel()
		{
			super();
		}
		
		public TableModel(ArrayList<Uposlenik> data)
		{
			super();
			this.data = data;
		}
		
		public ArrayList<Uposlenik> getData() {
			return data;
		}

		public void setData(ArrayList<Uposlenik> data) {
			this.data = data;
		}

		@Override
		public void fireTableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
			super.fireTableChanged(e);
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return (Object)(data.get(rowIndex).toObjectArray())[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return getValueAt(0, columnIndex).getClass();
		}
		
	}
	
	//methods for layout & control initialization
		public void layoutSet() {
			
			gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 300, 100, 100, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
			gbl_panel.columnWidths = new int[]{60, 109, 111, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
		}
		
		public void labelSet() {
			
			lblPodaci = new JLabel("Podaci:");
			GridBagConstraints gbc_lblPodaci = new GridBagConstraints();
			gbc_lblPodaci.insets = new Insets(0, 0, 5, 5);
			gbc_lblPodaci.anchor = GridBagConstraints.EAST;
			gbc_lblPodaci.gridx = 0;
			gbc_lblPodaci.gridy = 0;
			panel.add(lblPodaci, gbc_lblPodaci);
		}
		
		public void inputSet() {
			
			tfPodaci = new JTextField();
			GridBagConstraints gbc_tfPodaci = new GridBagConstraints();
			gbc_tfPodaci.insets = new Insets(0, 0, 5, 5);
			gbc_tfPodaci.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPodaci.gridx = 1;
			gbc_tfPodaci.gridy = 0;
			panel.add(tfPodaci, gbc_tfPodaci);
			tfPodaci.setColumns(10);
			
		}
		
		public void uiControlSet() {
			
			cbPoljePretrage = new JComboBox(TipPretrageUposlenika.values());
			GridBagConstraints gbc_cbPoljePretrage = new GridBagConstraints();
			gbc_cbPoljePretrage.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbPoljePretrage.insets = new Insets(0, 0, 5, 5);
			gbc_cbPoljePretrage.gridx = 2;
			gbc_cbPoljePretrage.gridy = 0;
			panel.add(cbPoljePretrage, gbc_cbPoljePretrage);
			
			tablePane = new JScrollPane();
			GridBagConstraints gbc_tablePane = new GridBagConstraints();
			gbc_tablePane.gridwidth = 4;
			gbc_tablePane.insets = new Insets(0, 0, 0, 5);
			gbc_tablePane.fill = GridBagConstraints.BOTH;
			gbc_tablePane.gridx = 0;
			gbc_tablePane.gridy = 1;
			panel.add(tablePane, gbc_tablePane);
			
			model = new TableModel(Login.korisnici);
			table = new JTable(model);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				@Override
				public void valueChanged(ListSelectionEvent e) {
					ListSelectionModel lsm = (ListSelectionModel)e.getSource();
					self.getBtnModifikuj().setEnabled(!lsm.isSelectionEmpty());
					self.getBtnIzbrisiKorisnika().setEnabled(!lsm.isSelectionEmpty());
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePane.setViewportView(table);

		}
		
		public void buttonSet() {
			
			btnPronaiKorisnika = new JButton("Pronađi korisnika");
			GridBagConstraints gbc_btnPronaiKorisnika = new GridBagConstraints();
			gbc_btnPronaiKorisnika.insets = new Insets(0, 0, 5, 0);
			gbc_btnPronaiKorisnika.gridx = 3;
			gbc_btnPronaiKorisnika.gridy = 0;
			panel.add(btnPronaiKorisnika, gbc_btnPronaiKorisnika);
			
			btnModifikuj.setEnabled(false);
			GridBagConstraints gbc_btnModifikuj = new GridBagConstraints();
			gbc_btnModifikuj.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnModifikuj.insets = new Insets(0, 0, 5, 5);
			gbc_btnModifikuj.gridx = 2;
			gbc_btnModifikuj.gridy = 2;
			add(btnModifikuj, gbc_btnModifikuj);
			
			btnIzbrisiKorisnika = new JButton("IzbriÅ¡i");
			btnIzbrisiKorisnika.setEnabled(false);
			GridBagConstraints gbc_btnIzbrisiKorisnika = new GridBagConstraints();
			gbc_btnIzbrisiKorisnika.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnIzbrisiKorisnika.insets = new Insets(0, 0, 5, 5);
			gbc_btnIzbrisiKorisnika.gridx = 3;
			gbc_btnIzbrisiKorisnika.gridy = 2;
			add(btnIzbrisiKorisnika, gbc_btnIzbrisiKorisnika);
			
			btnModifikuj = new JButton("Modifikuj");
			
			
			//action listener
			btnPronaiKorisnika.addActionListener(new ActionListener() {
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
			});
		}
	
	
	//methods
	static private ArrayList<Uposlenik> FiltriraniKorisnici(String filter, TipPretrageUposlenika parametar)
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
	}
	
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

	public AdminFrame getParrent() {
		return parent;
	}

	public void setParrent(AdminFrame parrent) {
		this.parent = parrent;
	}*/
}
