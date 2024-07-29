package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.TestCases.BaseClass;

public class Reporting extends TestListenerAdapter {

	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest extest;
	//public static WebDriver driver;

	@org.testng.annotations.BeforeClass
	public void onStart(ITestContext testContext) {

		
		  String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
		  Date()); String reportname = "TestReport" + timestamp + ".html";
		  sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
		  "/test-output/" + reportname);
		 
		//sparkReporter= new ExtentSparkReporter("target/Spark.html");
		
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Hostname", "localHost");
		extent.setSystemInfo("Envrionment", "QA");
		extent.setSystemInfo("user", "Abhishek");

		sparkReporter.config().setDocumentTitle("Inetbanking My project");
		sparkReporter.config().setReportName("Functional Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		// htmlReporter.config().setTestChartViewLocation(ChartLocation.TOP);

	}

	
	public void onTestSuccess(ITestResult tr) {

		extest = extent.createTest(tr.getName());
		extest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}

	
	public void onTestFailure(ITestResult tr) {
		extest = extent.createTest(tr.getName());
		extest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		// Define screenshot name and path
	    String screenshotName = tr.getName();
	    String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + screenshotName;

	    // Ensure the Screenshots directory exists
	    File screenshotDir = new File(System.getProperty("user.dir") + File.separator + "Screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }

	    try {
	        // Capture screenshot
	        CaptureScreenshot.captureScreenshot(BaseClass.driver, screenshotName);

	        // Attach screenshot to the report
	        extest.fail("Screenshot is below:" + extest.addScreenCaptureFromPath(screenshotPath));
	    } catch (Exception e) {
	        e.printStackTrace();
	        extest.fail("Failed to capture or attach screenshot: " + e.getMessage());
	    }
	}

	
	public void onTestSkipped(ITestResult tr) {
		extest = extent.createTest(tr.getName());
		extest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	@AfterClass
	public void onFinish(ITestContext testContext) {
		
				extent.flush();
				
	}
	
}
