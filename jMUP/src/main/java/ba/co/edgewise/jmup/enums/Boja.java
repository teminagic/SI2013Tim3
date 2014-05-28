package ba.co.edgewise.jmup.enums;


public enum Boja {
	CRNA("Crna"),
	CRVENA("Crvena"),
	ZUTA("\u017Duta"),
	PLAVA("Plava"),
	ZELENA("Zelena");
	
	private String _naziv;
	
	private Boja(final String naziv)
	{
		this._naziv = naziv;
	}

	@Override
	public String toString() {
		return this._naziv;
	}
	
	public static Boja getBoja(String boja)
	{
		switch (boja) {
		case "Crna":
			return Boja.CRNA;
		case "Crvena":
			return Boja.CRVENA;
		case "\u017Duta":
			return Boja.ZUTA;
		case "Plava":
			return Boja.PLAVA;
		case "Zelena":
			return Boja.ZELENA;
		default:
			return null;
		}
	}


}
