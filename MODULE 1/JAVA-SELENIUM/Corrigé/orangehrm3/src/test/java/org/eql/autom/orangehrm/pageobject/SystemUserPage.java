package org.eql.autom.orangehrm.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SystemUserPage extends MenuPage {

	@FindBy(id="searchSystemUser_userType")
	private WebElement menuDeroulantUserRole;
	
	@FindBy(id="searchBtn")
	private WebElement boutonRecherche;
	
	@FindBy(xpath="(//table[@id='resultTable']//td)[2]")
	private WebElement tableauRechercheUtilisateurTrouve;
	
	@FindBy(xpath="//table[@id='resultTable']//td")
	private WebElement tableauRechercheMessagePasDeResultat;
	
	public SystemUserPage(WebDriver driver) {
		super(driver);
	}

	public void rechercheParRole(String role) {
		
		Select menu = new Select(menuDeroulantUserRole);
		menu.selectByVisibleText(role);
		boutonRecherche.click();
	}
	
	public String getTableauRechercheUtilisateurTrouve() {
		return this.tableauRechercheUtilisateurTrouve.getText();
	}
	
	public String getTableauRechercheMessagePasDeResultat() {
		return this.tableauRechercheMessagePasDeResultat.getText();
	}
	
	public int trouverLigneContenantUtilisateurParNom(String nom) {
		
		int numeroDeColonne = this.numeroDeColonneParEntete("Employee Name");
		List<WebElement> lignes = this.d.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int ligneTrouvee = -1; 
		int ligneCourante = 0;
		
		for(WebElement ligne : lignes) {
			WebElement quatriemeCase = ligne.findElement(By.xpath("td["+(numeroDeColonne+1)+"]"));
			if(nom.equals(quatriemeCase.getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
	
		return ligneTrouvee;
	}
	
	public int numeroDeColonneParEntete(String header) {
	
		int ligneTrouvee = -1; 
		int ligneCourante = 0;
		
		List<WebElement> entetes = this.d.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th"));
		for(WebElement entete : entetes) {
			if(header.equals(entete.getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
		
		return ligneTrouvee;
	}
	
	public int trouverLigneContenantUtilisateurParNomV2(String nom) {
		
		List<WebElement> lignes = this.d.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int ligneTrouvee = -1; 
		int ligneCourante = 0;
		
		for(WebElement ligne : lignes) {
			List<WebElement> cases = ligne.findElements(By.xpath("td"));
			if(nom.equals(cases.get(3).getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
	
		return ligneTrouvee;
	}
	
	public PageDetailUtilisateur cliquerSurLienDetailsDeLUtilisateur(String nom) throws InvalidTableRowNumberException {
		
		int numeroLigne = this.trouverLigneContenantUtilisateurParNom(nom);
		if(numeroLigne != -1) {
			WebElement lien = this.d.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+(numeroLigne+1)+"]/td[2]/a"));
			lien.click();
			return PageFactory.initElements(d, PageDetailUtilisateur.class);
		}
		
		throw new InvalidTableRowNumberException("Ligne trouvée = "+numeroLigne);
	}
}
