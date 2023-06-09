package pageObject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

		driver.findElement(registerBtn).click();
		LoggerLoad.info("user is on Registerpage");

	}

	public String verifyUserWarnMsg() throws IOException, InterruptedException {

		WebElement userwarnmsg = driver.findElement(username);
		String wmes1 = (userwarnmsg.getAttribute("validationMessage"));
		Thread.sleep(2000);
		Screenshot.takeScreenshot("captureError1");
		LoggerLoad.info("user warning message:" + wmes1);
		return wmes1;

	}

	public String verifyPassWarnMsg() throws IOException {

		LoggerLoad.info("verifying the warn message");
		driver.findElement(username).sendKeys(props.getProperty("userName"));
		driver.findElement(registerBtn).click();
		WebElement passwarnmsg = driver.findElement(password);
		Screenshot.takeScreenshot("captureError2");
		String wmes2 = passwarnmsg.getAttribute("validationMessage");
		return wmes2;
	}

	public String verifyConPassWarnMsg() throws IOException {

		LoggerLoad.info("verify the warn message");
		driver.findElement(password).sendKeys(props.getProperty("passWord"));
		driver.findElement(registerBtn).click();
		WebElement confirmpasswarnmsg = driver.findElement(confirmPassword);
		Screenshot.takeScreenshot("captureError3");
		String wmes3 = confirmpasswarnmsg.getAttribute("validationMessage");
		return wmes3;
	}

	public void Register() throws InterruptedException {

		WebElement usrname = driver.findElement(username);
		usrname.clear();
		usrname.sendKeys(props.getProperty("userName"));
		WebElement pswd = driver.findElement(password);
		pswd.clear();
		pswd.sendKeys(props.getProperty("passWord"));
		driver.findElement(confirmPassword).sendKeys(props.getProperty("passWord"));
		driver.findElement(registerBtn).click();
		WebElement Msg = driver.findElement(accountcreatedMesg);
		driver.findElement(signout).click();
	}
}