package Payments;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class Typewise_Payment extends BaseDriver{
	JavascriptExecutor js;
	StopWatch stopWatch;
	String Taxtotal_fromDataentry;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		Delete_Files Delete_files = new Delete_Files(driver);
		System.out.println(System.getProperty("user.dir"));
		Delete_files.Delete_files("\\PdfReports\\");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
		driver = CMS_browser.openBrowser(url);
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		driver.get(url);
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		
		loginpage.Enter_password(password);
		Thread.sleep(10000);
		Scanner scanner = new Scanner(System.in);
     System.out.print("Can We start Automation: ");
		
		try
		{
			loginpage.click_logout(driver);
			loginpage.Enter_user_name(userid, driver);
			loginpage.Enter_password(password);
			loginpage.Click_login_btn(driver);	
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	@Test(priority = 2 )
	public void CashPayment() throws Exception
	{	
		test = extent.createTest("cash Payment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node1);
		offlinepaymentpage.Select_sector_no(driver, sector1);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo1);
		/////
		
		test.log(Status.INFO, "Property for Cash Payment : "+node1+"-"+sector1+"-"+PropertyNo1);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		counterpayment.Select_Finalcheckbox(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node1)) {
			 try {
			        counterpayment.Select_APartcheckbox(driver);
			        
			        try {
			            counterpayment.confirm_payment(driver);
			        } catch (Exception e) {
			           
			        }
			        
			    } catch (Exception e1) {
			       
			    }
				
	        } else {
	          
	        }
	
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "1111111111");
		counterpayment.Select_bill_book_no("TEST2425");
		counterpayment.Select_payment_mode("Cash");
		
		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
		
//		counterpayment.Click_ProceedAdvancePay(driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.Check_transaction_id(driver);
		counterpayment.Click_receipts_btn(driver);
		counterpayment.label_downloadReceipt(driver);
		counterpayment.downloadReceipt(driver);
		
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		counterpayment.compareUpicIds(test);
		stopWatch.stop();
		/////
		
		String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Receipt for download",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
		
		Thread.sleep(2000);
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "CashpaymentReceipt.pdf", 30);
	       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
       
		System.out.println("PDF file Downloading Status: " + result);  
        
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node1);
		offlinepaymentpage.Select_sector_no(driver, sector1);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo1);
		/////
		
		offlinepaymentpage.Click_search_property();
		String CounterafterChequeClear=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Counter After cash payment",MediaEntityBuilder.createScreenCaptureFromBase64String(CounterafterChequeClear).build());
		
		try {
			counterpayment = new CounterPaymentPage(driver);
			counterpayment.Check_isadvance_pay_btnVisible(driver);
			test.log(Status.PASS, "Counter is cleared ");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Counter is not cleared ");
		}	

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
		{
			e.printStackTrace();
		}
		extent.flush();
		
	}
	
	@AfterTest
	public void aftertest()
	{
		extent.flush();
	}
}
