package pojo;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CMS_browser {

	public static WebDriver openBrowser(String url)
	{
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		
		chromePrefs.put("download.prompt_for_download", false); 
		chromePrefs.put("safebrowsing.enabled", "false"); 
		
		 chromePrefs.put("download.default_directory",
				 System.getProperty("user.dir") + File.separator + "PdfReports");
		 
		 ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--remote-allow-origins=*");
			
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-site-isolation-trials");
			options.addArguments("--allow-running-insecure-content")  ;
			options.addArguments("--disable-extensions") ;
			
			options.addArguments("--ignore-certificate-errors");
			
			WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		//driver.get("http://testbaramatimc.ptaxcollection.com:8080/Pages/Login.aspx");
		driver.get(url);
		
		return driver;
	}
	
	
	 private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	        	HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
	    		chromePrefs.put("plugins.always_open_pdf_externally", true);
	    		
	    		 chromePrefs.put("download.default_directory",
	    				 System.getProperty("user.dir") + File.separator + "temp");
	    		 
	    		 ChromeOptions options = new ChromeOptions();
	    			options.setExperimentalOption("prefs", chromePrefs);
	    			options.addArguments("--remote-allow-origins=*");

	    			options.addArguments("--disable-web-security");
	    			options.addArguments("--disable-site-isolation-trials");
	    			options.addArguments("--allow-running-insecure-content")  ;
	    			options.addArguments("--disable-extensions") ;
	    			
	    			options.addArguments("--ignore-certificate-errors");
	            
	            driver = new ChromeDriver(options);
	            driver.manage().window().maximize();
	    		
	        }
	        return driver;
	    }
	
	
	
}
