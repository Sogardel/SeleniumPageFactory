package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Driver {
	
	
	public static WebDriver driver;
	public String url = ReadPropertiesFile.config.getProperty("url");
	public String browser = ReadPropertiesFile.config.getProperty("browser");
	public BasePage app;
	
	@BeforeClass
	public void setUp() {
		
		driver = initDriver(browser);
		Log.info("Started suite on :" + browser);
		driver.get(url);
		Log.info("Opened URL| :" + url);

		app =  new BasePage();
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		Log.info("Clsed all browser tabs");
	}
	

}
