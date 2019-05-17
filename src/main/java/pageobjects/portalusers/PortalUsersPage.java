package pageobjects.portalusers;

import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class PortalUsersPage extends WebPageInit {

	public void navigatePortalUserPage() {
		Browser.open(AcquirerPortalGlobal.PORTALUSER_URL);
		newPortalUserButton.exists(5);
	}

	@FindBy(xpath = "//button[contains(text(),'New portal user')]")
	public WebItem newPortalUserButton;

}
