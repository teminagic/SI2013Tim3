package ba.co.edgewise.jmup.klase;

import ba.co.edgewise.jmup.enums.Boja;
import ba.co.edgewise.jmup.enums.NijansaBoje;
import ba.co.edgewise.jmup.enums.VrstaBoje;
import ba.co.edgewise.jmup.klase.Vozilo;

public class BojaVozila {
	
	private Integer id;
	private Boja boja;
	private Vozilo vozilo;
	private NijansaBoje nijansa;
	private VrstaBoje vrsta;
	private String tip;
	
	public BojaVozila() {}
	
	public BojaVozila(Integer id, Boja boja, Vozilo vozilo,
			NijansaBoje nijansa, VrstaBoje vrsta, String tip) {
		super();
		this.id = id;
		this.boja = boja;
		this.vozilo = vozilo;
		this.nijansa = nijansa;
		this.vrsta = vrsta;
		this.tip = tip;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//get & set
	public Boja getBoja() {
		return boja;
	}

	public void setBoja(Boja boja) {
		this.boja = boja;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
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
