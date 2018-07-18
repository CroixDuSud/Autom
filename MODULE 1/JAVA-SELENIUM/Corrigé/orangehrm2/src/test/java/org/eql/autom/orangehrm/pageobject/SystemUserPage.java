package org.eql.autom.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SystemUserPage extends MenuPage {

	@FindBy(id="searchSystemUser_userType")
	private WebElement menuDeroulantUserRole;
	
	@FindBy(id="searchBtn")
	private WebElement boutonRecherche;
	
	@FindBy(xpath="(//table[@id='resultTable']//td)[2]")
	private WebElement tableauRechercheUtilisateurTrouve;
	
	@FindBy(xpath="//table[@id='resultTable']//td")
	private WebElement tableauRechercheMessagePasDeResultat;
	
	public SystemUserPage(WebDriver driver) {
		super(driver);
	}

	public void rechercheParRole(String role) {
		
		Select menu = new Select(menuDeroulantUserRole);
		menu.selectByVisibleText(role);
		boutonRecherche.click();
	}
	
	public String getTableauRechercheUtilisateurTrouve() {
		return this.tableauRechercheUtilisateurTrouve.getText();
	}
	
	public String getTableauRechercheMessagePasDeResultat() {
		return this.tableauRechercheMessagePasDeResultat.getText();
	}
}
