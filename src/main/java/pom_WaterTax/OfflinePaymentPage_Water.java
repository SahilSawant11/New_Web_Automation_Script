package pom_WaterTax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfflinePaymentPage_Water {

	
	////////////////////////////////////input-feilds//////////////////////////////////////////////	
	@FindBy(xpath = "//*[@id='txtscansearch']") private WebElement scansearch;
	@FindBy(xpath = "//*[@id='txtMobileNo']") private WebElement mobile;
	
	////////////////////////////////////buttons//////////////////////////////////////////////////	
	@FindBy(xpath = "//*[@id='btnMakePayment']") private WebElement makepayment_btn;
	@FindBy(xpath = "//*[@id='btnPayNow']") private WebElement paynow_btn;
	@FindBy(xpath = "//*[@id='btnDownload']") private WebElement downloadreciept_btn;
	@FindBy(xpath = "//*[@id='ticketView']/div/div/div[3]/button") private WebElement close_btn;
	
	////////////////////////////////////labels//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='lblShowMeterStatus']") private WebElement meter_status;
	@FindBy(xpath = "//*[@id='lblShowConnectionStatus']") private WebElement connection_status;
	
	////////////////////////////////////page-objects//////////////////////////////////////////////
	public OfflinePaymentPage_Water(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	public void OfflinePayment_Page_link(String url, WebDriver driver)
	{

	String s1[] = url.split("/");
	String s2 = "";

	for(int j=0;j<s1.length-1;j++)
	{
	s2 += s1[j]+"/";
	}
	s2 += "WaterBill/TaxPayment";
	System.out.println(s2);

	driver.get(s2);
	}
	
	
	////////////////////////////////////Enter-objects//////////////////////////////////////////////
	public void Enter_scansearch(String str) 
	{
		scansearch.sendKeys(str);
	}
	
	public void Enter_mobile(String str) 
	{
		mobile.clear();
		mobile.sendKeys(str);
	}
	
	
	////////////////////////////////////Click-objects//////////////////////////////////////////////
	public void Click_makepayment_btn() 
	{
		makepayment_btn.click();
	}
	
	public void Click_paynow_btn() 
	{
		paynow_btn.click();
	}
	
	public void Click_downloadreciept_btn() 
	{
		downloadreciept_btn.click();
	}
	
	public void Click_close_btn() 
	{
		close_btn.click();
	}
	
	
	////////////////////////////////////Select-objects//////////////////////////////////////////////
	public void Select_billbook(WebDriver driver) throws InterruptedException
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='section-bill']/div[2]/div/div[1]/div/button"));
        dropdownButton.click();
        Thread.sleep(2000);
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='section-bill']/div[2]/div/div[1]/div/div/ul/li[3]/a"));
        dropdownOption.click();									
    }
	
	public void printLabelTexts_counter() {
	    System.out.println("Meter Status Counter: " + meter_status.getText());
	    System.out.println("Connection Status Counter: " + connection_status.getText());
	}
	
	public String meterStatus()
	{
		String meterStatus = meter_status.getText();
		return meterStatus;
		
	}
	
	public String connectionStatus() {
		String connectionStatus = connection_status.getText();
		return connectionStatus;
	}
	
}
