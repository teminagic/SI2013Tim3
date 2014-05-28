package ba.co.edgewise.jmup.klase;

public class Motor {
	
	private Integer id;
	private Integer zapreminaMotora;
	private Integer maxSnaga;
	private String  vrstaGoriva;
	private String  brojMotora;
	private String  vrstaMotora;
	
	public Motor(Integer id, Integer zapreminaMotora, Integer maxSnaga,
			String vrstaGoriva, String brojMotora, String vrstaMotora) {
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

	public String getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(String vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public String getBrojMotora() {
		return brojMotora;
	}

	public void setBrojMotora(String brojMotora) {
		this.brojMotora = brojMotora;
	}

	public String getVrstaMotora() {
		return vrstaMotora;
	}

	public void setVrstaMotora(String vrstaMotora) {
		this.vrstaMotora = vrstaMotora;
	}
	
}
