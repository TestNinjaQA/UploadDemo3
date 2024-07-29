package com.inetBanking.TestCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.CaptureScreenshot;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test(groups= "regression")
	public void addCustomer() throws InterruptedException {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("Logged in successfully");

		Thread.sleep(5000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
//		addcust.clickAddNewCustomer();
//Thread.sleep(3000); 

		Thread.sleep(3000);

		addcust.custName("AbhishekRana");
		addcust.custGender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);

		addcust.custaddress("Friends enclave");
		addcust.custcity("Patiala");
		addcust.custState("Punjab");
		addcust.custpinno("147002");
		addcust.custtelephone();
		addcust.custemail();
		addcust.custpwd("hello");
		addcust.clickSubmit();
		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed");

		} else {
			logger.info("test case failed");
			CaptureScreenshot.captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);

		}

	}

}
