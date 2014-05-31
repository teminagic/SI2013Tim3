package ba.co.edgewise.jmup.enums;

public enum Status {
	AKTIVAN("Aktivan"),
	NEAKTIVAN("Neaktivan");
	
	private final String status;
	
	private Status(final String status)
	{
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.status;
	}
	
	public static Status getStatus(String tip)
	{
		switch (tip) {
		case "Aktivan":
			return Status.AKTIVAN;
		case "Neaktivan":
			return Status.NEAKTIVAN;
		default:
			return null;
		}
	}
}
