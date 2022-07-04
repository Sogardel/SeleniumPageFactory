package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class EventsPage extends SeleniumWrappers {

	public EventsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(linkText = "Festival of Old Films") public WebElement festivalOfOldFilmsLink;
	
	
}
