package com.autodeskcrm.gerericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Deepak
 *
 */
public class FileLib {
	
	/**
	 *    used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
			FileInputStream fis = new FileInputStream("./testData/commonData.properties");
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
		
		return value;
	}

}
