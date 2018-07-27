package parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PatientHandler extends DefaultHandler {

	private boolean enTrainDeLireGiven = false;

	private boolean enTrainDeLireFamily = false;

	private String dateDeNaissance;
	
	private String birthtimeValue = "";
	
	private String prenom = "";
	
	private String nom = "";
	
	private String resultat = "";
	// Objectif: retourner le patient avec la date de naissance souhait�e (par
	// exemple: 19551217)

	public PatientHandler(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	public String getResultat() {
		return this.resultat;
	}

	public void startDocument() throws SAXException {
	}

	public void endDocument() throws SAXException {
	}

	/**
	 * Hypoth�ses : 1) given, family et birthtime sont obligatoires 2) given &
	 * family pr�c�dent birthtime
	 * 
	 * Si vous ne faites pas ces hypoth�ses, il faut contr�ler qu'on a bien tous ces
	 * �l�ments au sein d'un m�me patient quel que soit l'ordre.
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {

		case "patient" :
			this.prenom = "";
			this.nom = "";
			this.birthtimeValue = "";
		case "given":
			this.enTrainDeLireGiven = true;
			break;

		case "family":
			this.enTrainDeLireFamily = true;
			break;

		case "birthtime": 
			this.birthtimeValue = attributes.getValue("value");
		default:
		}

		System.out.println("Statut du booleen � l'ouverture de la balise "+ qName +": "+this.enTrainDeLireGiven);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {

		case "given":
			this.enTrainDeLireGiven = false;
			break;

		case "family":
			this.enTrainDeLireFamily = false;
			break;

		case "patient": 
			if(this.dateDeNaissance.equals(this.birthtimeValue)) {
				this.resultat = this.prenom + " " + this.nom;
			}

		default:
		}
		
		System.out.println("Statut du booleen � la fermeture de la balise "+ qName +": "+this.enTrainDeLireGiven);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {

		System.out.println(String.copyValueOf(ch, start, length));
		
		if(this.enTrainDeLireGiven == true) {
			
			this.prenom = String.copyValueOf(ch, start, length);
		}
		
		if(this.enTrainDeLireFamily == true) {
			
			this.nom = String.copyValueOf(ch, start, length);
		}
	}

}
