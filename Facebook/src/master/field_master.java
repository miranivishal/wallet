package master;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class field_master extends configue{
	
public void post_field() throws Exception 
{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("post_field_click"))));
			driver.findElement(By.xpath(obj.getProperty("post_field_click"))).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("post_field_text"))));
			driver.findElement(By.xpath(obj.getProperty("post_field_text"))).click();
			driver.findElement(By.xpath(obj.getProperty("post_field_text"))).sendKeys(obj.getProperty("facebook_post_text"));
			logger.info("Post Text inserted successfully.");
		}
		catch(Exception e)
		{
			TestReason = "Post Text field not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void post_button() throws Exception 
{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("post_button"))));
			driver.findElement(By.xpath(obj.getProperty("post_button"))).click();
			logger.info("Post click successfully.");
		}
		catch(Exception e)
		{
			TestReason = "Post button not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void facebook_login() throws Exception 
{
		try
		{
			username = obj.getProperty("facebook_email_mobile");
			password = obj.getProperty("facebook_password");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty("login_email"))));			
			driver.findElement(By.id(obj.getProperty("login_email"))).sendKeys(username);
			logger.info("Login Email Address Inserted");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty("login_password"))));
			driver.findElement(By.id(obj.getProperty("login_password"))).sendKeys(password);
			logger.info("Login Password Inserted");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("login_loginbutton"))));
			driver.findElement(By.xpath(obj.getProperty("login_loginbutton"))).click();
			logger.info("Login Button Click");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("facebook_search"))));
			if(driver.findElements(By.xpath(obj.getProperty("facebook_search"))).size() != 0)
			{
				TestReason = "Pass: User Login Successfully and redirect to Home Screen";
				logger.info(TestReason); 
				myscreenshot(driver);
			}
			else
			{
				TestReason = "Fail: User not able to login successfully.";
				logger.info(TestReason);
				myscreenshot(driver);
				Assert.fail(TestReason);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestReason = "Fail: User not able to login successfully.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}

}
