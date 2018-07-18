package fr.eql.autom.modele.mots;

import fr.eql.autom.modele.entrees.Entree;
import fr.eql.autom.modele.proprietes.Mode;
import fr.eql.autom.modele.proprietes.Personne;

public class VerbeFini extends Verbe {

	private Personne accord;

	public VerbeFini(Entree lexeme, String forme) {
		super(lexeme, forme);
	}

	public VerbeFini(Entree lexeme, String forme, Mode mode, Personne accord) {
		super(lexeme, forme, mode);
	}
	
	public void setAccord(Personne accord) {
		this.accord = accord;
	}

	public Personne getAccord() {
		return accord;
	}
}
