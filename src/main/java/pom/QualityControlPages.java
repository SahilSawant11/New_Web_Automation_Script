package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

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
	
	public void Select_totaloutstanding_reports(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports));
		Select node = new Select(select_reports);
		node.selectByValue("4");
	}
	
	public void Select_total_outstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_reports));
		Select node = new Select(select_reports);
		node.selectByValue("4");
	}
	
	public void Select_zone(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav));
		Select node = new Select(select_zone_che_nav);
		node.selectByValue("BMC");
	}
	
	public void Select_zone_totaloutstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_zone_che_nav_totaloutstnd));
		Select node = new Select(select_zone_che_nav_totaloutstnd);
		node.selectByValue("BMC");
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
	
	public void Select_to_proprty(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property));
		Select node = new Select(select_to_property);
		node.selectByValue("51");
	}
	
	public void Select_to_proprty_totaloutstanding(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_to_property_totaloutstnd));
		Select node = new Select(select_to_property_totaloutstnd);
		node.selectByValue("51");
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
		wait.until(ExpectedConditions.visibilityOf(totaloutstanding_export_btn));
		totaloutstanding_export_btn.click();
		if (totaloutstanding_export_btn.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	
}
