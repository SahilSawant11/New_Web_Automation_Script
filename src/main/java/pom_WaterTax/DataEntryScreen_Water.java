package pom_WaterTax;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataEntryScreen_Water {

	//////////////////////////////////////////////input-feilds///////////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtconsumerNo']") private WebElement consumer_no;
	
	/////////////////////////////////////////////labels/////////////////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='lblConnectionCategory']") private WebElement category;
	@FindBy(xpath = "//*[@id='lblConnectionSize']") private WebElement size;
	@FindBy(xpath = "//*[@id='lblApplicationNo']") private WebElement application_no;
	@FindBy(xpath = "//*[@id='lblShowConsumerNo']") private WebElement show_consumer_no;
	@FindBy(xpath = "//*[@id='lblSection']") private WebElement section;
	@FindBy(xpath = "//*[@id='lblDivision']") private WebElement division;
	@FindBy(xpath = "//*[@id='lblRate']") private WebElement rate;
	@FindBy(xpath = "//*[@id='lblMeterNo']") private WebElement meter_no;
	@FindBy(xpath = "//*[@id='lblMeterStatus']") private WebElement meter_status;
	@FindBy(xpath = "//*[@id='lblConnectionStatus']") private WebElement connection_status;
	@FindBy(xpath = "//*[@id='lblConnectionStopDate']") private WebElement connection_stop_date;

	///////////////////////////////////////////////buttons///////////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='DBtnSearch']") private WebElement search_btn;
	
	///////////////////////////////////////////////Page-Objects////////////////////////////////////////////////////////
	
	public DataEntryScreen_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void DataEntry_Screen_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "WaterBill/DataEntry";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void clickSearchButton()
	{
		search_btn.click();
	}
	
	public void enterConsumerNo(String str)
	{
		consumer_no.clear();
		consumer_no.sendKeys(str);
	}
	
	public void printLabelTexts_dataEntry() {
	    System.out.println("Category: " + category.getText());
	    System.out.println("Size: " + size.getText());
	    System.out.println("Application No: " + application_no.getText());
	    System.out.println("Consumer No: " + show_consumer_no.getText());
	    System.out.println("Section: " + section.getText());
	    System.out.println("Division: " + division.getText());
	    System.out.println("Rate: " + rate.getText());
	    System.out.println("Meter No: " + meter_no.getText());
	    System.out.println("Meter Status Data Entry: " + meter_status.getText());
	    System.out.println("Connection Status Data Entry: " + connection_status.getText());
	    System.out.println("Connection Stop Date: " + connection_stop_date.getText());
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
