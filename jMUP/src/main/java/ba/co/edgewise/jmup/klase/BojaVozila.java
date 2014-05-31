package ba.co.edgewise.jmup.klase;

import ba.co.edgewise.jmup.enums.Boja;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.klase.Vozilo;

public class BojaVozila {
	
	private Boja boja;
	private Integer idVozilo;
	private NijansaBoje nijansa;
	private VrstaBoje vrsta;
	private String tip;
	
	public BojaVozila() {}
	
	public BojaVozila(Boja boja, Integer id, NijansaBoje nijansa,
			VrstaBoje vrsta, String tip) {
		super();
		this.boja = boja;
		this.idVozilo = id;
		this.nijansa = nijansa;
		this.vrsta = vrsta;
		this.tip = tip;
	}

	//get & set
	public Boja getBoja() {
		return boja;
	}

	public void setBoja(Boja boja) {
		this.boja = boja;
	}

	public Integer getVoziloId() {
		return idVozilo;
	}

	public void setVoziloId(Integer id) {
		this.idVozilo = id;
	}

	public NijansaBoje getNijansa() {
		return nijansa;
	}

	public void setNijansa(NijansaBoje nijansa) {
		this.nijansa = nijansa;
	}

	public VrstaBoje getVrsta() {
		return vrsta;
	}

	public void setVrsta(VrstaBoje vrsta) {
		this.vrsta = vrsta;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	

}
