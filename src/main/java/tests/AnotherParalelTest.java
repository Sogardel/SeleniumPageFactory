package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class AnotherParalelTest extends BaseTest {
	
	
	@Test
	public void searchBookTest() {
		
	//	jse.executeScript("arguments[0].click(), arguments[1].value='cooking', arguments[0].click()"
	//			, app.navMenu.searchIcon, app.navMenu.searchInput);
	//	app.se.waitForElement(app.productPage.bookPictureBox);
	//	assertTrue(app.productPage.bookPictureBox.isDisplayed());
	}

}
