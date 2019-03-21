package com.mobeewave.acquirer.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobeewave.acquirer.utils.CommonUtils;

public class PortalUserPage extends BasePage {
	private static String portalUserEmailTblcell_xpath;
	private static String portalUserRecord_xpath;
	public static WebElement portalUserName;
	public static WebElement portalUserEmail;
	public static WebElement portalUserUserName;
	public static WebElement portalUserDivision;
	public static WebElement portalUserAccountState;
	public static WebElement portalUserDetails;

	public WebElement searchPortalUserText() {

		return CommonUtils.IsElementSelectable(By.xpath(tf_filter_portalusers_xpath), 20);
	}

	public static void setElementsinPortalUserRecord(String portaluserEmail) {

		portalUserEmailTblcell_xpath = BasePage.tblcell_portaluser_email_partialxpath + portaluserEmail + "')]";
		portalUserRecord_xpath = portalUserEmailTblcell_xpath + "/..";
		WebElement portalUserRecord = CommonUtils.IsElementAvailable(By.xpath(portalUserRecord_xpath), 20);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ArrayList> listtemp = CommonUtils.getChildElements(portalUserRecord);
		portalUserName = (WebElement) listtemp.get(1);
		portalUserEmail = (WebElement) listtemp.get(2);
		portalUserUserName = (WebElement) listtemp.get(3);
		portalUserDivision = (WebElement) listtemp.get(4);
		portalUserAccountState = (WebElement) listtemp.get(5);
		portalUserDetails = (WebElement) listtemp.get(8);
	}
	
	public static WebElement portalUserEditIcon() {

		return CommonUtils.IsElementSelectable(By.xpath(icon_portaluser_moreactions_Xpath), 20);
	}
	
	public static void clickPortalUserCreateIcon() {
		CommonUtils.clickPositionAgainstElement(portalUserEditIcon(),0,-60);			
	}
}
