package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ScrollPage;

public class OldTaxesPage {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldWardNo']") private WebElement oldWardNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldPropertyNo']") private WebElement oldPropertyNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldPartitionNo']") private WebElement oldPartitionNo;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldCSNo']") private WebElement oldCityServey;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldRV']") private WebElement oldRV;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldPropertyTax']") private WebElement oldPropertyTax;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOldTotalTax']") private WebElement oldTaxTotal;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlYear']") private WebElement oldYear;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPropTax']") private WebElement propTax;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEduTax']") private WebElement EduTax;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSpEduTax']") private WebElement spEduTax;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEmpTax']") private WebElement EmpTax;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTreeCess']") private WebElement treeCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFireCess']") private WebElement fireCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtlightCess']") private WebElement lightCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDrainCess']") private WebElement drainCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRoadCess']") private WebElement roadCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSanitation']") private WebElement sanitation;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaterCess']") private WebElement waterCess;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaterBenifit']") private WebElement waterBenifit;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWaterBill']") private WebElement waterBill;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMBuild']") private WebElement Mbuilding;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSewage']") private WebElement sewage;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTax1']") private WebElement Tax1;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTaxx2']") private WebElement Tax2;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTaxx3']") private WebElement Tax3;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtInterest']") private WebElement interest;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRemark']") private WebElement remark;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnAddTaxPending']") private WebElement addOldTaxes_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnTaxPenSave']") private WebElement saveOldTaxes_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnTaxPendingUploadDocument']") private WebElement addTaxes_btn;
	
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;

	
	
	public OldTaxesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_oldWardNo(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(oldWardNo));
		
		oldWardNo.clear();
		oldWardNo.sendKeys(str);
	}
	
	public void Enter_oldPropertyNo(String str)
	{
		oldPropertyNo.clear();
		oldPropertyNo.sendKeys(str);
	}
	
	public void Enter_oldPartitionNo(String str)
	{
		oldPartitionNo.clear();
		oldPartitionNo.sendKeys(str);
	}
	
	public void Enter_oldCityServey(String str)
	{
		oldCityServey.clear();
		oldCityServey.sendKeys(str);
	}
	
	public void Enter_oldRV(String str)
	{
		oldRV.clear();
		oldRV.sendKeys(str);
	}
	
	public void Enter_oldPropertyTax(String str)
	{
		oldPropertyTax.clear();
		oldPropertyTax.sendKeys(str);
	}
	
	public void Enter_oldTaxTotal(String str)
	{
		oldTaxTotal.clear();
		oldTaxTotal.sendKeys(str);
	}
	
	public void Enter_oldYear(String str)
	{
		Select s = new Select(oldYear);
		s.selectByValue(str);
	}
	
	public void Enter_propTax(String str)
	{
		propTax.clear();
		propTax.sendKeys(str);
	}
	
	public void Enter_EduTax(String str)
	{
		EduTax.clear();
		EduTax.sendKeys(str);
	}
	
	public void Enter_spEduTax(String str)
	{
		spEduTax.clear();
		spEduTax.sendKeys(str);
	}
	
	
	
	public void Enter_EmpTax(String str)
	{
		EmpTax.clear();
		EmpTax.sendKeys(str);
	}
	
	public void Enter_treeCess(String str)
	{
		treeCess.clear();
		treeCess.sendKeys(str);
	}
	
	public void Enter_fireCess(String str)
	{
		fireCess.clear();
		fireCess.sendKeys(str);
	}
	
	public void Enter_lightCess(String str)
	{
		lightCess.clear();
		lightCess.sendKeys(str);
	}
	
	public void Enter_drainCess(String str)
	{
		drainCess.clear();
		drainCess.sendKeys(str);
	}
	
	public void Enter_roadCess(String str)
	{
		roadCess.clear();
		roadCess.sendKeys(str);
	}
	
	public void Enter_sanitation(String str)
	{
		sanitation.clear();
		sanitation.sendKeys(str);
	}
	
	public void Enter_waterCess(String str)
	{
		waterCess.clear();
		waterCess.sendKeys(str);
	}
	
	public void Enter_waterBenifit(String str)
	{
		waterBenifit.clear();
		waterBenifit.sendKeys(str);
	}
	
	public void Enter_waterBill(String str)
	{
		waterBill.clear();
		waterBill.sendKeys(str);
	}
	
	public void Enter_Mbuilding(String str)
	{
		Mbuilding.clear();
		Mbuilding.sendKeys(str);
	}
	
	public void Enter_sewage(String str)
	{
		sewage.clear();
		sewage.sendKeys(str);
	}
	
	public void Enter_Tax1(String str)
	{
		Tax1.clear();
		Tax1.sendKeys(str);
	}
	
	public void Enter_Tax2(String str)
	{
		Tax2.clear();
		Tax2.sendKeys(str);
	}
	
	public void Enter_Tax3(String str)
	{
		Tax3.clear();
		Tax3.sendKeys(str);
	}
	
	public void Enter_interest(String str)
	{
		interest.clear();
		interest.sendKeys(str);
	}
	
	public void Enter_remark(String str)
	{
		remark.clear();
		remark.sendKeys(str);
	}
	
	public void Button_addOldTaxes_btn(WebDriver driver) throws InterruptedException
	{
		addOldTaxes_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		ScrollPage.scrollTestPage(driver, addOldTaxes_btn);
	}

	public void Button_saveOldTaxes_btn(WebDriver driver) throws InterruptedException
	{
		ScrollPage.scrollTestPage(driver, saveOldTaxes_btn);
		Thread.sleep(1000);
		
		saveOldTaxes_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_addTaxes_btn(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addTaxes_btn);
		Thread.sleep(1000);
		
		addTaxes_btn.click();
	}
		
}
