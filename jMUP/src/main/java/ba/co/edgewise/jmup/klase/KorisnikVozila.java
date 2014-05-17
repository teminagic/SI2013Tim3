package ba.co.edgewise.jmup.klase;

public class KorisnikVozila extends Vozac{

	private String JMBG;
	// Dodati jos parametara
	
	// Konstruktor sa parametrima
	public KorisnikVozila(String JMBG) {
		// Dodati atribute u kostruktor sa parametrima od Vozac-a
		super();
	}
	
	// Konstruktor bez parametara
	public KorisnikVozila() {
		super();
	}

	private String getJMBG() {
		return JMBG;
	}

	private void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	

}
