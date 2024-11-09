package PCMC_All_Tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
import pom.LoginPage;
import pom.PCMC_ReportPage;
import utility.TakeScreenshoot;

public class PCMC_ReportTest extends BaseDriver{
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
/*	@BeforeTest
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
*/	
	@Test(priority = 1, enabled=false)
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
	
	@Test//(priority =2)
	public void challan_report_for_cash() throws Exception {
		test= extent.createTest("Challan report for cash");
		PCMC_ReportPage reportpage = new PCMC_ReportPage(driver);
		reportpage.Pcmc_Report_Page_link(url, driver);
		reportpage.select_zone_wakad(driver);
		reportpage.select_challan_option(driver);
		
//		date is already present
//		LocalDate today = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String formattedDate = today.format(formatter);
//	    reportpage.enter_todays_date(driver, formattedDate);
	    
		reportpage.select_cash_option(driver);
		Thread.sleep(10000);
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.log(null, "Taking Challan Reports", MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
		reportpage.Click_generate_btn(driver);
		Thread.sleep(10000);
		
	
	}
	
	@Test//(priority =3)
	public void challan_report_for_cheque() throws Exception {
		test= extent.createTest("Challan report for cheque");
		PCMC_ReportPage reportpage = new PCMC_ReportPage(driver);
		reportpage.Pcmc_Report_Page_link(url, driver);
		reportpage.select_zone_wakad(driver);
		reportpage.select_challan_option(driver);
		
//		date is already present
//		LocalDate today = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String formattedDate = today.format(formatter);
//	    reportpage.enter_todays_date(driver, formattedDate);
	    
		reportpage.select_cheque_option(driver);
		Thread.sleep(10000);
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.log(null, "Taking Challan Reports", MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
		reportpage.Click_generate_btn(driver);
		Thread.sleep(10000);
		
	
	}
	
	@Test//(priority =4 )
	public void headwise_report_for_cash() throws Exception {
		test= extent.createTest("Headwise report for cash");
		PCMC_ReportPage reportpage = new PCMC_ReportPage(driver);
		reportpage.Pcmc_Report_Page_link(url, driver);
		reportpage.select_zone_wakad(driver);
		reportpage.select_headwise_option(driver);
		reportpage.select_cash_option(driver);
		Thread.sleep(10000);
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.log(null, "Taking Headwise Reports", MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());
		reportpage.Click_generate_btn(driver);
		Thread.sleep(10000);
		
	
	}
	
	@Test//(priority=5)
	public void bharna_report_for_all_modes() throws Exception {
		test= extent.createTest("Bharna report for all nodes");
		PCMC_ReportPage reportpage = new PCMC_ReportPage(driver);
		reportpage.Pcmc_Report_Page_link(url, driver);
		reportpage.Click_other_txn(driver);
		Thread.sleep(5000);
		reportpage.select_zone_wakad(driver);
		reportpage.enter_specific_date(driver, specificDate);
		reportpage.Select_all_payment_modes(driver);
		Thread.sleep(10000);
		String counterpaymentscreen=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.log(null, "Taking Bharna Reports", MediaEntityBuilder.createScreenCaptureFromBase64String(counterpaymentscreen).build());	
		reportpage.Click_generate_btn(driver);
		Thread.sleep(10000);
		
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