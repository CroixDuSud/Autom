package org.eql.autom.libreplan.pageobject.ressources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Calendrier.OngletCalendrier;
import Calendrier.PageListeDesProjets;

public class MenuOnglet
{
    protected WebDriver driver;

    /****************************************
    *              1er niveau
    ***************************************/

    @FindBy (xpath="//td[1]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletCalendrier;

    @FindBy (xpath="//td[2]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletRessources;

    @FindBy (xpath="//td[3]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletCout;

    @FindBy (xpath="//td[4]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletConfiguration;

    @FindBy (xpath="//td[5]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletCommunications;

    @FindBy (xpath="//td[6]/table/tbody/tr/td[2]/div/button")
     protected WebElement ongletRapports;

    @FindBy (xpath="//td[7]/table/tbody/tr/td[2]/div/button")
    protected WebElement ongletZonePersonnelle;
    
    @FindBy(xpath = "//div[@class='z-menu-item-cm']/a[contains(text(),'Vue de la compagnie')]")
	protected WebElement lienVueDeLaCompagnie;

	@FindBy(xpath = "//div[@class=\"z-menu-item-cm\"]/a[contains(text(),'Projets')]")
	protected WebElement lienProjets;


    /****************************************
    *              Onglet Calendrier
    ***************************************/

    /****************************************
    *              Onglet Configuration
    ***************************************/

    /****************************************
    *              Onglet Profils
    ***************************************/

    @FindBy()
    protected WebElement machine;

    /****************************************
    *              Onglet Ressources
    ***************************************/

    

    /****************************************
    *              1er niveau
    ***************************************/

    /****************************************
    *              1er niveau
    ***************************************/



    public MenuOnglet(WebDriver driver)
    {
         super();
         this.driver = driver;
    }

     public PageMachines cliquerMachines()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(ongletRessources)
            .moveToElement(machine)
            .click().build().perform();
            return PageFactory.initElements(driver, PageMachines.class);
    }

     
     public OngletCalendrier cliquerLienVueDeLacompagnie() {
 		Actions actions = new Actions(driver);
 		actions.moveToElement(ongletCalendrier).moveToElement(lienVueDeLaCompagnie).click().build().perform();
 		return PageFactory.initElements(driver, OngletCalendrier.class);

 	}

 	public PageListeDesProjets cliquerLienProjets() {
 		Actions actions = new Actions(driver);
 		actions.moveToElement(ongletCalendrier).moveToElement(lienProjets).click().build().perform();
 		return PageFactory.initElements(driver, PageListeDesProjets.class);

 	}
}