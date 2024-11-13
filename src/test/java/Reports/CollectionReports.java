package Reports;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.CollectionReportsPage;
import pom.CounterPaymentPage;
import pom.LoginPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class CollectionReports extends BaseDriver {
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
	@Test(priority = 2)
	public void collectiontest() throws InterruptedException {
		test = extent.createTest("Collection Report");
		Thread.sleep(5000);
		CollectionReportsPage collectionpage = new CollectionReportsPage(driver);
		CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		StopWatch stopWatch = new StopWatch();
		collectionpage.CollectionReports_link(url, driver);		
		collectionpage.Select_template(driver);
		Thread.sleep(5000);
		collectionpage.Select_payment_option_cheque(driver);  // for cheque reports 
		Thread.sleep(5000);									  //	
		collectionpage.status_inprocess(driver);			  // for inprocess option 	
		Thread.sleep(5000);									  // 
		collectionpage.Select_all_payment_modes(driver);	  // 
		Thread.sleep(5000);
		String collectionoptionsSelected = null;
		try {
			collectionoptionsSelected = TakeScreenshoot.GetScreenshotFullBase64(driver);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		test.pass("Selected Collection Reports Options ✔",MediaEntityBuilder.createScreenCaptureFromBase64String(collectionoptionsSelected).build());
		collectionpage.scrollToBottom(driver);
		collectionpage.Click_date_box(driver,"1");
		Thread.sleep(5000);
		stopWatch.start();
		collectionpage.Click_generate_btn(driver);
		boolean result = false;
		try {
			 result = 		counterpayment.isFileDownloaded("pdffile.pdf", "CollectionReport.pdf", 30);
			 if (result==true) { test.pass("Receipt downloaded Successfully");	} else {test.fail("Receipt Not downloaded");}
	        System.out.println("PDF file Downloading Status: " + result); 
		} catch (Exception e) {	
			e.printStackTrace();
		}
        System.out.println("PDF file Downloading Status: " + result);
        test.info("Time duration of exporting Collection Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();
	}
	
	@AfterTest
    public void tearDown() {
 //       if (driver != null) {
 //           driver.quit();
 //      }
        extent.flush();
    }
	
}
