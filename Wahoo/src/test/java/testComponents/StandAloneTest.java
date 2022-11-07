package testComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wahoofitness.com/devices/accessories/apparel/wahooligan-shirt");

		popClick(driver);

		selector(By.cssSelector("select[name='super_attribute[92]']"), 1);
		Thread.sleep(1000);
		selector(By.cssSelector("select[name*='super_attribute[2']"), 1);
	}

	public static Select selector(By findBy, int x) {

		Select item = new Select(driver.findElement(findBy));

		item.selectByIndex(x);
		return item;
	}

	public static WebElement getPopUp(WebDriver driver) {
		WebElement popups;
		int numOfPops = driver.findElements(By.cssSelector(".dy-lb-close")).size();
		if (numOfPops > 0) {
			popups = driver.findElement(By.cssSelector(".dy-lb-close"));
		} else {
			popups = null;
		}

		return popups;
	}

	public static WebElement getAccept(WebDriver driver) {
		WebElement popups;
		int numOfPops = driver.findElements(By.cssSelector("button#onetrust-accept-btn-handler")).size();
		if (numOfPops > 0) {
			popups = driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
		} else {
			popups = null;
		}

		return popups;
	}

	public static void popClick(WebDriver driver) {
		WebElement popup1 = getPopUp(driver);
		WebElement accept = getAccept(driver);

		if (popup1 == null) {
			accept.click();
		} else {
			popup1.click();
			accept.click();
		}

	}

	public static WebElement exists(WebDriver driver) {
		WebElement element;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(".dy-lb-close")));

			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void popup(WebDriver driver) {

		if (exists(driver) != null) {
			exists(driver).click();
			driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
		} else {
			driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
		}
	}
}
