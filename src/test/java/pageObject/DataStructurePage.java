package pageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.DPclass;

public class DataStructurePage extends BaseClass{
	By getStartedDs= By.xpath("//a[@href='data-structures-introduction']");
	//By DSgetstarted = By.xpath("//div[@class='row row-cols-1 row-cols-md-3 g-4']/div[1]/div/div/a");
	By DStimecomplex = By.xpath("//a[@href='time-complexity']");
	By PracticeQues = By.xpath("//a[text()='Practice Questions']");
	By tryHere= By.xpath("//a[contains (text(), 'Try here')]");
	By textInput= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run= By.xpath("//button[@type='button']");
	
	public void clickdatastructure() throws Exception
	{
		driver.findElement(getStartedDs).click();
		 //driver.findElement(DStimecomplex).click();
			//driver.findElement(tryHere).click();
		
	}
	//@Test(dataProvider= "codedata",dataProviderClass = DPclass.class)
	/*public void AccessDS(String phythonCode) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(getStartedDs).click();
		   driver.findElement(DStimecomplex).click();
		   
			driver.findElement(tryHere).click();
		
			driver.findElement(textInput).sendKeys(phythonCode);
			driver.findElement(Run).click();

			try {
				driver.switchTo().alert().accept();
			}
			catch(Exception e){
				//e.printStackTrace();
			}
			driver.navigate().back();

			driver.navigate().back();*/
	
			public Void AccessDS (String phythonCode) throws IOException, InterruptedException {
				Thread.sleep(1000);
				driver.findElement(DStimecomplex).click();
				driver.findElement(tryHere).click();
				Thread.sleep(1000);
				WebElement entercode = driver.findElement(textInput);
				entercode.sendKeys(phythonCode);
				System.out.println("test"+entercode.getText());
				driver.findElement(Run).click();
				try {
					driver.switchTo().alert().accept();
				}
				catch(Exception e) {
					
				}
				driver.navigate().back();
				driver.navigate().back();
				driver.navigate().back();
				return null;
				
				}
	
	
	
	public void PracticeQ() {
		//driver.findElement(DSgetstarted).click();
		driver.findElement(DStimecomplex).click();
		driver.findElement(PracticeQues).click();
	}

}


