package pageObject;

import org.openqa.selenium.By;

import base.BaseClass;
import utility.LoggerLoad;

public class GetStarted extends BaseClass {

	By getStarted = By.xpath("//button[@class='btn']");

	public void getstarted() {

		driver.findElement(getStarted).click();
		LoggerLoad.info("clicking get started page");

	}

}
