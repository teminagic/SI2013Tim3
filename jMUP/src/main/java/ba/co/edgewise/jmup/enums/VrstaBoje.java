package ba.co.edgewise.jmup.enums;

public enum VrstaBoje {
	OBICNA("Obi\u010Dna"),
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
		case "Obi\u010Dna":
			return VrstaBoje.OBICNA;
		case "Metalik":
			return VrstaBoje.METALIK;
		default:
			return null;
		}
	}
}

