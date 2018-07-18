package fr.eql.autom.modele.proprietes;


public enum Genre implements IPropriete {
	F ("F"),
	M ("M"),
	TOUS ("TOUS");

	private String name;
	
	Genre(String name){
		this.name = name;
	}
	
	public String getValeur() {
		return this.name;
	}

	public String getNom() {
		return "Genre";
	}
}
