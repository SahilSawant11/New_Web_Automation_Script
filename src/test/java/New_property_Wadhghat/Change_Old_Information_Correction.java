package New_property_Wadhghat;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
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
import pom.OldTaxesPage;
import pom.OnlineDataEntryPage;
import utility.FileHistory;
import utility.TakeScreenshoot;

public class Change_Old_Information_Correction extends BaseDriver{

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
	
	@Test(priority = 2, enabled= false)
	private void SearchOnCounter1() throws Exception 
	{
		test = extent.createTest("Counter after changing Old Information");
		CounterPaymentPage counterpayment = null;

		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node);
		offlinepaymentpage.Select_sector_no(driver, sector);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo);
		offlinepaymentpage.Click_search_property();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		
		counterpayment = new CounterPaymentPage(driver);
	//	counterpayment.Select_Finalcheckbox(driver);
		
		String PropertyOnCounter=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("New created Property ",MediaEntityBuilder.createScreenCaptureFromBase64String(PropertyOnCounter).build());
	}
	
	@Test(priority = 3 , enabled=false)
	public void wadhghatComplaintRegister() throws InterruptedException, IOException
	{
		test = extent.createTest("Old Information Complaint Register");
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
		cmspage.select_aakshep_prakar(cms_aakshep_prakar_wadhghat, driver);
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

	@Test(priority = 4)
	public void searchComplaintWadhghat() throws InterruptedException
	{
		String akshep_no = "PNLWG25610";
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
	
	@Test(priority = 5)
	public void OldTaxex_info() throws Exception
	{
		/////
		stopWatch.reset();
		stopWatch.start();
		test = extent.createTest("OldTaxex_info");
		OldTaxesPage oldtaxespage = new OldTaxesPage(driver);
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Button_old_information_btn(driver);
		oldtaxespage.Enter_oldWardNo(oldWardNo, driver);
		test.info("Time duration of Redirecting to oldTaxesPage: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		oldtaxespage.Enter_oldPropertyNo(oldPropertyNo);
		oldtaxespage.Enter_oldPartitionNo(oldPartitionNo);
		oldtaxespage.Enter_oldCityServey(oldCityServey);
		oldtaxespage.Enter_oldRV(oldRV);
		oldtaxespage.Enter_oldPropertyTax(oldPropertyTax);
		oldtaxespage.Enter_oldTaxTotal(oldTaxTotal);
		
		oldtaxespage.Enter_oldYear(String.valueOf(financeYear-1));
		oldtaxespage.Enter_propTax(propTax);
		oldtaxespage.Enter_EduTax(EduTax);
		oldtaxespage.Enter_spEduTax(spEduTax);
		oldtaxespage.Enter_EmpTax(EmpTax);
		oldtaxespage.Enter_treeCess(treeCess);
		oldtaxespage.Enter_fireCess(fireCess);
		oldtaxespage.Enter_lightCess(lightCess);
		oldtaxespage.Enter_drainCess(drainCess);
		oldtaxespage.Enter_roadCess(roadCess);
		oldtaxespage.Enter_sanitation(sanitation);
		oldtaxespage.Enter_waterCess(waterCess);
		oldtaxespage.Enter_waterBenifit(waterBenifit);
		oldtaxespage.Enter_waterBill(waterBill);
		oldtaxespage.Enter_Mbuilding(Mbuilding);
		oldtaxespage.Enter_sewage(sewage);
		oldtaxespage.Enter_Tax1(Tax1);
		oldtaxespage.Enter_Tax2(Tax2);
		oldtaxespage.Enter_Tax3(Tax3);
		oldtaxespage.Enter_interest(interest);
		oldtaxespage.Enter_remark(oldRemark);
		
		oldtaxespage.Button_addOldTaxes_btn(driver);
		String oldinfoImage=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Entered Old info",MediaEntityBuilder.createScreenCaptureFromBase64String(oldinfoImage).build());
		
		/////
		stopWatch.reset();
		stopWatch.start();
		oldtaxespage.Button_saveOldTaxes_btn(driver);
		
		
		onlinedataentry.Button_DataSaved(driver);
		
		oldtaxespage.Button_addTaxes_btn(driver);
		test.info("Time duration of Saving oldTaxes: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}
		
	@Test(priority = 6)
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
		addtaxespage.Button_save_btn2(driver);
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Button_DataSaved(driver);
		
		Taxtotal_fromDataentry=addtaxespage.GetValuesElement_taxtotal(driver);
		
		addtaxespage.Button_print_approval_btn(driver);
		CounterPaymentPage counterpayment = null;
		boolean result = 		counterpayment.isFileDownloaded("pdffile.pdf", "Notesheet.pdf", 30);
        System.out.println("PDF file Downloading Status: " + result); 

		addtaxespage.Scroll_sthalpahani_ahaval(driver);
		addtaxespage.document_upload_wadhaghat_kagadpatra10();
		addtaxespage.Select_choose_file(System.getProperty("user.dir")+"\\AddTaxes file\\PDFFILE.pdf");
		addtaxespage.Button_upload_btn(driver);
		onlinedataentry.Button_DataSaved(driver);
		addtaxespage.Button_send_to_approval_btn(driver);
	}
	
	@Test(priority = 7)
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
	
	@Test(priority = 8)
	private void councilapproval() throws Exception 
	{
		Thread.sleep(10000);
		//String akshep_no="PNLWG25473";
		test = extent.createTest("Council Approval");
		CMS_Page cmspage = new CMS_Page(driver);
		
		cmspage.councilapproval_link(url, driver);

Council_approval counncil_approval = new Council_approval(driver);
Thread.sleep(20000);
counncil_approval.Search_complaint(driver, akshep_no);
Thread.sleep(20000);
counncil_approval.clickToOpen(driver);
Thread.sleep(20000);
counncil_approval.Fetch_grievance_id(driver);
		
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
	
	@Test(priority = 9)
	private void SearchOnCounter2() throws Exception 
	{
		test = extent.createTest("Counter after changing Old information");
		CounterPaymentPage counterpayment = null;

		OfflinePaymentPage offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.offlinePaymentPage(url, driver);
		offlinepaymentpage = new OfflinePaymentPage(driver);
		offlinepaymentpage.counterPayment(driver, url);
		offlinepaymentpage.Click_property_no_radio_btn(driver);
			
		offlinepaymentpage.Select_node_no(driver, node);
		offlinepaymentpage.Select_sector_no(driver, sector);
		offlinepaymentpage.Enter_property_no(driver, PropertyNo);
		offlinepaymentpage.Click_search_property();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		
		counterpayment = new CounterPaymentPage(driver);
		
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
