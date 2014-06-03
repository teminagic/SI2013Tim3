package ba.co.edgewise.jmup.mvc.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.co.edgewise.jmup.components.*;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Login extends JFrame {

	private static final long serialVersionUID = 5494623184975602741L;
	private JPanel contentPane;
	private LoginNaslov naslov;
	private LoginUnos unos;

	public Login() {
		layoutSet();
		panelSet();
	}
	
	public void layoutSet(){
		setTitle("JMup - Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setMinimumSize(new Dimension(800, 600));
		setVisible(true);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
	}
	
	public void panelSet(){
		naslov = new LoginNaslov();
		GridBagConstraints gbc_naslov = new GridBagConstraints();
		gbc_naslov.anchor = GridBagConstraints.SOUTH;
		gbc_naslov.fill = GridBagConstraints.HORIZONTAL;
		gbc_naslov.insets = new Insets(0, 0, 5, 0);
		gbc_naslov.gridx = 0;
		gbc_naslov.gridy = 1;
		this.contentPane.add(naslov, gbc_naslov);
		
		unos = new LoginUnos();
		GridBagConstraints gbc_unos = new GridBagConstraints();
		gbc_unos.insets = new Insets(0, 0, 5, 0);
		gbc_unos.anchor = GridBagConstraints.NORTH;
		gbc_unos.fill = GridBagConstraints.HORIZONTAL;
		gbc_unos.gridx = 0;
		gbc_unos.gridy = 2;
		this.contentPane.add(unos, gbc_unos);
	}

	public LoginUnos getUnos() {
		return unos;
	}
}
