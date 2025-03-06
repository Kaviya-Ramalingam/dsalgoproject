package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import utility.LoggerLoad;
import utility.Screenshot;

public class RegisterPage extends BaseClass {

	By registerBtn = By.xpath("//input[@type='submit']");
	By username = By.xpath("//input[@id='id_username']");
	By password = By.xpath("//input[@id='id_password1']");
	By confirmPassword = By.xpath("//input[@id='id_password2']");
	By accountcreatedMesg = By.xpath("//div[@class='alert alert-primary']");
	By signout = By.xpath("//a[text()='Sign out']");


	public void clickRegister() throws InterruptedException {

		getDriver().findElement(registerBtn).click();
		LoggerLoad.info("user is on Registerpage");

	}

	public String verifyUserWarnMsg() throws IOException, InterruptedException {

		WebElement userwarnmsg = getDriver().findElement(username);
		String wmes1 = (userwarnmsg.getAttribute("validationMessage"));
		Thread.sleep(2000);
		Screenshot.takeScreenshot("captureError1");
		LoggerLoad.info("user warning message:" + wmes1);
		return wmes1;

	}

	public String verifyPassWarnMsg() throws IOException {

		LoggerLoad.info("verifying the warn message");
		getDriver().findElement(username).sendKeys(props.getProperty("userName"));
		getDriver().findElement(registerBtn).click();
		WebElement passwarnmsg = getDriver().findElement(password);
		Screenshot.takeScreenshot("captureError2");
		String wmes2 = passwarnmsg.getAttribute("validationMessage");
		return wmes2;
	}

	public String verifyConPassWarnMsg() throws IOException {

		LoggerLoad.info("verify the warn message");
		getDriver().findElement(password).sendKeys(props.getProperty("passWord"));
		getDriver().findElement(registerBtn).click();
		WebElement confirmpasswarnmsg = getDriver().findElement(confirmPassword);
		Screenshot.takeScreenshot("captureError3");
		String wmes3 = confirmpasswarnmsg.getAttribute("validationMessage");
		return wmes3;
	}

	public void Register() throws InterruptedException {

		WebElement usrname = getDriver().findElement(username);
		usrname.clear();
		usrname.sendKeys(props.getProperty("userName"));
		WebElement pswd = getDriver().findElement(password);
		pswd.clear();
		pswd.sendKeys(props.getProperty("passWord"));
		Thread.sleep(2000);
		getDriver().findElement(confirmPassword).sendKeys(props.getProperty("passWord"));
		getDriver().findElement(registerBtn).click();
		WebElement Msg = getDriver().findElement(accountcreatedMesg);
		Assert.assertEquals(true,"New account created");
		Thread.sleep(2000);
		getDriver().findElement(signout).click();
		//Assert.assertEquals(true,"New account created");
	}
}