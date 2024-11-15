package pom;

import java.lang.classfile.instruction.TableSwitchInstruction;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineGrievancePage {
	@FindBy(xpath = "//p[@id=\'spnTodaysNewComplaint\']") private WebElement inprocess_tab;
	@FindBy(xpath = "//*[@id='loading']/div/div/img") private WebElement loader;
	@FindBy(xpath = "//*[@id='btnAccept']") private WebElement select_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWadhghatRemark']") private WebElement remark_box;
	
	
	public void Click_inprocess(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(inprocess_tab));
        inprocess_tab.click();
        
	}
	
	public void Select_property(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));	    
	    wait.until(ExpectedConditions.invisibilityOf(loader));
	    wait.until(ExpectedConditions.elementToBeClickable(select_btn));
	    select_btn.click();
	}

	
	public void Enter_remark(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(remark_box));
        remark_box.clear();
		remark_box.sendKeys(str);
        
	}
	
	public void Scroller(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
	}
	
	public OnlineGrievancePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Online_Greivance_Page_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "OnlineGrievance.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

}
