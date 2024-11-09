package PCMC_All_Tests;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;
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
import pom.AdminDashboardPage;
import pom.LoginPage;
import utility.TakeScreenshoot;

public class PCMC_AdminDashboardReports extends BaseDriver {
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
	
	@Test(priority = 2)
	public void Paymentmodewise_Report() throws Exception {
	
	    test = extent.createTest("Payment Mode Wise Report");


	    AdminDashboardPage admindashboardpage = new AdminDashboardPage(driver);
	    admindashboardpage.AdminDashboardPageLink(url, driver);	
	    Thread.sleep(5000);
	    admindashboardpage.Click_payment_wise(driver);	    
	    Thread.sleep(10000);
	    boolean isTablePresent = admindashboardpage.isPaymentModeWiseTablePresent(driver);	
	    Assert.assertTrue(isTablePresent, "Payment Mode Wise Collection table is not present.");

	    
	    if (isTablePresent) {
	        test.pass("Payment Mode Wise Collection table is found and visible.");
	    } else {
	        
	        test.fail("Payment Mode Wise Collection table is not found.");
	    }
	}
	
	@Test(priority = 3)
	public void Usewise_Report() throws Exception {
	
	    test = extent.createTest("Use Wise Report");
	    AdminDashboardPage admindashboardpage = new AdminDashboardPage(driver);
	    admindashboardpage.AdminDashboardPageLink(url, driver);	
	    Thread.sleep(5000);	    
	    admindashboardpage.Click_use_wise(driver);	    
	    Thread.sleep(10000);
	    boolean isTablePresent = admindashboardpage.isUseWiseTablePresent(driver);
	    Assert.assertTrue(isTablePresent, "Use Wise Collection table is not present.");

	    
	    if (isTablePresent) {
	        test.pass("Use Wise Collection table is found and visible.");
	    } else {
	        
	        test.fail("Use Wise Collection table is not found.");
	    }
	}
	
	@Test(priority = 3)
	public void Zonewise_Report() throws Exception {
	    test = extent.createTest("Zone Wise Report");
	    AdminDashboardPage admindashboardpage = new AdminDashboardPage(driver);
	    admindashboardpage.AdminDashboardPageLink(url, driver);
	    Thread.sleep(5000);
	    admindashboardpage.Click_zone_wise(driver);
	    Thread.sleep(10000);
	    boolean isTablePresent = admindashboardpage.isZoneWiseTablePresent(driver);
	    Assert.assertTrue(isTablePresent, "Zone Wise Collection table is not present.");
	    
	    
	    if (isTablePresent) {
	        test.pass("Zone Wise Collection table is found and visible.");
	    } else {	        
	        test.fail("Zone Wise Collection table is not found.");
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
