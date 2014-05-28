package ba.co.edgewise.jmup.components;
//
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class LoginUnos extends JPanel {

	private static final long serialVersionUID = -6880638709725337315L;
	private JTextField tfKorisnickoIme;
	private JPasswordField pwfSifra;
	private JButton btnPrijava;
	private JPanel panel;
	private JLabel lblKorisnickoIme;
	private JLabel lblSifra;
	
	public JTextField getTfKorisnickoIme() {
		return tfKorisnickoIme;
	}

	public JPasswordField getPwfSifra() {
		return pwfSifra;
	}

	public JButton getBtnPrijava() {
		return btnPrijava;
	}

	public LoginUnos() {
		
		setLayout(new BorderLayout(0, 0));
		panelSet();
		labelSet();
		inputSet();
		buttonSet();
	}
	
	public void panelSet() {
		panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 100, 150, 0, 0 };
		gbl_panel.rowHeights = new int[] { 10, 39, 34, 0, 10, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
	}
	
	public void labelSet() {
		lblKorisnickoIme = new JLabel("Korisni\u010Dko ime:");
		GridBagConstraints gbc_lblKorisnickoIme = new GridBagConstraints();
		gbc_lblKorisnickoIme.anchor = GridBagConstraints.EAST;
		gbc_lblKorisnickoIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblKorisnickoIme.gridx = 1;
		gbc_lblKorisnickoIme.gridy = 1;
		panel.add(lblKorisnickoIme, gbc_lblKorisnickoIme);
		
		lblSifra = new JLabel("\u0160ifra:");
		GridBagConstraints gbc_lblSifra = new GridBagConstraints();
		gbc_lblSifra.insets = new Insets(0, 0, 5, 5);
		gbc_lblSifra.anchor = GridBagConstraints.EAST;
		gbc_lblSifra.gridx = 1;
		gbc_lblSifra.gridy = 2;
		panel.add(lblSifra, gbc_lblSifra);
	}
	
	public void inputSet() {
		tfKorisnickoIme = new JTextField();
		GridBagConstraints gbc_tfKorisnickoIme = new GridBagConstraints();
		gbc_tfKorisnickoIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisnickoIme.gridx = 2;
		gbc_tfKorisnickoIme.gridy = 1;
		panel.add(tfKorisnickoIme, gbc_tfKorisnickoIme);
		tfKorisnickoIme.setColumns(10);

		pwfSifra = new JPasswordField();
		GridBagConstraints gbc_pwfSifra = new GridBagConstraints();
		gbc_pwfSifra.insets = new Insets(0, 0, 5, 5);
		gbc_pwfSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwfSifra.gridx = 2;
		gbc_pwfSifra.gridy = 2;
		panel.add(pwfSifra, gbc_pwfSifra);
	}
	
	public void buttonSet() {
		btnPrijava = new JButton("Prijava");
		GridBagConstraints gbc_btnPrijava = new GridBagConstraints();
		gbc_btnPrijava.anchor = GridBagConstraints.EAST;
		gbc_btnPrijava.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrijava.gridx = 2;
		gbc_btnPrijava.gridy = 3;
		panel.add(btnPrijava, gbc_btnPrijava);
	}

}
