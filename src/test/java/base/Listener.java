package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.LoggerLoad;
import utility.Screenshot;

public class Listener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		LoggerLoad.info("Test failed - screenshot captured" + result.getMethod().getMethodName());
		try {
			Screenshot.takeScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
