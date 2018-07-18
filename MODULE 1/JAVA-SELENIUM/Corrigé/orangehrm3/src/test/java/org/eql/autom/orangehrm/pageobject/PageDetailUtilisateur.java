package org.eql.autom.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDetailUtilisateur extends MenuPage {

	@FindBy(id="systemUser_userType")
	private WebElement selectUserRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement inputEmployeeName;
	
	@FindBy(id="systemUser_userName")
	private WebElement inputUserName;
	
	@FindBy(id="systemUser_status")
	private WebElement selectStatus;
	
	public PageDetailUtilisateur(WebDriver driver) {
		super(driver);
	}

	public boolean formulaireInactif() {
		
		return !this.selectUserRole.isEnabled()
				&& !this.inputEmployeeName.isEnabled()
				&& !this.inputUserName.isEnabled()
				&& !this.selectStatus.isEnabled();
	}
}
