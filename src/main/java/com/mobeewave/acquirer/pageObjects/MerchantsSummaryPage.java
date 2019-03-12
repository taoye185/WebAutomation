
package com.mobeewave.acquirer.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;

/// <summary>

/// The Merchant Summary Page class.
/// Contains Merchant related page pageObjects.
/// </summary>

public class MerchantsSummaryPage extends BasePage {

	private By lbl_username;
	private static String lbl_username_xpath;
	private static String merchantIdTblcell_xpath;
	private static String merchantRecord_xpath;
	public WebElement merchantName;
	public WebElement merchantRegistrationDate;
	public WebElement merchantDiviison;
	public WebElement merchantLockStatus;
	public WebElement merchantDetails;
	// region PageElements List

	public String pageTitle() {
		return SetUp.getDriver().getCurrentUrl();
	}

	public WebElement usernameLabel() {

		lbl_username_xpath = BasePage.lbl_username_partialxpath + CommonUtils.username_LBL_GBL + "')]";
		lbl_username = By.xpath(lbl_username_xpath);
		return CommonUtils.IsElementAvailable(lbl_username, 20);

	}

	public WebElement searchMerchantText() {

		return CommonUtils.IsElementAvailable(By.xpath(tf_merchantfilterchoice_xpath), 20);

	}

	public WebElement merchantIDinMerchantSummuryTabel(String merchantID) {
		String cell_merchnatID_xpath = BasePage.tf_merchatId_Partialxpath + merchantID + "')]";
		return CommonUtils.IsElementAvailable(By.xpath(cell_merchnatID_xpath), 20);
	}

	public void getChildElementsfromMerchantSummeryTabel() {
		CommonUtils.getChildElements(merchantRecord());

	}

	public static WebElement merchantRecord() {
		return CommonUtils.IsElementAvailable(By.xpath(merchantRecord_xpath), 20);
	}

	public void setElementsinMerchantRecord(String merchantID) {

		merchantIdTblcell_xpath = BasePage.tf_merchatId_Partialxpath + merchantID + "')]";
		merchantRecord_xpath = merchantIdTblcell_xpath + "/..";
		WebElement merchantRecord = CommonUtils.IsElementAvailable(By.xpath(merchantRecord_xpath), 20);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ArrayList> listtemp = CommonUtils.getChildElements(merchantRecord);
		merchantName = (WebElement) listtemp.get(1);
		merchantRegistrationDate = (WebElement) listtemp.get(2);
		merchantDiviison = (WebElement) listtemp.get(3);
		merchantLockStatus = (WebElement) listtemp.get(4);
		merchantDetails = (WebElement) listtemp.get(7);
		/*
		 * System.out.println(" merchantName " + merchantName.getText());
		 * System.out.println(" merchantRegistrationDate " +
		 * merchantRegistrationDate.getText());
		 * System.out.println(" merchantDiviison " +
		 * merchantDiviison.getText());
		 * System.out.println(" merchantLockStatus " +
		 * merchantLockStatus.getText()); System.out.println(" merchantDetails "
		 * + merchantDetails.getText());
		 */

	}

	// endregions
}
