package fr.eql.autom.modele.proprietes;


public enum Categorie implements IPropriete {
	NOM ("NOM"),
	ADJ ("ADJ"),
	ADV ("ADV"),
	VERBE ("VERBE");

	private String name;
	
	Categorie(String name){
		this.name = name;
	}
	
	public String getValeur() {
		return this.name;
	}

	public String getNom() {
		return "Categorie";
	}
}
