package org.eql.autom.libreplan.pageobject;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import org.eql.autom.libreplan.pageobject.ressources.PageConnexion;

public class SeConnecter {
	


	@Test
	public void testConnexion() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\Desktop\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		PageConnexion connexion = PageFactory.initElements(driver, PageConnexion.class);
		
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		
		assertTrue(connexion.getChampLogin().isDisplayed());
		
		assertTrue(connexion.getChampMotDePasse().isDisplayed());
		
		assertTrue(connexion.getBoutonSeConnecter().isDisplayed());
		
		connexion.seConnecter("admin", "admin");			
		
	}

}
