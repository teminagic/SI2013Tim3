package ba.co.edgewise.jmup.enums;

public enum TipUposlenika {
	
	ADMINISTRATOR("Administrator"),
	SALTERSKI_RADNIK("Šalterski radnik"),
	MENADZER("Menadžer");
	
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
			case "Šalterski radnik":
				return TipUposlenika.SALTERSKI_RADNIK;
			case "Menadžer":
				return TipUposlenika.MENADZER;
			default:
				return null;
		}
	}
	
}
