package utils;

import org.openqa.selenium.WebElement;

public class AgGridCommon {

	public static String groupDetailsRowXpath = "";
	
	public static WebElement selectAndGetElementInTheGrid(WebItem grid, String text) {
		return grid.getSiblingElementforDynamicallyGeneratedData(text);
	}
	
	public static void selectAndGetSiblingElementBySearchText(WebItem grid, String siblingName, String elementText) {
		groupDetailsRowXpath = "//*[.='" + siblingName + "']/following-sibling::*";
		System.out.println(" groupDetailsRowXpath " + groupDetailsRowXpath);
		grid.getSiblingElement(groupDetailsRowXpath, elementText);
	}
	
}
