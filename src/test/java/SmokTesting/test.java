package SmokTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	

	    @Test
	    public void testOne() {
	      
	    	String myString = "123";
	    	int myInt = Integer.parseInt(myString);
	    	
	    	System.out.println(myInt);
	    	
	    }

	    @AfterClass
	    public void cleanUp() {
	        // Optional: Clean up if necessary; WebDriver is reused in Test2
	    }
}
