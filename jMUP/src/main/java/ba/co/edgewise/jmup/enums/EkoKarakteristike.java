package ba.co.edgewise.jmup.enums;

public enum EkoKarakteristike {
	
	KONVENCIONALNO("Konvencionalno"), 
	EURO1("Euro 1"), 
	EURO2("Euro 2"), 
	EURO3("Euro 3"), 
	EURO4("Euro 4"), 
	EURO5("Euro 5");

	private final String vrsta;
	
	private EkoKarakteristike(final String vrsta)
	{
		this.vrsta = vrsta;
	}
	@Override
	public String toString() {
		return this.vrsta;
	}
	
	public static EkoKarakteristike getEkoKarakteristike(String tip)
	{
		switch (tip) {
			case "Konvencionalno":
				return EkoKarakteristike.KONVENCIONALNO;
			case "Euro 1":
				return EkoKarakteristike.EURO1;
			case "Euro 2":
				return EkoKarakteristike.EURO2;
			case "Euro 3":
				return EkoKarakteristike.EURO3;
			case "Euro 4":
				return EkoKarakteristike.EURO4;
			case "Euro 5":
				return EkoKarakteristike.EURO5;
			default:
				return null;
		}
	}
}
