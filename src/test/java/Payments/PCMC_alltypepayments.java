package Payments;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FalseFileFilter;
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
import pom.DDChequeclearPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class PCMC_alltypepayments extends BaseDriver{
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
//		Delete_Files Delete_files = new Delete_Files(driver);
//		System.out.println(System.getProperty("user.dir"));
//		Delete_files.Delete_files("\\PdfReports\\");
//		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.openBrowser(url);
		stopWatch = new StopWatch();
		
	}
	
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
//		loginpage.Click_login_btn(driver);
		Scanner scanner = new Scanner(System.in);
        System.out.print("Can We start Automation: ");
        String name = scanner.nextLine();
		
		try
		{
			loginpage.click_logout(driver);
			loginpage.Enter_user_name(userid, driver);
			loginpage.Enter_password(password);
//			loginpage.Click_login_btn(driver);	
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2,dependsOnMethods = "loginPage")
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
		boolean result = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", "CashPayment.pdf");
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
	//enabled = false
	@Test(priority = 8)
	public void AdvancePayment() throws Exception
	{
		
		
		test = extent.createTest("Advance Payment");
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
		
		test.log(Status.INFO, "Property for Advance Payment : "+node1+"-"+sector1+"-"+PropertyNo1);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.Click_advance_pay_btn(driver);
		counterpayment.Enter_AdvanceAmount(driver);
		counterpayment.Click_ProceedAdvancePay(driver);
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "9825456987");
		//counterpayment.Select_payment_mode("Cash");
		counterpayment.Enter_behalf_payer_name(driver, "abc");
			
		/////
		stopWatch.reset();
		stopWatch.start();
		counterpayment.PCMC_Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		Thread.sleep(2000);
		counterpayment.confirm_payment(driver);
		counterpayment.Check_transaction_id(driver);
	//	counterpayment.Click_receipts_btn(driver);
		counterpayment.label_downloadReceipt(driver);
		counterpayment.pcmc_DownloadReceipt(driver);
		
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		Thread.sleep(2000);
		boolean result = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", "AdvanceCash.pdf");
        System.out.println("PDF file Downloading Status: " + result); 
		
		
		///

	}
	
	@Test(priority = 4,dependsOnMethods = "loginPage", enabled= false)
	public void chequePayment() throws Exception
	{
		test = extent.createTest("Cheque Payment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node2);
		offlinepaymentpage.Select_sector_no(driver, sector2);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo2);
		/////
		test.log(Status.INFO, "Property for cheque Payment : "+node2+"-"+sector2+"-"+PropertyNo2);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
	
			counterpayment.PCMC_confirm_payment(driver);
		
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "8104678065");
		counterpayment.Select_payment_mode("Cheque");
		counterpayment.Select_bankname(driver, "Bank OF India(BOI)");
//		counterpayment.Enter_behalf_payer_name(driver, "abc");
			counterpayment.Enter_cheque_dd_transation_no(driver, "1122334");
			LocalDate today = LocalDate.now();
			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String formattedDate = today.format(formatter);
			
			counterpayment.Enter_cheque_dd_transation_date(driver, formattedDate);
		
		
		String EnteredChequeDetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(EnteredChequeDetails).build());
		
//		counterpayment.Click_ProceedAdvancePay(driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(3000);
		
		counterpayment.PCMC_Click_pay_now(driver);
		try {
			counterpayment.PCMC_Click_pay_now(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
		
		boolean result = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", "ChequePayment.pdf");
        System.out.println("PDF file Downloading Status: " + result); 
		

	}
	
	@Test(priority = 5,dependsOnMethods = "chequePayment", enabled = false)
	public void cheque_fail() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extent.createTest("Cheque fail");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();

		DDChequeclearPage DDchequeapproval = new DDChequeclearPage(driver);
		DDchequeapproval.DDchequeApprovalpage(url, driver);
		DDchequeapproval.pageloading(driver);
		DDchequeapproval.Enter_ChequeNo("1122334", driver);
		DDchequeapproval.SelectNode_filter(node2, driver);
		DDchequeapproval.SelectSec_filter(sector2, driver);
		LocalDate today = LocalDate.now();
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = today.format(formatter);
		
		DDchequeapproval.Enter_Bank_transaction_date(driver, formattedDate);
		
		DDchequeapproval.Click_serachBTN (driver);
		DDchequeapproval.SelectCheque(driver);
		
		String chequeforclearence=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("selected Cheque for Not Clearence",MediaEntityBuilder.createScreenCaptureFromBase64String(chequeforclearence).build());
		
		stopWatch.start();
		DDchequeapproval.ChequefailBtn(driver);
		DDchequeapproval.Yes_popUp_NotCleared(driver);
		DDchequeapproval.WaitTillGetClear(driver);
		test.info("Time duration of Not Clearing Cheque was: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		
		
		
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node2);
		offlinepaymentpage.Select_sector_no(driver, sector2);
	//	offlinepaymentpage.Enter_property_no(driver, PropertyNo2);
		
		/////
		
		offlinepaymentpage.Click_search_property();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		String CounterafterChequeFail=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Counter After Cheque Fail",MediaEntityBuilder.createScreenCaptureFromBase64String(CounterafterChequeFail).build());
		
		
		try {
			counterpayment = new CounterPaymentPage(driver);
			counterpayment.Check_is_penalty_Visible(driver);
			test.log(Status.PASS, "Counter is Penalized");
			assertTrue(true, "Counter is Penalized");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Counter is not Penalized ");
			
			assertTrue(false, "Counter is not Penalized");
		}

	}
	
	
	@Test(priority = 6, enabled = false)
	public void cheque_clear() throws Exception
	{
		
		test = extent.createTest("Cheque clear");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();

		DDChequeclearPage DDchequeapproval = new DDChequeclearPage(driver);
		DDchequeapproval.DDchequeApprovalpage(url, driver);
		DDchequeapproval.pageloading(driver);
		DDchequeapproval.Enter_ChequeNo("1122334", driver);
		DDchequeapproval.SelectNode_filter(node2, driver);
		
		
		DDchequeapproval.SelectSec_filter(sector2, driver);
		
		DDchequeapproval.Click_serachBTN (driver);
		DDchequeapproval.SelectCheque(driver);
		
		String chequeforclearence=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("selected Cheque for Clearence",MediaEntityBuilder.createScreenCaptureFromBase64String(chequeforclearence).build());
		
		stopWatch.start();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
	        Thread.sleep(3000);
		DDchequeapproval.ChequeclearBtn(driver);
		 Thread.sleep(3000);
		DDchequeapproval.Yes_popUp(driver);
		
		DDchequeapproval.WaitTillGetClear(driver);
		test.info("Time duration of Clearing Cheque was: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		
		
		
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node2);
		offlinepaymentpage.Select_sector_no(driver, sector2);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo2);
		/////
		
		offlinepaymentpage.Click_search_property();
		String CounterafterChequeClear=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Counter After Cheque Clear",MediaEntityBuilder.createScreenCaptureFromBase64String(CounterafterChequeClear).build());
		
		
		try {
			counterpayment = new CounterPaymentPage(driver);
			counterpayment.Check_isadvance_pay_btnVisible(driver);
			test.log(Status.PASS, "Counter is cleared ");
			assertTrue(true, "Counter is cleared");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Counter is not cleared ");
			
			assertTrue(false, "Counter is not cleared");
		}
		
		
		

	}
	
		
	@Test(priority = 7,dependsOnMethods = "loginPage")
	public void Card() throws Exception
	{
		test = extent.createTest("Card Payment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node3);
		offlinepaymentpage.Select_sector_no(driver, sector3);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo3);
		/////
		
		test.log(Status.INFO, "Property for Card Payment : "+node3+"-"+sector3+"-"+PropertyNo3);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		counterpayment.PCMC_confirm_payment(driver);
			
			
		
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "9819578052");
		counterpayment.Select_payment_mode("Card Payment");
		counterpayment.Select_bankname(driver, "Bank OF India(BOI)");
		Thread.sleep(4000);
		
		Random random = new Random();

        // Generate a random integer
        int randomInt = random.nextInt(); 
		
		try {
			counterpayment.Enter_paid_ref_id(driver, "1234"+randomInt);
		} catch (Exception e) {
			Thread.sleep(2000);
			counterpayment.Enter_paid_ref_id(driver, "1234"+randomInt);
		}
	
		counterpayment.PCMC_Click_pay_now(driver);
		counterpayment.PCMC_Yes_Transaction_btn(driver);
		
		
		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
		
		//counterpayment.PCMC_Click_ProceedCardPay(driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		//counterpayment.PCMC_Click_pay_now(driver);
		//counterpayment.confirm_payment(driver);
		//Thread.sleep(2000);
		//counterpayment.confirm_payment(driver);
		//counterpayment.Check_transaction_id(driver);
		//counterpayment.Click_receipts_btn(driver);
		//counterpayment.label_downloadReceipt(driver);
		
		//counterpayment.pcmc_DownloadReceipt(driver);
		
		test.info("Time duration of Searching property on counter payment page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		
		String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Receipt for download",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
		
		boolean result = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", "CardPayment.pdf");
        System.out.println("PDF file Downloading Status: " + result); 
		
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node1);
		offlinepaymentpage.Select_sector_no(driver, sector1);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo1);
		/////
		
		offlinepaymentpage.Click_search_property();
		String CounterafterChequeClear=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Counter After Cheque Clear",MediaEntityBuilder.createScreenCaptureFromBase64String(CounterafterChequeClear).build());
		
		
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
