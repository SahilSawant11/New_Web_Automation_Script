package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApprovalPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWadhghatRemark']") private WebElement remarks;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_ApproveALL']") private WebElement ApprovalAll_btn;
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblNewTotalTaxch']") private WebElement ekunKarApproval1;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblNewPropertyTaxch']") private WebElement samanyaKarApproval1;
	
	public ApprovalPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_remarks(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(remarks));
		
		remarks.sendKeys(str);
	}
	
	public void Button_ApprovalAll_btn() throws InterruptedException
	{
		ApprovalAll_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	
	public void Approval_link(String url, WebDriver driver)
	{
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "Approval.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	
	public String getEkunKarApproval1() {
		
		
		String abc=ekunKarApproval1.getText();
		return abc;
	
		

		
       
        
       
        
    }
	
	public String getSamanyaKarApproval1() {
		
        return samanyaKarApproval1.getText(); 
    }

	
	
	
	
}
