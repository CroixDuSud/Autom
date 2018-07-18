package org.eql.autom.orangehrm.junit;

public class Menu {

	private int niveau1;
	private int niveau2;
	private int niveau3;
	
	public Menu(int niveau1, int niveau2, int niveau3) {
		this.niveau1 = niveau1;
		this.niveau2 = niveau2;
		this.niveau3 = niveau3;
	}
	
	public int getNiveau1() {
		return this.niveau1;
	}
	
	public int getNiveau2() {
		return this.niveau2;
	}
	
	public int getNiveau3() {
		return this.niveau3;
	}

}
