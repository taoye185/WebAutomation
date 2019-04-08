
package com.mobeewave.acquirer.pageObjects;

import com.mobeewave.acquirer.utils.CommonUtils;
import com.mobeewave.acquirer.utils.DataReader;

public class BasePage {

	public static String pageTitle = "";	
		
		
	public static void areElementsOveralapped() {
		CommonUtils.checkOverlap();
		CommonUtils.makeBothElementListandMapClear();
	}

	public static void getAllPageEliments() {

	}

	public static String getCurrentPage() {
		return pageTitle = CommonUtils.getPageTitle();
	}
	
	public static String locator(String locator){
		return DataReader.elementsProperty.getProperty(locator);
	}
	
	public static String locatorXML(String locator){
		//elementsXML.selectSingleNode("//login/tf_username_xpath").getText();
		return  DataReader.elementsXML.selectSingleNode("//ele/"+locator).getText();
	}

}
