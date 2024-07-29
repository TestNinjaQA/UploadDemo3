package com.inetBanking.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name= "password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath= "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;

	public void setLdriver(WebDriver ldriver) {
		this.ldriver = ldriver;
	}

	public void setUsername(String username) {
		txtUserName.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	

}
