package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import base.BaseClass;
import utility.LoggerLoad;

public class GraphPage extends BaseClass {

	By dropDown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By Graph = By.xpath("//div[@class='nav-item dropdown show']//div//a[6]");
	By Topic = By.xpath("//body/div/ul['+i+']/a[@class='list-group-item']");
	By tryHere = By.xpath("//a[contains (text(), 'Try here')]");
	By textInput = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run = By.xpath("//button[@type='button']");
	By topicGraph = By.xpath("//a[@href='graph']");
	By PracticeQue = By.xpath("//a[text()='Practice Questions']");

	public void clickGraph() throws IOException, InterruptedException {

		driver.findElement(dropDown).click();
		driver.findElement(Graph).click();
		LoggerLoad.info(" user is on graph page");
	}

	public void AccessGraph(String phythonCode) throws IOException, InterruptedException {

		// int size= driver.findElements(Topic).size();

		for (int j = 2; j <= 3; j++) {

			By Topic = By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");

			driver.findElement(Topic).click();
			driver.findElement(tryHere).click();
			driver.findElement(textInput).sendKeys(phythonCode);
			driver.findElement(Run).click();

			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
			}
			driver.navigate().back();
			driver.navigate().back();
		}
	}

	public void practiceQ() {
		driver.findElement(topicGraph).click();
		driver.findElement(PracticeQue).click();

	}

}
