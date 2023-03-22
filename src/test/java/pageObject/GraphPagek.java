package pageObject;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.ExcelReader;

public class GraphPagek extends BaseClass {
	
	By dropDown=By.xpath("//a[@class='nav-link dropdown-toggle']");
	By Graph = By.xpath("//div[@class='nav-item dropdown show']//div//a[6]");
    By topicGraph =By.xpath("//a[@href='graph']");
    By topicGraphRep =By.xpath("//a[@href='graph-representations']");
	By tryHere= By.xpath("//a[contains (text(), 'Try here')]");
	By textInput= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run= By.xpath("//button[@type='button']");
	By Result= By.xpath("//pre[@id='output']");
	
	By PracticeQ1 = By.xpath("//a[text()='Practice Questions']");
	
	public void clickGraph() throws IOException, InterruptedException {
	
	driver.findElement(dropDown).click();	
	driver.findElement(Graph).click();
	}
	
	//@Test(dataProvider = "codedata")

	public Void selectGraph (String phythonCode) throws IOException, InterruptedException {
	Thread.sleep(1000);
	driver.findElement(topicGraph).click();
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
	
	return null;
	
	}
	
	//@Test(dataProvider = "codedata")
	public void selectGraphRepresentation(String phythonCode) throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(topicGraphRep).click();
		driver.findElement(tryHere).click();
		Thread.sleep(1000);
		WebElement entercode1 = driver.findElement(textInput);
		entercode1.sendKeys(phythonCode);
		System.out.println("sendkeys");
		System.out.println(entercode1.getText());
		driver.findElement(Run).click();
		try {
			driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			
		}
		driver.navigate().back();
}
	
	public void practiceQ()
	{
		driver.findElement(PracticeQ1).click();
		
	}
	
	}


