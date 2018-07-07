package com.testproject.suiteA;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;


import com.testproject.base.TestBase;
import com.testproject.util.TestUtil;

public class TestSuiteBase extends TestBase {
	@BeforeSuite
	public void checkSuiteSkip() throws IOException	
	{	  
		intialize();
		xlsObjectIntialize("Testsuites");
		Applog.debug("Checking Run mode --->| Suite A |");
		
		if(!TestUtil.isRunnable(xls, "Testsuites", "Testsuite_A"))
		{
			Applog.debug("Skipping-->| Suite A|");
			throw new SkipException("Run mode is NO | Skipping TestSuite A |");
		}
		
		Applog.debug("Running Suite A........");
		
		xls = xlsObjectIntialize("Testsuite_A");
	}

}
