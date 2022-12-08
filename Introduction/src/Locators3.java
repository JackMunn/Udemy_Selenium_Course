import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver website = new ChromeDriver();
		
		website.get("https://rahulshettyacademy.com/AutomationPractice/");
		website.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).click();

		
	}
}
