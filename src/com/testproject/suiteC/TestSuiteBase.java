package com.testproject.suiteC;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.testproject.base.TestBase;
import com.testproject.util.TestUtil;

public class TestSuiteBase extends TestBase{
	@BeforeSuite
	public void checkSuiteSkip() throws IOException	
	{	
		intialize();
		xls = xlsObjectIntialize("Testsuites");
		Applog.debug("Checking Run mode of Suite C ........");
		
		if(!TestUtil.isRunnable(xls, "Testsuites", "Testsuite_C"))
		{
			Applog.debug("Skip Suite C");
			throw new SkipException("|Run mode is NO |Skipping TestSuite C|");
		}
		Applog.debug("Running Suite C........");
		xls = xlsObjectIntialize("Testsuite_C");
	}
}
