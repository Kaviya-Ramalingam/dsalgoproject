package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.LoggerLoad;

public class GetStarted extends BaseClass {
	
	
	By getStarted = By.xpath ("//button[@class='btn']");
	

 public void getstarted() {
	
		driver.findElement(getStarted).click();
		LoggerLoad.info("clicking get started page");
		
		
		
		
	}

}
