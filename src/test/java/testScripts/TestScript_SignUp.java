package testScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonPage.SignUpPage;

public class TestScript_SignUp {
	WebDriver driver;
	SignUpPage SP;
	
	@BeforeTest
	public void launchBrowser() {		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");  
	    driver=new ChromeDriver();  
	    driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    SP = PageFactory.initElements(driver, SignUpPage.class);
	}

	@Test
    public void registration() {
	   SP.validateLang();
	   SP.nameField.sendKeys("gaurav");
	   SP.orgField.sendKeys("gaurav");;
	   SP.emailField.sendKeys("alkari.gaurav1@gmail.com");
	   SP.checkboxTermsCondition.click();
	   SP.btnGetStarted.click();
	   SP.validateErrorMessage();
	}
	
  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }
}
