package ba.co.edgewise.jmup.enums;

public enum VrstaVozila {

	PUTNICKI_AUTOMOBIL("Putnièki automobil"), 
	MOPED("Moped"), 
	MOTOCIKL("Motocikl"), 
	MOTORNI_TRICIKL("Motorni tricikl"), 
	CETVEROCIKL("Èetverocikl"), 
	AUTOBUS("Autobus"), 
	TERETNO_VOZILO("Teretno vozilo"), 
	PRIKLJUCNO_VOZILO("Prikljuèno vozilo"), 
	TRAKTOR("Traktor"), 
	TRAKTOR_SA_GUSJENICAMA("Traktor sa gusjenicama"), 
	RADNA_MASINA("Radna mašina");
	
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
			case "Putnièki automobil":
				return VrstaVozila.PUTNICKI_AUTOMOBIL;
			case "Moped":
				return VrstaVozila.MOPED;
			case "Motorni tricikl":
				return VrstaVozila.MOTORNI_TRICIKL;
			case "Motocikl":
				return VrstaVozila.MOTOCIKL;
			case "Èetverocikl":
				return VrstaVozila.CETVEROCIKL;
			case "Autobus":
				return VrstaVozila.AUTOBUS;
			case "Teretno vozilo":
				return VrstaVozila.TERETNO_VOZILO;
			case "Prikljuèno vozilo":
				return VrstaVozila.PRIKLJUCNO_VOZILO;
			case "Traktor":
				return VrstaVozila.TRAKTOR;
			case "Traktor sa gusjenicama":
				return VrstaVozila.TRAKTOR_SA_GUSJENICAMA;
			case "Radna mašina":
				return VrstaVozila.RADNA_MASINA;
			default:
				return null;
		}
	}
}

