package autom.eql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import autom.calculatrice.Operation;

public class Exo {

	@Test
	public void tableau() {
		
		//cr�er un tableau de 10 cases
		int tableau[] = new int[10];
		
		//remplir le tableau avec des nombres de 1 � 10
		for(int i=0; i<10; i++) {
			tableau[i] = i+1; //� la case 0 je mets 1 ; � la case 1 je mets 2 ; etc
		}
		
		//additionner les nombres contenus dans le tableau
		int resultat = 0;
		
		for(int i=0; i<10; i++) {
			resultat = resultat+tableau[i]; 
		}
		
		//v�rifier que la somme est �gale � 55
		assertEquals("somme", 55, resultat);
	}
	
	@Test
	public void monEnum() {
		
		Operation op = Operation.addition;
		assertEquals("test","+",op.getOperateur());
	}
	
	@Test
	public void monEnumText() {
		
		Operation op = Operation.addition;
		assertEquals("V�rification de la m�thode avec la valeur: "+op.getOperateur(),"pluS",op.getNomOperateurV4());
	}
}
