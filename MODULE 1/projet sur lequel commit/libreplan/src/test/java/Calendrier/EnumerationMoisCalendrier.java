package Calendrier;

	
	public enum EnumerationMoisCalendrier {
		janv ("janv."),
		fevr ("fevr"),
		mars ("mars"),
		avril ("avr."),
		mai ("mai"),
		juin ("juin"),
		juil ("juil."),
		aout("aout"),
		sept("sept."),
		oct("oct."),
		nov("nov."),
		dec("dec.")
		;
		

		String mois;
		
		public String getMois(String mois) {
			return mois;
		}

		EnumerationMoisCalendrier(String mois){
			this.mois = mois;
		}
		


}
