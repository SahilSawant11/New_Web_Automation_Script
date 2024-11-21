package pom;


import java.time.Duration;

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



public class OnlineDataEntryPage {

	///////////////////////////////////////////Property details//////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowPropertyNo']") private WebElement property_no_lable;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblShowOwnerName']") private WebElement taxpayer_bhogvatdar_lable;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblMobileNo']") private WebElement mobile_no_lable;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////ploat info////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_HiddenTab']") private WebElement DataEntry_lable;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWadhGhatRemark']") private WebElement vadhghat_shera;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewZoneNo']") private WebElement zone_no;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_cmbOpenPlot']") private WebElement khula_bhukhand;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLPropertyDesc']") private WebElement property_type;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewCityServeyNo']") private WebElement csn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNewPlotNo']") private WebElement plot_no;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalPlotArea']") private WebElement plot_area_sqft;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalPlotAreaSqMtr']") private WebElement plot_area_sqm;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalBuiltUpArea']") private WebElement karpatr_chatai_area;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalCarpetArea']") private WebElement chatai_area;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCategoryType']") private WebElement shreni;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPropertyType']") private WebElement shreni_prakar;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlConstructionType']") private WebElement new_property;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////owner info////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlMtitle']") private WebElement shirshak_kardharak;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerMfstName']") private WebElement kardharak;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerPatta']") private WebElement ptta;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerImaratPatta']") private WebElement dukan_imarat_nav;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerDukanno']") private WebElement dukan_flat_no;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPMSocietyNameM']") private WebElement society_name_marathi;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPMSocietySachivNameM']") private WebElement society_sachiv_name_marathi;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlTitle']") private WebElement title;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerFstName']") private WebElement taxpayer_name;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerAddress']") private WebElement address;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerBldName']") private WebElement shop_building_name;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOwnerShpFltNo']") private WebElement shop_flat_no;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPMSocietyNameE']") private WebElement society_name_eng;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPMSocietySachivNameE']") private WebElement secretory_name;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLOccupierTitle']") private WebElement shirshak_bhogvatdar;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMarathiOccupierName']") private WebElement bhogvatdar;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOccupierName']") private WebElement occupier_name;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtwing']") private WebElement wing;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnJointOwnerAdd']") private WebElement add_owner_info;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////Gride view address///////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_gvOwnerDetails']/tbody/tr[2]/td[2]/input") private WebElement remove_owner_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvOwnerDetails_chkGrid_0']") private WebElement isPrime_Check_box_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblshirshak_0']") private WebElement shirshak_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiPrathamNav_0']") private WebElement kardharak_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiOccupierName_0']") private WebElement bhogvatdar_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiPatta_0']") private WebElement ptta_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiImaratNav_0']") private WebElement dukan_imarat_nav_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiFlatNo_0']") private WebElement dukan_flat_no_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblWingNo_0']") private WebElement wing_from_grid;
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblTitle_0']") private WebElement title_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblFirstName_0']") private WebElement taxpayer_name_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblOccupierNameEnglish_0']") private WebElement occupier_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblAddress_0']") private WebElement address_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblShopBldName_0']") private WebElement shop_building_name_from_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblShopNo_0']") private WebElement shop_flat_no_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblMarathiSocietyName_0']") private WebElement society_name_marathi_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblEngSocietyName_0']") private WebElement society_name_eng_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblSecretoryNameMarathi_0']") WebElement society_sachiv_name_marathi_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblSecretoryNameEnglish_0']") private WebElement secretory_name_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblManagerNameMarathi_0']") private WebElement manager_name_marathi_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblManagerNameEnglish_0']") private WebElement manager_name_eng_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_gvOwnerDetails_lblManagerMobileNo_0']") private WebElement manager_mobile_no_grid;
	 
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////floor info///////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLFloor']") private WebElement floor;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtConsYear']") private WebElement construnction_year;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLConstType']") private WebElement construction_type;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLTypeOfUse']") private WebElement type_of_use;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCarpetArea']") private WebElement karpatr_chatai_area_sqft_floor;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCarpetAreaSqMtr']") private WebElement karpatr_chatai_area_sqm_floor;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLRegistration']") private WebElement nondani;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNoRooms']") private WebElement no_of_room;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_DDLRenter']") private WebElement renter_available;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMFstRenterName']") private WebElement renter_name_marathi;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFstRenterName']") private WebElement renter_name_eng;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCalculatedRent']") private WebElement calculated_rent;
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlIsAgreement']") private WebElement agreement;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAgreementDate']") private WebElement agreement_from_date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAgrToDate']") private WebElement agreement_to_date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNonCalculatedRent']") private WebElement non_calculated_rent;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnUpdateFloor']") private WebElement add_floor_info;
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////Grid view floor///////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_GVPropertyDetails']/tbody/tr[2]/td[2]/input") private WebElement remove_floor_check_box;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblFloor_0']") private WebElement floor_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblConstYear_0']") private WebElement construnction_year_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblConstType_0']") private WebElement construction_type_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblTypeOfUse_0']") private WebElement type_of_use_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblCarpetAreaft_0']") private WebElement carpetArea_sqft_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblCarpetAreamtr_0']") private WebElement carpetArea_sqm_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblRooms_0']") private WebElement no_of_room_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblRegistration_0']") private WebElement nondani_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblRenter_0']") private WebElement renter_available_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblMarathiRenterPrathamNav_0']") private WebElement bhadekaru_name_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblCalculateRent_0']") private WebElement calculated_rent_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblNonCalculateRent_0']") private WebElement non_calculated_rent_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblFirst_0']") private WebElement renter_name_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblIsAgreement_0']") private WebElement 	agreement_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblAgreementDate_0']") private WebElement agreement_from_date_grid;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_GVPropertyDetails_lblAgreementToDate_0']") private WebElement agreement_to_date_grid;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtRToilet']") private WebElement r_toilet;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCToilet']") private WebElement c_toilet;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////RV and ALV/////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblDORV']") private WebElement old_rv;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblDOALV']") private WebElement old_alv;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblDNRV']") private WebElement new_rv;
	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblDNALV']") private WebElement new_alv;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////KAR/////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[1]") private WebElement arthik_varsh;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[2]") private WebElement samany_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[3]") private WebElement mnp_shikshan_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[4]") private WebElement rasta_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[5]") private WebElement vruksh_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[6]") private WebElement saf_safai_malpravah_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[7]") private WebElement pani_puravatha_agnishaman_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[8]") private WebElement v_panipatti_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[9]") private WebElement arahivasi_seva_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[10]") private WebElement rahivasi_seva_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[11]") private WebElement maha_shikshan_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[12]") private WebElement rojgar_hami_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[13]") private WebElement v_saf_safai_kar;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[14]") private WebElement paniptti_rkkam;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[15]") private WebElement thakit_shasti;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[16]") private WebElement mothi_imarat_notis_warrent_fee;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[17]") private WebElement chalu_shasti;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[18]") private WebElement total_ker;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[19]") private WebElement vishesh_sut;
	@FindBy(xpath = "//table[@id='ContentPlaceHolder1_gvTransMast']/tbody/tr[2]/td[20]") private WebElement net_total_kar;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////////विशेष सुविधेअंतर्गत सूट///////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsSolar']") private WebElement solar_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsRainWaterHarvesting']") private WebElement waterHarvesting_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsGarbageSegregation']") private WebElement garbage_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsGarbageDisposal']") private WebElement garbage_disposal_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsEBill']") private WebElement eBill_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ChkIsFamilyplanning']") private WebElement familyplanning_check_box;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_CHkIsWomenOwner']") private WebElement womenOwner_check_box;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////Buttons////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataentryUploadPhotoPlan']") private WebElement upload_photo_and_plan;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataentryOldInformation']") private WebElement old_information_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataentryWaterconnection']") private WebElement water_connection_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataentryRetainTaxes']") private WebElement retain_taxes_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataentryUploadDocument']") private WebElement add_taxes_and_upload_document_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnSave']") private WebElement save_btn;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_btnClear']") private WebElement cancel_btn;
	
	@FindBy(xpath = "/html/body/div[3]/p") private WebElement DataSaved;
	@FindBy(xpath = "/html/body/div[3]/div[7]/div/button") private WebElement DataSaved_okbtn;
	
	@FindBy(xpath = "/html/body/div[4]/p") private WebElement DataSaved2;
	@FindBy(xpath = "/html/body/div[4]/div[7]/div/button") private WebElement DataSaved_okbtn2;
	
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnRegisterY']") private WebElement complaint_registration_yes;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnRegisterN']") private WebElement complaint_registration_no;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_PanelUpdateProgress']") private WebElement loading_page;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnDataEntryBuildingInfo']") private WebElement building_info_btn;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOccupancyDate']") private WebElement occupancy_date;
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtconstructionyear']") private WebElement counstruction_year;
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_BtnBuildingInfoSave']") private WebElement save_building_info_btn;
	@FindBy(xpath = "//button[text()='OK']") private WebElement building_info_ok_btn;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_BtnBuildinginfoADDtAXES']") private WebElement add_taxes_and_upload_files;
	
	public OnlineDataEntryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//////////////////////////////////////////////property details///////////////////////////////////////////////
	
	public String Fetch_property_no_lable() throws InterruptedException
	{
		String str = property_no_lable.getText();
		Thread.sleep(500);
		
		return str;
	}
	
	public String Fetch_taxpayer_bhogvatdar_lable() throws InterruptedException
	{
		String str = taxpayer_bhogvatdar_lable.getText();
	
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		return str;
	}
	
	public String Fetch_mobile_no_lable() throws InterruptedException
	{
		String str = mobile_no_lable.getText();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		return str;
	}
	
	
	///////////////////////////////////////////////Lables and wadhghat shera/////////////////////////////////////
	
	public void Check_DataEntry_lable(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(500);
	    
		if(DataEntry_lable.isDisplayed())
		{
			System.out.println("Page is successfully open");
		}
		else
		{
			System.out.println("page not displayed");
		}
	}
	
	public void Enter_vadhghat_shera(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(vadhghat_shera));
		
		vadhghat_shera.clear();
		vadhghat_shera.sendKeys("test");
		Thread.sleep(500);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////ploat info1///////////////////////////////////////////////////
	
	public void Enter_zone_no(WebDriver driver, String str) throws InterruptedException
	{
		zone_no.clear();
		zone_no.sendKeys(str);
		Thread.sleep(500);
	}
	
	
	public void Select_khula_bhukhand(String str) throws InterruptedException
	{
		Select s = new Select(khula_bhukhand);
		s.selectByVisibleText(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Select_property_type(String str) throws InterruptedException
	{
		Select s = new Select(property_type);
		s.selectByVisibleText(str);
		
		Thread.sleep(500);
	}
	
	public void Enter_csn(String str) throws InterruptedException
	{
		csn.sendKeys(str);
		Thread.sleep(500);
	}
	
	public void Enter_plot_no(String str) throws InterruptedException
	{
		plot_no.sendKeys(str);
		Thread.sleep(500);
	}
	
	public void Enter_plot_area_sqft(String str) throws InterruptedException
	{
		plot_area_sqft.sendKeys(str);
		Thread.sleep(500);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
	}
	
	public String Check_plot_area_sqm() throws InterruptedException
	{
		plot_area_sqm.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		
		String val = plot_area_sqm.getAttribute("value");
		return val;
	}
	
	public String Check_karpatr_chatai_area() throws InterruptedException
	{		
		String val = karpatr_chatai_area.getAttribute("value");
		
		return val;
	}
	
	public String Check_chatai_area() throws InterruptedException
	{		
		String val = chatai_area.getAttribute("value");
		
		return val;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////ploat info2///////////////////////////////////////////////////
	
	public void Select_shreni(String str) throws InterruptedException
	{
		Select s = new Select(shreni);
		s.selectByVisibleText(str);
		Thread.sleep(500);
	}
	
	public void Select_shreni_prakar(String str,WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(1000);
			System.out.println("waiting");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(shreni_prakar));
		Thread.sleep(500);
		Select s = new Select(shreni_prakar);
		s.selectByVisibleText(str);
		Thread.sleep(1000);
	}
	
	public void Select_new_property(String str) throws InterruptedException
	{
		Select s = new Select(new_property);
		s.selectByVisibleText(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(2000);
			System.out.println("waiting for new property");
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////Owner Info1/////////////////////////////////////////////////
	
	
	public void Select_shirshak_kardharak(String str) throws InterruptedException
	{		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		Select s = new Select(shirshak_kardharak);
		s.selectByVisibleText(str);
		
		Thread.sleep(500);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_kardharak(String str) throws InterruptedException
	{
		kardharak.sendKeys(str);
	}
	
	public void Enter_ptta(String str) throws InterruptedException
	{
		ptta.sendKeys(str);
	}
	
	public void Enter_dukan_imarat_nav(String str) throws InterruptedException
	{
		dukan_imarat_nav.sendKeys(str);
	}
	
	public void Enter_dukan_flat_no(String str) throws InterruptedException
	{
		dukan_flat_no.sendKeys(str);
	}
	
	public void Enter_society_name_marathi(String str) throws InterruptedException
	{
		society_name_marathi.sendKeys(str);
	}
	
	public void Enter_society_sachiv_name_marathi(String str) throws InterruptedException
	{
		society_sachiv_name_marathi.sendKeys(str);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////Owner info2///////////////////////////////////////////////
	
	public void Select_title(String str) throws InterruptedException
	{		
		Thread.sleep(500);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		Select s = new Select(title);
		s.selectByVisibleText(str);
		
		Thread.sleep(500);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_taxpayer_name(String str) throws InterruptedException
	{
		taxpayer_name.sendKeys(str);
	}
	
	public void Enter_address(String str) throws InterruptedException
	{
		address.sendKeys(str);
	}
	
	public void Enter_shop_building_name(String str) throws InterruptedException
	{
		shop_building_name.sendKeys(str);
	}
	
	public void Enter_shop_flat_no(String str) throws InterruptedException
	{
		shop_flat_no.sendKeys(str);
	}
	
	public void Enter_society_name_eng(String str) throws InterruptedException
	{
		society_name_eng.sendKeys(str);
	}
	
	public void Enter_secretory_name(String str) throws InterruptedException
	{
		secretory_name.sendKeys(str);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////Owner info3//////////////////////////////////////////////
	
	public void Select_shirshak_bhogvatdar(String str) throws InterruptedException
	{
		Thread.sleep(500);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		Select s = new Select(shirshak_bhogvatdar);
		s.selectByVisibleText(str);
		
		Thread.sleep(500);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_bhogvatdar(String str) throws InterruptedException
	{
		bhogvatdar.sendKeys(str);
	}
	
	public void Enter_occupier_name(String str) throws InterruptedException
	{
		occupier_name.sendKeys(str);
	}
	
	public void Enter_wing(String str) throws InterruptedException
	{
		wing.sendKeys(str);
	}
	
	public void Click_add_owner_info() throws InterruptedException
	{
		add_owner_info.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//////////////////////////////////////////Owner Grid View//////////////////////////////////////////////
	
	public void Click_remove_owner_check_box(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", remove_owner_check_box);
		Thread.sleep(1000);
		try {
			remove_owner_check_box.click();
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
				remove_owner_check_box.click();
			} catch (Exception e2) {
				Thread.sleep(5000);
				remove_owner_check_box.click();
			}
			
		}
		
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting after remove");
		}
		Thread.sleep(500);
	}
	
	public boolean fetch_isPrime_Check_box_grid() throws InterruptedException
	{
		boolean isprime = isPrime_Check_box_grid.isEnabled();
		
		Thread.sleep(1000);
		return isprime;
	}
	
	
	public String fetch_shirshak_from_grid() throws InterruptedException
	{
		String str = shirshak_from_grid.getText();
		
		return str;
	}
	
	public String fetch_kardharak_from_grid() throws InterruptedException
	{
		String str = kardharak_from_grid.getText();
		
		return str;
	}
	
	public String fetch_bhogvatdar_from_grid() throws InterruptedException
	{
		String str = bhogvatdar_from_grid.getText();
		
		return str;
	}
	
	public String fetch_ptta_grid() throws InterruptedException
	{
		String str = ptta_grid.getText();
		
		return str;
	}
	
	public String fetch_dukan_imarat_nav_from_grid() throws InterruptedException
	{
		String str = dukan_imarat_nav_from_grid.getText();
		
		return str;
	}
	
	public String fetch_dukan_flat_no_from_grid() throws InterruptedException
	{
		String str = dukan_flat_no_from_grid.getText();
		
		return str;
	}
	
	public String fetch_wing_from_grid() throws InterruptedException
	{
		String str = wing_from_grid.getText();
		
		return str;
	}
	
	public String fetch_title_from_grid() throws InterruptedException
	{
		String str = title_from_grid.getText();
		
		return str;
	}
	
	public String fetch_taxpayer_name_from_grid() throws InterruptedException
	{
		String str = taxpayer_name_from_grid.getText();
		
		return str;
	}
	
	public String fetch_occupier_from_grid() throws InterruptedException
	{
		String str = occupier_from_grid.getText();
		
		return str;
	}
	
	public String fetch_address_from_grid() throws InterruptedException
	{
		String str = address_from_grid.getText();
		
		return str;
	}
	
	public String fetch_shop_building_name_from_grid() throws InterruptedException
	{
		String str = shop_building_name_from_grid.getText();
		
		return str;
	}
	
	public String fetch_shop_flat_no_grid() throws InterruptedException
	{
		String str = shop_flat_no_grid.getText();
		
		return str;
	}
	
	public String fetch_society_name_marathi_grid() throws InterruptedException
	{
		String str = society_name_marathi_grid.getText();
		
		return str;
	}
	
	public String fetch_society_name_eng_grid() throws InterruptedException
	{
		String str = society_name_eng_grid.getText();
		
		return str;
	}
	
	public String fetch_society_sachiv_name_marathi_grid() throws InterruptedException
	{
		String str = society_sachiv_name_marathi_grid.getText();
		
		return str;
	}
	
	public String fetch_secretory_name_grid() throws InterruptedException
	{
		String str = secretory_name_grid.getText();
		
		return str;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////Floor info////////////////////////////////////////////////
	
	public void Select_floor(String str) throws InterruptedException
	{
		Select s = new Select(floor);
		s.selectByVisibleText(str);
	}
	
	public void Enter_construnction_year(String str) throws InterruptedException
	{
		construnction_year.sendKeys(str);
	}
	
	public void Select_construction_type(String str) throws InterruptedException
	{
		Select s = new Select(construction_type);
		s.selectByVisibleText(str);
		
		
	}
	
	public void Select_type_of_use(String str) throws InterruptedException
	{
		Select s = new Select(type_of_use);
		s.selectByVisibleText(str);
	}
	
	public void Enter_karpatr_chatai_area_sqft_floor(String str) throws InterruptedException
	{
		karpatr_chatai_area_sqft_floor.sendKeys(str);
	}
	
	public String Fetch_karpatr_chatai_area_sqm_floor() throws InterruptedException
	{
		String str = karpatr_chatai_area_sqm_floor.getAttribute("value");
		
		return str;
	}
	
	public void Select_nondani(String str) throws InterruptedException
	{
		Select s = new Select(nondani);
		s.selectByVisibleText("Yes");
	}
	
	public void Enter_no_of_room(String str) throws InterruptedException
	{
		no_of_room.sendKeys(str);
	}
	
	public void Select_renter_available(String str) throws InterruptedException
	{
		Select s = new Select(renter_available);
		s.selectByVisibleText(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////Renter details//////////////////////////////////////////////
	
	public void Enter_renter_name_marathi(String str) throws InterruptedException
	{
		renter_name_marathi.sendKeys(str);
	}
	
	public void Enter_renter_name_eng(String str) throws InterruptedException
	{
		renter_name_eng.sendKeys(str);
	}
	
	public void Enter_calculated_rent(String str) throws InterruptedException
	{
		calculated_rent.sendKeys(str);
	}
	
	public void Select_agreement(String str) throws InterruptedException
	{
		Select s = new Select(agreement);
		s.selectByVisibleText(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_agreement_from_date(String str) throws InterruptedException
	{
		agreement_from_date.sendKeys(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_agreement_to_date(String str) throws InterruptedException
	{
		agreement_to_date.sendKeys(str);
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Enter_non_calculated_rent(String str) throws InterruptedException
	{
		non_calculated_rent.sendKeys(str);
	}
	
	public void Click_add_floor_info() throws InterruptedException
	{
		add_floor_info.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	

	///////////////////////////////////////Floor Grid//////////////////////////////////////////////////////
	
	
	public void Click_remove_floor_check_box(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", remove_owner_check_box);
		Thread.sleep(1000);
		
		remove_floor_check_box.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public String Fetch_floor_grid() throws InterruptedException
	{
		
		String str = floor_grid.getText();
		
		return str;
	}
	
	public String Fetch_construnction_year_grid() throws InterruptedException
	{
		String str = construnction_year_grid.getText();
		
		return str;
	}
	
	public String Fetch_construction_type_grid() throws InterruptedException
	{
		String str = construction_type_grid.getText();
		
		return str;
	}
	
	public String Fetch_type_of_use_grid() throws InterruptedException
	{
		String str = type_of_use_grid.getText();

		return str;
	}
	
	public String Fetch_carpetArea_sqft_grid() throws InterruptedException
	{
		String str = carpetArea_sqft_grid.getText();
		
		return str;
	}
	
	public String Fetch_carpetArea_sqm_grid() throws InterruptedException
	{
		String str = carpetArea_sqm_grid.getText();
		
		return str;
	}
	
	public String Fetch_no_of_room_grid() throws InterruptedException
	{
		String str = no_of_room_grid.getText();
		
		return str;
	}
	
	public String Fetch_nondani_grid() throws InterruptedException
	{
		String str = nondani_grid.getText();
		
		return str;
	}
	
	public String Fetch_renter_available_grid() throws InterruptedException
	{
		String str = renter_available_grid.getText();
		
		return str;
	}
	
	public String Fetch_bhadekaru_name_grid() throws InterruptedException
	{
		String str = bhadekaru_name_grid.getText();
		
		return str;
	}
	
	public String Fetch_calculated_rent_grid() throws InterruptedException
	{
		String str = calculated_rent_grid.getText();
		
		return str;
	}
	
	public String Fetch_non_calculated_rent_grid() throws InterruptedException
	{
		String str = non_calculated_rent_grid.getText();

		return str;
	}
	
	public String Fetch_renter_name_grid() throws InterruptedException
	{
		String str = renter_name_grid.getText();

		return str;
	}
	
	public String Fetch_agreement_grid() throws InterruptedException
	{
		String str = agreement_grid.getText();
		
		return str;
	}
	
	public String Fetch_agreement_from_date_grid() throws InterruptedException
	{
		String str = agreement_from_date_grid.getText();
		
		return str;
	}
	
	public String Fetch_agreement_to_date_grid() throws InterruptedException
	{
		String str = agreement_to_date_grid.getText();
		
		return str;
	}
	
	public void Enter_r_toilet(String str) throws InterruptedException
	{
		r_toilet.sendKeys(str);
	}
	
	public void Enter_c_toilet(String str) throws InterruptedException
	{
		c_toilet.sendKeys(str);
	}
	
	public String Fetch_old_rv() throws InterruptedException
	{
		String str = old_rv.getText();
		
		return str;
	}
	
	public String Fetch_old_alv() throws InterruptedException
	{
		String str = old_alv.getText();
		
		return str;
	}
	
	public String Fetch_new_rv() throws InterruptedException
	{
		String str = new_rv.getText();
		return str;
	}
	
	public String Fetch_new_alv() throws InterruptedException
	{
		String str = new_alv.getText();
		
		return str;
	}
	
	public String Fetch_arthik_varsh() throws InterruptedException
	{
		String str = arthik_varsh.getText();
		
		return str;
	}
	
	public String Fetch_samany_kar() throws InterruptedException
	{
		String str = samany_kar.getText();
		
		return str;
	}
	
	public String Fetch_mnp_shikshan_kar() throws InterruptedException
	{
		String str = mnp_shikshan_kar.getText();
		
		return str;
	}
	
	public String Fetch_rasta_kar() throws InterruptedException
	{
		String str = rasta_kar.getText();
		
		return str;
	}
	
	public String Fetch_vruksh_kar() throws InterruptedException
	{
		String str = vruksh_kar.getText();
		
		return str;
	}
	
	public String Fetch_saf_safai_malpravah_kar() throws InterruptedException
	{
		String str = saf_safai_malpravah_kar.getText();
		return str;
	}
	
	public String Fetch_pani_puravatha_agnishaman_kar() throws InterruptedException
	{
		String str = pani_puravatha_agnishaman_kar.getText();
		
		return str;
	}
	
	public String Fetch_v_panipatti_kar() throws InterruptedException
	{
		String str = v_panipatti_kar.getText();
		return str;
	}
	
	public String Fetch_arahivasi_seva_kar() throws InterruptedException
	{
		String str = arahivasi_seva_kar.getText();

		return str;
	}
	
	public String Fetch_rahivasi_seva_kar() throws InterruptedException
	{
		String str = rahivasi_seva_kar.getText();
		
		return str;
	}
	
	public String Fetch_maha_shikshan_kar() throws InterruptedException
	{
		String str = maha_shikshan_kar.getText();
		
		return str;
	}
	
	public String Fetch_rojgar_hami_kar() throws InterruptedException
	{
		String str = rojgar_hami_kar.getText();
		
		return str;
	}
	
	public String Fetch_v_saf_safai_kar() throws InterruptedException
	{
		String str = v_saf_safai_kar.getText();
		
		return str;
	}
	
	public String Fetch_paniptti_rkkam() throws InterruptedException
	{
		String str = paniptti_rkkam.getText();
		
		return str;
	}
	
	public String Fetch_thakit_shasti() throws InterruptedException
	{
		String str = thakit_shasti.getText();
		
		return str;
	}
	
	public String Fetch_mothi_imarat_notis_warrent_fee() throws InterruptedException
	{
		String str = mothi_imarat_notis_warrent_fee.getText();
		
		return str;
	}
	
	public String Fetch_chalu_shasti() throws InterruptedException
	{
		String str = chalu_shasti.getText();
		
		return str;
	}
	
	public String Fetch_total_ker() throws InterruptedException
	{
		String str = total_ker.getText();
		
		return str;
	}
	
	public String Fetch_vishesh_sut() throws InterruptedException
	{
		String str = vishesh_sut.getText();
		
		return str;
	}
	
	public String Fetch_net_total_kar() throws InterruptedException
	{
		String str = net_total_kar.getText();
		
		return str;
	}
	
	public void Check_solar_check_box() throws InterruptedException
	{
		solar_check_box.click();
	}
	
	public void Check_waterHarvesting_check_box() throws InterruptedException
	{
		waterHarvesting_check_box.click();
	}
	
	public void Check_garbage_check_box() throws InterruptedException
	{
		garbage_check_box.click();
	}
	
	public void Check_garbage_disposal_check_box() throws InterruptedException
	{
		garbage_disposal_check_box.click();
	}
	
	public void Check_eBill_check_box() throws InterruptedException
	{
		eBill_check_box.click();
	}
	
	public void Check_familyplanning_check_box() throws InterruptedException
	{
		familyplanning_check_box.click();
	}
	
	public void Check_womenOwner_check_box() throws InterruptedException
	{
		womenOwner_check_box.click();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////Button//////////////////////////////////////////
	
	public void Button_upload_photo_and_plan() throws InterruptedException
	{
		Thread.sleep(1000);
		
		upload_photo_and_plan.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_old_information_btn(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(1000);
			System.out.println("waiting");
		}
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", save_btn);
		Thread.sleep(1000);
	
		
		old_information_btn.click();
	}
	
	public void Button_water_connection_btn() throws InterruptedException
	{
		water_connection_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_retain_taxes_btn() throws InterruptedException
	{
		retain_taxes_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_add_taxes_and_upload_document_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		wait.until(ExpectedConditions.visibilityOf(add_taxes_and_upload_document_btn));
		Thread.sleep(500);
		
		add_taxes_and_upload_document_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
	}
	
	public void Button_save_btn(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", save_btn);
		Thread.sleep(1000);
	
		Thread.sleep(500);
		save_btn.click();
	}
	
	public void Button_cancel_btn() throws InterruptedException
	{
		cancel_btn.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(1000);
			System.out.println("waiting");
		}
		Thread.sleep(1000);
	}
	
	
	public void Button_DataSaved(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	try {
		wait.until(ExpectedConditions.visibilityOf(DataSaved));
		DataSaved.getText();
		wait.until(ExpectedConditions.visibilityOf(DataSaved_okbtn));
		Thread.sleep(2000);
		DataSaved_okbtn.click();
		System.out.println(DataSaved.getText());
	} catch (Exception e) {
		wait.until(ExpectedConditions.visibilityOf(DataSaved2));
		DataSaved2.getText();
		wait.until(ExpectedConditions.visibilityOf(DataSaved_okbtn2));
		DataSaved_okbtn2.click();
		System.out.println(DataSaved2.getText());
	}
	
	
	
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	public void Button_complaint_registration_yes(WebDriver driver) throws InterruptedException
	{
		complaint_registration_yes.click();
		
		Thread.sleep(1000);
		while(loading_page.getAttribute("aria-hidden").equals("false"))
		{
			Thread.sleep(500);
			System.out.println("waiting");
		}
		Thread.sleep(500);
		
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript
	    		("return document.readyState").toString().equals("complete")){
	    		System.out.println("Page loaded properly.");
	    	}
	    Thread.sleep(500);
	}
	
	
	public void Button_complaint_registration_no(WebDriver driver) throws InterruptedException
	{
		System.out.println("no button clicked...........");
		complaint_registration_no.click();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void Button_building_info_btn(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(building_info_btn));
		
		building_info_btn.click();
	}
	
	public void Save_building_info_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(save_building_info_btn));
		
		save_building_info_btn.click();  
	}
	
	public void Add_taxes_and_upload(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(add_taxes_and_upload_files));
		
		add_taxes_and_upload_files.click();  
	}
	
	public void Enter_occupancy_date(String str)
	{
		occupancy_date.clear();
		occupancy_date.sendKeys(str);
	}
	
	public void Enter_construction_year(String str)
	{
		counstruction_year.clear();
		counstruction_year.sendKeys(str);
	}
	
	public void Button_building_info_ok_btn(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOf(building_info_ok_btn));
		
		building_info_ok_btn.click();
	}
}




















