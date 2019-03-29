package com.mobeewave.acquirer.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.utils.CommonUtils;


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
		return	usernameTxtBox = CommonUtils.IsElementSelectable(By.xpath(BasePage.tf_username_xpath), "LoginPage.UserName");
			 
	}

	public WebElement passwordTxtBox() {
		return	passwordTxtBox = CommonUtils.IsElementSelectable(By.xpath(BasePage.tf_password_xpath), "LoginPage.Password");
	
	}


	public WebElement signInBtn() {
		return signInBtn = CommonUtils.IsElementSelectable(By.xpath(BasePage.btn_signIn_xpath), "LoginPage.SignInBtn");
	
	}
	
	public WebElement forgetPasswordLink() {
		return forgetPasswordLink = CommonUtils.IsElementSelectable(By.xpath(BasePage.lnk_forgetPassword_xpath),
				"LoginPage.ForgetPasswordLink");
	}


	// endregion

	
}