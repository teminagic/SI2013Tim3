package ba.co.edgewise.jmup.klase;
import java.awt.image.*;

// Nasljedjivanje se vrsilo radi razlicitih metoda koje posjeduju razliciti tipovi korisnika
public class Administrator extends Uposlenik {

	public Administrator(String ime, String prezime, BufferedImage slikaKorisnika, String korisnickoIme, String password, Boolean status) {
		super(ime, prezime, slikaKorisnika, korisnickoIme, password, status);
	}
	
	public Administrator() {
		super();
	}
	// metode:
	
}
