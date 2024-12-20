package Water_Panvel;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom_WaterTax.LoginPage_Water;
import utility.Delete_Files;

public class Login_Water extends BaseDriver{
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		Delete_Files Delete_files = new Delete_Files(driver);
		System.out.println(System.getProperty("user.dir"));
		Delete_files.Delete_files("\\temp\\");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
//		driver = CMS_browser.openBrowser("http://test.paywaterbill.org/Login");	
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		Delete_Files Delete_files = new Delete_Files(driver);
		System.out.println(System.getProperty("user.dir"));
		Delete_files.Delete_files("\\PdfReports\\");
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.getDriver();
		
		
	    driver.get("http://test.paywaterbill.org/Login");
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

}
