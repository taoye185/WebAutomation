package pageobjects.login;

import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.GPPageElements;
import utils.Browser;
import utils.Global;
import utils.WebItem;
import utils.WebPageInit;

public class LoginPage extends WebPageInit {
	
	/* Define a unique element of a page, useful to verify that the user is one login page*/
	
	@FindBy(name = "username")
	public WebItem usernameTxtBox;

	@FindBy(name = "password")
	public WebItem passwordTxtBox;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	public WebItem signInBtn;

	@FindBy(id = "forgotpw")
	public WebItem forgetPasswordLink;
}
