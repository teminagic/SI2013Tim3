package ba.co.edgewise.jmup.enums;

public enum SaobracajnaPretraga { 
	Broj_potvrde("Broj potvrde"), 
	Registarska_oznaka("Registarska oznaka"), 
	Ime_prezime("Ime i prezime"), 
	JMBG_vozaca("JMBG voza\u010Da"); 
	
	private final String stringValue;
	private SaobracajnaPretraga(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}