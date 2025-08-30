package com.gtm.PractiseSeleniumFramework;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.gtm.PractiseSeleniumFramework.utilis.DriverManager;
import com.gtm.PractiseSeleniumFramework.utilis.ExcelReader;
import com.gtm.PractiseSeleniumFramework.utilis.ExtentReportManager;
import com.gtm.PractiseSeleniumFramework.utilis.PropertyManger;

public class TestSetup {
public static Properties prop;
public static WebDriver driver;
public static ExtentReports extent;
public static ExcelReader excel = new ExcelReader("./src/test/java/excel/testCaseData.xlsx");
@BeforeSuite
public synchronized  void testSetup()
{
	prop=PropertyManger.initilizePropertyManager();
	extent=ExtentReportManager.initExtentReport();
	
}

@BeforeMethod
public  void  beforeMethod()
{
	driver=DriverManager.createDriver(prop.getProperty("browser"));
	driver.get(prop.getProperty("testURL"));
}

@AfterMethod
public void teardown()
{
	DriverManager.destoryDriver(driver);
}
}
