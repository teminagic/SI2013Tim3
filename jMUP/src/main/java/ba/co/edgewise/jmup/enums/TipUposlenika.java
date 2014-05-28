package ba.co.edgewise.jmup.enums;

public enum TipUposlenika {
	
	ADMINISTRATOR("Administrator"),
	SALTERSKI_RADNIK("öalterski radnik"),
	MENADZER("Menadûer");
	
	private final String text;
	
	private TipUposlenika(final String text)
	{
		this.text = text;
	}

	@Override
	public String toString() {
		return this.text;
	}
	
	public static TipUposlenika getTipUposlenika(String tip)
	{
		switch (tip) {
			case "Administrator":
				return TipUposlenika.ADMINISTRATOR;
			case "≈†alterski radnik":
				return TipUposlenika.SALTERSKI_RADNIK;
			case "Menad≈æer":
				return TipUposlenika.MENADZER;
			default:
				return null;
		}
	}
	
}
