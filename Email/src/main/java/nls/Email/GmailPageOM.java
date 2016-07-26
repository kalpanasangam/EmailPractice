package nls.Email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailPageOM extends GetPage{
	
	
	
	WebDriver driver;
	
	By email = By.id("Email");
	By next = By.id("next");
	By pwd = By.id("Passwd");
	By signin = By.id("signIn");
	
	public GmailPageOM(String url){
		driver=goToPage(url);
	}
	
	public void enterEmail(String name){
		driver.findElement(email).sendKeys(name);
		
	}
	
	public void hitNext(){
		driver.findElement(next).click();
		driver.navigate().forward();
	}
	
	public void enterPassword(String pwd2){
		driver.findElement(pwd).sendKeys(pwd2);
	}
	
	public GmailWelcomePage hitEnter(){
		driver.findElement(signin).click();
//		driver.navigate().forward();
		GmailWelcomePage GWP = PageFactory.initElements(driver, GmailWelcomePage.class);
		return GWP;
		
	}
	
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}

}

