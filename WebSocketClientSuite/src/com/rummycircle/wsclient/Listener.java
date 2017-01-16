package com.rummycircle.wsclient;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onFinish(ITestContext Result) {

	}

	@Override
	public void onStart(ITestContext Result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {

	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult Result) {

	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult Result) {
			
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult Result) {
		
	}
}