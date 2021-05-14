package wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import master.field_master;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class review_post extends field_master {
protected String postlocator;	
	
@Story("Wallet Review Verify")
@Description("Wallet Review Verify")
@Severity(SeverityLevel.NORMAL)
@Test (priority = 1, description = "Wallet Review Verification", enabled=true)
public void wallet_review_post_verify() throws Exception, Throwable {
	
			wallet_login();
			
			driver.navigate().to("http://wallethub.com/profile/test_insurance_company/");
			
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath(obj.getProperty("insurance_heading")));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(2000);
			
			rating_field();
			
			Thread.sleep(2000);
			
			policy_dropdown();
			
			review_content_field();
						
			review_submit_button();
			
			Thread.sleep(3000);
			
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("review_submit_verify"))));
				if(driver.findElements(By.xpath(obj.getProperty("review_submit_verify"))).size() != 0)
				{
					TestReason = "Pass: Review posted successfully";
					logger.info(TestReason); 
					myscreenshot(driver);
				}
				else
				{
					TestReason = "Fail: Review not posted successfully";
					logger.info(TestReason);
					myscreenshot(driver);
					Assert.fail(TestReason);
				}
			}
			catch(Exception e)
			{
				TestReason = "Fail: Review not posted successfully";
				logger.info(TestReason);
				myscreenshot(driver);
				Assert.fail(TestReason);
			}		
}
}