package master;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class configue  extends variable {
	

//-----------------------------------Driver Setup-----------------------------------------------------	

@Description("Test Setup Congfiguration")
@BeforeTest(alwaysRun = true,description = "Test Setup Congfiguration")
public void driverset() throws Exception, InterruptedException {
				
		String currentos = System.getProperty("os.name");
		if(currentos.contains("Windows"))
		{	
			// --------- For run program in Windows Chrome 90.0 Version
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
		}
		else
		{	
			// --------- For run program in Mac OS Chrome 90.0 Version
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver");
		}
				
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//application.properties");
				
		obj = new Properties();
		obj.load(objfile);
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "//Log4j.properties");
		
		logger = Logger.getLogger("WalletHub");

		LoggingPreferences loggingPrefs = new LoggingPreferences();
		loggingPrefs.enable(LogType.BROWSER, Level.ALL);
		loggingPrefs.enable(LogType.CLIENT, Level.ALL);
		loggingPrefs.enable(LogType.DRIVER, Level.ALL);
		loggingPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		loggingPrefs.enable(LogType.PROFILER, Level.ALL);
		loggingPrefs.enable(LogType.SERVER, Level.ALL);

		ChromeOptions options = new ChromeOptions();

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("marionette", true);
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);
			
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("profile.default_content_setting_values.notifications", 1);

		options.setExperimentalOption("prefs", prefs);
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(options);
		
	    wait = new WebDriverWait(driver, 30);
		
	    String url = obj.getProperty("URL");
	    	    
	    driver.get(url);
	    
		driver.manage().window().maximize();
		
		logger.info("Browser Opened Successfully");
		logger.info(driver.getCurrentUrl());	
}
@Description("After Test Exit Congfiguration")
@AfterTest(alwaysRun = true,description = "After Test Exit Congfiguration")
public void aftertest() throws Exception
{
	    logger.info("Browser going to shutdown.");
	    driver.quit();
}

//-------------------------------------Taking Screen Shot For Allure Report---------------------------------------------------------	
	

public byte[] myscreenshot(WebDriver driver) {
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File screenshotFile = screenShot.getScreenshotAs(OutputType.FILE);
		try 
		{
			Allure.addAttachment(TestReason, new FileInputStream(screenshotFile));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
		return null;
}
}