package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	  @BeforeMethod
	  public void beforeMethod() throws IOException
	  {
		  lp.openBrowser();
		  lp.openScotiaLoginPage();
	  }
  @Test(priority = 1)
  public void loginWihWrongEmailAndPassword() throws InterruptedException 
  {
	  lp.login(df.wrongEmail,df.wrongPassword);
	  Assert.assertEquals(df.globalErr, lp.readGlobalErr()); 
  }
  
  @Test(priority = 2)
  public void loginWihInvalidEmail() throws InterruptedException 
  {
	  lp.login(df.emailWithSpecialChar,df.wrongPassword);
	  Assert.assertEquals(df.specialCharErr, lp.readErr());
  }
  
  @Test(priority = 3)
  public void loginWihEmptyEmail() throws InterruptedException 
  {
	  lp.login("",df.wrongPassword);
	  Assert.assertEquals(df.emptyEmailErr, lp.readErr());
  }
  
  @Test(priority = 4)
  public void loginWihEmptyPassword() throws InterruptedException 
  {
	  lp.login(df.wrongEmail,"");
	  Assert.assertEquals(df.emptyPasswordErr, lp.readErr());
  }

  @AfterMethod
  public void afterMethod() 
  {
	 lp.closeBrowser();
  }

}
