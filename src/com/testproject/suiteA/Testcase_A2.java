package com.testproject.suiteA;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testproject.util.TestUtil;

public class Testcase_A2 extends TestSuiteBase {
	String testExecutionStatus = "Pass";
	
	@BeforeTest
	public void checkTestSkip() throws IOException
	{	
		Applog.debug("Checking Run mode -->| Suite A | "+this.getClass().getSimpleName()+" ........");
		
		if(!TestUtil.isRunnable(xls, "Testcases",this.getClass().getSimpleName()))
		{	testExecutionStatus = "Skip";
			Applog.debug("Skipping--->| Suite A | "+this.getClass().getSimpleName()+" |");
			throw new SkipException("Run mode is NO | Skipping "+this.getClass().getSimpleName());
		}
	}
	
	
	@Test
	public void testcase_A2()
	{
		Applog.debug("Executing "+this.getClass().getSimpleName()+" | ........");
		System.out.println("Testcase No 2");
	}
	
	@AfterTest
	public void testcasereporter(){		
		int i = TestUtil.getrownum(xls,"Testcases",this.getClass().getSimpleName());
		TestUtil.reportDataSetResult(xls,"Testcases",i,testExecutionStatus);

		}
	
	
}
