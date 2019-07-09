package acquirerportal.pageobjects.groups;
import org.openqa.selenium.support.FindBy;
import acquireportal.;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class GroupPermissionsPage extends WebPageInit {

	final String PORTALUSERPERMISSIONLABELXPATH = "//h2[contains(text(),'" + GroupPermissions.PORTALUSER_PERMISSION
			+ "')]";

	@FindBy(xpath = PORTALUSERPERMISSIONLABELXPATH)
	public WebItem portalUserPermisionLabel;
	@FindBy(xpath = "//div[contains(text(),'Allows user to get the public details of all Portal users')]")
	public WebItem portalUserSubPermision1;

	// public String portalUserSubPermisionsXpath2 = "//div[contains(text(),'Allows
	// user to get the public details of all Portal users')]/.././/*";
	public String portalUserSubPermisionsXpath = "//div[contains(text(),'Allows user to get the public details of all Portal users')]//following::div[contains(text(),'Allows')]";
	@FindBy(xpath = "//h2[contains(text(),'Portal group permissions')]")
	public WebItem PortalGroupPermissionsLabel;

	public String portalUserGroupSubPermisionsXpath = "//div[contains(text(),'Allows user to get the public details of all Portal group')]/../*";

	@FindBy(xpath = "//h2[contains(text(),'Merchant permissions')]")
	public WebItem mrchantPermisionLabel;

	public String merchantsSubPermisionsXpath = "//div[contains(text(),'Allows user to get the public details of all merchants')]/../*";

	@FindBy(xpath = "//h2[contains(text(),'Transaction permissions')]")
	public WebItem transactionPermisionLabel;

	public String transactionSubPermisionsXpath = "//div[contains(text(),'Allows user to view transactions.')]/../*";

	@FindBy(xpath = "//h2[contains(text(),'Onboarding file permissions')]")
	public WebItem onboardingFilePermisionLabel;
	public String onboardingSubPermisionsXpath = "//div[contains(text(),'Allows user to upload a onboarding file for merchant registration')]/../*";

	@FindBy(xpath = "//h2[contains(text(),'Audit log permissions')]")
	public WebItem auditLogPermisionLabel;
	public String auditLogSubPermisionsXpath = "//div[contains(text(),'Allows user to view the audit logs')]/../*";

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebItem DoneBtn;

	public void selectPortalUserPermisisons(String permission) {
		portalUserSubPermision1.getSiblingElement(portalUserSubPermisionsXpath, permission);

	}

	public void selectAllPortalUserPermissions() {
		portalUserSubPermision1.click();
		portalUserPermisionLabel.clickAllSiblingElements(portalUserSubPermisionsXpath);
	}

	public void selectAllPortalGroupPermissions() {
		PortalGroupPermissionsLabel.clickAllSiblingElements(portalUserGroupSubPermisionsXpath);
	}

	public void selectAllMerchantPermissions() {
		mrchantPermisionLabel.clickAllSiblingElements(merchantsSubPermisionsXpath);
	}

	public void selectAllTransactionPermissions() {
		transactionPermisionLabel.clickAllSiblingElements(transactionSubPermisionsXpath);
	}

	public void selectAllOnboardingFilePermissions() {
		onboardingFilePermisionLabel.clickAllSiblingElements(onboardingSubPermisionsXpath);
	}

	public void selectAllAuditLogPermissions() {
		transactionPermisionLabel.clickAllSiblingElements(auditLogSubPermisionsXpath);
	}

}
