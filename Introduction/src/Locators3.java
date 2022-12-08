import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver website = new ChromeDriver();
		
		website.get("https://rahulshettyacademy.com/AutomationPractice/");
		// traversing from sibling to sibling
		System.out.println(website.findElement(By.xpath("//div/button[1]/following-sibling::button[1]")).getText());
		// traversing from sibling to parent
		// System.out.println(website.findElement(By.xpath("//div/button[1]/parent::div")).getText());
		System.out.println(website.findElement(By.xpath("//div/button[1]/following-sibling::button[1]/parent::div/parent::header/a[2]")).getText());

		
	}
}
