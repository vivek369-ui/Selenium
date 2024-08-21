package day_one;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Locater
public class Second_Test_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		// id
		driver.findElement(By.id("nav-cartx")).click();

		// name
		driver.findElement(By.name("my search")).sendKeys("dd");

		// link
		driver.findElement(By.linkText("Best Sellers")).click();

		// class name
		driver.findElement(By.className("a-link-normal")).click();

		// tag name
		Dimension link = driver.findElement(By.tagName("a")).getSize();
		System.out.println(link);

	}

}
