package co.ba.edgewise.components;
//
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalterskaPretragaVlasnicka extends JPanel {
	
	private static final long serialVersionUID = -4719468020930451083L;
	private JTable table_vlasnicke;
	private GridBagLayout gridBagLayout;

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

		table_vlasnicke = new JTable();
		table_vlasnicke.setModel(new DefaultTableModel(new Object[][] {
				{ "", null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Identifikacijski broj potvrde",
						"Registarska oznaka", "Ime i prezime vlasnika",
						"JMBG Vlasnika" }));
		sp_pretragaTabela.setViewportView(table_vlasnicke);
	}

}
