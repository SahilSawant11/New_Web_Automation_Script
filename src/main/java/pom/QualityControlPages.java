package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualityControlPages {
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlReports']") private WebElement select_reports;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlNodeNo']") private WebElement select_zone_che_nav;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DropDownList11']") private WebElement select_zone_che_nav_totaloutstnd;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSectorNo']") private WebElement select_ward;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DropDownList22']") private WebElement select_ward_totaloutstnd;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlFromProperty']") private WebElement select_from_property;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlFromProperty11']") private WebElement select_from_property_totaloutstnd;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlToProperty']") private WebElement select_to_property;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlToProperty11']") private WebElement select_to_property_totaloutstnd;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rdbCurrentPending']") private WebElement select_to_Current_and_Pending;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rdbCurrent']") private WebElement select_Current;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rdbPending']") private WebElement select_Pending;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlInterest']") private WebElement select_with_without_interest;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAmount']") private WebElement enter_amount;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnShow']") private WebElement show_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnExport']") private WebElement export_btn;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnTotalOutstanding']") private WebElement totaloutstanding_export_btn;
	@FindBy(xpath = "//*[@id=\'ContentPlaceHolder1_GRVAllDetails\']/tbody/tr[1]/th[1]") private WebElement gridelem;
	@FindBy(xpath = "//*[@id=\'ContentPlaceHolder1_Image1\']") private WebElement loader;
	
	/////////////////////////wadhghat fer ////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_Wadhghat']") private WebElement select_wadhghat;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_FerFar']") private WebElement select_ferfar;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlFinYearForReport']") private WebElement select_finance_year_wf;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFrmDate1']") private WebElement select_from_date_wf;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtToDate1']") private WebElement select_to_date_wf;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnexportpdf']") private WebElement export_btn_wf;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnexportfer']") private WebElement export_btn_fer;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public QualityControlPages (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Select_defaulter_reports(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports));
		Select node = new Select(select_reports);
		node.selectByValue("1");
	}
	
	public void Select_wadhghat_ferfar_reports(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports));
		Select node = new Select(select_reports);
		node.selectByValue("6");
	}
	
	public void Select_financial_year_2024_25_wf(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_finance_year_wf));
		Select node = new Select(select_finance_year_wf);
		node.selectByValue("2024-2025");
	}
	
	public void Enter_from_date_wf(WebDriver driver, String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		select_from_date_wf.click();
		String xpath = String.format("//div[@id='ContentPlaceHolder1_CalendarExtender2_days']//div[text()='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        dateElement.click();
        
	}   
	
	public void Enter_to_date_wf(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(select_to_date_wf));
		select_to_date_wf.sendKeys(str);
	}
	
	public void Click_export_btn_wf(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(export_btn_wf));
        export_btn_wf.click();
        
	}
	
	public void Click_export_btn_fer(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(export_btn_fer));
        export_btn_fer.click();
        
	}
	
	public void Click_wadhghat(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(select_wadhghat));
        select_wadhghat.click();
        
	}
	
	public void Click_ferfar(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(select_ferfar));
        select_ferfar.click();
        
	}
	
	public void Select_total_outstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports));
		Select node = new Select(select_reports);
		node.selectByValue("4");
	}
	
	public void Select_zone_BMC(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav));
		Select node = new Select(select_zone_che_nav);
		node.selectByValue("BMC");
	}
	
	public void Select_zone(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav));
		Select node = new Select(select_zone_che_nav);
		node.selectByIndex(1);
	}
	
	public void Select_zone_totaloutstanding_BMC(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav_totaloutstnd));
		Select node = new Select(select_zone_che_nav_totaloutstnd);
		node.selectByValue("BMC");
	}
	
	public void Select_zone_totaloutstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav_totaloutstnd));
		Select node = new Select(select_zone_che_nav_totaloutstnd);
		node.selectByIndex(1);
	}
	
	public void Select_ward(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_ward));
		Select node = new Select(select_ward);
		node.selectByValue("1");
	}
	
	public void Select_ward_totaloutstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_ward_totaloutstnd));
		Select node = new Select(select_ward_totaloutstnd);
		node.selectByValue("1");
	}
	
	public void Select_from_proprty(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_from_property));
		Select node = new Select(select_from_property);
		node.selectByValue("1");
	}
	
	public void Select_from_proprty_totaloutstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_from_property_totaloutstnd));
		Select node = new Select(select_from_property_totaloutstnd);
		node.selectByValue("1");
	}
	
	public void Select_to_proprty_BMC(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property));
		Select node = new Select(select_to_property);
		node.selectByValue("51");
	}
	
	public void Select_to_proprty_totaloutstanding_BMC(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property_totaloutstnd));
		Select node = new Select(select_to_property_totaloutstnd);
		node.selectByValue("51");
	}
	
	public void Select_to_proprty_KH(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property));
		Select node = new Select(select_to_property);
		node.selectByValue("1-1");
	}
	
	public void Select_to_proprty_totaloutstanding_KH(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property_totaloutstnd));
		Select node = new Select(select_to_property_totaloutstnd);
		node.selectByValue("500003");
	}
	
	public void Select_to_current(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_Current));
		select_Current.click();
	}
	
	public void Select_to_pending(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_Pending));
		select_Pending.click();
	}
	
	public void Select_with_interest(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_with_without_interest));
		Select node = new Select(select_with_without_interest);
		node.selectByValue("0");
	}
	
	public void Select_without_interest(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_with_without_interest));
		Select node = new Select(select_with_without_interest);
		node.selectByValue("1");
	}
	
	public void Enter_amount(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(enter_amount));
		enter_amount.sendKeys("5000");
		
	}
	
	public void Quality_Control_Page_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "QualityControlReports.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void Show_button(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(show_btn));
		show_btn.click();
	}
	
	public void Export_button(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(export_btn));
		export_btn.click();
	}
	
	public void Totaloutstanding_export_button(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(totaloutstanding_export_btn));
		totaloutstanding_export_btn.click();
	}
	
	
	public boolean isGridDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));	    
	    wait2.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(gridelem));

		if (gridelem.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	
}
