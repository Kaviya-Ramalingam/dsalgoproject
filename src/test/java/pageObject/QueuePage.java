package pageObject;

import org.openqa.selenium.By;
import base.BaseClass;
import utility.LoggerLoad;

public class QueuePage extends BaseClass {
	
	By dropdown= By.xpath("//a[@class='nav-link dropdown-toggle']");
	By queue=By.xpath("//div[@class='nav-item dropdown show']//div//a[4]");
	By queuephython= By.xpath("//a[text()='Implementation of Queue in Python']");
	By queuecollection= By.xpath("//a[text()='Implementation using collections.deque']");
	By queueArray= By.xpath("//a[text()='Implementation using array']");
	By queueOp= By.xpath("//a[text()='Queue Operations']");
	By tryHere= By.xpath("//a[text()='Try here>>>']");
	By inputText= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run= By.xpath("//button[@type='button']");
	By practiceQ= By.xpath("//a[text()='Practice Questions']");
	By Topics=By.xpath("//body/div/ul/a[@class='list-group-item']");
	
	public void clickQue(){
	
		driver.findElement(dropdown).click();
		driver.findElement(queue).click();
		LoggerLoad.info("Queue is selected");
	}

	public void AccessQueue(String phythonCode) {

		int size= driver.findElements(Topics).size();
		for(int j=1; j<=size;j++)
		{
			By Topic= By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");
			driver.findElement(Topic).click();
			driver.findElement(tryHere).click();
			driver.findElement(inputText).sendKeys(phythonCode);
			driver.findElement(Run).click();

			try {
				driver.switchTo().alert().accept();
			}
			catch(Exception e){
				//e.printStackTrace();
			}

			driver.navigate().back();
		    driver.navigate().back();
		}

	}
	
	public void practiceQ()
	{
		driver.findElement(queuephython).click();
		driver.findElement(practiceQ).click();
	}

}


