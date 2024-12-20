package Water_Panvel;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import New_property_Wadhghat.BaseDriver;
import pom_WaterTax.LoginPage_Water;
import pom_WaterTax.ReportEnginePage_Water;
import utility.TakeScreenshoot;

public class ReportEngine_Water extends BaseDriver {
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
	public void TopDefaulter_report() throws Exception
	{
		extent.createTest("Top Defaulter Reports");
		ReportEnginePage_Water reportenginepage = new ReportEnginePage_Water(driver);
		reportenginepage.ReportEngine_Page_link(url, driver);
		reportenginepage.Select_topdefaulter_type(driver);
		reportenginepage.Select_node_all(driver);
		reportenginepage.Select_type_all(driver);
		reportenginepage.Select_finance_year(driver);
		reportenginepage.Select_size_all(driver);
		reportenginepage.Select_category_niyamit(driver);
		reportenginepage.Enter_amount("100");
		reportenginepage.Enter_topN("100");
		reportenginepage.Click_show_btn();
		Thread.sleep(5000);
		reportenginepage.scroll_to_bottom(driver);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.info("Top Defaulters:",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
		reportenginepage.Click_download_btn();
		Thread.sleep(2000);
		reportenginepage.Click_yes_btn();
		Thread.sleep(65000);
		reportenginepage.Click_close_btn();
	}
	
	@Test(priority = 3)
	public void Goshwara_report() throws Exception
	{
		extent.createTest("Goshwara Reports");
		ReportEnginePage_Water reportenginepage = new ReportEnginePage_Water(driver);
		reportenginepage.ReportEngine_Page_link(url, driver);
		reportenginepage.Select_goshwara_type(driver);
		reportenginepage.Select_subtype_wardwise(driver);
		reportenginepage.Click_show_btn();
		Thread.sleep(10000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.info("Goshwara",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
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
