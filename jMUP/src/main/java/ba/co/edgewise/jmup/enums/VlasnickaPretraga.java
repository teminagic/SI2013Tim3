package ba.co.edgewise.jmup.enums;

public enum VlasnickaPretraga { 
	Broj_potvrde("Broj potvrde"), 
	Registarska_oznaka("Registarska oznaka"), 
	Ime_prezime("Ime i prezime"), 
	JMBG_vlasnika("JMBG vlasnika") ; 
	
	private final String stringValue;
	private VlasnickaPretraga(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}