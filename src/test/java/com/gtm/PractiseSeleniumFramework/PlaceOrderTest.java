package com.gtm.PractiseSeleniumFramework;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gt.PractiseSeleniumFramework.Page.CartPage;
import com.gt.PractiseSeleniumFramework.Page.LoginPage;
import com.gt.PractiseSeleniumFramework.Page.Productpage;
import com.gtm.PractiseSeleniumFramework.utilis.Data;
import com.gtm.PractiseSeleniumFramework.utilis.ExtentReportManager;

public class PlaceOrderTest extends TestSetup {
	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyPlaceOrder(String UserName, String Password, String ProductPageHeader, String Products) {

		ExtentReportManager.getExtentTest().assignAuthor("Ekta N");
		LoginPage login = new LoginPage();
		Productpage productPage = login.doLoginWithValidCredentials(UserName, Password);
		Assert.assertTrue(productPage.isDisplayed());
		Assert.assertEquals(productPage.getHeaderText(), ProductPageHeader);
		System.out.println("Products from excel" + Products);
		
	
		productPage.addProductsToCart(Products);
		CartPage cart = productPage.clickOnCartLogo();
		Assert.assertTrue(cart.isCartPageHeaderDisplayed());
		Assert.assertEquals(cart.getHeaderText(), "Your Cart");
		Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));
		//Assert.assertTrue(cart.isProductInCart("Sauce Labs Bolt T-Shirt"));

	}

}
