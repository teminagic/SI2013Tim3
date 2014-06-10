package ba.co.edgewise.jmup.components;
//
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.co.edgewise.components.helpers.TableModelSaobracajna;
import ba.co.edgewise.components.helpers.TableModelVozac;

public class SalterskaPretragaSaobracajna extends JPanel {

	private static final long serialVersionUID = -2514490758065822452L;
	private JTable table_saobracajne;
	private GridBagLayout gridBagLayout;
	private TableModelSaobracajna model;


	public SalterskaPretragaSaobracajna() {
		setLayout();
		setComponents();
	}

	public void setLayout() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 595, 0 };
		gridBagLayout.rowHeights = new int[] { 256, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
	}

	public void setComponents() {
		JScrollPane sp_pretragaTabela = new JScrollPane();
		GridBagConstraints gbc_sp_pretragaTabela = new GridBagConstraints();
		gbc_sp_pretragaTabela.fill = GridBagConstraints.BOTH;
		gbc_sp_pretragaTabela.gridx = 0;
		gbc_sp_pretragaTabela.gridy = 0;
		add(sp_pretragaTabela, gbc_sp_pretragaTabela);

		//model = new TableModelSaobracajna();
		//table_saobracajne = new JTable(model);
		this.setModel(new TableModelSaobracajna());
		setTable(new JTable(getModel()));
		getModel().addTableModelListener(getTable());
		getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp_pretragaTabela.setViewportView(table_saobracajne);
	}
	public JTable getTable() {
		return table_saobracajne;
	}
		
	public void setTable(JTable jTable) {
		this.table_saobracajne = jTable;
	}

	public TableModelSaobracajna getModel() {
		return model;
	}
		
	public void setModel(TableModelSaobracajna tableModelSaobracajna) {
		this.model = tableModelSaobracajna;	
	}
}