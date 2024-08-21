package day_one;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.SearchContext;
public class First_Test_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.samsung.com/in/");
		String tit = "Samsung India | Mobile | TV | Home Appliances";
		String title = driver.getTitle();

		if (title.equals(tit))

		{
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		driver.close();

	}

}
