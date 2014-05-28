package ba.co.edgewise.jmup.enums;

public enum VrstaVozila {

	PUTNICKI_AUTOMOBIL("Putnički automobil"), 
	MOPED("Moped"), 
	MOTOCIKL("Motocikl"), 
	MOTORNI_TRICIKL("Motorni tricikl"), 
	CETVEROCIKL("Četverocikl"), 
	AUTOBUS("Autobus"), 
	TERETNO_VOZILO("Teretno vozilo"), 
	PRIKLJUČNO_VOZILO("Priključno vozilo"), 
	TRAKTOR("Traktor"), 
	TRAKTOR_SA_GUSJENICAMA("Traktor sa gusjenicama"), 
	RADNA_MAŠINA("Radna mašina");
	
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
			case "Putnički automobil":
				return VrstaVozila.PUTNICKI_AUTOMOBIL;
			case "Moped":
				return VrstaVozila.MOPED;
			case "Motorni tricikl":
				return VrstaVozila.MOTORNI_TRICIKL;
			case "Motocikl":
				return VrstaVozila.MOTOCIKL;
			case "Četverocikl":
				return VrstaVozila.CETVEROCIKL;
			case "Autobus":
				return VrstaVozila.AUTOBUS;
			case "Teretno vozilo":
				return VrstaVozila.TERETNO_VOZILO;
			case "Priključno vozilo":
				return VrstaVozila.PRIKLJUČNO_VOZILO;
			case "Traktor":
				return VrstaVozila.TRAKTOR;
			case "Traktor sa gusjenicama":
				return VrstaVozila.TRAKTOR_SA_GUSJENICAMA;
			case "Radna mašina":
				return VrstaVozila.RADNA_MAŠINA;
			default:
				return null;
		}
	}
}

