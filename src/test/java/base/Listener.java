package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.LoggerLoad;
import utility.Screenshot;

public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		LoggerLoad.info("Test failed - screenshot captured" + result.getMethod().getMethodName());
		try {
			Screenshot.takeScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("Method skipped"+ result.getName());

	}
	@Override
	public void onTestStart(ITestResult result) {
	System.out.println("Method started"+ result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("Method passed"+ result.getName());

	}
}
