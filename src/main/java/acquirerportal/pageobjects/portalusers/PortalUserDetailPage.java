package acquirerportal.pageobjects.portalusers;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class PortalUserDetailPage extends WebPageInit {

	@FindBy(xpath = "//*[contains(text(),'Delete user')]")
	public WebItem deleteUserButton;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebItem deleteConfirmationButton;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebItem deleteCancelButton;
	
}
