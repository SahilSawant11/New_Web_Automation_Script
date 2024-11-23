package pom_TradeLicense;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataEntryPage_TradeLicense {

	@FindBy(xpath = "//select[@id=\'ddlNode']") private WebElement node;
	@FindBy(xpath = "//select[@id=\'ddlSector']") private WebElement sector;
	@FindBy (xpath= "//input[@id=\'txtPropertyPartitionNo']") private WebElement propertyno;
	@FindBy (xpath= "//input[@id=\'btnSearchProperty']") private WebElement searchproperty;
	@FindBy (xpath= "//input[@id=\'txtApplicantEngName']") private WebElement nameEng;
	@FindBy (xpath= "//input[@id=\'id 1']") private WebElement nameMar;
	@FindBy (xpath= "//input[@id=\'txtEmailId']") private WebElement 	email;
	@FindBy (xpath= "//input[@id=\'txtMobNo']") private WebElement mobile;
	@FindBy (xpath= "//input[@id=\'txtAadharNo']") private WebElement adhaar;
	@FindBy (xpath= "//input[@id=\'txtPanNo']") private WebElement pan;
	@FindBy (xpath= "//input[@id=\'txtCity']") private WebElement city;
	@FindBy (xpath= "//input[@id=\'txtPinCode']") private WebElement pincode;
	@FindBy (xpath= "//input[@id=\'txtWingNo']") private WebElement wing;
	@FindBy (xpath= "//input[@id=\'txtPlotNo']") private WebElement plot;
	@FindBy (xpath= "//input[@id=\'txtFlatNo']") private WebElement flat;
	@FindBy (xpath= "//input[@id=\'txtSocietyName']") private WebElement society_name;
	@FindBy (xpath= "//input[@id=\'txtAddress']") private WebElement address;
	@FindBy (xpath= "//button[@id=\'addfieldbtn']") private WebElement addmore;
	@FindBy (xpath= "//select[@id=\'ddlDistrict']") private WebElement district;
	@FindBy (xpath= "//*[@id=\'agreebtn']") private WebElement agreebtn;
	@FindBy (xpath= "//*[@id=\'btnsubmit']") private WebElement submitbtn;
	@FindBy (xpath= "//*[@id=\'btnPrintApplication\']") private WebElement printbtn;
	
	
	@FindBy (xpath= "//select[@id=\'ddlLicenceMainTypeID']") private WebElement businessType;
	@FindBy (xpath= "//select[@id=\'ddlLicenceType']") private WebElement licenseType;
	@FindBy (xpath= "//select[@id=\'ddlPropertyType']") private WebElement propertyType;
	@FindBy (xpath= "//select[@id=\'ddlLicensePeriod']") private WebElement licensePeriod;
	@FindBy (xpath= "//select[@id=\'ddlPremiseType']") private WebElement premiseType;
	@FindBy (xpath= "//select[@id=\'ddlNatureoftrade']") private WebElement natureofTrade;
	@FindBy (xpath= "//select[@id=\'ddlBusinessStyle']") private WebElement bStyle;
	@FindBy (xpath= "//select[@id=\'ddlBusinessStatus']") private WebElement statusofBusiness;
	@FindBy (xpath= "//select[@id=\'ddlOccupancyCerti']") private WebElement OC;
	
	@FindBy (xpath= "//input[@id=\'txtTotalAreaSqMtr']") private WebElement totalArea;
	@FindBy (xpath= "//input[@id=\'txtCommeceDate']") private WebElement commDate;
	@FindBy (xpath= "//input[@id=\'txtOccupancyDate']") private WebElement ocDate;
	@FindBy (xpath= "//input[@id=\'txtTINGSTNo']") private WebElement gstNo;
	@FindBy (xpath= "//input[@id=\'txtSHELEmailID']") private WebElement emailBusiness;
	@FindBy (xpath= "//input[@id=\'txtSHELMobileNo']") private WebElement mobileBusiness;
	@FindBy (xpath= "//input[@id=\'txtSHELLandlineNo']") private WebElement landlineno;
	@FindBy (xpath= "//input[@id=\'txtBAadharNo']") private WebElement adhaarBussiness;
	@FindBy (xpath= "//input[@id=\'txtBPanNo']") private WebElement panBusiness;
	@FindBy (xpath= "//input[@id=\'txtBPanNo']") private WebElement plotBussiness;
	@FindBy (xpath= "//input[@id=\'txtBWingNo']") private WebElement wingBussiness;
	@FindBy (xpath= "//input[@id=\'txtBShopNo']") private WebElement shopno;
	@FindBy (xpath= "//input[@id=\'txtBSocietyName']") private WebElement societyName;
	@FindBy (xpath= "//input[@id=\'txtBAddress']") private WebElement addressBusiness;
	@FindBy (xpath= "//input[@id=\'txtnameOfBusiness']") private WebElement shopname;
	
	@FindBy (xpath= "//input[@id=\'file32316']") private WebElement choose_file;
	@FindBy(xpath = "//*[@id='lblApplicationNo']") private WebElement application_no;
	
	
	public DataEntryPage_TradeLicense (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void DataEntry_Page_link(String url, WebDriver driver)
	{
		
		String s1[] = url.split("/");
		String s2 = "";
		
		for(int j=0;j<s1.length-1;j++)
		{
			s2 += s1[j]+"/";
		}
		s2 += "SHEL/DataEntry";
		System.out.println(s2);
		
		driver.get(s2);
	}
	
	public void select_node_no( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(node));
		
		Select s = new Select(node);
		s.selectByValue("2");
	}
	
	public void select_sector_no( WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(sector));
		
		Select s = new Select(sector);
		s.selectByValue("KH10");
	}
	
	public void enter_property_no( WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(propertyno));
		propertyno.sendKeys("15-7");
	}
	
	public void scroll_to_bottom(WebDriver driver) throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    Thread.sleep(2000);
	}
	
	public void scroll_to_top(WebDriver driver) throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	    Thread.sleep(2000);
	}


	
	public void scrollbypixdown(WebDriver driver) throws InterruptedException
	{
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		Thread.sleep(2000);

	}
	
	public void scrollbypixup(WebDriver driver)
	{
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(500, 0);");

	}
	 
	public void search_property(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(searchproperty));
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		searchproperty.click();
				
	}
	
	public void clickDeleteOwners(WebDriver driver, int startId, int endId) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    boolean isClicked = false;
	    
	    // Loop through the range of IDs
	    for (int i = startId; i <= endId; i++) {
	        String partialId = "span" + i;

	        try {
	            // Use dynamic XPath that finds the element with partial ID
	            WebElement deleteOwner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, '" + partialId + "')]")));

	            // Scroll the element into view (optional)
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", deleteOwner);

	            // Wait until the element is clickable
	            wait.until(ExpectedConditions.elementToBeClickable(deleteOwner));

	            // Click on the deleteOwner element
	            deleteOwner.click();
	            System.out.println("Clicked on the 'delete' span element with ID: " + partialId);
	            isClicked = true;

	            // Optionally add a small delay to avoid overwhelming the system (e.g., wait for page updates)
	            Thread.sleep(500); // 0.5 second delay, adjust as needed.

	        } catch (NoSuchElementException e) {
	            System.out.println("No 'delete' span element found with ID: " + partialId);
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click was intercepted for ID: " + partialId);
	        } catch (Exception e) {
	            System.out.println("Error while clicking the 'delete' span with ID: " + partialId + " - " + e.getMessage());
	        }
	    }

	    // Log the final message after the loop
	    System.out.println("Finished attempting to delete owners in the specified range.");
	}

	public void clickDeleteOwner2(WebDriver driver, int startId, int endId) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    boolean isClicked = false;

	    // Loop through the range of IDs
	    for (int i = startId; i <= endId; i++) {
	        String partialId2 = "span" + i;

	        try {
	            // Use dynamic XPath that finds the element with partial ID
	            WebElement deleteOwner2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, '" + partialId2 + "')]")));

	            // Scroll the element into view (optional)
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", deleteOwner2);

	            // Wait until the element is clickable
	            wait.until(ExpectedConditions.elementToBeClickable(deleteOwner2));

	            // Click on the deleteOwner element
	            deleteOwner2.click();
	            System.out.println("Clicked on the 'delete' span element with ID: " + partialId2);
	            isClicked = true;
	            break; // Exit the loop once the element is clicked
	        } catch (NoSuchElementException e) {
	            System.out.println("No 'delete' span element found with ID: " + partialId2);
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click was intercepted for ID: " + partialId2);
	        } catch (Exception e) {
	            System.out.println("Error while clicking the 'delete' span with ID: " + partialId2 + " - " + e.getMessage());
	        }
	    }

	    // If no element was clicked after the loop
	    if (!isClicked) {
	        System.out.println("No 'delete' span element found in the specified range.");
	    }
	}

	public void Enter_Englishname(String str)
	{
		nameEng.clear();
		nameEng.sendKeys(str);
	}
	
	public void Enter_Marathiname(String str)
	{
		nameMar.clear();
		nameMar.sendKeys(str);
	}
	
	public void Enter_mail(String str)
	{
		email.clear();
		email.sendKeys(str);
	}
	
	public void Enter_phone(String str)
	{
		mobile.clear();
		mobile.sendKeys(str);
	}
	
	public void Enter_Adhaar(String str)
	{
		adhaar.clear();
		adhaar.sendKeys(str);
	}
	
	public void Enter_Pan(String str)
	{
		pan.clear();
		pan.sendKeys(str);
	}
	
	public void Enter_City(String str)
	{
		city.clear();
		city.sendKeys(str);
	}
	
	public void Enter_Pincode(String str)
	{
		pincode.clear();
		pincode.sendKeys(str);
	}
	
	public void Enter_Wing(String str)
	{
		wing.clear();
		wing.sendKeys(str);
	}
	
	public void Enter_Plot(String str)
	{
		plot.clear();
		plot.sendKeys(str);
	}
	
	public void Enter_Flat(String str)
	{
		flat.clear();
		flat.sendKeys(str);
	}
	
	public void Enter_SocietyName(String str)
	{
		society_name.clear();
		society_name.sendKeys(str);
	}
	
	public void Enter_address(String str)
	{
		address.clear();
		address.sendKeys(str);
	}

	public void select_district( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(district));
		
		Select s = new Select(district);
		s.selectByValue("Mumbai City");
	}
	
	public void Click_add_more( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(addmore));
		addmore.click();
	}

	public void select_business_type( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(businessType));
		
		Select s = new Select(businessType);
		s.selectByValue("44");
	}
	
	public void select_license_type( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(licenseType));
		
		Select s = new Select(licenseType);
		s.selectByValue("4105");
	}
	
	public void select_property_type( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(propertyType));
		
		Select s = new Select(propertyType);
		s.selectByValue("4");
	}
	
	public void select_license_period( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(licensePeriod));
		
		Select s = new Select(licensePeriod);
		s.selectByValue("8");
	}
	
	public void select_premise_type( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(premiseType));
		
		Select s = new Select(premiseType);
		s.selectByValue("1");
	}
	
	public void select_nature_of_trade( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(natureofTrade));
		
		Select s = new Select(natureofTrade);
		s.selectByValue("1");
	}
	
	public void select_business_of_style( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(bStyle));
		
		Select s = new Select(bStyle);
		s.selectByValue("3");
	}
	
	public void select_status( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(statusofBusiness));
		
		Select s = new Select(statusofBusiness);
		s.selectByValue("1");
	}
	
	public void select_oc( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(OC));
		
		Select s = new Select(OC);
		s.selectByValue("1");
	}
	
	public void Enter_Shopname(String str)
	{
		shopname.clear();
		shopname.sendKeys(str);
	}
	
	public void Enter_TotalAre(String str)
	{
		totalArea.clear();
		totalArea.sendKeys(str);
	}
	
	public void Enter_CommenceDate(String str)
	{
		commDate.clear();
		commDate.sendKeys(str);
	}
	
	public void Enter_OCdate(String str)
	{
		ocDate.clear();
		ocDate.sendKeys(str);
	}
	
	public void Enter_gst(String str)
	{
		gstNo.clear();
		gstNo.sendKeys(str);
	}
	
	public void Enter_mail_business(String str)
	{
		emailBusiness.clear();
		emailBusiness.sendKeys(str);
	}
	
	public void Enter_mobile(String str)
	{
		mobileBusiness.clear();
		mobileBusiness.sendKeys(str);
	}
	
	public void Enter_landline(String str)
	{
		landlineno.clear();
		landlineno.sendKeys(str);
	}
	
	public void Enter_adhaar(String str)
	{
		adhaarBussiness.clear();
		adhaarBussiness.sendKeys(str);
	}
	
	public void Enter_pan(String str)
	{
		panBusiness.clear();
		panBusiness.sendKeys(str);
	}
	
	public void Enter_plot(String str)
	{
		plotBussiness.clear();
		plotBussiness.sendKeys(str);
	}
	
	public void Enter_wing(String str)
	{
		wingBussiness.clear();
		wingBussiness.sendKeys(str);
	}
	
	public void Enter_shopno(String str)
	{
		shopno.clear();
		shopno.sendKeys(str);
	}
	
	public void Enter_socName(String str)
	{
		societyName.clear();
		societyName.sendKeys(str);
	}
	
	public void Enter_address_bussiness(String str)
	{
		addressBusiness.clear();
		addressBusiness.sendKeys(str);
	}
	
	public void Click_agree_btn( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(agreebtn));
		agreebtn.click();
	}
	
	public void Click_submit_btn( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(submitbtn));
		submitbtn.click();
	}
	
	public void Click_print_btn( WebDriver driver)
	{
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(printbtn));
		printbtn.click();
	}
		
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
	
	public String fetch_application_no(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	    wait.until(ExpectedConditions.visibilityOf(application_no));
	    String applicationNumber = application_no.getText();
	    String nonNumericPart = applicationNumber.replaceAll("[^a-zA-Z]", ""); // Extract non-numeric part (SRVY)
	    String numericPart = applicationNumber.replaceAll("[^0-9]", ""); // Extract numeric part 
	    String modifiedApplicationNumber = "ASEN" + numericPart;
	    return modifiedApplicationNumber;
	}

	
}



