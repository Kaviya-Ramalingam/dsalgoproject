package pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseClass;

public class SigninPage extends BaseClass{
	
	By login = By.xpath("//input[@type='submit']");
	By username=By.xpath("//input[@id='id_username']");
	By password=By.xpath("//input[@id='id_password']");
	By logintitle = By.xpath("//div[@class='alert alert-primary']");
	By signIn = By.xpath("//a[@href='/login']");
	
	

	public void login(String user, String pswd, String exp) throws InterruptedException {
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getDriver().findElement(signIn).click();
		getDriver().findElement(username).sendKeys(user);
		getDriver().findElement(password).sendKeys(pswd);
		getDriver().findElement(login).click();
		
		String expTitle= "You are logged in";
	    WebElement verifyTitle=	getDriver().findElement(logintitle);
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
	

