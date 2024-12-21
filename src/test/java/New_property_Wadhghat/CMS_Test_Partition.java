package New_property_Wadhghat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pom.AddTaxesPage;
import pom.ApprovalPage;
import pom.CMS_Page;
import pom.Council_approval;
import pom.OldTaxesPage;
import pom.OnlineDataEntryPage;
import utility.FileHistory;
import utility.TakeScreenshoot;

public class CMS_Test_Partition extends BaseDriver {
	
	JavascriptExecutor js;
	StopWatch stopWatch;
	
	//taxex check
	String Taxtotal_fromDataentry;

	@BeforeTest
	public void beforetest() throws IOException
	{

		stopWatch = new StopWatch();
		
	}
	
	@Test(priority = 2)
	public void cmsPageWadhghat() throws InterruptedException
	{
		test = extent.createTest("cmsPageWadhghat");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Button_register_Grievance(driver);
		/////
	}
	
	@Test(priority = 3)
	public void cmsRegisterPageWadhghat_Partition() throws Exception
	{
//		String PropertyNo = "91";
		test = extent.createTest("cmsRegisterPageWadhghat-Partition");
		CMS_Page cmspage = new CMS_Page(driver);
		
		/////
		cmspage.select_node_no(node, driver);
		test.info("Time duration of opening Registration page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		cmspage.select_sector_no(sector, driver);
		
		/////
		stopWatch.reset();
		stopWatch.start();
		
		cmspage.Button_new_property_btn();
		
		cmspage.Enter_building_no(PropertyNo);
		
		Thread.sleep(5000);
		
		cmspage.Enter_to_prop("1");
		
		Thread.sleep(2000);
		
		cmspage.Click_Property_btn();
		
		test.info("Time duration of opening New Property PopUp window page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		/////
		stopWatch.reset();
		stopWatch.start();
		cmspage.Display_akshep_nondava_btn(driver);
		test.info("Time duration of generating New Property number: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		
		test.info("Property "+ node+""+sector+" - "+PropertyNo+" - "+ "1");
		FileHistory.FileData(url,node, sector, PropertyNo);
	}
	
	@Test(priority = 4, dependsOnMethods = "cmsRegisterPageWadhghat_Partition")
	public void cmsComplaintRegisterWadhghat_Partition() throws InterruptedException
	{
		test = extent.createTest("cmsComplaintRegisterWadhghat-Partition");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.Button_akshep_nondava_btn(driver);
		cmspage.select_aakshep_prakar(cms_aakshep_prakar, driver);
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
	
	@Test(priority = 5,  dependsOnMethods = "cmsComplaintRegisterWadhghat_Partition")
	public void searchComplaintWadhghat_Partition() throws InterruptedException
	{
		test = extent.createTest("searchComplaintWadhghat");
		CMS_Page cmspage = new CMS_Page(driver);
		cmspage.CMS_link(url, driver);
		cmspage.Button_filter_btn(driver);
		cmspage.Enter_complaint_Id(driver, akshep_no);
		
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
	
	
	@Test(priority = 6, dependsOnMethods = "searchComplaintWadhghat_Partition")
	public void Dataentry_owner_info_Partition() throws InterruptedException
	{
		test = extent.createTest("Dataentry_owner_info-Partition");
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Enter_vadhghat_shera(driver);
		test.info("Time duration of Opening Wadhghat Page: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
		
		onlinedataentry.Click_remove_owner_check_box(driver);
		onlinedataentry.Select_shirshak_kardharak(shirshak_kardharak);
		onlinedataentry.Enter_kardharak(kardharak);
		onlinedataentry.Enter_ptta(ptta);
		onlinedataentry.Enter_dukan_imarat_nav(dukan_imarat_nav);
		onlinedataentry.Enter_dukan_flat_no(dukan_flat_no);
		onlinedataentry.Select_title(title);
		onlinedataentry.Enter_taxpayer_name(taxpayer_name);
		onlinedataentry.Enter_address(address);
		onlinedataentry.Enter_shop_building_name(shop_building_name);
		onlinedataentry.Enter_shop_flat_no(shop_flat_no);
		onlinedataentry.Select_shirshak_bhogvatdar(shirshak_bhogvatdar);
		onlinedataentry.Enter_bhogvatdar(bhogvatdar);
		onlinedataentry.Enter_occupier_name(occupier_name);
		
		onlinedataentry.Click_add_owner_info();
	}
	
	@Test(priority = 7, dependsOnMethods = "Dataentry_owner_info_Partition")
	public void Dataentry_floor_info_Partition() throws Exception
	{
		test = extent.createTest("Dataentry_floor_info-Partition");
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Click_remove_floor_check_box(driver);
		
		onlinedataentry.Select_floor(floor);
		onlinedataentry.Enter_construnction_year(construnction_year);
		
	
		try {
			onlinedataentry.Select_construction_type(construction_type);
		} catch (Exception e) {
			onlinedataentry.Select_construction_type(construction_typeForbaramati);
		}
		
		
		try {
			onlinedataentry.Select_type_of_use(type_of_use);
		} catch (Exception e) {
			onlinedataentry.Select_type_of_use("R-निवासी");
		}
		
		onlinedataentry.Enter_karpatr_chatai_area_sqft_floor(karpatr_chatai_area_sqft_floor);
		
		onlinedataentry.Select_nondani(nondani);
		onlinedataentry.Enter_no_of_room(Enter_no_of_room);
		onlinedataentry.Select_renter_available(renter_available);
		onlinedataentry.Enter_renter_name_marathi(renter_name_marathi);
		onlinedataentry.Enter_renter_name_eng(renter_name_eng);
		onlinedataentry.Enter_calculated_rent(calculated_rent);
		onlinedataentry.Select_agreement(agreement);
		
		onlinedataentry.Click_add_floor_info();
		String floorinfoImage=TakeScreenshoot.GetScreenshotFullBase64(driver);
		test.pass("Entered Floor info",MediaEntityBuilder.createScreenCaptureFromBase64String(floorinfoImage).build());
		onlinedataentry.Enter_r_toilet("2");
		onlinedataentry.Enter_c_toilet("2");
		
		/////
		stopWatch.reset();
		stopWatch.start();
		onlinedataentry.Button_save_btn(driver);
		onlinedataentry.Button_DataSaved(driver);
		onlinedataentry.Button_old_information_btn(driver);
		test.info("Time duration of Saving Wadhghat Data: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		
	}
	
	@Test(priority = 8, dependsOnMethods = "Dataentry_floor_info_Partition")
	public void OldTaxex_info_Partition() throws Exception
	{
		/////
		stopWatch.reset();
		stopWatch.start();
		test = extent.createTest("OldTaxex_info");
		OldTaxesPage oldtaxespage = new OldTaxesPage(driver);
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
		
		OnlineDataEntryPage onlinedataentry = new OnlineDataEntryPage(driver);
		onlinedataentry.Button_DataSaved(driver);
		
		oldtaxespage.Button_addTaxes_btn(driver);
		test.info("Time duration of Saving oldTaxes: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}
	
	@Test(priority = 9, dependsOnMethods = "OldTaxex_info_Partition")
	public void AddTaxes_and_UploadFiles_Partition() throws InterruptedException
	{
		/////
		stopWatch.reset();
		stopWatch.start();
		test = extent.createTest("AddTaxes_and_UploadFiles-Partition");
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
		addtaxespage.Button_print_approval_btn(driver);
		addtaxespage.getWindowHandleName(driver);
		addtaxespage.Scroll_sthalpahani_ahaval(driver);
		addtaxespage.document_upload_wadhaghat_kagadpatra10();
		addtaxespage.Select_choose_file(System.getProperty("user.dir")+"\\AddTaxes file\\PDFFILE.pdf");
		addtaxespage.Button_upload_btn(driver);
		onlinedataentry.Button_DataSaved(driver);
		addtaxespage.Button_send_to_approval_btn(driver);
	}
	
	@Test(priority = 10, dependsOnMethods = "AddTaxes_and_UploadFiles_Partition")
	public void WadhghatApproval_Partition() throws Exception
	{
		test = extent.createTest("WadhghatApproval-Partition");
		ApprovalPage approvalpage = new ApprovalPage(driver);
		approvalpage.Approval_link(url, driver);
		
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
		
		
		String spanEkunKarApproval1 = approvalpage.getEkunKarApproval1();
		
		 
		
	    
	    Assert.assertEquals(spanEkunKarApproval1, Taxtotal_fromDataentry+".00", 
	            "The stored Ekun Kar does not match the displayed Ekun Kar! "
	            + "Stored: " + Taxtotal_fromDataentry + ", Displayed: " + spanEkunKarApproval1);

	    test.pass("The stored Ekun Kar matches the displayed Ekun Kar as expected: " + Taxtotal_fromDataentry);
	    
//	    Assert.assertEquals(spanSamanyaKarApproval1, storedSamanyaKar, 
//	            "The stored Ekun Kar does not match the displayed Ekun Kar! "
//	            + "Stored: " + storedSamanyaKar + ", Displayed: " + spanSamanyaKarApproval1);
//
//	    test.pass("The stored Ekun Kar matches the displayed Ekun Kar as expected: " + storedSamanyaKar);
		
		approvalpage.Enter_remarks(approvalRemark,driver);
		/////
		stopWatch.reset();
		stopWatch.start();
		approvalpage.Button_ApprovalAll_btn();
		test.info("Time duration of Approval Process: "+TimeUnit.NANOSECONDS.toSeconds(stopWatch.getNanoTime())+" sec.");
		stopWatch.stop();
		/////
	}
	
	@Test(priority = 11,dependsOnMethods = "WadhghatApproval_Partition")
	private void councilapproval_Partition() throws Exception 
	{
		Thread.sleep(10000);
//		String akshep_no="PNLWG25635";
		test = extent.createTest("Council Approval-Partition");
		CMS_Page cmspage = new CMS_Page(driver);
		
		cmspage.councilapproval_link(url, driver);

	Council_approval counncil_approval = new Council_approval(driver);
		
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
    public void tearDown() {
     
        extent.flush();
        }

}