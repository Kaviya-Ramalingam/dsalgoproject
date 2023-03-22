package pageObject;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.ExcelReader;


public class SigninPage extends BaseClass{
	
	
	By login = By.xpath("//input[@type='submit']");
	By username=By.xpath("//input[@id='id_username']");
	By password=By.xpath("//input[@id='id_password']");
	By logintitle = By.xpath("//div[@class='alert alert-primary']");
	By signIn = By.xpath("//a[@href='/login']");
	
	
	@Test(dataProvider="Logindata")
	public void login(String user, String pswd, String exp) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(signIn).click();
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(login).click();
		
		String expTitle= "You are logged in";
	    WebElement verifyTitle=	driver.findElement(logintitle);
		String actualTitle= verifyTitle.getText();
		
		if(exp.equals("valid"))
		{
			if(expTitle.equals(actualTitle))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}

		else if (exp.equals("invalid"))
		{
			if(expTitle.equals(actualTitle))
			{
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	
	}
	

