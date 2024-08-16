package web_Driver_Methods;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
       driver.manage().window().maximize();
       
       //implicit wait
      //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
       //Explicit wait
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Declaration 
       
     WebElement w =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/Toolsqa.jpg']")));
       w.isDisplayed();
     driver.quit();
	}

}
