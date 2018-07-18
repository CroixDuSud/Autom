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
	 * Permet de cr�er une entr�e dans le dictionnaire (sauf des entr�es nominales).
	 * Retourne true si l'entr�e a �t� cr��e.
	 * Retourne false si l'entr�e existe d�j� et n'a pas �t� cr��e.
	 */
	boolean ajouterEntree(String identite, Categorie categorie) throws CategorieNonSupporteeException;

	/*
	 * Permet de cr�er une entr�e dans le dictionnaire.
	 * Si la cat�gorie n'est pas nominale, l'information sur le genre est ignor�e.
	 * Retourne true si l'entr�e a �t� cr��e.
	 * Retourne false si l'entr�e existe d�j� et n'a pas �t� cr��e.
	 */
	boolean ajouterEntree(String identite, Categorie categorie, Genre genre);
	
	/*
	 * Permet d'ajouter une entr�e dans le dictionaire
	 * Retourne true si l'entr�e a �t� cr��e.
	 * Retourne false si l'entr�e existe d�j� et n'a pas �t� cr��e.
	 */
	boolean ajouterEntree(String identite, Set<IPropriete> proprietes) throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException;
	
	/*
	 * Permet d'ajouter un mot dans le dictionnaire et de le rattacher � une entr�e 
	 * (par exemple rajouter le mot "faisons" et le rajouter au lex�me "faire")
	 * Retourne true si l'entr�e a �t� cr��e.
	 * Retourne false si l'entr�e existe d�j� et n'a pas �t� cr��e.
	 */
	boolean ajouterMot(String entree, String forme, Set<IPropriete> proprietes) throws EntreeInexistanteException, ProprieteObligatoireIndefinieException, ProprieteDupliqueeException;
	
	/*
	 * Retourne l'ensemble des mots associ�s � une entr�e.
	 */
	Set<Mot> trouverMotsAssociesAUneEntree(String identite) throws EntreeInexistanteException; 
	
	/*
	 * Retourne l'ensemble des entr�es possible pour un mot donn�.
	 * Le mot "couvent" peut correspondre au verbe "couver" ou au nom "couvent"
	 */
	Set<Entree> trouverEntreesAssocieesAuMot(String forme) throws MotInexistantException;
	
	/*
	 * Retourne l'ensemble des entr�es possible pour un mot donn� et une cat�gorie donn�e.
	 */
	Set<Entree> trouverEntreesAssocieesAuMotParCategorie(String forme, Categorie categorie) throws MotInexistantException;
	
	
}
