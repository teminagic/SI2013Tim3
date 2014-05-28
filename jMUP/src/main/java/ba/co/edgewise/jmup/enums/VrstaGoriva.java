package ba.co.edgewise.jmup.enums;

public enum VrstaGoriva {
	
	BENZIN("Benzin"), 
	BENZIN_LPG("Benzin/LPG"), 
	BENZIN_CNG("Benzin/CNG"), 
	BENZIN_ELEKTRICNI("Benzin/elektri�ni"), 
	DIZEL("Dizel"), 
	DIZEL_CNG("Dizel/CNG"),
	DIZEL_ELEKTRICNI("Dizel/elektri�ni"), 
	ELEKTRICNI_POGON("Elektri�ni pogon"), 
	BIODIZEL("Biodizel"), 
	ETANOL("Etanol"), 
	METANOL("Metanol"), 
	HIDROGEN("Hidrogen(vodonik)"), 
	LPG("LPG"), 
	CNG("CNG");

	private final String vrsta;
	
	private VrstaGoriva(final String vrsta)
	{
		this.vrsta = vrsta;
	}
	@Override
	public String toString() {
		return this.vrsta;
	}
	
	public static VrstaGoriva getVrstaGoriva(String tip)
	{
		switch (tip) {
			case "Benzin":
				return VrstaGoriva.BENZIN;
			case "Benzin/LPG":
				return VrstaGoriva.BENZIN_LPG;
			case "Benzin/CNG":
				return VrstaGoriva.BENZIN_CNG;
			case "Benzin/elektri�ni":
				return VrstaGoriva.BENZIN_ELEKTRICNI;
			case "Dizel":
				return VrstaGoriva.DIZEL;
			case "Dizel/CNG":
				return VrstaGoriva.DIZEL_CNG;
			case "Dizel/elektri�ni":
				return VrstaGoriva.DIZEL_ELEKTRICNI;
			case "Elektri�ni pogon":
				return VrstaGoriva.ELEKTRICNI_POGON;
			case "Biodizel":
				return VrstaGoriva.BIODIZEL;
			case "Etanol":
				return VrstaGoriva.ETANOL;
			case "Metanol":
				return VrstaGoriva.METANOL;
			case "Hidrogen(vodonik)":
				return VrstaGoriva.HIDROGEN;
			case "LPG":
				return VrstaGoriva.LPG;
			case "CNG":
				return VrstaGoriva.CNG;
			default:
				return null;
		}
	}
}
