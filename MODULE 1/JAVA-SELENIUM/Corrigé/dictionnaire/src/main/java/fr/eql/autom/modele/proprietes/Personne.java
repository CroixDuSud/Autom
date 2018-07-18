package fr.eql.autom.modele.proprietes;


public enum Personne implements IPropriete {
	SG1 ("1SG"),
	SG2 ("2SG"),
	SG3 ("3SG"),
	PL1 ("1PL"),
	PL2 ("2PL"),
	PL3 ("3PL");

	private String name;
	
	Personne(String name){
		this.name = name;
	}
	
	public String getValeur() {
		return this.name;
	}

	public String getNom() {
		return "Personne";
	}
}
