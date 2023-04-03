package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import base.BaseClass;
import utility.LoggerLoad;

public class StackPage extends BaseClass {
	By dropdown = By.xpath("//div[@class='nav-item dropdown']");
	By Stack = By.xpath("//div[@class='nav-item dropdown show']//div//a[3]");
	By Topic = By.xpath("//body/div/ul['+j+']/a[@class='list-group-item']");
	By tryHere = By.xpath("//a[contains (text(), 'Try here')]");
	By textInput = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run = By.xpath("//button[@type='button']");
	By topicStack = By.xpath("//a[@href='operations-in-stack']");
	By PracticeQue = By.xpath("//a[text()='Practice Questions']");

	public void clickStack() throws IOException {

		driver.findElement(dropdown).click();
		driver.findElement(Stack).click();
		LoggerLoad.info("user is on  stack page");
	}

	public void AccessStack(String phythonCode) {

		int size = driver.findElements(Topic).size();
		for (int j = 1; j <= size; j++) {

			By Topic = By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");

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

	public void PracticeQues() {

		driver.findElement(topicStack).click();
		driver.findElement(PracticeQue).click();
	}
}
