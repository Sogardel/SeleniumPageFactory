package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JsExecutorExample extends BaseTest{
	
	
	//@Test
	public void testJs() throws InterruptedException {
	
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		
		//jse.executeScript("arguments[0].click()",app.navMenu.searchIcon);
		//jse.executeScript("arguments[0].value='cooking'", app.navMenu.searchInput);
		//jse.executeScript("arguments[0].click()",app.navMenu.searchIcon);		
		
		
		//jse.executeScript("arguments[0].click(), arguments[1].value='cooking', arguments[0].click()"
		//		, app.navMenu.searchIcon, app.navMenu.searchInput);
		
		
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");
		jse.executeScript("document.getElementsByClassName('search_field')[0].value='cooking' ");
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click()");

		Thread.sleep(3000);
		//alternativa pentru element.getText()
		String bookTitle = jse.executeScript("return document.getElementsByClassName('post_title')[0].childNodes[0].innerHTML").toString();
		System.out.println("Book title :" + bookTitle);
		Thread.sleep(5000);
		//alternativa pentru driver.getTtitle()
		String pageTitle = jse.executeScript("return document.title").toString();
		System.out.println("Page title :" + pageTitle);
		//alternativa pentru driver.getCurrentUrl()
		String pageUrl = jse.executeScript("return document.URL").toString();
		System.out.println("Page url :"+ pageUrl);
		
		jse.executeScript("window.schimbTitlu = function(){document.title= 'This title is changed by js function!';};" 
				+"window.schimbTitlu.call();");
	
		String pageTitleSchimbat = jse.executeScript("return document.title").toString();
		System.out.println("Page title schimbat :" + pageTitleSchimbat);
		
	//	jse.executeScript("document.createEvent(MouseEvents)" 
	//	+ "initMouseEvents" 
	//			+ "dispatch");
		
		
		//check if checkbox is selected
		//1 elemenet.isSelected() --> boolean
		//2 jse.executeScript("document.getElementById('wp-comment-cookies-consent').checked ")--> boolean
			
	}
	
	//@Test
	public void testJs2() throws InterruptedException {
		
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		driver.navigate().to("https://keyfood.ro/");
		Thread.sleep(2000);
		jse.executeScript("window.location = 'https://emag.ro'");
		Thread.sleep(2000);
		//driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		Thread.sleep(2000);
		//driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");
		Thread.sleep(2000);
		//driver.navigate().refresh();
		jse.executeScript("window.history.go(0)");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		Thread.sleep(2000);
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(2000);	
	}
	
	//@Test
	public void testJs3() throws InterruptedException {
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		//scroll by pixel
		//jse.executeScript("window.scrollBy(0, 2500)");
		Thread.sleep(5000);
		//scroll to element
		//jse.executeScript("document.getElementsByClassName('sc_emailer_button')[0].scrollIntoView()");
		WebElement element =  driver.findElement(By.cssSelector("input[value='Sign up']"));
		//scroll to element
		jse.executeScript("arguments[0].scrollIntoView()", element);
		//element.isSelected();
		Thread.sleep(5000);	
		//scroll to element
		Actions action = new Actions(driver);
		//action.moveToElement(element).perform();
		
		//scroll to (down )footer
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight) ");
		//scroll up
		Thread.sleep(5000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight) ");
	}

	@Test
	public void testJs4() {
		
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		
		long startTime = System.currentTimeMillis();
		System.out.println("Start-time : " + startTime);
		
		jse.executeAsyncScript("window.setTimeout(arguments[arguments.length -1], 4000);");
		
		long endTime = System.currentTimeMillis();
		System.out.println("End-time :" + endTime);
		System.out.println("Passed time : "+ (endTime - startTime));
				
	}
	
	

}
