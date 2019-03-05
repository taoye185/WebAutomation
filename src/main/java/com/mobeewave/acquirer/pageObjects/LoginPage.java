package com.mobeewave.acquirer.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;



/// <summary>

/// The LoginPage class.
/// Contains login page pageObjects.
/// </summary>

public class LoginPage extends BasePage {

	private static String pageObjectsFileURL = SetUp.getpageObjectsPropertyfileURL();
	private CommonUtils comUitl;

	// region PageElements identifiers
	private By tf_username = By.xpath(BasePage.tf_username_xpath);
	private By tf_password = By.xpath(BasePage.tf_password_xpath);
	private By btn_signIn = By.xpath(BasePage.btn_signIn_xpath);
	private By lnk_forgetPassword = By.xpath(BasePage.lnk_forgetPassword_xpath);
	// endregion
	

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