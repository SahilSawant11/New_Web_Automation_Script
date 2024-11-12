package SmokTesting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import New_property_Wadhghat.BaseDriver;
import ch.qos.logback.core.util.Duration;
import pojo.CMS_browser;
import pom.LoginPage;
import pom.OfflinePaymentPage;
import utility.Delete_Files;
import utility.TakeScreenshoot;

public class CheckPages  extends BaseDriver{
	private WebDriver driver;
	TakeScreenshoot takescreenshot = new TakeScreenshoot(driver, null);
	StopWatch stopWatch;
    private ExtentReports extent;
    private ExtentSparkReporter spark;
    private ExtentTest test;
    private String baseurl = "http://testpanvelmc.ptaxcollection.com:8080/Pages/";
	
    @BeforeTest
	public void beforetest() throws IOException
	{	
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
	
    @Test(priority = 2)
    public void startTest() throws Exception {
        // Create a test in ExtentReports
        test = extent.createTest("Cash Payment Test");

        // Define URLs to loop through
        String[] urls = {
                "OnlinePayment", "OfflinePayment", "NewUser", "NewRole", "Response", "PagePrevilages", 
                "CollectionReport", "PageNameMaster", "CouncilMaster", "PageGroupMaster", 
                "BillBookAllocation", "ChangePassword", "ActiveTaxesEditableStatus", "UniquePropertyNoEntryMaster", 
                "TransactionApproval", "CollectionApproval", "DiscountSlabMaster", "BankMaster", "GenerateBillReceipt", 
                "ApplcationSetting", "TransferFee", "NameCorrection", "NewDataEntryTab", "DashboardTabRegistration", 
                "NewTaxPayment", "Approval", "MutationApproval", "SearchByOldRV", "SearchByBillBookNoAndInvoiceNo", 
                "PaymentInitiatedStatus", "WaterBillPayment", "WaterBill/OfflinePayment", "NewWaterConnection", 
                "WaterBill/NewConnectionBillPayment", "OtherPayment", "CMS", "AutoWardEntry", "QualityControlReports", 
                "CMSDetails", "NewUserOTPMaster", "QCScreen", "Accountant", "PropertyAudit", "NotvariDetails", 
                "CashierAllocation", "CashierScreen", "CouncilApproval", "OnlineGrievance", "SendBalanceSMS", 
                "ImportMISTransactions", "MinorChanges", "ApprovalAllocation", "DeploymentSchedule", "UserLoginTracker", 
                "ReportEngine", "CouncilApprovalReadOnly", "AnamatRakkam", "OccpancyAdvancePayment", "SendSms", 
                "PropertyDataByNIC", "SelfAssessmentGrievance", "OnlineGrievanceReadOnly", "EBillEmailSEND", 
                "BlockUnblockProperties", "HomeDashboard", "PaymentMissMatched", "MinusCollectionAdjust", 
                "GenarateQRandUnicodeAddress", "CustomSmsSend", "SocietyPaymentPosting", "IGRMuation", 
                "PropertyMutationUsingIGR", "SelfAssessmentApproval", "ReportDownloadAccessDetails", "QuickPay", 
                "BillDistributionTracker", "NewReportEngine", "PropertyTypeMaster", "ReportAccess", 
                "NDashboard", "AdminDashboard", "OnlinePaymentRefund", "DiscountApprovals" };

        // Loop through each URL and test the page
        for (String url : urls) {
        	stopWatch.reset();
        	stopWatch.start();
            // Open the URL
			driver.get(baseurl + url + ".aspx");
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form1']/div[3]/nav/div[1]/a")));
				stopWatch.stop();
				long loadTime = stopWatch.getTime();
				String pagename = TakeScreenshoot.GetScreenshotFullBase64(driver);
			    test.log(Status.INFO, "Page  : " + url + " has opened in : " + loadTime + "ms");
			    test.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(pagename).build());  
			    System.out.println(url + ": Page Loaded");
			} catch (Exception e) {
				stopWatch.stop();
				long loadTime = stopWatch.getTime();
				String pagename = TakeScreenshoot.GetScreenshotFullBase64(driver);
			    test.log(Status.INFO, "Page  : " + url + " has not opened. Time taken : "+ loadTime);
			    test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(pagename).build());
			    System.out.println(url + ": Page Load Error");
			}
        }
    }

    @AfterTest
    public void tearDown() {
     
        extent.flush();

    }
}
  
		  
