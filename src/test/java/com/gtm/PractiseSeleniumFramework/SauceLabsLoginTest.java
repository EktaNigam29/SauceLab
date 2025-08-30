package com.gtm.PractiseSeleniumFramework;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gt.PractiseSeleniumFramework.Page.CartPage;
import com.gt.PractiseSeleniumFramework.Page.LoginPage;
import com.gt.PractiseSeleniumFramework.Page.Productpage;
import com.gtm.PractiseSeleniumFramework.utilis.Data;
import com.gtm.PractiseSeleniumFramework.utilis.ExtentReportManager;

public class SauceLabsLoginTest extends TestSetup{
	
	
	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyLoginValidCredentials (String UserName, String Password) throws InterruptedException
	{

ExtentReportManager.getExtentTest().assignAuthor("GTM");
		LoginPage login=new LoginPage();
	
		Productpage product=login.doLoginWithValidCredentials(UserName, Password);
		Assert.assertTrue(product.isDisplayed());
		Assert.assertEquals(product.getHeaderText(), "Products");
		
		
		//Assert.assertEquals(product.getHeaderText(), "Productssss");
		
		
		//product.addProductToCart("Sauce Labs Backpack");
		/*List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt");
		product.addProductsToCart(products);
		CartPage	cart=product.clickOnCartLogo();
		Assert.assertTrue(cart.isCartPageHeaderDisplayed());
		Assert.assertEquals(cart.getHeaderText(), "Your Cart");
		Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));
		Assert.assertTrue(cart.isProductInCart("Sauce Labs Bolt T-Shirt"));*/
}
	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyLoginWithInValidCredentials (String UserName, String Password) throws InterruptedException
	{

ExtentReportManager.getExtentTest().assignAuthor("GTM");
		LoginPage login=new LoginPage();
	
		login =login.doLoginWithInValidCredentials(UserName, Password);
		Assert.assertTrue(login.isLoginErrorMessageDisplayed());
		
	
}
}