package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class PageFormatsPage extends SeleniumWrappers {

	public PageFormatsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css = "input[title='Search for:']") public WebElement searchField;
	
	

}
