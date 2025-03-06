package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utility.LoggerLoad;

public class Retry implements IRetryAnalyzer {
	    private int count = 0;
	    private static final int maxTry = 1;

	
		@Override
		public boolean retry(ITestResult result) {
			 if (count < maxTry) {
				LoggerLoad.info ("Retrying test " + result.getName () + " with status " + getResultStatusName (
		                   result.getStatus ()) + " for the " + (this.count + 1) + " time(s).");
		            count++;
		            return true;
		        }
			return false;
		}
		
		public String getResultStatusName (final int status) {
		       String resultName = null;
		       if (status == 1) {
		           resultName = "SUCCESS";
		       }
		       if (status == 2) {
		           resultName = "FAILURE";
		       }
		       if (status == 3) {
		           resultName = "SKIP";
		       }
		       return resultName;
		   }
	}


