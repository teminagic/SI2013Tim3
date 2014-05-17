package ba.co.edgewise.jmup.klase;

public class Saobracajna extends Dozvola{
	private String regOznaka;
	// dodati podatke koji se nalaze u saobracajnoj, a nisu vec navedeni u klasi Dozovola
	
	// Konstruktor sa parametrima
	public Saobracajna(int brojDozvole, Vozilo vozilo, Vozac vozac, String regOznaka) {
		super(brojDozvole, vozilo, vozac);
		this.setRegOznaka(regOznaka);
	}
	// Konstruktor bez parametara
	public Saobracajna() {
		super();
	}
	private String getRegOznaka() {
		return regOznaka;
	}
	private void setRegOznaka(String regOznaka) {
		this.regOznaka = regOznaka;
	}

}
