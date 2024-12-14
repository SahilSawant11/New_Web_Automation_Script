package Water_Panvel;

import java.io.IOException;

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
import pojo.CMS_browser;
import pom_WaterTax.CollectionReportPage_Water;
import pom_WaterTax.LoginPage_Water;
import utility.TakeScreenshoot;

public class CollectionReports_Water extends BaseDriver {

	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		stopWatch = new StopWatch();	
	}
	
	@Test(priority = 1, enabled = false)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage_Water loginpage = new LoginPage_Water(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
		loginpage.Click_login_btn(driver);
		
		try
		{
			loginpage.Enter_user_name("sagar.m", driver);
			loginpage.Enter_password("123");
			loginpage.Click_login_btn(driver);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	public void Collection_Report() throws Exception
	{
		extent.createTest("Collection Report");
		CollectionReportPage_Water collectionreportpage = new CollectionReportPage_Water(driver);
		collectionreportpage.CollectionReport_Page_link(url, driver);
		Thread.sleep(5000);
		collectionreportpage.Select_type_collection_details(driver);
		collectionreportpage.Select_subtype_all(driver);
		collectionreportpage.Select_node_all(driver);
		collectionreportpage.Select_sector_all(driver);
		collectionreportpage.Select_finance_year(driver);
		collectionreportpage.Select_billbook_all(driver);
		collectionreportpage.Select_resource_all(driver);
		collectionreportpage.Select_mode_all(driver);
		collectionreportpage.Select_user_all(driver);
		collectionreportpage.Enter_from_date("01/12/2024");
		collectionreportpage.Click_to_date();
		collectionreportpage.Click_search_btn();
		Thread.sleep(10000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.info("Collection Report:",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
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
    public void tearDown() 
	{
		extent.flush();
	}
	
	
}
