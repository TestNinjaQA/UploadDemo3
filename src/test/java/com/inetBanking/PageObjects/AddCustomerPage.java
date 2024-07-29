package com.inetBanking.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephone() {
		txttelephoneno.sendKeys(randomeNumber());
	}
	
	public void custemail() {
		txtemailid.sendKeys(randomeString());
	}
	
	public void custpwd(String cpwd) {
		txtpassword.sendKeys(cpwd);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public String randomeString() {
		String custemail= RandomStringUtils.randomAlphabetic(8)+ "@gmail.com";
		return custemail;
	}
	
	public String randomeNumber() {
		String telephone=RandomStringUtils.randomNumeric(10);
		return telephone;
	}

}
