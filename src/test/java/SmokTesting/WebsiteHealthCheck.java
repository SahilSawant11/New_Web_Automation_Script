package SmokTesting;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WebsiteHealthCheck {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentSparkReporter spark;
    private ExtentTest test;
    private StopWatch stopWatch;
    private String screenshotDir;

    @BeforeTest
    public void setup() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        screenshotDir = "screenshots_" + timestamp;
        new File(screenshotDir).mkdirs();

       
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(spark);
        

        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        stopWatch = new StopWatch();
        

    }

    private String takeScreenshot(String websiteName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String fileName = String.format("%s/%s_%s.png", screenshotDir, websiteName, timestamp);
            File destination = new File(fileName);
            FileUtils.copyFile(source, destination);
            return fileName;
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    private String sanitizeFileName(String url) {
        // Remove protocol and special characters from URL for filename
        return url.replaceAll("https?://", "")
                 .replaceAll("[^a-zA-Z0-9.-]", "_")
                 .replaceAll("_+", "_");
    }

    private Map<String, Object> performHealthCheck(String urlString) {
        Map<String, Object> results = new HashMap<>();
        HttpURLConnection connection = null;
        
        try {
            // HTTP Connection Check
            @SuppressWarnings("deprecation")
			URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            results.put("httpStatus", responseCode);
            results.put("isUp", responseCode >= 200 && responseCode < 400);
            results.put("contentType", connection.getContentType());
            results.put("serverInfo", connection.getHeaderField("Server"));

            // Selenium page load and screenshot
            stopWatch.reset();
            stopWatch.start();
            driver.get(urlString);
            stopWatch.stop();
            
            // SS
            String screenshotPath = takeScreenshot(sanitizeFileName(urlString));
            results.put("screenshotPath", screenshotPath);
            
            results.put("loadTime", stopWatch.getTime());
            results.put("pageTitle", driver.getTitle());
            
            // validations
            boolean hasContent = !driver.getPageSource().contains("404") && 
                               !driver.getPageSource().contains("503") &&
                               !driver.getPageSource().toLowerCase().contains("error");
            results.put("hasValidContent", hasContent);
            results.put("hasElements", !driver.findElements(By.tagName("body")).isEmpty());
            results.put("status", "SUCCESS");
            
        } catch (Exception e) {
            results.put("status", "FAILED");
            results.put("error", e.getMessage());
            results.put("isUp", false);
            
       
            try {
                String screenshotPath = takeScreenshot(sanitizeFileName(urlString) + "_error");
                results.put("screenshotPath", screenshotPath);
            } catch (Exception se) {
                System.out.println("Failed to take error screenshot: " + se.getMessage());
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        
        return results;
    }

    private void logResults(String url, Map<String, Object> results) {
        test = extent.createTest("Website Health Check: " + url);
        
        if ("SUCCESS".equals(results.get("status"))) {
            boolean isUp = (boolean) results.get("isUp");
            if (isUp) {
                test.log(Status.PASS, "Website is UP and Healthy");
            } else {
                test.log(Status.FAIL, "Website returned non-success status code");
            }
            
            // Log screenshot
            test.log(Status.INFO, "HTTP Status: " + results.get("httpStatus"));
            test.log(Status.INFO, "Load Time: " + results.get("loadTime") + "ms");
            test.log(Status.INFO, "Page Title: " + results.get("pageTitle"));
            test.log(Status.INFO, "Content Type: " + results.get("contentType"));
            test.log(Status.INFO, "Server Info: " + results.get("serverInfo"));
            test.log(Status.INFO, "Has Valid Content: " + results.get("hasValidContent"));
            test.log(Status.INFO, "Has Rendered Elements: " + results.get("hasElements"));
            
            // Pass screenshot 
            if (results.get("screenshotPath") != null) {
                test.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(
				    results.get("screenshotPath").toString()).build());
            }
        } else {
            test.log(Status.FAIL, "Website is DOWN");
            test.log(Status.INFO, "Error: " + results.get("error"));
            
            // error screenshot 
            if (results.get("screenshotPath") != null) {
                test.fail("Error Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(
				    results.get("screenshotPath").toString()).build());
            }
        }
    }

    @Test
    public void testWebsites() {
        String[] websites = {
        	"http://testbaramatimc.ptaxcollection.com:8080"	,
        	"http://testpanvelmc.ptaxcollection.com:8080",
        	"http://testpcmc.ptaxcollection.com:8080/Pages/Login.aspx",
            "https://test.paywaterbill.org/waterbill/OnlineTaxAndNewConnectionPayment",
            
            "https://panvelmc.org/",
            "https://cfcpanvelmc.org/",
            "https://tradepanvelmc.org/SHEL/ShelHome",
            "https://paywaterbill.org/waterbill/OnlineTaxAndNewConnectionPayment",
            
            "https://baramatimc.org/",
            "https://baramatimc.org/pages/onlinepayment.aspx",
            "https://baramatiwaterbill.ptaxcollection.com/waterbill/OnlineTaxAndNewConnectionPayment",
            
            "https://ptaxcollection.pcmcindia.gov.in/",
            
        };

        for (String website : websites) {
            Map<String, Object> results = performHealthCheck(website);
            logResults(website, results);
            System.out.println("Checked website: " + website);
            if (results.get("screenshotPath") != null) {
                System.out.println("Screenshot saved: " + results.get("screenshotPath"));
            }
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}