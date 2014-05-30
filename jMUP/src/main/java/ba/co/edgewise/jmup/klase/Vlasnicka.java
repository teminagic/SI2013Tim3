package ba.co.edgewise.jmup.klase;

public class Vlasnicka{
	
	String brojDozvole;
	Vozilo vozilo;
	Osoba vlasnik;
	
	

	public Vlasnicka() {
		super();
	}


	public Vlasnicka(String brojDozvole, Vozilo vozilo, Osoba vlasnik) {
		super();
		this.brojDozvole = brojDozvole;
		this.vozilo = vozilo;
		this.vlasnik = vlasnik;
	}


	public String getBrojDozvole() {
		return brojDozvole;
	}


	public void setBrojDozvole(String brojDozvole) {
		this.brojDozvole = brojDozvole;
	}


	public Vozilo getVozilo() {
		return vozilo;
	}


	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}


	public Osoba getVlasnik() {
		return vlasnik;
	}


	public void setVlasnik(Osoba vlasnik) {
		this.vlasnik = vlasnik;
	}
	
	//UBACITI PARAMETRE
	public Object[] toObjectArray() {
		return new Object[]{ };
	}	
	//public enum VlasnickaPretraga { Broj_potvrde("Broj potvrde"), Registarska_oznaka(""), Ime_prezime("Ime i prezime"), JMBG_vlasnika("JMBG vlasnika") ; 

	
}
