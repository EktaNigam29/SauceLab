package com.gt.PractiseSeleniumFramework.Page;

import org.openqa.selenium.By;

import com.gtm.PractiseSeleniumFramework.TestSetup;
import com.gtm.PractiseSeleniumFramework.utilis.ElementUtils;



public class LoginPage extends TestSetup{
	
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By loginErrorMessage = By.xpath("//h3[@data-test='error']");
	
	public Productpage doLoginWithValidCredentials(String username, String pwd)
	{
		//ElementUtils.type(userName, username);
		ElementUtils.type(userName, username,"Username");
		
		ElementUtils.type(password, pwd);
		ElementUtils.click(loginButton);
		return new Productpage();
		
	}
	public LoginPage doLoginWithInValidCredentials(String username, String pwd)
	{ElementUtils.type(userName, username);
	ElementUtils.type(password, pwd);
	ElementUtils.click(loginButton);
	return this;
		
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String getLoginErrorMessage() {
		
		return ElementUtils.getElementText(loginErrorMessage);

	}
	public boolean isLoginErrorMessageDisplayed()
	{
		return ElementUtils.getElement(loginErrorMessage).isDisplayed();
	}
	
}
