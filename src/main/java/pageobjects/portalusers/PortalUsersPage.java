package pageobjects.portalusers;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class PortalUsersPage extends WebPageInit {

	@FindBy(xpath = "//button[contains(text(),'New portal user')]")
	public WebItem newPortalUserButton;
	
}
