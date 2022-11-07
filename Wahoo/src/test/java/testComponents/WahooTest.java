
package testComponents;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Cart;
import pageObjects.CheckoutPage;
import pageObjects.Homepage;
import pageObjects.ProductCatalogue;

public class WahooTest extends BaseTest {

	@Test
	public void order() throws InterruptedException {
		// Home Page
		Homepage homepage = new Homepage(driver);
		homepage.popClick();
		homepage.getRide().click();
		// Product Page
		ProductCatalogue products = new ProductCatalogue(driver);
		products.loopers();
		Thread.sleep(1000);
		// Cart Page
		Cart cart = new Cart(driver);
		cart.getCart().click();
		Thread.sleep(1000);
		cart.getRemove().click();
		Thread.sleep(1000);
		cart.getOk().click();
		Thread.sleep(2000);
		cart.getEdit().click();
		Thread.sleep(2000);
		cart.getQuantity().sendKeys("3");
		Thread.sleep(1000);
		cart.getUpdateCart().click();
		Thread.sleep(3000);
		cart.totalChecker();
		// Contact Page
		CheckoutPage contact = new CheckoutPage(driver);
		Thread.sleep(1000);
		contact.getEmail().sendKeys("davidsmith@yahoo.com");
		contact.getFName().sendKeys("David");
		contact.getLName().sendKeys("Smith");
		// contact.getCompanyName().sendKeys("RobU INC.");
		contact.getStreet().sendKeys("3150 Rochambeau Ave");
		contact.getCity().sendKeys("Bronx");
		Thread.sleep(1000);
		contact.stateSelect();
		contact.getZip().sendKeys("10467-3803");
		contact.getPhoneNum().sendKeys("7186539773");
		Thread.sleep(1000);
		contact.clickAddy();
		contact.clickCont();
		Thread.sleep(2000);
		contact.clickCard();
		Thread.sleep(1000);
		contact.getCardInfo("5440479220582517", "1225", "6206");
		Thread.sleep(1000);
		contact.clickOrder();
		Thread.sleep(5000);
		Assert.assertEquals(contact.status(),
				"Your card was declined. Your request was in live mode, but used a known test card.");

	}

}







