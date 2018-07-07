package com.testproject.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.testproject.util.Xls_Reader;

public class TestBase {
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static FileInputStream  file = null;
	public static Xls_Reader xls = null;
	public static Logger Applog = null;
	public static Boolean isInitialize = false;
	public static String[] runMode = null;
	public static String executionStatus = "Pass";
	public static String testExecutionStatus = "Pass";
	
		
	public static void intialize() throws IOException 
	{	if(!isInitialize)
		{
		Applog = Logger.getLogger("devpinoyLogger");
		Applog.debug("Initializing........");
		Applog.debug("Loading Properties file...........");
		CONFIG = new Properties();
		OR = new Properties();
		file = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\testproject\\config\\config.properties");
		CONFIG.load(file);
		file = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\testproject\\config\\OR.properties");
		OR.load(file);
		Applog.debug("Loaded Properties file");
		isInitialize = true;
		}
	}
	
	
	public static Xls_Reader xlsObjectIntialize(String xlsname) throws IOException
	{
		Applog.debug("Initializing xls object........");
		return xls = new Xls_Reader(System.getProperty("user.dir")+CONFIG.getProperty(xlsname+"path"));
		
	}
}
