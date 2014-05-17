package ba.co.edgewise.jmup.klase;
public class Vlasnicka extends Dozvola{

	// dodati podatke koji se nalaze u vlasnickoj, a nisu vec navedeni u klasi Dozovola
	
	// Konstruktor sa parametrima
	public Vlasnicka(int brojDozvole, Vozilo vozilo, Vozac vozac) {
		super(brojDozvole, vozilo, vozac);
	}
	// Konstruktor bez parametara
	public Vlasnicka() {
		super();
	}

}
