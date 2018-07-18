package org.eql.autom.orangehrm.junit;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrameTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	
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
}
