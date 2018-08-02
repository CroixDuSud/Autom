package org.eql.autom.libreplan.pageobject.ressources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Calendrier.OngletCalendrier;

public class PageConnexion {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID, using ="textfield") ////input[contains(@name,"username")], "//input[contains(@name,'username')]"
	private WebElement champLogin;
	
	@FindBy(how = How.ID, using = "textfield2")
	private WebElement champMotDePasse;
	
	@FindBy(how = How.ID, using = "button")
	private WebElement boutonSeConnecter;

	
	public OngletCalendrier seConnecter(String login, String motDePasse) {
		champLogin.clear();
		champLogin.sendKeys(login);
		champMotDePasse.clear();
		champMotDePasse.sendKeys(motDePasse);
		boutonSeConnecter.click();
		return PageFactory.initElements(driver, OngletCalendrier.class);
	}

	public PageConnexion (WebDriver driver) {
		super();
		this.driver=driver;
		
	}

	public WebElement getChampLogin() {
		return champLogin;
	}

	
	public WebElement getChampMotDePasse() {
		return champMotDePasse;
	}

	
	public WebElement getBoutonSeConnecter() {
		return boutonSeConnecter;
	}
	
}
