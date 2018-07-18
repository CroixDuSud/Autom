package fr.eql.autom.modele.proprietes;


public enum Nombre implements IPropriete {
	SG ("SG"),
	PL ("PL"),
	TOUS ("TOUS");
	
	private String name;
	
	Nombre(String name){
		this.name = name;
	}
	
	public String getValeur() {
		return this.name;
	}

	public String getNom() {
		return "Nombre";
	}
}
