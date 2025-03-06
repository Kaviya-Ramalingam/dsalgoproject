package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utility.LoggerLoad;

public class TreePage extends BaseClass {

	By dropDown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By tree = By.xpath("//div[@class='nav-item dropdown show']//div//a[5]");
	By topic = By.xpath("//body/div/ul['+i+']/a[@class='list-group-item']");
	By tryHere = By.xpath("//a[contains (text(), 'Try here')]");
	By textInput = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By Run = By.xpath("//button[@type='button']");
	By OverviewTree = By.xpath("//a[text()='Overview of Trees']");
	By PracticeQues = By.xpath("//a[text()='Practice Questions']");


	public void clickTree() throws IOException, InterruptedException {

		getDriver().findElement(dropDown).click();
		getDriver().findElement(tree).click();
		LoggerLoad.info("user is on tree page");
	}

	public void Tree(String phythonCode) throws IOException, InterruptedException {

		int size = getDriver().findElements(topic).size();

		for (int j = 1; j <= size; j++) {

			By Topic = By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");

			getDriver().findElement(Topic).click();
			getDriver().findElement(tryHere).click();
			getDriver().findElement(textInput).sendKeys(phythonCode);
			getDriver().findElement(Run).click();
			try {
				getDriver().switchTo().alert().accept();
			} catch (Exception e) {

			}

			getDriver().navigate().back();
			getDriver().navigate().back();

		}
	}

	public void PracticeQ() {
		getDriver().findElement(OverviewTree).click();
		getDriver().findElement(PracticeQues).click();

	}
}
