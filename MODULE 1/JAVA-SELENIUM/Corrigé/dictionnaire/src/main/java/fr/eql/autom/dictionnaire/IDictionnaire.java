package fr.eql.autom.dictionnaire;

import java.util.Set;

import fr.eql.autom.dictionnaire.exceptions.CategorieNonSupporteeException;
import fr.eql.autom.dictionnaire.exceptions.EntreeInexistanteException;
import fr.eql.autom.dictionnaire.exceptions.MotInexistantException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteDupliqueeException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteObligatoireIndefinieException;
import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.mots.Mot;
import fr.eql.autom.modele.proprietes.Categorie;
import fr.eql.autom.modele.proprietes.Genre;
import fr.eql.autom.modele.proprietes.IPropriete;

public interface IDictionnaire {

	/*
	 * Permet de créer une entrée dans le dictionnaire (sauf des entrées nominales).
	 * Retourne true si l'entrée a été créée.
	 * Retourne false si l'entrée existe déjà et n'a pas été créée.
	 */
	boolean ajouterEntree(String identite, Categorie categorie) throws CategorieNonSupporteeException;

	/*
	 * Permet de créer une entrée dans le dictionnaire.
	 * Si la catégorie n'est pas nominale, l'information sur le genre est ignorée.
	 * Retourne true si l'entrée a été créée.
	 * Retourne false si l'entrée existe déjà et n'a pas été créée.
	 */
	boolean ajouterEntree(String identite, Categorie categorie, Genre genre);
	
	/*
	 * Permet d'ajouter une entrée dans le dictionaire
	 * Retourne true si l'entrée a été créée.
	 * Retourne false si l'entrée existe déjà et n'a pas été créée.
	 */
	boolean ajouterEntree(String identite, Set<IPropriete> proprietes) throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException;
	
	/*
	 * Permet d'ajouter un mot dans le dictionnaire et de le rattacher à une entrée 
	 * (par exemple rajouter le mot "faisons" et le rajouter au lexème "faire")
	 * Retourne true si l'entrée a été créée.
	 * Retourne false si l'entrée existe déjà et n'a pas été créée.
	 */
	boolean ajouterMot(String entree, String forme, Set<IPropriete> proprietes) throws EntreeInexistanteException, ProprieteObligatoireIndefinieException, ProprieteDupliqueeException;
	
	/*
	 * Retourne l'ensemble des mots associés à une entrée.
	 */
	Set<Mot> trouverMotsAssociesAUneEntree(String identite) throws EntreeInexistanteException; 
	
	/*
	 * Retourne l'ensemble des entrées possible pour un mot donné.
	 * Le mot "couvent" peut correspondre au verbe "couver" ou au nom "couvent"
	 */
	Set<Entree> trouverEntreesAssocieesAuMot(String forme) throws MotInexistantException;
	
	/*
	 * Retourne l'ensemble des entrées possible pour un mot donné et une catégorie donnée.
	 */
	Set<Entree> trouverEntreesAssocieesAuMotParCategorie(String forme, Categorie categorie) throws MotInexistantException;
	
	
}
