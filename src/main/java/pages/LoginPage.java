package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReadPropertiesFile;
import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {
	
	//public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String username = ReadPropertiesFile.credentials.getProperty("user");
	public String password =  ReadPropertiesFile.credentials.getProperty("pass");
	
	
	@FindBy(id = "log") public WebElement usernameField;
	@FindBy(id = "password") public WebElement passwordField;
	@FindBy(css = "input[class='submit_button']") public WebElement submitButton; 
	
	
	public void loginInApp(String username, String password) {
		
		//usernameField.sendKeys(username);
		sendKeys(usernameField, username);
		//passwordField.sendKeys(password);
		sendKeys(passwordField, password);
		//submitButton.click();
		click(submitButton);
		
	}
	

}
