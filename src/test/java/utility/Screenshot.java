package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Screenshot extends BaseClass {
	
	public static void takeScreenshot(String stepName) throws IOException {
		
         TakesScreenshot screenshot= (TakesScreenshot)driver;
         File src =screenshot.getScreenshotAs(OutputType.FILE);
         String dir= System.getProperty("user.dir");
         String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
         File target = new File(dir+"/src/test/resources/screenshots/"+stepName+"_"+timestamp+".jpeg");
         FileUtils.copyFile(src,target);
        
         

}
	

}

