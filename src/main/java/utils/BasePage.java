package utils;

import pages.ContactsPage;
import pages.LoginPage;
import pages.NavMenuPage;
import pages.PageFormatsPage;
import pages.ShopPage;

public class BasePage extends BaseTest {
	
	
	public NavMenuPage navMenu =  new NavMenuPage(driver);
	public LoginPage loginPage =  new LoginPage(driver);
	public PageFormatsPage postFormatsPage =  new PageFormatsPage(driver);
	public ContactsPage contactsPage = new ContactsPage(driver);
	public ShopPage shopPage =  new ShopPage(driver);
	
	
	public SeleniumWrappers se = new SeleniumWrappers(driver);
	

}
