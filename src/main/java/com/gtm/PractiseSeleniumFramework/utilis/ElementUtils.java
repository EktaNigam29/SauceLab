package com.gtm.PractiseSeleniumFramework.utilis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gtm.PractiseSeleniumFramework.TestSetup;

public class ElementUtils extends TestSetup{
public   synchronized  static void type(By locator, String value)
{clear(locator);
//WaitMachine.waitForElementToPresent(locator);
	driver.findElement(locator).sendKeys(value);
}
public synchronized static void type(By locator, String value,String fieldName)
{clear(locator);
//WaitMachine.waitForElementToPresent(locator);
	driver.findElement(locator).sendKeys(value);
	ExtentReportManager.getExtentTest().info("Entered " +"<b>"+ value +"</b>"+" in "+ fieldName+ " field ");
}
public  synchronized static void click(By locator)
{//WaitMachine.waitForElementToClickable(locator);
	driver.findElement(locator).click();
}

public synchronized static void clear(By locator)
{
	driver.findElement(locator).clear();
}
public synchronized static String getElementText(By locator)
{
	return driver.findElement(locator).getText();
}
public synchronized static WebElement getElement(By locator)
{
return 	driver.findElement(locator);
}
}
