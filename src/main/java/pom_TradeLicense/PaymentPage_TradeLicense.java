package pom_TradeLicense;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage_TradeLicense {
	
	/////////////////////////////////////////input-feilds//////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtApplicationNo']") private WebElement searchbox;
	@FindBy(xpath = "//*[@id='txtEmailID']") private WebElement email;
	
	/////////////////////////////////////////buttons///////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnSearchApplication']") private WebElement searchbtn;
	@FindBy(xpath = "//*[@id='btnPay']") private WebElement paybtn;
	@FindBy(xpath = "//*[@id='btnPayNow']") private WebElement paynowbtn;
	@FindBy(xpath = "//*[@id='paynow']/div[3]/div/div[2]/div/button") private WebElement billbook;
	@FindBy(xpath = "//*[@id='paynow']/div[3]/div/div[2]/div/div/div/input") private WebElement billbookbox;
	@FindBy(xpath = "//*[@id='btnDownloadReceipt']") private WebElement downloadreciept;
	
	//////////////////////////////////////Page-Objects////////////////////////////////////////
	public PaymentPage_TradeLicense (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Payment_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "SHEL/NewLicesnsePayment";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void Button_search_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(searchbtn));
		Thread.sleep(1000);
		searchbtn.click();
	}
	
	public void Button_pay_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(paybtn));
		Thread.sleep(1000);
		paybtn.click();
	}
	
	public void Button_paynow_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(paynowbtn));
		Thread.sleep(1000);
		paynowbtn.click();
	}
	
	public void Download_reciept (WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(downloadreciept));
		downloadreciept.click();
	}
	
	/////////////////////////////////////Enter-Objects//////////////////////////////////////
	public void Search_application (WebDriver driver,String str) throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(500);
		searchbox.sendKeys(str);
	}
	
	public void Enter_email (WebDriver driver, String str) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(str);
	}
	
	public void Enter_billbook (WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(billbook));
		billbook.click();
	}
	
	public void Enter_billbookbox (WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(billbookbox));
		billbookbox.click();
		billbookbox.sendKeys(Keys.ARROW_DOWN);
		billbookbox.sendKeys("Te");
		billbookbox.sendKeys(Keys.ENTER);
	}
	
}
