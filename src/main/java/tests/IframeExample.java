package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class IframeExample extends BaseTest{

	
	//@Test
	public void iframeExampleTest() throws InterruptedException {
	
		app.navMenu.navigateTo(app.navMenu.contactsLink);
		Thread.sleep(3000);
		app.contactsPage.zoomMap(app.contactsPage.zoomOut);
		Thread.sleep(3000);	
	}
	
	
	@Test
	public void iframeExample2() throws InterruptedException {
		app.navMenu.navigateTo(app.navMenu.eventsLink);
		app.eventPage.click(app.eventPage.festivalOfOldFilmsLink);
		app.singleEventPage.clickMap();
		
		System.out.println(driver.getWindowHandles());
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(browserTabs.size());
		System.out.println(browserTabs.get(0));
		System.out.println(browserTabs.get(1));
		Thread.sleep(5000);
		
		driver.switchTo().window(browserTabs.get(1));
		String pageTitle =  driver.getTitle();
		System.out.println("Page title :" + pageTitle);
		driver.findElement(By.id("searchboxinput")).clear();
		driver.findElement(By.id("searchboxinput")).sendKeys("Cluj");
		driver.findElement(By.id("searchbox-searchbutton")).click();
		driver.close();
		Thread.sleep(5000);

	}
	
	@Test
	public void openNewTab() throws InterruptedException {
		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open('https://keyfood.ro/', '_blank')");
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		driver.switchTo().window(browserTabs.get(0));
		driver.get("https://www.digi24.ro");
		assertTrue(false);
		Thread.sleep(5000);

	}
	
	
}
