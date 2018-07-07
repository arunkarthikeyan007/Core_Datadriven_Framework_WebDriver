package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestProdDisplay {

	@Test
	public void testProdDisplay()
	{
				
WebDriver Driver = new FirefoxDriver();
		
		Driver.get("http://demo.virtuemart.net/");
		Driver.findElement(By.xpath("html/body/div[1]/div/div[1]/ul[2]/li[1]/a")).click();
		
		WebElement featuredview = Driver.findElement(By.className("featured-view"));
		//Categories.findElements(By.title("Product variants"));
		
		int showproduct = featuredview.findElements(By.className("product-details")).size();
		
		System.out.println(showproduct);
	}
}
