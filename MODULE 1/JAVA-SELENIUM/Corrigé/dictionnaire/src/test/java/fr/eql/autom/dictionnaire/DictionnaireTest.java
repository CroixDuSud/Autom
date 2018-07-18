package fr.eql.autom.dictionnaire;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import fr.eql.autom.dictionnaire.exceptions.CategorieNonSupporteeException;
import fr.eql.autom.dictionnaire.exceptions.EntreeInexistanteException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteDupliqueeException;
import fr.eql.autom.dictionnaire.exceptions.ProprieteObligatoireIndefinieException;
import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.entrees.EntreeNominale;
import fr.eql.autom.modele.mots.Mot;
import fr.eql.autom.modele.proprietes.Categorie;
import fr.eql.autom.modele.proprietes.Genre;
import fr.eql.autom.modele.proprietes.IPropriete;
import fr.eql.autom.modele.proprietes.Mode;
import fr.eql.autom.modele.proprietes.Nombre;
import fr.eql.autom.modele.proprietes.Personne;

public class DictionnaireTest {

	@Test
	public void question1() throws CategorieNonSupporteeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = dico.ajouterEntree("lire", Categorie.VERBE);
		
		assertTrue("entr�e cr��e",resultat);
		assertEquals("entr�e cr��e",true,resultat);
		
		//BONUS
		assertEquals("entr�e effectivement cr�e dans la map", 1, dico.entrees.size());
		Entree entree = dico.entrees.get("lire");
		String identite = entree.getIdentite();
		String texteDeLaCategorie = entree.getCategorie().getValeur();
		assertEquals("entr�e cr��e avec la bonne identit�","lire",identite);
		assertEquals("entr�e cr��e avec la bonne cat�gorie","VERBE",texteDeLaCategorie);
	}
	
	@Test(expected = CategorieNonSupporteeException.class)
	public void question2() throws CategorieNonSupporteeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		dico.ajouterEntree("voiture", Categorie.NOM);
	}
	
	@Test
	public void question3() throws CategorieNonSupporteeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = dico.ajouterEntree("lire", Categorie.VERBE);
		assertEquals("entr�e cr��e la premi�re fois",true,resultat);
		
		boolean resultat2 = dico.ajouterEntree("lire", Categorie.VERBE);
		assertEquals("entr�e non cr��e la seconde fois",false,resultat2);
		
		//BONUS
		assertEquals("entr�e effectivement cr�e dans la map", 1, dico.entrees.size());
	}
	
	@Test
	public void question4() {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = dico.ajouterEntree("lire", Categorie.VERBE, Genre.M);
		assertEquals("entr�e cr��e", true, resultat);
		
		//BONUS
		assertEquals("entr�e effectivement cr�e dans la map", 1, dico.entrees.size());
		Entree entree = dico.entrees.get("lire");
		String identite = entree.getIdentite();
		String texteDeLaCategorie = entree.getCategorie().getValeur();
		assertEquals("entr�e cr��e avec la bonne identit�","lire",identite);
		assertEquals("entr�e cr��e avec la bonne cat�gorie","VERBE",texteDeLaCategorie);
	}
	
	@Test
	public void question5() {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = dico.ajouterEntree("voiture", Categorie.NOM, Genre.F);
		assertEquals("entr�e cr��e", true, resultat);
		
		//BONUS
		assertEquals("entr�e effectivement cr�e dans la map", 1, dico.entrees.size());
		Entree entree = dico.entrees.get("voiture");
		//caster
		if(entree instanceof EntreeNominale) {
			EntreeNominale entreeNominale = (EntreeNominale) entree;
			String identite = entreeNominale.getIdentite();
			String texteDeLaCategorie = entreeNominale.getCategorie().getValeur();
			String genre = entreeNominale.getGenre().getValeur();
			assertEquals("entr�e cr��e avec la bonne identit�","voiture",identite);
			assertEquals("entr�e cr��e avec la bonne cat�gorie","NOM",texteDeLaCategorie);
			assertEquals("entr�e cr��e avec la bon genre","F",genre);
		} else {
			fail();
		}
	}
	
	@Test
	public void question6() {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = dico.ajouterEntree("voiture", Categorie.NOM, Genre.F);
		assertEquals("entr�e cr��e", true, resultat);
		
		boolean resultat2 = dico.ajouterEntree("voiture", Categorie.NOM, Genre.F);
		assertEquals("entr�e non cr��e", false, resultat2);
	}
	
	@Test
	public void question7() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		boolean resultat = dico.ajouterEntree("voiture", prop);
		assertEquals("entr�e cr��e", true, resultat);
		
		//BONUS
		Entree entree = dico.entrees.get("voiture");
		//caster
		if(entree instanceof EntreeNominale) {
			EntreeNominale entreeNominale = (EntreeNominale) entree;
			String identite = entreeNominale.getIdentite();
			String texteDeLaCategorie = entreeNominale.getCategorie().getValeur();
			String genre = entreeNominale.getGenre().getValeur();
			assertEquals("entr�e cr��e avec la bonne identit�","voiture",identite);
			assertEquals("entr�e cr��e avec la bonne cat�gorie","NOM",texteDeLaCategorie);
			assertEquals("entr�e cr��e avec la bon genre","F",genre);
		} else {
			fail();
		}
	}
	
	@Test
	public void question8() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		boolean resultat = dico.ajouterEntree("voiture", prop);
		assertEquals("entr�e cr��e", true, resultat);
		
		boolean resultat2 = dico.ajouterEntree("voiture", prop);
		assertEquals("entr�e cr��e", false, resultat2);
	}
	
	@Test(expected=ProprieteObligatoireIndefinieException.class)
	public void question9() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Genre.F);
		dico.ajouterEntree("voiture", prop);
	}
	
	
	@Ignore
	@Test(expected=ProprieteDupliqueeException.class)
	public void question10a() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		System.out.println(prop.size()); //ce test ne sert � rien � cause du set
		dico.ajouterEntree("voiture", prop);
	}
	
	@Test(expected=ProprieteDupliqueeException.class)
	public void question10b() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Categorie.ADJ);
		prop.add(Genre.F);
		dico.ajouterEntree("voiture", prop);
	}
	
	@Test
	public void question11() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		prop.add(Personne.PL1);
		boolean resultat = dico.ajouterEntree("voiture", prop);
		assertEquals("entr�e cr��e", true, resultat);
		
		//BONUS
		Entree entree = dico.entrees.get("voiture");
		//caster
		if(entree instanceof EntreeNominale) {
			EntreeNominale entreeNominale = (EntreeNominale) entree;
			String identite = entreeNominale.getIdentite();
			String texteDeLaCategorie = entreeNominale.getCategorie().getValeur();
			String genre = entreeNominale.getGenre().getValeur();
			assertEquals("entr�e cr��e avec la bonne identit�","voiture",identite);
			assertEquals("entr�e cr��e avec la bonne cat�gorie","NOM",texteDeLaCategorie);
			assertEquals("entr�e cr��e avec la bon genre","F",genre);
		} else {
			fail();
		}
	}
	
	private boolean creationDeLEntreeVoiture(Dictionnaire dico) throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		boolean resultat = dico.ajouterEntree("voiture", prop);
		return resultat;
	}
	
	@Test
	public void question12() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException, EntreeInexistanteException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		prop.add(Nombre.PL);
		
		boolean resultat2 = dico.ajouterMot("voiture", "voitures", prop);
		assertEquals("mot cr��", true, resultat2);
		
		List<Mot> mots = dico.mots.get("voitures");
		assertEquals("il existe un mot", 1, mots.size());
		
		Mot mot = mots.get(0);
		String identite = mot.getLexeme().getIdentite();
		String texte = mot.getForme();
		String categorie = mot.getLexeme().getCategorie().getValeur();
		assertEquals("identite", "voiture", identite);
		assertEquals("forme", "voitures", texte);
		assertEquals("categorie", "NOM", categorie);
	}
	
	@Test (expected = EntreeInexistanteException.class)
	public void question13() throws EntreeInexistanteException, ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		
		dico.ajouterMot("voiture", "voitures", prop);
	}
	
	@Test(expected=ProprieteObligatoireIndefinieException.class)
	public void question14() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException, EntreeInexistanteException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		//prop.add(Nombre.PL); nombre manquant
		
		dico.ajouterMot("voiture", "voitures", prop);
	}
	
	@Test(expected=ProprieteDupliqueeException.class)
	public void question15() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException, EntreeInexistanteException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		prop.add(Nombre.PL); 
		prop.add(Nombre.SG); //duplication PL / SG
		
		dico.ajouterMot("voiture", "voitures", prop);
	}
	
	@Test()
	public void question16() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException, EntreeInexistanteException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		prop.add(Nombre.PL); 
		prop.add(Mode.IMP); //non n�cessaire
		
		boolean resultat2 = dico.ajouterMot("voiture", "voitures", prop);
		assertEquals("entr�e cr��e", true, resultat2);
	}
	
	
	//La m�thode trouverMotsAssociesAUneEntree(String identite) : Set<Mot> doit renvoyer tous les mots associ�s � une entr�e.
	@Test()
	public void question17() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException, EntreeInexistanteException {
		

		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		//MOT Voitures PL associ� � VOITURE
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.NOM);
		prop.add(Genre.F);
		prop.add(Nombre.PL); 
		boolean resultat2 = dico.ajouterMot("voiture", "voitures", prop);
		assertEquals("entr�e cr��e", true, resultat2);

		//MOT Voiture SG associ� � VOITURE
		Set<IPropriete> prop2 = new HashSet<IPropriete>();
		prop2.add(Categorie.NOM);
		prop2.add(Genre.F);
		prop2.add(Nombre.SG); 
		boolean resultat3 = dico.ajouterMot("voiture", "voiture", prop);
		assertEquals("entr�e cr��e", true, resultat3);
		
		Set<Mot> motsAssoci�s = dico.trouverMotsAssociesAUneEntree("voiture");
		assertEquals("nombre de mots", 2, motsAssoci�s.size());
		
		//solution 1
		for(Mot mot : motsAssoci�s) {
			String forme = mot.getForme();
			if(!forme.equals("voiture") && !forme.equals("voitures")) {
				fail();
			}
		}
		
		//solution 2 comparer des ensembles de String
		//Construire l'ensemble de r�f�rence
		Set<String> attendu = new HashSet<String>();
		attendu.add("voiture");
		attendu.add("voitures");
		
		Set<String> obtenu = new HashSet<String>();
		for(Mot mot : motsAssoci�s) {
			obtenu.add(mot.getForme());
		}
		
		boolean res = obtenu.containsAll(attendu);
		assertEquals("ensembles identiques", true, res);
	}
	
	//La m�thode trouverMotsAssociesAUneEntree(String identite) : Set<Mot> doit renvoyer un ensemble vide si l�entr�e � 0 mots associ�s.
	@Test()
	public void question18() throws ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		boolean resultat = this.creationDeLEntreeVoiture(dico);
		assertEquals("entr�e cr��e", true, resultat);
		
		Set<Mot> motsAssoci�s = dico.trouverMotsAssociesAUneEntree("voiture");
		boolean res = motsAssoci�s.isEmpty();
		assertEquals("entr�e cr��e", true, res);
	}
	
	//La m�thode trouverEntreesAssocieesAuMot(String forme) : Set<Entree> doit renvoyer l�ensemble des entr�es associ�es � un mot.
	@Test()
	public void question20() throws CategorieNonSupporteeException, EntreeInexistanteException, ProprieteObligatoireIndefinieException, ProprieteDupliqueeException {
		
		Dictionnaire dico = new Dictionnaire();
		
		dico.ajouterEntree("couver", Categorie.VERBE);
		dico.ajouterEntree("couvent", Categorie.NOM, Genre.M);
		
		Set<IPropriete> prop = new HashSet<IPropriete>();
		prop.add(Categorie.VERBE);
		prop.add(Mode.IND);
		prop.add(Personne.PL3); 
		dico.ajouterMot("couver", "couvent", prop);
		
		Set<IPropriete> prop2 = new HashSet<IPropriete>();
		prop2.add(Categorie.NOM);
		prop2.add(Genre.M);
		prop2.add(Nombre.SG); 
		dico.ajouterMot("couvent", "couvent", prop2);
		
		Set<Entree> entrees = dico.trouverEntreesAssocieesAuMot("couvent");
		assertEquals("nombre entrees", 2, entrees.size());
		
		//solution 2 comparer des ensembles de String
		//Construire l'ensemble de r�f�rence
		Set<String> attendu = new HashSet<String>();
		attendu.add("couver");
		attendu.add("couvent");
				
		Set<String> obtenu = new HashSet<String>();
		for(Entree e : entrees) {
			obtenu.add(e.getIdentite());
		}
				
		boolean res = obtenu.containsAll(attendu);
		assertEquals("ensembles identiques", true, res);
	}
	
	//La m�thode trouverEntreesAssocieesAuMot(String forme) : Set<Entree> doit renvoyer une erreur si le mot n�existe pas.
	@Test
	public void question21() {
		
		Dictionnaire dico = new Dictionnaire();
		
		dico.trouverEntreesAssocieesAuMot("couvent");
	}
}
