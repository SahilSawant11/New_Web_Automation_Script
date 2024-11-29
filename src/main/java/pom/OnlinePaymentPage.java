package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinePaymentPage {
	
	@FindBy(xpath = "//*[@id='form1']/div[3]/nav/div[1]/a/span") private WebElement council_name;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlNodeNo']") private WebElement node_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']") private WebElement sector_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']//option") private WebElement sector_options;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPropertyNo']") private WebElement property_no;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnGetProperty']") private WebElement search_property;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIAgree']") private WebElement agree_and_proceed_radio_btn;	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVPropTax_chkGrid_2']") private WebElement select_pay_all_checkbox;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnSave']") private WebElement register;	
	@FindBy(xpath = "/html/body/div[3]/div[7]/div/button") private WebElement ok_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnShowNoticeBill']") private WebElement notice_btn;	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[4]/td[20]") private WebElement  nivval_ekun_kar;	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_lblShowOwnerName']") private WebElement  kardharak_nav;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVPropTax_btnpartialpaynow_2']") private WebElement  pay_now_btn;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtEmail']") private WebElement  emailID;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtMobileNo']") private WebElement  mobileno;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_RadioButtonList1']/tbody/tr/td/label") private WebElement  payment_gateway;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_chkTermnCondition']") private WebElement  terms_and_conditions;
	@FindBy(xpath = "//*[@id=\'ContentPlaceHolder1_LinkButton6\']") private WebElement  final_pay_now;
	@FindBy(xpath = "/html/body/div[3]/div[7]/div/button") private WebElement  final_ok_btn;

	public static String onlineTotalTax;
	public static String onlineKarDharak;
	
	public OnlinePaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void onlinePaymentUrl(WebDriver driver,String url) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(council_name));
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "OnlinePayment.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

	public void Select_node_no(WebDriver driver,String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(node_no));
		Select node = new Select(node_no);
		node.selectByValue(str);
	}
	
	public void Select_sector_no(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(sector_options));
		Select sector = new Select(sector_no);
		sector.selectByValue(str);
	}
	
	public void Enter_property_no(WebDriver driver, String str) throws InterruptedException
	{
		property_no.sendKeys(str);
		Thread.sleep(2000);
		
		
		
		  if (str.contains("-")) {
			  property_no.sendKeys(Keys.ARROW_DOWN);
				property_no.sendKeys(Keys.ENTER);
	        } else {
	          
	        }
		  
	}
	
	public void Click_search_property() throws InterruptedException
	{
		Thread.sleep(1000);
		search_property.click();
	}
	
	public void Agree_and_proceed(WebDriver driver) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(agree_and_proceed_radio_btn));
		Thread.sleep(1000);
		agree_and_proceed_radio_btn.click();
		register.click();
		Thread.sleep(5000);
		ok_btn.click();
	}
	
	public void Click_Notice_Bill() throws InterruptedException
	{
		Thread.sleep(1000);
		notice_btn.click();
	}

	public void Scroll_to_grid(WebDriver driver) throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600)"); 


	}
	
	public void Click_select_pay_all_checkbox() throws InterruptedException
	{
		Thread.sleep(1000);
		select_pay_all_checkbox.click();
	}
	
	public void getOnlineScreenDetails() throws InterruptedException{
		String nivval_ekun_kar_online = nivval_ekun_kar.getText();
		String kar_dharak_nav = kardharak_nav.getText();
		System.out.println("Online Counter Tax: " + nivval_ekun_kar_online);
		System.out.println("Offline Owner Name: " + kar_dharak_nav);
		onlineKarDharak = kar_dharak_nav;
		onlineTotalTax = nivval_ekun_kar_online;
	}
	
	public void Click_pay_now() throws InterruptedException
	{
		Thread.sleep(1000);
		pay_now_btn.click();
	}
	
	public void Enter_email_id(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(emailID));
		emailID.clear();
		emailID.sendKeys(str);
	}
	
	public void Enter_mobile_no(WebDriver driver, String str) throws InterruptedException
	{
		mobileno.clear();
		mobileno.sendKeys(str);
		
	}
	
	public void Click_gateway() throws InterruptedException
	{
		Thread.sleep(1000);
		payment_gateway.click();
	}
	
	public void Click_terms_conditions() throws InterruptedException
	{
		Thread.sleep(1000);
		terms_and_conditions.click();
	}
	
	public void Click_final_pay_now() throws InterruptedException
	{
		Thread.sleep(1000);
		final_pay_now.click();
	}
	
	public void Click_final_ok() throws InterruptedException
	{
		Thread.sleep(1000);
		final_ok_btn.click();
	}
	
}




















