package New_property_Wadhghat;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pojo.CMS_browser;
import pom.LoginPage;
import pom.MinorChangesPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class MinorChanges extends BaseDriver {

	StopWatch stopWatch;
	private WebDriver driver = CMS_browser.getDriver();
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
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
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
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
	public void performMinorChangeAndVerify() throws Exception {
	    test = extent.createTest("Perform Minor Change and Verify");
	    stopWatch = new StopWatch();
	    MinorChangesPage minorchange = new MinorChangesPage(driver);
	    
	    // Part 1: Perform Minor Change
	    stopWatch.start();
	    minorchange.MinorChanges_link(url, driver);
	    test.info("Time duration of opening MinorChanges page: " + TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime()) + " sec.");
	    stopWatch.stop();
	    
	    OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
	    offlinepaymentpage.Click_property_no_radio_btn(driver);
	    offlinepaymentpage.Select_node_no(driver, node);
	    offlinepaymentpage.Select_sector_no(driver, sector);
	    offlinepaymentpage.Enter_property_no(driver, PropertyNo);
	    
	    stopWatch.reset();
	    stopWatch.start();
	    offlinepaymentpage.Click_search_property();
	    stopWatch.stop();
	    
	    String beforeChange = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.pass("Befor making changes", MediaEntityBuilder.createScreenCaptureFromBase64String(beforeChange).build());
	    minorchange.Enter_oldPropertyNo(change_oldPropertyNo);
	    minorchange.Enter_SocietyNameMarathi(change_SocietyNameMarathi);
	    minorchange.Enter_SocietyNameEng(change_SocietyNameEng);
	    minorchange.Enter_newCityservey(change_newCityservey);
	    minorchange.Enter_dhukan(change_dhukan);
	    minorchange.Enter_shop(change_shop);
	    minorchange.Enter_patta(change_patta);
	    minorchange.Enter_address(change_address);
	    minorchange.Enter_wingNo(change_wingNo);
	    minorchange.Enter_flatNo(change_flatNo);
	    minorchange.Enter_plotNo(change_plotNo);
	    minorchange.Enter_MobileNo(change_MobileNo);
	    minorchange.Enter_email(change_email);
	    minorchange.Enter_remark(change_remark);
	    
	    String storedMobileNo = MinorChangesPage.getStoredValue("MobileNo"); // Get stored value
	    String storedSocietyNameEng = MinorChangesPage.getStoredValue("SocietyName");
	    String storedDhukanNav = MinorChangesPage.getStoredValue("dhukan");
	
	    
	    String minorchangesImage = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.pass("Minor changes", MediaEntityBuilder.createScreenCaptureFromBase64String(minorchangesImage).build());
	    
	    minorchange.Button_uploadIcon(driver);
	    minorchange.Button_choose_file(System.getProperty("user.dir") + "\\AddTaxes file\\PDFFILE.pdf", driver);
	    minorchange.Button_upload_btn();
	    
	    stopWatch.reset();
	    stopWatch.start();
	    minorchange.Button_ok_btn(driver);
	    
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);"); 
	    minorchange.Buttonr_save_btn(driver);
	    minorchange.Button_yes_btn(driver);
	    minorchange.Button_ok_again_btn(driver);
	    
	    test.info("Time duration of Saving MinorChange Data: " + TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime()) + " sec.");
	    stopWatch.stop();
	    
	    // Part 2: Verify Mobile Number on Counter Payment Screen
	    offlinepaymentpage.offlinePaymentPage(url, driver);
	    offlinepaymentpage.counterPayment(driver, url);
	    offlinepaymentpage.Click_property_no_radio_btn(driver);
	    
	    offlinepaymentpage.Select_node_no(driver, node);
	    offlinepaymentpage.Select_sector_no(driver, sector);
	    offlinepaymentpage.Enter_property_no(driver, PropertyNo1);
	    offlinepaymentpage.Click_search_property();    
	    Thread.sleep(10000);
	    
	    String spanMobileNo = minorchange.getSpanMobileNo(); 
	    String spanSocietyNav = minorchange.getSpanSocietyNav();
	    String spanDukanNav = minorchange.getSpanDukanNav();
	  
	    test.info("Stored Mobile Number in check: " + storedMobileNo);
	    test.info("Stored Society Name in check: " + storedSocietyNameEng);
	    test.info("Stored Dukan Nav in check: " + storedDhukanNav);

	    
	    
	    Assert.assertEquals(spanMobileNo, storedMobileNo);
	    

	    Assert.assertEquals(spanSocietyNav, storedSocietyNameEng, 
	            "The stored Society match the displayed name! "
	            + "Stored: " + storedSocietyNameEng + ", Displayed: " + spanSocietyNav);

	    test.pass("The stored Society Name does not match the displayed name as expected.");

	    Assert.assertEquals(spanDukanNav, storedDhukanNav, 
	            "The stored Dhukan nav should not match the displayed nav! "
	            + "Stored: " + storedDhukanNav + ", Displayed: " + spanDukanNav);
	    
	    test.pass("The stored Dhukan nav does not match the displayed nav as expected.");
	    String minorchangesImage2 = TakeScreenshoot.GetScreenshotFullBase64(driver);
	    test.pass("Counter after minor changes", MediaEntityBuilder.createScreenCaptureFromBase64String(minorchangesImage2).build());
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
		extent.flush();}
	
}
