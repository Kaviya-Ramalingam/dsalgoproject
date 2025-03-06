package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

		getDriver().findElement(dropdown).click();
		getDriver().findElement(Stack).click();
		LoggerLoad.info("user is on  stack page");
	}

	public void AccessStack(String phythonCode) {

		int size = getDriver().findElements(Topic).size();
		for (int j = 1; j <= size; j++) {

			By Topic = By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");

			getDriver().findElement(Topic).click();
			getDriver().findElement(tryHere).click();
			getDriver().findElement(textInput).sendKeys(phythonCode);
			getDriver().findElement(Run).click();

			try {
				getDriver().switchTo().alert().accept();
			}

			catch (Exception e) {

			}
			getDriver().navigate().back();
			getDriver().navigate().back();
		}
	}

	public void PracticeQues() {

		getDriver().findElement(topicStack).click();
		getDriver().findElement(PracticeQue).click();
	}
}
