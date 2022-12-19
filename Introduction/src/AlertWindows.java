import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertWindows {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		website.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String name = "Jack";
		
		// enters name and triggers alert
		website.findElement(By.id("name")).sendKeys(name);
		website.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		
		//switches context from browser to alert
		System.out.println(website.switchTo().alert().getText());
		website.switchTo().alert().accept();
		
		website.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(website.switchTo().alert().getText());
		website.switchTo().alert().dismiss();
		
	}
}
