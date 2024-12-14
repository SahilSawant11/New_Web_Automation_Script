package pom_WaterTax;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportEnginePage_Water {
	////////////////////////////////////input-feilds//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtAmount']") private WebElement taxamount;
	@FindBy(xpath = "//*[@id='txtTopN']") private WebElement topN;
	
	////////////////////////////////////buttons//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='btnShow']") private WebElement show_btn;
	@FindBy(xpath = "//*[@id='btnRpt']") private WebElement downloadreport_btn;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='Yes']") private WebElement yes_btn;
	@FindBy(xpath = "//*[@id='ticketView']/div/div/div[3]/button") private WebElement close_btn;
	
	///////////////////////////////////////////////Page-Objects////////////////////////////////////////////////////////
	
	public ReportEnginePage_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ReportEngine_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "waterbill/ReportEngine";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	///////////////////////////////////////////////Enter-Objects////////////////////////////////////////////////////////
	
	public void Enter_amount(String str) 
	{
		taxamount.clear();
		taxamount.sendKeys(str);
	}
	
	public void Enter_topN(String str) 
	{
		topN.clear();
		topN.sendKeys(str);
	}

	///////////////////////////////////////////////Click-Objects////////////////////////////////////////////////////////
	
	public void Click_show_btn() 
	{
		show_btn.click();
	}
	
	public void Click_download_btn() 
	{
		downloadreport_btn.click();
	}
	
	public void Click_yes_btn() 
	{
		yes_btn.click();
	}
	
	public void Click_close_btn() 
	{
		close_btn.click();
	}
	
	///////////////////////////////////////////////Select-Objects////////////////////////////////////////////////////////
	
	public void Select_topdefaulter_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
    }
	
	public void Select_goshwara_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='Section_Connection']/div[2]/div[1]/div/div/div/ul/li[5]/a"));
        dropdownOption.click();
    }
	
	public void Select_node_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divzone']/div[1]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divzone']/div[1]/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_type_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divConnectionType']/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divConnectionType']/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_finance_year(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divYearType1']/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divYearType1']/div/div/div/ul/li[7]/a"));
        dropdownOption.click();
    }
	
	public void Select_category_niyamit(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divconnectionCategory']/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divconnectionCategory']/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
    }
	
	public void Select_size_all(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divTypeSize']/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divTypeSize']/div/div/ul/li[1]/a/label"));
        dropdownOption.click();
        dropdownButton.click();
    }
	
	public void Select_subtype_wardwise(WebDriver driver) 
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='divSubReport']/div/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='divSubReport']/div/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
	}
	
///////////////////////////////////////////////Function-Objects////////////////////////////////////////////////////////
	
	public void scroll_to_bottom(WebDriver driver) throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    Thread.sleep(2000);
	}
}
