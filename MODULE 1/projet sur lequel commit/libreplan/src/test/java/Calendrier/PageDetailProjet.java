package Calendrier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageDetailProjet extends OngletCalendrier {

	
	@FindBy(how = How.XPATH, using = "//strong/../following-sibling::td[2]/table/tbody/tr/td/table/tbody/tr/td/span[contains(text(),'Calendrier')]/../following-sibling::td/span[contains(text(),'Détail du projet')]")
	private WebElement FilArianeDetailProjet;


	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Allocation avancée')]")
	private WebElement pageAllocationsAvanceees;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Tableau de bord')]")
	private WebElement pageTableauDeBord;
	
	@FindBy(how = How.XPATH, using = "//img[@src='/libreplan/common/img/ico_save.png']")
	private WebElement boutonSauvegarder;
	
	@FindBy(how = How.XPATH, using = "//img[@src='/libreplan/common/img/ico_back.png']")
	private WebElement boutonAnnulerEdition;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WBS')]")
	private WebElement ongletWBS;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Données générales')]")
	private WebElement ongletDonneesGenerales;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Coût')]")
	private WebElement ongletCout;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Avancement')]")
	private WebElement ongletAvancement;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Libellés')]")
	private WebElement ongletLibelles;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Exigence de critère')]")
	private WebElement ongletExigenceCriteres;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Matériels')]")
	private WebElement ongletMateriels;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Formulaires qualité des tâches')]")
	private WebElement ongletFormulairesQualiteTaches;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Autorisation')]")
	private WebElement ongletAutorisation;
	
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Confirmer la fenêtre de sortie')]")
	private WebElement titrePopUpConfirmationAnnulation;
	
	@FindBy(how = How.XPATH, using="//div[contains(@class,'messagebox')]")
	private WebElement textePopUpConfirmationAnnulation;

	@FindBy(how = How.XPATH, using="//td[contains(text(),'OK')]")
	private WebElement boutonOkPopUpConfirmationAnnulation;
	
	@FindBy(how = How.XPATH, using="//div[@class='z-window-modal-cm']/div/table[2]/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr/td[contains(text(),'Annuler')]")
	private WebElement boutonAnnulerPopUpConfirmationAnnulation;
	
	public PageDetailProjet(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void cliquerBoutonSauvegarder() {
		boutonSauvegarder.click();
	}
	
	public void cliquerBoutonAnnuler() {
		boutonAnnulerEdition.click();
	}
	
	public void cliquerOngletWBS() {
		ongletWBS.click();
	}
	
	public void cliquerOngletDonneesGenerales() {
		ongletDonneesGenerales.click();
	}
	
	public void cliquerOngletCout() {
		ongletCout.click();
	}
	
	public void cliquerOngletAvancement() {
		ongletAvancement.click();
	}
	
	public void cliquerOngletLibelle() {
		ongletLibelles.click();
	}
	
	public void cliquerOngletExigenceCriteres() {
		ongletExigenceCriteres.click();
	}
	
	public void cliquerOngletMateriels() {
		ongletMateriels.click();
	}
	
	public void cliquerOngletFormulairesQualiteTaches() {
		ongletFormulairesQualiteTaches.click();
	}
	
	public void cliquerOngletAutorisation() {
		ongletAutorisation.click();
	}
	
	public OngletCalendrier cliquerBoutonOkPopUpConfirmationAnnulation() {
		boutonOkPopUpConfirmationAnnulation.click();
		return PageFactory.initElements(driver, OngletCalendrier.class);
	}
	
	public void cliquerBoutonAnnulationPopUpConfirmationAnnulation() {
		boutonAnnulerPopUpConfirmationAnnulation.click();
	}
	
	public WebElement getFilArianeDetailProjet() {
		return FilArianeDetailProjet;
	}
	
	public WebElement getPageAllocationsAvanceees() {
		return pageAllocationsAvanceees;
	}

	public WebElement getPageTableauDeBord() {
		return pageTableauDeBord;
	}

	public WebElement getBoutonSauvegarder() {
		return boutonSauvegarder;
	}

	public WebElement getBoutonAnnulerEdition() {
		return boutonAnnulerEdition;
	}

	public WebElement getOngletWBS() {
		return ongletWBS;
	}

	public WebElement getOngletDonneesGenerales() {
		return ongletDonneesGenerales;
	}

	public WebElement getOngletCout() {
		return ongletCout;
	}

	public WebElement getOngletAvancement() {
		return ongletAvancement;
	}

	public WebElement getOngletLibelles() {
		return ongletLibelles;
	}

	public WebElement getOngletExigenceCritere() {
		return ongletExigenceCriteres;
	}

	public WebElement getOngletMateriels() {
		return ongletMateriels;
	}

	public WebElement getOngletFormulairesQualiteTaches() {
		return ongletFormulairesQualiteTaches;
	}

	public WebElement getOngletAutorisation() {
		return ongletAutorisation;
	}

	public WebElement getOngletExigenceCriteres() {
		return ongletExigenceCriteres;
	}

	public WebElement getTitrePopUpConfirmationAnnulation() {
		return titrePopUpConfirmationAnnulation;
	}

	public WebElement getTextePopUpConfirmationAnnulation() {
		return textePopUpConfirmationAnnulation;
	}

	public WebElement getBoutonOkPopUpConfirmationAnnulation() {
		return boutonOkPopUpConfirmationAnnulation;
	}

	public WebElement getBoutonAnnulerPopUpConfirmationAnnulation() {
		return boutonAnnulerPopUpConfirmationAnnulation;
	}
	
	
}