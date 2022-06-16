package tests;

import org.testng.annotations.Test;

import utils.BasePage;
import utils.BaseTest;

public class LoginTest extends BaseTest{

	@Test
	public void validLoginTest() throws InterruptedException {
		
		app.navMenu.navigateTo(app.navMenu.loginPopUp);
		app.loginPage.loginInApp(app.loginPage.username, app.loginPage.password);
		
		
		
		
		Thread.sleep(4000);
		
	}
	
	
	
}
