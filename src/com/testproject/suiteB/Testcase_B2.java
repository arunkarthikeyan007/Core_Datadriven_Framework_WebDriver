package com.testproject.suiteB;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testproject.suiteB.TestSuiteBase;
import com.testproject.util.TestUtil;

public class Testcase_B2 extends TestSuiteBase{
	String testExecutionStatus = "Pass";
	
	@BeforeTest
	public void checkTestSkip() throws IOException
	{
		Applog.debug("Checking Run mode -->| Suite B | "+this.getClass().getSimpleName()+" ........");
		
		if(!TestUtil.isRunnable(xls, "Testcases",this.getClass().getSimpleName()))
		{
			Applog.debug("Skipping--->| Suite B | "+this.getClass().getSimpleName()+" |");
			throw new SkipException("Run mode is NO | Skipping "+this.getClass().getSimpleName());
		}
	}
	
	@Test
	public void testcase_B2()
	{
		Applog.debug("Executing "+this.getClass().getSimpleName()+" | ........");
		
		System.out.println("Testcase No B2");
	}
	
	@AfterTest
	public void testcasereporter(){		
		int i = TestUtil.getrownum(xls,"Testcases",this.getClass().getSimpleName());
		TestUtil.reportDataSetResult(xls,"Testcases",i,testExecutionStatus);
		
	}
	
	}
