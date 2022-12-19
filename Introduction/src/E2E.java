import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {
	public static void main (String [] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		website.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//From city
		website.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		website.findElement(By.cssSelector("a[value='DEL']")).click();
		Assert.assertEquals(website.findElement(By.cssSelector("a[value='DEL']")).getAttribute("value"), "DEL");
		
		
		//To city
		website.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		website.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='IXM']")).click();
		
		// Departure date
		website.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(1000);
		
		// Select passenger number
		website.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for(int i = 1 ; i < 5; i++) {
			website.findElement(By.id("hrefIncAdt")).click();
		}
		website.findElement(By.id("btnclosepaxoption")).click();
		
		//tickboxes
		website.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		//checking return date is disabled (e.g TRUE)
		if(website.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 0.5")) {
			Assert.assertTrue(true);
			System.out.println("Return date is disabled");

		} else {
			Assert.assertFalse(false);
		};
		
		website.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//checking return date is enabledd (e.g opacity = 1)
		if(website.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 1")) {
			Assert.assertTrue(true);
			System.out.println("Return date is enabled");
		} else {
			Assert.assertFalse(false);
		};
		
		website.findElement(By.cssSelector("input[type='submit']")).click();

	}
}
