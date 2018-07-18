package fr.eql.autom.modele.mots;

import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.proprietes.Genre;
import fr.eql.autom.modele.proprietes.Nombre;

public class Adjectif extends Mot {

	private Nombre accordNombre;
	
	private Genre accordGenre;
	
	public Adjectif(Entree lexeme, String forme) {
		super(lexeme, forme);
	}

	public Adjectif(Entree lexeme, String forme, Genre accordGenre, Nombre accordNombre) {
		super(lexeme, forme);
	}
	
	public void setAccordGenre(Genre accordGenre) {
		this.accordGenre = accordGenre;
	}

	public Genre getAccordGenre() {
		return accordGenre;
	}

	public void setAccordNombre(Nombre accordNombre) {
		this.accordNombre = accordNombre;
	}

	public Nombre getAccordNombre() {
		return accordNombre;
	}

	@Override
	public Entree getLexeme() {
		if(this.getLexeme() != null) {
			return this.getLexeme();
		} else {
			return new Entree("", null);
		}
	}
	
	@Override
	public String getAbbréviation() {
		return "adj";
	}

	
}
