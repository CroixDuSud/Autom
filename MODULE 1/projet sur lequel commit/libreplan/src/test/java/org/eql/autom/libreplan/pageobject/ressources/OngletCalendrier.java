package org.eql.autom.libreplan.pageobject.ressources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OngletCalendrier {
	
	protected final WebDriver driver;
	
	public OngletCalendrier(WebDriver driver) {
		super();
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFilArianePlanificationProjets() {
		return FilArianePlanificationProjets;
	}

	public WebElement getCliquerBoutonNouveauProjet() {
		return cliquerBoutonNouveauProjet;
	}

	public WebElement getPagePlanificationProjets() {
		return pagePlanificationProjets;
	}

	public WebElement getPageListeProjets() {
		return pageListeProjets;
	}

	public WebElement getPageChargementRessources() {
		return pageChargementRessources;
	}

	public WebElement getPageCalendrierRessourcesFile() {
		return pageCalendrierRessourcesFile;
	}

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'DEBUT')]/../following-sibling::td[2]/table/tbody/tr/td/table/tbody/tr/td/span[contains(text(),'Calendrier')]/../following-sibling::td/span[contains(text(),'Planification des projets')]")
	private WebElement FilArianePlanificationProjets;
	
	@FindBy(how = How.XPATH, using = "//img[@src='/libreplan/common/img/ico_add.png']")
	private WebElement cliquerBoutonNouveauProjet;	

	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Planification des projets')]")
	private WebElement pagePlanificationProjets; 
	
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Liste des projets')]")
	private WebElement pageListeProjets; 
		
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Chargement des ressources')]")
	private WebElement pageChargementRessources; //
		
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Calendrier des ressources en file')]")	
	private WebElement pageCalendrierRessourcesFile;
		
}
