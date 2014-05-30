package ba.co.edgewise.jmup.components;
//a
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import ba.co.edgewise.components.helpers.TableModelVozilo;

public class SalterskaPretragaVozilo extends JPanel {

	private static final long serialVersionUID = 914404948964006300L;
	private JTable table_vozila;
	private GridBagLayout gridBagLayout;
	private TableModelVozilo model;
	JScrollPane sp_pretragaTabela;

	public SalterskaPretragaVozilo() {
		// methods for setting layout
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
		sp_pretragaTabela = new JScrollPane();
		GridBagConstraints gbc_sp_pretragaTabela = new GridBagConstraints();
		gbc_sp_pretragaTabela.fill = GridBagConstraints.BOTH;
		gbc_sp_pretragaTabela.gridx = 0;
		gbc_sp_pretragaTabela.gridy = 0;
		add(sp_pretragaTabela, gbc_sp_pretragaTabela);

	//	model = new TableModelVozilo();
	//	table_vozila = new JTable(model);
		this.setModel(new TableModelVozilo());
		setTable(new JTable(getModel()));
		getModel().addTableModelListener(getTable());
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp_pretragaTabela.setViewportView(table_vozila);
	}
	public JTable getTable() {
		return table_vozila;
	}

	public void setTable(JTable jTable) {
		this.table_vozila = jTable;
	}

	public TableModelVozilo getModel() {
		return model;
	}

	public void setModel(TableModelVozilo tableModelVozilo) {
		this.model = tableModelVozilo;	
	}
}
