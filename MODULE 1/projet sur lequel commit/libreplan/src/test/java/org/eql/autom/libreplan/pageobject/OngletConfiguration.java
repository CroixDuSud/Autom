package org.eql.autom.libreplan.pageobject;

import org.eql.autom.libreplan.pageobject.ressources.MenuOnglet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class OngletConfiguration extends MenuOnglet
{
    @FindBy()
    protected WebElement profils;

    public OngletConfiguration(WebDriver driver)
    {
        super(driver);
    }

    public PageProfils cliquerProfils()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(ongletConfiguration)
            .moveToElement(profils)
            .click().build().perform();
            return PageFactory.initElements(driver, PageProfils.class);
    }




/*  A recupérer pour l'onglet ressources



    public PageFormulairesDeQualite cliquerFormulairesDeQualite()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuCout)
            .moveToElement(feuilleDeTemps)
            .click().build().perform();
            return PageFactory.initElements(driver, PageFeuilleDeTemps.class);
    }
    */
}