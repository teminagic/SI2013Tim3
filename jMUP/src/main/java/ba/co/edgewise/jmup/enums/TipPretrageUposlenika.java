package ba.co.edgewise.jmup.enums;

public enum TipPretrageUposlenika {

	IME("Ime korisnika"),
	PREZIME("Prezime korisnika"),
	USERNAME("Korisni\u010Dko ime")
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
