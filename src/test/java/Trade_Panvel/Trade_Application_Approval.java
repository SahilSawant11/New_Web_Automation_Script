package Trade_Panvel;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import pojo.CMS_browser;
import pom_TradeLicense.ApplicationApprovalPage;
import pom_TradeLicense.DataEntryPage_TradeLicense;
import pom_TradeLicense.LoginPage_TradeLicense;
import pom_TradeLicense.PaymentPage_TradeLicense;
import utility.TakeScreenshoot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Trade_Application_Approval extends BaseDriver {
	
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
	
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(spark);
		BaseDriver.GetData();
		driver = CMS_browser.openBrowser("https://test.tradepanvelmc.org/Login");
		stopWatch = new StopWatch();	
	}
	
	@Test(priority = 1)
	public void loginPage() throws InterruptedException
	{
		test = extent.createTest("loginPage");
		LoginPage_TradeLicense loginpage = new LoginPage_TradeLicense(driver);
		loginpage.Enter_user_name(userid, driver);
		loginpage.Enter_password(password);
		loginpage.Click_login_btn(driver);
		
		try
		{
		//	loginpage.click_logout(driver);
			loginpage.Enter_user_name("abhilash.m", driver);
			loginpage.Enter_password("shritejm@123");
			loginpage.Click_login_btn(driver);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority = 2)
	public void dataEntry() throws Exception
	{
		test = extent.createTest("Data Entry");
		DataEntryPage_TradeLicense dataentrypage = new DataEntryPage_TradeLicense(driver);

		dataentrypage.DataEntry_Page_link(url, driver);
		dataentrypage.select_node_no(driver);
		dataentrypage.select_sector_no( driver);
		dataentrypage.enter_property_no(driver);
		Thread.sleep(5000);
		dataentrypage.scroll_to_bottom(driver);
		dataentrypage.search_property(driver);
		Thread.sleep(5000);
		dataentrypage.scroll_to_top(driver);
		application_no = dataentrypage.fetch_application_no(driver);
		System.out.println("Fetched Application Number: " + application_no);
		dataentrypage.scrollbypixdown(driver);
		dataentrypage.clickDeleteOwners(driver, 90400, 90500);
	//	dataentrypage.clickDeleteOwner2(driver, 90400, 90500);
		
		dataentrypage.scrollbypixup(driver);
		dataentrypage.Enter_Englishname(occupier_name);
		dataentrypage.Enter_Marathiname(ferfar_kardharak);
		dataentrypage.Enter_mail(change_email);
		dataentrypage.Enter_phone(mobile);
		dataentrypage.Enter_Adhaar(adhaar);
		dataentrypage.Enter_Pan(pan);
		dataentrypage.select_district(driver);
		dataentrypage.Enter_City(city);
		dataentrypage.Enter_Pincode(pin);
		dataentrypage.Enter_Wing(wing);
		dataentrypage.Enter_Plot(plot_no);
		dataentrypage.Enter_Flat(flatno);
		dataentrypage.Enter_SocietyName(societyname);
		
		
		dataentrypage.Enter_address(address);
		dataentrypage.Click_add_more(driver);
		
		dataentrypage.scrollbypixdown(driver);
		
		dataentrypage.Enter_socName(societyname);
		dataentrypage.select_business_type(driver);		
		dataentrypage.select_license_type(driver);
		dataentrypage.select_property_type(driver);
		dataentrypage.select_license_period(driver);
		dataentrypage.select_premise_type(driver);
		dataentrypage.select_nature_of_trade(driver);
		dataentrypage.Enter_TotalAre("50");
		dataentrypage.select_business_of_style(driver);
		dataentrypage.select_status(driver);
		dataentrypage.Enter_CommenceDate("04052017");
		dataentrypage.select_oc(driver);
		dataentrypage.Enter_OCdate("04052017");
		dataentrypage.Enter_gst(change_MobileNo);
		dataentrypage.Enter_mail_business(change_email);
		dataentrypage.Enter_landline(mobile);
		dataentrypage.Enter_mobile(mobile);
		dataentrypage.Enter_adhaar(adhaar);
		dataentrypage.Enter_pan(pan);
		dataentrypage.Enter_wing(wing);
		dataentrypage.Enter_shopno(shop_flat_no);
		dataentrypage.Enter_socName(societyname);
		dataentrypage.Enter_address_bussiness(address);
		dataentrypage.Enter_plot(plot_no);
		

		dataentrypage.scroll_to_bottom(driver);

		dataentrypage.Button_choose_file(System.getProperty("user.dir") + "\\AddTaxes file\\PDFFILE.pdf",driver);
		dataentrypage.Click_agree_btn(driver);
		String firstWindowHandle = driver.getWindowHandle();
		dataentrypage.Click_submit_btn(driver);
		Thread.sleep(5000);
		driver.switchTo().window(firstWindowHandle);
		Thread.sleep(5000);
		dataentrypage.Click_print_btn(driver);
		driver.switchTo().window(firstWindowHandle);
	}

	@Test(priority = 3)
	public void applicationapproval1() throws Exception
	{

		test = extent.createTest("First Application Approval");
		ApplicationApprovalPage approvalpage = new ApplicationApprovalPage(driver);

		approvalpage.Application_Approval_Page_link(url, driver);
		approvalpage.Search_application(driver, application_no);
		approvalpage.Button_show_btn(driver);
		String actualTax = approvalpage.get_tax(driver);
		String actualEmail = approvalpage.get_email(driver);
		String actualAddress = approvalpage.get_address(driver);
		String actualMobile = approvalpage.get_mobile(driver);
		String expectedTax = "1400";
		String expectedEmail = "abc@gmail.com";
		String expectedAddress = "Address";
		String expectedMobile = "1111111111";
		assertEquals(actualTax, expectedTax,"values dont match");
		test.info("Tax match the expected tax of Rs. 1400");
		assertEquals(actualEmail, expectedEmail,"values dont match");
		test.info("Email ID match");
		assertEquals(actualAddress, expectedAddress,"values dont match");
		test.info("Address match");
		assertEquals(actualMobile, expectedMobile,"values dont match");
		test.info("Mobile no. match");
		approvalpage.Enter_remark(driver);
		approvalpage.Button_arjavhal_btn(driver);
		approvalpage.Button_approved1_btn(driver);
	}
	
	@Test(priority = 4)
	public void applicationapproval2() throws Exception
	{
		test = extent.createTest("Second Application Approval");
		ApplicationApprovalPage approvalpage = new ApplicationApprovalPage(driver);

		approvalpage.Application_Approval_Page_link(url, driver);
		approvalpage.Search_application(driver, application_no);
		approvalpage.Button_show_btn(driver);
		approvalpage.Enter_remark(driver);
		approvalpage.Button_arjavhal_btn(driver);
		approvalpage.Button_approved1_btn(driver);
		
	}
	
	@Test(priority = 5)
	public void licensepayment() throws Exception
	{

		test = extent.createTest("License Payment");
		PaymentPage_TradeLicense paypage = new PaymentPage_TradeLicense(driver);
		paypage.Payment_Page_link(url, driver);
		paypage.Search_application(driver, application_no);
		paypage.Button_search_btn(driver);
		paypage.Button_pay_btn(driver);
		paypage.Enter_email(driver, change_email);
		paypage.Enter_billbook(driver);
		paypage.Enter_billbookbox(driver);
		paypage.Button_paynow_btn(driver);
		paypage.Download_reciept(driver);
		
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
