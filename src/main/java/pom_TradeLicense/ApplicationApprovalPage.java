package pom_TradeLicense;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationApprovalPage {
	
	/////////////////////////////////////////Input-feilds///////////////////////////////////////
	@FindBy(xpath = "//*[@id=\'tblGrievances_filter\']/label/input") private WebElement searchbox;
	@FindBy(xpath = "//input[@id='txtRemark']") private WebElement remarkbox;
	@FindBy(xpath = "//*[@id='lblshowNewFee']") private WebElement tax;
	@FindBy(xpath = "//*[@id='lblShowApplicantAddress']") private WebElement address;
	@FindBy(xpath = "//*[@id='lblShowEmailID']") private WebElement email;
	@FindBy(xpath = "//*[@id='lblShowMobileNo']") private WebElement mobile;
	
	/////////////////////////////////////////Buttons///////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnshow']") private WebElement showbtn;
	@FindBy(xpath = "//*[@id='btnPrintApplication']") private WebElement arjavhalbtn;
	@FindBy(xpath = "//*[@id='btnApproved1']") private WebElement approved1;
	@FindBy(xpath = "//span[@id='BtnFilter']/i)[1]") private WebElement filterBtn;
	

	/////////////////////////////////////////Page-Objects///////////////////////////////////////
	
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

	/////////////////////////////////////////Enter-Objects///////////////////////////////////////
	
	public void Search_application (WebDriver driver,String str) throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(500);
		searchbox.sendKeys(str);
	}
	
	public void Enter_remark (WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(remarkbox));
		remarkbox.clear();
		remarkbox.sendKeys("Automated Remark");
	}
	
	/////////////////////////////////////////Click-Objects///////////////////////////////////////
	
	public void Button_show_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(showbtn));
		Thread.sleep(1000);
		showbtn.click();
	}
	
	public void Button_arjavhal_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(arjavhalbtn));
		Thread.sleep(1000);
		arjavhalbtn.click();
	}
	
	public void Button_approved1_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(approved1));
		Thread.sleep(1000);
		approved1.click();
	}

	public void Click_filter_btn()
	{
		filterBtn.click();
	}
	/////////////////////////////////////////Function-Objects///////////////////////////////////////
	
	public String get_tax (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(tax));
		String Tax = tax.getText();
		return Tax;
	}
	
	public String get_email (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(email));
		String Email = email.getText();
		return Email;
	}
	
	public String get_address (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(address));
		String Address= address.getText();
		return Address;
	}
	
	public String get_mobile (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(mobile));
		String Mobile = mobile.getText();
		return Mobile;
	}
	
}
