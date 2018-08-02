package org.eql.autom.libreplan.pageobject;

import org.eql.autom.libreplan.pageobject.ressources.MenuOnglet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OngletCout extends MenuOnglet
{

    @FindBy()
    protected WebElement feuilleDeTemps;

    @FindBy()
    protected WebElement typesHeures;

    @FindBy()
    protected WebElement categoriesDeCout;

    public OngletCout(WebDriver driver)
    {
        super(driver);
    }

    public PageFeuilleDeTemps cliquerFeuilleDeTemps()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuCout)
            .moveToElement(feuilleDeTemps)
            .click().build().perform();
            return PageFactory.initElements(driver, PageFeuilleDeTemps.class);
    }

    public PageTypesHeures cliquerTypesHeures()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuCout)
            .moveToElement(typesHeures)
            .click().build().perform();
            return PageFactory.initElements(driver, PageTypesHeures.class);
    }

    public PageCategoriesDeCout cliquerCategoriesDeCout()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(menuCout)
            .moveToElement(categoriesDeCout)
            .click().build().perform();
            return PageFactory.initElements(driver, PageCategoriesDeCout.class);
    }


}