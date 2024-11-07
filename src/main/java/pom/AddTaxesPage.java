package pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.core.ReturnInstruction.Return;

public class AddTaxesPage {

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowPropertyNo']") private WebElement property_no_lable;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowOwnerName']") private WebElement kar_dharak_nav_lable;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnRefreshTaxes']") private WebElement Refresh_Taxes_btn;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVWadhGhatDocument_lblDocumentName_8']") private WebElement scroll_sthalpahani_ahaval;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_8']") private WebElement upload_durusti_patra9;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_GVWadhGhatDocument_lnkUpload_9']") private WebElement upload_wadhaghat_kagadpatra10;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSaveDataOnAddTaxes']") private WebElement save_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnRegisterN']") private WebElement addTax_complaint_register_btn_no;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnPrintWadhghat']") private WebElement print_approval_btn;
	
	@FindBy(xpath = "//div[text()='Data saved successfully.']") private WebElement data_save;
	@FindBy(xpath = "/html/body/div[3]/div[7]/button") private WebElement no_OCdate_popup;
	@FindBy(xpath = "/html/body/div[3]/p") private WebElement sendToApproval;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSendToApproval']") private WebElement send_to_approval_btn;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1FileUpload']") private WebElement choose_file;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_MP1Upload']") private WebElement upload_btn;
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	
	//----taxex
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_gridAppealTaxInfo_lblTotal_0']") private WebElement TaxtotalOn_Dataentry;
	
	
	
	public AddTaxesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Fetch_property_no_lable(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(property_no_lable));
		
		String str = property_no_lable.getText();
		return str;
	}
	
	public String Fetch_kar_dharak_nav_lable()
	{
		String str = kar_dharak_nav_lable.getText();
		return str;
	}
	
	public void Button_Refresh_Taxes_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Refresh_Taxes_btn));
		
		Refresh_Taxes_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_save_btn(WebDriver driver) throws InterruptedException
	{
//		Thread.sleep(1000);
//		while(loading_page.getAttribute("aria-hidden").equals("false"))
//		{
//			Thread.sleep(500);
//			System.out.println("waiting");
//		}
//		Thread.sleep(500);
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(20000));
//		wait1.until(ExpectedConditions.visibilityOf(Refresh_Taxes_btn));
//		
		Thread.sleep(5000);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save_btn);
//		Thread.sleep(500);
//		
		save_btn.click();
//		
//		Thread.sleep(1000);
//		while(loading_page.getAttribute("aria-hidden").equals("false"))
//		{
//			Thread.sleep(500);
//			System.out.println("waiting");
//		}
//		Thread.sleep(500);
//		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(no_OCdate_popup));
		Thread.sleep(2000);
		no_OCdate_popup.click();
		
		
		
	}
	
	public void Button_addTax_complaint_register_btn_no() throws InterruptedException
	{
		addTax_complaint_register_btn_no.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	
	////////need to review///////////////////////////////////////////////////////////////////////////
	public void Button_print_approval_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(print_approval_btn));
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", print_approval_btn);
		Thread.sleep(500);
		
		print_approval_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Scroll_sthalpahani_ahaval(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll_sthalpahani_ahaval);
		Thread.sleep(500);
	}
	
	public void document_upload_durusti_patra9() throws InterruptedException
	{
		upload_durusti_patra9.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void document_upload_wadhaghat_kagadpatra10() throws InterruptedException
	{
		upload_wadhaghat_kagadpatra10.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	
	public void Button_send_to_approval_btn(WebDriver driver) throws InterruptedException
	{		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", send_to_approval_btn);
		Thread.sleep(500);
		
		try {
			send_to_approval_btn.click();
		} catch (Exception e) {
			
			Thread.sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", send_to_approval_btn);
			Thread.sleep(1000);
			send_to_approval_btn.click();
		}
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    ("return document.readyState").toString().equals("complete")){
	    	System.out.println("Page loaded properly.");
	    }
	    Thread.sleep(10000);
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//		wait.until(ExpectedConditions.visibilityOf(sendToApproval));
	}
	
	public void Select_choose_file(String str) throws InterruptedException
	{
		choose_file.sendKeys(str);
		Thread.sleep(2000);
	}
	
	
	public void Button_upload_btn(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		upload_btn.click();
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    ("return document.readyState").toString().equals("complete")){
	    	System.out.println("Page loaded properly.");
	    }
	}
	
	public String GetValuesElement_taxtotal(WebDriver driver) throws InterruptedException
	{		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(TaxtotalOn_Dataentry));
		Thread.sleep(500);
		String Outputtext1 =TaxtotalOn_Dataentry.getText();
		
		return Outputtext1;
	}
	
	
	public void getWindowHandleName(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    ("return document.readyState").toString().equals("complete")){
	    	System.out.println("Page loaded properly.");
	    }
		
		Thread.sleep(2000);
		Set<String> s = driver.getWindowHandles();
		
		while(s.size() == 2)
		{
			Thread.sleep(1000);
			System.out.println("waiting for file download");
			s = driver.getWindowHandles();
		}
		Thread.sleep(3000);
		System.out.println("File downloaded");
	}	
}
