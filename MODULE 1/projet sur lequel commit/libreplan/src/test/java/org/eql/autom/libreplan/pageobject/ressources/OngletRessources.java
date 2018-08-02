package org.eql.autom.libreplan.pageobject.ressources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OngletRessources extends MenuOnglet {

	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/resources/worker/worker.zul']")
	protected WebElement participantsRessources;
	
	@FindBy(xpath="//a[contains(text(), 'Machines') and @class='z-menu-item-cnt']")
	protected WebElement machinesRessources;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/resources/worker/virtualWorkers.zul']")
	protected WebElement travailleursVirtuels;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/calendars/calendars.zul']")
	protected WebElement calendriersRessources;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/excetionsdays/exceptionDays.zul']")
	protected WebElement joursExceptionnelsCalendrier;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/resources/criterions/criterions.zul']")
	protected WebElement critereRessources;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/advance/advanceTypes.zul']")
	protected WebElement typesAvancement;
	
	@FindBy(xpath="//a[@href='http://localhost:8180/libreplan/qualityforms/qualityForms.zul']")
	protected WebElement formulairesQualite;
	
	public OngletRessources (WebDriver driver) {

		super(driver);
	}
		
	public PageParticipants cliquerParticipants() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(participantsRessources).click().build().perform();
		return PageFactory.initElements(driver, PageParticipants.class);
	}
	
	public PageMachines cliquerMachines() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(machinesRessources).click().build().perform();
		return PageFactory.initElements(driver, PageMachines.class);
	}
	
	public PageTravailleursVirtuels cliquerTravailleurs() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(travailleursVirtuels).click().build().perform();
		return PageFactory.initElements(driver, PageTravailleursVirtuels.class);
	}
	
	public PageCalendriers cliquerCalendriers() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(calendriersRessources).click().build().perform();
		return PageFactory.initElements(driver, PageCalendriers.class);
	}
	
	public PageJoursExceptionnelsCalendrier cliquerCalendriers1() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(joursExceptionnelsCalendrier).click().build().perform();
		return PageFactory.initElements(driver, PageJoursExceptionnelsCalendrier.class);
	}
	
	public PageCriteres cliquerCriteres() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(critereRessources).click().build().perform();
		return PageFactory.initElements(driver, PageCriteres.class);
	}
	
	public PageTypesAvancement cliquerTypesAvancement() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(typesAvancement).click().build().perform();
		return PageFactory.initElements(driver, PageTypesAvancement.class);
		
	}
	
	public PageFormulairesQualite cliquerFormulairesQualite() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources).moveToElement(formulairesQualite).click().build().perform();
		return PageFactory.initElements(driver, PageFormulairesQualite.class);
	}
}
		
		
