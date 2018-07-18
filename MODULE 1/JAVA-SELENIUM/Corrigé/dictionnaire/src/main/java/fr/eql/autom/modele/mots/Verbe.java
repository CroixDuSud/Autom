package fr.eql.autom.modele.mots;

import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.proprietes.Mode;

public class Verbe extends Mot {

	private Mode mode; 
	
	public Verbe(Entree lexeme, String forme) {
		super(lexeme, forme);
	}

	public Verbe(Entree lexeme, String forme, Mode mode) {
		super(lexeme, forme);
		this.mode = mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Mode getMode() {
		return mode;
	}

}
