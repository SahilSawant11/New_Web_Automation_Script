package pom;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.util.Assert;

public class CounterPaymentPage {

	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lnkAdvcPay']") private WebElement advance_pay_btn;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ChkChequeBounce']") private WebElement penalty_radio_btn ;
	
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVPropTax\"]/tbody/tr") private List<WebElement> rows_Count;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVPropTax\"]/tbody/tr[2]/td") private List<WebElement> pendingList;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVPropTax\"]/tbody/tr[3]/td") private List<WebElement> currentList;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVPropTax\"]/tbody/tr[4]/td") private List<WebElement> totalList;
	
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$GVPropTax$ctl02$chkGrid']") private WebElement select_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVPropTax_chkGrid_3']") private WebElement select_fullcheck_box;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVPropTax_chkGrid_0']") private WebElement select_Apartcheck_box;
	                
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVPropTax_chkGrid_0']") private WebElement pendingfullpayment;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_GVPropTax_chkGrid_2']") private WebElement currentfullpayment;
	
	@FindBy(xpath = "(//input[@class='edttxbtn edit-button'])[1]") private WebElement pay_optionPendingFull;
	@FindBy(xpath = "(//input[@class='edttxbtn edit-button'])[3]") private WebElement pay_optionFull;
	
	//element for partial payment option
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPayableTotalPartialTax']") private WebElement partial_payment_textfield;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$btnPayableTotalPartialTax']") private WebElement tax_details_btn;
	@FindBy(xpath = "//a[text()='Edit']") private WebElement edit_btn;
	@FindBy(xpath = "//a[text()='Update']") private WebElement update_btn;
	
	//
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtEmail']") private WebElement email_id;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtMobileNo']") private WebElement mobile_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlBillBookNo']") private WebElement bill_book_no;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$DDLPaymentMode']") private WebElement payment_mode;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtBehalfPayerName']") private WebElement behalf_payer_name;
	@FindBy(xpath = "//select[@name='ctl00$ContentPlaceHolder1$ddlBankName']") private WebElement bank_option;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtChequeNumberDD']") private WebElement cheque_dd_transation_no;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$DDChequeDate']") private WebElement cheque_dd_transation_date;
	@FindBy(xpath = "//input[@name='ctl00$ContentPlaceHolder1$txtDebitRefID']") private WebElement paid_ref_id;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalTax']") private WebElement Total_pay_tax;
	
	///////////////////////////////////no due pop up elements//////////////////////////
	

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtEmailtran']") private WebElement email_idPopUP;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtMobileNotran']") private WebElement mobile_noPopUP;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlBillBookNotran']") private WebElement bill_book_noPopUP;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_DDLPaymentTypetran']") private WebElement payment_modepopup;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnPayProceedtran']") private WebElement pay_nowPopUP;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtNDEmailID']") private WebElement email_idPopUP2;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtNDMobileNo']") private WebElement mobile_noPopUP2;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlNoDueBillBook']") private WebElement bill_book_noPopUP2;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlNDPaymentMode']") private WebElement payment_modepopup2;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnPayNoDueFee']") private WebElement pay_nowPopUP2;
	
	
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnPayProceed']") private WebElement pay_now;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_PayProceedbtn']") private WebElement PCMC_pay_now;
	@FindBy(xpath = "/html/body/div[3]/div[7]/div/button") private WebElement confirm_yes;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVPropTax']/tbody/tr[4]/td[2]/input") private WebElement PCMC_confirm_yes;
	@FindBy(xpath = "/html/body/div[2]/div/div[3]/button[1]") private WebElement NoticePopup;
	
	@FindBy(xpath = "//span[text()='Transaction ID Generated Succesfully']") private WebElement transction_id_msg;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_lblDownloadReceiptbtn']") private WebElement receipts_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnGetReceipt']") private WebElement pcmc_receipts_btn;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblDownloads']") private WebElement download_receipt_list;
	@FindBy(xpath = "(//tr//td//input[@type='image'])[1]") private WebElement downloadfile1;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblAmount']") private WebElement amount;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_txtAdvcAmount']") private WebElement Advanceamount;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblPaymentStatus']") private WebElement transaction_id;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_GVDownloads\"]/tbody/tr[1]/th[1]") private WebElement downloadReceipt;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVDownloads']/tbody/tr[2]/td[1]/input") private WebElement downloadReceipt_btn;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnAdvcPayProceed']") private WebElement ProceedAdvancePayment;
	
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_Image1']") private WebElement loader;
	
	//counter reports
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnShowNoticeBill']") private WebElement NoticeBill;
	

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnShowKarakarni']") private WebElement valuation;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnShowNakkal']") private WebElement Nakkal;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnNoDueCertificate']") private WebElement NoDue;
	

//	Cheque elements 
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ddlBankName']") private WebElement bankname;
	
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_engtxtmsg']") private WebElement NoDueMessage;
	
// Upic
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_lblUPICID']") private WebElement upicId;
	
	
	// PCMC BTN
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_PayProceedbtn']") private WebElement PCMCCardPayment;
	@FindBy(xpath = "//button[@class='confirm' and text()='Yes']")  private WebElement PCMCYesTransBtn;


	
	public CounterPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUpicIdPresent() {
        try {
            return upicId.isDisplayed(); // Checks if the element is displayed
        } catch (NoSuchElementException e) {
            return false; // Element is not found
        }
    }
	
	public String getUpicId() {
        return upicId.getText();
    }
	
	public void compareUpicIds(ExtentTest test) {
	    if (!isUpicIdPresent()) {
	        test.fail("Property details are not shown after Payment");
	        return; 
	    }

	    String valueBeforeClick = getUpicId();

	    String valueAfterClick = getUpicId(); 
	    
	    	    if (valueBeforeClick.equals(valueAfterClick)) {
	        test.pass("The UPIC ID values are the same: " + valueBeforeClick);
	    } else {
	        test.info("The UPIC ID values are different. Before: " + valueBeforeClick + ", After: " + valueAfterClick);
	    }
	}

	
	
	public void Click_advance_pay_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(advance_pay_btn));
		advance_pay_btn.click();
	}
	
	public void Check_isadvance_pay_btnVisible(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(advance_pay_btn));
		
		
	}
	
	public void Check_is_penalty_Visible(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(penalty_radio_btn));
		
		
	}
	
	public void click_noticeBill(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(NoticeBill));
		NoticeBill.click();
		
		
	}
	public void click_valuation(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(valuation));
		valuation.click();
		
		
	}
	
	public void click_Nakkal(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(Nakkal));
		Nakkal.click();
		
		
	}
	
	public void click_Nodue(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOf(NoDue));
		NoDue.click();
		
		
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	public int Get_rows_Count()
	{
		int i = rows_Count.size();
		return i;
	}
	
	public List<Integer> Get_pendingList(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOfAllElements(pendingList));
		
		Iterator<WebElement> i = pendingList.iterator();
		ArrayList<Integer> al = new ArrayList<Integer>();
		i.next();
		i.next();
		i.next();
		while(i.hasNext())
		{
			al.add(Integer.parseInt(i.next().getText()));
		}
		
		return al;
	}
	
	public List<Integer> Get_currentList(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOfAllElements(currentList));
		
		Iterator<WebElement> i = pendingList.iterator();
		ArrayList<Integer> al = new ArrayList<Integer>();
		i.next();
		i.next();
		i.next();
		while(i.hasNext())
		{
			al.add(Integer.parseInt(i.next().getText()));
		}
		
		return al;
	}
	
	public List<Integer> Get_totalList(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOfAllElements(totalList));
		
		Iterator<WebElement> i = pendingList.iterator();
		ArrayList<Integer> al = new ArrayList<Integer>();
		i.next();
		i.next();
		i.next();
		while(i.hasNext())
		{
			al.add(Integer.parseInt(i.next().getText()));
		}
		
		return al;
	}
	
	public String Get_Total_pay_tax()
	{
		return Total_pay_tax.getAttribute("value");
	}
	
	
	public void Select_checkbox(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(select_check_box));
		select_check_box.click();
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Select_Finalcheckbox(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		
		try {
			wait.until(ExpectedConditions.visibilityOf(select_fullcheck_box));
			select_fullcheck_box.click();
			
		} catch (Exception e) {
			
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(8));
			wait2.until(ExpectedConditions.visibilityOf(currentfullpayment));
			currentfullpayment.click();
		}		
	}
	
	public boolean IsFinalCheckboxPresent(WebDriver driver) {
        try {
            
            return select_fullcheck_box.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

	
	public void Select_APartcheckbox(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		try {
			wait.until(ExpectedConditions.visibilityOf(select_Apartcheck_box));
			select_Apartcheck_box.click();
			
		} catch (Exception e) {
			
			
		}
		
		
		
		
	}
	
	
	public void Select_fullpayment(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(pendingfullpayment));
		
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(500);
	    
	    try
	    {
	    	currentfullpayment.click();
			
			Thread.sleep(1000);
			while(loading_page.getAttribute("aria-hidden").equals("false"))
			{
				Thread.sleep(500);
				System.out.println("waiting");
			}
			Thread.sleep(500);
	    }
	    catch(Exception e)
	    {
	    	pendingfullpayment.click();
			
			Thread.sleep(1000);
			while(loading_page.getAttribute("aria-hidden").equals("false"))
			{
				Thread.sleep(500);
				System.out.println("waiting");
			}
			Thread.sleep(500);
	    }
		
//		if(pay_optionPendingFull.isDisplayed())
//		{
//			currentfullpayment.click();
//			
//			Thread.sleep(1000);
//			while(loading_page.getAttribute("aria-hidden").equals("false"))
//			{
//				Thread.sleep(500);
//				System.out.println("waiting");
//			}
//			Thread.sleep(500);
//			
//			pay_optionFull.click();
//			
//		}
//		else
//		{
//			pendingfullpayment.click();
//			
//			Thread.sleep(1000);
//			while(loading_page.getAttribute("aria-hidden").equals("false"))
//			{
//				Thread.sleep(500);
//				System.out.println("waiting");
//			}
//			Thread.sleep(500);
//			
//			pay_optionPendingFull.click();
//		}
	}
	
	public void Button_pay_optionPendingFull(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(pay_optionPendingFull));
		
		pay_optionPendingFull.click();
	}
	
	public void Button_pay_optionFull(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(pay_optionFull));
		
		pay_optionFull.click();
	}
	
	public String Get_amount(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(amount));
		
		return amount.getText();
	}
	
	
	public void Check_transaction_id(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(transaction_id));
		
		transaction_id.isDisplayed();
	}
	
	public void Click_pay_option(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(email_id));
		Thread.sleep(1000);
//		pay_option.click();
	}
	

	public void Enter_partial_payment_textfield(WebDriver driver, String str) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(partial_payment_textfield));

		partial_payment_textfield.clear();
		partial_payment_textfield.sendKeys(str);
	}
	
	
	public void Click_tax_details_btn()
	{
		tax_details_btn.click();
	}
	
	
	public void Click_edit_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(edit_btn));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", edit_btn);
		Thread.sleep(1000);
		
		edit_btn.click();
	}
	
	public void Click_update_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(update_btn));
		update_btn.click();
	}
	
	public void Enter_email_id(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(email_id));
		email_id.clear();
		email_id.sendKeys(str);
	}
	
	
	public void Enter_mobile_no(WebDriver driver, String str) throws InterruptedException
	{
		mobile_no.clear();
		mobile_no.sendKeys(str);
		
	}
	
	public void Select_bill_book_no(String str)
	{
		Select billbook = new Select(bill_book_no);
		
		
		try {
			billbook.selectByVisibleText(str);
		} catch (Exception e) {
			billbook.selectByIndex(1);
		}
		
	}
	
	/////////////////////////////////////////////////////NO Due POP UP PAYMENT/////////////////////////////////////////
	public void Enter_email_idPopUP(WebDriver driver, String str)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.visibilityOf(email_idPopUP));
			email_idPopUP.clear();
			email_idPopUP.sendKeys(str);
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.visibilityOf(email_idPopUP2));
			email_idPopUP2.clear();
			email_idPopUP2.sendKeys(str);
		}
		
		
	}
	
	
	public void Enter_mobile_noPOPUp(WebDriver driver, String str) throws InterruptedException
	
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(mobile_noPopUP));
			mobile_noPopUP.clear();
			mobile_noPopUP.sendKeys(str);
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(mobile_noPopUP2));
			mobile_noPopUP2.clear();
			mobile_noPopUP2.sendKeys(str);
		}
		
		
	}
	
	public void Select_bill_book_noPopUP(String str)
	{
		
		try {
			Select billbook = new Select(bill_book_noPopUP);
			
			
			try {
				billbook.selectByVisibleText(str);
			} catch (Exception e) {
				billbook.selectByIndex(1);
			}
		} catch (Exception e) {
			Select billbook = new Select(bill_book_noPopUP);
			
			
			try {
				billbook.selectByVisibleText(str);
			} catch (Exception e1) {
				billbook.selectByIndex(1);
			}
		}
		
		
	}
	
	public void Select_payment_modePopUp(String str)
	{
		try {
			Select paymentmode = new Select(payment_modepopup);
			paymentmode.selectByValue(str);
		} catch (Exception e) {
			Select paymentmode = new Select(payment_modepopup2);
			paymentmode.selectByValue(str);
		}
	}
	
	public void Click_payBTN_PopUp(WebDriver driver)
	{

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(pay_nowPopUP));
			pay_nowPopUP.click();
		} catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
			wait.until(ExpectedConditions.visibilityOf(pay_nowPopUP2));
			pay_nowPopUP2.click();
		}
	}
	
	 
	 public static boolean isFileDownloaded(String fileName, String newFileName, int timeoutInSeconds) {
		 String downloadDir = System.getProperty("user.dir") + File.separator + "temp";
	        File file = new File(downloadDir, fileName);
	        int attempts = 0;
	        
	        // Check if file exists and keep checking until timeout
	        while (attempts < timeoutInSeconds) {
	            if (file.exists()) {
	            	
	            	File renamedFile = new File(downloadDir, newFileName);
	                if (file.renameTo(renamedFile)) {
	                    System.out.println("File renamed to: " + newFileName);
	                    
	                    return true;
	                } else {
	                    System.out.println("Failed to rename file.");
	                }
	                return true;
	            }
	            try {
	                Thread.sleep(1000); // Wait for 1 second before the next attempt
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            attempts++;
	        }
	        return false;
	    }
	 
	 
	 
	 
	 

	 public static boolean moveRenamedFileToReportFolder(String newFilename) {
	        // Define the source folder (temp folder) and destination folder (pdfreports)
	        String sourceFolder = System.getProperty("user.dir") + File.separator + "temp";
	        String targetFolder = System.getProperty("user.dir") + File.separator + "pdfreports";

	        File sourceFile = new File(sourceFolder, newFilename);
	        File destinationFile = new File(targetFolder, newFilename);

	        try {
	      
	            File targetDir = new File(targetFolder);
	            if (!targetDir.exists()) {
	                targetDir.mkdir();
	            }

	          
	            if (sourceFile.exists()) {
	                Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	                System.out.println("File moved successfully to: " + destinationFile.getAbsolutePath());
	                boolean deleted = sourceFile.delete();
	                ///////////
	                //to delete the files after renaming and moving
	                if (deleted) {
	                	System.out.println("Deleted from temp after renaming");
	                } else {
	                	System.out.println("Failed to delete");
	                }
	                //////////
	                return true;
	            } else { 
	                System.out.println("Source file does not exist: " + sourceFile.getAbsolutePath());
	                return false;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	public void Select_payment_mode(String str)
	{
		Select paymentmode = new Select(payment_mode);
		paymentmode.selectByValue(str);
	}
	
	public void Enter_behalf_payer_name(WebDriver driver, String str)
	{
		behalf_payer_name.clear();
		behalf_payer_name.sendKeys(str);

	}
	
	public void select_bank_option(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(bank_option));
		
		Select s = new Select(bank_option);
		s.selectByVisibleText(str);
	}
	
	public void Enter_cheque_dd_transation_no(WebDriver driver, String str) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(1000);
	    
	    Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(cheque_dd_transation_no));
		cheque_dd_transation_no.clear();
		cheque_dd_transation_no.sendKeys(str);
	}
	
	public void Enter_cheque_dd_transation_date(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(cheque_dd_transation_date));
		cheque_dd_transation_date.sendKeys(str);
	}
	
	public void Enter_paid_ref_id(WebDriver driver, String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(bank_option));
		paid_ref_id.sendKeys(str);
	}
	
	
	public void Click_pay_now(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
		wait.until(ExpectedConditions.visibilityOf(pay_now));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.elementToBeClickable(pay_now));
		js.executeScript("arguments[0].scrollIntoView();", pay_now);
		Thread.sleep(1000);
		
		pay_now.click();
	}
	
	
	public void PCMC_Click_pay_now(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
		wait.until(ExpectedConditions.visibilityOf(PCMC_pay_now));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.elementToBeClickable(PCMC_pay_now));
		js.executeScript("arguments[0].scrollIntoView();", PCMC_pay_now);
		Thread.sleep(1000);
		
		PCMC_pay_now.click();
	}
	
	public void scrollToBottom(WebDriver driver) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void confirm_payment(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000));
		wait.until(ExpectedConditions.visibilityOf(confirm_yes));
		Thread.sleep(2000);
		confirm_yes.click();
	}
	
	
	public void PCMC_confirm_payment(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.visibilityOf(PCMC_confirm_yes));
		Thread.sleep(2000);
			 
		 try {
			 PCMC_confirm_yes.click();
		} catch (Exception e) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", PCMC_confirm_yes);
			 PCMC_confirm_yes.click();
		}
		
	}
		
	
	public boolean Check_isPropertyHasNoDue(WebDriver driver) throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.until(ExpectedConditions.visibilityOf(NoDueMessage));
			boolean nodueshowed= NoDueMessage.isDisplayed();
			return nodueshowed;
			
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	
	public void PopUpAfterDownloadNotice(WebDriver driver) throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.visibilityOf(NoticePopup));
			Thread.sleep(5000);
			NoticePopup.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void checkfile(String directoryPath , String filename) throws InterruptedException
	{
		
		

	        // Create a File object for the directory
	        File directory = new File(directoryPath);

	        // Check if the directory exists and is actually a directory
	        if (directory.exists() && directory.isDirectory()) {
	            // Create a File object for the specific file
	            File file = new File(directory, filename);

	            // Check if the file exists
	            if (file.exists() && file.isFile()) {
	                System.out.println("File exists: " + file.getAbsolutePath());
	            } else {
	                System.out.println("File does not exist: " + file.getAbsolutePath());
	            }
	        } else {
	            System.out.println("Directory does not exist: " + directoryPath);
	        }
		
		
	} 
	 
	
	public void Click_receipts_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(transction_id_msg));
		Thread.sleep(1000);
		receipts_btn.click();
	}
	
	
	public void pcmc_DownloadReceipt(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(transction_id_msg));
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", pcmc_receipts_btn);
	    Thread.sleep(5000);
		pcmc_receipts_btn.click();
	}
	
	public void Download_pdf_file(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(download_receipt_list));
		Thread.sleep(1000);
		downloadfile1.click();
	}
	
	
	public String LastPayAmount()
	{
		String FinalPayAmount = amount.getText();
		return FinalPayAmount;
	}
	
	public void label_downloadReceipt(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(downloadReceipt));
	}
	
	public void downloadReceipt(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(downloadReceipt_btn));
		downloadReceipt_btn.click();
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	
	public void Enter_AdvanceAmount(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(Advanceamount));
		Advanceamount.sendKeys("100");
	}
	
	public void Click_ProceedAdvancePay(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(ProceedAdvancePayment));
		ProceedAdvancePayment.click();
		Thread.sleep(2000);
	}
	
	public void PCMC_Click_ProceedCardPay(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(PCMCCardPayment));
		PCMCCardPayment.click();
		Thread.sleep(2000);
	}
	
	public void PCMC_Yes_Transaction_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(PCMCYesTransBtn));
		Thread.sleep(1000);
		PCMCYesTransBtn.click();
	}
	
	public void Select_bankname(WebDriver driver,String str)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(60000));
		wait.until(ExpectedConditions.visibilityOf(bankname));
		
		Select bankname1 = new Select(bankname);
		
		
		try {
			bankname1.selectByVisibleText(str);
		} catch (Exception e) {
			bankname1.selectByIndex(1);
		}
		
	}
	
	
}
