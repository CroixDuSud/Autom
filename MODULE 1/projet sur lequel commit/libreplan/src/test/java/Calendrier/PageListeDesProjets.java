package Calendrier;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageListeDesProjets extends OngletCalendrier {

	public PageListeDesProjets(WebDriver driver) {
		super(driver);
	}
	// TODO Auto-generated constructor stub

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']")
	private WebElement iconeOperationsModifier;

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']")
	private WebElement iconeOperationSupprimer;

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_planificador1.png']")
	private WebElement iconeOperationVoirPrevision;

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_derived1.png']")
	private WebElement iconeOperationCreerModele;

	public WebElement getIconeOperationsModifier() {
		return iconeOperationsModifier;
	}

	public WebElement getIconeOperationSupprimer() {
		return iconeOperationSupprimer;
	}

	public WebElement getIconeOperationVoirPrevision() {
		return iconeOperationVoirPrevision;
	}

	public WebElement getIconeOperationCreerModele() {
		return iconeOperationCreerModele;
	}

	
	public String obtenirTextChampNom(String string) {
		String champNom = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return champNom;
	}

	public String obtenirTextcaseCode(String string) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return element;
	}

	public String obtenirTextcaseDateDebut(int jour, EnumerationMoisCalendrier mois, int annee) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + jour + " " + mois + ". " + annee + " ')]")).getText();
		return element;
	}
	
	public String obtenirTextcaseEcheance(int jour, EnumerationMoisCalendrier mois, int annee) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + jour + " " + mois + ". " + annee + "')]")).getText();
		return element;
	}

	public String obtenirTextCaseClient(String string) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return element;
	}

	public String obtenirTextCaseBudgetTotal(String string) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return element;
	}

	public String obtenirTextCaseHeures(String string) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return element;
	}

	public String obtenirTextCaseEtat(String string) {
		String element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).getText();
		return element;
	}
}
