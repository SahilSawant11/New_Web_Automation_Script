package pom_TradeLicense;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_TradeLicense {

		/////////////////////////////////////////input-feilds//////////////////////////////////////
		@FindBy(xpath = "//input[@id='txtUserName']") private WebElement user_name;
		@FindBy(xpath = "//input[@id='txtPassword']") private WebElement password;
		
		/////////////////////////////////////////buttons///////////////////////////////////////
		@FindBy(xpath = "//button[@id='btnLogin']") private WebElement login_btn;
	
		/////////////////////////////////////////Page-Objects///////////////////////////////////////
		public LoginPage_TradeLicense(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		/////////////////////////////////////////Enter-Objects///////////////////////////////////////
		public void Enter_user_name(String user, WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.until(ExpectedConditions.visibilityOf(user_name));
			
			user_name.clear();
			user_name.sendKeys(user);
		}
		
		public void Enter_password(String pass)
		{
			password.clear();
			password.sendKeys(pass);
		}

		/////////////////////////////////////////Click-Objects///////////////////////////////////////
		public void Click_login_btn(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(1000);
			login_btn.click();
			Thread.sleep(3000);
			JavascriptExecutor j = (JavascriptExecutor)driver;
		    if (j.executeScript
		    		("return document.readyState").toString().equals("complete")){
		    		System.out.println("Page loaded properly.");
		    	}
		    Thread.sleep(500);
		}
		
}