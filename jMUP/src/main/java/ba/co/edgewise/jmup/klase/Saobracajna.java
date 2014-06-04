package ba.co.edgewise.jmup.klase;

public class Saobracajna{
	
	String brojDozvole;
	Vozilo vozilo;
	Osoba korisnik;
	
	public Saobracajna() {
		super();
	}

	public Saobracajna(String brojDozvole, Vozilo vozilo, Osoba korisnik) {
		super();
		this.brojDozvole = brojDozvole;
		this.vozilo = vozilo;
		this.korisnik = korisnik;
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

	public Osoba getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Osoba korisnik) {
		this.korisnik = korisnik;
	}
	//UBACITI PARAMETRE
	public Object[] toObjectArray() {
	return new Object[]{this.brojDozvole, this.vozilo.getRegOznaka(), this.korisnik.getIme()+" "+this.korisnik.getPrezime(), this.korisnik.getJmbg_Id() };
	}	
}
