package pom_WaterTax;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage_Water {
	////////////////////////////////////buttons//////////////////////////////////////////////
	@FindBy(xpath = "//button[@id='btnGrievance']") private WebElement grievance_btn;
	@FindBy(xpath = "//button[@id='btnNewApplication']") private WebElement new_application_btn;
	@FindBy(xpath = "//button[@id = 'btnSaveGreavence']") private WebElement save_grievance_btn;
	@FindBy(xpath = "//button[@id = 'btnuploadDoc']") private WebElement upload_document;
	@FindBy(xpath = "//*[@id='btnSearchInTable']") private WebElement filter_btn;
	@FindBy(xpath = "//*[@id='btnApproved']") private WebElement approve_btn;
	@FindBy(xpath = "//*[@id='btClose']") private WebElement approval_close_btn;
	@FindBy(xpath ="//*[@id='ticketView']/div/div/div[3]/button") private WebElement close_btn;
	@FindBy(xpath = "//*[@id='btnPay']") private WebElement pay_btn;	//make-payment page
	@FindBy(xpath = "//*[@id='btnPayNow']") private WebElement paynow_btn; //make-payment page
	@FindBy(xpath = "//*[@id='btnDownloadReceipt']") private WebElement download_btn; // make-payment page
	@FindBy(xpath = "//*[@id='bTNbACK']") private WebElement search_btn; //make-payment page

	////////////////////////////////////chk-box//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='chkGrievanceID']") private WebElement chk_grievance_id;
	
	////////////////////////////////////input-feilds//////////////////////////////////////////////
	@FindBy(xpath = "//input[@id ='txtApplicantNameMarathi']") private WebElement marathi_name;
	@FindBy(xpath = "//input[@id = 'txtApplicantAddressMarathi']") private WebElement marathi_address;
	@FindBy(xpath = "//input[@id = 'txtApplicantNameEnglish']") private WebElement english_name;
	@FindBy(xpath = "//input[@id = 'txtApplicantAddressEnglish']") private WebElement english_address;
	@FindBy(xpath = "//input[@id = 'txtMobileNo']") private WebElement mobile_no;
	@FindBy(xpath = "//input[@id = 'txtRemark']") private WebElement remark;
	@FindBy(xpath = "//*[@id='dt-search-0']") private WebElement grievance_search_box;
	
	
	
	///////////////////////////////////////////////Page-Objects////////////////////////////////////////////////////////
	
	public DashboardPage_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void DashBoard_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "CMS/Dashboard";
		System.out.println(s2);
		
		driver.get(s2);
	}

	
	///////////////////////////////////////////////Enter-Objects////////////////////////////////////////////////////////
	
	public void Enter_marathi_name (String str)
	{
		marathi_name.clear();
		marathi_name.sendKeys(str);
	}
	
	public void Enter_marathi_address (String str)
	{
		marathi_address.clear();
		marathi_address.sendKeys(str);
	}
	
	public void Enter_english_name(String str)
	{
		english_name.clear();
		english_name.sendKeys(str);
	}
	
	public void Enter_english_address(String str)
	{
		english_address.clear();
		english_address.sendKeys(str);
	}
	
	public void Enter_mobile (String str)
	{
		mobile_no.clear();
		mobile_no.sendKeys(str);
	}
	
	public void Enter_remark (String str)
	{
		remark.clear();
		remark.sendKeys(str);
	}
	
	public void Enter_grievance_id (String str)
	{
		grievance_search_box.clear();
		grievance_search_box.sendKeys(str);
	}

	///////////////////////////////////////////////Click-Objects////////////////////////////////////////////////////////
	
	public void Click_takraar_nondva( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(grievance_btn));
		grievance_btn.click();
	}
	
	public void Click_new_application( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(new_application_btn));
		new_application_btn.click();
	}
	
	public void Click_save_complaint (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(save_grievance_btn));
		save_grievance_btn.click();
	}
	
	public void Click_close_btn()
	{
		close_btn.click();
	}
	
	public void Click_filter_btn()
	{
		filter_btn.click();
	}
	
	public void Click_approve_btn()
	{
		approve_btn.click();
	}
	
	public void Click_approval_close_btn() 
	{
		approval_close_btn.click();
	}
	
	public void Click_open_complaint (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(chk_grievance_id));
		chk_grievance_id.click();
	}
	
	public void Click_pay_btn() //make-payment page
	{
		pay_btn.click();
	}
	
	public void Click_paynow_btn() //make-payment page
	{
		paynow_btn.click();
	}
	
	public void Click_download_btn() // make-payment page
	{
		download_btn.click();
	}
	
	public void Click_search_btn() //make-payment page
	{
		search_btn.click();
	}
	
	
	///////////////////////////////////////////////Select-Objects////////////////////////////////////////////////////////
	
	public void Select_application_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='Section_FindProperty']/div/div/div[2]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='Section_FindProperty']/div/div/div[2]/div/div/ul/li[2]"));
        dropdownOption.click();
    }
	
	public void Select_complaint_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='ShowGrievanceType']/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='ShowGrievanceType']/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
    }
	
	public void Select_complaint_status_approval(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/div/ul/li[14]/a"));
        dropdownOption.click();
    }
	
	public void Select_complaint_status_make_payment(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/div/ul/li[9]"));
        dropdownOption.click();
    }

	public void Select_complaint_status_meter_pending(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='DivGrievances']/div/section/div[1]/div/div[4]/div/div/ul/li[11]/a"));
        dropdownOption.click();
    }
	
	public void Select_tap_size(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='show']/div/div/div/div/section[3]/div[1]/div[1]/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='show']/div/div/div/div/section[3]/div[1]/div[1]/div/div/div/ul/li[11]/a"));
        dropdownOption.click();
    }
	
	public void Select_billbook(WebDriver driver)	//make-payment page
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='paynow']/div[2]/div/div[2]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='paynow']/div[2]/div/div[2]/div/div/ul/li[2]/a"));
        dropdownOption.click();
	}
	
	public void Select_mode_cash(WebDriver driver) //make-payment page
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='paynow']/div[3]/div/div[2]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='paynow']/div[3]/div/div[2]/div/div/ul/li[1]/a"));
        dropdownOption.click();
		
	}
	///////////////////////////////////////////////Function-Objects////////////////////////////////////////////////////////
	
	public String fetch_id(WebDriver driver) {
	
		WebElement label = driver.findElement(By.xpath("//*[@id='lblShowApplicationID']"));
		
		String fullText = label.getText();

		String id = fullText.replaceAll(".*Token No. = (\\w+).*", "$1");

		return id;
	}
	
	
}
