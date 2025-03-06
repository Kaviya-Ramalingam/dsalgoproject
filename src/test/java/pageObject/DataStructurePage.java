package pageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utility.LoggerLoad;

public class DataStructurePage extends BaseClass{
	
	By getStartedDs= By.xpath("//a[@href='data-structures-introduction']");
	By DStimecomplex = By.xpath("//a[@href='time-complexity']");
	By PracticeQues = By.xpath("//a[text()='Practice Questions']");
	By tryHere= By.xpath("//a[contains (text(), 'Try here')]");
	By textInput= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run= By.xpath("//button[@type='button']");
	
	

	public void clickdatastructure() throws Exception
	{
		getDriver().findElement(getStartedDs).click();
		LoggerLoad.info("user is on datastructure page");	 
	}
	
	public void AccessDS (String phythonCode) throws IOException, InterruptedException {
				
				getDriver().findElement(DStimecomplex).click();
				getDriver().findElement(tryHere).click();
				Thread.sleep(2000);
				getDriver().findElement(textInput).sendKeys(phythonCode);
				getDriver().findElement(Run).click();
				try {
					getDriver().switchTo().alert().accept();
				}
				catch(Exception e) {
					
				}
				getDriver().navigate().back();
				getDriver().navigate().back();
				getDriver().navigate().back();
				return  ;
				
				}
	
	public void PracticeQ() {
		
		getDriver().findElement(DStimecomplex).click();
		getDriver().findElement(PracticeQues).click();
	}

}


