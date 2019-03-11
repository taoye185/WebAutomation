
package com.mobeewave.acquirer.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;
import com.mobeewave.acquirer.utils.DataReader;

/// <summary>

/// The Merchant Summary Page class.
/// Contains Merchant related page pageObjects.
/// </summary>

public class MerchantsSummaryPage extends BasePage {

	private By lbl_username;
	private String lbl_username_xpath;
	private String  merchantIdTblcell_xpath;
	public  WebElement merchantName;
	public  WebElement merchantRegistrationDate;
	public  WebElement merchantDiviison;
	public  WebElement merchantLockStatus;
	public  WebElement merchantDetails;
	// region PageElements List

	public String pageTitle() {
		return SetUp.getDriver().getCurrentUrl();
	}

	public WebElement usernameLabel() {

		lbl_username_xpath = BasePage.lbl_username_partialxpath + CommonUtils.username_LBL_GBL + "')]";
		lbl_username = By.xpath(lbl_username_xpath);
		return CommonUtils.IsElementAvailable(lbl_username, 20);

	}

	public WebElement merchantSummuryTabel() {	
		return CommonUtils.IsElementAvailable(By.xpath(merchantrecord_xpath), 20);
	}

	public void getChildElementsfromMerchantSummeryTabel() {
		CommonUtils.getChildElements(merchantSummuryTabel());	
		
	}
	
	public WebElement merchantIdTblcell(String merchantID) {
		merchantIdTblcell_xpath = BasePage.lbl_username_partialxpath + merchantID + "')]";
		return CommonUtils.IsElementAvailable(By.xpath(merchantIdTblcell_xpath), 20);
	}
	
	public void setMerchantDetailsfromTable(WebElement merchantIdTblcell) {
		
		 WebElement merchantIdfromTable = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(0);
		  merchantName = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(1);
		  merchantRegistrationDate = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(2);
		  merchantDiviison = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(3);
		  merchantLockStatus = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(4);
		  merchantDetails = (WebElement) CommonUtils.getChildElements(merchantSummuryTabel()).get(5);
		 
		 
	}
	
	
	
	

	// endregions
}


