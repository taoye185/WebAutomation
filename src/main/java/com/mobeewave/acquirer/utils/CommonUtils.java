package com.mobeewave.acquirer.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mobeewave.acquirer.infastructure.SetUp;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

public class CommonUtils {

	public static String username_GBL = "";
	public static String password_GBL = "";
	public static String username_LBL_GBL = "";
	public static String email_GBL = "";
	public static String newUserNameFull_GBL;
	public static String newUserName_GBL;
	public static String newUserPassword_GBL;
	public static String newUserEmail_GBL;
	public static String newUserGroup;
	public static String newUserBank;
	public static String newUserDivision;	
	public static WebDriver _driver;
	private static String configPrpoertiesFileURL = "resources/config.properties";
	public static Map<WebElement, String> elementListMap = new HashMap<WebElement, String>();
	public static List<WebElement> elementList = new ArrayList();
	public static List<WebElement> parentElementList = new ArrayList();
	public static List<WebElement> options = new ArrayList();
	DataReader dataReader = new DataReader();
	
	/// <summary>
	/// This method returns the element by waiting till its visible and enabled.
	/// </summary>
	/// <param name="by">Element locator</param>
	/// <param name="time">Time out</param>
	/// <param name="identifier">identifier or element. This will helps when
	/// element text is not available</param>
	/// <returns>WebElement</returns>

	public static WebElement IsElementSelectable(By by, int time, String identifier) {

		_driver = SetUp.getDriver();
		Wait wait = new FluentWait(_driver).withTimeout(time, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		try {

			WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
			System.out.println(" FOUND ELEMENT " + by + "  " + element.getText());
			System.out.println(" location " + by + "  " + element.getLocation());
			addElementstoMap(element, identifier);
			return element;
		}

		catch (WebDriverException ex) {
			WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
			return element;
		} catch (NoSuchElementException ex) {

			System.out.println("====================    " + ex.getMessage() + "   =============================");
			return null;
		}
	}

	/// <summary>
	/// This method returns the element by waiting till its visible and enabled.
	/// </summary>
	/// <param name="by">Element locator</param>
	/// <param name="time">Time out</param>
	/// <returns>WebElement</returns>

	public static WebElement IsElementSelectable(By by, int time) {

		return IsElementSelectable(by, time, "");
	}

	/// <summary>
	/// This method returns the element by waiting till its visible and enabled.
	/// </summary>
	/// <param name="by">Element locator</param>
	/// set default wait time as 10 seconds
	/// <returns>WebElement</returns>

	public static WebElement IsElementSelectable(By by) {
		return IsElementSelectable(by, 10);
	}

	public static WebElement IsElementSelectable(By by, String s) {
		return IsElementSelectable(by, 10, s);
	}

	/// <summary>
	/// This method returns the element by waiting till its Available.
	/// </summary>
	/// <param name="by">Element locator</param>
	/// <param name="time">Time out</param>
	/// <param name="identifier">identifier or element. This will helps when
	/// element text is not available</param>
	/// <returns>WebElement</returns>

	public static WebElement IsElementAvailable(By by, int time, String identifier) {

		_driver = SetUp.getDriver();

		// for its presence once every 5 seconds.
		try {
			Wait wait = new FluentWait(_driver).withTimeout(time, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
			// elementLocations.put(element.getLocation().x,element.getLocation().y
			// );
			System.out.println(" FOUND ELEMENT " + by + "  " + element.getText());
			addElementstoMap(element, identifier);
			return element;
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(by.toString());
		}
	}

	/// <summary>
	/// This method returns the element by waiting till its visible and enabled.
	/// </summary>
	/// <param name="by">Element locator</param>
	/// <param name="time">Time out</param>
	/// <returns>WebElement</returns>
	public static WebElement IsElementAvailable(By by, int time) {

		return IsElementAvailable(by, time, "");
	}

	public static WebElement IsElementAvailable(By by) {
		return IsElementAvailable(by, 5);
	}

	public static WebElement IsElementAvailable(By by, String s) {
		return IsElementAvailable(by, 10, s);
	}

	/// <summary>
	/// This method determines if there are any overallping elements in the
	/// page.
	/// </summary>
	/// <returns>WebElement</returns>

	public static void checkOverlap() {
		System.out.println(" ..... Verifying possible elements overlap...... ");
		try {
			int numElement = elementListMap.size();
			System.out.println(" numElement  " + numElement);

			for (Map.Entry<WebElement, String> entry : elementListMap.entrySet()) {
				System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
				elementList.add(entry.getKey());
			}

			for (int i = 0; i < numElement; i++) {
				for (int j = i + 1; j < numElement; j++) {
					WebElement a = (WebElement) elementList.get(i);
					System.out.println("element a " + a);
					WebElement b = (WebElement) elementList.get(j);
					System.out.println("element b " + b);
					CommonUtils.isOverlap(a, b);
				}
			}
		} catch (Exception ex) {
			System.out.println("ERROR OCCURED...  " + ex.getMessage());
		}
	}

	public static void addElementstoMap(WebElement element, String identifier) {
		if (elementListMap.containsKey(1)) {
			try {
				throw new Exception("Map already contains key " + element + " " + identifier);
			} catch (Exception ex) {

				System.out.println("ERROR OCCURED...  " + ex.getMessage());
			}
		}
		elementListMap.put(element, identifier);
	}

	public static void makeElementListClear() {
		elementList.clear();
	}

	public static void makeElementListMapClear() {
		elementListMap.clear();
	}

	public static void makeBothElementListandMapClear() {
		elementList.clear();
		elementListMap.clear();
	}

	/// <summary>
	/// This method is waiting till the page is getting laod
	/// </summary>
	/// <param name="i">wait time in miliseconds</param>
	/// <returns></returns>

	public void waitForPageLoaded(int i) {
		_driver = SetUp.getDriver();
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(_driver, i);
			wait.until(expectation);
			System.out.println("WAIT  " + "waiting to load page elements");
		} catch (Throwable error) {
			Assert.fail("FAILED " + " Timeout waiting for Page Load Request to complete.");
			System.out.println("====================    " + error.getMessage() + "   =============================");
		}
	}

	/// <summary>
	/// This method fetch correct user name from property file then match the
	/// corresponding password
	/// </summary>
	/// <param name="username">username to be search from property file</param>
	/// <returns></returns>

	public static void setUpUsers(String username) {

		switch (username) {
		case "CBA_Admin":
			username_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBAAdmin");
			username_LBL_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBAAdminLabel");
			password_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBAAdminpassword");
			email_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBAAdminEmail");
			break;
		case "CBA_Support":
			username_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBASupport");
			username_LBL_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBASupportLabel");
			password_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBASupportpassword");
			email_GBL = DataReader.readProperty(configPrpoertiesFileURL, "CBASupportEmail");
			break;
		}

	}

	public static void setUpNewPortalUsers(String username) {
		String sheetName="Create_" +username;
		System.out.println("Sheet Name " + sheetName);
		String filepath = DataReader.readProperty(configPrpoertiesFileURL, "DataDrivenTests");
		System.out.println("filepath Name " + filepath);
		switch (username) {	
		case "CBASupport":
			DataReader.setExcelFile(filepath, sheetName);
			newUserNameFull_GBL =  DataReader.readExcel(1, 0);
			newUserName_GBL =  DataReader.readExcel(1, 1);
			newUserPassword_GBL =  DataReader.readExcel(1, 2);
			newUserEmail_GBL =  DataReader.readExcel(1, 3);
			newUserGroup= DataReader.readExcel(1, 4);
			newUserBank= DataReader.readExcel(1, 5);
			newUserDivision = DataReader.readExcel(1, 6);
			break;
		}

	}
	
	public static boolean coordIsPartiallyContainedIn(WebElement w1, WebElement w2) throws IOException {
		boolean isContained = false;

		int ax1 = w1.getLocation().getX();
		int ay1 = w1.getLocation().getY();
		int width1 = w1.getSize().getWidth();
		int height1 = w1.getSize().getHeight();
		int ax2 = ax1 + width1;
		int ay2 = ay1 + height1;
		int bx1 = w2.getLocation().getX();
		int by1 = w2.getLocation().getY();
		int width2 = w2.getSize().getWidth();
		int height2 = w2.getSize().getHeight();
		int bx2 = bx1 + width2;
		int by2 = by1 + height2;

		if ((bx2 >= ax2) && (ax2 > bx1) && (by2 >= ay2) && (ay2 > by1)) {
			System.out.println(
					"A possible overlap: 1st element has [" + ax1 + " ," + ax2 + " ," + ay1 + " ," + ay2 + "]");
			System.out.println(
					"A possible overlap: 2nd element has [" + bx1 + " ," + bx2 + " ," + by1 + " ," + by2 + "]");
			return true;
		} else if ((ax1 < bx2) && (bx2 <= ax2) && (ay1 < by2) && (by2 <= ay2)) {
			System.out.println(
					"A possible overlap: 1st element has [" + ax1 + " ," + ax2 + " ," + ay1 + " ," + ay2 + "]");
			System.out.println(
					"A possible overlap: 2nd element has [" + bx1 + " ," + bx2 + " ," + by1 + " ," + by2 + "]");
			return true;
		}
		// System.out.println("not overlapping");
		return isContained;
	}

	/// <summary>
	/// This method sverify element overalp
	/// </summary>
	/// <param name="w1">Element1</param>
	/// <param name="w2">Element2</param>
	/// <returns></returns>
	public static boolean isOverlap(WebElement w1, WebElement w2) throws IOException {
		/*
		 * Pre: w1 and w2 are elements currently displayed on current page Post:
		 * return true if w1 and w2 has boundaries overlapping. false if
		 * otherwise
		 */

		boolean isOverlap = false;
		isOverlap = coordIsPartiallyContainedIn(w1, w2) || coordIsPartiallyContainedIn(w2, w1);
		return isOverlap;
	}

	/// <summary>
	/// This method slow down Selenium Sendkeys
	/// </summary>
	/// <param name="text">text to be send</param>
	/// <param name="time">time interval between chars</param>
	/// <param name="element">element that should send the text</param>
	/// <returns></returns>

	public void slowDownSendKeys(String text, int time, WebElement element) {
		try {
			char arr[] = text.toCharArray(); // convert the String object to
												// array of char
			// iterate over the array using the for-each loop.
			for (char ch : arr) {
				String charSequence = "" + ch;
				element.sendKeys(charSequence);
				TimeUnit.MILLISECONDS.sleep(time);
			}
		} catch (Exception ex) {
			System.out.println("FAILED" + "==========   " + ex.getMessage() + "   ============");
		}
	}

	/// <summary>
	/// This method hover over and click a certain element
	/// </summary>
	/// <param name="element">element that should found and click</param>
	/// <returns></returns>

	public void mouseHoverOverAndClick(WebElement element) {
		try {
			_driver = SetUp.getDriver();
			WebDriver _driver = SetUp.getDriver();
			Actions action = new Actions(_driver);
			action.moveToElement(element);
			action.click();
			action.perform();
		} catch (Exception ex) {
			System.out.println("FAILED" + "==========   " + ex.getMessage() + "   ============");
		}
	}

	/// <summary>
	/// This method allows to wait a test for a given time period (in seconds)
	/// </summary>
	/// <param name="time">time interval in seconds </param>
	/// <returns></returns>
	public void setWaitInSeconds(int time) {

		try {
			System.out.println("waiting " + time + " seconds ... ");
			SetUp.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

			// SetUp.getDriver().manage().wait(i);
		} catch (Exception ex) {
			System.out.println("FAILED" + "==========   " + ex.getMessage() + "   ============");
		}
	}

	/// <summary>
	/// Click using and element and off set by coordinates
	/// </summary>
	/// <param name="x">x-coordinate</param>
	/// <param name="y">y-coordinate</param>
	public static void clickPositionAgainstElement(WebElement element, int x, int y) {
		WebDriver driver = SetUp.getDriver();
		new Actions(driver).moveToElement(element).moveByOffset(x, y).click().perform();

	}

	public static String getPageTitle() {
		try {
			if (_driver == null) {
				return null;
			}
		} catch (Exception ex) {
			System.out.println("FAILED" + "==========   " + ex.getMessage() + "   ============");
		}
		return SetUp.getDriver().getTitle();
	}

	@SuppressWarnings("rawtypes")
	public static List getChildElements(WebElement element) {
		parentElementList = element.findElements(By.xpath(".//*"));

		for (int i = 0; i < parentElementList.size(); i++) {
			WebElement a = (WebElement) parentElementList.get(i);
			System.out.println("element " + i + a.getText() + a.getLocation());
		}
		return parentElementList;
	}

	@SuppressWarnings("rawtypes")
	public static WebElement getPagination(WebElement element, int index) {
		parentElementList = element.findElements(By.xpath(".//*"));
		try {

			if (index > parentElementList.size()) {

				throw new Exception("Given pagination is out of bounds");

			}
			for (int i = 0; i < parentElementList.size(); i++) {
				WebElement a = (WebElement) parentElementList.get(i);
				System.out.println("element " + i + a.getText() + a.getLocation());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parentElementList.get(index);
	}
	
	/**
	 * 
	 * @param dropdown
	 * @return List of options in the dropdown
	 */
	@SuppressWarnings("rawtypes")
	public static List getDropdownOptions(Select dropdown) {
		
		options = dropdown.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement a = (WebElement) options.get(i);
			System.out.println("Select Option " + i + " "  + a.getText());
		}
		return options;
	}

	public static int selectValuefromDropdown(String value){
		int index=0;
		for (int i = 0; i < options.size(); i++) {
			WebElement a = (WebElement) options.get(i);
			index=i;
			if(a.getText().equalsIgnoreCase(value)){
				break;
			}
			
		}
		System.out.println("Select Option " + index );
		return index;
		
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static WebElement getLastPagination(WebElement element, String path) {
		parentElementList = element.findElements(By.xpath(path+"//*"));
		int index = parentElementList.size()-1;
		try {
			
		
			for (int i = 0; i < parentElementList.size(); i++) {
				WebElement a = (WebElement) parentElementList.get(i);
				System.out.println("element " + i + a.getText() + a.getLocation());
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return parentElementList.get(index);
	}
	
	
	
}
