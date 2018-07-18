package org.eql.autom.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

	protected final WebDriver d;

	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement menuAdmin;
	
	public SystemUserPage cliquerMenuAdmin() {
		this.menuAdmin.click();
		return PageFactory.initElements(d, SystemUserPage.class);
	}

	public MenuPage(WebDriver driver) {
		super();
		this.d = driver;
	}

}
