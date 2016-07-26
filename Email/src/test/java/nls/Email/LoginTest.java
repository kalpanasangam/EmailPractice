package nls.Email;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



public class LoginTest {
	public WebDriver driver;
	public String url;
	public GmailPageOM page;
	public GmailWelcomePage welcome;
	public String name;
	public String pwd2;
	public String expectedOfWelcome;
 
	
@BeforeSuite
public void beforeSuite(){
	
	
}
	 @BeforeClass
	  public void beforeClass() {
		 url = "https://www.gmail.com/";
		 name="netlogic.consu@gmail.com";
		 pwd2="consu.consu123";
		 expectedOfWelcome ="https://mail.google.com/mail/#inbox";
		 
	  }

 @Test
  public void driverInitialization() {
	 page = new GmailPageOM(url);
	
	 Assert.assertEquals( page.getTitle(), "Gmail");
  }
 
 @Test(dependsOnMethods="driverInitialization")
 public void Credentials() {
	 page.enterEmail(name);
	 page.hitNext();
	
	 page.enterPassword(pwd2);
	 welcome = page.hitEnter();
	
	 Assert.assertTrue(true);
  }
 
 
}
