package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.inetBanking.TestCases.BaseClass;



public class CaptureScreenshot {
	
	
	public static void captureScreenshot( WebDriver driver, String screenshotName) {
		
		
		  if (!(driver instanceof TakesScreenshot)) { throw new
		  IllegalArgumentException("Driver does not support TakesScreenshot"); }
		 
		  
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File destination = new File(System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + screenshotName + ".png");
	  
	    try {
	    	
	        FileHandler.copy(source, destination);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	   
	}
}
