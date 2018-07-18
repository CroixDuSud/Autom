package autom.eql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import autom.calculatrice.Calculatrice;

@RunWith(Parameterized.class) 
public class CalculatriceTest {

	int operande1;
	int operande2;
	int resultatAttendu;
	
	public CalculatriceTest(int operande1, int operande2, int resultatAttendu) {
		this.operande1 = operande1;
		this.operande2 = operande2;
		this.resultatAttendu = resultatAttendu;
	}
	
	@Test
	public void testDivision() {
		//appel au code métier
		Calculatrice c = new Calculatrice();
		int resultat = c.division(operande1, operande2);
		
		//assertion sur le résultat
		assertEquals("test division",resultatAttendu,resultat);
	}
	
	
	@Test
	public void testAddition() {
		
		//appel au code métier
		Calculatrice c = new Calculatrice();
		int resultat = c.addition(2, 2);
		
		//assertion sur le résultat
		assertNotEquals("test addition",5,resultat);
	}
	
	@Test
	public void testSoustraction() {
		
		//appel au code métier
		Calculatrice c = new Calculatrice();
		c.a = 2;
		c.b = 2;
		int resultat = c.soustraction();
		
		//assertion sur le résultat
		assertEquals("test soustraction",0,resultat);
	}
	
	@Test
	public void testMultiplication() {
		
		//appel au code métier
		//Calculatrice c = new Calculatrice();
		int resultat = Calculatrice.multiplication(2, 2);
		
		//assertion sur le résultat
		assertEquals("test multiplicaion",4,resultat);
	}
	
	@Parameters
	public static Collection valeurs() {
		
		Object tableau[][] = new Object[][] { 
			{2, 1, 2}, 
			{6, 2, 3}, 
			{8, 2, 4}  
		}; 
		
		return Arrays.asList(tableau);

	}

}
