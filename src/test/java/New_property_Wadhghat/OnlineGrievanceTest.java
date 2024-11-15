package New_property_Wadhghat;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pojo.CMS_browser;
import pom.LoginPage;
import pom.OnlineGrievancePage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class OnlineGrievanceTest extends BaseDriver {
	
	StopWatch stopWatch;
	WebDriver driver;
	
	
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
		driver = CMS_browser.openBrowser(url);
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
	public void Online_greivance_test() throws Exception
	{
		test = extent.createTest("Greivance Test");
		OnlineGrievancePage grievancepage = new OnlineGrievancePage(driver);
		grievancepage.Online_Greivance_Page_link(url, driver);
	
		grievancepage.Click_inprocess(driver);
		Thread.sleep(120000);
		grievancepage.Select_property(driver);
		Thread.sleep(60000);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();  
		String childWindow = iterator.next();  
		
		driver.switchTo().window(childWindow);
		grievancepage.Scroller(driver);
		Thread.sleep(5000);
		String floorinfoImage=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Property Documents ",MediaEntityBuilder.createScreenCaptureFromBase64String(floorinfoImage).build());
		grievancepage.Scroller(driver);
		Thread.sleep(5000);
		String floorinfoImage2=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Property Documents ",MediaEntityBuilder.createScreenCaptureFromBase64String(floorinfoImage2).build());
		grievancepage.Scroller(driver);
		Thread.sleep(3000);
		String floorinfoImage3=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Property Documents ",MediaEntityBuilder.createScreenCaptureFromBase64String(floorinfoImage3).build());
		grievancepage.Enter_remark(driver, oldRemark);
		
		
	}
	
	@AfterTest
    public void tearDown() {
      //  if (driver != null) {
       //     driver.quit();
     //   }
        extent.flush();
    }


}
