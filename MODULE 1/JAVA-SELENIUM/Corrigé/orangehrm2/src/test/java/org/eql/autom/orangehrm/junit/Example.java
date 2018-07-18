package org.eql.autom.orangehrm.junit;

import java.util.ArrayList;
import java.util.List;

public class Example {

	//retourne une liste qui combine trois valeurs
	public List<Integer> maMethode() {
		
		int premierNiveauDuMenu = 0;
		int deuxiemeNiveauDuMenu = 1;
		int troisiemeNiveauDuMenu = 2;
		
		//...
		
		List<Integer> menu = new ArrayList<Integer>();
		menu.add(premierNiveauDuMenu);
		menu.add(deuxiemeNiveauDuMenu);
		menu.add(troisiemeNiveauDuMenu);
		
		return menu;
	}
	
	//retourne un objet qui combine trois valeurs
	public Menu maMethode2() {
		
		int premierNiveauDuMenu = 0;
		int deuxiemeNiveauDuMenu = 1;
		int troisiemeNiveauDuMenu = 2;
		
		Menu menu = new Menu(premierNiveauDuMenu, deuxiemeNiveauDuMenu, troisiemeNiveauDuMenu);
	
		return menu;
	}
	
	public void methodeDappel() {
		
		Menu m = this.maMethode2();
		int i = m.getNiveau1();
		int j = m.getNiveau2();
		int k = m.getNiveau3();
		
	}
}
