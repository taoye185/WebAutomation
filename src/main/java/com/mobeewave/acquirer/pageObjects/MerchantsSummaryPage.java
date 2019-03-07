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

	// region PageElements List

	public String pageTitle() {
		return SetUp.getDriver().getCurrentUrl();
	}

	public WebElement usernameLabel() {

		lbl_username_xpath = BasePage.lbl_username_partialxpath + CommonUtils.username_LBL_GBL + "')]";
		lbl_username = By.xpath(lbl_username_xpath);
		return CommonUtils.IsElementAvailable(lbl_username, 20);

	}

	public WebElement temp() {

		
		By temp = By.xpath(merchantrecord_xpath);
		return CommonUtils.IsElementAvailable(temp, 20);

	}

	public void childs() {

		List<WebElement> childs = temp().findElements(By.xpath(".//*"));
		
		for (int i= 0; i < childs.size(); i++) {
			WebElement a = (WebElement) childs.get(i);
			System.out.println(" WebElement " + a.getText());
	}
		
		
	}
	

	// endregions
}
