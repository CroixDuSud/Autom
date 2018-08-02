package Calendrier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagePlanificationDesProjets {
	
	@FindBy(how = How.XPATH, using ="span[contains(text(),'Planification des projets')]") ////input[contains(@name,"username")], "//input[contains(@name,'username')]"
	private WebElement filArianePlanificationProjets;
	
	

}
