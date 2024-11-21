package pom_TradeLicense;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationApprovalPage {
	
	@FindBy(xpath = "//*[@id=\'tblGrievances_filter\']/label/input") private WebElement searchbox;

	public ApplicationApprovalPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Application_Approval_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "SHEL/ApplicationApproval";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void Search_application (WebDriver driver,String str) throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(500);
		searchbox.sendKeys(str);
	}
	
	
	
	
}
