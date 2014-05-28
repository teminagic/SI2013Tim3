package ba.co.edgewise.jmup.enums;

public enum TipPretrageUposlenika {

	IME("Ime korisnika"),
	PREZIME("Prezime korisnika"),
	USERNAME("Korisni�ko ime")
	;
	
	TipPretrageUposlenika(String text)
	{
		this.text = text;
	}
	
	private final String text;

	@Override
	public String toString() {
		return text;
	}
}
