package com.gt.PractiseSeleniumFramework.Page;

import java.util.List;

import org.openqa.selenium.By;

import com.gtm.PractiseSeleniumFramework.utilis.ElementUtils;

public class Productpage {
	
	private By productPageHeader = By.className("product_label");
	//private By addproductToCart = By.xpath("(//button[text()='ADD TO CART'])[1]");
	private By cartlogo = By.xpath("//*[@data-icon='shopping-cart']");
	private String AddToCartXpath ="//div[text()='ProductName']//ancestor::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/button";
	
	public String getHeaderText()
	{
		return ElementUtils.getElementText(productPageHeader);
	}
	public boolean isDisplayed()
	{
		return ElementUtils.getElement(productPageHeader).isDisplayed();
	}
	public void addProductToCart(String productName)
	{
		By addToCart=By.xpath(AddToCartXpath.replace("ProductName", productName));
		ElementUtils.click(addToCart);
	}
public void addProductsToCart(List<String> products) {
		
		for(int i=0;i<products.size();i++)
		{
			addProductToCart(products.get(i));
		}
}
public void addProductsToCart(String products) {
	
	String[] listofproducts=products.split(",");
	for(int i=0;i<listofproducts.length;i++)
	{
		addProductToCart(listofproducts[i]);
	}
}
	
	public CartPage clickOnCartLogo()
	{
		ElementUtils.click(cartlogo);
		return new CartPage();
	}

}
