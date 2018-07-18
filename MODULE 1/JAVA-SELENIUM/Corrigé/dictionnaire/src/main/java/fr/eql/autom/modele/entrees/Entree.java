package fr.eql.autom.modele.entrees;

import fr.eql.autom.modele.proprietes.Categorie;

public class Entree {

	private String identite;
	
	private Categorie categorie;

	public String getIdentite() {
		return identite;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public Entree(String identite, Categorie categorie){
		this.identite = identite;
		this.categorie = categorie;
	}

}
