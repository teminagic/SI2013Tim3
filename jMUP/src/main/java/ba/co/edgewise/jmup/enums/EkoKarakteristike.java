package ba.co.edgewise.jmup.enums;

public enum EkoKarakteristike {
	
	Konvencionalno("Konvencionalno"), 
	Euro_1("Euro 1"), 
	Euro_2("Euro 2"), 
	Euro_3("Euro 3"), 
	Euro_4("Euro 4"), 
	Euro_5("Euro 5");

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
				return EkoKarakteristike.Konvencionalno;
			case "Euro 1":
				return EkoKarakteristike.Euro_1;
			case "Euro 2":
				return EkoKarakteristike.Euro_2;
			case "Euro 3":
				return EkoKarakteristike.Euro_3;
			case "Euro 4":
				return EkoKarakteristike.Euro_4;
			case "Euro 5":
				return EkoKarakteristike.Euro_5;
			default:
				return null;
		}
	}
}
