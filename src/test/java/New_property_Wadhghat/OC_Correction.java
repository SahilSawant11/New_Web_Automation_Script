package New_property_Wadhghat;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
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
import pom.AddTaxesPage;
import pom.ApprovalPage;
import pom.CMS_Page;
import pom.Council_approval;
import pom.CounterPaymentPage;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import pom.OnlineDataEntryPage;
import utility.FileHistory;
import utility.TakeScreenshoot;

public class OC_Correction extends BaseDriver{
	JavascriptExecutor js;
	StopWatch stopWatch;
	String Taxtotal_fromDataentry;
	
	@BeforeTest
	public void beforetest() throws IOException
	{
		stopWatch = new StopWatch();
	}
	
	@Test(priority = 1,enabled=false)
	public void loginPage() throws InterruptedException
	{
		driver.get(url);
		test = extent.createTest("loginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Enter_user_name(userid, driver);
		
		loginpage.Enter_password(password);
		Thread.sleep(10000);
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
	public void ocComplaintRegister() throws InterruptedException, IOException
	{
		test = extent.createTest("OC Complaint Register");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_register_Grievance(driver);
		/////		
		/////
		cmspage.select_node_no(node, driver);
		test.info("Time duration of opening Registration page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		cmspage.select_sector_no(sector, driver);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Enter_property_no(PropertyNo, driver);
	//	PropertyNo = cmspage.Fetch_get_building_no(driver);
		test.info("Time duration of opening New Property PopUp window page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_get_property_btn();

		test.info("Time duration of generating New Property number: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		
		test.info("Property "+ node+""+sector+" - "+PropertyNo);
		FileHistory.FileData(url,node, sector, PropertyNo);

		cmspage.Button_akshep_nondava_btn(driver);
		cmspage.select_aakshep_prakar("OC Correction", driver);
		cmspage.Enter_date(date);
		cmspage.Enter_mobile(mobile);
		cmspage.Enter_remark(cms_remark);
		cmspage.Button_akshep_nondava_btn2(driver);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_yes_btn(driver);
		cmspage.pageloading(driver);
		cmspage.Button_ok_btn(driver);
		akshep_no = cmspage.fetch_akshep_no(driver);
		test.info("Time duration of Successful Complaint Register of Whadhghat: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}

	@Test(priority = 3)
	public void searchComplaintWadhghat() throws InterruptedException
	{
		test = extent.createTest("searchComplaintWadhghat");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		cmspage.Button_filter_btn(driver);
		cmspage.Enter_complaint_Id(driver, akshep_no); //akshep_no
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_Search_property(driver);
		cmspage.icon_pageloading();
		test.info("Time duration of Search Wadhghat Property on CMS Page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		cmspage.Fetch_grievance_id(driver);
		cmspage.Button_grivance_select_btn(driver);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_make_correction_btn(driver);
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Enter_vadhghat_shera(driver);
	}
	
	@Test(priority = 4, dependsOnMethods = "searchComplaintWadhghat")
	public void OC_date_entry() throws InterruptedException
	{
		test = extent.createTest("OC_date_entry");
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Enter_vadhghat_shera(driver);
		test.info("Time duration of Opening Wadhghat Page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		onlinedataentry.Button_building_info_btn(driver);
		Thread.sleep(5000);
		onlinedataentry.Enter_occupancy_date("21/04/2017");
		onlinedataentry.Enter_construction_year("2017");
		onlinedataentry.Save_building_info_btn(driver);
//		Thread.sleep(300000);
		onlinedataentry.Button_building_info_ok_btn(driver);
		Thread.sleep(5000);
		onlinedataentry.Add_taxes_and_upload(driver);
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void AddTaxes_and_UploadFiles() throws InterruptedException
	{
		/////
		stopWatch.reset();
		stopWatch.start();
		test = extent.createTest("AddTaxes_and_UploadFiles");
		AddTaxesPage addtaxespage = new AddTaxesPage(driver);
		addtaxespage.Button_Refresh_Taxes_btn(driver);
		test.info("Time duration of Redirecting Add Taxes Screen: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		Thread.sleep(2000);
		addtaxespage.Button_save_btn(driver);
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Button_DataSaved(driver);
		
		Taxtotal_fromDataentry=addtaxespage.GetValuesElement_taxtotal(driver);
		Thread.sleep(2000);
		addtaxespage.Button_print_approval_btn(driver);
		CounterPaymentPage counterpayment = null;
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "Notesheet.pdf", 30);
        System.out.println("PDF file Downloading Status: " + result); 

		addtaxespage.Scroll_sthalpahani_ahaval(driver);
		addtaxespage.document_upload_wadhaghat_kagadpatra10();
		addtaxespage.Select_choose_file(System.getProperty("user.dir")+"\\AddTaxes file\\PDFFILE.pdf");
		addtaxespage.Button_upload_btn(driver);
	//	onlinedataentry.Button_DataSaved(driver);
		onlinedataentry.Button_building_info_ok_btn(driver);
		addtaxespage.Button_send_to_approval_btn(driver);
	}
	
	@Test(priority = 6)
	public void WadhghatApproval() throws Exception
	{
		test = extent.createTest("WadhghatApproval");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		cmspage.Button_filter_btn(driver);
		cmspage.Enter_complaint_Id(driver, akshep_no);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_Search_property(driver);
		//cmspage.icon_pageloading();
		test.info("Time duration of Search Wadhghat Property on CMS Page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		cmspage.Fetch_grievance_id(driver);
		Thread.sleep(10000);
		cmspage.Button_grivance_select_btn(driver);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_verify_correction_btn(driver);
//		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
//		onlinedataentry.Enter_vadhghat_shera(driver);
		ApprovalPage approvalpage = new ApprovalPage(driver);
		//approvalpage.Approval_link(url, driver);
		
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 0);");
		
		String approvalimage1=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("property info on approval page",MediaEntityBuilder.createScreenCaptureFromBase64String(approvalimage1).build());
		js.executeScript("window.scrollBy(0, 750);");
		
		String approvalimage2=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Owner info on approval screen",MediaEntityBuilder.createScreenCaptureFromBase64String(approvalimage2).build());
		
		js.executeScript("window.scrollBy(0, 600);");
		String approvalimage3=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Tax info on approval screen",MediaEntityBuilder.createScreenCaptureFromBase64String(approvalimage3).build());
		
		approvalpage.Enter_remarks(approvalRemark,driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		approvalpage.Button_ApprovalAll_btn();
		test.info("Time duration of Approval Process: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}
	
	@Test(priority = 7)
	private void councilapproval() throws Exception 
	{
		Thread.sleep(10000);
		//String akshep_no="PNLWG25473";
		test = extent.createTest("Council Approval");
		CMS_Page cmspage = new CMS_Page(driver);
		
		cmspage.councilapproval_link(url, driver);

Council_approval counncil_approval = new Council_approval(driver);
//Thread.sleep(30000);
//counncil_approval.Search_complaint(driver, akshep_no);
//Thread.sleep(30000);
//counncil_approval.clickToOpen(driver);
//Thread.sleep(30000);
//counncil_approval.Fetch_grievance_id(driver);
		
String popup1=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("property details",MediaEntityBuilder.createScreenCaptureFromBase64String(popup1).build());
		
try {
	counncil_approval.Search_complaint(driver, akshep_no);
	String searchedcomplaint=TakeScreenshoot.GetScreenshotFullBase64(driver);
	test.pass("Searched property",MediaEntityBuilder.createScreenCaptureFromBase64String(searchedcomplaint).build());
	counncil_approval.clickToOpen(driver);
} catch (Exception e) {
	// TODO: handle exception
}

counncil_approval.clicknext(driver);
String popup2=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("floor details",MediaEntityBuilder.createScreenCaptureFromBase64String(popup2).build());

counncil_approval.clicknext(driver);
String popup3=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("Old Property Information",MediaEntityBuilder.createScreenCaptureFromBase64String(popup3).build());
	
counncil_approval.clicknext(driver);

String popup4=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("Pending Tax Details || Current Tax Details || Appeal Tax Details",MediaEntityBuilder.createScreenCaptureFromBase64String(popup4).build());
	
counncil_approval.clicknext(driver);	
String popup5=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("Bill Transaction Council Act 129",MediaEntityBuilder.createScreenCaptureFromBase64String(popup5).build());
	
counncil_approval.clicknext(driver);	
String popup6=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("WadhGhat Collection Details",MediaEntityBuilder.createScreenCaptureFromBase64String(popup6).build());
	
counncil_approval.clicknext(driver);
String popup7=TakeScreenshoot.GetScreenshotFullBase64(driver);
test.pass("Special Discount",MediaEntityBuilder.createScreenCaptureFromBase64String(popup7).build());
	
counncil_approval.Enter_remark(driver);
counncil_approval.clickOnapproval(driver);

	System.out.println(node+sector+PropertyNo);
	
	Thread.sleep(20000);

	}
	
	@Test(priority = 8)
	private void checkTaxesOnCounter() throws Exception 
	{
		test = extent.createTest("Check Taxes Rates after OC");
		CounterPaymentPage counterpayment = null;

		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node);
		offlinepaymentpage.Select_sector_no(driver, sector);
		offlinepaymentpage.Enter_property_no(driver,PropertyNo);
		offlinepaymentpage.Click_search_property();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
		
		counterpayment = new CounterPaymentPage(driver);
//		offlinepaymentpage.checkTaxesRate(driver);
//		test.info("a / c = " + offlinepaymentpage.getADivC());
//	    test.info("b / c = " + offlinepaymentpage.getBDivC());
//	    test.info("(a + b) / c = " + offlinepaymentpage.getAPlusBDivC());
//	    double actualValue = offlinepaymentpage.getAPlusBDivC(); 
//	    double expectedValue = 7.0;
//	    double delta = 0.001; 
//	    assertEquals(actualValue, expectedValue, delta, "The calculated tax rate is not equal to 7.0");
//	    test.info("Assert Pass : Calculated (a + b) / c = " + actualValue);
		String PropertyOnCounter=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("New created Property ",MediaEntityBuilder.createScreenCaptureFromBase64String(PropertyOnCounter).build());
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
}
