package pageobjects._login;

import org.openqa.selenium.support.FindBy;

import pageobjects.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class LoginPage extends WebPageInit {
	
	/* Define a unique element of a page, useful to verify that the user is one login page*/
	@FindBy(name = "username")
	public WebItem pageId;

	// @FindBy(linkText  = AcquirerPortalGlobal.URL_LOGIN)
	// public WebItem navigateToLoginPage;

	public void navigateToLoginPage() {
		Browser.open(AcquirerPortalGlobal.LOGIN_URL);
	}

	@FindBy(name = "username")
	public WebItem usernameTxtBox;

	@FindBy(name = "password")
	public WebItem passwordTxtBox;

	@FindBy(id = "login")
	public WebItem signInBtn;

	@FindBy(id = "forgotpw")
	public WebItem forgetPasswordLink;
}
