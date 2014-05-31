package ba.co.edgewise.jmup.klase;

import ba.co.edgewise.jmup.enums.VrstaGoriva;
import ba.co.edgewise.jmup.enums.VrstaMotora;

public class Motor {
	
	private Integer id;
	private Integer zapreminaMotora;
	private Integer maxSnaga;
	private VrstaGoriva  vrstaGoriva;
	private String  brojMotora;
	private VrstaMotora vrstaMotora;
	
	public Motor(Integer id, Integer zapreminaMotora, Integer maxSnaga,
			VrstaGoriva vrstaGoriva, String brojMotora, VrstaMotora vrstaMotora) {
		super();
		this.setId(id);
		this.zapreminaMotora = zapreminaMotora;
		this.maxSnaga = maxSnaga;
		this.vrstaGoriva = vrstaGoriva;
		this.brojMotora = brojMotora;
		this.vrstaMotora = vrstaMotora;
	}

	public Motor() {}

	
	
	// get & set
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZapreminaMotora() {
		return zapreminaMotora;
	}

	public void setZapreminaMotora(Integer zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}

	public Integer getMaxSnaga() {
		return maxSnaga;
	}

	public void setMaxSnaga(Integer maxSnaga) {
		this.maxSnaga = maxSnaga;
	}

	public String getBrojMotora() {
		return brojMotora;
	}

	public void setBrojMotora(String brojMotora) {
		this.brojMotora = brojMotora;
	}

	public VrstaGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(VrstaGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public VrstaMotora getVrstaMotora() {
		return vrstaMotora;
	}

	public void setVrstaMotora(VrstaMotora vrstaMotora) {
		this.vrstaMotora = vrstaMotora;
	}
	
}
