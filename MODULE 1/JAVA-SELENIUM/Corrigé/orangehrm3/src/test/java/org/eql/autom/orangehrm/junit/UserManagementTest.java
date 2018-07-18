package org.eql.autom.orangehrm.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eql.autom.orangehrm.pageobject.HomePage;
import org.eql.autom.orangehrm.pageobject.InvalidTableRowNumberException;
import org.eql.autom.orangehrm.pageobject.LoginPage;
import org.eql.autom.orangehrm.pageobject.PageDetailUtilisateur;
import org.eql.autom.orangehrm.pageobject.SystemUserPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UserManagementTest {

	private WebDriver driver;
	
	@Before 
	public void ouvertureDeLApplication() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		this.driver = new FirefoxDriver();	
		this.driver.manage().window().maximize();
		this.driver.get("http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/auth/login");
		
	}
	
	@After
	public void fermetureDuNavigateur() {
		this.driver.quit();
	}
	
	@Test
	public void testConnexion() throws InvalidTableRowNumberException {

		LoginPage page = PageFactory.initElements(this.driver, LoginPage.class);
		HomePage home = page.seConnecter("admin", "admin");
		assertEquals("changement de page","http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/dashboard", driver.getCurrentUrl());
	
		SystemUserPage user = home.cliquerMenuViewSystemUsers();
	
		user.rechercheParRole("ESS");
		String message = user.getTableauRechercheMessagePasDeResultat();
		assertEquals("message pas d'utilisateur trouvé","No Records Found",message);
		
		user.rechercheParRole("Admin");
		String nomUser = user.getTableauRechercheUtilisateurTrouve();
		assertEquals("utilisateur admin trouvé","admin",nomUser);
				
		PageDetailUtilisateur detail = user.cliquerSurLienDetailsDeLUtilisateur("E E E");
		assertTrue(detail.formulaireInactif());
	}
}
