package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class ShopPage extends SeleniumWrappers{

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);	
	}

	
	@FindBy(css="span[style='left: 0%;']") public WebElement sliderInitialPostion;
	@FindBy(css="span[style='left: 100%;']") public WebElement sliderFinalPostion;

	
}
