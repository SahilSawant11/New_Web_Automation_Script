package pom_WaterTax;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeterPage_Water {

	///////////////////////////////////////inputs-feilds///////////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtMeterNo']") private WebElement meter_no;
	@FindBy(xpath = "//*[@id='txtMeterCost']") private WebElement meter_cost;
	@FindBy(xpath = "//*[@id='txtMeterCompany']") private WebElement meter_company;
	@FindBy(xpath = "//*[@id='txtMaxMeterReading']") private WebElement max_reading;
	@FindBy(xpath = "//*[@id='txtMeterReceivingDate']") private WebElement recieving_date;
	@FindBy(xpath = "//*[@id='txtMeterReadingBeforeTest']") private WebElement reading_before;
	@FindBy(xpath = "//*[@id='txtMeterReadingAfterTest']") private WebElement reading_after;
	@FindBy(xpath = "//*[@id='txtMeterTestingDate']") private WebElement testing_date;
	@FindBy(xpath = "//*[@id='txtMeterRemark']") private WebElement meter_remark;
	@FindBy(xpath ="//*[@id='txtAutoFillConsumerNo']") private WebElement consumer_no;
	
	////////////////////////////////////////////////buttons/////////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnSaveProperty']") private WebElement save_btn;
	@FindBy(xpath = "(//button[@id='ImgDoc']/img)[2]") private WebElement upload_btn;
	@FindBy(xpath = "//*[@id='upload-1']") private WebElement choose_file;
	@FindBy(xpath = "//*[@id='btnUploadPopUp']") private WebElement pop_up_upload_btn;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='OK']") private WebElement ok_btn;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='Yes !']") private WebElement yes_btn;
	@FindBy(xpath = "//*[@id='btnPrint']") private WebElement karyadesh_btn;
	@FindBy(xpath = "//*[@id='ticketView']/div/div/div[3]/button") private WebElement close_btn;
	
	///////////////////////////////////////////////Page-Objects////////////////////////////////////////////////////////
	
	public MeterPage_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	///////////////////////////////////////////////Enter-Objects////////////////////////////////////////////////////////
	
	public void Enter_meter_no(String str) {
	    meter_no.clear();
	    // Generate a random number
	    int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999); // Generates a number between 1000 and 9999
	    String randomMeterNo = str + randomNum;
	    meter_no.sendKeys(randomMeterNo);
	}
	
	public void Enter_meter_cost(String str)
	{
		meter_cost.clear();
		meter_cost.sendKeys(str);
	}
	
	public void Enter_meter_company(String str) 
	{
		meter_company.clear();
		meter_company.sendKeys(str);
	}
	
	public void Enter_max_reading(String str)
	{
		max_reading.clear();
		max_reading.sendKeys(str);
	}

	public void Enter_reading_before(String str)
	{
		reading_before.clear();
		reading_before.sendKeys(str);
	}

	public void Enter_reading_after(String str) 
	{
		reading_after.clear();
		reading_after.sendKeys(str);
	}
	
	public void Enter_meter_remark(String str)
	{
		meter_remark.clear();
		meter_remark.sendKeys(str);
	}

	///////////////////////////////////////////////Click-Objects////////////////////////////////////////////////////////
	
	public void Click_upload_btn(WebDriver driver)
	{
		upload_btn.click();
	}
	
	public void Click_recieve_date_box()
	{
		recieving_date.click();
	}
	
	public void Click_test_date_box() 
	{
		testing_date.click();
	}
	
	public void Click_yes_btn() 
	{
		yes_btn.click();
	}
	
	public void Click_ok_btn() 
	{
		ok_btn.click();
	}
	
	public void Click_popup_upload_btn()
	{
		pop_up_upload_btn.click();
	}
	
	public void Click_save_btn()
	{
		save_btn.click();
	}
	
	public void Click_karyadesh()
	{
		karyadesh_btn.click();
	}
	
	public void Click_close_btn() 
	{
		close_btn.click();
	}
	
	///////////////////////////////////////////////Select-Objects////////////////////////////////////////////////////////
	
	public void Select_tap_size_six(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[1]/div/div[2]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[1]/div/div[2]/div/div/div/div/ul/li[11]/a"));
		dropdownOption.click();
	}
	
	public void Select_meter_status_start(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[2]/div/div[3]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[2]/div/div[3]/div/div/div/div/ul/li[2]/a"));
		dropdownOption.click();
	}
	
	public void Select_meter_test_yes(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[2]/div/div[4]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='meterSection']/div/div[2]/div/div[4]/div/div/div/div/ul/li[3]/a"));
		dropdownOption.click();
	}
	
	///////////////////////////////////////////////Function-Objects////////////////////////////////////////////////////////
	
	public void Button_choose_file(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(choose_file));
		
		Thread.sleep(2000);
		choose_file.sendKeys(str);
		String s = "C:\\fakepath\\PDFFILE.pdf";
		String s1 = choose_file.getAttribute("value");
		Thread.sleep(5000);
		while(!s1.equalsIgnoreCase(s))
		{
			Thread.sleep(500);
			s1 = choose_file.getAttribute("value");
			System.out.println("no minor changes");
		}
		Thread.sleep(5000);
	}
	
	public String Get_Consumer_id()
	{
		String consumerID = consumer_no.getAttribute("value");
		return consumerID;
		
	}
	
	
}
