package ba.co.edgewise.enums;

public enum VrstaBoje {
	OBIČNA("Obična"),
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
			return VrstaBoje.OBIČNA;
		case "Metalik":
			return VrstaBoje.METALIK;
		default:
			return null;
		}
	}
}

