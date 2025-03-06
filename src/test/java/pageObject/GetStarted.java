package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utility.LoggerLoad;

public class GetStarted extends BaseClass {

	By getStarted = By.xpath("//button[@class='btn']");
	
	/*WebDriver driver;
	
	public GetStarted() {
	        this.driver = thdriver.get();
	    }*/
	

	public void getstarted() {
		WebDriver driver = thdriver.get();

		driver.findElement(getStarted).click();
		LoggerLoad.info("clicking get started page");

	}

}
