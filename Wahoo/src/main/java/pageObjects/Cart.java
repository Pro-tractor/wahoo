package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class Cart extends AbstractComponents {

	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By cart = By.cssSelector(".wf-cart");

	By remove = By.cssSelector("li:nth-of-type(1) > .product a[title='Remove item']");

	By ok = By.cssSelector(".action-accept.action-primary");

	By removedConfirm = By.xpath("//div[@id='minicart-content-wrapper']/span/span[.='Item was removed successfully']");

	By viewEdit = By.cssSelector(".action.viewcart");

	By quantity = By.cssSelector(".input-text.qty");

	By updateCart = By.cssSelector("button[name='update_cart_action']");

	By total = By.cssSelector(".grand.totals > .amount  .price");

	By unitPrice = By.cssSelector(".col.price > .price-excluding-tax  .price");

	By checkout = By.cssSelector("button[title='Proceed to Checkout']");

	public WebElement getCart() {
		return driver.findElement(cart);
	}


	public WebElement getRemove() {
		return driver.findElement(remove);
	}

	public WebElement getOk() {
		return driver.findElement(ok);
	}

	public WebElement getConfirm() {
		return driver.findElement(removedConfirm);
	}

	public WebElement getEdit() {
		return driver.findElement(viewEdit);
	}

	public WebElement getQuantity() {
		return driver.findElement(quantity);
	}

	public WebElement getUpdateCart() {
		return driver.findElement(updateCart);
	}

	public WebElement getTotal() {
		return driver.findElement(total);
	}

	public WebElement getUnitPrice() {
		return driver.findElement(unitPrice);
	}

	public WebElement getCheckout() {
		return driver.findElement(checkout);
	}

	public void totalChecker() {
		String original = getUnitPrice().getText();

		String total = getTotal().getText();
		System.out.println("This is the original price: " + original);
		System.out.println("This is the updated price: " + total);
		if (!(original.equalsIgnoreCase(total))) {
			getCheckout().click();
			System.out.println("Cart was updated successfully.");
		} else {
			System.out.println("Price did not change. Please update quantity.");
		}

	}

}
