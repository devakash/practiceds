package couponduniatest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CouponD_Test {

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajain5\\Downloads\\chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {


		// Creating an WebDriver object for CHROME Browser
		WebDriver driver = new ChromeDriver();

		// Load the URL
		String URL = "http://selenium.couponapitest.com/";
		driver.get(URL);

		// Get the list of all Links
		List<WebElement> element = driver.findElements(By.tagName("a"));

		for (int i = 0; i < element.size(); i++) {
			element.get(i).click();

			//Getting page title
			String pageTitle = driver.getTitle();

			//condition to check if page has Title
			if (!pageTitle.toLowerCase().contains(URL)) {
				if (pageTitle.contains("404")) {
					System.out.println("Page "+(i+1)+" has 404 error. "+driver.getCurrentUrl());
					}
				System.out.println("Page " + (i + 1) + " title is --> "+pageTitle );
			} else {
				System.out.println("Page " + (i + 1) + " title doesn't exists.");
			}

			//Logic to check if a page has an image and it contains alternate text if any.
			List<WebElement> l = driver.findElements(By.tagName("img"));

			if (l.size() > 0) {
				String alternateText = l.get(0).getAttribute("alt");
				if (alternateText.length() > 0) {
					System.out.println("Page " + (i + 1) + " has an image and alternate text is :" + alternateText);
				} else {
					System.out.println("Page " + (i + 1) + " has an image but alternate text is not present.");
				}
			}
			
			String pageSource=driver.getPageSource();
			if(pageSource.toLowerCase().contains("Fatal error".toLowerCase()))
			{
				System.out.println("Page "+(i+1)+" has PHP erros. "+driver.getCurrentUrl());
			}

			driver.navigate().back();
			Thread.sleep(2500);
			
			//to avoid StaleElementReferenceException
			element = driver.findElements(By.tagName("a"));
			
			System.out.println();
		}
		
		driver.quit();

	}
	
	

}
