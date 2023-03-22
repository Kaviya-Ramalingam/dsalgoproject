package pageObject;

import java.io.IOException;
import java.util.logging.ConsoleHandler;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.LoggerLoad;
import utility.Screenshot;

public class homePage extends BaseClass {
	//WebDriver driver;
	
By getStartedDs= By.xpath("//a[@href='data-structures-introduction']");
By getStartedArray=By.xpath("//a[@href ='array']");
By getStartedlinkedList=By.xpath("//a[@href ='linked-list']");
By getStartedStack=By.xpath("//a[@href ='stack']");
By getStartedTree=By.xpath("//a[@href ='tree']");
By getStartedGraph=By.xpath("//a[@href ='graph']");
By getStartedQueue=By.xpath("//a[@href ='queue']");
By errorMessage = By.xpath("//div[contains(text(),'You are not logged in')]");
By getStarted = By.xpath ("//button[@class='btn']");
By dropDown=By.xpath("//a[@class='nav-link dropdown-toggle']");
By signIn = By.xpath("//a[@href='/login']") ;
By register = By.xpath("//a[@href='/register']");


//@Test
@Parameters({"string"})
	
	public void getStartedhome(String string) {
	 
		switch (string) {
		case "Data Structures-Introduction":
			
			WebElement clickbtn = driver.findElement(getStartedDs);
			LoggerLoad.info("click " + clickbtn.getText() + "link on  DataStructures ");
					clickbtn.click();
			break;
			
		case "Arrays":
			
			driver.findElement(getStartedArray).click();
			LoggerLoad.info("clicking getStarted array button");
			break;
			
		case "Linked List":
		
			 driver.findElement(getStartedlinkedList).click();
			break;
			
		case "Stack":
			driver.findElement(getStartedStack).click();
			break;
			
		case "Queue":

			driver.findElement(getStartedQueue).click();
			break;
			
		case "Tree":
		
			driver.findElement(getStartedTree).click();
			break;
			
		case "Graph":
			
			driver.findElement(getStartedGraph).click();
			break;
		}
}
		public String displayErrorMsg() throws IOException {
			WebElement ErrorMessage =driver.findElement(errorMessage);
			String text = ErrorMessage.getText();
            Screenshot.takeScreenshot("Capture error message");
			System.out.println(text);
			return text;
		}
		
		public void selectdropdown() throws InterruptedException, IOException
		{
			for(int i=1;i<=6;i++)
			{
				Thread.sleep(2000);
				driver.findElement(dropDown).click();
				driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[1]")).click();
				String text1=driver.findElement(errorMessage).getText();
				Screenshot.takeScreenshot("Capture alert message");
				System.out.println("The alert message is "+ text1);

			}
		}
		public void signIn() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(signIn).click();
	}
		public void register() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(register).click();
		}
}

	