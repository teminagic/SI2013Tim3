package ba.co.edgewise.enums;

public enum VrstaGoriva {
	
	Benzin("Benzin"), 
	Benzin_LPG("Benzin/LPG"), 
	Benzin_CNG("Benzin/CNG"), 
	Benzin_elektricni("Benzin/električni"), 
	Dizel("Dizel"), 
	Dizel_CNG("Dizel/CNG"),
	Dizel_elektricni("Dizel/električni"), 
	Elektricni_pogon("Električni pogon"), 
	Biodizel("Biodizel"), 
	Etanol("Etanol"), 
	Metanol("Metanol"), 
	Hidrogen("Hidrogen(vodonik)"), 
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
				return VrstaGoriva.Benzin;
			case "Benzin/LPG":
				return VrstaGoriva.Benzin_LPG;
			case "Benzin/CNG":
				return VrstaGoriva.Benzin_CNG;
			case "Benzin/električni":
				return VrstaGoriva.Benzin_elektricni;
			case "Dizel":
				return VrstaGoriva.Dizel;
			case "Dizel/CNG":
				return VrstaGoriva.Dizel_CNG;
			case "Dizel/električni":
				return VrstaGoriva.Dizel_elektricni;
			case "Električni pogon":
				return VrstaGoriva.Elektricni_pogon;
			case "Biodizel":
				return VrstaGoriva.Biodizel;
			case "Etanol":
				return VrstaGoriva.Etanol;
			case "Metanol":
				return VrstaGoriva.Metanol;
			case "Hidrogen(vodonik)":
				return VrstaGoriva.Hidrogen;
			case "LPG":
				return VrstaGoriva.LPG;
			case "CNG":
				return VrstaGoriva.CNG;
			default:
				return null;
		}
	}
}
