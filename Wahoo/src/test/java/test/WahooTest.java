
package test;

import org.testng.annotations.Test;

import testComponents.BaseTest;

public class WahooTest extends BaseTest {

	@Test
	public void order() throws InterruptedException {
		homepage.popup(driver);
		Thread.sleep(1000);
		homepage.getRide().click();

	}

}







