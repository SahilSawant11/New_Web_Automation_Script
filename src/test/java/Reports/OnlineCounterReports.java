package Reports;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pom.OnlineDataEntryPage;
import pom.OnlinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class OnlineCounterReports extends BaseDriver{
	JavascriptExecutor js;
	StopWatch stopWatch;
	private WebDriver driver = CMS_browser.getDriver();
	
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
	@Test(priority = 3)
	public void TaxCompareTest() throws Exception
	{
		test = extent.createTest("Tax Compare test");
		OnlinePaymentPage onlinepage = new OnlinePaymentPage(driver);
		onlinepage.onlinePaymentUrl(driver, url);
		onlinepage.Select_node_no(driver, node);
		onlinepage.Select_sector_no(driver, sector);
		onlinepage.Enter_property_no(driver, PropertyNo);
		onlinepage.Click_search_property();
		Thread.sleep(5000);
		String pagename = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.log(Status.INFO, "Property on Online Payment Screen ", MediaEntityBuilder.createScreenCaptureFromBase64String(pagename).build() );
		onlinepage.Agree_and_proceed();
		onlinepage.Click_Notice_Bill();
		CounterPaymentPage counterpayment = null;
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "Noticebillfromonline.pdf", 30);
	       if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
    
        onlinepage.Scroll_to_grid(driver);
        onlinepage.Click_select_pay_all_checkbox();
        String ops = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.log(Status.INFO, "Taxes on Online Payment Screen ", MediaEntityBuilder.createScreenCaptureFromBase64String(ops).build() );
	    //OfflinePaymentPage offlinepage = new OfflinePaymentPage(driver);
		//offlinepage.getOfflineTotalTax(driver);
	    onlinepage.getOnlineScreenDetails();
	    
	    String offlineTax = OfflinePaymentPage.offlineTotalTax;
	    String onlineTax = OnlinePaymentPage.onlineTotalTax;
	    String offlineOwnerName = OfflinePaymentPage.offlineKarDharak;
	    String onlineOwnerName = OnlinePaymentPage.onlineKarDharak;
	    
//	    try {
//	    	Assert.assertEquals(onlineTax, offlineTax,"The online and offline tax values do not match!");
//	    	Assert.assertEquals(onlineOwnerName, offlineOwnerName,"The online and offline owner name values do not match!");
//	    	test.pass("online and offline taxes and names  match");
//			
//		} catch (AssertionError e) {
//			test.fail("Taxes or Names on Online Screen and Offline Screen did not match");
//			throw e;
//		}
	    
	    onlinepage.Click_pay_now();
	    onlinepage.Enter_email_id(driver, change_email );
	    onlinepage.Enter_mobile_no(driver, mobile);
	    onlinepage.Click_gateway();
	    Thread.sleep(5000);
	    onlinepage.Click_terms_conditions();
	    Thread.sleep(5000);
	    onlinepage.Click_final_pay_now();
	    Thread.sleep(5000);
	    onlinepage.Click_final_ok();
	    Thread.sleep(5000);
	    String pg = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.log(Status.INFO, "Payment Gateway Screen ", MediaEntityBuilder.createScreenCaptureFromBase64String(pg).build() );
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
    public void tearDown() {
     
        extent.flush();

    }

}
