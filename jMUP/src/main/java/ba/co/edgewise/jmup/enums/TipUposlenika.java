package ba.co.edgewise.jmup.enums;

public enum TipUposlenika {
	
	ADMINISTRATOR("Administrator"),
	SALTERSKI_RADNIK("\u0160alterski radnik"),
	MENADZER("Menad\u017Eer");
	
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
			case "\u0160alterski radnik":
				return TipUposlenika.SALTERSKI_RADNIK;
			case "Menad\u017Eer":
				return TipUposlenika.MENADZER;
			default:
				return null;
		}
	}
	
}
