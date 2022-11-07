package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Homepage extends AbstractComponents {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By ride = By.xpath("//nav[@id='top_nav']//a[@title='Ride']/span[.='RIDE']");
	By popup1 = By.cssSelector("[aria-busy] div:nth-child(60) .dy-lb-close");
	By acceptBtn = By.cssSelector("button#onetrust-accept-btn-handler");


	public void getUrl() {
		driver.get("https://www.wahoofitness.com/");
	}

	public WebElement getPopUp() {
		WebElement popups;
		int numOfPops = driver.findElements(popup1).size();
		if (numOfPops > 0) {
			popups = driver.findElement(popup1);
		} else {
			popups = null;
		}

		return popups;
	}

	public WebElement getAccept() {
		WebElement popups;
		int numOfPops = driver.findElements(acceptBtn).size();
		if (numOfPops > 0) {
			popups = driver.findElement(acceptBtn);
		} else {
			popups = null;
		}

		return popups;
	}

	public void popClick() {
		WebElement popup1 = getPopUp();
		WebElement accept = getAccept();

		if (popup1 == null) {
			accept.click();
		} else {
			popup1.click();
			accept.click();
		}

	}

	//	public WebElement getPopup() {
	//		return driver.findElement(popup1);
	//	}
	//
	//	public static WebElement getAcceptBtn() {
	//		return driver.findElement(acceptBtn);
	//	}
	//	public static WebElement exists(WebDriver driver) {
	//		WebElement element;
	//		try {
	//
	//			WebDriverWait wait = new WebDriverWait(driver, 1);
	//			element = wait.until(ExpectedConditions
	//					.visibilityOfElementLocated(By.cssSelector("[aria-busy] div:nth-child(60) .dy-lb-close")));
	//
	//			return element;
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return null;
	//
	//	}
	//
	//	public void popup(WebDriver driver) {
	//
	//		if (exists(driver) != null) {
	//			exists(driver).click();
	//			getAcceptBtn().click();
	//		} else {
	//			getAcceptBtn().click();
	//		}
	//	}

	public WebElement getRide() {
		return driver.findElement(ride);
	}

}
