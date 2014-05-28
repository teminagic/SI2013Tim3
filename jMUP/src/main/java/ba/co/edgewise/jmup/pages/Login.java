package ba.co.edgewise.jmup.pages;

import javax.swing.*;

import ba.co.edgewise.jmup.components.LoginNaslov;
import ba.co.edgewise.jmup.components.LoginUnos;
import ba.co.edgewise.jmup.klase.*;
import ba.co.edgewise.jmup.enums.*;

import java.awt.*;

import javax.swing.border.*;

import ba.co.edgewise.jmup.components.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Login extends JFrame {

	private static final long serialVersionUID = -4409783328623751563L;
	
	private JPanel contentPane;
	private LoginNaslov naslov;
	private LoginUnos unos;
	
	static public ArrayList<Uposlenik> korisnici = new ArrayList<Uposlenik>();
	
	private Login forma = this;

	public static void main(String[] args) {
		korisnici.add(new Uposlenik(1,"Admin", "Admin", "Admin", "Admin", true, TipUposlenika.ADMINISTRATOR));
		korisnici.add(new Uposlenik(2,"Šalter", "Šalter", "Šalter", "Šalter", true, TipUposlenika.SALTERSKI_RADNIK));
		korisnici.add(new Uposlenik(3,"Boss", "Boss", "Boss", "Boss", true, TipUposlenika.MENADZER));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		setMinimumSize(new Dimension(650, 400));
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		naslov = new LoginNaslov();
		GridBagConstraints gbc_naslov = new GridBagConstraints();
		gbc_naslov.fill = GridBagConstraints.BOTH;
		gbc_naslov.insets = new Insets(0, 0, 5, 0);
		gbc_naslov.gridx = 0;
		gbc_naslov.gridy = 1;
		contentPane.add(naslov, gbc_naslov);
		
		unos = new LoginUnos();
		unos.getBtnPrijava().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = unos.getTfKorisnickoIme().getText();
				String password = new String(unos.getPwfSifra().getPassword());
				Uposlenik k = getKorisnik(username, password);
				if (k.getTip() == TipUposlenika.ADMINISTRATOR)
				{
					forma.dispose();
					AdminFrame novi = new AdminFrame();
					novi.setVisible(true);
				}
				else if (k.getTip() == TipUposlenika.SALTERSKI_RADNIK)
				{
					forma.dispose();
					SalterFrame novi = new SalterFrame();
					novi.setVisible(true);
				}
				else if (k.getTip() == TipUposlenika.MENADZER)
				{
					forma.dispose();
					BossFrame novi = new BossFrame();
					novi.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Fail");
				}
			}
		});
		GridBagConstraints gbc_unos = new GridBagConstraints();
		gbc_unos.insets = new Insets(0, 0, 5, 0);
		gbc_unos.fill = GridBagConstraints.HORIZONTAL;
		gbc_unos.gridx = 0;
		gbc_unos.gridy = 2;
		contentPane.add(unos, gbc_unos);
	}
	
	private Uposlenik getKorisnik(String username, String password){
		Uposlenik rezultat = new Uposlenik();
		for(Uposlenik k : korisnici)
		{
			if(k.getKorisnickoIme().equals(username) && k.getPassword().equals(password))
			{
				rezultat = k;
				break;
			}
		}
		return rezultat;
	}

}
