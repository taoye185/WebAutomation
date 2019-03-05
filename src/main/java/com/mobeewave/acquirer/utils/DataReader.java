package com.mobeewave.acquirer.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DataReader {

	/// <summary>
	/// This method returns the element by waiting till its visible and enabled.
	/// </summary>
	/// <param name="FileURL">URL to file</param>
	/// <param name="property">property that should read from the file</param>
	/// <returns>String</returns>
	
	public static String readProperty(String FileURL, String property) {

		String result = "";
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			File initialFile = new File(FileURL);
			inputStream = new FileInputStream(initialFile);
			if (inputStream != null) {
				prop.load(inputStream);
			} 
			result = prop.getProperty(property);
			inputStream.close();
		} catch (Exception ex) {
			System.out.println("EXCEPTION  " + " File not found ...... ");
			System.out.println("====================    " + ex.getMessage() + "   =============================");
		} finally {

		}
		return result;
	}
}
