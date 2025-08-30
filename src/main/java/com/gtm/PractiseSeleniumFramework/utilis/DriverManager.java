package com.gtm.PractiseSeleniumFramework.utilis;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
//private static WebDriver driver;
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}
	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver); 
	}
	public  synchronized static WebDriver createDriver(String browserName)
	
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{DriverManager.driver.set(new ChromeDriver());
			//driver=new ChromeDriver();
			maximizebrowser();
			applyImplicitlyWait();
		}else if (browserName.equalsIgnoreCase("firefox"))
		
		{DriverManager.driver.set(new FirefoxDriver());
			//driver=new FirefoxDriver();
			maximizebrowser();
			applyImplicitlyWait();
		}else if (browserName.equalsIgnoreCase("edge"))
		{DriverManager.driver.set(new EdgeDriver());
			//driver=new EdgeDriver();
			maximizebrowser();
			applyImplicitlyWait();
		}return DriverManager.getDriver();
	}
	public static void maximizebrowser()
	{
		DriverManager.getDriver().manage().window().maximize();
	}
	public static void applyImplicitlyWait()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_TIME));
	}
	public static void destoryDriver(WebDriver driver )
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
