package autom.calculatrice;

public enum Operation {

	addition("+"),
	soustraction("-"),
	multiplication("*"),
	division("/");
	
	private String operateur;
	
	Operation(String operateur){
		this.operateur = operateur;
	}
	
	public String getOperateur() {
		return this.operateur;
	}
	
	public String getNomOperateur() {
		
		switch(this.operateur) {
		
			case "+" : return "plus";
			case "-" : return "moins";
			case "*" : return "étoile";
			case "/" : return "barre oblique";
			default : break;
		
		}
		
		return "operateur inconnu";
	}
	
	public String getNomOperateurV4() {
		
		switch(this) {
		
			case addition : return "plus";
			case soustraction : return "moins";
			case multiplication : return "étoile";
			case division : return "barre oblique";
			default : break;
		
		}
		
		return "operateur inconnu";
	}
	
	public String getNomOperateurV3() {
		
		String resultat;
		switch(this.operateur) {
		
			case "+" : resultat="plus";break;
			case "-" : resultat="moins";break;
			case "*" : resultat="étoile";break;
			case "/" : resultat="barre oblique";break;
			default : resultat="operateur inconnu";
		
		}
		
		return resultat;
	}
	
	public String getNomOperateurV2() {
		
		if(this.operateur.equals("+")) {
			return "plus";
		} else if (this.operateur.equals("-")){
			return "moins";
		} else if (this.operateur.equals("*")){
			return "étoile";
		} else if (this.operateur.equals("/")){
			return "barre oblique";
		} else {
			return "operateur inconnu";
		}
	}
}
