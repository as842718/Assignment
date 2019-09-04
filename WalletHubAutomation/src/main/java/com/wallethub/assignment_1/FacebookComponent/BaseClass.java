package com.wallethub.assignment_1.FacebookComponent;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	final static Logger logger =Logger.getLogger(BaseClass.class);
	
	public static WebDriver driver ;
	
	@Parameters({"URL","Browser"})
	@BeforeClass
	public void launchApp(String URL,String Browser){
		
		try {
					
			if (Browser.toUpperCase().contains("CHROME")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			
			//	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				//capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				driver = new ChromeDriver(options);
				driver.get(URL);
				driver.manage().deleteAllCookies();
				
				logger.info("Chrome browser");
				logger.info("URL"+URL);
				
			} else if (Browser.toUpperCase().contains("FIREFOX")) {

				
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") +"\\Driver\\geckodriver.exe");
				
				driver = new FirefoxDriver();
				
				driver.get(URL);
				
				logger.info("FIREFOX");
				logger.info("URL"+URL);

			} else if (Browser.toUpperCase().contains("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") +"\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();		
				driver.get(URL);
				
				logger.info("IE");
				logger.info("URL"+URL);
			}
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());

		
		}
	}
			
	@AfterAll
	public void closeApp(){
		
	//driver.close();
	
	logger.info("Browser Close");
		
	}
	
	

}
