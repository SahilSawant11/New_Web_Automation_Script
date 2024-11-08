package pom;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMS_Page {

	@FindBy(xpath="//input[@id='ContentPlaceHolder1_btnSearchProperty']") private WebElement register_Grievance;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlNodeNo']") private WebElement node_no;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSectorNo']") private WebElement sector_no;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSectorNo']//option[2]") private WebElement sector_no_option;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPropertyNo']") private WebElement property_no;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnNewProp']") private WebElement new_property_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnGetProperty']") private WebElement get_property_btn;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtProp']") private WebElement get_building_no;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_createNewProp']") private WebElement building_btn;
	
	@FindBy(xpath = "//button[text()='OK']") private WebElement ok_btn;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnGnrtCmplnt']") private WebElement akshep_nondava_btn;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCmplntType']") private WebElement aakshep_prakar;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCmplntDate']") private WebElement date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMobile']") private WebElement mobile;
	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtRemark']") private WebElement remark;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSVCmplnt']") private WebElement akshep_nondava_btn2;
	
	@FindBy(xpath = "//button[text()='Yes']") private WebElement yes_btn;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblCmplntID']") private WebElement akshep_no;
	@FindBy(xpath = "//span[@id='BtnFilter']") private WebElement filter_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFilterComplaintID']") private WebElement complaint_Id;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnFind']") private WebElement Search_property;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVObjDtl\"]/tbody/tr[2]/td[2]") private WebElement grievance_id;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVObjDtl\"]/tbody/tr[2]/td[1]/input") private WebElement grivance_select_btn;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnMakeCorrection']") private WebElement make_correction_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnForApproval']") private WebElement verify_correction_btn;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement pageloading;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gridAppealTaxInfo_lblTotal_0']") private WebElement ekunKar;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gridAppealTaxInfo_lblTotal_0']") private WebElement samanyaKar;
	
	
	
	public CMS_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	private static Map<String, String> storedTaxValues = new HashMap<String, String>();
	
	
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
	
	public void Button_register_Grievance(WebDriver driver)
	{
		register_Grievance.click();
	}
	
	public void select_node_no(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(node_no));
		
		Select s = new Select(node_no);
		s.selectByValue(str);
	}
	
	public void select_sector_no(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(sector_no_option));
		
		Select s = new Select(sector_no);
		s.selectByValue(str);
	}
	
	public void Enter_property_no(String str, WebDriver driver) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(property_no));
		Thread.sleep(500);
		property_no.sendKeys(str);
	}
	
	
	
	
	
	public void Button_new_property_btn() throws InterruptedException
	{
		Thread.sleep(1000);
		
		new_property_btn.click();
	}
	
	public void Button_get_property_btn() throws InterruptedException
	{
		Thread.sleep(1000);
		get_property_btn.click();
	}
	
	
	public String Fetch_get_building_no(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(get_building_no));
		
		String val = get_building_no.getAttribute("value");
		
		return val;
	}
	
	public void Button_building_btn()
	{
		building_btn.click();
	}
	
	public void Button_ok_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(ok_btn));
		Thread.sleep(500);
		ok_btn.click();
	}
	
	public void Display_akshep_nondava_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(akshep_nondava_btn));
	}
	
	public void Button_akshep_nondava_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(akshep_nondava_btn));
		
		akshep_nondava_btn.click();
	}
	
	public void select_aakshep_prakar(String str, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(aakshep_prakar));
		
		Select s = new Select(aakshep_prakar);
		s.selectByVisibleText(str);
	}
	
	public void Enter_date(String str)
	{
		date.clear();
		date.sendKeys(str);
	}
	
	public void Enter_mobile(String str)
	{
		mobile.clear();
		mobile.sendKeys(str);
	}
	
	
	public void Enter_remark(String str)
	{
		remark.clear();
		remark.sendKeys(str);
	}
	
	public void Button_akshep_nondava_btn2(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(akshep_nondava_btn2));
		
		akshep_nondava_btn2.click();
	}
	
	public void Button_yes_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(yes_btn));
		Thread.sleep(1000);
		yes_btn.click();
	}
	
	public String fetch_akshep_no(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(akshep_no));
		
		String s = akshep_no.getText();
		return s;
	}
	
	public void Button_filter_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(filter_btn));
		Thread.sleep(500);
		filter_btn.click();
	}
	
	public void Enter_complaint_Id(WebDriver driver, String str) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(complaint_Id));
		Thread.sleep(500);
		complaint_Id.sendKeys(str);
	}
	
	public void Button_Search_property(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(Search_property));
		Thread.sleep(500);
		Search_property.click();
	}
	
	public String Fetch_grievance_id(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(grievance_id));
		
		Thread.sleep(2000);
		String val = grievance_id.getText();
		return val;
	}
	
	public void Button_grivance_select_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(grivance_select_btn));
		Thread.sleep(500);
		grivance_select_btn.click();
	}
	
	public void icon_pageloading() throws InterruptedException
	{
		Thread.sleep(1000);
		while(pageloading.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting for complaint to search");
		}
		Thread.sleep(500);
	}
	
	public void Button_make_correction_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(make_correction_btn));
		
		make_correction_btn.click();
	}
	
	public void Button_verify_correction_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(verify_correction_btn));
		
		verify_correction_btn.click();
	}
	
	
	public void CMS_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "CMS.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void councilapproval_link(String url, WebDriver driver) throws InterruptedException
	{
		
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "CouncilApproval.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public static String getStoredTaxValue(String key) {
        return storedTaxValues.get(key);

	}
	
	public void EkunKarStoredValue(String str)
	{
		String EkunKar = ekunKar.getAttribute("value");
		storedTaxValues.put("Ekun Kar", EkunKar);
	}
	
	public void SamanyaKarStoredValue(String str)
	{
		String SamanyaKar = samanyaKar.getAttribute("value");
		storedTaxValues.put("Samanya Kar", SamanyaKar);
	}
	
}
