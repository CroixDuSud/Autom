package org.eql.autom.libreplan.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eql.autom.libreplan.pageobject.ressources.MenuOnglet;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Calendrier.EnumerationMoisCalendrier;
import Calendrier.OngletCalendrier;
import Calendrier.PageCreerNouveauProjet;
import Calendrier.PageDetailProjet;
import Calendrier.PageListeDesProjets;
import org.eql.autom.libreplan.pageobject.ressources.PageConnexion;

public class PRO_TA_01_Creer_un_projet_Test {
	
	private WebDriver driver;
	
	
	@Test
	public void PRO_TA_01_Creer_un_projet() {
		
		//Se connecter
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		

		PageConnexion connexion = PageFactory.initElements(driver, PageConnexion.class);	
		OngletCalendrier menuVertical =	connexion.seConnecter("admin", "admin");
		

		
		WebDriverWait waitFilAriane = new WebDriverWait(driver, 10);
		waitFilAriane.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@id,'q3-box')]/tbody/tr/td/img")));
		
		
		//verifier qu'on est bien sur l'onglet Calendrier via le fil d'ariane qui doit afficher :  	DEBUT =>  Calendrier => Planification des projets
		//Le xpath parcourt tous ces items ; l'assertEquals verifier qu'� la fin on obtient bien "Planification des projets"
		assertEquals("Planification des projets", menuVertical.getFilArianePlanificationProjets().getText());
		
			
	    WebDriverWait waitBoutonCreerNouveauProjet = new WebDriverWait(driver, 10);
	    waitBoutonCreerNouveauProjet.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@id,'q3-box')]/tbody/tr/td/img")));

			
	    //cliquer sur le bouton cr�er un nouveau projet
	    menuVertical.cliquerBoutonNouveauProjet();

		
			PageCreerNouveauProjet nouveauProjet = PageFactory.initElements(driver, PageCreerNouveauProjet.class);
	
		WebDriverWait waitPopInCreerNouveauProjet = new WebDriverWait(driver, 10);
		waitPopInCreerNouveauProjet.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Nom')]/../../following-sibling::td/div/input")));
		
		//Effectuer des asserts sur les diff�rents �l�ments de "cr�er un projet"
		
		assertTrue(nouveauProjet.getChampNom().isDisplayed());
		assertTrue(nouveauProjet.getChampModele().isDisplayed());
		assertFalse(nouveauProjet.getChampCode().isEnabled());
		assertTrue(nouveauProjet.getCheckboxGenererCode().isSelected());
		assertTrue(nouveauProjet.getBoutonAccepter().isDisplayed());
		assertTrue(nouveauProjet.getBoutonAnnuler().isDisplayed());

		//R�cup�rer la date du jour au format "dd MMM yyyy"
		SimpleDateFormat formater = null;
	    Date aujourdhui = new Date();
	    formater = new SimpleDateFormat("dd MMM yyyy");
	    String DateDuJour = formater.format(aujourdhui);
	    
		//Verifier que la date dans le champ date de d�but correspond � la date du jour
	//assertEquals(DateDuJour, nouveauProjet.getChampDateDebut().getAttribute("value"));
	
	
		//Renseigner les diff�rents champs
	    
	    String saisirChampNom = "PROJET_TEST1";
	    String saisirCode = "PRJTEST1";
	   

		nouveauProjet.saisirChampNom(saisirChampNom);
		nouveauProjet.cliquerCheckboxGenererCode();
		nouveauProjet.saisirCode(saisirCode);
		nouveauProjet.saisirDateDebut(25, EnumerationMoisCalendrier.juin, 2018);
		nouveauProjet.saisirEcheance(14, EnumerationMoisCalendrier.juil, 2018);
		nouveauProjet.cliquerBoutonAccepter();
		
		/*nouveauProjet.cliquerBoutonDateDebut();
		nouveauProjet.selectionnerDebutDateCalendrier(10);*/
		
		PageDetailProjet detailProjet = PageFactory.initElements(driver, PageDetailProjet.class);
		
		WebDriverWait waitPageDetailProjet = new WebDriverWait(driver, 10);
		waitPageDetailProjet.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'WBS')]")));
		
		
		//Effectuer des assertion sur la page Detail du projet
		assertTrue(detailProjet.getPageAllocationsAvanceees().isDisplayed());
		assertTrue(detailProjet.getPageTableauDeBord().isDisplayed());
		assertTrue(detailProjet.getOngletWBS().isDisplayed());
		assertTrue(detailProjet.getOngletDonneesGenerales().isDisplayed());
		assertTrue(detailProjet.getOngletCout().isDisplayed());
		assertTrue(detailProjet.getOngletAvancement().isDisplayed());
		assertTrue(detailProjet.getOngletLibelles().isDisplayed());
		assertTrue(detailProjet.getOngletExigenceCritere().isDisplayed());
		assertTrue(detailProjet.getOngletMateriels().isDisplayed());
		assertTrue(detailProjet.getOngletFormulairesQualiteTaches().isDisplayed());
		assertTrue(detailProjet.getOngletAutorisation().isDisplayed());

		assertTrue(detailProjet.getBoutonSauvegarder().isDisplayed());
		assertTrue(detailProjet.getBoutonAnnulerEdition().isDisplayed());

		//cliquer sur le bouton annuler et ouvrir une pop-up de confirmation
		detailProjet.cliquerBoutonAnnuler();
		
		//Verifier si le titre de la pop in = "Confirmer la fen�tre de sortie"
		assertEquals("Confirmer la fen�tre de sortie",detailProjet.getTitrePopUpConfirmationAnnulation().getText());
		
		//Verifier si le texte de la pop-in = Les modifications non enregistr�es seront perdues. �tes-vous s�r ?
		assertEquals("Les modifications non enregistr�es seront perdues. �tes-vous s�r ?", detailProjet.getTextePopUpConfirmationAnnulation().getText());
		
		//verifier presence bouton ok et bouton annulation
		assertTrue(detailProjet.getBoutonOkPopUpConfirmationAnnulation().isDisplayed());
		
		//verifier bouton annulation
		assertTrue(detailProjet.getBoutonAnnulerPopUpConfirmationAnnulation().isDisplayed());
		
		//cliquer sur annuler
		detailProjet.cliquerBoutonAnnulationPopUpConfirmationAnnulation();
		
		//V�rifier qu'on est bien sur  	DEBUT=> Calendrier => D�tail du projet	
		assertEquals("D�tail du projet", detailProjet.getFilArianeDetailProjet().getText());
		
		//verifier pr�sence de l'onglet WBS
		assertTrue(detailProjet.getOngletWBS().isDisplayed());
		
		//cliquer sur le bouton annuler et ouvrir une pop-up de confirmation
		detailProjet.cliquerBoutonAnnuler();
				
		//Verifier si le titre de la pop in = "Confirmer la fen�tre de sortie"
		assertEquals("Confirmer la fen�tre de sortie",detailProjet.getTitrePopUpConfirmationAnnulation().getText());
				
		//Verifier si le texte de la pop-in = Les modifications non enregistr�es seront perdues. �tes-vous s�r ?
		assertEquals("Les modifications non enregistr�es seront perdues. �tes-vous s�r ?", detailProjet.getTextePopUpConfirmationAnnulation().getText());
		
		//cliquer sur ok
		detailProjet.cliquerBoutonOkPopUpConfirmationAnnulation();
		
		WebDriverWait waitFilArianPlanificationProjets = new WebDriverWait(driver, 10);
		waitPageDetailProjet.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains(text(),'DEBUT')]/../following-sibling::td[2]/table/tbody/tr/td/table/tbody/tr/td/span[contains(text(),'Calendrier')]/../following-sibling::td/span[contains(text(),'Planification des projets')]")));
		
		//verifier fil d'ariane : planification du projet
		assertEquals("Planification des projets", menuVertical.getFilArianePlanificationProjets().getText());
		
		//V�rifier la cr�ation du projet : Passer la souris sur l'onglet "Calendrier" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Projets".
		MenuOnglet menuOnglets = PageFactory.initElements(driver, MenuOnglet.class);
		
		menuOnglets.cliquerLienProjets();
		
		//Verifier si "Liste des projets" est pr�sent
		assertTrue(menuVertical.getPageListeProjets().isDisplayed());
		
		PageListeDesProjets listeDesProjets = PageFactory.initElements(driver, PageListeDesProjets.class);
		

		WebDriverWait waitNomProjet = new WebDriverWait(driver, 10);
		waitPageDetailProjet.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'" + saisirChampNom + "')]")));
		
		
			try {
				assertEquals(saisirChampNom,listeDesProjets.obtenirTextChampNom(saisirChampNom));
				assertEquals(saisirCode,listeDesProjets.obtenirTextcaseCode(saisirCode));
				assertEquals("25 juil. 2018",listeDesProjets.obtenirTextcaseDateDebut(25, EnumerationMoisCalendrier.juin, 2018));
				assertEquals("14 juil. 2018",listeDesProjets.obtenirTextcaseEcheance(14, EnumerationMoisCalendrier.juil, 2018));
				assertEquals("0 �",listeDesProjets.obtenirTextCaseBudgetTotal("0 �"));
				assertEquals("0", listeDesProjets.obtenirTextCaseHeures("0"));
				assertEquals("PRE-VENTES",listeDesProjets.obtenirTextCaseEtat("PRE-VENTES"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			// TODO Auto-generated catch block

		
		assertTrue(listeDesProjets.getIconeOperationCreerModele().isDisplayed());
		assertTrue(listeDesProjets.getIconeOperationsModifier().isDisplayed());
		assertTrue(listeDesProjets.getIconeOperationSupprimer().isDisplayed());
		assertTrue(listeDesProjets.getIconeOperationVoirPrevision().isDisplayed());
	}
	
}
