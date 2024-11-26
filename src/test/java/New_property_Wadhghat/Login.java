package New_property_Wadhghat;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pojo.CMS_browser;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;





//
public class Login extends BaseDriver {
	
	JavascriptExecutor js;
	StopWatch stopWatch;
	
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
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.getDriver();
		stopWatch = new StopWatch();
	}
	
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException {
		
		Delete_Files Delete_files = new Delete_Files(driver);
		System.out.println(System.getProperty("user.dir"));
		Delete_files.Delete_files("\\PdfReports\\");
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		
//		WebDriverManager.chromedriver().setup();
		driver = CMS_browser.getDriver();
		stopWatch = new StopWatch();
		
		
	    driver.get(url);
	    test = extent.createTest("loginPage");
	    
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.Enter_user_name(userid, driver);
	    loginpage.Enter_password(password);
	    
//	 Thread.sleep(10000);
	    
     //Checking
	   OfflinePaymentPage offlinepage = new OfflinePaymentPage(driver);
	   ;
	    if (offlinepage.waitforlogin(driver)==true) {
        
	        System.out.println("User is logged in successfully. Proceeding with further actions.");
	        
	    } else {
	        System.out.println(" login failed or user name is not displayed.");
	    }
	}


	

}

//	JavascriptExecutor js;
//	StopWatch stopWatch;
//	
//	@BeforeTest
//	public void beforetest() throws IOException
//	{
//		Delete_Files Delete_files = new Delete_Files(driver);
//		System.out.println(System.getProperty("user.dir"));
//		Delete_files.Delete_files("\\PdfReports\\");
//		
//		extent = new ExtentReports();
//		spark = new ExtentSparkReporter("ExtentReport.html");
//		extent.attachReporter(spark);
//		BaseDriver.GetData();
////		WebDriverManager.chromedriver().setup();
//		driver = CMS_browser.getDriver();
//		stopWatch = new StopWatch();
//	}
//	
//	
//	@Test(priority = 1)
//	public void loginPage() throws InterruptedException
//	{
//		driver.get(url);
//		test = extent.createTest("loginPage");
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.Enter_user_name(userid, driver);
//		
//		loginpage.Enter_password(password);
//		Thread.sleep(10000);
//		Scanner scanner = new Scanner(System.in);
//     System.out.print("Can We start Automation: ");
//		
//		try
//		{
//			loginpage.click_logout(driver);
//			loginpage.Enter_user_name(userid, driver);
//			loginpage.Enter_password(password);
//			loginpage.Click_login_btn(driver);	
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}
//
//}

