package com.gtm.PractiseSeleniumFramework.utilis;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gtm.PractiseSeleniumFramework.TestSetup;

public class TestScreenshotUtils extends TestSetup{
	public static String screenShotpath;
	public static String screenShotname;
	
	public static void captureScreenshot() throws IOException
	{ screenShotpath= System.getProperty("user.dir")+"/Screenshots";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
	screenShotname=	d.toString().replace(" ", "_").replace(":", "_")+".png";
		
		File destination =new File(screenShotpath + screenShotname);//in extent report image
//	File destination = new File(screenShotpath + File.separator + screenShotname);//this will add screenshot in the folder

		FileUtils.copyFile(source, destination);
	


	
	}
}


