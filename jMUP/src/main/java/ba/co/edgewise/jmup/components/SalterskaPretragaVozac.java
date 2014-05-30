package ba.co.edgewise.jmup.components;
//asc
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.co.edgewise.components.helpers.TableModelVozac;

public class SalterskaPretragaVozac extends JPanel {

	private static final long serialVersionUID = -2736418492564332685L;
	private JTable table_vozaci;
	private GridBagLayout gridBagLayout;
	private TableModelVozac model;

	public SalterskaPretragaVozac() {
		setLayout();
		setComponents();
	}

	public void setLayout() {
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 595, 0 };
		gridBagLayout.rowHeights = new int[] { 253, 0 };
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
		
		//model = new TableModelVozac();
		//table_vozaci = new JTable(model);
		this.setModel(new TableModelVozac());
		setTable(new JTable(getModel()));
		getModel().addTableModelListener(getTable());
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp_pretragaTabela.setViewportView(table_vozaci);
	}
	public JTable getTable() {
		return table_vozaci;
	}
		
	public void setTable(JTable jTable) {
		this.table_vozaci = jTable;
	}

	public TableModelVozac getModel() {
		return model;
	}
		
	public void setModel(TableModelVozac tableModelVozac) {
		this.model = tableModelVozac;	
	}
}
