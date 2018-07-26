package parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;

import org.junit.Assert;

public class ParserTest {

	@Test
	public void monTest() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		ParserDOM parser = new ParserDOM("src\\test\\resources\\Exercice6.xml");
		
		Assert.assertEquals("Paul Pappel", parser.trouverPatientParDateDeNaissance("19551217"));
		System.out.println(parser.trouverPatientParDateDeNaissanceV2("19551217"));
		
		List<String> p = new ArrayList<String>();
		p.add("a");
		p.add("b");
		System.out.println(p);
		
		List<ParserDOM> p2 = new ArrayList<ParserDOM>();
		p2.add(new ParserDOM("src\\test\\resources\\Exercice6.xml"));
		p2.add(new ParserDOM("src\\test\\resources\\Exercice6.xml"));
		System.out.println(p2);
	}
}
