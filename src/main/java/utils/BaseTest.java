package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTest extends Driver {
	
	
	//public static WebDriver driver;
	public String url = ReadPropertiesFile.config.getProperty("url");
	//public String browser = ReadPropertiesFile.config.getProperty("browser");
	public BasePage app;
	public JavascriptExecutor jse;
	
	public static ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		
		//driver = initDriver(browser);
		Log.info("Started suite on :" + browser);
		//driver.get(url);
		driver.set(initDriver(browser));	
		getDriver().get(url);
		
		Log.info("Opened URL| :" + url);
		jse = (JavascriptExecutor)getDriver();
		app =  new BasePage();
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	
	@AfterClass
	public void tearDown() {
		getDriver().quit();
		//driver.quit();
		Log.info("After test Thread ID :" + Thread.currentThread().getId());
		//driver.remove();
	}
	

}
