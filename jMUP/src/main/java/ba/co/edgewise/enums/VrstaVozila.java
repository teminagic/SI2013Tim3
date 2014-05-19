package ba.co.edgewise.enums;

public enum VrstaVozila {

	Putnicki_automobil("Putni�ki automobil"), 
	Moped("Moped"), 
	Motocikl("Motocikl"), 
	Motorni_tricikl("Motorni tricikl"), 
	Cetverocikl("�etverocikl"), 
	Autobus("Autobus"), 
	Teretno_vozilo("Teretno vozilo"), 
	Prikljucno_vozilo("Priklju�no vozilo"), 
	Traktor("Traktor"), 
	Traktor_sa_gusjenicama("Traktor sa gusjenicama"), 
	Radna_masina("Radna ma�ina");
	
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
				return VrstaVozila.Putnicki_automobil;
			case "Moped":
				return VrstaVozila.Moped;
			case "Motorni tricikl":
				return VrstaVozila.Motorni_tricikl;
			case "Motocikl":
				return VrstaVozila.Motocikl;
			case "�etverocikl":
				return VrstaVozila.Cetverocikl;
			case "Autobus":
				return VrstaVozila.Autobus;
			case "Teretno vozilo":
				return VrstaVozila.Teretno_vozilo;
			case "Priklju�no vozilo":
				return VrstaVozila.Prikljucno_vozilo;
			case "Traktor":
				return VrstaVozila.Traktor;
			case "Traktor sa gusjenicama":
				return VrstaVozila.Traktor_sa_gusjenicama;
			case "Radna ma�ina":
				return VrstaVozila.Radna_masina;
			default:
				return null;
		}
	}
}

