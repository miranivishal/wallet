# WalletHub
This is a test project for Automation testing for WalletHub in Selenium Webdriver with Java Language.

Prerequiste:

Chrome Browser: https://www.google.com/intl/en_in/chrome/

Chrome Driver: https://chromedriver.chromium.org/

Maven: https://maven.apache.org/download.cgi

Java: https://www.java.com/en/download/

Allure(Report): https://docs.qameta.io/allure/

Please set environment variable and path for Maven and Java.

Step 1: Clone the code from git repository

Step 2: You will have file "chromedriver" you need to download chromedriver from https://chromedriver.chromium.org/ 
acording your OS and browser version and replace it.

Step 3: Now go to command prompt and set project repository as based.

Step 4: Run command 'mvn clean test'. This will start executing test in chrome browser.

Step 5: After successfull execute, run command 'allure serve allure-results' to generate Allure Report.

Additional Note: In application.properties file You need to set your username and password for Facebook & WalletHub Account as below variable

WalletHub

wallet_email = Insert Your Email Address

wallet_password = Insert Your Password

Facebook

facebook_email_mobile = Insert Your Username	

facebook_password = Insert Your Password

Note: For WalletHub Test, I am not able to perform the last one scenario because after submit the review it require to approve and its not immediate available under profile section. Rest of the completed as per requirment.