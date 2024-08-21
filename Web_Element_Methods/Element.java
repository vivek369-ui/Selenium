package Web_Element_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver obj = new ChromeDriver();

		obj.get("https://github.com/login");

		// submit()
		obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']")).sendKeys("vivek");
		obj.findElement(By.xpath("//input[@class='form-control form-control input-block js-password-field']")).sendKeys("ram");
		obj.findElement(By.xpath("//input[@class='form-control form-control input-block js-password-field']")).submit();

		// sendkey() and keys.
		obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']")).sendKeys("vivek",Keys.ENTER, "ram", Keys.ENTER);

		// clear()
		WebElement e = obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
		e.sendKeys("vivek");
		e.clear();

		// getTagName()
		WebElement e1 = obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
		System.out.println(e1.getTagName());

		// getAttribute()
		WebElement e3 = obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
		System.out.println(e3.getAttribute("class"));

		// getText()
		String r = obj.findElement(By.xpath("//a[@class=\"label-link position-absolute top-0 right-0\"]")).getText();
		System.out.println(r);

		// getShadowRoot()
		obj.findElement(By.xpath("//a[@class=\"label-link position-absolute top-0 right-0\"]")).getShadowRoot().findElement(By.id("root")).getText();

		// getLocation()
		WebElement f = obj.findElement(By.xpath((("//a[@class='label-link position-absolute top-0 right-0']"))));
		System.out.println(f.getLocation());

		// getCssValue() IMP
		obj.findElement(By.xpath(("//input[@class=\"btn btn-primary btn-block js-sign-in-button\"]"))).getCssValue("color");

		// getSize()
		System.out.println(obj.findElement(By.xpath((("//a[@class='label-link position-absolute top-0 right-0']")))).getSize());
	}

}
