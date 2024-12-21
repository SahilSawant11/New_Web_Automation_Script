package Water_Panvel;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import New_property_Wadhghat.BaseDriver;
import pom_WaterTax.AddReadingPage_Water;
import pom_WaterTax.DashboardPage_Water;
import pom_WaterTax.DataEntryPage_Water;
import pom_WaterTax.DataEntryScreen_Water;
import pom_WaterTax.LoginPage_Water;
import pom_WaterTax.MeterPage_Water;
import pom_WaterTax.OfflinePaymentPage_Water;
import utility.TakeScreenshoot;

public class CMS_Water_Niyamit extends BaseDriver{
	
	TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
	private String grievanceID;
	private String consumerID;
	private String meter1;
	private String meter2;
	private String connection1;
	private String connection2;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		stopWatch = new StopWatch();	
	}
	
	@Test(priority = 1 , enabled = false)
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
	public void registercomplaint() throws Exception
	{
		test = extent.createTest("Register New Complaint");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		Thread.sleep(15000); // Temporary wait to change the url from https to http manually
		dashboardwater.Click_takraar_nondva(driver);
		dashboardwater.Select_application_type(driver);
		dashboardwater.Click_new_application(driver);
		dashboardwater.Enter_marathi_name(marathi_name);
		dashboardwater.Enter_marathi_address(marathi_address);
		dashboardwater.Enter_english_name(english_name);
		dashboardwater.Enter_english_address(english_address);
		dashboardwater.Enter_mobile(mobile);
		dashboardwater.Select_complaint_type(driver);
		dashboardwater.Enter_remark(approvalRemark);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Complaint info",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
		dashboardwater.Click_save_complaint(driver);
		Thread.sleep(5000);
		dashboardwater.Click_close_btn();
		grievanceID = dashboardwater.fetch_id(driver);
		
	}
	
	@Test(priority = 3 , dependsOnMethods = "registercomplaint")
	public void opencomplaint_for_dataentry() throws Exception
	{
		test = extent.createTest("OPEN COMPLAINT FOR DATA ENTRY");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		dashboardwater.DashBoard_Page_link(url, driver);
		Thread.sleep(15000); // Temporary wait to change the url from https to http manually
		dashboardwater.Enter_grievance_id(grievanceID);
		Thread.sleep(2000);
		dashboardwater.Click_open_complaint(driver);
		Thread.sleep(5000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Complaint Opened for Data Entry",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	}
	
	@Test(priority = 4 , dependsOnMethods = "opencomplaint_for_dataentry")
	public void dataentry_niyamit() throws Exception
	{
		test = extent.createTest("DATA ENTRY OF NIYAMIT");
		DataEntryPage_Water dataentry = new DataEntryPage_Water(driver);
		dataentry.Select_application_type(driver);
		dataentry.Enter_marathi_name(renter_name_marathi);
		dataentry.Enter_shop_name_marathi(change_SocietyNameMarathi2);
		dataentry.Enter_marathi_address(address);
		dataentry.Enter_name(occupier_name);
		dataentry.Enter_address(address);
		dataentry.Enter_shop_name(shop_building_name);
		dataentry.Enter_pin(pin);
		dataentry.Enter_adhaar(adhaar);
		dataentry.Enter_mobile(mobile);
		dataentry.Enter_mail(mail);
		dataentry.Enter_gov_no(change_flatNo);
		dataentry.Enter_no_of_connections(zone_no);
		dataentry.Enter_no_of_families("5");
		dataentry.Enter_no_of_persons("5");
		dataentry.Enter_no_of_toilets("10");
		dataentry.Enter_water_ward_no("7");
		dataentry.Enter_block_no("5");
		dataentry.Click_emaarat(driver);
		dataentry.Select_vibhaag(driver);
		dataentry.Select_bhaag(driver);
		dataentry.Select_building_type(driver);
		dataentry.Select_category_niyamit(driver);
		dataentry.Select_connection_size_six(driver);
		dataentry.Select_use(driver);
		dataentry.Click_upload_btn(driver);
		dataentry.Button_choose_file(System.getProperty("user.dir") + "\\AddTaxes file\\PDFFILE.pdf",driver);
		Thread.sleep(2000);
		dataentry.Click_popup_upload_btn();
		Thread.sleep(2000);
		dataentry.Click_yes_btn();
		Thread.sleep(2000);
		dataentry.Click_ok_btn();
		dataentry.Click_save_btn();
		Thread.sleep(2000);
		dataentry.Click_notesheet_btn();
		Thread.sleep(2000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.info("NoteSheet",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
		dataentry.Click_close_btn();
		Thread.sleep(2000);
		dataentry.Click_upload_notesheet_btn();
		Thread.sleep(2000);
		dataentry.Button_choose_file_2(System.getProperty("user.dir") + "\\AddTaxes file\\PDFFILE.pdf",driver);
		Thread.sleep(2000);
		dataentry.Click_popup_upload_btn2();
		Thread.sleep(2000);
		dataentry.Click_yes_btn();
		Thread.sleep(2000);
//		dataentry.Click_ok_btn();
	}
	
	@Test(priority = 5 , dependsOnMethods = "dataentry_niyamit")
	public void opencomplaint_for_approval() throws Exception
	{
		test = extent.createTest("OPEN COMPLAINT FOR APPROVAL");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		dashboardwater.DashBoard_Page_link(url, driver);
		Thread.sleep(15000); // Temporary wait to change the url from https to http manually
		dashboardwater.Select_complaint_status_approval(driver);
		dashboardwater.Click_filter_btn();
		Thread.sleep(2000);
		dashboardwater.Enter_grievance_id(grievanceID);
		Thread.sleep(2000);
		dashboardwater.Click_open_complaint(driver);
		Thread.sleep(5000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Complaint Opened for Approval",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	}
	
	@Test(priority = 6 , dependsOnMethods = "opencomplaint_for_approval")
	public void approval()throws Exception
	{
		test = extent.createTest("Approval");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		dashboardwater.Select_tap_size(driver);
		Thread.sleep(2000);
		dashboardwater.Enter_remark(approvalRemark);
		dashboardwater.Click_approve_btn();
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.info("Complaint Approved",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
		dashboardwater.Click_approval_close_btn();
	}
	
	@Test(priority = 7 , dependsOnMethods = "approval")
	public void makepayment() throws Exception
	{
		//String fetch_id = "WT0022502";
		test = extent.createTest("Make Application Payment");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		dashboardwater.DashBoard_Page_link(url, driver);
		Thread.sleep(15000); // Temporary wait to change the url from https to http manually
		dashboardwater.Select_complaint_status_make_payment(driver);
		dashboardwater.Click_filter_btn();
		Thread.sleep(2000);
		dashboardwater.Enter_grievance_id(grievanceID);
		Thread.sleep(2000);
		dashboardwater.Click_open_complaint(driver);
		Thread.sleep(5000);
		dashboardwater.Click_pay_btn();
		dashboardwater.Select_billbook(driver);
		dashboardwater.Select_mode_cash(driver);
		dashboardwater.Click_paynow_btn();
		Thread.sleep(5000);
		dashboardwater.Click_download_btn(driver);
		Thread.sleep(5000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Payment Reciept",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
		dashboardwater.Click_close_btn();
		dashboardwater.Click_search_btn();
	}
	
	@Test(priority = 8 , dependsOnMethods = "makepayment")
	public void opencomplaint_for_meter() throws Exception
	{
//		String fetch_id = "WT0031457";
		test = extent.createTest("OPEN COMPLAINT FOR APPROVAL");
		DashboardPage_Water dashboardwater = new DashboardPage_Water(driver);
		dashboardwater.DashBoard_Page_link(url, driver);
		Thread.sleep(15000); // Temporary wait to change the url from https to http manually
		dashboardwater.Select_complaint_status_meter_pending(driver);
		dashboardwater.Click_filter_btn();
		Thread.sleep(2000);
		dashboardwater.Enter_grievance_id(grievanceID);
		Thread.sleep(2000);
		dashboardwater.Click_open_complaint(driver);
		Thread.sleep(5000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Complaint Opened for Adding Meter Details",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	}	
	
	@Test(priority = 9 , dependsOnMethods = "opencomplaint_for_meter")
	public void meter_details() throws Exception
	{
		test = extent.createTest("METER Details");
		MeterPage_Water meterpage = new MeterPage_Water(driver);
		consumerID =meterpage.Get_Consumer_id();
		meterpage.Enter_meter_no("");
		meterpage.Enter_meter_company("test-company");
		meterpage.Enter_meter_cost("999");
		meterpage.Enter_reading_before("10");
		meterpage.Enter_reading_after("20");
		meterpage.Enter_max_reading("100");
		meterpage.Enter_meter_remark(approvalRemark);
		meterpage.Click_recieve_date_box();
		meterpage.Click_test_date_box();
		meterpage.Select_tap_size_six(driver);
		meterpage.Select_meter_status_start(driver);
		meterpage.Select_meter_test_yes(driver);
		meterpage.Click_upload_btn(driver);
		meterpage.Button_choose_file(System.getProperty("user.dir") + "\\AddTaxes file\\PDFFILE.pdf",driver);
		Thread.sleep(2000);
		meterpage.Click_popup_upload_btn();
		Thread.sleep(2000);
		meterpage.Click_yes_btn();
		Thread.sleep(2000);
		meterpage.Click_ok_btn();
		meterpage.Click_save_btn();
		Thread.sleep(5000);
		meterpage.Click_karyadesh(driver);
		Thread.sleep(5000);
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
		meterpage.Click_close_btn();
		test.pass("Adding Meter Details",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	}	
	
	@Test (priority = 10 , dependsOnMethods = "meter_details")
	public void add_reading() throws Exception
	{
//		String consumerID = "CNB100B0063220";
	 	test = extent.createTest("Add Reading");
	 	AddReadingPage_Water readingpage = new AddReadingPage_Water(driver);
	 	readingpage.AddReading_Page_link(url, driver);
	 	readingpage.Enter_consumer_no(consumerID);
	 	readingpage.Click_search_btn();
	 	Thread.sleep(5000);
	 	readingpage.Enter_last_reading_date("09/11/2024");
	 	readingpage.Click_current_reading_date();
	 	readingpage.Enter_current_reading("35");
	 	readingpage.Click_add_btn();
	 	Thread.sleep(2000);
	 	String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
	 	readingpage.Click_yes_btn();
	 	test.pass("Reading Details",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	 }

	@Test (priority = 10 , dependsOnMethods = "add_reading" )
	public void reading_approval() throws Exception
	{
//		String consumerID = "CNB100B0063223";
	 	test = extent.createTest("Reading Approval");
	 	AddReadingPage_Water readingpage = new AddReadingPage_Water(driver);
	 	readingpage.ReadingApproval_Page_link(url, driver);
	 	readingpage.Enter_consumer_no(consumerID);
	 	readingpage.Click_search_btn_approval();
	 	Thread.sleep(2000);
	 	String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
	 	test.info( "Reading Searched",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	 	Thread.sleep(2000);
	 	readingpage.Click_checkall(driver);
	 	readingpage.Click_approved();
	 	Thread.sleep(2000);
	 	readingpage.Click_yes_btn();
	 }
	
	@Test(priority = 11)
	public void open_counter() throws Exception 
	{
		String consumerID = "CNB100B0063239";
		extent.createTest("Open Connection on Counter");
		OfflinePaymentPage_Water offlinepaymentpage = new OfflinePaymentPage_Water(driver);
		offlinepaymentpage.OfflinePayment_Page_link(url, driver);
		offlinepaymentpage.Enter_scansearch(consumerID);
		Thread.sleep(2000);
		offlinepaymentpage.printLabelTexts_counter();
		meter1 = offlinepaymentpage.meterStatus();
		connection1 = offlinepaymentpage.connectionStatus();
		String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
	 	test.info( "Connection openned on Counter",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());

	}
	
	@Test(priority = 12 , dependsOnMethods = "open_counter")
	public void cash_payment() throws Exception 
	{
		extent.createTest("Water Tax Payment in Cash");
		OfflinePaymentPage_Water offlinepaymentpage = new OfflinePaymentPage_Water(driver);
	 	offlinepaymentpage.Click_makepayment_btn();
	 	Thread.sleep(5000);
	 	offlinepaymentpage.Enter_mobile(mobile);
	 	offlinepaymentpage.Select_billbook(driver);
	 	offlinepaymentpage.Click_paynow_btn();
	 	Thread.sleep(10000);
	 	offlinepaymentpage.Click_downloadreciept_btn();
	 	Thread.sleep(5000);
	 	String image=TakeScreenshoot.GetScreenshotFullBase64(driver);
	 	test.info( "Reciept",MediaEntityBuilder.createScreenCaptureFromBase64String(image).build());
	 	offlinepaymentpage.Click_close_btn();
	}
	
	@Test(priority = 13)
	public void open_dataEntryPage() throws Exception
	{
		String consumerID = "CNB100B0063239";
		extent.createTest("Open Connection on Data Entry Page");
		DataEntryScreen_Water dataenrtyscreen = new DataEntryScreen_Water(driver);
		SoftAssert softAssert = new SoftAssert();
		dataenrtyscreen.DataEntry_Screen_link(url, driver);
		dataenrtyscreen.enterConsumerNo(consumerID);
		dataenrtyscreen.clickSearchButton();
		Thread.sleep(5000);
		
		meter2 = dataenrtyscreen.meterStatus();
		connection2 = dataenrtyscreen.connectionStatus();
		System.out.println("Counter Meter Status :" + meter1);
		System.out.println("Data Entry Meter Status :" + meter2);
		softAssert.assertEquals(meter2, meter1, "Meter statuses do not match!");
	    softAssert.assertEquals(connection2, connection1, "Connection statuses do not match!");
	    softAssert.assertAll();
		dataenrtyscreen.printLabelTexts_dataEntry();
		
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
