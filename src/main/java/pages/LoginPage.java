package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GetElementName;
import utils.Name;
import utils.ReadPropertiesFile;
import utils.SeleniumWrappers;

public class LoginPage extends SeleniumWrappers {
	
	//public WebDriver driver;
//	public NameStore name;
	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this);
		GetElementName.store(driver);

	}
	
	public String username = ReadPropertiesFile.credentials.getProperty("user");
	public String password =  ReadPropertiesFile.credentials.getProperty("pass");
	
	@Name(Description = "LoginPage.usernameField")
	@FindBy(id = "log") public WebElement usernameField;
	
	@FindBy(id = "password") public WebElement passwordField;

	@FindBy(css = "input[class='submit_button']") public WebElement submitButton; 

	@FindBy(css = "li[class='menu_user_logout']") public WebElement logoutButton;
	
	@Name(Description = "LoginPage.loginPopUp")
	@FindBy(css = "li[class='menu_user_login']") public WebElement loginPopUp;
	
	
	@FindBy(css = "div[class*=sc_infobox_style_error]") public WebElement errorLoginMessage;
	
	@FindBy(css = "div[class*=sc_infobox_style_success]") public WebElement sucessLoginMessage;
	@FindBy(css = ".popup_close") public WebElement closePopUpButton;

	
	public void loginInApp(String username, String password) {
		
		//usernameField.sendKeys(username);
		sendKeys(usernameField, username);
		//passwordField.sendKeys(password);
		sendKeys(passwordField, password);
		//submitButton.click();
		click(submitButton);
		
	}
	

}
