package org.eql.autom.orangehrm.junit;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrameTest {

	WebDriver driver;
	
	/*
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		driver = new FirefoxDriver();
	}*/
	
	/*@After
	public void tearDown() {
		driver.quit();
	}*/
	
	@Ignore
	@Test
	public void recupererTextetAttributDansUneIFrame() {
		
		driver.get("https://www.xul.fr/html5/iframe.php");
		
		driver.switchTo().frame(0);
		
		assertEquals("Exemple de contenu inclut dans la balise.", getTexte());
		
		assertEquals("https://www.xul.fr/html5/images/freeciv.jpg", getSrcAttribute());
		
		driver.switchTo().defaultContent();
	}
	
	public String getTexte() {
		WebElement texte = driver.findElement(By.xpath("//strong"));
		return texte.getText();
	}
	
	public String getSrcAttribute() {
		WebElement image = driver.findElement(By.xpath("//img"));
		return image.getAttribute("src");
	}

	@Ignore
	@Test
	public void changementDOnglet() throws InterruptedException {
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		
		driver.switchTo().frame("iframeResult");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement lien = driver.findElement(By.xpath("//a"));
		
		Set<String> handlesAvantClic = driver.getWindowHandles();
		
		String pointDeDepart = driver.getWindowHandle();
		
		lien.click();
		
		driver.switchTo().defaultContent();
		
		Set<String> handlesApresClic = driver.getWindowHandles();
		
		handlesApresClic.removeAll(handlesAvantClic); //reste plus que les nouveaux
		
		String nouveauHandle = handlesApresClic.iterator().next();
		
		driver.switchTo().window(nouveauHandle);
		
		WebElement titre = driver.findElement(By.xpath("//h1/following-sibling::p"));
		
		assertEquals("The language for building web pages", titre.getText());
		
		driver.switchTo().window(pointDeDepart);
		
		driver.close();
	}
	
	@Ignore 
	@Test
	public void testAlert() {
		
		driver.get("http://www.startyourdev.com/html/evenement-html-onclick");
		
		WebElement bouton = driver.findElement(By.xpath("//div[@id='div_code_rendu']//input"));
		
		bouton.click();
		
		Alert a = driver.switchTo().alert();
		
		assertEquals("Clic sur le bouton", a.getText());
		
		a.accept();
		
	}
	
	@Test
	public void transformationDate() {
		
		//passer d'un texte à une date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedDate = LocalDate.parse("01/01/2000", formatter);
	
		//passer d'une date à un texte
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yy");
		String date = parsedDate.format(formatter2);
		
		//comparaison
		assertEquals("comparaison des dates", "01-01-00",date);
	}
	
	@Test
	public void transformationDate2() {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy", Locale.US);

	String dateAvantPretraitement = "FEB 3rd 2018";
	
	//supprimer st/nd/rd/th après le jour du mois
	dateAvantPretraitement = dateAvantPretraitement.replaceAll("(\\d+)(st|nd|rd|th)", "$1");
	//transformer le nom du mois en majuscules (FEB) en majuscule initiale + minuscules (Feb)
	dateAvantPretraitement = dateAvantPretraitement.replaceAll("FEB", "Feb");
	
	
	LocalDate parsedDate = LocalDate.parse(dateAvantPretraitement, formatter);
	
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd", Locale.FRENCH);
	String date = parsedDate.format(formatter2);
	//2018-févr.-03
	
	
	//remplacer le nom des mois de la locale français (févr.) par d'autres (FEV)
	//date = date.replaceAll("févr.", "FEV");
	
	String[] tab = date.split("-");
	switch(tab[1]) {
		case "janv." : tab[1] = "JAN";
		case "févr." : tab[1] = "FEV";
		//...
	}
	
	date = tab[0] + "-" + tab[1] + "-" + tab[2];
	
	StringBuilder builder = new StringBuilder();
	for(int i = 0; i<tab.length; i++) {
		builder.append(tab[i]);
		if(i != tab.length-1) {
			builder.append("-");
		}
	}

	//date = builder.substring(0, builder.length()-1).toString();
	date = builder.toString();
	
	//comparaison
	assertEquals("comparaison des dates", "2018-FEV-03", date);
	
	}
}
