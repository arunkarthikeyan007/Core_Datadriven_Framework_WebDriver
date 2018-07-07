package com.testproject.suiteC;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testproject.suiteC.TestSuiteBase;
import com.testproject.util.TestUtil;

public class Testcase_C1 extends TestSuiteBase{
	String testExecutionStatus = "Pass";
	
	@BeforeTest
	public void checkTestSkip() throws IOException
	{
		Applog.debug("Checking Run mode -->| Suite C | "+this.getClass().getSimpleName()+" | ........");
		
		if(!TestUtil.isRunnable(xls, "Testcases", this.getClass().getSimpleName()))
		{
			Applog.debug("Skipping--->| Suite C | "+this.getClass().getSimpleName()+" | ........");
			throw new SkipException("Run mode is NO |  "+this.getClass().getSimpleName()+" | ........");
		}
	}
		
	@Test
	public void testcase_C1()
	{
		Applog.debug("Executing "+this.getClass().getSimpleName()+" | ........");
		
		System.out.println("Testcase No C1");
	}
	
	@AfterTest
	public void testcasereporter(){		
		int i = TestUtil.getrownum(xls,"Testcases",this.getClass().getSimpleName());
		TestUtil.reportDataSetResult(xls,"Testcases",i,testExecutionStatus);
		
	}
	}
