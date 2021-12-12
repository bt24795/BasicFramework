package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	/*public WebElement emailBox = driver.findElement(By.id("usernameInput-input"));
	public WebElement passwordBox = driver.findElement(By.id("password-input"));
	public WebElement loginButton = driver.findElement(By.className("ButtonCore__block"));
	public WebElement GlobalErr = driver.findElement(By.id("globalError"));
	public WebElement Err = driver.findElement(By.xpath("//div[@class='Error__container']"));*/
	
	//WE CANNOT use WebElement like this. we have to use @FindBy(PageFactory)
	//to avoid NullPointerException we use page factory
	
	@FindBy(id = "usernameInput-input")
	public WebElement emailBox;
	
	@FindBy(id = "password-input")
	public WebElement passwordBox;
	
	@FindBy(className = "ButtonCore__block")
	public WebElement loginButton;
	
	@FindBy(id = "globalError")
	public WebElement GlobalErr;
	
	@FindBy(className = "Error__container")
	public WebElement Err;
	
	public void openBrowser() throws IOException
	{
		FileInputStream f = new FileInputStream("D:\\Selenium_Class\\testing\\scotiaProp.properties");
		Properties p = new Properties();
		p.load(f);
		String browser= p.getProperty("browser");
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Class\\SeleniumJars\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this); //to avoid NullPointerException we use page factory
	}
	
	public void openScotiaLoginPage()
	{
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qHZhjve0pSU&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJxSFpoanZlMHBTVSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjIzODc4MzI4LCJpYXQiOjE2MjM4NzcxMjgsImp0aSI6ImQyNDY5OGNlLTk5ODUtNDIwZC1hZjQwLWI0OTRkNzUyODEyYiIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.D2tbVvp8sh0UQ-yWXPRTcNUwEyDXn-tUAjc1PY5LG8B0NypbEf3p_KcE4UG9wOLGTDbwvf9sjLNhJEVex7ZAASm7uF8WxuKwg0Nh64poInnk6VVmIEa1SNOya58bYOWu0vzIrSCGkWIkMYdRu81bEbSeY9UtzaXvNokiXaP91GeM-Hn_kAWitFqUUxQjMUpQS6ygfLaa-HVlUisjC1tPSvRL7h0Yg50m6-uz5ax3HAqqRB34RY791qFfB3vYRSMNDoeFsSqmMw_dHxkBVDLu4uf0My0geSBCmM9LATsoOwAQNEkX6QWX_CTOSI8f4SSLO0x4OM3HqTU7pZFPDsrHIQ&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); // Implicit Wait
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	public void login(String email, String password) throws InterruptedException
	{
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		loginButton.click();
		Thread.sleep(3000);
	}
	public String readGlobalErr() 
	{
		String actual = GlobalErr.getText();
		System.out.println(actual);
		return actual;
	}
	public String readErr()
	{
		String actual= Err.getText();
		System.out.println(actual);
		return actual;
	}
}
