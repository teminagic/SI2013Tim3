package ba.co.edgewise.jmup.klase;

public class Osoba {
	
	int id;
	String jmbg_Id;
	String prezime;
	String ime;
	String prebivaliste;
	boolean pravnoLice;
	
	public Osoba(){}

	public Osoba(int id, String jmbg_Id, String prezime, String ime,
			String prebivaliste, boolean pravnoLice) {
		super();
		this.id = id;
		this.jmbg_Id = jmbg_Id;
		this.prezime = prezime;
		this.ime = ime;
		this.prebivaliste = prebivaliste;
		this.pravnoLice = pravnoLice;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJmbg_Id() {
		return jmbg_Id;
	}

	public void setJmbg_Id(String jmbg_Id) {
		this.jmbg_Id = jmbg_Id;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrebivaliste() {
		return prebivaliste;
	}

	public void setPrebivaliste(String prebivaliste) {
		this.prebivaliste = prebivaliste;
	}

	public boolean isPravnoLice() {
		return pravnoLice;
	}

	public void setPravnoLice(boolean pravnoLice) {
		this.pravnoLice = pravnoLice;
	}
	public Object[] toObjectArray() {
		return new Object[]{this.ime, this.prezime, this.jmbg_Id};
	}
}
