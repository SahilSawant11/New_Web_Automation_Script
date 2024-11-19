package pom_TradeLicense;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationApprovalPage {
	
//	@FindBy(xpath = "//select[@id=\'ddlNode']") private WebElement node;
//	@FindBy(xpath = "//select[@id=\'ddlSector']") private WebElement sector;
//	@FindBy (xpath= "//input[@id=\'txtPropertyPartitionNo']") private WebElement propertyno;
	
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
	
//	public void select_node_no( WebDriver driver)
//	{
//		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait3.until(ExpectedConditions.visibilityOf(node));
//		
//		Select s = new Select(node);
//		s.selectByValue("2");
//	}
//	
//	public void select_sector_no( WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(sector));
//		
//		Select s = new Select(sector);
//		s.selectByValue("KH10");
//	}
//	
//	public void enter_property_no( WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//		wait.until(ExpectedConditions.visibilityOf(propertyno));
//		propertyno.sendKeys("7-2");
//	}
//	
	
}
