package Reports;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.CollectionReportsPage;
import pom.CounterPaymentPage;
import pom.LoginPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class CollectionReports extends BaseDriver {
	JavascriptExecutor js;
	StopWatch stopWatch;
	private WebDriver driver = CMS_browser.getDriver();
	


	@Test(priority = 2)
	public void chequeBounceCollectionReport() throws InterruptedException {
		test = extent.createTest("chequeBounceCollectionReport");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);	
		collectionpage.Select_template(driver);
		Thread.sleep(5000);		
		collectionpage.Select_payment_option_cheque(driver);
		Thread.sleep(10000);
		collectionpage.status_notCleared(driver);
		Thread.sleep(5000);									  
		collectionpage.Select_all_payment_modes(driver);	   
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
		boolean result = false;
		try {
			 result = 		counterpayment.isFileDownloaded("pdffile.pdf", "BounceChequePayment.pdf", 30);
		       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@Test(priority = 3)
	public void chequeClearedCollectionReport() throws InterruptedException {
		test = extent.createTest("chequeClearedCollectionRepor");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);		
		collectionpage.Select_template(driver);
		Thread.sleep(5000);
		collectionpage.Select_payment_option_cheque(driver); 
		Thread.sleep(10000);									  	
		collectionpage.status_cleared(driver);
		Thread.sleep(5000);									  
		collectionpage.Select_all_payment_modes(driver);	  
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
		boolean result = false;
		try {
			 result = 		counterpayment.isFileDownloaded("pdffile.pdf", "ClearChequeReport.pdf", 30);
		       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
		} catch (Exception e) {	
			e.printStackTrace();
		}
        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@Test(priority = 4)
	public void chequeInProcessCollectionReport() throws InterruptedException {
		test = extent.createTest("chequeInProcessCollectionReport");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);		
		collectionpage.Select_template(driver);
		Thread.sleep(5000);
		collectionpage.Select_payment_option_cheque(driver); 
		Thread.sleep(10000);									  	
		collectionpage.status_inprocess(driver);			
		Thread.sleep(5000);									  
		collectionpage.Select_all_payment_modes(driver);	 
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
		boolean result = false;
		try {
			result = 		counterpayment.isFileDownloaded("pdffile.pdf", "chequeInProcessCollectionReport.pdf", 30);
		       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
		} catch (Exception e) {	
			e.printStackTrace();
		}
        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@Test(priority = 5)
	public void DailyCollectionReport() throws InterruptedException {
		test = extent.createTest("Daily Collection Report");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);		
		collectionpage.Select_template(driver);								 	  
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		Thread.sleep(5000);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
//		boolean result = false;
//		try {
//			result = 		counterpayment.isFileDownloaded("pdffile.pdf", "DailyCollectionReport.pdf", 30);
//		       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
//			
//		} catch (Exception e) {	
//			e.printStackTrace();
//		}
//        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@Test(priority = 5)
	public void MonthlyCollectionReport() throws InterruptedException {
		test = extent.createTest("Monthly Collection Report");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);		
		collectionpage.Select_template(driver);								 	  
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		Thread.sleep(5000);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
		boolean result = false;
		try {
			result = 		counterpayment.isFileDownloaded("pdffile.pdf", "MonthlyCollectionReport.pdf", 30);
		       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
		} catch (Exception e) {	
			e.printStackTrace();
		}
        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result,java.lang.reflect.Method m)
	{
		try
		{
			if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "Test Pass " + result.getName());
				
				String a=	TakeScreenshoot.GetScreenshot(driver, m.getName());
				
				test.pass("<b>PASSED SCREENSHOTS</B>", MediaEntityBuilder.createScreenCaptureFromPath(a).build());
				
			}
			else if(result.getStatus() == ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "Test Fail " + result.getName());
				test.log(Status.FAIL, "Test Fail " + result.getThrowable());
				String a=	TakeScreenshoot.GetScreenshot(driver, m.getName());
				
				test.fail("<b>FAILED SCREENSHOTS</B>", MediaEntityBuilder.createScreenCaptureFromPath(a).build());	
			}
			else if(result.getStatus() == ITestResult.SKIP)
			{
				test.log(Status.SKIP, "Test Skip " + result.getName());
			}
		}
		catch(Exception e)
		{//4545
			e.printStackTrace();
		}
		extent.flush();
		
	}
	
	@AfterTest
    public void tearDown() {
 //       if (driver != null) {
 //           driver.quit();
 //      }
        extent.flush();
    }
	
}
