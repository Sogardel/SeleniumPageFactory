package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	
	public WebDriver driver;
	
	
	public WebDriver initDriver(String browser) {
		
		switch(browser.toLowerCase()) {
		
		case "chrome" :
		//	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			long id = Thread.currentThread().getId();
			System.out.println("Chrome ---> Thread.id :" + id);
		
		return driver;
		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			long id2 = Thread.currentThread().getId();
			System.out.println("Firefox ---> Thread.id :" + id2);
			
		return driver;
			
		default:
			return driver;
		}
				
	}
	

}
