package com.mobeewave.acquirer.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.utils.CommonUtils;



/// <summary>

/// The LoginPage class.
/// Contains login page pageObjects.
/// </summary>

public class LoginPage extends BasePage {

	// region PageElements

	public WebElement usernameTxtBox() {
		WebElement usernameTxtBox = CommonUtils.IsElementSelectable(By.xpath(BasePage.tf_username_xpath), "LoaginPage.UserName");
		// ElementList.add(usernameTxtBox);
		//addElementstoMap(usernameTxtBox, "LoaginPage.UserName");
		return usernameTxtBox;
	}

	public WebElement passwordTxtBox() {
		WebElement passwordTxtBox = CommonUtils.IsElementSelectable(By.xpath(BasePage.tf_password_xpath), "LoginPage.Password");
	//	addElementstoMap(passwordTxtBox, "LoginPage.Password");
		return passwordTxtBox;
	}


	public WebElement signInBtn() {
		WebElement signInBtn = CommonUtils.IsElementSelectable(By.xpath(BasePage.btn_signIn_xpath), "LoginPage.SignInBtn");
	//	addElementstoMap(signInBtn, "LoginPage.SignInBtn");		
		return signInBtn;
	}
	
	public WebElement forgetPasswordLink() {
		WebElement forgetPasswordLink = CommonUtils.IsElementSelectable(By.xpath(BasePage.lnk_forgetPassword_xpath),
				"LoginPage.ForgetPasswordLink");
		//addElementstoMap(forgetPasswordLink, "LoginPage.ForgetPasswordLink");
		return forgetPasswordLink;
	}


	// endregion

	
}