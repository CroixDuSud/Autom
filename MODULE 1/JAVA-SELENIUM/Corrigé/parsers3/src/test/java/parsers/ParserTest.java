package parsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Ignore;

public class ParserTest {

	@Test
	@Ignore
	public void monTest() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,
			TransformerException {

		ParserDOM parser = new ParserDOM("src\\test\\resources\\Exercice6.xml");

		Assert.assertEquals("Paul Pappel", parser.trouverPatientParDateDeNaissance("19551217"));
		System.out.println(parser.trouverPatientParDateDeNaissanceV2("19551217"));

		parser.ecrireLeDocumentDansUnFichier("target/nouveau.xml");
		List<String> p = new ArrayList<String>();
		p.add("a");
		p.add("b");
		System.out.println(p);

		List<ParserDOM> p2 = new ArrayList<ParserDOM>();
		p2.add(new ParserDOM("src\\test\\resources\\Exercice6.xml"));
		p2.add(new ParserDOM("src\\test\\resources\\Exercice6.xml"));
		System.out.println(p2);

		parser.afficherTousLesNoeuds();
	}

	@Test
	@Ignore
	public void parserSAX() throws SAXException, IOException, ParserConfigurationException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		// factory.setNamespaceAware(true);
		SAXParser saxParser = factory.newSAXParser();
		saxParser.parse("src\\test\\resources\\Exercice6.xml", new SAXHandler());

	}

	@Test
	@Ignore
	public void parserSAXDateDeNaissance() throws SAXException, IOException, ParserConfigurationException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		// factory.setNamespaceAware(true);
		SAXParser saxParser = factory.newSAXParser();
		PatientHandler handler = new PatientHandler("19551217");
		saxParser.parse("src\\test\\resources\\Exercice6.xml", handler);
		Assert.assertEquals("Paul Pappel", handler.getResultat());

	}

	@Test
	public void testRapide() throws IOException {
		
		InputStream stream = new FileInputStream("src\\test\\resources\\Contact.xlsx");
		Workbook workbook = new XSSFWorkbook(stream);
		
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			
			Sheet sheet = workbook.getSheetAt(i);
			System.out.println(sheet.getSheetName());
			
			for (Row row : sheet) {
				
				for (Cell cell : row) {
					
					switch(cell.getCellTypeEnum()) {
					
						case STRING : System.out.println(cell.getStringCellValue()); break;
							
						case NUMERIC : System.out.println((int) cell.getNumericCellValue()); break;
					
						case BLANK: break;
					
						case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
					
						case ERROR: break;
					
						case FORMULA: System.out.println(cell.getCellFormula()); 
									  if(cell.getCachedFormulaResultTypeEnum().equals(CellType.NUMERIC)){
										  System.out.println((int) cell.getNumericCellValue()); break;
									  }
					
						case _NONE: break;
					
						default: break;
					}
					
					XSSFCellStyle style = (XSSFCellStyle) cell.getCellStyle();
					if(style != null) {
						XSSFFont font = style.getFont();
						System.out.println("Couleur de la cellule? "+style.getFillBackgroundColorColor());
						System.out.println("Gras? "+font.getBold()+" Couleur du texte? "+font.getXSSFColor());
					}
				}
			}
		}
		workbook.close();

	}
}
