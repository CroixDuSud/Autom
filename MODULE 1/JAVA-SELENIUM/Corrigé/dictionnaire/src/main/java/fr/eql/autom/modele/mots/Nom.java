package fr.eql.autom.modele.mots;

import fr.eql.autom.modele.entrees.EntreeNominale;
import fr.eql.autom.modele.proprietes.Nombre;

public class Nom extends Mot {

	private Nombre nombre; 
	
	public Nom(EntreeNominale lexeme, String forme) {
		super(lexeme, forme);
	}

	public Nom(EntreeNominale lexeme, String forme, Nombre nombre) {
		super(lexeme, forme);
		this.nombre = nombre;
	}

	public Nombre getNombre() {
		return nombre;
	}
}
