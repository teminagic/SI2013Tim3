package ba.co.edgewise.jmup.enums;

public enum VrstaBoje {
	OBICNA("Obična"),
	METALIK("Metalik");
	
	private final String vrsta;
	
	private VrstaBoje(final String vrsta)
	{
		this.vrsta = vrsta;
	}
	
	@Override
	public String toString() {
		return this.vrsta;
	}
	
	public static VrstaBoje getVrstaBoje(String tip)
	{
		switch (tip) {
		case "Obična":
			return VrstaBoje.OBICNA;
		case "Metalik":
			return VrstaBoje.METALIK;
		default:
			return null;
		}
	}
}

