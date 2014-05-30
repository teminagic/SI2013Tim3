package ba.co.edgewise.jmup.enums;

public enum VoziloPretraga { 
	Registarska_oznaka("Registarska oznaka"), 
	Godina_proizvodnje("Godina proizvodnje"), 
	Vrsta_vozila("Vrsta vozila"), 
	Marka_vozila("Marka vozila");
	
	private final String stringValue;
	private VoziloPretraga(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}