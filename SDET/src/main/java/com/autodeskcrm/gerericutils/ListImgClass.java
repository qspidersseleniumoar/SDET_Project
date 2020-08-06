package com.autodeskcrm.gerericutils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import example.ScreenShotTest;

public class ListImgClass implements ITestListener{
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		System.out.println("=======================>"+testName);
		
		Date d = new Date();
		String currentDate = d.toString().replace(" ", "_").replace(":", "_");
		
          System.out.println("==============Faill =====================>");
           EventFiringWebDriver eDrirver = new EventFiringWebDriver(ScreenShotTest.driver);
           File srcfile = eDrirver.getScreenshotAs(OutputType.FILE);
           try {
			FileUtils.copyFile(srcfile, new File("./screenShot/"+testName+"_"+currentDate+".png"));
		} catch (IOException e) {
		
		}
	}


	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
	
	}

}
