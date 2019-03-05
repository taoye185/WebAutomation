package com.mobeewave.acquirer.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;
import com.mobeewave.acquirer.utils.DataReader;


/// <summary>

/// The Merchant Summary Page class.
/// Contains Merchant related page pageObjects.
/// </summary>

public class MerchantsSummaryPage {

	private By lbl_username;
	private String lbl_username_xpath;

	// region PageElements List

	public String pageTitle() {
		return SetUp.getDriver().getCurrentUrl();
	}

	public WebElement usernameLabel() {

		lbl_username_xpath = BasePage.lbl_username_partialxpath + CommonUtils.username_LBL_GBL + "')]";
		lbl_username = By.xpath(lbl_username_xpath);
		return CommonUtils.IsElementAvailable(lbl_username, 20);

	}

	// endregion
}
