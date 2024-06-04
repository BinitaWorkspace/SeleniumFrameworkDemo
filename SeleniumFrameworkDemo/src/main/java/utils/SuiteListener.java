//THis class is meant to act based on the Test execution status

package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

	public void onTestFailure(ITestResult result) {
		Date currentdate = new Date();
		String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File ssFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		System.out.println(screenshotFilename);
		try {
			FileUtils.copyFile(ssFile, new File(".//screenshots//" + screenshotFilename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Successful");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped");
		Date currentdate = new Date();
		String skippedssFilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File sssFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		System.out.println(skippedssFilename);
		try {
			FileUtils.copyFile(sssFile, new File(".//screenshots//" + skippedssFilename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Completed");
	}

}