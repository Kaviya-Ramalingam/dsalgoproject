package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
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
		driver.findElement(getStartedDs).click();
		LoggerLoad.info("user is on datastructure page");	 
	}
	
	public void AccessDS (String phythonCode) throws IOException, InterruptedException {
				
				driver.findElement(DStimecomplex).click();
				driver.findElement(tryHere).click();
				driver.findElement(textInput).sendKeys(phythonCode);
				driver.findElement(Run).click();
				try {
					driver.switchTo().alert().accept();
				}
				catch(Exception e) {
					
				}
				driver.navigate().back();
				driver.navigate().back();
				driver.navigate().back();
				return  ;
				
				}
	
	public void PracticeQ() {
		
		driver.findElement(DStimecomplex).click();
		driver.findElement(PracticeQues).click();
	}

}


