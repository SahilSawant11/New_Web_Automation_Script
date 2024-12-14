package pom_WaterTax;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataEntryPage_Water {
	
	////////////////////////////////////input-feilds//////////////////////////////////////////////
	@FindBy(xpath = "//*[@id='txtApplicantNameMarathi']") private WebElement applicant_marathi_name;
	@FindBy(xpath = "//*[@id='txtApplicantAddressMarathi']") private WebElement applicant_marathi_address;
	@FindBy(xpath = "//*[@id='txtShopNameMarathi']") private WebElement shop_name_marathi;
	@FindBy(xpath = "//*[@id='txtApplicantName']") private WebElement applicant_name;
	@FindBy(xpath = "//*[@id='txtApplicantAddress']") private WebElement applicant_address;
	@FindBy(xpath = "//*[@id='txtShopName']") private WebElement shop_name;
	@FindBy(xpath = "//*[@id='txtPinCode']") private WebElement pin;
	@FindBy(xpath = "//*[@id='txtMobileNo']") private WebElement mobile;
	@FindBy(xpath = "//*[@id='txtEmailID']") private WebElement mail;
	@FindBy(xpath = "//*[@id='txtGovNo']") private WebElement gov_no;
	@FindBy(xpath = "//*[@id='txtAdharCardNo']") private WebElement adhaar;
	@FindBy(xpath = "//*[@id='txtNoOfConnection']") private  WebElement no_of_connections;
	@FindBy(xpath = "//*[@id='txtNoOfFamilies']") private WebElement no_of_families;
	@FindBy(xpath = "//*[@id='txtNoOfPersons']") private WebElement no_of_persons;
	@FindBy(xpath = "//*[@id='txtNoOfToilets']") private WebElement no_oftoilets;
	@FindBy(xpath = "//*[@id='txtWaterWardNo']") private WebElement water_ward_no;
	@FindBy(xpath = "//*[@id='txtBlockNo']") private WebElement block_no;
	
	////////////////////////////////////chk-box//////////////////////////////////////////////
	@FindBy(xpath = "//section[@id='main-content']/section/div[2]/div/div/section[3]/div/div/div[2]/div/div/label/span[1]") private WebElement emaarat_chkbox;

	//////////////////////////////////////Buttons/////////////////////////////////////////////////////		
	@FindBy(xpath = "//*[@id='btnSaveProperty']") private WebElement save_btn;
	@FindBy(xpath= "//*[@id='btnDiscardApp']") private WebElement discard_btn;
	@FindBy(xpath = "(//button[@id='ImgDoc']/img)[6]") private WebElement upload_btn;
	@FindBy(xpath = "//*[@id='upload-1']") private WebElement choose_file;
	@FindBy(xpath = "//*[@id='upload-2']") private WebElement choose_file2;
	@FindBy(xpath = "//*[@id='btnUploadPopUp']") private WebElement pop_up_upload_btn;
	@FindBy(xpath = "//*[@id='btnUploadPopUp1']") private WebElement pop_up_upload_btn2;
	@FindBy(xpath = "//input[@id='btnupload' and @value='Upload']") private WebElement upload_btn_L;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='OK']") private WebElement ok_btn;
	@FindBy(xpath = "//button[contains(@class, 'confirm') and text()='Yes !']") private WebElement yes_btn;
	@FindBy(xpath ="//*[@id='ticketView']/div/div/div[3]/button") private WebElement close_btn;
	@FindBy(xpath = "//*[@id='btnPrint']") private WebElement notesheet_btn;
	@FindBy(xpath = "//*[@id='btnUploadNotesheet']") private WebElement upload_notesheet_btn;
	
	///////////////////////////////////////////////Page-Objects////////////////////////////////////////////////////////
	
	public DataEntryPage_Water(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//////////////////////////////////////Enter-Objects/////////////////////////////////////////////////////	
	
	public void Enter_marathi_name(String str)
	{
		applicant_marathi_name.clear();
		applicant_marathi_name.sendKeys(str);
	}
	
	public void Enter_marathi_address(String str) {
	    applicant_marathi_address.clear();
	    applicant_marathi_address.sendKeys(str);
	}

	public void Enter_shop_name_marathi(String str) {
	    shop_name_marathi.clear();
	    shop_name_marathi.sendKeys(str);
	}

	public void Enter_name(String str) {
	    applicant_name.clear();
	    applicant_name.sendKeys(str);
	}

	public void Enter_address(String str) {
	    applicant_address.clear();
	    applicant_address.sendKeys(str);
	}

	public void Enter_shop_name(String str) {
	    shop_name.clear();
	    shop_name.sendKeys(str);
	}

	public void Enter_pin(String str) {
	    pin.clear();
	    pin.sendKeys(str);
	}

	public void Enter_mobile(String str) {
	    mobile.clear();
	    mobile.sendKeys(str);
	}

	public void Enter_mail(String str) {
	    mail.clear();
	    mail.sendKeys(str);
	}

	public void Enter_gov_no(String str) {
	    gov_no.clear();
	    gov_no.sendKeys(str);
	}

	public void Enter_adhaar(String str) {
	    adhaar.clear();
	    adhaar.sendKeys(str);
	}

	public void Enter_no_of_connections(String str) {
	    no_of_connections.clear();
	    no_of_connections.sendKeys(str);
	}

	public void Enter_no_of_families(String str) {
	    no_of_families.clear();
	    no_of_families.sendKeys(str);
	}

	public void Enter_no_of_persons(String str) {
	    no_of_persons.clear();
	    no_of_persons.sendKeys(str);
	}

	public void Enter_no_of_toilets(String str) {
	    no_oftoilets.clear();
	    no_oftoilets.sendKeys(str);
	}

	public void Enter_water_ward_no(String str) {
	    water_ward_no.clear();
	    water_ward_no.sendKeys(str);
	}

	public void Enter_block_no(String str) {
	    block_no.clear();
	    block_no.sendKeys(str);
	}

	//////////////////////////////////////Select-Objects/////////////////////////////////////////////////////		
	
	public void Select_application_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[1]/div/div/section/div/div/div[1]/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[1]/div/div/section/div/div/div[1]/div/div/ul/li[3]/a"));
        dropdownOption.click();
    }
	
	public void Select_vibhaag(WebDriver driver) 
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[2]/div[3]/div/div[1]/div/div/div/button"));
        dropdownButton.click();
        WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[2]/div[3]/div/div[1]/div/div/div/div/ul/li[2]/a"));
        dropdownOption.click();
	}
	
	public void Select_bhaag(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[2]/div[3]/div/div[2]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[2]/div[3]/div/div[2]/div/div/div/div/ul/li[1]/a"));
		dropdownOption.click();
	}
	
	public void Select_building_type(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[3]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[3]/div/div/div/div/ul/li[2]/a"));
		dropdownOption.click();
	}
	
	public void Select_category_niyamit(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[4]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[4]/div/div/div/div/ul/li[2]/a"));
		dropdownOption.click();
	}
	
	public void Select_category_vaarshik(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[4]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[4]/div/div/div/div/ul/li[3]/a"));
		dropdownOption.click();
	}
	
	public void Select_use(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[5]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[5]/div/div/div/div/ul/li[2]/a"));
		dropdownOption.click();
	}
	
	public void Select_connection_size_six(WebDriver driver)
	{
		WebElement dropdownButton = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[7]/div/div/div/button"));
		dropdownButton.click();
		WebElement dropdownOption = driver.findElement(By.xpath("//*[@id='main-content']/section/div[2]/div[1]/div/section[3]/div[1]/div/div[7]/div/div/div/div/ul/li[11]/a"));
		dropdownOption.click();
	}

	
	//////////////////////////////////////Clicks-Objects/////////////////////////////////////////////////////		
	public void Click_emaarat(WebDriver driver)
	{
		emaarat_chkbox.click();
	}
	
	public void Click_upload_btn(WebDriver driver)
	{
		upload_btn.click();
	}
	
	public void Click_popup_upload_btn()
	{
		pop_up_upload_btn.click();
	}
	
	public void Click_popup_upload_btn2()
	{
		pop_up_upload_btn2.click();
	}
	
	public void Click_upload_btn_L() {
		upload_btn_L.click();
	}
	
	public void Click_save_btn()
	{
		save_btn.click();
	}
	
	public void Click_discard_btn() 
	{
		discard_btn.click();
	}
	
	public void Click_yes_btn() 
	{
		yes_btn.click();
	}
	
	public void Click_ok_btn() {
		ok_btn.click();
	}
	
	public void Click_notesheet_btn() {
		notesheet_btn.click();
	}
	
	public void Click_upload_notesheet_btn() {
		upload_notesheet_btn.click();
	}
	
	public void Click_close_btn()
	{
		close_btn.click();
	}
	
///////////////////////////////////////////////ChooseFile-Objects////////////////////////////////////////////////////////
	
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
	
	public void Button_choose_file_2(String str, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(choose_file2));
		
		Thread.sleep(2000);
		choose_file2.sendKeys(str);
		String s = "C:\\fakepath\\PDFFILE.pdf";
		String s1 = choose_file2.getAttribute("value");
		Thread.sleep(5000);
		while(!s1.equalsIgnoreCase(s))
		{
			Thread.sleep(500);
			s1 = choose_file2.getAttribute("value");
			System.out.println("no minor changes");
		}
		Thread.sleep(5000);
	}
	
	
}
