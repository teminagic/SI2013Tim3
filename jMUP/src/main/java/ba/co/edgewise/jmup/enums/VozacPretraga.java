package ba.co.edgewise.jmup.enums;

public enum VozacPretraga { 
	Ime("Ime"),
	Prezime("Prezime"), 
	JMBG("JMBG"); 
	
	private final String stringValue;
   private VozacPretraga(final String s) { stringValue = s; }
   public String toString() { return stringValue; }
}