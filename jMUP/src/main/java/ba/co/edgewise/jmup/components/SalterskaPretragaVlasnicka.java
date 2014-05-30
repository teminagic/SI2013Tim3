package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.co.edgewise.components.helpers.TableModelVlasnicka;
import ba.co.edgewise.components.helpers.TableModelVozac;

public class SalterskaPretragaVlasnicka extends JPanel {
	
	private static final long serialVersionUID = -4719468020930451083L;
	private JTable table_vlasnicke;
	private GridBagLayout gridBagLayout;
	private TableModelVlasnicka model;


	public SalterskaPretragaVlasnicka() {
		setLayout();
		setComponents();
	}

	public void setLayout() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 595, 0 };
		gridBagLayout.rowHeights = new int[] { 256, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void setComponents() {
		JScrollPane sp_pretragaTabela = new JScrollPane();
		GridBagConstraints gbc_sp_pretragaTabela = new GridBagConstraints();
		gbc_sp_pretragaTabela.fill = GridBagConstraints.BOTH;
		gbc_sp_pretragaTabela.gridx = 0;
		gbc_sp_pretragaTabela.gridy = 0;
		add(sp_pretragaTabela, gbc_sp_pretragaTabela);

		//model = new TableModelVlasnicka();
		//table_vlasnicke = new JTable(model);
		this.setModel(new TableModelVlasnicka());
		setTable(new JTable(getModel()));
		getModel().addTableModelListener(getTable());
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp_pretragaTabela.setViewportView(table_vlasnicke);
	}
	public JTable getTable() {
		return table_vlasnicke;
	}
		
	public void setTable(JTable jTable) {
		this.table_vlasnicke = jTable;
	}

	public TableModelVlasnicka getModel() {
		return model;
	}
		
	public void setModel(TableModelVlasnicka tableModelVlasnicka) {
		this.model = tableModelVlasnicka;	
	}
}
