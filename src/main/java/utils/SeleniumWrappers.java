package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers {
	
	public WebDriver driver;
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss.mm").format(new Date());

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;

	}
	
	public void waitForElement(WebElement element) {
	//	String elemName = GetElementName.getDescription(element);

		try {
			Log.info("Called <waitForElement> on " + element  +" at :" + timestamp);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Element " + element + " found at :" + timestamp);
		}catch(NoSuchElementException e) {
			Log.error("Element " + element + "not found! -->Attemtp retry :");
			try {
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOf(element));
			}catch(NoSuchElementException e1) {
				Log.error("Element " + element + "not found on second retry!");

			}
			
		}
	}
	
	
	
	public void click(WebElement element) {
		
		//String elemName = GetElementName.getDescription(element);

		try {
			Log.info("called method click on <element>" + element);
			waitForElement(element);
			element.click();
			
		}catch(StaleElementReferenceException e) {
			element.click();

		}catch (Exception e) {
			Log.error("Click method failed on " + element );
			Log.error(e.fillInStackTrace());		}
	}
	
	public void sendKeys(WebElement element, String keysToSend) {
		//String elemName = GetElementName.getDescription(element);
		try {
			Log.info("called <sendKeys> on ELEMENT: < " + element + " >" + " with value :" + keysToSend );
			waitForElementToBeDisplayed(element);
			Log.info("called <clear> on ELEMENT: < " + element + " >");
			element.clear();
			element.sendKeys(keysToSend);
			
			
		}catch (Exception e) {
			Log.error("method <sendKeys> failed on element :" + element);
			throw new TestException("Error in sending keys!");		
		}
	
	}
	
	
	public void dragAndDrop(WebElement element, int xOffset, int yOffset) {
		
		Actions action =  new Actions(driver);
		action.moveToElement(element).dragAndDropBy(element, xOffset, yOffset).perform();
		
		action.moveToElement(element).clickAndHold(element).moveByOffset(xOffset, yOffset).release(element).build().perform();
		
		
	}
	
	
	public void hoverElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Log.info("called explict wait");
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action =  new Actions(driver);
		action.moveToElement(element).perform();
		Log.info("moved to element");

		
	}
	
	
	public boolean checkCurrentUrl(String expectedUrl) {
		
		if(driver.getCurrentUrl().equals(expectedUrl)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	

	
	public void waitForElementToBeDisplayed(WebElement element) {
		
		try {
			WebDriverWait wait =  new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}catch(NoSuchElementException e) {
			//log
			//retry
			
		}
		
	}


	public void click2(WebElement element, String elementName) {
			
			try {
				Log.info("called method click on ELEMENT: < " + elementName + " >" );
				//System.out.println("Called click etc..");
				//WebDriverWait wait = new WebDriverWait(driver, 10);
				//wait.until(ExpectedConditions.elementToBeClickable(element));
				waitForElement(element);
				element.click();
				
			}catch(Exception e) {
				Log.error("Click method failed");
				Log.error(e.fillInStackTrace());
			}
		}
	
	
	
	
}
