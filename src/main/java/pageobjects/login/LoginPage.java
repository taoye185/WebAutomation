package pageobjects.login;

import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class LoginPage extends WebPageInit {

	/*
	 * Define a unique element of a page, useful to verify that the user is one
	 * login page
	 */

	public void navigateToLoginPage() {
		Browser.open(AcquirerPortalGlobal.URL);
		usernameTxtBox.exists(5);
	}

	@FindBy(name = "username")
	public WebItem usernameTxtBox;

	@FindBy(name = "password")
	public WebItem passwordTxtBox;

	@FindBy(xpath = "//button[@type ='submit']")
	public WebItem signInBtn;

	@FindBy(id = "forgotpw")
	public WebItem forgetPasswordLink;
}
