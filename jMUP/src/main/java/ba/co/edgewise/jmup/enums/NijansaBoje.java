package ba.co.edgewise.jmup.enums;

public enum NijansaBoje {

	STANDARDNA("Standardna"),
	SVJETLIJA("Svjetlija"),
	TAMNIJA("Tamnija");
	
	private final String nijansa;
	
	private NijansaBoje(final String nijansa)
	{
		this.nijansa = nijansa;
	}
	
	@Override
	public String toString() {
		return this.nijansa;
	}
	
	public static NijansaBoje getNijansaBoje(String tip)
	{
		switch (tip) {
		case "Standardna":
			return NijansaBoje.STANDARDNA;
		case "Svjetlija":
			return NijansaBoje.SVJETLIJA;
		case "Tamnija":
			return NijansaBoje.TAMNIJA;
		default:
			return null;
		}
	}
}
