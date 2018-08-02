package org.eql.autom.libreplan.pageobject.ressources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMachines extends OngletRessources {
	
	 // GRE_02 - Créer une machine
	
	// Liste Machines - Step 1 à 2
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('4-cap') +1) = '4-cap']")
	protected WebElement identificationPageMachine;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('s5-cave') +1) = 's5-cave']")
	protected WebElement colonneNom;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('t5-cave') +1) = 't5-cave']")
	protected WebElement colonneDesc;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('u5-cave') +1) = 'u5-cave']")
	protected WebElement colonneCode;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('v5-cave') +1) = 'v5-cave']")
	protected WebElement colonneEnFile;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('w5-cave') +1) = 'w5-cave']")
	protected WebElement colonneOperations;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('q4-real') +1) = 'q4-real']")
	protected WebElement champFiltrePar;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('d5') +1) = 'd5']")
	protected WebElement champDetailsPerso;
	
	@FindBy(xpath="//td[substring(@id, string-length(@id) - string-length('f5-cnt') +1) = 'f5-cnt']")
	protected WebElement boutonPlusOptions;
	
	@FindBy(xpath="//button[substring(@id, string-length(@id) - string-length('n5-btn') +1) = 'n5-btn']")
	protected WebElement boutonFiltre;
	
	@FindBy(xpath="//button[substring(@id, string-length(@id) - string-length('x5-btn') +1) = 'x5-btn']")
	protected WebElement boutonCreer;
	
	// Creer Machine Formulaire - Step 3 à 6
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('16-hm') +1) = '16-hm']")
	protected WebElement ongletDonneesMachine;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('g6') +1) = 'g6']")
	protected WebElement codeMachine;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('h6-real') +1) = 'h6-real']")
	protected WebElement caseGenererCode;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('k6') +1) = 'k6']")
	protected WebElement nomMachine;
	
	@FindBy(xpath="//input[substring(@id, string-length(@id) - string-length('n6') +1) = 'n6']")
	protected WebElement descriptionMachine;
	
	@FindBy(xpath="//select[substring(@id, string-length(@id) - string-length('s6') +1) = 's6']")
	protected WebElement listeTypeMachine;
	
	@FindBy(xpath="//table[substring(@id, string-length(@id) - string-length('jd-box') +1) = 'jd-box']")
	protected WebElement boutonEnregistrer;
	
	@FindBy(xpath="//table[substring(@id, string-length(@id) - string-length('kd-box') +1) = 'kd-box']")
	protected WebElement boutonSauveretContinuer;
	
	@FindBy(xpath="//table[substring(@id, string-length(@id) - string-length('ld-box') +1) = 'ld-box']")
	protected WebElement boutonAnnuler;
	
	@FindBy(xpath="//div[substring(@id, string-length(@id) - string-length('k7') +1) = 'k7']")
	protected WebElement messageMachineEnregistree;
	
	@FindBy(xpath="//img[@src='/libreplan/common/img/ico_ok.png']")
	protected WebElement modifierMachineCreee;
	
	
	//apres click sur bouton annuler
	@FindBy()
	protected WebElement titreMachineModifiee;
	
	@FindBy()
	protected WebElement machineCreee;
	//

	public PageMachines (WebDriver driver) {

		super(driver);
	}
	// Liste Machines - Step 1 à 2
	
	public void creerMachine() {
		this.boutonCreer.click();
	}
	
	public String getIdentificationPageMachine() {
		return this.identificationPageMachine.getText();
	}
	
	public String getColonneNom() {
		return this.colonneNom.getText();
	}
	
	public String getColonneDesc() {
		return this.colonneDesc.getText();
	}
	
	public String getColonneCode() {
		return this.colonneCode.getText();
	}
	
	public String getColonneEnFile() {
		return this.colonneEnFile.getText();
	}
	
	public String getColonneOperations() {
		return this.colonneOperations.getText();
	}
	
	public String getChampFiltrePar() {
		return this.champFiltrePar.getText();
	}
	
	public String getChampDetailsPerso() {
		return this.champDetailsPerso.getText();
	}
	
	public String getBoutonPlusOptions() {
		return this.boutonPlusOptions.getText();
	}
	
	public String getBoutonFiltre() {
		return this.boutonFiltre.getText();
	}
	
	public String getBoutonCreer() {
		return this.boutonCreer.getText();
	}
	
	// Creer Machine Formulaire - Step 3 à 6
	
	public String getOngletDonneesMachine() {
		return this.ongletDonneesMachine.getText();
	}
	
	public String getCodeMachine() {
		return this.codeMachine.getText();
	}
	
	public String getCaseGenererCode() {
		return this.caseGenererCode.getText();
	}
	
	public String getNomMachine() {
		return this.nomMachine.getText();
	}
	
	public String getDescriptionMachine() {
		return this.descriptionMachine.getText();
	}
	
	public String getValeurParDefautListeTypeMachine() {
		return this.listeTypeMachine.getAttribute("selected");
	}
	
	public String getBoutonEnregistrer() {
		return this.boutonEnregistrer.getText();
	}
	
	public String getBoutonSauveretContinuer() {
		return this.boutonSauveretContinuer.getText();
	}
	
	public String getBoutonAnnuler() {
		return this.boutonAnnuler.getText();
	}
	
	//renseigner les champs - Step 5
	
	public void cliquerCaseGenererCode() {
		caseGenererCode.click();
	}
	
	public void saisirCodeMachine(String code) {
		this.codeMachine.sendKeys(code);
	}
	
	public void saisirNomMachine(String nom) {
		this.nomMachine.sendKeys(nom);
	}
	
	public void saisirDescriptionMachine(String description) {
		this.descriptionMachine.sendKeys(description);
	}
	 public void cliquerBoutonSauveretContinuer() {
		 boutonSauveretContinuer.click();
	 }
	 
	 public String getMessageMachineEnregistree() {
		 return this.messageMachineEnregistree.getText();
	 }
	 
	 public String getModifierMachineCreee() {
			return this.modifierMachineCreee.getText();
	 }	
	//retour page gestion des machines  - Step 6
	 
	// public void cliquerBoutonAnnuler() {
	//	 boutonAnnuler.click();
	// }
	 
	// public int trouverLigneDansColonne(String nomColonne, int numColonne) {
			
		//	List<WebElement> lignes = this.driver.findElements(By.xpath()); //xpath a trouver
		//	int ligneTrouvee = -1; 
		//	int ligneCourante = 0;
			
		//	for(WebElement ligne : lignes) {
		//		List<WebElement> cases = ligne.findElements(By.xpath("td"));
		//		if(nomColonne.equals(cases.get(numColonne).getText())) {
		//			ligneTrouvee = ligneCourante;
		//			return ligneTrouvee;
		//		}
				
		//		ligneCourante++;
		//	}
		
		//	return ligneTrouvee;
	  //  }
	    
	   // public String getMachineCreee(String nomColonne, int numColonne) throws InvalidTableRowNumberException {
	    //    int numeroLigne = this.trouverLigneDansColonne(nomColonne, numColonne);
	//		if(numeroLigne != -1) {
		//		WebElement lien = this.driver.findElement(By.xpath("["+(numeroLigne+1)+"]/td"));
			//	return lien.getText();
	    //    }
	//        throw new InvalidSelectorException("Ligne trouvée = " + numeroLigne);
	 //   }
}
