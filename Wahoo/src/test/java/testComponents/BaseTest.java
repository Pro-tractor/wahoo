package testComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import pageObjects.Homepage;

public class BaseTest {
	public WebDriver driver;
	public Homepage homepage;

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public Homepage launchApp() {
		driver = initializeDriver();
		homepage = new Homepage(driver);

		homepage.getUrl();
		return homepage;

	}

}
