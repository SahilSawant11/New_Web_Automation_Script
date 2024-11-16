package Trade_Panvel;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom_TradeLicense.ApplicationApprovalPage;
import pom_TradeLicense.DataEntryPage_TradeLicense;
import pom_TradeLicense.LoginPage_TradeLicense;
import utility.TakeScreenshoot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Trade_Application_Approval extends BaseDriver {
	
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
	
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
		test = extent.createTest("loginPage");
		LoginPage_TradeLicense loginpage = new LoginPage_TradeLicense(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
		loginpage.Click_login_btn(driver);
		
		try
		{
		//	loginpage.click_logout(driver);
			loginpage.Enter_user_name(userid, driver);
			loginpage.Enter_password(password);
			loginpage.Click_login_btn(driver);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	public void dataEntry() throws Exception
	{
		test = extent.createTest("Data Entry");
		DataEntryPage_TradeLicense dataentrypage = new DataEntryPage_TradeLicense(driver);
		dataentrypage.DataEntry_Page_link(url, driver);
		dataentrypage.select_node_no(driver);
		dataentrypage.select_sector_no( driver);
		dataentrypage.enter_property_no(driver);
		Thread.sleep(5000);
		dataentrypage.scroll_to_bottom(driver);
		dataentrypage.search_property(driver);
		Thread.sleep(5000);
		dataentrypage.scrollbypix(driver);
		dataentrypage.clickDeleteOwner1(driver);
		dataentrypage.clickDeleteOwner2(driver);
		dataentrypage.Enter_Englishname(occupier_name);
		dataentrypage.Enter_Marathiname(ferfar_kardharak);
		dataentrypage.Enter_mail(change_email);
		dataentrypage.Enter_phone(mobile);
		dataentrypage.Enter_Adhaar(adhaar);
		dataentrypage.Enter_Pan(pan);
		dataentrypage.Enter_City(city);
		dataentrypage.Enter_Pincode(pin);
		dataentrypage.Enter_Wing(wing);
		dataentrypage.Enter_Plot(plot_no);
		dataentrypage.Enter_Flat(flatno);
		dataentrypage.Enter_address(address);
		
		
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
