package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utility.LoggerLoad;

public class LinkedlistPage extends BaseClass {

	By dropDown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkedList = By.xpath("//div[@class='nav-item dropdown show']//div//a[2]");
	By Topic = By.xpath("//body/div/ul['+j+']/a[@class='list-group-item']");
	By PracticeQues = By.xpath("//a[text()='Practice Questions']");
	By tryHere = By.xpath("//a[contains (text(), 'Try here')]");
	By textInput = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run = By.xpath("//button[@type='button']");
	By Linkedlisttopic = By.xpath("//a[text()='Introduction']");

	
	public void clickLinkedlist() throws IOException {
		getDriver().findElement(dropDown).click();
		getDriver().findElement(linkedList).click();
		LoggerLoad.info("user is on linkedList page");
	}

	public void AccessLinkedlist(String phythonCode) {

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

	public void PracticeQ() {

		getDriver().findElement(Linkedlisttopic).click();
		getDriver().findElement(PracticeQues).click();
	}
}
