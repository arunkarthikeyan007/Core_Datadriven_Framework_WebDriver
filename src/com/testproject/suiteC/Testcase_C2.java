package com.testproject.suiteC;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testproject.suiteC.TestSuiteBase;
import com.testproject.util.TestUtil;

public class Testcase_C2 extends TestSuiteBase{
	static int count = -1;
	String testExecutionStatus = "Pass";
	
	@BeforeTest
	public void checkTestSkip() throws IOException
	{
		Applog.debug("Checking Run mode -->| Suite C | "+this.getClass().getSimpleName()+" | ........");
		
		if(!TestUtil.isRunnable(xls, "Testcases", this.getClass().getSimpleName()))
		{	testExecutionStatus = "Skip";
			executionStatus = "Skip";
			Applog.debug("Skipping--->| Suite C | "+this.getClass().getSimpleName()+" | ........");
			throw new SkipException("Run mode is NO | Skipping "+this.getClass().getSimpleName());
		}
		runMode = TestUtil.dataSetRunMode(xls,this.getClass().getSimpleName());
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		return TestUtil.getdata(xls, this.getClass().getSimpleName());
	}
	
	@Test(dataProvider="getTestData")
	public void testcase_A1( String data1,String data2)
	{	
		count++;
		if(!runMode[count].equalsIgnoreCase("Y")){
			executionStatus = "Skip";
			if(testExecutionStatus.equalsIgnoreCase("fail"))
			testExecutionStatus = "Fail";
			
			Applog.debug("Skipping "+this.getClass().getSimpleName()+ " for data set "+ count+" | Run mode is NO");
			throw new SkipException("Skipping "+this.getClass().getSimpleName()+ " for data set "+count +" | Run mode is NO");
			}
		
		Applog.debug("Executing "+this.getClass().getSimpleName()+" for data set "+count+" ........");
		
		System.out.println("Testcase No C2");
	}
	
	@AfterMethod
	public void testmethodreporter(){
		TestUtil.reportDataSetResult(xls,this.getClass().getSimpleName(), count+2,executionStatus);
		executionStatus = "Pass";
		}
	
	@AfterTest
	public void testcasereporter(){		
		int i = TestUtil.getrownum(xls,"Testcases",this.getClass().getSimpleName());
		TestUtil.reportDataSetResult(xls,"Testcases",i,testExecutionStatus);
		}
}
				