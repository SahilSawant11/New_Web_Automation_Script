package pom_PCMC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PCMC_ReportPage {
	
	////////////////////////////////////////////input-feilds//////////////////////////////////////////
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlZone']") private WebElement zone;
	
	////////////////////////////////////////////check-boxes//////////////////////////////////////////
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlReportType']") private WebElement select_reports_type;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPaymentMode']") private WebElement select_payment_mode;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtFromDate']") private WebElement from_date_box;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$GVPaymentMode$ctl01$chkAll']") private WebElement all_payment_mode_checkbox;
	
	////////////////////////////////////////////buttons//////////////////////////////////////////
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_BtnDownloadReport']") private WebElement download_report_btn;
	@FindBy(xpath = "(//a[@id='ContentPlaceHolder1_BtnChallanTransaction']") private WebElement challan_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnOtherTransaction']") private WebElement other_btn;
	
	
	////////////////////////////////////////////page-objects//////////////////////////////////////////
	
	public PCMC_ReportPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Pcmc_Report_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "Report.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	////////////////////////////////////////////click-objects//////////////////////////////////////////
	
	public void Click_challan_txn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(challan_btn));
		challan_btn.click();
	}
	
	public void Click_other_txn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(other_btn));
		other_btn.click();
	}

	public void Click_generate_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(download_report_btn));
		download_report_btn.click();
	}
	
	////////////////////////////////////////////select-objects//////////////////////////////////////////
	
	public void select_zone_wakad(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(zone));
		Select node = new Select(zone);
		node.selectByValue("17");
	}
	
	public void select_headwise_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports_type));
		Select node = new Select(select_reports_type);
		node.selectByValue("Headwise");
	}
		
	public void select_challan_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports_type));
		Select node = new Select(select_reports_type);
		node.selectByValue("Challan");
	}
	
	public void select_cash_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_payment_mode));
		Select node = new Select(select_payment_mode);
		node.selectByValue("6");
	}
	
	public void select_cheque_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_payment_mode));
		Select node = new Select(select_payment_mode);
		node.selectByValue("9");
	}
	
	public void select_dd_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_payment_mode));
		Select node = new Select(select_payment_mode);
		node.selectByValue("7");
	}
	
	public void select_card_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_payment_mode));
		Select node = new Select(select_payment_mode);
		node.selectByValue("10");
	}
	
	public void select_online_option(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_payment_mode));
		Select node = new Select(select_payment_mode);
		node.selectByValue("8");
	}
	
	public void Select_all_payment_modes(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(all_payment_mode_checkbox));
		all_payment_mode_checkbox.click();
	}
	
	////////////////////////////////////////////enter-objects//////////////////////////////////////////

	public void enter_specific_date(WebDriver driver, String str)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000)); 
	    wait.until(ExpectedConditions.visibilityOf(from_date_box)); 
	    from_date_box.clear();
	    from_date_box.sendKeys(str); // Send the specified date as input
	}
	
	public void enter_todays_date(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(from_date_box));
		from_date_box.sendKeys(str);
	}
	
}
