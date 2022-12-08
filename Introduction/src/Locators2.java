import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
	public static void main (String[] args) throws InterruptedException {
		// Selenium can't invoke browsers directly, you have to call the filepath directly
		// You need to download chromebrowser that is compatible with the version of Chrome
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		// this is a global setting that tells Selenium to wait 3 seconds if elements aren't available
		website.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String password = getPassword(website);
		
		// visits a specific website
		website.get("https://rahulshettyacademy.com/locatorspractice/");

		// checks the title of the page
		// console.log in Java is System.out.println()s
		System.out.println(website.getTitle());
		// prints the URL
		System.out.println(website.getCurrentUrl());
		
		String UserName = "Jack";
		
		//Different selectors id, name, className, xpath, CSS Selector
		website.findElement(By.id("inputUsername")).sendKeys(UserName);
		website.findElement(By.name("inputPassword")).sendKeys(password);
		website.findElement(By.xpath("//div[@id='container']//form[@class='form']/button[@type='submit']")).click();
		Thread.sleep(1000);	
		System.out.println(website.findElement(By.tagName("p")).getText());
		
		// Assertions use testng, see pom.xml dependency
		Assert.assertEquals(website.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(website.findElement(By.xpath("//h2")).getText(), "Hello " + UserName + ",");
		
		//Logout
		website.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		
		website.close();
	}
	
	public static String getPassword (WebDriver website) throws InterruptedException {
		website.get("https://rahulshettyacademy.com/locatorspractice/");
		website.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		website.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = website.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		String finalPassword = passwordArray[1].split("'")[0];
		System.out.println("password is " + finalPassword);
		
		return finalPassword;
			
	}
}