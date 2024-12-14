package PCMC_All_Tests;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.TakeScreenshoot;

public class PCMC_TypeWisePayments extends BaseDriver {
	StopWatch stopWatch;
	private WebDriver driver = CMS_browser.getDriver();
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1, enabled = false)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
		loginpage.Click_login_btn(driver);
		Scanner scanner = new Scanner(System.in);
        System.out.print("Can We start Automation: ");
        String name = scanner.nextLine();
		
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
	
	@Test(priority = 2)
	public void Full_CashPayment() throws Exception
	{
		test = extent.createTest("Full Cash Payment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node9);
		offlinepaymentpage.Select_sector_no(driver, sector9);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo9);
		/////
		
		test.log(Status.INFO, "Property for Cash Payment : "+node9+"-"+sector9+"-"+PropertyNo9);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
	
		Thread.sleep(5000);
		
			counterpayment.PCMC_confirm_payment(driver);
		
		
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "8104678066");
		counterpayment.Select_payment_mode("Cash");
		
		
		
		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
		

		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.PCMC_Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		Thread.sleep(2000);
		counterpayment.confirm_payment(driver);
		counterpayment.Check_transaction_id(driver);
		String TRANSACTIONIDdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(TRANSACTIONIDdetails).build());
		
		
		counterpayment.pcmc_DownloadReceipt(driver);
		
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		
		String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Receipt for download",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
		
		Thread.sleep(2000);
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "Cash.pdf", 30);
        System.out.println("PDF file Downloading Status: " + result); 
        
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node9);
		offlinepaymentpage.Select_sector_no(driver, sector9);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo9);
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
	
	@Test(priority = 3)
	public void Pending_CashPayment() throws Exception
	{
		test = extent.createTest("Full Cash Payment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node10);
		offlinepaymentpage.Select_sector_no(driver, sector10);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo10);
		/////
		
		test.log(Status.INFO, "Property for Cash Payment : "+node10+"-"+sector10+"-"+PropertyNo10);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(5000);
		
		counterpayment.PCMC_uncheck_current(driver);
	
		Thread.sleep(5000);
		
			counterpayment.PCMC_confirm_payment(driver);
		
		
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "8104678066");
		counterpayment.Select_payment_mode("Cash");
		
		
		
		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
		

		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.PCMC_Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		Thread.sleep(2000);
		counterpayment.confirm_payment(driver);
		counterpayment.Check_transaction_id(driver);
		String TRANSACTIONIDdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(TRANSACTIONIDdetails).build());
		
		
		counterpayment.pcmc_DownloadReceipt(driver);
		
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		
		String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Receipt for download",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
		
		Thread.sleep(2000);
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "Cash.pdf", 30);
        System.out.println("PDF file Downloading Status: " + result); 
        
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node10);
		offlinepaymentpage.Select_sector_no(driver, sector10);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo10);
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
