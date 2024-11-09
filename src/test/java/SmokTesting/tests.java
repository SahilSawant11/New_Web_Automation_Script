package SmokTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class tests {

	 private WebDriver driver = testbrowser.getDriver();

	    @Test
	    public void testTwo() {
	        driver.get("http://testpcmc.tabsurveypcmc.org/");
	      
	    }

	    @AfterClass
	    public void cleanUp() {
	        // Optional: Clean up if necessary; WebDriver is reused in Test1
	    }
}