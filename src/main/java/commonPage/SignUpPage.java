package commonPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@id='language']")
	public WebElement lang;
	
	@FindBy(xpath="//div[@id='language']")
	public List<WebElement> langDropdown;
	
	@FindBy(xpath="//input[@ng-model='signUpData.Name']")
	public WebElement nameField;
	
	@FindBy(xpath="//input[@id='orgName']")
	public WebElement orgField;
	
	@FindBy(xpath="//input[@id='singUpEmail']")
	public WebElement emailField;
	
	@FindBy(xpath="//label[@class='ui-checkbox']/span")
	public WebElement checkboxTermsCondition;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnGetStarted;
	
	@FindBy(xpath="//div[@ng-show='errorMessage']//span")
	public WebElement emailSentMessage;
	
	public SignUpPage(WebDriver driver) {
		 this.driver = driver;
	}
	
	public void validateLang() {
		JavascriptExecutor js=(JavascriptExecutor)driver;  	
		js.executeScript("arguments[0].click();", lang);

		List<WebElement> langOption=langDropdown;
		for(WebElement dropdownOption:langOption)  
		{  
		 System.out.println("options are :-" +dropdownOption.getText());		 
		 List<String> listOption=new ArrayList<String>(Arrays.asList("English", "Dutch")); 
		 System.out.println(listOption.equals(dropdownOption)); 
		}  
	}
	
	public void validateErrorMessage() {
       String valMessage="A welcome email has been sent. Please check your email.";
       WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(emailSentMessage));
        
       String valMesText=emailSentMessage.getAttribute("innerText");
       System.out.println("Text msg :-" +valMesText);
  
       Assert.assertTrue(valMesText.equals(valMessage));
	}
}
