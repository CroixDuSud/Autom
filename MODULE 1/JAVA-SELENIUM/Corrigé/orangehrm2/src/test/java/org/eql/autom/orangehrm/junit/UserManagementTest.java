package org.eql.autom.orangehrm.junit;

import static org.junit.Assert.assertEquals;

import org.eql.autom.orangehrm.pageobject.HomePage;
import org.eql.autom.orangehrm.pageobject.LoginPage;
import org.eql.autom.orangehrm.pageobject.SystemUserPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UserManagementTest {

	@Test
	public void testConnexion() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/auth/login");
		
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		HomePage home = page.seConnecter("admin", "admin");
		assertEquals("changement de page","http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/dashboard", driver.getCurrentUrl());
	
		SystemUserPage user = home.cliquerMenuAdmin();
		
		user.rechercheParRole("Admin");
		String nomUser = user.getTableauRechercheUtilisateurTrouve();
		assertEquals("utilisateur admin trouvé","admin",nomUser);
		
		user.rechercheParRole("ESS");
		String message = user.getTableauRechercheMessagePasDeResultat();
		assertEquals("message pas d'utilisateur trouvé","No Records Found",message);
		
		driver.quit();
	}
}
