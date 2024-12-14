package pom_WaterTax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddReadingPage_Water {
	////////////////////////////////////input-feilds//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtLastReadingdate']") private WebElement last_reading_date;
	@FindBy(xpath = "//*[@id='txtCurrentReadingDate']") private WebElement current_reading_date;
	@FindBy(xpath = "//*[@id='txtCurrentReading']") private WebElement current_reading;	
	@FindBy(xpath = "//*[@id='txtConsumerNo']") private WebElement consumer_no;
	
	////////////////////////////////////buttons//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnSave']") private WebElement add_btn;
	@FindBy(xpath = "//*[@id='btnSearchConsumer']") private WebElement search_btn;
	@FindBy(xpath = "//*[@id='btnSearch']") private WebElement search_btn_approval;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='Yes']") private WebElement yes_btn;
	@FindBy(xpath = "//*[@id='btnApproved']") private WebElement reading_approved;	// Reading Approved Page
	
	////////////////////////////////////checkbox////////////////////////////////////////////// 
	@FindBy(xpath = "//*[@id='flowcheckall']") private WebElement checkall; // Reading Approval Page
	
	
	///////////////////////////////////////////////Page-Objects//////////////////////////////////////
	
	public AddReadingPage_Water(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void AddReading_Page_link(String url, WebDriver driver)
	{

	String s1[] = url.split("/");
	String s2 = "";

	for(int j=0;j<s1.length-1;j++)
	{
	s2 += s1[j]+"/";
	}
	s2 += "WaterBill/Addreading";
	System.out.println(s2);

	driver.get(s2);
	}
	
	public void ReadingApproval_Page_link(String url, WebDriver driver)  // Reading Approval Page
	{

	String s1[] = url.split("/");
	String s2 = "";

	for(int j=0;j<s1.length-1;j++)
	{
	s2 += s1[j]+"/";
	}
	s2 += "WaterBill/ApproveReading";
	System.out.println(s2);

	driver.get(s2);
	}
	
	///////////////////////////////////////////////Enter-Objects////////////////////////////////////////////////////////	
	
	public void Enter_last_reading_date(String str)
	{
		last_reading_date.clear();
		last_reading_date.sendKeys(str);
	}
	
	public void Enter_current_reading(String str) 
	{
		current_reading.clear();
		current_reading.sendKeys(str);
	}
	
	public void Enter_consumer_no(String str)
	{
		consumer_no.clear();
		consumer_no.sendKeys(str);
	}
	
	///////////////////////////////////////////////Click-Objects////////////////////////////////////////////////////////	
	
	public void Click_search_btn() 
	{
		search_btn.click();
	}

	public void Click_current_reading_date()
	{
		current_reading_date.click();
	}
	
	public void Click_add_btn() 
	{
		add_btn.click();
	}
	
	public void Click_yes_btn() 
	{
		yes_btn.click();
	}

	public void Click_search_btn_approval() // Reading Approval Page
	{
		search_btn_approval.click();
	}
	
	public void Click_checkall(WebDriver driver) // Reading Approval Page
	{
		WebElement checkbox = driver.findElement(By.cssSelector("input.checkall"));
		checkbox.click();

	}
	
	public void Click_approved() 
	{
		reading_approved.click();
	}

}
