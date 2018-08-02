package org.eql.autom.libreplan.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProfils extends OngletConfiguration
{

    @FindBy(xpath="//*/div[@class='z-column-cnt']/div[@class='z-column-sort-img']/../text()")
    protected WebElement colonneNomProfil;

    @FindBy()
    protected WebElement colonneAction;

    @FindBy()
    protected WebElement iconeModifier;

    @FindBy()
    protected WebElement iconeSupprimer;

    public PageProfils(WebDriver driver)
    {
        super(driver);
    }

	public static void creerProfil() {
	}
}