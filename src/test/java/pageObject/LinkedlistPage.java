package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;

public class LinkedlistPage extends BaseClass{

	By dropDown=By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkedList = By.xpath("//div[@class='nav-item dropdown show']//div//a[2]");
	//By LLgetstarted=By.xpath("//div[@class='row row-cols-1 row-cols-md-3 g-4']/div[3]/div/div/a");
	By Topic= By.xpath("//body/div/ul['+j+']/a[@class='list-group-item']");
	By PracticeQues = By.xpath("//a[text()='Practice Questions']");
	By tryHere= By.xpath("//a[contains (text(), 'Try here')]");
	By textInput= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run= By.xpath("//button[@type='button']");
	By Linkedlisttopic =By.xpath("//a[text()='Introduction']");
	
	
	public void clickLinkedlist() throws IOException {
		driver.findElement(dropDown).click();
		driver.findElement(linkedList).click();
	}
		
	public void AccessLinkedlist(String phythonCode) {	
		
		int size= driver.findElements(Topic).size();
		for( int j=1;j<=size;j++) {

			By Topic= By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");
			driver.findElement(Topic).click();

				driver.findElement(tryHere).click();
				driver.findElement(textInput).sendKeys(phythonCode);
				driver.findElement(Run).click();


				try {
					driver.switchTo().alert().accept();
				}

				catch (Exception e) {
					
				}
				driver.navigate().back();
			
			driver.navigate().back(); 	  	
		}

	}
	public void PracticeQ() {
		
		driver.findElement(Linkedlisttopic).click();
		driver.findElement(PracticeQues).click();
	}
}


