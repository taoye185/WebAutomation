package com.mobeewave.acquirer.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.utils.CommonUtils;
import com.mobeewave.acquirer.utils.DataReader;

/// <summary>

/// The LoginPage class.
/// Contains login page pageObjects.
/// </summary>

public class LoginPage extends BasePage {
	WebElement usernameTxtBox;
	WebElement passwordTxtBox;
	WebElement signInBtn;
	WebElement forgetPasswordLink;

	// region PageElements

	public WebElement usernameTxtBox() {
		return usernameTxtBox = CommonUtils.IsElementSelectable(By.xpath(locator("tf_username_xpath")));
	}

	public WebElement passwordTxtBox() {
		return passwordTxtBox = CommonUtils.IsElementSelectable(By.xpath(locator("tf_password_xpath")));
	}

	public WebElement signInBtn() {
		return signInBtn = CommonUtils.IsElementSelectable(By.xpath(locator("btn_signIn_xpath")));
	}

	public WebElement forgetPasswordLink() {
		return forgetPasswordLink = CommonUtils.IsElementSelectable(By.xpath(locator("lnk_forgetPassword_xpath")));
	}

	// endregion

}