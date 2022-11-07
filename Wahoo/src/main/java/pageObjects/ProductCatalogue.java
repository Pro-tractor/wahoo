package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By products = By.cssSelector(
			"[id='section-4'] > div:nth-child(2) > .category-products > .products-grid > li > .text > .product-name > a");

	By color = By.cssSelector("select[name='super_attribute[92]']");

	By size = By.cssSelector("select[name*='super_attribute[2']");

	By addBtn = By.cssSelector("button#product-addtocart-button > span");

	By cartQty = By.cssSelector(".cart-qty.count");


	public WebElement getAddBtn() {

		return driver.findElement(addBtn);
	}

	public WebElement getCartQty() {
		return driver.findElement(cartQty);
	}

	public WebElement getColor() {
		WebElement colors;
		int numOfcolors = driver.findElements(color).size();
		if (numOfcolors > 0) {
			colors = driver.findElement(color);
		} else {
			colors = null;
		}

		return colors;
	}

	public WebElement getSize() {
		WebElement sizes;
		int numOfSizes = driver.findElements(size).size();
		if (numOfSizes > 0) {
			sizes = driver.findElement(size);
		} else {
			sizes = null;
		}

		return sizes;
	}

	public List<WebElement> getProducts() {

		// waitForElementToAppear(products);
		return driver.findElements(products);
	}



	public void selectProduct() {

		WebElement product = randomizer(getProducts());

		Actions action = new Actions(driver);

		action.click(product).perform();



	}

	public void loopers() throws InterruptedException {

		String cartQTY = getCartQty().getText();

		while (!(cartQTY.equalsIgnoreCase("2"))) {
			// cartQTY = getCartQty().getText();

			if (cartQTY.equalsIgnoreCase("2")) {
				break;
			}

			selectProduct();
			WebElement colors = getColor();
			WebElement sizes = getSize();

			if (colors != null) {

				if (!(colors.isEnabled())) {
					if (sizes != null) {
						selector(size, 1);
						selector(color, 1);
						getAddBtn().click();
						Thread.sleep(1000);

						goBack();



					}

				} else if (colors.isEnabled()) {
					selector(color, 1);
					if (sizes != null) {
						selector(size, 1);

						getAddBtn().click();
						goBack();
						Thread.sleep(1000);


					} else {

						getAddBtn().click();
						//						cart += 1;
						goBack();
						Thread.sleep(1000);


					}

				}

			} else {
				goBack();

				waitForElementToAppear(cartQty);
				cartQTY = getCartQty().getText();
			}

		}
	}




}
