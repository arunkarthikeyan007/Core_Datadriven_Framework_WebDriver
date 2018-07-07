package com.testproject.util;

public class TestUtil {
//*************************************************************************************************************
	//To find the runmode of suite/testcase
	public static boolean isRunnable(Xls_Reader xls,String sheetname,String testName)
	{	
		boolean isExecutable = false;
		for(int i=2;i<=xls.getRowCount(sheetname);i++)
			{
				if(xls.getCellData(sheetname, 1, i).equalsIgnoreCase(testName))
				{	if(xls.getCellData(sheetname, "Run Mode", i).equalsIgnoreCase("Y"))
					isExecutable = true;
					else
					isExecutable = false;
				}
			}	
		xls =null;
		return isExecutable;
	}
	
//*************************************************************************************************************	
	//To get test data for testcase
	public static Object[][] getdata(Xls_Reader xls,String testCaseName)
	{
		if(!xls.isSheetExist(testCaseName))
		{
			xls =null;
			return new Object[1][0];
		}
		int row = xls.getRowCount(testCaseName);
		int col = xls.getColumnCount(testCaseName);
				
		Object[][] data = new Object[row-1][col-3];
	
		for(int rownum=2;rownum<=row;rownum++)
			for(int colnum=1;colnum<=col-3;colnum++)
			{
				data[rownum-2][colnum-1] = xls.getCellData(testCaseName, colnum, rownum);
			}
			return data;
		}
//*************************************************************************************************************	
	// To write result into sheet
	public static void reportDataSetResult(Xls_Reader xls,String testCaseName, int rowNum, String result)
	{
		xls.setCellData(testCaseName,"Result", rowNum, result);
	}
//*************************************************************************************************************	
	// To get run modes of dataset
	public static String[] dataSetRunMode(Xls_Reader xls,String sheetName )
	{
		if(!xls.isSheetExist(sheetName))
		return null;
		
		String[] runmode = new String[xls.getRowCount(sheetName)-1];
		for(int i=2 ; i<=xls.getRowCount(sheetName);i++)
		{
			runmode [i-2]= xls.getCellData(sheetName, "Run Mode", i);
		}
		
		return runmode;
	}

//*************************************************************************************************************	
	public static int getrownum(Xls_Reader xls,String sheetName, String testcasename)
	{	
		for( int i=2 ; i<=xls.getRowCount(sheetName);i++)
		{
			String celldata= xls.getCellData(sheetName, "Test Case Name", i);
			if(celldata.equalsIgnoreCase(testcasename))
			return i ;
		}
		return -1;
	}
//*************************************************************************************************************	

}
