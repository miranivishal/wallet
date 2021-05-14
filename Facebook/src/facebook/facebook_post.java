package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import master.field_master;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class facebook_post extends field_master {
protected String postlocator;	
	
@Story("Facebook Post Verify")
@Description("Facebook Post Verify")
@Severity(SeverityLevel.NORMAL)
@Test (priority = 1, description = "Facebook Post Verification", enabled=true)
public void facebook_user_post_verify() throws Exception, Throwable {
	
			facebook_login();
			
			post_field();
			
			post_button();
			
			try
			{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(obj.getProperty("posting_status"))));
				Thread.sleep(2000);
				postlocator = obj.getProperty("post_verify_t1") + obj.getProperty("facebook_post_text") + obj.getProperty("post_verify_t2");
				if(driver.findElements(By.xpath(postlocator)).size() != 0)
				{
					TestReason = "Pass: Facebook post publish successfully";
					logger.info(TestReason); 
					myscreenshot(driver);
				}
				else
				{
					TestReason = "Fail: Facebook post not publish successfully";
					logger.info(TestReason);
					myscreenshot(driver);
					Assert.fail(TestReason);
				}
			}
			catch(Exception e)
			{
				TestReason = "Fail: Facebook post not publish successfully";
				logger.info(TestReason);
				myscreenshot(driver);
				Assert.fail(TestReason);
			}		
}
}