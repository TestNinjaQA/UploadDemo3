package com.inetBanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{

	
	@Test(groups= "smoke")
	public void login() {
		
	driver.get(baseUrl);
	logger.info("opened url");
	
	LoginPage lp= new LoginPage(driver);
	
	lp.setUsername(username);
	lp.setPassword(password);
	lp.clickLogin();
	
	System.out.println("Login button clicked");
	
	String expectedTitle= driver.getTitle();
	System.out.println("Actual title is: "+expectedTitle);
	String actualTitle= "Guru99 Bank Manager HomePage";
	if(expectedTitle.equalsIgnoreCase(actualTitle)) {
		Assert.assertTrue(true);
		//System.out.println("test Passed");
		logger.info("test passed");
	}
	else {
		//System.out.println("test failed");
		Assert.assertTrue(false);
		logger.info("test failed");
	}
	
	}
	
}
