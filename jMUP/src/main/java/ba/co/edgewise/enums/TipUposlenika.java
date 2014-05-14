package ba.co.edgewise.enums;

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
		case "�alterski radnik":
			return TipUposlenika.SALTERSKI_RADNIK;
		case "Menad�er":
			return TipUposlenika.MENADZER;
		default:
			return null;
		}
	}
	
}
