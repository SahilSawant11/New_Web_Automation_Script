package pom_WaterTax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionReportPage_Water {

	////////////////////////////////////input-feilds//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtFromDate']") private WebElement fromdate;
	@FindBy(xpath = "//*[@id='txtToDate']") private WebElement todate;
	
	////////////////////////////////////buttons//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnCollRpt']") private WebElement reportsearch_btn;

	
	////////////////////////////////////page-objects//////////////////////////////////////////////
	public CollectionReportPage_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CollectionReport_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "WaterBill/CollectionReport";
		System.out.println(s2);
		
		driver.get(s2);
	}

	
	////////////////////////////////////Enter-objects//////////////////////////////////////////////
	public void Enter_from_date(String str) 
	{
		fromdate.clear();
		fromdate.sendKeys(str);
	}
	
	
	////////////////////////////////////Click_objects//////////////////////////////////////////////
	public void Click_to_date() 
	{
		todate.click();
	}
	
	public void Click_search_btn() 
	{
		reportsearch_btn.click();
	}
	
	
	////////////////////////////////////Select-objects//////////////////////////////////////////////
	public void Select_type_collection_details(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
    }
	
	public void Select_subtype_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[3]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[3]/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
    }
	
	public void Select_node_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divzone']/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divzone']/div[1]/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
    }
	
	public void Select_sector_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divzone']/div[2]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divzone']/div[2]/div/ul/li[1]/a/label"));
        dropdownOption.click();
    }
	
	public void Select_finance_year(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divYearType']/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divYearType']/div[1]/div/div/div/ul/li[7]/a"));
        dropdownOption.click();
    }
	
	public void Select_billbook_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divBBLInvoice']/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divBBLInvoice']/div[1]/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_resource_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divPayResources']/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divPayResources']/div[1]/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_mode_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='DivCounterPayMode']/div/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='DivCounterPayMode']/div/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_user_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='DivUser']/div/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='DivUser']/div/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
}
