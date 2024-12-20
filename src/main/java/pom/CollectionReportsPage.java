package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionReportsPage {
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlDuration']") private WebElement duration;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlReportType']") private WebElement template;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$DDLZoneSectionNo']") private WebElement zone;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlFinanceYear']") private WebElement finance_year;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlPaymentResource']") private WebElement payment_source;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlPayOption']") private WebElement pay_option;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlStatus']") private WebElement status;
	@FindBy(id="ContentPlaceHolder1_GVPaymentMode_chkAll") private WebElement paymode_checkALl;
	@FindBy( id="ContentPlaceHolder1_GVWard_chkAll") private WebElement ward_checkAll;
	@FindBy(name = "ctl00$ContentPlaceHolder1$txtFromDate") private WebElement from_date_box;
	@FindBy(id ="ContentPlaceHolder1_btnCollRpt" ) private WebElement generate_button;
	
	public void Select_monthly_report(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(duration));
		Select option = new Select(duration);
		option.selectByValue("1");
	}
	
	public CollectionReportsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Select_template(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(template));
		Select node = new Select(template);
		node.selectByValue("1");
	}
	
	public void Select_zone(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(zone));
		Select node = new Select(zone);
		node.selectByValue("0");
	}
	
	public void Select_all_wards(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(ward_checkAll));
		ward_checkAll.click();
	}
	
	public void Select_all_payment_modes(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(paymode_checkALl));
		paymode_checkALl.click();
	}
	
	public void Select_fincance_year(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(finance_year));
		Select node = new Select(finance_year);
		node.selectByValue("0");
	}
	
	public void Select_payment_source_all(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(payment_source));
		Select node = new Select(payment_source);
		node.selectByValue("0");
	}
	
	public void Select_payment_source_tab(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(payment_source));
		Select node = new Select(payment_source);
		node.selectByValue("3");
	}
	
	public void Select_payment_option_cheque(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(zone));
		Select node = new Select(pay_option);
		node.selectByValue("2");
	}
	
	public void status_cleared(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(status));
		Select node = new Select(status);
		node.selectByValue("1");
	}
	
	public void status_inprocess(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(status));
		Select node = new Select(status);
		node.selectByValue("2");
	}
	
	public void status_notCleared(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(status));
		Select node = new Select(status);
		node.selectByValue("3");
	}
	
	public void Click_date_box(WebDriver driver, String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		from_date_box.click();
		String xpath = String.format("//div[@id='ContentPlaceHolder1_CalendarExtender3_days']//div[text()='%s']", date);
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        dateElement.click();
	}
	
	public void Click_generate_btn(WebDriver driver)
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		generate_button.click();
	}
	
	public void CollectionReports_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "CollectionReport.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

	public void scrollToBottom(WebDriver driver) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
}
