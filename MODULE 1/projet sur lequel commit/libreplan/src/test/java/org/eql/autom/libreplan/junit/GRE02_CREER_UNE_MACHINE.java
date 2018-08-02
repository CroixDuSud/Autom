package org.eql.autom.libreplan.junit;

import static org.junit.Assert.assertEquals;

import org.eql.autom.libreplan.pageobject.ressources.PageConnexion;
import org.eql.autom.libreplan.pageobject.ressources.InvalidTableRowNumberException;
import org.eql.autom.libreplan.pageobject.ressources.MenuOnglet;
import org.eql.autom.libreplan.pageobject.ressources.OngletCalendrier;
import org.eql.autom.libreplan.pageobject.ressources.OngletRessources;
import org.eql.autom.libreplan.pageobject.ressources.PageConnexion;
import org.eql.autom.libreplan.pageobject.ressources.PageMachines;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GRE02_CREER_UNE_MACHINE {

	WebDriver driver;

    @Before
    public void demarrerLibreplan()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\WORKSPACEJBU\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
    }

    @After
    public void fermerLibreplan()
    {
        driver.quit();
    }

    @Test
    public void gererMachines() throws InvalidTableRowNumberException
    {
    	//step 1
        PageConnexion pageConnexion = PageFactory.initElements(driver, PageConnexion.class);
		pageConnexion.seConnecter("admin", "admin");
        assertEquals("affichage page calendrier (index)", "http://localhost:8180/libreplan/planner/index.zul", driver.getCurrentUrl());

        OngletRessources ongletRessources = PageFactory.initElements(driver, OngletRessources.class);
        PageMachines pageMachines = ongletRessources.cliquerMachines();
        //step 2 vérification Page Liste Machines
        assertEquals("affichage page liste des machines", "http://localhost:8180/libreplan/resources/machine/machines.zul", driver.getCurrentUrl());
        assertEquals("Identification de la page", "Machines Liste", pageMachines.getIdentificationPageMachine());
        assertEquals("Nom", pageMachines.getColonneNom());
        assertEquals("Description", pageMachines.getColonneDesc());
        assertEquals("Code", pageMachines.getColonneCode());
        assertEquals("En file", pageMachines.getColonneEnFile());
        assertEquals("Opérations", pageMachines.getColonneOperations());
        assertEquals("", pageMachines.getChampFiltrePar());
        assertEquals("", pageMachines.getChampDetailsPerso());
        assertEquals("Plus d'options", pageMachines.getBoutonPlusOptions());
        assertEquals("", pageMachines.getBoutonFiltre());
        assertEquals("", pageMachines.getBoutonCreer());

        // Créer Machine : Vérification step 3 à 4

        pageMachines.creerMachine();
        assertEquals("identification de la page", "Machines Liste", pageMachines.getIdentificationPageMachine());
        assertEquals("", pageMachines.getOngletDonneesMachine());
        assertEquals("", pageMachines.getCodeMachine());
        assertEquals("", pageMachines.getCaseGenererCode());
        assertEquals("", pageMachines.getNomMachine());
        assertEquals("", pageMachines.getDescriptionMachine());
        equals(pageMachines.getValeurParDefautListeTypeMachine());
        assertEquals("Enregistrer", pageMachines.getBoutonEnregistrer());
        assertEquals("Sauver et continuer", pageMachines.getBoutonSauveretContinuer());
        assertEquals("Annuler", pageMachines.getBoutonAnnuler());

        // Créer Machine : saisie step 5
        String code = "MACHINETEST1";
        String nom = "MACHINETEST1";
        String description = "MACHINETEST1";
        
        
        pageMachines.cliquerCaseGenererCode();
        pageMachines.saisirCodeMachine(code);
        pageMachines.saisirNomMachine(nom);
        pageMachines.saisirDescriptionMachine(description);
        pageMachines.cliquerBoutonSauveretContinuer();
        
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[substring(@id, string-length(@id) - string-length('k7') +1) = 'k7']")));
        //vérification machine créée
        assertEquals("Machine \"MACHINETEST1\" enregistré", pageMachines.getMessageMachineEnregistree());
        assertEquals("", pageMachines.getModifierMachineCreee());
    
    
    //annuler et vérifier
    
   // pageMachines.cliquerBoutonAnnuler();
  //  assertEquals("Identification de la page", "Machines Liste", pageMachines.getIdentificationPageMachine());
    
    }
}
