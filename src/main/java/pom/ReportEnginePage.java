package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportEnginePage {

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlpropwise1']") private WebElement select_node;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlpropwise2']") private WebElement select_sector;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtPropertyWise']") private WebElement select_propertyno_wise_checkbox;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlReportPropwise']") private WebElement select_report_name;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVWard_chkSingle_5']") private WebElement select_propertyno_6_checkbox;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvpartionno_chkAll']") private WebElement select_partitionno_all_checkbox;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnExportpropwise']") private WebElement export_btn;
	
	public ReportEnginePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Select_propertyno_wise_checkbox(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_propertyno_wise_checkbox));
		select_propertyno_wise_checkbox.click();
	}
	
	public void Select_Node(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_node));
		Select node = new Select(select_node);
		
		
		
		try {
			node.selectByValue("BMC");
		} catch (Exception e) {
			node.selectByValue("KM");
		}
	}
	
	public void Select_sector_no(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_sector));
		Select sector = new Select(select_sector);
		sector.selectByValue("2");
	}
	
	public void Select_propertyno_50_checkbox(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_propertyno_6_checkbox));
		select_propertyno_6_checkbox.click();
	}
	
	public void Select_partitionno_all_checkbox(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_partitionno_all_checkbox));
		select_partitionno_all_checkbox.click();
	}
	
	public void Select_report_type_notice(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_report_name));
		Select type = new Select(select_report_name);
		type.selectByValue("1");
	}
	
	public void Select_report_type_karakarni(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(select_report_name));
		Select type = new Select(select_report_name);
		type.selectByValue("3");
	}
	
	public void Export_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOf(export_btn));
		export_btn.click();
	}
	
	public void Report_Engine_Page_link(String url, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "ReportEngine.aspx";
		System.out.println(s2);
		
		driver.get(s2);
	}

}
