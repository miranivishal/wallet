package master;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class variable {

	protected WebDriver driver;
	protected Logger logger;
	protected Properties obj;
	protected WebDriverWait wait;	
	protected String screenshotname;
	protected String TestReason;
	protected String username;
	protected String password;
	protected String insurancename;
	protected String reviewcontent;
}
