import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Section7 {
	public static void main (String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver website = new ChromeDriver();
		
		//viewport settings
		website.manage().window().maximize();
		website.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select HTML tag (a static dropdown)
		WebElement staticDropdown = website.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
		// selecting based on indexed
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// selecting based on option text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// select based on value attribute
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "INR");
		
		
		// selecting passengers using clicks
		website.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		// adds 4 adults
		for(int adults = 1; adults < 5; adults++) {
			website.findElement(By.id("hrefIncAdt")).click();			
		}
		Assert.assertEquals(website.findElement(By.id("divpaxinfo")).getText(),"5 Adult"); 
		website.findElement(By.id("btnclosepaxoption")).click();
		
		// Select depature city
		website.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		website.findElement(By.xpath("//a[@value='MAA']")).click();
		website.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"]//a[@value='MAA']")).click(); // alternative to line above
		
		Assert.assertEquals(website.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"), "Chennai (MAA)");
		
		// select arrival city
		website.findElement(By.cssSelector("[name='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(2000);
		// it's necessary to use an index here, as there are two a HTML tags with a value of AIP
		// website.findElement(By.xpath("(//a[@value='AIP'])[2]")).click(); // some orgnaisations don't like using indexes
		// instead use parent > child traverse
		website.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='AIP']")).click();
		
		
		
		// ---- Handling calendar
		
		website.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	
				
		website.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// .isEnabled doesn't work for some reason
		// Assert.assertTrue(website.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		if(website.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 1")) {
			//If opacity is 1, then it is enabled
			Assert.assertTrue(true);
		} else {
			//If opacity is 1 then it is disabled
			Assert.assertTrue(false);
		};
	

		
		
		/// ------Handling dynamic auto suggestive dropdowns
		website.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = website.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		//Loops through options, which is a list of web elements, and in each iterations places it in 'option'
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		// -----Handling checkboxes
		Assert.assertFalse(website.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		website.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(website.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		//returns true for each checkbox on page
		
		List<WebElement> checkboxes = website.findElements(By.cssSelector("input[type='checkbox']"));
		Assert.assertEquals(website.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		for(WebElement checkbox : checkboxes) {
			if(checkbox.isSelected()== true ) {
				System.out.println(checkbox.getAttribute("name") + "is selected");
			} else {
				System.out.println (checkbox.getAttribute("name") + " is not selected");
			}
		}

		
		
		

	}
}
