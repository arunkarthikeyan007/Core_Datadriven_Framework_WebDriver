package com.testproject.suiteB;

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
		Applog.debug("Checking Run mode of Suite B ........");
		
		if(!TestUtil.isRunnable(xls, "Testsuites", "Testsuite_B"))
		{
			Applog.debug("Skip Suite B");
			throw new SkipException("|Run mode is NO |Skipping TestSuite B|");
		}
		Applog.debug("Running Suite B........");
		xls = xlsObjectIntialize("Testsuite_B");
	}
}
