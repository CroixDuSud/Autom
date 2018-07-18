package petstoretest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PremierTestSelenium {

	@Test
	public void afficherPageAccueil() {
	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		try {
		
		driver.get("http://localhost:8180/jpetstore-1.0.5-env2/");
		
		/*PageAccueil p = //...
		WebElement lienEntree = p.getLienEnterTheStore();
		assertEquals("texte du lien", "Enter the Store", lienEntree.getText());
		PageCatalogue p2 = p.entrerDansLePetStore();
		boolean res = p2.verifierImageCentrale();
		assertEquals("image centrale existe", true, res);*/
		
		//assertion sur le lien
		WebElement lienEntree = driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/p[5]/a"));
		assertEquals("texte du lien", "Enter the Store", lienEntree.getText());
	
		//sélection via le texte
		WebElement lienEntree2 = driver.findElement(By.linkText("Enter the Store"));
		assertEquals("texte du lien2", "Enter the Store", lienEntree2.getText());
		
		//sélection via xpath
		List<WebElement> lienEntree3 = driver.findElements(By.xpath("(//a[@href='shop/index.do'])[2]"));
		//assertEquals(2,lienEntree3.size());
		//assertEquals("texte du lien3", "Enter the Store", lienEntree3.get(0).getText());
		//assertEquals("texte du lien3", "Enter the Store", lienEntree3.get(1).getText());
		assertEquals("texte du lien3", "Enter the Store", lienEntree3.get(0).getText());
		
		//clic
		lienEntree.click();
		
		//assertion sur l'image
		WebElement imageCentrale = driver.findElement(By.xpath("//img[@src='../images/splash.gif']"));
				
		}
		
		finally {
			driver.quit();
		}
	}
}
