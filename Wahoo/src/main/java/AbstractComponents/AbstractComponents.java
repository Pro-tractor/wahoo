package AbstractComponents;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	protected WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public Select selector(By findBy, int x) {

		Select item = new Select(driver.findElement(findBy));

		item.selectByIndex(x);
		return item;
	}

	public void goBack() {

		driver.navigate().back();

	}

	public WebElement randomizer(List<WebElement> x) {
		Random random = new Random();
		//		List<WebElement> products = x;
		int maxNumOfProducts = x.size();
		int y = random.nextInt(maxNumOfProducts - 1);
		//		System.out.println(maxNumOfProducts);
		WebElement product = x.get(y);
		//		System.out.println(y);
		return product;

	}

}
