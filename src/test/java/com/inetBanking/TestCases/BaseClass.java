package com.inetBanking.TestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static ReadConfig readConfig;
	public static WebDriver driver;

	public String baseUrl;
	public String username;
	public String password;
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {

			try {
				WebDriverManager.edgedriver().setup(); // Configure WebDriverManager for Edge
				driver = new EdgeDriver();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(
						"Failed to set up EdgeDriver. Ensure network connectivity and EdgeDriver version compatibility.");
			}

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		readConfig = new ReadConfig();
		baseUrl = readConfig.getBaseUrl();
		username = readConfig.getUsername();
		password = readConfig.getPassword();

		//driver.get(baseUrl);
		driver.manage().window().maximize();

		logger = Logger.getLogger("inetBankingV3");
		PropertyConfigurator.configure("Log4j.properties");

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
