package ba.co.edgewise.jmup.enums;

public enum VrstaMotora {
		OTTO("OTTO"), 
		DIESEL("DIESEL"), 
		WANKEL("WANKEL"), 
		ELEKTROMOTOR("Elektromotor"), 
		KOMBINOVANI_POGON("Kombinovani pogon");
		
		private String _naziv;		
		private VrstaMotora(final String naziv)
		{
			this._naziv = naziv;
		}
		
		@Override
		public String toString() {
			return this._naziv;			
		}
			
		public static VrstaMotora getMotor(String motor)
		{	
			switch (motor) {
				case "OTTO":
					return VrstaMotora.OTTO;
				case "DIESEL":
					return VrstaMotora.DIESEL;
				case "WANKEL":
					return VrstaMotora.WANKEL;
				case "Elektromotor":
					return VrstaMotora.ELEKTROMOTOR;
				case "Kombinovani pogon":
					return VrstaMotora.KOMBINOVANI_POGON;
				default:
					return null;
				}
			}


		}
