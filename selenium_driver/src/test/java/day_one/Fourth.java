package day_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Customized locater x-path

public class Fourth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		// driver.get("https://github.com/");
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();

		// X-path with single attribute
		driver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']")).sendKeys("mil gaya");

		// X-path with multiple attribute
		driver.findElement(By.xpath("//a[@title='My eBay'] [@class='gh-eb-li-a gh-rvi-menu']")).click();

		// X-path with AND and OR
		// and
		driver.findElement(By.xpath("//a[@title='My eBay and @class='gh-eb-li-a gh-rvi-menu']")).click();

		// or
		driver.findElement(By.xpath("//*[@id='gh-shop-a' or @class='gh-control']")).click();

		// X-path inner text (not used any attribute) text()
		String s = driver.findElement(By.xpath("//a[text()='Watchlist']")).getText();
		System.out.println(s);

		//X-path with contains contains()
		driver.findElement(By.xpath("//img[contains(@role,'pre')]")).click();
		
		//X-path with starts_with starts-with()
		driver.findElement(By.xpath("//*[starts-with(@role,'pre')]")).click();
		
		//X-path chained 
		driver.findElement(By.xpath("//div[@id='gh-top']/ul[2]/li[3]")).click();
	}

}
