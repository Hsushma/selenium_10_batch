package com.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Acer
 */
public class FileUtility 
{
	public String getDataFromProperty(String key) throws IOException
	{
		/**
		 * this method is used to get data from property file
		 */
		
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/commandata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
