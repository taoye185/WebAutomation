package acquirerportal.pageobjects.portalusers;

import org.openqa.selenium.support.FindBy;
import acquirerportal.AcquirerPortalGlobal;
import coreutils.Browser;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class PortalUsersPage extends WebPageInit {

	public void navigatePortalUserPage() {
		Browser.open(AcquirerPortalGlobal.PORTAL_USER_URL);
		newPortalUserButton.exists(5);
	}

	@FindBy(id = "portal-users-list")
	public WebItem portalUserListGrid;

	@FindBy(id = "add-user-btn")
	public WebItem newPortalUserButton;

	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebItem filterButton;

	@FindBy(xpath = "//label[contains(text(),'Names')]")
	public WebItem nameLabel;

	@FindBy(id = "name")
	public WebItem portalUserFilterNamesTextField;
		
	@FindBy(id = "username")
	public WebItem portalUserFilterUserNamesTextField;

	@FindBy(id = "Emails")
	public WebItem portalUserFilterEmailFilterOptions;
	
	@FindBy(id = "group")
	public WebItem portalUserFiltergroupFilterOptions;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;

	@FindBy(xpath = "//div[contains(text(),'Name')]")
	public WebItem nameHeaderinResults;

	@FindBy(xpath = "//div[contains(text(),'Email')]")
	public WebItem emailHeaderinResults;

	public String portalUserDetailsRowXpath = "";

}
