package coreutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GridCommon {

	public static String groupDetailsRowXpath = "";

	/**
	 * Select an element of the grid and click on it
	 * 
	 * @param grid - the table
	 * @param text - the text of the element to be found
	 * @return
	 */
	public static WebElement selectAndGetElementInTheGrid(WebItem grid, String text) {
		return grid.getSiblingElementforDynamicallyGeneratedData(text);
	}

	/**
	 * Returns an element of the row in Grid
	 * 
	 * @param grid - the table
	 * @param text - the text of the element to be found
	 * @return
	 */
	public static WebElement getGridRowElement(WebItem grid, String elementText) {
		Browser.sleep(2000);
		return grid.findElement(By.xpath(".//*[contains(text(),'" + elementText + "')]"));
	}

	/**
	 * Select an element of the grid based on another element at same level
	 * 
	 * @param grid        - the table
	 * @param siblingName - the sibling element
	 * @param elementText - the text of the element to be found
	 */
	public static void selectAndGetSiblingElementBySearchText(WebItem grid, String siblingName, String elementText) {
		groupDetailsRowXpath = "//*[.='" + siblingName + "']/following-sibling::*";
		Log.info(" groupDetailsRowXpath " + groupDetailsRowXpath);
		grid.getSiblingElement(groupDetailsRowXpath, elementText);
	}

}
