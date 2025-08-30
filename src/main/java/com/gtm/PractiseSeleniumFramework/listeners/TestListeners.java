package com.gtm.PractiseSeleniumFramework.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gtm.PractiseSeleniumFramework.TestSetup;
import com.gtm.PractiseSeleniumFramework.utilis.ExtentReportManager;
import com.gtm.PractiseSeleniumFramework.utilis.TestScreenshotUtils;

public class TestListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("Test case-" + result.getName()+ " Execution Started !");
		ExtentReportManager.createExtentTest(result.getName());
		//String logMessage="Execution of "+ result.getName()+ " Started ";
		String logMessage="<b>"+"<i>"+"Execution of "+ result.getName()+ " Started "+"</i>"+"</b>";
		Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.GREY);
		ExtentReportManager.getExtentTest().info(m);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	String logMessage="<b>"+"<i>"+"This test case got passed "+"</i>"+"</b>";
		Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.GREEN);
		ExtentReportManager.getExtentTest().info(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    
		try {
			TestScreenshotUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
ExtentReportManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromPath(TestScreenshotUtils.screenShotpath+TestScreenshotUtils.screenShotname).build());
		

	/*	String screenshotPath = null;

		    try {
		        // Capture screenshot and get relative path
		    	screenshotPath = TestScreenshotUtils.captureScreenshot();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    // Log screenshot with failure in report
		    ExtentReportManager.getExtentTest().fail(
		        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
		    );*/
		String logMessage="<b>"+"<i>"+"This test case got failed "+"</i>"+"</b>";
		Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.RED);
		ExtentReportManager.getExtentTest().info(m);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logMessage="<b>"+"<i>"+"This test case got skipped "+"</i>"+"</b>";
		Markup m = MarkupHelper.createLabel(logMessage,ExtentColor.ORANGE);
		ExtentReportManager.getExtentTest().info(m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.getExtent().flush();
		
	}

}
