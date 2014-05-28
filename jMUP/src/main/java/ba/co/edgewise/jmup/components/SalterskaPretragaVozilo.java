package co.ba.edgewise.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalterskaPretragaVozilo extends JPanel {

	private static final long serialVersionUID = 914404948964006300L;
	private JTable table_vozila;
	private GridBagLayout gridBagLayout;

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
		JScrollPane sp_pretragaTabela = new JScrollPane();
		GridBagConstraints gbc_sp_pretragaTabela = new GridBagConstraints();
		gbc_sp_pretragaTabela.fill = GridBagConstraints.BOTH;
		gbc_sp_pretragaTabela.gridx = 0;
		gbc_sp_pretragaTabela.gridy = 0;
		add(sp_pretragaTabela, gbc_sp_pretragaTabela);

		table_vozila = new JTable();
		table_vozila.setModel(new DefaultTableModel(new Object[][] {
				{ "", null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Registarska oznaka", "Godina proizvodnje",
						"Vrsta vozila", "Marka vozila" }));
		sp_pretragaTabela.setViewportView(table_vozila);
	}
}
