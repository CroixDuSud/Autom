package parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	public void startDocument() throws SAXException{
		System.out.println("DEBUT DU FICHIER");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("FIN DU FICHIER");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("DEBUT DE LA BALISE local: "+localName+ " qName: "+qName+ " uri: "+uri);
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<attributes.getLength(); i++) {
			builder.append(attributes.getLocalName(i)+": "+attributes.getValue(i));
		}
		System.out.println("ATTRIBUTS DE LA BALISE: "+builder.toString());
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("FIN DE LA BALISE: "+qName);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("TEXTE: "+String.copyValueOf(ch, start, length));
	}

}
