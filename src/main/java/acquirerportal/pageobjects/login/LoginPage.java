package acquirerportal.pageobjects.login;

import org.openqa.selenium.support.FindBy;
import acquirerportal.AcquirerPortalGlobal;
import coreutils.Browser;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class LoginPage extends WebPageInit {

	public void navigateToLoginPage() {
		Browser.open(AcquirerPortalGlobal.URL);
		usernameTxtBox.exists(7);
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
