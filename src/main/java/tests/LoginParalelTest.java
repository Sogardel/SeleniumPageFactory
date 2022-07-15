package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginParalelTest  extends BaseTest{

	@Test(priority = 1)
	public void validLoginTest() throws InterruptedException{
		app.navMenu.navigateTo(app.navMenu.loginPopUp);
		app.loginPage.loginInApp(app.loginPage.username, app.loginPage.password);
		assertTrue(app.loginPage.sucessLoginMessage.isDisplayed());
		//app.se.click2(app.loginPage.logoutButton, "logouButton");
		app.se.click(app.loginPage.logoutButton);
	}
	
	//@Test(priority =2)
	public void invlaidLoginTest() {
		
		app.navMenu.navigateTo(app.navMenu.loginPopUp);
		app.loginPage.loginInApp("UserGresit", "ParolaGresita");
		assertTrue(app.loginPage.errorLoginMessage.isDisplayed());
		//app.se.click2(app.loginPage.closePopUpButton, "closePopUp din login form");
		app.se.click(app.loginPage.closePopUpButton);
		
	}
	
	
	
}
