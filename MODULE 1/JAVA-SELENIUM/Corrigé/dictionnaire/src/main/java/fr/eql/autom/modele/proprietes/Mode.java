package fr.eql.autom.modele.proprietes;


public enum Mode implements IPropriete {
	INF ("INF"),
	IND ("IND"),
	SUBJ ("SUBJ"),
	IMP ("IMP"),
	PART_PRES ("PART_PRES"),
	PART_PASS ("PART_PASS");

	private String name;
	
	Mode(String name){
		this.name = name;
	}
	
	public String getValeur() {
		return this.name;
	}

	public String getNom() {
		return "Mode";
	}
}
