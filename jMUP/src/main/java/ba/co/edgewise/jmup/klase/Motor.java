package ba.co.edgewise.jmup.klase;

public class Motor {
	
	private Integer _zapreminaMotora;
	private Integer _maxSnaga;
	private String  _vrstaGoriva;
	private String  _brojMotora;
	private String  _vrstaMotora;
	
	public Motor(Integer zm, Integer ms, String vg, String bm, String vm) {
		   
		this._zapreminaMotora = zm;
		this._maxSnaga = ms;
		this._vrstaGoriva = vg;
		this._brojMotora = bm;
		this._vrstaMotora = vm;

	}
	
	public Motor() {}
	
	// get & set
	public Integer get_zapreminaMotora() {
		return _zapreminaMotora;
	}

	public void set_zapreminaMotora(Integer _zapreminaMotora) {
		this._zapreminaMotora = _zapreminaMotora;
	}

	public Integer get_maxSnaga() {
		return _maxSnaga;
	}

	public void set_maxSnaga(Integer _maxSnaga) {
		this._maxSnaga = _maxSnaga;
	}

	public String get_vrstaGoriva() {
		return _vrstaGoriva;
	}

	public void set_vrstaGoriva(String _vrstaGoriva) {
		this._vrstaGoriva = _vrstaGoriva;
	}

	public String get_brojMotora() {
		return _brojMotora;
	}

	public void set_brojMotora(String _brojMotora) {
		this._brojMotora = _brojMotora;
	}

	public String get_vrstaMotora() {
		return _vrstaMotora;
	}

	public void set_vrstaMotora(String _vrstaMotora) {
		this._vrstaMotora = _vrstaMotora;
	}
	
	
}
