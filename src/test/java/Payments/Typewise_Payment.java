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
//		Delete_Files Delete_files = new Delete_Files(driver);
//		System.out.println(System.getProperty("user.dir"));
//		Delete_files.Delete_files("\\PdfReports\\");
//		extent = new ExtentReports();
//		spark = new ExtentSparkReporter("ExtentReport.html");
//		extent.attachReporter(spark);
//		BaseDriver.GetData();
//		driver = CMS_browser.openBrowser(url);
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1,enabled=false)
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
	public void A_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("A_Part_CashPayment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node5);
		offlinepaymentpage.Select_sector_no(driver, sector5);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo5);
		/////
		
		test.log(Status.INFO, "Property for A Part Cash Payment : "+node5+"-"+sector5+"-"+PropertyNo5);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node5)) {
			 try {
			        counterpayment.row1(driver);
			        
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
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.error_pop_up(driver, test);
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
        
	}
	
	@Test(priority = 3 )
	public void B_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("B_Part_CashPayment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node6);
		offlinepaymentpage.Select_sector_no(driver, sector6);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo6);
		/////
		
		test.log(Status.INFO, "Property for B Part Cash Payment : "+node6+"-"+sector6+"-"+PropertyNo6);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node6)) {
			 try {
			        counterpayment.row2(driver);
			        
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
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.error_pop_up(driver, test);
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

	}
	
	@Test(priority = 4)
	public void C_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("C_Part_CashPayment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node7);
		offlinepaymentpage.Select_sector_no(driver, sector7);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo7);
		/////
		
		test.log(Status.INFO, "Property for C Part Cash Payment : "+node7+"-"+sector7+"-"+PropertyNo7);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node7)) {
			 try {
			        counterpayment.row3(driver);

			        
			        try {
			    		counterpayment.error_pop_up(driver, test);	
			            counterpayment.confirm_payment(driver);
			        } catch (Exception e) {
			           
			        }
			        
			    } catch (Exception e1) {
			       
			    }
				
	        } else {
	          
	        }
	
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());

//		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
//		counterpayment.Enter_mobile_no(driver, "1111111111");
//		counterpayment.Select_bill_book_no("TEST2425");
//		counterpayment.Select_payment_mode("Cash");
//		
//		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
//		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
//		stopWatch.reset();
//		stopWatch.start();
//		Thread.sleep(2000);
//		counterpayment.Click_pay_now(driver);
//		counterpayment.confirm_payment(driver);
//
//		counterpayment.Check_transaction_id(driver);
//		counterpayment.Click_receipts_btn(driver);
//		counterpayment.label_downloadReceipt(driver);
//		counterpayment.downloadReceipt(driver);
		
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
        
	}
	
	@Test(priority = 5)
	public void AB_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("AB_Part_CashPayment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node8);
		offlinepaymentpage.Select_sector_no(driver, sector8);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo8);
		/////
		
		test.log(Status.INFO, "Property for AB Part Cash Payment : "+node8+"-"+sector8+"-"+PropertyNo8);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node8)) {
			 try {
			        counterpayment.row1(driver);
			        
			        try {
			            counterpayment.confirm_payment(driver);
			            counterpayment.row2(driver);
			            Thread.sleep(10000);
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
        
	}
	
	@Test(priority = 6 )
	public void BC_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("BC_Part_CashPayment");
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
		
		test.log(Status.INFO, "Property for BC Part Cash Payment : "+node9+"-"+sector9+"-"+PropertyNo9);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node9)) {
			 try {
			        counterpayment.row2(driver);
			        counterpayment.row3(driver);
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
        
	}
	
	@Test(priority = 7 )
	public void AC_Part_CashPayment() throws Exception
	{	
		test = extent.createTest("AC_Part_CashPayment");
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
		
		test.log(Status.INFO, "Property for AC Part Cash Payment : "+node10+"-"+sector10+"-"+PropertyNo10);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node10)) {
			 try {
			        counterpayment.row1(driver);

			        
			        try {
			            counterpayment.confirm_payment(driver);
			            counterpayment.row3(driver);
			        	counterpayment.error_pop_up(driver, test);
			            Thread.sleep(10000);
			        } catch (Exception e) {
			           
			        }
			        
			    } catch (Exception e1) {
			       
			    }
				
	        } else {
	          
	        }
	
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		
//		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
//		counterpayment.Enter_mobile_no(driver, "1111111111");
//		counterpayment.Select_bill_book_no("TEST2425");
//		counterpayment.Select_payment_mode("Cash");
//		
//		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
//		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
//		stopWatch.reset();
//		stopWatch.start();
//		Thread.sleep(2000);
//		counterpayment.Click_pay_now(driver);
//		counterpayment.confirm_payment(driver);
//		counterpayment.error_pop_up(driver, test);
//		counterpayment.Check_transaction_id(driver);
//		counterpayment.Click_receipts_btn(driver);
//		counterpayment.label_downloadReceipt(driver);
//		counterpayment.downloadReceipt(driver);
//		
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
        
	}

	@Test(priority = 8 )
	public void B_Part_Partial_CashPayment() throws Exception
	{	
		test = extent.createTest("B_Part_Partial_CashPayment");
		CounterPaymentPage counterpayment = null;
		stopWatch = new StopWatch();
	
		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
		
		offlinepaymentpage.Select_node_no(driver, node12);
		offlinepaymentpage.Select_sector_no(driver, sector12);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo12);
		/////
		
		test.log(Status.INFO, "Property for B Part Partial Cash Payment : "+node12+"-"+sector12+"-"+PropertyNo12);
		stopWatch.start();
		offlinepaymentpage.Click_search_property();
			
		counterpayment = new CounterPaymentPage(driver);
		
		Thread.sleep(2000);
		
		String abc="BMC";;
		 if (!abc.equals(node12)) {
			 try {
			        counterpayment.row2(driver);
			        counterpayment.row2_partialpay_btn(driver);
			        
			        try {

			        } catch (Exception e) {
			           
			        }
			        
			    } catch (Exception e1) {
			       
			    }
				
	        } else {
	          
	        }
	
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("counter",MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
	
		counterpayment.Enter_partial_payment_textfield(driver, "100");
		counterpayment.tax_partial_btn(driver);
		counterpayment.Click_edit_btn(driver);
		counterpayment.Click_update_btn(driver);
		counterpayment.Enter_email_id(driver, "abc@123.gmail.com");
		counterpayment.Enter_mobile_no(driver, "1111111111");
		counterpayment.Select_bill_book_no("TEST2425");
		counterpayment.Select_payment_mode("Cash");
		
		String paymentdetails=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("payment details ",MediaEntityBuilder.createScreenCaptureFromBase64String(paymentdetails).build());
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(2000);
		counterpayment.Click_pay_now(driver);
		counterpayment.confirm_payment(driver);
		counterpayment.error_pop_up(driver, test);
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
