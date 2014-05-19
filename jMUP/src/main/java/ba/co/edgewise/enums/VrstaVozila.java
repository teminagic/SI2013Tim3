package ba.co.edgewise.enums;

public enum VrstaVozila {

	Putnicki_automobil("Putnièki automobil"), 
	Moped("Moped"), 
	Motocikl("Motocikl"), 
	Motorni_tricikl("Motorni tricikl"), 
	Cetverocikl("Èetverocikl"), 
	Autobus("Autobus"), 
	Teretno_vozilo("Teretno vozilo"), 
	Prikljucno_vozilo("Prikljuèno vozilo"), 
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
			case "Putnièki automobil":
				return VrstaVozila.Putnicki_automobil;
			case "Moped":
				return VrstaVozila.Moped;
			case "Motorni tricikl":
				return VrstaVozila.Motorni_tricikl;
			case "Motocikl":
				return VrstaVozila.Motocikl;
			case "Èetverocikl":
				return VrstaVozila.Cetverocikl;
			case "Autobus":
				return VrstaVozila.Autobus;
			case "Teretno vozilo":
				return VrstaVozila.Teretno_vozilo;
			case "Prikljuèno vozilo":
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

