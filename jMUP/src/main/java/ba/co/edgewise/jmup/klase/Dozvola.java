package ba.co.edgewise.jmup.klase;

public class Dozvola { // 	DA LI TREBA DA IH SADRZI KAO PRIVATNE ATRIBUTE??? ZASTO ASOCIJACIJA?
	
	private int brojDozvole;
	// U dozvoli se nalaze podaci o vozilu i o vozacima, tako je uradjeno i sa klasama.
	private Vozilo vozilo;
	// Dalje, o vrstama vozaca, pogledati klasu Vozac i klase koje su naslijedjene iz nje
	// U ovoj klasi se samo cuva Vozac. Kako su iz klase Dozvola naslijedjene klase Saobracajna i Vlasnicka
	// Tako ce u ovom atributu "Vozac" biti ili VlasnikVozila ili KorisnikVozila
	// Pretpostavljeno je da postoji samo jedan vlasnik vozila! (bar sad za sad!)
	private Vozac vozac;
	
	
	// Konstruktor sa parametrima
	public Dozvola(int brojDozvole, Vozilo vozilo, Vozac vozac) {
		this.brojDozvole = brojDozvole;
		this.vozilo = vozilo;
		this.vozac = vozac;
	}
	// Konstruktor bez parametara
	public Dozvola() {
		this.vozac = new Vozac();
		this.vozilo = new Vozilo();
	}
	
	int getBrojDozvole() {
		return brojDozvole;
	}
	void setBrojDozvole(int brojDozvole) {
		this.brojDozvole = brojDozvole;
	}
	private Vozilo getVozilo() {
		return vozilo;
	}
	private void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}
	private Vozac getVozac() {
		return vozac;
	}
	private void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}

}
