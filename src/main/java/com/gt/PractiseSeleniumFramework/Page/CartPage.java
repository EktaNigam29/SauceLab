package com.gt.PractiseSeleniumFramework.Page;

import org.openqa.selenium.By;

import com.gtm.PractiseSeleniumFramework.TestSetup;
import com.gtm.PractiseSeleniumFramework.utilis.ElementUtils;

public class CartPage extends TestSetup{
	
	private By CartPageHeader=By.className("subheader");
	//private  String productXpath = "//div[@class='inventory_item_name' and text()='" + productName + "']";
	private String productXpath="//div[text()='ProductName']";
	
	
	public boolean isCartPageHeaderDisplayed()
	{
		return  ElementUtils.getElement(CartPageHeader).isDisplayed();
	}
	public String getHeaderText()
	{
		return ElementUtils.getElementText(CartPageHeader);
	}

	public boolean isProductInCart(String productName)
	{
		By checkitem =By.xpath(productXpath.replace("ProductName", productName));
	return	ElementUtils.getElement(checkitem).isDisplayed();
	}
}
