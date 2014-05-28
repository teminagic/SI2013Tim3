package ba.co.edgewise.jmup.enums;

public enum VrstaVozila {

	Putnicki_automobil("Putnički automobil"), 
	Moped("Moped"), 
	Motocikl("Motocikl"), 
	Motorni_tricikl("Motorni tricikl"), 
	Cetverocikl("Četverocikl"), 
	Autobus("Autobus"), 
	Teretno_vozilo("Teretno vozilo"), 
	Prikljucno_vozilo("Priključno vozilo"), 
	Traktor("Traktor"), 
	Traktor_sa_gusjenicama("Traktor sa gusjenicama"), 
	Radna_masina("Radna mašina");
	
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
				return VrstaVozila.Putnicki_automobil;
			case "Moped":
				return VrstaVozila.Moped;
			case "Motorni tricikl":
				return VrstaVozila.Motorni_tricikl;
			case "Motocikl":
				return VrstaVozila.Motocikl;
			case "Četverocikl":
				return VrstaVozila.Cetverocikl;
			case "Autobus":
				return VrstaVozila.Autobus;
			case "Teretno vozilo":
				return VrstaVozila.Teretno_vozilo;
			case "Priključno vozilo":
				return VrstaVozila.Prikljucno_vozilo;
			case "Traktor":
				return VrstaVozila.Traktor;
			case "Traktor sa gusjenicama":
				return VrstaVozila.Traktor_sa_gusjenicama;
			case "Radna mašina":
				return VrstaVozila.Radna_masina;
			default:
				return null;
		}
	}
}

