package Calendrier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.IntegerSyntax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageCreerNouveauProjet extends OngletCalendrier {

	public PageCreerNouveauProjet(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// WebDriver driver;

	Date d = new Date();
	public int dateActuelle;
	private String dateActuelleString;
	// String dateDuJour = String.valueOf(dateActuelle);

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Créer un nouveau projet')]")
	private WebElement titreCreerNouveauProjet;


	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Nom')]/../../following-sibling::td/div/input")
	private WebElement champNom;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Modèle')]/../../following-sibling::td/div/span/i/input")
	private WebElement champModele;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Modèle')]/../../following-sibling::td/div/span/i/i")
	private WebElement boutonLoupeModele;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Code')]/../../following-sibling::td/div/table/tbody/tr/td/table/tbody/tr/td/input")
	private WebElement champCode;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Code')]/../../following-sibling::td/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/input")
	private WebElement checkboxGenererCode;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Date de début')]/../../following-sibling::td/div/i/input")
	private WebElement champDateDebut;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Date de début')]/../../following-sibling::td/div/i/i")
	private WebElement boutonDateDebut;

	@FindBy(how = How.ID, using = "_z_4-ry")
	private WebElement boutonMoisSuivantDateDebut;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Echéance')]/../../following-sibling::td/div/i/input")
	private WebElement champEcheance;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Echéance')]/../../following-sibling::td/div/i/i")
	private WebElement boutonEcheance;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Client')]/../../following-sibling::td/div/span/i/input")
	private WebElement champClient;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Client')]/../../following-sibling::td/div/span/i/i")
	private WebElement boutonLoupeClient;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Client')]/../../../following-sibling::tr/td[2]/div/i/input")
	private WebElement menuDeroulantCalendrier;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Accepter')]")
	private WebElement boutonAccepter;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Annuler')]")
	private WebElement boutonAnnuler;

	@FindBy(how = How.ID, using = "z_4-tm")
	private WebElement moisCalendrier;

	public void saisirChampNom(String nom) {
		champNom.clear();
		champNom.sendKeys(nom);
	}

	public void saisirChampModele(String modele) {
		champModele.clear();
		champModele.sendKeys(modele);
	}

	public void saisirCode(String code) {
		champCode.clear();
		champCode.sendKeys(code);
	}

	public void cliquerCheckboxGenererCode() {
		checkboxGenererCode.click();
	}

	public void cliquerBoutonDateDebut() {
		boutonDateDebut.click();
	}

	public void saisirDateDebut(int jour, EnumerationMoisCalendrier mois, int annee) {
		// EnumerationMoisCalendrier enumeration = null;
		champDateDebut.clear();
		String date = jour + " " + mois + ". " + annee;
		champDateDebut.sendKeys(date);
	}
	


	/*
	 * public void selectionnerDebutDateCalendrier(int nombreJoursAjoutes) {
	 * nombreJoursAjoutes = nombreJoursAjoutes; 
	 * Calendar calendar = 	 * Calendar.getInstance(); 
	 * 
	 * // Obtenir le mois actuel pour le comprarer au nouveau mois int moisActuel = calendar.get(Calendar.MONTH);
	 * calendar.add(Calendar.DATE, nombreJoursAjoutes); 
	 * int nouveauMois = calendar.get(Calendar.MONTH); 
	 * 
	 * // Prendre la date actuelle pour lui ajouter  des jours 
	 * dateActuelle = d.getDate() + nombreJoursAjoutes; 
	 * 
	 * //obtenir le nombre de jours dans le mois int nbreJoursMois =
	 * calendar.getActualMaximum(dateActuelle); // Convertir dateActuelle en String 
	 * String dateActuelleString = Integer.toString(dateActuelle);
	 * 	 * System.out.println(d.getDate() + "et" + dateActuelleString); 
	 * 
	 * // Soustraire le  nouveau mois au mois actuel pour obtenir le nombre nécessaire de fois où il faut appuyer sur la flèche mois suivant 
	 * int nombreDeClics = nouveauMois - moisActuel; 
	 * 
	 * if (nouveauMois > moisActuel) { 
		 * int i = 1; 
		 * do 
		 * { if (Integer.valueOf(dateActuelle)> nbreJoursMois) 
			 * { int ValeurJourMoisSuivant = dateActuelle- nbreJoursMois; 
			 * String ValeurJourMoisSuivantString = String.valueOf(ValeurJourMoisSuivant); 
			 * boutonMoisSuivantDateDebut.click();
			 * driver.findElement(By.xpath("//table[@id='_z_4-mid']/tbody/tr/td[@_dt='" + ValeurJourMoisSuivantString + "']")) .click(); i++; 
			 * } else {
			 * boutonMoisSuivantDateDebut.click();
			 * driver.findElement(By.xpath("//table[@id='_z_4-mid']/tbody/tr/td[@_dt='" + dateActuelleString + "']")) .click(); i++;} } while (i <= nombreDeClics);
			 * } 
		 *else {
		 * driver.findElement(By.xpath("//table[@id='_z_4-mid']/tbody/tr/td[@_dt='" + dateActuelleString + "']")) .click(); } }
	 */

	public void saisirEcheance(int jour, EnumerationMoisCalendrier mois, int annee) {
		// EnumerationMoisCalendrier enumeration = null;
		champEcheance.clear();
		String date = jour + " " + mois + ". " + annee;
		champEcheance.sendKeys(date);
	}

	public void saisirClient(String client) {
		champClient.clear();
		champClient.sendKeys(client);
	}

	public void selectionnerCalendrier(String calendrier) {
		menuDeroulantCalendrier.clear();
		menuDeroulantCalendrier.sendKeys(calendrier);
	}
	
	public PageDetailProjet cliquerBoutonAccepter() {
		boutonAccepter.click();
		return PageFactory.initElements(driver, PageDetailProjet.class);
				
	}


	public WebElement getTitreCreerNouveauProjet() {
		return titreCreerNouveauProjet;
	}

	public WebElement getChampNom() {
		return champNom;
	}

	public WebElement getChampModele() {
		return champModele;
	}

	public WebElement getBoutonLoupeModele() {
		return boutonLoupeModele;
	}

	public WebElement getChampCode() {
		return champCode;
	}

	public WebElement getCheckboxGenererCode() {
		return checkboxGenererCode;
	}

	public WebElement getChampDateDebut() {
		return champDateDebut;
	}

	public WebElement getBoutonDateDebut() {
		return boutonDateDebut;
	}

	public WebElement getBoutonMoisSuivantDateDebut() {
		return boutonMoisSuivantDateDebut;
	}

	public WebElement getChampEcheance() {
		return champEcheance;
	}

	public WebElement getBoutonEcheance() {
		return boutonEcheance;
	}

	public WebElement getChampClient() {
		return champClient;
	}

	public WebElement getBoutonLoupeClient() {
		return boutonLoupeClient;
	}

	public WebElement getMenuDeroulantCalendrier() {
		return menuDeroulantCalendrier;
	}

	public WebElement getBoutonAccepter() {
		return boutonAccepter;
	}

	public WebElement getBoutonAnnuler() {
		return boutonAnnuler;
	}

	public WebElement getMoisCalendrier() {
		return moisCalendrier;
	}


	/*
	 * public void selectionnerDate(int jour, String mois, int annee) {
	 * moisCalendrier.click();
	 * driver.findElement(By.xpath("//td[contains(text(),'"+mois+".')]")).click(); }
	 */
}
