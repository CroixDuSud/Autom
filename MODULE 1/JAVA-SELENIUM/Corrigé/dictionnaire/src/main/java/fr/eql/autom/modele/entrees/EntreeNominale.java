package fr.eql.autom.modele.entrees;

import fr.eql.autom.modele.proprietes.Categorie;
import fr.eql.autom.modele.proprietes.Genre;

public class EntreeNominale extends Entree {

	private Genre genre;

	public Genre getGenre() {
		return genre;
	}
	
	public EntreeNominale(String identite, Genre genre){
		super(identite, Categorie.NOM);
		this.genre = genre;
	}
}
