package com.mobeewave.acquirer.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobeewave.acquirer.utils.CommonUtils;

public class ConfirmationMesssageBoxPage extends BasePage {
public static WebElement confirmationMessageTitle;
public static WebElement confirmationMessageDescription;
public static WebElement confirmationMessageOK;
public static WebElement confirmationMessageCancel;


	public static WebElement confirmationBox(){
				return CommonUtils.IsElementSelectable(By.xpath(locator("confirmationMessageBox")), 20);
	}
	
	public static void setConfirmationBoxElements(){
		List<ArrayList> listtemp = CommonUtils.getChildElements(confirmationBox());
		confirmationMessageTitle = (WebElement) listtemp.get(6);
		confirmationMessageDescription =  (WebElement) listtemp.get(7);
		confirmationMessageOK = (WebElement) listtemp.get(9);
		confirmationMessageCancel =  (WebElement) listtemp.get(10);
	}
	
	
	
}
