package nls.Email;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetPage {
	
	static WebDriver driver;


	
	public static WebDriver goToPage(String url){
		
		driver = new FirefoxDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}
}

