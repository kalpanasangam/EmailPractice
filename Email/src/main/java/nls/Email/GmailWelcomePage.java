package nls.Email;

import org.openqa.selenium.WebDriver;

public class GmailWelcomePage extends GetPage {
	
	public static WebDriver driver;

	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}
}

