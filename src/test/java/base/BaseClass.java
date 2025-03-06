package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import utility.LoggerLoad;

public class BaseClass {

	//public static WebDriver driver;
	public static Properties props;
	public static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();
	public void setupApplication() throws IOException

	{
		props = new Properties();
		String filePath = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/config.properties";
		FileInputStream inputstream = new FileInputStream(filePath);
		props.load(inputstream);
		getDriver().manage().window().maximize();
		getDriver().get((String) props.get("url"));

	}

	public void crossBrowser(String browsername) {
		

		if (browsername.equalsIgnoreCase("chrome")) {
			LoggerLoad.info("Testing on chrome");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			
			co.addArguments("--headless");
			thdriver.set (new ChromeDriver(co));
		} else if (browsername.equalsIgnoreCase("safari")) {
			LoggerLoad.info("Testing on safari");
			thdriver.set(new SafariDriver());
		} else if (browsername.equalsIgnoreCase("firefox")) {
		    FirefoxOptions options = new FirefoxOptions();
		    options.addArguments("--headless");
			LoggerLoad.info("Testing on firefox");
			thdriver.set(new FirefoxDriver(options));
		} else {
			throw new IllegalArgumentException("Invalid browser value!!");
		}
	}
	
	public WebDriver getDriver() {
		return thdriver.get();
		
	}
}
