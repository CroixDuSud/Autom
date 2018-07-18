package autom.calculatrice;

public class Calculatrice {

	//i : variable de classe visible de partout
	int i;
	public int a; 
	public int b;
	
	public int addition(int a, int b) {
		//j : variable locale
		int j;
		return this.a+b;
	}
	
	public int soustraction() {
		return this.a-this.b;
	}
	
	public static int multiplication(int a, int b) {
		return a*b;
	}
	
	public int division(int a, int b) {
		return a/b;
	}
}
