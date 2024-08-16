package web_Driver_Methods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//navigation methods
public class Third {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.apple.com/");
		
		//navigate().to()
		//URL myurel =new URL("https://www.sony.co.in/homepage");
		driver.navigate().to("https://www.sony.co.in/homepage");
		
		URL myurel =new URL("https://www.sony.co.in/homepage");
		driver.navigate().to(myurel);
		
		
		//navigate().back()
	   //navigate().forward()
		
		driver.navigate().to("\"https://www.sony.co.in/homepage\"");
		driver.navigate().to("\"https://www.apple.com/\"");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		//navigate().refresh();
		
		driver.navigate().refresh();
	}

}
