package utils;

import org.openqa.selenium.WebElement;

public class AgGridCommon {

	public static String groupDetailsRowXpath = "";
	
	/**
	 * Select an element of the grid and click on it
	 * @param grid
	 * @param text
	 * @return
	 */
	public static WebElement selectAndGetElementInTheGrid(WebItem grid, String text) {
		return grid.getSiblingElementforDynamicallyGeneratedData(text);
	}
	
	/**
	 * Select an element of the grid based on another element at same level
	 * @param grid
	 * @param siblingName
	 * @param elementText
	 */
	public static void selectAndGetSiblingElementBySearchText(WebItem grid, String siblingName, String elementText) {
		groupDetailsRowXpath = "//*[.='" + siblingName + "']/following-sibling::*";
		System.out.println(" groupDetailsRowXpath " + groupDetailsRowXpath);
		grid.getSiblingElement(groupDetailsRowXpath, elementText);
	}
	
}
