package fr.eql.autom.modele.mots;

import fr.eql.autom.modele.entrees.Entree;

public abstract class Mot {

	private Entree lexeme; 
	
	private String forme;
	
	public Mot(Entree lexeme, String forme){
		this.lexeme = lexeme;
		this.forme = forme;
	}

	public Entree getLexeme() {
		return lexeme;
	}

	public String getForme() {
		return forme;
	}	
	
	public abstract String getAbbréviation();
}
