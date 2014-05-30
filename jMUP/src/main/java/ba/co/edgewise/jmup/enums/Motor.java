package ba.co.edgewise.jmup.enums;

public enum Motor {
		OTTO("OTTO"), 
		DIESEL("DIESEL"), 
		WANKEL("WANKEL"), 
		ELEKTROMOTOR("Elektromotor"), 
		KOMBINOVANI_POGON("Kombinovani pogon");
		
		private String _naziv;		
		private Motor(final String naziv)
		{
			this._naziv = naziv;
		}
		
		@Override
		public String toString() {
			return this._naziv;			
		}
			
		public static Motor getMotor(String motor)
		{	
			switch (motor) {
				case "OTTO":
					return Motor.OTTO;
				case "DIESEL":
					return Motor.DIESEL;
				case "WANKEL":
					return Motor.WANKEL;
				case "Elektromotor":
					return Motor.ELEKTROMOTOR;
				case "Kombinovani pogon":
					return Motor.KOMBINOVANI_POGON;
				default:
					return null;
				}
			}


		}
