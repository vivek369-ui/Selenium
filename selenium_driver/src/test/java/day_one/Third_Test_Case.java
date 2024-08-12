package day_one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Customized locater css 

public class Third_Test_Case {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.samsung.com/in/aisearch/?searchvalue=Galaxy%20Z%20Fold6");

		driver.manage().window().maximize();

		// css Selectors

		// tag and id
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("tag");

		// tag and class
		boolean a = driver.findElement(By.cssSelector("span.a-truncate-cut")).isDisplayed();
		System.out.println(a);

		// tag and attribute
		driver.findElement(By.cssSelector("input[class='query-input__form-input']")).sendKeys("i ot it ");
		driver.findElement(By.cssSelector("a[class='result-sort__title active']"));

		// tag class attribute
		driver.findElement(By.cssSelector("input.nav-input[placeholder='Search Amazon.in']")).sendKeys("djcnl");

	}

}
