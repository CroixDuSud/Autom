package fr.eql.autom.dictionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.eql.autom.dictionnaire.exceptions.CategorieNonSupporteeException;
import fr.eql.autom.dictionnaire.exceptions.EntreeInexistanteException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteDupliqueeException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteObligatoireIndefinieException;
import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.entrees.EntreeNominale;
import fr.eql.autom.modele.mots.Adjectif;
import fr.eql.autom.modele.mots.Adverbe;
import fr.eql.autom.modele.mots.Mot;
import fr.eql.autom.modele.mots.Nom;
import fr.eql.autom.modele.mots.Verbe;
import fr.eql.autom.modele.mots.VerbeFini;
import fr.eql.autom.modele.proprietes.Categorie;
import fr.eql.autom.modele.proprietes.Genre;
import fr.eql.autom.modele.proprietes.IPropriete;
import fr.eql.autom.modele.proprietes.Mode;
import fr.eql.autom.modele.proprietes.Nombre;
import fr.eql.autom.modele.proprietes.Personne;

public class Dictionnaire implements IDictionnaire {

	Map<String, Entree> entrees = new HashMap<String, Entree>();
	
	Map<String, List<Mot>> mots = new HashMap<String, List<Mot>>();
	
	Map<String, List<Mot>> motsParEntree = new HashMap<String, List<Mot>>();
	
	Map<String, List<Entree>> entreesParMot = new HashMap<String, List<Entree>>();

	public boolean ajouterEntree(String identite, Categorie categorie) throws CategorieNonSupporteeException {
		if(Categorie.NOM.equals(categorie)){
			throw new CategorieNonSupporteeException();
		}
		if(entrees.containsKey(identite)){
			return false;
		} else {
			Entree nouvelle = new Entree(identite,categorie);
			entrees.put(identite, nouvelle);
			motsParEntree.put(identite, new ArrayList<Mot>());
			return true;
		}
	}

	public boolean ajouterEntree(String identite, Categorie categorie, Genre genre) {
		if(entrees.containsKey(identite)){
			return false;
		} else if (Categorie.NOM.equals(categorie)){
			Entree nouvelle = new EntreeNominale(identite,genre);
			entrees.put(identite, nouvelle);
			motsParEntree.put(identite, new ArrayList<Mot>());
		} else {
			Entree nouvelle = new Entree(identite,categorie);
			entrees.put(identite, nouvelle);
			motsParEntree.put(identite, new ArrayList<Mot>());
		}
		return true;
	}
	
	public boolean ajouterEntree(String identite, Set<IPropriete> proprietes) throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		Categorie categorie = this.getCategorie(proprietes);
		Genre genre = null;
		if("NOM".equals(categorie.getValeur())){
			genre = this.getGenre(proprietes);
		} 
		return this.ajouterEntree(identite, categorie, genre);
	}
	
	public boolean ajouterMot(String entree, String forme, Set<IPropriete> proprietes) throws EntreeInexistanteException, ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		//Verification de l'entrée
		Entree e = this.entrees.get(entree);
		if(e == null){
			throw new EntreeInexistanteException("L'entrée "+entree+" n'existe pas.");
		}
		
		//Verification de l'existance de la forme
		List<Mot> motsAccesDirect = new ArrayList<Mot>();
		if(mots.keySet().contains(forme)){
			motsAccesDirect = mots.get(forme);
		} else {
			mots.put(forme, motsAccesDirect);
		}
		
		List<Mot> mots = motsParEntree.get(entree);
		Mot mot = null;
		switch(e.getCategorie()){
			case NOM : mot = new Nom((EntreeNominale) e, forme, getNombre(proprietes)); break;
			case ADJ : mot = new Adjectif(e, forme, getGenre(proprietes), getNombre(proprietes)); break;
			case ADV : mot = new Adverbe(e, forme); break;
			case VERBE : mot = creerVerbe(e, forme, proprietes); break;
		}
		if(mot != null){
			motsAccesDirect.add(mot);
			return mots.add(mot);
		} else {
			return false;
		}
	}

	
	private Mot creerVerbe(Entree e, String forme, Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		
		Mot resultat = null;
		switch(getMode(proprietes)){
			case IND : resultat = new VerbeFini(e, forme, getMode(proprietes), getPersonne(proprietes));
			case SUBJ : resultat = new VerbeFini(e, forme, getMode(proprietes), getPersonne(proprietes));
			case IMP : resultat = new VerbeFini(e, forme, getMode(proprietes), getPersonne(proprietes));
			case INF : resultat = new Verbe(e, forme, getMode(proprietes));
			case PART_PASS : resultat = new Verbe(e, forme, getMode(proprietes));
			case PART_PRES : resultat = new Verbe(e, forme, getMode(proprietes));
		}
		return resultat;
	}

	private Nombre getNombre(Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		return (Nombre) getPropriete(proprietes, "Nombre");
	}

	private Mode getMode(Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		return (Mode) getPropriete(proprietes, "Mode");
	}

	private Personne getPersonne(Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		return (Personne) getPropriete(proprietes, "Personne");
	}

	private Genre getGenre(Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		return (Genre) getPropriete(proprietes, "Genre");
	}
	
	private Categorie getCategorie(Set<IPropriete> proprietes) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		return (Categorie) getPropriete(proprietes, "Categorie");
	}
	
	private IPropriete getPropriete(Set<IPropriete> proprietes, String nomPropriete) throws ProprieteDupliqueeException, ProprieteObligatoireIndefinieException {
		IPropriete resultat = null;
		boolean found = false;
		for(IPropriete propriete : proprietes){
			if(nomPropriete.equals(propriete.getNom()) && found==false){
				resultat = propriete;
				found = true;
			} else if (nomPropriete.equals(propriete.getNom()) && found==true) {
				throw new ProprieteDupliqueeException();
			}
		}
		if(resultat == null){
			throw new ProprieteObligatoireIndefinieException();
		} else {
			return resultat;	
		}
	}
	
	public Set<Mot> trouverMotsAssociesAUneEntree(String entree) {
		Set<Mot> mots = new HashSet<Mot>();
		mots.addAll(motsParEntree.get(entree));
		return mots;
	}

	public Set<Entree> trouverEntreesAssocieesAuMot(String forme) {
		List<Mot> liste = this.mots.get(forme);
		Set<Entree> entrees = new HashSet<Entree>();
		for(Mot mot : liste){
			entrees.add(mot.getLexeme());
		}
		return entrees;
	}

	public Set<Entree> trouverEntreesAssocieesAuMotParCategorie(String forme, Categorie categorie) {
		List<Mot> liste = this.mots.get(forme);
		Set<Entree> entrees = new HashSet<Entree>();
		for(Mot mot : liste){
			Entree entree = mot.getLexeme();
			if(entree.getCategorie().equals(categorie)){
				entrees.add(entree);
			}
		}
		return entrees;
	}

	
	
}
