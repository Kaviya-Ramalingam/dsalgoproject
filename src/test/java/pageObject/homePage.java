package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import base.BaseClass;
import utility.LoggerLoad;
import utility.Screenshot;

public class homePage extends BaseClass {
	
	
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
By dropDownarray = By.xpath("//div[@class='dropdown-menu show']/a[1]");
By dropdownLL=By.xpath("//div[@class='dropdown-menu show']/a[2]");
By dropdownstack=By.xpath("//div[@class='dropdown-menu show']/a[3]");
By dropdownqueue=By.xpath("//div[@class='dropdown-menu show']/a[4]");
By dropdowntree=By.xpath("//div[@class='dropdown-menu show']/a[5]");
By dropdowngraph=By.xpath("//div[@class='dropdown-menu show']/a[6]");
By signIn = By.xpath("//a[@href='/login']") ;
By register = By.xpath("//a[@href='/register']");


	
	public void getStartedhome(String string) {
	 
		switch (string) {
		
		case "Data Structures-Introduction":
			
			driver.findElement(getStartedDs).click();
			LoggerLoad.info("clicking getStarted DataStructures ");
			break;
			
		case "Arrays":
			
			driver.findElement(getStartedArray).click();
			LoggerLoad.info("clicking getStarted array button");
			break;
			
		case "Linked List":
		
			 driver.findElement(getStartedlinkedList).click();
			 LoggerLoad.info("clicking getStarted linkedlist");
			 break;
			
		case "Stack":
			 
			 driver.findElement(getStartedStack).click();
			 LoggerLoad.info("clicking getStarted stack");
			 break;
			
		case "Queue":

			 driver.findElement(getStartedQueue).click();
			 LoggerLoad.info("clicking getStarted queue");
			 break;
			
		case "Tree":
		
			 driver.findElement(getStartedTree).click();
			 LoggerLoad.info("clicking getStarted tree");
			 break;
			
		case "Graph":
			
			 driver.findElement(getStartedGraph).click();
			 LoggerLoad.info("clicking getStarted graph");
			 break;
		}

}

public void dropdown(String string1) {

	driver.findElement(dropDown).click();
	
	switch (string1) {
	
	case "Arrays":
		
		driver.findElement(dropDownarray).click();
		LoggerLoad.info("User click on " + string1);
		break;
		
	case "Linked List":
		LoggerLoad.info("User click on " + string1);
		driver.findElement(dropdownLL).click();
		break;
		
	case "Stack":
		LoggerLoad.info("User click on " + string1);
		driver.findElement(dropdownstack).click();
		break;
		
	case "Queue":
		LoggerLoad.info("User click on " + string1);
		driver.findElement(dropdownqueue).click();
		break;
		
	case "Tree":
		LoggerLoad.info("User click on " + string1);
		driver.findElement(dropdowntree).click();
		break;
		
	case "Graph":
		LoggerLoad.info("User click on " + string1);
		driver.findElement(dropdowngraph).click();
		break;
		
	}
}

		public String displayErrorMsg() throws IOException {
			String text = driver.findElement(errorMessage).getText();
            Screenshot.takeScreenshot("Capture error message");
            LoggerLoad.info("The error message is" +text);
			return text;
		}
		
	    public String displayalertMsg() throws IOException {
		    String text1=driver.findElement(errorMessage).getText();
		    Screenshot.takeScreenshot("Capture alert message");
		    LoggerLoad.info("The alert message is "+ text1);
		    return text1;
		}	
		
		public void signIn() throws InterruptedException {
			
			driver.findElement(signIn).click();
	    }
		public void register() throws InterruptedException {
			
			driver.findElement(register).click();
		}
}

	