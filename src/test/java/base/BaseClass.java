package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utility.LoggerLoad;

public class BaseClass {

	public static WebDriver driver;
	public static Properties props;

	public void setupApplication() throws IOException

	{
		props = new Properties();
		String filePath = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/config.properties";
		FileInputStream inputstream = new FileInputStream(filePath);
		props.load(inputstream);
		driver.manage().window().maximize();
		driver.get((String) props.get("url"));

	}

	public void crossBrowser(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			LoggerLoad.info("Testing on chrome");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		} else if (browsername.equalsIgnoreCase("safari")) {
			LoggerLoad.info("Testing on safari");
			driver = new SafariDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			LoggerLoad.info("Testing on firefox");
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser value!!");
		}
	}
}
