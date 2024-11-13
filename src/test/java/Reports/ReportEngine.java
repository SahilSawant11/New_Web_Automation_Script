package Reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Stopwatch;

import New_property_Wadhghat.BaseDriver;
import SmokTesting.testbrowser;
import pojo.CMS_browser;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.ReportEnginePage;
import utility.Delete_Files;


public class ReportEngine extends BaseDriver {
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
		driver = CMS_browser.openBrowser(url);
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		
		loginpage.Enter_password(password);
		Thread.sleep(10000);
		loginpage.Click_login_btn(driver);
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
	public void Notice_report () throws Exception
	{
		test = extent.createTest("Notice Report Test");
		 ReportEnginePage reportenginepage = new ReportEnginePage(driver);
		 CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		 StopWatch stopWatch = new StopWatch();
		 reportenginepage.Report_Engine_Page_link(url, driver);
		 reportenginepage.Select_propertyno_wise_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_Node(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_sector_no(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_propertyno_50_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_partitionno_all_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_report_type_notice(driver);
		 Thread.sleep(5000);
		 stopWatch.start();
		 reportenginepage.Export_btn(driver);
		 Thread.sleep(2000);
		 boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "NoticeReport.pdf", 30);
	        System.out.println("PDF file Downloading Status: " + result); 
		 test.info("Time duration of exporting Notice Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		 stopWatch.stop();   
	}
	
@Test(priority = 3)
	
	public void Karakarni_report () throws Exception
	{
		 test = extent.createTest("Karakarni Report Test");
		 ReportEnginePage reportenginepage = new ReportEnginePage(driver);
		 CounterPaymentPage counterpayment = new CounterPaymentPage(driver);
		 StopWatch stopWatch = new StopWatch();
		 reportenginepage.Report_Engine_Page_link(url, driver);
		 reportenginepage.Select_propertyno_wise_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_Node(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_sector_no(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_propertyno_50_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_partitionno_all_checkbox(driver);
		 Thread.sleep(5000);
		 reportenginepage.Select_report_type_karakarni(driver);
		 Thread.sleep(5000);
		// stopWatch.reset();
		 stopWatch.start();
		 reportenginepage.Export_btn(driver);
		 Thread.sleep(2000);
		 boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "kaakarni.pdf", 30);
	        System.out.println("PDF file Downloading Status: " + result); 
		 test.info("Time duration of exporting Karakarni Report: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
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
