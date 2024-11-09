package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboardPage {
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_PaymentModeWiseCollectionDashboard']") private WebElement paymentmodewise_table;
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_dgvUseWiseCollection']") private WebElement usewise_table;
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_ZoneCollectionDashboard']") private WebElement zonewise_table;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnPaymentTypeTransaction']") private WebElement paymentwise_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnUseWiseCollection']") private WebElement usewise_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnZoneCollection']") private WebElement zonewise_btn;
	
	public AdminDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AdminDashboardPageLink(String url, WebDriver driver)
	{
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "AdminDashboard.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void Click_payment_wise(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(paymentwise_btn));
		paymentmodewise_table.click();
	}
	
	public void Click_zone_wise(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(zonewise_btn));
		zonewise_btn.click();
	}
	
	public void Click_use_wise(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(usewise_btn));
		usewise_btn.click();
	}
	
	 public  boolean isPaymentModeWiseTablePresent(WebDriver driver) {
	        try {
	       
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(paymentmodewise_table));
	            return paymentmodewise_table.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
	 public  boolean isUseWiseTablePresent(WebDriver driver) {
	        try {
	       
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(usewise_table));
	            return usewise_table.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 public  boolean isZoneWiseTablePresent(WebDriver driver) {
	        try {
	       
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(zonewise_table));
	            return zonewise_table.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
