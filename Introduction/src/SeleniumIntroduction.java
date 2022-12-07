import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Adding 'implements Webdriver' is necessary to access common methods across different browsers (e.g. opening, closing, etc)
// WebDriver is an interface which provides a set of browser automation methods with empty bodies
public class SeleniumIntroduction {

	public static void main(String[] args) throws InterruptedException {
		//Invoking Browser
		// Chrome - ChromeDriver -> Methods
		
		// I had to highlight 'ChromeDriver' and import something, which added the line 1 code
		// There are two ways of accessing methods
		// Method one:
		// ChromeDriver driver = new ChromeDriver() <- has access to all Chrome driver methods
		// Method two:
		// WebDriver driver = new ChromeDriver() <- has access only to Chrome driver methods defined in the WebDriver interface
		// Method one can be problematic when using multiple browsers, as some Chrome driver methods won't work in other browsers (whereas WebDriver ones will)
		
		// Selenium can't invoke browsers directly, you have to call the filepath directly
		// You need to download chromebrowser that is compatible with the version of Chrome
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		// this is a global setting that tells Selenium to wait 3 seconds if elements aren't available
		website.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		// visits a specific website
		website.get("https://rahulshettyacademy.com/locatorspractice/");

		// checks the title of the page
		// console.log in Java is System.out.println()s
		System.out.println(website.getTitle());
		// prints the URL
		System.out.println(website.getCurrentUrl());
		
		//Different selectors id, name, className, xpath, CSS Selector
		website.findElement(By.id("inputUsername")).sendKeys("Username123");
		website.findElement(By.name("inputPassword")).sendKeys("Password123");
		website.findElement(By.xpath("//div[@id='container']//form[@class='form']/button[@type='submit']")).click();
		// website.findElement(By.className("signInBtn")).click();
		// implicit wait is needed as the error message isn't there for the text to be grabbed
		System.out.println(website.findElement(By.cssSelector("p.error")).getText());
		
		// Reset password flow 
		website.findElement(By.linkText("Forgot your password?")).click(); // link text locator
		Thread.sleep(1000);	
	
		website.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Username123"); //xpath locator
		website.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Email@gmail.com");
		website.findElement(By.xpath("//input[@type='text'][2]")).clear(); //xpath locator using index, when multiple items are located
		website.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Email@gmail.com"); //css locator using nth index
		website.findElement(By.xpath("//form/input[3]")).sendKeys("07572390455");
		
		website.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//locate and print success text
		System.out.println("Using CSS: " + website.findElement(By.cssSelector("p.infoMsg")).getText());
		System.out.println("Using xpath: " + website.findElement(By.xpath("//Form/p")).getText());
		
		website.findElement(By.cssSelector(".go-to-login-btn")).click();

		// Back on the login page
		website.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Username123"); //xpath locator
		website.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);	
		website.findElement(By.cssSelector("#chkboxOne")).click();
		website.findElement(By.cssSelector("#chkboxTwo")).click();
		website.findElement(By.cssSelector("button[type='submit']")).click();
		
		// closes the tab
		// an alternative is driver.quit(), this closes the whole browser. 
		
//		driver.close();
	}

}
