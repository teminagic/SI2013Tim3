package ba.co.edgewise.jmup.enums;

public enum VrstaVozila {

	PUTNICKI_AUTOMOBIL("Putni�ki automobil"), 
	MOPED("Moped"), 
	MOTOCIKL("Motocikl"), 
	MOTORNI_TRICIKL("Motorni tricikl"), 
	CETVEROCIKL("�etverocikl"), 
	AUTOBUS("Autobus"), 
	TERETNO_VOZILO("Teretno vozilo"), 
	PRIKLJUCNO_VOZILO("Priklju�no vozilo"), 
	TRAKTOR("Traktor"), 
	TRAKTOR_SA_GUSJENICAMA("Traktor sa gusjenicama"), 
	RADNA_MASINA("Radna ma�ina");
	
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
			case "Putni�ki automobil":
				return VrstaVozila.PUTNICKI_AUTOMOBIL;
			case "Moped":
				return VrstaVozila.MOPED;
			case "Motorni tricikl":
				return VrstaVozila.MOTORNI_TRICIKL;
			case "Motocikl":
				return VrstaVozila.MOTOCIKL;
			case "�etverocikl":
				return VrstaVozila.CETVEROCIKL;
			case "Autobus":
				return VrstaVozila.AUTOBUS;
			case "Teretno vozilo":
				return VrstaVozila.TERETNO_VOZILO;
			case "Priklju�no vozilo":
				return VrstaVozila.PRIKLJUCNO_VOZILO;
			case "Traktor":
				return VrstaVozila.TRAKTOR;
			case "Traktor sa gusjenicama":
				return VrstaVozila.TRAKTOR_SA_GUSJENICAMA;
			case "Radna ma�ina":
				return VrstaVozila.RADNA_MASINA;
			default:
				return null;
		}
	}
}

