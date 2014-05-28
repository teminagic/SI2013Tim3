package ba.co.edgewise.jmup.enums;

public enum VrstaVozila {

	PUTNICKI_AUTOMOBIL("Putni\u010Dki automobil"), 
	MOPED("Moped"), 
	MOTOCIKL("Motocikl"), 
	MOTORNI_TRICIKL("Motorni tricikl"), 
	CETVEROCIKL("\u010Cetverocikl"), 
	AUTOBUS("Autobus"), 
	TERETNO_VOZILO("Teretno vozilo"), 
	PRIKLJUCNO_VOZILO("Priklju\u010Dno vozilo"), 
	TRAKTOR("Traktor"), 
	TRAKTOR_SA_GUSJENICAMA("Traktor sa gusjenicama"), 
	RADNA_MASINA("Radna ma\u0161ina");
	
	private final String vrsta;
	
	private VrstaVozila(final String vrsta)
	{
		this.vrsta = vrsta;
	}
	@Override
	public String toString() {
		return this.vrsta;
	}
	public static VrstaVozila getVrstaVozila(String tip)
	{
		switch (tip) {
			case "Putni\u010Dki automobil":
				return VrstaVozila.PUTNICKI_AUTOMOBIL;
			case "Moped":
				return VrstaVozila.MOPED;
			case "Motorni tricikl":
				return VrstaVozila.MOTORNI_TRICIKL;
			case "Motocikl":
				return VrstaVozila.MOTOCIKL;
			case "\u010Cetverocikl":
				return VrstaVozila.CETVEROCIKL;
			case "Autobus":
				return VrstaVozila.AUTOBUS;
			case "Teretno vozilo":
				return VrstaVozila.TERETNO_VOZILO;
			case "Priklju\u010Dno vozilo":
				return VrstaVozila.PRIKLJUCNO_VOZILO;
			case "Traktor":
				return VrstaVozila.TRAKTOR;
			case "Traktor sa gusjenicama":
				return VrstaVozila.TRAKTOR_SA_GUSJENICAMA;
			case "Radna ma\u0161ina":
				return VrstaVozila.RADNA_MASINA;
			default:
				return null;
		}
	}
}

