package pageObject;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import utility.LoggerLoad;
import utility.Screenshot;

public class RegisterPage extends BaseClass{
	
	
	By registerBtn=By.xpath("//input[@type='submit']");
    By username=By.xpath("//input[@id='id_username']");
    By password=By.xpath("//input[@id='id_password1']");
    By confirmPassword=By.xpath("//input[@id='id_password2']");
    By accountcreatedMesg=By.xpath("//div[@class='alert alert-primary']");
    //By signOut = By.xpath("//a[@href='/logout']");
    By signout= By.xpath("//a[text()='Sign out']");

public void clickRegister() throws InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(registerBtn).click();
	
}
public String verifyUserWarnMsg() throws IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement userwarnmsg = driver.findElement(username);
	String wmes1=(userwarnmsg.getAttribute("validationMessage"));
	Thread.sleep(2000);
	Screenshot.takeScreenshot("captureError1");
	System.out.println(wmes1);
	return wmes1;

}
public String verifyPassWarnMsg() throws IOException {
	
	LoggerLoad.info("verifying the warn message");
	driver.findElement(username).sendKeys(props.getProperty("userName"));
	driver.findElement(registerBtn).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement passwarnmsg = driver.findElement(password);
	Screenshot.takeScreenshot("captureError2");
	String wmes2=passwarnmsg.getAttribute("validationMessage");
	return wmes2;
}
public String verifyConPassWarnMsg() throws IOException {
	LoggerLoad.info("verify the warn message");
	driver.findElement(password).sendKeys(props.getProperty("passWord"));
	driver.findElement(registerBtn).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement confirmpasswarnmsg = driver.findElement(confirmPassword);
	Screenshot.takeScreenshot("captureError3");
	String wmes3=confirmpasswarnmsg.getAttribute("validationMessage");
	return wmes3;
}
public void Register() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement usrname=driver.findElement(username);
	usrname.clear();
	usrname.sendKeys(props.getProperty("userName"));
	WebElement pswd=driver.findElement(password);
	pswd.clear();
	pswd.sendKeys(props.getProperty("passWord"));
	driver.findElement(confirmPassword).sendKeys(props.getProperty("passWord"));
	driver.findElement(registerBtn).click();
	WebElement Mesg=driver.findElement(accountcreatedMesg);
	driver.findElement(signout).click();
}
}