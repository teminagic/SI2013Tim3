package ba.co.edgewise.jmup.klase;

import ba.co.edgewise.enums.Boja;
import ba.co.edgewise.jmup.klase.Vozilo;

public class BojaVozila {
	
	private Boja _boja;
	private Vozilo _vozilo;
	private String _nijansa;
	private String _vrsta;
	private String _tip;
	
	public BojaVozila() {}
	
	public BojaVozila(
	Boja boja,
	Vozilo vozilo,
	String nijansa,
	String vrsta,
	String tip )
	{
		this._boja = boja;
		this._vozilo = vozilo;
		this._nijansa = nijansa;
		this._vrsta = vrsta;
		this._tip = tip;
	}
	
	//get & set
	public Boja get_boja() {
		return _boja;
	}

	public void set_boja(Boja _boja) {
		this._boja = _boja;
	}

	public Vozilo get_vozilo() {
		return _vozilo;
	}

	public void set_vozilo(Vozilo _vozilo) {
		this._vozilo = _vozilo;
	}

	public String get_nijansa() {
		return _nijansa;
	}

	public void set_nijansa(String _nijansa) {
		this._nijansa = _nijansa;
	}

	public String get_vrsta() {
		return _vrsta;
	}

	public void set_vrsta(String _vrsta) {
		this._vrsta = _vrsta;
	}

	public String get_tip() {
		return _tip;
	}

	public void set_tip(String _tip) {
		this._tip = _tip;
	}
	
	

}
