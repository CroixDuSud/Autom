package org.eql.autom.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

	protected final WebDriver d;

	//1er niveau
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement menuAdmin;

	//2e niveau
	@FindBy(id="menu_admin_UserManagement")
	private WebElement menuUserManagement;

	//3e niveau
	@FindBy(id="menu_admin_viewSystemUsers")
	private WebElement menuViewSystemUsers;	
	
	public SystemUserPage cliquerMenuAdmin() {
		this.menuAdmin.click();
		return PageFactory.initElements(d, SystemUserPage.class);
	}
	
	public SystemUserPage cliquerMenuViewSystemUsers() {
		Actions actions = new Actions(d);
		actions.moveToElement(menuAdmin)
			.moveToElement(menuUserManagement).build().perform();
		
		WebDriverWait wait = new WebDriverWait(d, 10);
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(menuViewSystemUsers), 
				ExpectedConditions.elementToBeClickable(menuViewSystemUsers)));
		
		menuViewSystemUsers.click();
		return PageFactory.initElements(d, SystemUserPage.class);
	}

	public MenuPage(WebDriver driver) {
		super();
		this.d = driver;
	}

}
