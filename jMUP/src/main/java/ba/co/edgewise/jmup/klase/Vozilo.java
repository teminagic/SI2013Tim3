package ba.co.edgewise.jmup.klase;
public class Vozilo {

	// dodati privatne atribute za vozilo
	String _marka; 
	String _tip;
	String _model;
	String _brojSasije;
	String _oblikKaroserije;
	String _godinaProizvodnje;
	Integer _motor;
	Double _odnosSnageIMase;
	Integer _brojMjestaZaSjedenje;
	Integer _brojMjestaZaStajanje;
	Integer _brojMjestaZaLezanje;
	String _ekoKarakteristike;
	Integer _katalizator;
	
	public Vozilo() {}
	public Vozilo(
					String marka,
					String tip,
					String model,
					String brojSasije,
					String oblikKaroserije,
					String godinaProizvodnje,
					Integer motor,
					Double odnosSnageIMase,
					Integer brojMjestaZaSjedenje,
					Integer brojMjestaZaStajanje,
					Integer brojMjestaZaLezanje,
					String ekoKarakteristike,
					Integer katalizator
			) {
		// TODO Auto-generated constructor stub
		this._marka = marka;
		this._brojMjestaZaSjedenje = brojMjestaZaSjedenje;
		this._brojMjestaZaStajanje = brojMjestaZaStajanje;
		this._brojMjestaZaLezanje = brojMjestaZaLezanje;
		this._brojSasije = brojSasije;
		this._ekoKarakteristike = ekoKarakteristike;
		this._godinaProizvodnje = godinaProizvodnje;
		this._katalizator = katalizator;
		this._marka = marka;
		this._model = model;
		this._motor = motor;
		this._oblikKaroserije = oblikKaroserije;
		this._odnosSnageIMase = odnosSnageIMase;
		this._tip = tip;
	}


	public String get_marka() {
		return _marka;
	}


	public void set_marka(String _marka) {
		this._marka = _marka;
	}


	public String get_tip() {
		return _tip;
	}


	public void set_tip(String _tip) {
		this._tip = _tip;
	}


	public String get_model() {
		return _model;
	}


	public void set_model(String _model) {
		this._model = _model;
	}


	public String get_brojSasije() {
		return _brojSasije;
	}


	public void set_brojSasije(String _brojSasije) {
		this._brojSasije = _brojSasije;
	}


	public String get_oblikKaroserije() {
		return _oblikKaroserije;
	}


	public void set_oblikKaroserije(String _oblikKaroserije) {
		this._oblikKaroserije = _oblikKaroserije;
	}


	public String get_godinaProizvodnje() {
		return _godinaProizvodnje;
	}


	public void set_godinaProizvodnje(String _godinaProizvodnje) {
		this._godinaProizvodnje = _godinaProizvodnje;
	}


	public Integer get_motor() {
		return _motor;
	}


	public void set_motor(Integer _motor) {
		this._motor = _motor;
	}


	public Double get_odnosSnageIMase() {
		return _odnosSnageIMase;
	}


	public void set_odnosSnageIMase(Double _odnosSnageIMase) {
		this._odnosSnageIMase = _odnosSnageIMase;
	}


	public Integer get_brojMjestaZaSjedenje() {
		return _brojMjestaZaSjedenje;
	}


	public void set_brojMjestaZaSjedenje(Integer _brojMjestaZaSjedenje) {
		this._brojMjestaZaSjedenje = _brojMjestaZaSjedenje;
	}


	public Integer get_brojMjestaZaStajanje() {
		return _brojMjestaZaStajanje;
	}


	public void set_brojMjestaZaStajanje(Integer _brojMjestaZaStajanje) {
		this._brojMjestaZaStajanje = _brojMjestaZaStajanje;
	}


	public String get_ekoKarakteristike() {
		return _ekoKarakteristike;
	}


	public void set_ekoKarakteristike(String _ekoKarakteristike) {
		this._ekoKarakteristike = _ekoKarakteristike;
	}


	public Integer get_katalizator() {
		return _katalizator;
	}


	public void set_katalizator(Integer _katalizator) {
		this._katalizator = _katalizator;
	}
	public Integer get_brojMjestaZaLezanje() {
		return _brojMjestaZaLezanje;
	}
	public void set_brojMjestaZaLezanje(Integer _brojMjestaZaLezanje) {
		this._brojMjestaZaLezanje = _brojMjestaZaLezanje;
	}
}

	