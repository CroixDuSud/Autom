package fr.eql.autom;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DeuxiemeTest {

	// Commentaire sur une ligne
	@Test
	public void monTest() {
		
		int resultat = 5 + 4;
		assertEquals("test addition", 9, resultat);
	}
	
	/*
	 * Commentaire 
	 * sur 2 lignes
	 */
	@Test
	public void monTestEnEchec() {
		
		int resultat = 5 + 4;
		assertEquals("test addition", 10, resultat);
	}
	
	
	@Test
	public void testDeTrim() {
		
		String monTexte = " bonjour          ";
		monTexte = monTexte.trim();
		assertEquals("comparaison après trim","bonjour",monTexte);
	}
	
	@Test
	public void testLongueur() {
		
		String monTexte = "bonjour";
		int longueur = monTexte.length();
		assertEquals("comparaison longueur",7,longueur);
	}
	
	@Test
	public void testLongueurSuperieureADeux() {
		
		String monTexte = "bonjour";
		int longueur = monTexte.length();
		boolean estSuperieurADeux = longueur > 2;
		assertEquals("comparaison longueur",true,estSuperieurADeux);
	}
}
