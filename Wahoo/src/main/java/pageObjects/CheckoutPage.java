package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By email = By.cssSelector("[data-role='email-with-possible-login'] #customer-email");
	By fName = By.cssSelector("div#shipping-new-address-form input[name='firstname']");
	By lName = By.cssSelector("div#shipping-new-address-form input[name='lastname']");
	By companyName = By.xpath("//input[#'VI7TEPD']");
	By streetAddr = By.cssSelector("div[name='shippingAddress.street.0']  input[name='street[0]']");
	By city = By.cssSelector("div#shipping-new-address-form input[name='city']");
	By country = By.cssSelector("div#shipping-new-address-form select[name='country_id']");
	By state = By.cssSelector("div#shipping-new-address-form select[name='region_id']");
	By zip = By.cssSelector("div#shipping-new-address-form input[name='postcode']");
	By phoneNum = By.cssSelector("div#shipping-new-address-form input[name='telephone']");
	By addValid = By.cssSelector("input#candidate_0");
	By contBtn = By.cssSelector("aside:nth-of-type(9) .button.dark.learn_more");
	By payment = By.cssSelector("input#amasty_stripe");
	By cardNum = By.cssSelector("input[name='cardnumber']");
	By cardDate = By.cssSelector("input[name='exp-date']");
	By cvc = By.cssSelector("input[name='exp-date']");
	By placeOrder = By.cssSelector(".-summary.checkout-block button[title='Place Order']");
	By orderStatus = By.cssSelector("#checkout > div.messages > div > div");

	public String status() {
		return driver.findElement(orderStatus).getText();
	}

	public void clickAddy() {
		waitForElementToAppear(addValid);
		driver.findElement(addValid).click();
	}

	public void clickCont() {

		driver.findElement(contBtn).click();
	}

	public void clickCard() {
		driver.findElement(payment).click();
	}

	public void getCardInfo(String num, String date, String cvcNum) {
		driver.switchTo().frame(0);

		driver.findElement(cardNum).sendKeys(num);
		driver.findElement(cardDate).sendKeys(date);
		driver.findElement(cvc).sendKeys(cvcNum);
		driver.switchTo().parentFrame();
		;

	}

	public void clickOrder() {
		waitForElementToAppear(placeOrder);
		driver.findElement(placeOrder).click();
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getFName() {
		return driver.findElement(fName);
	}

	public WebElement getLName() {
		return driver.findElement(lName);
	}

	public WebElement getCompanyName() {
		return driver.findElement(companyName);
	}

	public WebElement getStreet() {
		return driver.findElement(streetAddr);
	}

	public WebElement getCity() {
		return driver.findElement(city);
	}

	public WebElement getCountry() {
		return driver.findElement(country);
	}

	public WebElement getState() {
		return driver.findElement(state);
	}

	public void stateSelect() {
		selector(state, 43);
	}

	public WebElement getZip() {
		return driver.findElement(zip);
	}

	public WebElement getPhoneNum() {
		return driver.findElement(phoneNum);
	}


}
