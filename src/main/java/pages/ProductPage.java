package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GetElementName;
import utils.Name;
import utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers{

	
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "div[class=post_thumb]") public WebElement bookPictureBox;
	
	
}
