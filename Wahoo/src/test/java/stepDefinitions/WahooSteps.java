package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cart;
import pageObjects.CheckoutPage;
import pageObjects.Homepage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class WahooSteps extends BaseTest {
	public Homepage homepage = new Homepage(driver);
	public ProductCatalogue products = new ProductCatalogue(driver);
	public Cart cart = new Cart(driver);

	@Given("I am on the wahoo homepage.")
	public void i_am_on_the_wahoo_homepage() {

		homepage = launchApp();
	}

	@Given("I close all the popups.")
	public void i_close_all_the_popups() {
		homepage.popClick();
	}

	@Given("I click on all products")
	public void i_click_on_all_products() {
		homepage.getRide().click();
	}

	@Given("I randomly select a product and I check if it has size and\\/or color and I add to cart until I have two items.")
	public void i_randomly_select_a_product_and_i_check_if_it_has_size_and_or_color_and_i_add_to_cart_until_i_have_two_items()
			throws InterruptedException {
		ProductCatalogue products = new ProductCatalogue(driver);
		products.loopers();
	}

	@Given("I click on the cart to remove one item from cart")
	public void i_click_on_the_cart_to_remove_one_item_from_cart() throws InterruptedException {
		Cart cart = new Cart(driver);
		cart.getCart().click();
		Thread.sleep(1000);
		cart.getRemove().click();
	}

	@Given("I click the okay popup")
	public void i_click_the_okay_popup() {
		Cart cart = new Cart(driver);
		cart.getOk().click();
	}

	@Given("I click on view or edit")
	public void i_click_on_view_or_edit() {
		Cart cart = new Cart(driver);
		cart.getEdit().click();
	}

	@Given("I change the {string} and I update the cart")
	public void i_change_the_and_i_update_the_cart(String string) {
		Cart cart = new Cart(driver);
		cart.getQuantity().sendKeys(string);
		cart.getUpdateCart().click();
	}

	@Given("I check if the price has changed and I click on checkout")
	public void i_check_if_the_price_has_changed_and_i_click_on_checkout() {
		Cart cart = new Cart(driver);
		cart.totalChecker();
	}

	@Given("I input {string}, {string}, {string}, {string}, {string}, {string}, {string}, ")
	public void i_input(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) throws InterruptedException {
		CheckoutPage contact = new CheckoutPage(driver);
		Thread.sleep(1000);
		contact.getEmail().sendKeys(string);
		contact.getFName().sendKeys(string2);
		contact.getLName().sendKeys(string3);

		contact.getStreet().sendKeys(string4);
		contact.getCity().sendKeys(string5);
		Thread.sleep(1000);
		contact.stateSelect();
		contact.getZip().sendKeys(string6);
		contact.getPhoneNum().sendKeys(string7);
	}

	@Given("I click on the address validation popup")
	public void i_click_on_the_address_validation_popup() {
		CheckoutPage contact = new CheckoutPage(driver);
		contact.clickAddy();
		contact.clickCont();
	}

	@Given("I select the credit card and input {string}, {string}, {string}")
	public void i_select_the_credit_card_and_input(String string, String string2, String string3)
			throws InterruptedException {
		CheckoutPage contact = new CheckoutPage(driver);
		contact.clickCard();
		Thread.sleep(1000);
		contact.getCardInfo(string, string2, string3);
	}

	@When("I click the checkout button")
	public void i_click_the_checkout_button() {
		CheckoutPage contact = new CheckoutPage(driver);
		contact.clickOrder();
	}

	@Then("I verify the {string}")
	public void i_verify_the_message(String string) throws InterruptedException {
		CheckoutPage contact = new CheckoutPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals(contact.status(),
				"Your card was declined. Your request was in live mode, but used a known test card.");
	}

}
