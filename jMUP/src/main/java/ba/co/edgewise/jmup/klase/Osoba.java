package ba.co.edgewise.jmup.klase;

public class Osoba {
	String _jmbg_id;
	String _prezime;
	String _ime;
	String _prebivaliste;
	boolean _pravnoLice;
	
	public Osoba(){}

	public Osoba(String jmbg_id, String prezime, String ime,
			String prebivaliste, boolean pravnoLice) {
		this._jmbg_id = jmbg_id;
		this._prezime = prezime;
		this._ime = ime;
		this._prebivaliste = prebivaliste;
		this._pravnoLice = pravnoLice;
	}

	public String get_jmbg_id() {
		return _jmbg_id;
	}

	public void set_jmbg_id(String _jmbg_id) {
		this._jmbg_id = _jmbg_id;
	}

	public String get_prezime() {
		return _prezime;
	}

	public void set_prezime(String _prezime) {
		this._prezime = _prezime;
	}

	public String get_ime() {
		return _ime;
	}

	public void set_ime(String _ime) {
		this._ime = _ime;
	}

	public String get_prebivaliste() {
		return _prebivaliste;
	}

	public void set_prebivaliste(String _prebivaliste) {
		this._prebivaliste = _prebivaliste;
	}

	public boolean is_pravnoLice() {
		return _pravnoLice;
	}

	public void set_pravnoLice(boolean _pravnoLice) {
		this._pravnoLice = _pravnoLice;
	}

}
