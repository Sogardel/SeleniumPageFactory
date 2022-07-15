package utils;

import pages.ContactsPage;
import pages.EventsPage;
import pages.LoginPage;
import pages.NavMenuPage;
import pages.PageFormatsPage;
import pages.ProductPage;
import pages.ShopPage;
import pages.SingleEventPage;

public class BasePage extends BaseTest {
	
	
	public NavMenuPage navMenu =  new NavMenuPage(getDriver());
	public LoginPage loginPage =  new LoginPage(getDriver());
	public PageFormatsPage postFormatsPage =  new PageFormatsPage(getDriver());
	public ContactsPage contactsPage = new ContactsPage(getDriver());
	public ShopPage shopPage =  new ShopPage(getDriver());
	public EventsPage eventPage = new EventsPage(getDriver());
	public SingleEventPage singleEventPage = new SingleEventPage(getDriver());
	public ProductPage productPage =  new ProductPage(getDriver());
	
	public SeleniumWrappers se = new SeleniumWrappers(getDriver());

}
