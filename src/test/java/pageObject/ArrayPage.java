package pageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BaseClass;
import utility.ExcelReader;
import utility.LoggerLoad;

public class ArrayPage extends BaseClass{
	By dropdown= By.xpath("//a[@class='nav-link dropdown-toggle']");
	By array=By.xpath("//div[@class='nav-item dropdown show']//div//a[1]");
        By arraypython= By.xpath("//a[text()='Arrays in Python']");
	By Topic= By.xpath("//body/div/ul['+i+']/a[@class='list-group-item']");
	By tryHere= By.xpath("//a[contains (text(), 'Try here')]");
	By textInput= By.xpath("//form[@id='answer_form']/div/div/div[1]/textarea");
	//By arrayusinglist= By.xpath("//a[text()='Arrays Using List']");
	//By basicoperationlist= By.xpath("//a[text()='Basic Operations in Lists']");
	//By applicationArray= By.xpath("//a[text()='Applications of Array']");
        By practiceQ= By.xpath("//a[text()='Practice Questions']");
	By searcharray=By.xpath("//a[text()='Search the array']");
	By maxCons= By.xpath("//a[text()='Max Consecutive Ones']");
	By findno=By.xpath("//a[text()='Find Numbers with Even Number of Digits']");
	By square=By.xpath("//a[text()='Squares of  a Sorted Array']");
	By TopicS=By.xpath("//body/div/ul/a[@class='list-group-item']");
	By Run= By.xpath("//button[@type='button']");
	public void dropdown()
	{
		driver.findElement(dropdown).click();
		driver.findElement(array).click();
		LoggerLoad.info("user is on Array page");
	}
	
	public void performarray (String phythonCode ) throws IOException
	{
		int size= driver.findElements(Topic).size();
	
		for(int j=1; j<=size;j++)
		{
			By Topic= By.xpath("//body/div/ul[" + j + "]/a[@class='list-group-item']");
			
			driver.findElement(Topic).click();
			driver.findElement(tryHere).click();
			driver.findElement(textInput).sendKeys(phythonCode);
			driver.findElement(Run).click();
	
				try {
					driver.switchTo().alert().accept();
				}
				catch(Exception e){
					
				}
	
			driver.navigate().back();
			driver.navigate().back();
		}
		
	}
	
	public void practiceQarray (String Code) throws IOException
	{
		driver.findElement(arraypython).click();
		System.out.println("after arryinpyton");
		driver.findElement(practiceQ).click();
		System.out.println("practisequestion");
		///driver.findElement(searcharray).click();
		///System.out.println("searcharray");
		
		int size= driver.findElements(Topic).size();
		System.out.println(size);
		
		
	
		for(int j=1; j<=size;j++)
		{
			By Topic = By.xpath("//body//div[@class='list-group'][" +j+"]");
			driver.findElement(TopicS).click();
		    driver.findElement(textInput).sendKeys(Keys.DELETE);
				
			driver.findElement(textInput).sendKeys(Code);
				driver.findElement(Run).click();
				System.out.println("after code0");
				try {
					driver.switchTo().alert().accept();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				driver.navigate().back();
				}
				//driver.findElement(searcharray).click();
				//driver.findElement(Topic).click();
	}
	}
	
				
			/*	for(int i=0;i<=28;i++)
				{
					driver.findElement(input).sendKeys(Keys.DELETE);
		
				}
				
				
				driver.findElement(input).sendKeys(code[1]);
				System.out.println("after input");
				driver.findElement(run).click();
				System.out.println("after code1");
				try {
					driver.switchTo().alert().accept();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				driver.navigate().back();
		}	*/
//	}
		
	
	
