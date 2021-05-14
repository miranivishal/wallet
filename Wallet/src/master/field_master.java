package master;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class field_master extends configue{
	
public void rating_field() throws Exception 
{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("review_list"))));
			WebElement rating = driver.findElement(By.xpath(obj.getProperty("review_list")));
			System.out.println(rating);
			List<WebElement> star = rating.findElements(By.tagName("svg"));

			star.get(3).click();
			logger.info("4th rate option click");
		}
		catch(Exception e)
		{
			TestReason = "4th rate option not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void review_content_field() throws Exception 
{
		try
		{
			reviewcontent = obj.getProperty("review_content");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("review_content_field"))));
			driver.findElement(By.xpath(obj.getProperty("review_content_field"))).sendKeys(reviewcontent);
			driver.findElement(By.xpath(obj.getProperty("review_content_field"))).sendKeys(Keys.ENTER);
			logger.info("Review content inserted");
		}
		catch(Exception e)
		{
			TestReason = "Review content field not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void review_submit_button() throws Exception 
{
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("review_submit_button"))));
			driver.findElement(By.xpath(obj.getProperty("review_submit_button"))).click();
			logger.info("Review submit button click");
		}
		catch(Exception e)
		{
			TestReason = "Review submit button not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void policy_dropdown() throws Exception 
{
		try
		{
			insurancename = obj.getProperty("insurance_name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("policy_dropdown"))));
			driver.findElement(By.xpath(obj.getProperty("policy_dropdown"))).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("policy_dd_list"))));

			List<WebElement>lis= driver.findElements(By.tagName("li"));
			for(WebElement li:lis)
			 {
				 if(li.getText().contains(insurancename))
				 {	
				 	li.click();
					logger.info("Policy Value Selected");
					break;
				 }
				 else
				 {
					 continue;
				 }
			 }	 
		}
		catch(Exception e)
		{
			TestReason = "Policy dropdown not found.";
			logger.info(TestReason);
			myscreenshot(driver);
			Assert.fail(TestReason);
		}
}
public void wallet_login() throws Exception 
{
		try
		{
			username = obj.getProperty("wallet_email");
			password = obj.getProperty("wallet_password");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("login_menu"))));
			driver.findElement(By.xpath(obj.getProperty("login_menu"))).click();
			logger.info("Login Menu Option Click");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty("login_email"))));			
			driver.findElement(By.id(obj.getProperty("login_email"))).sendKeys(username);
			logger.info("Login Email Address Inserted");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty("login_password"))));
			driver.findElement(By.id(obj.getProperty("login_password"))).sendKeys(password);
			logger.info("Login Password Inserted");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty("login_loginbutton"))));
			driver.findElement(By.xpath(obj.getProperty("login_loginbutton"))).click();
			logger.info("Login Button Click");
			
			Thread.sleep(5000);
			if(driver.findElements(By.xpath(obj.getProperty("login_menu"))).size() == 0)
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
