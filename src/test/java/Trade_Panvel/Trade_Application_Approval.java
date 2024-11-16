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
import pom.LoginPage;
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
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
		Scanner scanner = new Scanner(System.in);
        System.out.print("Can We start Automation: ");
        String name = scanner.nextLine();
		
		try
		{
			loginpage.click_logout(driver);
			loginpage.Enter_user_name(userid, driver);
			loginpage.Enter_password(password);	
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	public void dataEntry() throws InterruptedException
	{
		test = extent.createTest("Data Entry");
		
		
		
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
