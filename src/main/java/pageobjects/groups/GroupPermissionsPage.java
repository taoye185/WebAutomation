package pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import pageobjects.global.GroupPermissions;
import utils.WebItem;
import utils.WebPageInit;

public class GroupPermissionsPage extends WebPageInit {

	final String PORTALUSERPERMISSIONLABELXPATH = "//h2[contains(text(),'" + GroupPermissions.PORTALUSER_PERMISSION
			+ "')]";

	@FindBy(xpath = PORTALUSERPERMISSIONLABELXPATH)
	public WebItem portalUserPermisionLabel;
	@FindBy(xpath = "//div[contains(text(),'Allows user to get the public details of all Portal users')]")
	public WebItem portalUserSubPermision1;

	public String portalUserSubPermisionsXpath = "//div[contains(text(),'Allows user to get the public details of all Portal users')]/.././/*";

	@FindBy(xpath = "//h2[contains(text(),'Portal group permissions')]")
	public WebItem PortalGroupPermissionsLabel;

	public String portalUserGroupSubPermisionsXpath = "//div[contains(text(),'Allows user to get the public details of all Portal group')]/../*";

	@FindBy(xpath = "//h2[contains(text(),'Merchant permissions')]")
	public WebItem mrchantPermisionLabel;

	@FindBy(xpath = "//h2[contains(text(),'Transaction permissions')]")
	public WebItem transactionPermisionLabel;

	@FindBy(xpath = "//h2[contains(text(),'Onboarding file permissions")
	public WebItem onboardingFilePermisionLabel;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebItem DoneBtn;

	public void selectPortalUserPermisisons(String permission) {
		portalUserSubPermision1.getSiblingElement(portalUserSubPermisionsXpath, permission);

	}

	public void selectAllPortalUserPermissions() {
		selectPortalUserPermisisons(GroupPermissions.PORTALUSER_PERMISSION_1);
		selectPortalUserPermisisons(GroupPermissions.PORTALUSER_PERMISSION_2);
		selectPortalUserPermisisons(GroupPermissions.PORTALUSER_PERMISSION_3);
		selectPortalUserPermisisons(GroupPermissions.PORTALUSER_PERMISSION_4);
	}

}
