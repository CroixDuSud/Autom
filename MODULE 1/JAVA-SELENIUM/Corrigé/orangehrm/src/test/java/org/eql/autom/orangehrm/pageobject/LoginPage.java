package org.eql.autom.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected final WebDriver d;
	
	@FindBy(how=How.ID, using="txtUsername")
	private WebElement champLogin;
	
	@FindBy(id="txtPassword")
	private WebElement champPassword;
	
	@FindBy(id="btnLogin")
	private WebElement boutonConnection;
	
	public LoginPage(WebDriver driver) {
		super();
		this.d = driver;
	}
	
	public HomePage seConnecter(String login, String password) {
		this.champLogin.sendKeys(login);
		this.champPassword.sendKeys(password);
		this.boutonConnection.click();
		return PageFactory.initElements(d, HomePage.class);
	}
}
