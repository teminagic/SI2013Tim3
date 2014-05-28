package ba.co.edgewise.jmup.enums;

public enum TipUposlenika {
	
	ADMINISTRATOR("Administrator"),
	SALTERSKI_RADNIK("�alterski radnik"),
	MENADZER("Menad�er");
	
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
			case "Šalter":
				return TipUposlenika.SALTERSKI_RADNIK;
			case "Menadžer":
				return TipUposlenika.MENADZER;
			default:
				return null;
		}
	}
	
}
