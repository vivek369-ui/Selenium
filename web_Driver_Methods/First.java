package web_Driver_Methods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// method releted to web page
		
		// get(url)
		driver.get("https://www.mercedes-benz.com/en/");

		// getTitle()
		String e = driver.getTitle();
		System.out.println(e);

		// getCurrentUrl()
		String as = driver.getCurrentUrl();
		System.out.println(as);

		// getPageSource()
		String r = driver.getPageSource();
		System.out.println(r);

		// getWindowHandle()
		String r1 = driver.getWindowHandle();
		System.out.println(r1);

		// getWindowHandles()
		Set<String> r2 = driver.getWindowHandles();
		System.out.println(r2);

		//conditional method
		
		// isDisplayed()
		boolean a = driver.findElement(By.className("brandhub-picture brandhub-picture--contain")).isDisplayed();
		System.out.println(a);

		// isEnabled()
		Boolean en = driver.findElement(By.className("brandhub-relaunch-button brandhub-relaunch-button--white brandhub-relaunch-button--size-m brandhub-search__button-right")).isEnabled();
		System.out.println(en);

		// isSelected()
		Boolean e1 = driver.findElement(By.className("brandhub-relaunch-button brandhub-relaunch-button--white brandhub-relaunch-button--size-m brandhub-search__button-right")).isSelected();
		System.out.println(e1);

	}

}
