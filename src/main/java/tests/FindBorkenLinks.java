package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBorkenLinks extends BaseTest {

	@Test
	public void findBrokenLinks() throws IOException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
	
		System.out.println("Total links :" + links.size());
		
		
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByClassName('menu-item')[1].childNodes[0].setAttribute('href', 'https://keybooks.ro/new-shop/')");
		
		
		
		for(int i = 0; i<links.size(); i++) {
			
			WebElement element  =links.get(i);
			String url = element.getAttribute("href");
			if(url == null) {
				continue;
			}
			System.out.println(url);
			checkLinks(url);
			
		}
		
	}
	
	public static void checkLinks(String urlLink) throws IOException {
		
		try {
			URL url = new URL(urlLink);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setConnectTimeout(2000);
			httpUrlConn.connect();
			if(httpUrlConn.getResponseCode() == 200) {
				System.out.println( urlLink + " - " + httpUrlConn.getResponseMessage() );
			}
			if(httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				
				System.out.println( urlLink + " - " + httpUrlConn.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
}
