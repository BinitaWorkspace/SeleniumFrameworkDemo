//This Class is created for the purpose of retrying the execution of the failed testcases

package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//This Class is created for the purpose of retrying the execution of the failed testcases
public class RetryAnalyzer implements IRetryAnalyzer {
	int count = 0;
	int retryCount = 1;

	public boolean retry(ITestResult result) {
		while (count < retryCount) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
