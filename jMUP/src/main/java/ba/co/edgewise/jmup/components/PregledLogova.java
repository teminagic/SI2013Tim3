package ba.co.edgewise.jmup.components;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTable;

import ba.co.edgewise.components.helpers.TableModelLogovi;

public class PregledLogova extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9218590729691310193L;
	private JTable table;
	private TableModelLogovi model;

	/**
	 * Create the panel.
	 */
	public PregledLogova() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 500, 10, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		model = new TableModelLogovi();
		table = new JTable(model);
		scrollPane.setViewportView(table);

	}

	public JTable getTable() {
		return table;
	}
	
	public TableModelLogovi getModel() {
		return model;
	}

	public void setModel(TableModelLogovi model) {
		this.model = model;
	}
}
