package com.inetBanking.TestCases;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.Xls_Reader;

public class TC_LoginDDT_002 extends BaseClass {

	static Xls_Reader reader;
	
	@Test(dataProvider = "getDataFromExcel", groups= "smoke")
	public void loginDDT(String username, String password) throws InterruptedException {
		driver.get(baseUrl);
		LoginPage lp1 = new LoginPage(driver);
		
		lp1.setUsername(username);
		lp1.setPassword(password);
		lp1.clickLogin();
		
		Thread.sleep(5000);
		
		
		  if(isAlertPresent()==true) { 
		driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
		  logger.warn("Login has failed"); 
		  } 
		  
		  else { 
			  
			Assert.assertTrue(true);		  
		  logger.info("Login has passedd"); 
		  lp1.clickLogout(); 
		  Thread.sleep(5000);
		  driver.switchTo().alert().accept(); 
		  driver.switchTo().defaultContent(); 
		  }
		 
	}

	@DataProvider(name = "getDataFromExcel")
	public static Object[][] getDataFromExcel() {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		reader = new Xls_Reader(
				"C:\\Users\\Abhishek_Rana\\eclipse-workspace\\inetBankingV3\\src\\test\\java\\com\\inetBanking\\TestData\\LoginData.xlsx");

		for (int rownum = 2; rownum <= reader.getRowCount("Sheet1"); rownum++) {

			String username = reader.getCellData("Sheet1", "username", rownum);

			String password = reader.getCellData("Sheet1", "password", rownum);

			Object[] ob = new Object[] { username, password };
			myData.add(ob);

		}
		return myData.toArray(new Object[myData.size()][]);

	}

	

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
	
	

}
