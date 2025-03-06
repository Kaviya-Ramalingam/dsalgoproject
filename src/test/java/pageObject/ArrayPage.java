package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utility.LoggerLoad;

public class ArrayPage extends BaseClass {
	
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By array = By.xpath("//div[@class='nav-item dropdown show']//div//a[1]");
	By arraypython = By.xpath("//a[text()='Arrays in Python']");
	By Topic = By.xpath("//body/div/ul['+i+']/a[@class='list-group-item']");
	By tryHere = By.xpath("//a[contains (text(), 'Try here')]");
	By textInput = By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	By practiceQ = By.xpath("//a[text()='Practice Questions']");
	By searcharray = By.xpath("//a[text()='Search the array']");
	By maxCons = By.xpath("//a[text()='Max Consecutive Ones']");
	By findno = By.xpath("//a[text()='Find Numbers with Even Number of Digits']");
	By square = By.xpath("//a[text()='Squares of  a Sorted Array']");
	By PQTopics = By.xpath("//body//div[@class='list-group'][' +j+']");
	By Run = By.xpath("//button[@type='button']");
	
	

	public void dropdown() {
		
		getDriver().findElement(dropdown).click();
		getDriver().findElement(array).click();
		LoggerLoad.info("user is on Array page");
	}

	public void performarray(String phythonCode) throws IOException {

		int size = getDriver().findElements(Topic).size();
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

	public void practiceQarray(String Code) throws IOException {
		getDriver().findElement(arraypython).click();
		getDriver().findElement(practiceQ).click();

		int size = getDriver().findElements(PQTopics).size();

		for (int j = 1; j <= size; j++) {
			By TopicS = By.xpath("//body//div[@class='list-group'][" + j + "]");
			getDriver().findElement(TopicS).click();
			getDriver().findElement(textInput).sendKeys(Keys.DELETE);
			getDriver().findElement(textInput).sendKeys(Code);
			getDriver().findElement(Run).click();

			try {
				getDriver().switchTo().alert().accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			getDriver().navigate().back();
		}
		getDriver().navigate().back();

	}

}
