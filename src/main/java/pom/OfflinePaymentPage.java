package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfflinePaymentPage {

		@FindBy(xpath = "//*[@id='form1']/div[3]/nav/div[1]/a/span") private WebElement council_name;
		@FindBy(xpath = "//a[text()=' Report ']") private WebElement report_btn;
		@FindBy(xpath = "//a[text()='Collection Report']")private WebElement collection_report;
		@FindBy(xpath = "(//a[@id='navbarDropdownMenuLink-555'])[1]") private WebElement payment_btn;
		@FindBy(xpath = "//a[text()='Counter Payment']") private WebElement counter_payment;
		@FindBy(xpath = "//a[text()='Dashboard']") private WebElement dashboard;
		
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtPropertyUniqueNo']") private WebElement upic_code_checkbox;
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtPropertyWise']") private WebElement property_no_radio_btn;	
		
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlNodeNo']") private WebElement node_no;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']") private WebElement sector_no;
		@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlSectorNo']//option") private WebElement sector_options;
		@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtPropertyNo']") private WebElement property_no;
		@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnGetProperty']") private WebElement search_property;
		@FindBy(xpath = "/html/body/div[3]") private WebElement property_not_available_popup;
		@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblPaymentStatus']") private WebElement transaction_id;
		@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lblDownloadReceiptbtn']") private WebElement receipts;
		
		@FindBy(xpath = "//span[@id='loggedUserFullName']") private WebElement loggedUserFullName;
		
		public OfflinePaymentPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public boolean waitforlogin(WebDriver driver) {
			 
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
					wait.until(ExpectedConditions.visibilityOf(loggedUserFullName));
					
					return true;
				} catch (Exception e) {
					return false;
				}
		}
		
		public void Text_council_name(WebDriver driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
			wait.until(ExpectedConditions.visibilityOf(council_name));
			Thread.sleep(2000);
		}
		
		public void click_payment_btn(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(payment_btn));
			payment_btn.click();
		}
		
		public void click_dashboard(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(payment_btn));
			dashboard.click();
		}
		
		public void Click_report_btn(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(report_btn));
			report_btn.click();
		}
		
		public void Click_collection_report(WebDriver driver) throws InterruptedException
		{
			System.out.println("collectin report menu option clicked");
		      
			collection_report.click();
		}
		
		public void Click_payment_btn(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(payment_btn));
			payment_btn.click();
		}
		
		public void Click_counter_payment(WebDriver driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(counter_payment));
			counter_payment.click();
		}
		
		public void counterPayment(WebDriver driver,String url) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
			wait.until(ExpectedConditions.visibilityOf(council_name));
			
			String s1[] = url.split("/");
			String s2 = "";
			
			for(int j=0;j<s1.length-1;j++)
			{
				s2 += s1[j]+"/";
			}
			s2 += "offlinePayment.aspx";
			System.out.println(s2);
			
			driver.get(s2);
		}
		
		public void Click_upic_code_checkbox() throws InterruptedException
		{
			Thread.sleep(1000);
			upic_code_checkbox.click();
		}
		
		public void Click_property_no_radio_btn(WebDriver driver)
		{			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
			wait.until(ExpectedConditions.visibilityOf(property_no_radio_btn));
			
			property_no_radio_btn.click();
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
			
		public void check_transaction_id(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
			wait.until(ExpectedConditions.visibilityOf(transaction_id));
		}
		
		public void Click_receipts() throws InterruptedException
		{
			Thread.sleep(1000);
			receipts.click();
		}
		
		public void offlinePaymentPage(String url, WebDriver driver)
		{
			String s1[] = url.split("/");
			String s2 = "";
			
			for(int j=0;j<s1.length-1;j++)
			{
				s2 += s1[j]+"/";
			}
			s2 += "offlinePayment.aspx";
			System.out.println(s2);
			
			driver.get(s2);
		}
		
}
