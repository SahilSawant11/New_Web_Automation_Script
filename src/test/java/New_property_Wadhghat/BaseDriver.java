package New_property_Wadhghat;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import SmokTesting.Testdb;
import utility.TakeScreenshoot;

public class BaseDriver {

	static public String url;

	static public WebDriver driver;
	static public ExtentSparkReporter spark;
	static public ExtentReports extent;
	static public ExtentTest test;
	
	static public String userid;
	static public String password;
	static public String node;
	static public String sector;
	static public String PropertyNo;
	
	static public String nodex ="KH";
	static public String sectorx = "6";
	static public String PropertyNox = "76";
	 
	
	static public String node1;
	static public String sector1;
	static public String PropertyNo1;
	
	static public String node2;
	static public String sector2;
	static public String PropertyNo2;
	
	static public String node3;
	static public String sector3;
	static public String PropertyNo3;
	
	static public String node4;
	static public String sector4;
	static public String PropertyNo4;
	
	static public String node5;
	static public String sector5;
	static public String PropertyNo5;
	
	static public String node6;
	static public String sector6;
	static public String PropertyNo6;
	
	static public String node7;
	static public String sector7;
	static public String PropertyNo7;
	
	static public String node8;
	static public String sector8;
	static public String PropertyNo8;
	
	static public String node9;
	static public String sector9;
	static public String PropertyNo9;
	
	static public String node10;
	static public String sector10;
	static public String PropertyNo10;
	
	static public String node11;
	static public String sector11;
	static public String PropertyNo11;
	
	static public String node12;
	static public String sector12;
	static public String PropertyNo12;
	
	static public String akshep_no;
	public TakeScreenshoot takescreenshot=new TakeScreenshoot(driver, null);
	static public int financeYear;
	static public String application_no;
	
	static public String NODE ="KH";
	static public String SECTOR ="5";
	static public String PROPERTYNO="1";
	static public String PROPERTYNOobliq="1-75";
	
	static public String cms_aakshep_prakar ="नविन/वाढीव नोंद";
	static public String cms_aakshep_prakar_OC ="OC Correction";
	static public String cms_aakshep_prakar_wadhghat ="वाढघट";
	static public String date = "20/04/2023";
	static public String mobile = "1111111111";
	static public String cms_remark = "test";
	static public String zone_no = "1";
	static public String khula_bhukhand = "No";
	static public String property_type = "निवासी";
	static public String csn = "123";
	static public String plot_no = "10";
	static public String plot_area_sqft = "500";
	static public String shreni = "INDIVIDUAL";
	static public String shreni_prakar = "R";
	static public String new_property = "No ";
	static public String shirshak_kardharak = "श्री";
	static public String kardharak = "करधारक";
	static public String ptta = "पत्ता";
	static public String dukan_imarat_nav = "इमारत";
	static public String dukan_flat_no = "20";
	static public String title = "Mr";
	static public String taxpayer_name = "Taxpayer";
	static public String address = "Address";
	static public String shop_building_name = "Building";
	static public String shop_flat_no = "20";
	static public String shirshak_bhogvatdar = "श्री";
	static public String bhogvatdar = "भोगवटदार";
	static public String occupier_name = "Occupier";
	
	static public String adhaar = "123456789123";
	static public String pan= "123456789";
	static public String city= "Panvel";
	static public String pin= "400001";
	static public String wing= "X";
	static public String flatno= "21";
	static public String societyname="SOCIETY CHA NAAAV";
	
	static public String floor = "तळमजला";
	static public String construnction_year = "2000";
	static public String construnction_year_new = "2024";
	static public String construction_type = "सिमेंट कॉक्रिट संरचना";
	static public String construction_typeForbaramati = "A1-सिमेंट कॉक्रिट संरचना-उच्च दर्जाचे";
	static public String type_of_use = "निवासी";
	static public String type_of_use_new = "दुकान";
	static public String karpatr_chatai_area_sqft_floor = "400";
	static public String karpatr_chatai_area_sqft_floor_new = "800";
	static public String nondani = "Yes";
	static public String Enter_no_of_room = "4";
	static public String renter_available = "Yes";
	static public String renter_name_marathi = "भाडेकरू1";
	static public String renter_name_eng = "Renter";
	static public String calculated_rent = "5000";
	static public String agreement = "No";
	static public String r_toilet = "2";
	static public String c_toilet = "2";
	static public String oldWardNo = "A127";
	static public String oldPropertyNo = "1908";
	static public String oldPartitionNo = "5";
	static public String oldCityServey = "12321";
	static public String oldRV = "50000";
	static public String oldPropertyTax = "9000";
	static public String oldTaxTotal = "40000";
	static public String propTax = "100";
	static public String EduTax = "111";
	static public String spEduTax = "210";
	static public String EmpTax = "40";
	static public String treeCess = "301";
	static public String fireCess = "402";
	static public String lightCess = "521";
	static public String drainCess = "50";
	static public String roadCess = "20";
	static public String sanitation = "10";
	static public String waterCess = "30";
	static public String waterBenifit = "94";
	static public String waterBill = "53";
	static public String Mbuilding = "53";
	static public String sewage = "53";
	static public String Tax1 = "94";
	static public String Tax2 = "94";
	static public String Tax3 = "53";
	static public String interest = "10";
	static public String oldRemark = "test";
	static public String approvalRemark = "test";
	
	
	static public String ferfar_aakshep_prakar = "फेरफार";
	static public String ferfar_kardharak = "करधारक2";
	static public String ferfar_taxpayer = "xyz";
	static public String ferfar_bhogvatdar = "भोगवटादार";
	static public String ferfar_occupier = "Occupier";
	static public String ferfar_bhadekaru = "भाडेकरू4";
	static public String ferfar_Renter = "Renter3";
	static public String ferfar_oldPurchaseDate = "01/03/2022";
	static public String ferfar_newPurchaseDate = "01/04/2023";
	static public String ferfar_orderNo = "123456";
	static public String ferfar_trnsferDate = "20/04/2023";
	static public String ferfar_remark = "test";
	
	static public String change_oldWardNo = "oldwdtest";
	static public String change_oldPartitionNo = "3test";
	static public String change_oldPropertyNo = "A123";
	static public String change_SocietyNameMarathi = "abc";
	static public String change_SocietyNameEng = "abc1";
	static public String change_newCityservey = "321";
	static public String change_dhukan = "Amt";
	static public String change_shop = "Amt1";
	static public String change_rToilet = "2";
	static public String change_patta = "Amaravati";
	static public String change_address = "amravati1";
	static public String change_cToilet = "2";
	static public String change_wingNo = "A-test";
	static public String change_flatNo = "102";
	static public String change_plotNo = "10";
	static public String change_MobileNo = "1234567890";
	static public String change_email = "abc@gmail.com";
	static public String change_remark = "test";
	
	static public String change_oldWardNo2 = "oldwdtest_B";
	static public String change_oldPartitionNo2 = "3test_B";
	static public String change_oldPropertyNo2 = "B123";
	static public String change_SocietyNameMarathi2 = "def";
	static public String change_SocietyNameEng2 = "def1";
	static public String change_newCityservey2 = "123";
	static public String change_dhukan2 = "Pnv";
	static public String change_shop2 = "PNV1";
	static public String change_rToilet2 = "4";
	static public String change_patta2 = "Panvel";
	static public String change_address2 = "panvel1";
	static public String change_cToilet2 = "6";
	static public String change_wingNo2 = "B-test";
	static public String change_flatNo2 = "21";
	static public String change_plotNo2 = "5";
	static public String change_MobileNo2 = "1111111111";
	static public String change_email2 = "xyz@gmail.com";
	static public String change_remark2 = "automation_test";
	static public String specificDate = "01-10-2024";

	
	@SuppressWarnings("resource")
	public static void GetData() throws IOException
	{
		
		Testdb testdb = new Testdb();
	     testdb.fetchData();  // Fetch data from the database and populate variables
	     node = testdb.GetWard();
	     sector="6";
	 	userid = testdb.Getusername();
	 	password = testdb.Getpassword();
	     url=testdb.Geturl();
	     String bmc="BMC";
	     String pmc="KH";
	     String pcmc="BSR";
	     String check=testdb.getId1();
	     
	     String abc2=check.substring(0, 2);
	     
		 if (pmc.contains(abc2)) {
			
			 String test1=testdb.getId1();
		     node1 = test1.substring(0, 2);  // Get "KH"
		     sector1 = test1.substring(2); // Get "12"   
		     PropertyNo1=testdb.getName1();
		     
		     String test2=testdb.getId1();
		     node2 = test2.substring(0, 2);  // Get "KH"
		     sector2 = test2.substring(2); // Get "12"   
		     PropertyNo2=testdb.getName2();
		     
		     String test3=testdb.getId3();
		     node3 = test3.substring(0, 2);  // Get "KH"
		     sector3 = test3.substring(2); // Get "12"   
		     PropertyNo3=testdb.getName3();
		     
		     
		     String test4=testdb.getId4();
		     node4 = test4.substring(0, 2);  // Get "KH"
		     sector4 = test4.substring(2); // Get "12"   
		     PropertyNo4=testdb.getName4();
		     
		     String test5=testdb.getId5();
		     node5 = test5.substring(0, 2);  // Get "KH"
		     sector5 = test5.substring(2); // Get "12"   
		     PropertyNo5=testdb.getName5();
		     
		     String test6=testdb.getId6();
		     node6 = test6.substring(0, 2);  // Get "KH"
		     sector6 = test6.substring(2); // Get "12"   
		     PropertyNo6=testdb.getName6();
		     
		     String test7=testdb.getId7();
		     node7 = test7.substring(0, 2);  // Get "KH"
		     sector7 = test7.substring(2); // Get "12"   
		     PropertyNo7=testdb.getName7();
		     
		     String test8=testdb.getId8();
		     node8 = test8.substring(0, 2);  // Get "KH"
		     sector8 = test8.substring(2); // Get "12"   
		     PropertyNo8=testdb.getName8();
		     
		     String test9=testdb.getId9();
		     node9 = test9.substring(0, 2);  // Get "KH"
		     sector9 = test9.substring(2); // Get "12"   
		     PropertyNo9=testdb.getName9();
		     
		     String test10=testdb.getId10();
		     node10 = test10.substring(0, 2);  // Get "KH"
		     sector10 = test10.substring(2); // Get "12"   
		     PropertyNo10=testdb.getName10();
		     
		     String test11=testdb.getId11();
		     node11 = test11.substring(0,2);
		     sector11 = test11.substring(2);
		     PropertyNo11 = testdb.getName11();
		     
		     String test12=testdb.getId12();
		     node12 = test12.substring(0,2);
		     sector12 = test12.substring(2);
		     PropertyNo12 = testdb.getName12();
				
	        } else {
	        	// To get properties for BRM and PCMC
	        	 String test1=testdb.getId1();
	    	     node1 = test1.substring(0, 3);  
	    	     sector1 = test1.substring(3);    
	    	     PropertyNo1=testdb.getName1();
	    	     
	    	     String test2=testdb.getId1();
	    	     node2 = test2.substring(0, 3);  
	    	     sector2 = test2.substring(3);    
	    	     PropertyNo2=testdb.getName2();
	    	     
	    	     String test3=testdb.getId3();
	    	     node3 = test3.substring(0, 3);  
	    	     sector3 = test3.substring(3);   
	    	     PropertyNo3=testdb.getName3();
	    	     
	    	     
	    	     String test4=testdb.getId4();
	    	     node4 = test4.substring(0, 3);  
	    	     sector4 = test4.substring(3);   
	    	     PropertyNo4=testdb.getName4();
	    	     
	    	     String test5=testdb.getId5();
	    	     node5 = test5.substring(0, 3);  
	    	     sector5 = test5.substring(3);   
	    	     PropertyNo5=testdb.getName5();
	    	     
	    	     String test6=testdb.getId6();
	    	     node6 = test6.substring(0, 3);  
	    	     sector6 = test6.substring(3);  
	    	     PropertyNo6=testdb.getName6();
	    	     
	    	     String test7=testdb.getId7();
	    	     node7 = test7.substring(0, 3);  
	    	     sector7 = test7.substring(3);   
	    	     PropertyNo7=testdb.getName7();
	    	     
	    	     String test8=testdb.getId8();
	    	     node8 = test8.substring(0, 3);  
	    	     sector8 = test8.substring(3);   
	    	     PropertyNo8=testdb.getName8();
	    	     
	    	     String test9=testdb.getId9();
	    	     node9 = test9.substring(0, 3);  
	    	     sector9 = test9.substring(3);   
	    	     PropertyNo9=testdb.getName9();
	    	     
	    	     String test10=testdb.getId10();
	    	     node10 = test10.substring(0, 3);  
	    	     sector10 = test10.substring(3);  
	    	     PropertyNo10=testdb.getName10();
	    	     
	    	     String test11=testdb.getId11();
			     node11 = test11.substring(0,3);
			     sector11 = test11.substring(3);
			     PropertyNo11 = testdb.getName11();
			     
			     String test12=testdb.getId12();
			     node12 = test12.substring(0,3);
			     sector12 = test12.substring(3);
			     PropertyNo12 = testdb.getName12();
	        }
	     
	     
	     
	    
	     
		financeYear =2024;	
	}
	
	
	public void getproperty()
	{
		
	     
	}
}