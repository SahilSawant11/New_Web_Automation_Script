package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v121.css.model.CSSStyleSheetHeader;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDChequeclearPage {
	
	@FindBy(xpath="//*[@id='ContentPlaceHolder1_txtSearchByChecqurNo']") private WebElement Filter_chequeno;
	
	@FindBy(xpath="//*[@id='ContentPlaceHolder1_ddlZoneNo']") private WebElement Filter_zone;
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_dllWardNo']") private WebElement Filter_Sec;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnSearchData']") private WebElement Btn_serach;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVData_chkRow_0']") private WebElement Selectbox_cheque;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnCleared']") private WebElement ClearChequeBtn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnNotCleared']") private WebElement FailChequeBtn;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnYes']") private WebElement Yes_popup;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnYesNot']") private WebElement Yes_popup_for_notCleared;
	@FindBy(xpath = "/html/body/div[3]/p") private WebElement PopUpAfterChequeClear;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$ChequeCleartxt']") private WebElement bank_date;
	
	public DDChequeclearPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void DDchequeApprovalpage(String url, WebDriver driver)
	{
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "TransactionApproval.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void Enter_Bank_transaction_date(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(bank_date));
		bank_date.sendKeys(str);
	}

	public void pageloading(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(500);
	}
	
	public void Enter_ChequeNo(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Filter_chequeno));
		
		Filter_chequeno.clear();
		Filter_chequeno.sendKeys(str);
	}
	
	
	public void SelectNode_filter(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Filter_zone));			
Select billbook = new Select(Filter_zone);
		try {
			billbook.selectByVisibleText(str);
		} catch (Exception e) {
			billbook.selectByIndex(1);
		}
		
		
	}
	public void SelectSec_filter(String str, WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
		wait.until(ExpectedConditions.visibilityOf(Filter_Sec));
	//	Select sector = new Select(Filter_Sec);
		Filter_Sec.sendKeys(str);
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(120000));
//		wait.until(ExpectedConditions.visibilityOf(sector_options));
//		Select sector = new Select(sector_no);
//		sector.selectByVisibleText(str);
		
	}
	
	public void Click_serachBTN( WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Btn_serach));
		
		Btn_serach.click();
	}
	
	public void SelectCheque( WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Selectbox_cheque));
		
		Selectbox_cheque.click();
		Thread.sleep(2000);
	}
	
	public void ChequeclearBtn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(ClearChequeBtn));
		
		ClearChequeBtn.click();
		Thread.sleep(500);
		
		
	}
	
	public void ChequefailBtn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(FailChequeBtn));
		
		FailChequeBtn.click();
		Thread.sleep(500);
		
		
	}
	
	public void Yes_popUp(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Yes_popup));
		
		Yes_popup.click();
		Thread.sleep(2000);
	}
	
	public void Yes_popUp_NotCleared(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Yes_popup_for_notCleared));
		
		Yes_popup_for_notCleared.click();
		Thread.sleep(2000);
	}
	
	public void WaitTillGetClear( WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(PopUpAfterChequeClear));
		
		String successmessage =PopUpAfterChequeClear.getText();
		
		System.out.println(successmessage);
		
	}
	
	
	
	
	
}
