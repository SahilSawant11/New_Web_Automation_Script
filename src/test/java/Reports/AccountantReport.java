package Reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom.AccountantReportPage;
import pom.CollectionReportsPage;
import pom.CounterPaymentPage;
import pom.LoginPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class AccountantReport extends BaseDriver{
	JavascriptExecutor js;
	StopWatch stopWatch;
	WebDriver driver;
	
	
	
	@Test(priority = 2)
	public void collectiontest() throws InterruptedException {
		test = extent.createTest("Collection Report");
		Thread.sleep(5000);
		AccountantReportPage accountantreport = new AccountantReportPage(driver);
		accountantreport.AccountantReports_link(url, driver);
		accountantreport.Zone_Office_Report_btn(driver);
		
		
	}
}
