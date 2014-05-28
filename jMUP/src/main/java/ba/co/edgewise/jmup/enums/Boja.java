package ba.co.edgewise.jmup.enums;


public enum Boja {
	CRNA("crna"),
	CRVENA("crvena"),
	�UTA("�uta"),
	PLAVA("plava"),
	ZELENA("zelena");
	
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
		case "crna":
			return Boja.CRNA;
		case "crvena":
			return Boja.CRVENA;
		case "�uta":
			return Boja.�UTA;
		case "plava":
			return Boja.PLAVA;
		case "zelena":
			return Boja.ZELENA;
		default:
			return null;
		}
	}


}
