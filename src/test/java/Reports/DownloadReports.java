package Reports;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
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
import Payments.alltypepayments;
import pojo.CMS_browser;
import pom.CMS_Page;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class DownloadReports extends BaseDriver {
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
/*
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
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.getDriver();
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
	*/
	@Test(priority = 2)
	public void DownloadCounterReports() throws Exception
	{
		test = extent.createTest("Counter Reports");
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
		
		try {
			counterpayment.confirm_payment(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		counterpayment.click_noticeBill(driver);
		Thread.sleep(3000);
		boolean isnoticedownloaded = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", node1+"-"+sector1+"-"+PropertyNo1+"-"+"Notice.pdf");
        System.out.println("PDF file Downloading Status: " + isnoticedownloaded); 
        
        if (isnoticedownloaded==true) {
        	test.pass("Notice Bill downloaded successfully for "+node1+"-"+sector1+"-"+PropertyNo1);
		}else {
			test.fail("Notice Bill not downloaded  for "+node1+"-"+sector1+"-"+PropertyNo1);
		}
        
        
        counterpayment.PopUpAfterDownloadNotice(driver);
        
        counterpayment.click_valuation(driver);
        Thread.sleep(3000);
        
        boolean isvaluationdownloaded = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", node1+"-"+sector1+"-"+PropertyNo1+"-"+"valuation.pdf");
        System.out.println("PDF file Downloading Status: " + isvaluationdownloaded); 
        
        counterpayment.PopUpAfterDownloadNotice(driver);
        
        if (isvaluationdownloaded==true) {
        	counterpayment.moveRenamedFileToReportFolder(EduTax);
        	test.pass("valuationsheet  downloaded successfully for "+node1+"-"+sector1+"-"+PropertyNo1);
		}else {
			test.fail("valuationsheet  not downloaded  for "+node1+"-"+sector1+"-"+PropertyNo1);
		}
}
	
	@Test(priority = 3)
	public void AssismentNakkal() throws Exception
	{
		CounterPaymentPage counterpayment = null;
		test = extent.createTest("Assisment Nakkal");
		System.out.println("hello");
		
		MakePropertyNoDue(node1, sector1, PropertyNo1);
		
		counterpayment = new CounterPaymentPage(driver);
		counterpayment.click_Nakkal(driver);
		
		try {
			counterpayment.Enter_email_idPopUP(driver, "abc@123.gmail.com");
			counterpayment.Enter_mobile_noPOPUp(driver, "1111111111");
			counterpayment.Select_bill_book_noPopUP("TEST2425");
			counterpayment.Select_payment_modePopUp("Cash");
			counterpayment.Click_payBTN_PopUp(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		boolean isNakkaldownloaded = counterpayment.renameDownloadedFile("PDFFILE.pdf", node1+"-"+sector1+"-"+PropertyNo1+"-"+"Nakkal.pdf");
        System.out.println("PDF file Downloading Status: " + isNakkaldownloaded); 
		

        if (isNakkaldownloaded==true) {
        	counterpayment.moveRenamedFileToReportFolder(EduTax);
        	test.pass("Nakkal downloaded successfully for "+node1+"-"+sector1+"-"+PropertyNo1);
		}else {
			test.fail("Nakkal not downloaded  for "+node1+"-"+sector1+"-"+PropertyNo1);
		}
		
		
}
	
	@Test(priority = 4)
	public void NoDueCertificate() throws Exception
	{
		CounterPaymentPage counterpayment = null;
		test = extent.createTest("NoDueCertificate");
	
		
		MakePropertyNoDue(node1, sector1, PropertyNo1);
		
		counterpayment = new CounterPaymentPage(driver);
		counterpayment.click_Nodue(driver);
		
		try {
			counterpayment.Enter_email_idPopUP(driver, "abc@123.gmail.com");
			counterpayment.Enter_mobile_noPOPUp(driver, "1111111111");
			counterpayment.Select_bill_book_noPopUP("TEST2425");
			counterpayment.Select_payment_modePopUp("Cash");
			counterpayment.Click_payBTN_PopUp(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		boolean isNoDuedownloaded = counterpayment.renameDownloadedFile("PDFFILE.pdf", node1+"-"+sector1+"-"+PropertyNo1+"-"+"NoDue.pdf");
        System.out.println("PDF file Downloading Status: " + isNoDuedownloaded); 
		

        if (isNoDuedownloaded==true) {
        	counterpayment.moveRenamedFileToReportFolder(EduTax);
        	test.pass("No Due Certificate downloaded successfully for "+node1+"-"+sector1+"-"+PropertyNo1);
		}else {
			test.fail("No Due Certificate not downloaded  for "+node1+"-"+sector1+"-"+PropertyNo1);
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
	
	////////////////////////////////////////methods used in a test code
	
	public void MakePropertyNoDue(String node,String sector,String property) throws Exception {
		
		
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
		
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node);
		offlinepaymentpage.Select_sector_no(driver, sector);
		offlinepaymentpage.Enter_property_no(driver, property);
		/////
		
		test.log(Status.INFO, "Property : "+node+"-"+sector+"-"+property);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
	
		
		if (counterpayment.Check_isPropertyHasNoDue(driver) == true) {
			try {
				counterpayment.confirm_payment(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			test.log(Status.INFO, "Property has No Due : "+node+"-"+sector+"-"+property);
			String counterOfnodueProperty=TakeScreenshoot.GetScreenshotFullBase64(driver);
			test.pass("counter Of no due Property",MediaEntityBuilder.createScreenCaptureFromBase64String(counterOfnodueProperty).build());
		}
else {
	test.log(Status.INFO, "Property has Due : "+node+"-"+sector+"-"+property);
	String counterOfProperty=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("counter Of Property",MediaEntityBuilder.createScreenCaptureFromBase64String(counterOfProperty).build());
	
	counterpayment.Select_Finalcheckbox(driver);
	Thread.sleep(5000);
	counterpayment.Select_APartcheckbox(driver);
	
	
	try {
		counterpayment.confirm_payment(driver);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());

	counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
	counterpayment.Enter_mobile_no(driver, "1111111111");
	counterpayment.Select_bill_book_no("TEST2425");
	counterpayment.Select_payment_mode("Cash");
	
	
	
	String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
	
//	counterpayment.Click_ProceedAdvancePay(driver);
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
	stopWatch.stop();
	/////
	
	
	String counterbeforePayment=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("Receipt for download",MediaEntityBuilder.createScreenCaptureFromBase64String(counterbeforePayment).build());
	
	Thread.sleep(2000);
	boolean result = 		counterpayment.renameDownloadedFile("PDFFILE.pdf", "CashPaymentFullForNoDue.pdf");
    System.out.println("PDF file Downloading Status: " + result);  
    
	offlinepaymentpage.counterPayment(driver, url);
	offlinepaymentpage.Click_property_no_radio_btn(driver);
		
	offlinepaymentpage.Select_node_no(driver, node);
	offlinepaymentpage.Select_sector_no(driver, sector);
	offlinepaymentpage.Enter_property_no(driver, property);
	/////
	
	offlinepaymentpage.Click_search_property();
	String propertyafterfullpaymentforNoDue=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("property after full payment for NoDue",MediaEntityBuilder.createScreenCaptureFromBase64String(propertyafterfullpaymentforNoDue).build());
	
	try {
		counterpayment.confirm_payment(driver);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	try {
		counterpayment = new CounterPaymentPage(driver);
		counterpayment.Check_isadvance_pay_btnVisible(driver);
		test.log(Status.PASS, "Counter is cleared ");
		
	} catch (Exception e) {
		test.log(Status.FAIL, "Counter is not cleared ");
	}
	
}
		
		
		
		
	}
		
}
