import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		//viewport settings
		website.manage().window().maximize();
		website.get("http://www.google.com"); // this way of going to a website waits until all web components are loaded before continuing
		website.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/"); //this way does it, it'll immediately move to the next step
		website.navigate().back();
		website.navigate().forward();
	}
}
