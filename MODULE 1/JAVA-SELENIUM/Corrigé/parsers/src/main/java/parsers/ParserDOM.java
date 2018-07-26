package parsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author formation
 *
 */
public class ParserDOM {

	/**
	 * Document représentant le fichier à lire
	 */
	private Document xmlDocument;
	
	private String fichier;
	
	/**
	 * Permet d'initialiser un parseur DOM sur le fichier passé en paramètre
	 * @param fichier XML à lire
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public ParserDOM(String file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		this.fichier = file;
		this.xmlDocument = builder.parse(new File(file));
	}
	
	/**
	 * Permet de retourner le prénom et nom du patient d'après sa
	 * date de naissance et retourne null si aucun patient n'est trouvé
	 * @param dateDeNaissance du patient au format AAAAMMJJ
	 * @return prénom et nom du patient 
	 * @throws XPathExpressionException 
	 */
	public String trouverPatientParDateDeNaissance(String dateDeNaissance) throws XPathExpressionException {
		
		//Construire une expression Xpath en Java
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//birthtime[@value='"+dateDeNaissance+"']/../../name");
		
		//Appliquer un XPath absolu à mon document
		Object result = expr.evaluate(this.xmlDocument, XPathConstants.NODE);
		Node node = (Node) result;
		
		XPathExpression expr2 = xpath.compile("given"); 
		//Appliquer un XPath absolu à mon document
		String prenom = (String) expr2.evaluate(node, XPathConstants.STRING);
		
		XPathExpression expr3 = xpath.compile("family"); 
		String nom = (String) expr3.evaluate(node, XPathConstants.STRING);
		
		return prenom+" "+nom;
	}
	
	/**
	 * Permet de retourner le prénom et nom du patient d'après sa
	 * date de naissance et retourne null si aucun patient n'est trouvé
	 * @param dateDeNaissance du patient au format AAAAMMJJ
	 * @return prénom et nom du patient 
	 * @throws XPathExpressionException 
	 */
	public String trouverPatientParDateDeNaissanceV2(String dateDeNaissance) throws XPathExpressionException {
		
		//Construire une expression Xpath en Java
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//birthtime[@value='"+dateDeNaissance+"']/../../name");
		
		//Appliquer un XPath absolu à mon document
		Object result = expr.evaluate(this.xmlDocument, XPathConstants.NODE);
		Node node = (Node) result;
		
		String prenom = "";
		String nom = "";
		NodeList enfants = node.getChildNodes();
		System.out.println(enfants.getLength());
		for(int i=0; i<enfants.getLength(); i++) {
			System.out.println(i+": "+enfants.item(i).getTextContent());
			
			if("given".equals(enfants.item(i).getLocalName())) {
				prenom = enfants.item(i).getTextContent();
			}
			if("family".equals(enfants.item(i).getLocalName())) {
				nom = enfants.item(i).getTextContent();
			}
		}
		
		
		
		return prenom+" "+nom;
	}
	@Override
	public String toString() {
		return "toto";
	}
}
