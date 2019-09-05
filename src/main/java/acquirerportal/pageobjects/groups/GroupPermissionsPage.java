package acquirerportal.pageobjects.groups;

import org.openqa.selenium.support.FindBy;
import acquirerportal.GroupPermissions;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class GroupPermissionsPage extends WebPageInit {

	// portal user permissions
	final String PORTALUSERPERMISSIONLABELXPATH = "//h2[contains(text(),'" + GroupPermissions.PORTALUSER_PERMISSION
			+ "')]";

	@FindBy(xpath = PORTALUSERPERMISSIONLABELXPATH)
	public WebItem portalUserPermissionLabel;

	@FindBy(xpath = "//span[contains(text(),'Allows user to get the public details of all Portal users')]")
	public WebItem portalUserPermissionListFirstElement;

	public String portalUserFirstElementXpath = "//span[contains(text(),'Allows user to get the public details of all Portal users')]//following::span[contains(text(),'Allows')]";

	// portal user group permissions
	@FindBy(xpath = "//h2[contains(text(),'Portal group permissions')]")
	public WebItem PortalGroupPermissionsLabel;

	@FindBy(xpath = "//span[contains(text(),'Allows user to get the public details of all Portal group')]")
	public WebItem portalUserGroupPermisionListFirstElement;

	public String portalUserGroupFirstElementXpath = "//span[contains(text(),'Allows user to get the public details of all Portal group')]//following::span[contains(text(),'Allows')]";

	// merchant permissions
	@FindBy(xpath = "//h2[contains(text(),'Merchant permissions')]")
	public WebItem merchantPermissionLabel;

	@FindBy(xpath = "//span[contains(text(),'Allows user to get the public details of all merchants')]")
	public WebItem merchantPermissionListFirstElement;

	public String merchantsFirstElementXpath = "//span[contains(text(),'Allows user to get the public details of all merchants')]//following::span[contains(text(),'Allows')]";

	// transaction permissions
	@FindBy(xpath = "//h2[contains(text(),'Transaction permissions')]")
	public WebItem transactionPermissionLabel;

	@FindBy(xpath = "//*[contains(text(),'Allows user to view transactions.')]")
	public WebItem transactionPermissionListFirstElement;

	public String transactionFirstElementXpath = "//span[contains(text(),'Allows user to view transactions.')]//following::span[contains(text(),'Allows')]";

	// onboarding permissions
	@FindBy(xpath = "//h2[contains(text(),'Onboarding file permissions')]")
	public WebItem onboardingFilePermissionLabel;

	@FindBy(xpath = "//span[contains(text(),'Allows user to upload a onboarding file for merchant registration')]")
	public WebItem onboardingFilePermissionListFirstElement;

	public String onboardingFirstElementXpath = "//span[contains(text(),'Allows user to upload a onboarding file for merchant registration')]//following::span[contains(text(),'Allows')]";

	// audit log permissions
	@FindBy(xpath = "//h2[contains(text(),'Audit log permissions')]")
	public WebItem auditLogPermissionLabel;

	@FindBy(xpath = "//span[contains(text(),'Allows user to view the audit logs')]")
	public WebItem auditLogPermissionListFirstElement;

	public String auditLogFirstElementXpath = "//span[contains(text(),'Allows user to view the audit logs')]//following::span[contains(text(),'Allows')]";

	// Done Button
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebItem DoneBtn;

	public void selectAllPortalUserPermissions() {
		portalUserPermissionListFirstElement.click();
		portalUserPermissionLabel.clickAllSiblingElements(portalUserFirstElementXpath);
	}

	public void selectAllPortalGroupPermissions() {
		portalUserGroupPermisionListFirstElement.click();
		PortalGroupPermissionsLabel.clickAllSiblingElements(portalUserGroupFirstElementXpath);
	}

	public void selectAllMerchantPermissions() {
		merchantPermissionListFirstElement.click();
		merchantPermissionLabel.clickAllSiblingElements(merchantsFirstElementXpath);
	}

	public void selectAllTransactionPermissions() {
		transactionPermissionListFirstElement.click();
		transactionPermissionLabel.clickAllSiblingElements(transactionFirstElementXpath);
	}

	public void selectAllOnboardingFilePermissions() {
		onboardingFilePermissionListFirstElement.click();
		onboardingFilePermissionLabel.clickAllSiblingElements(onboardingFirstElementXpath);
	}

	public void selectAllAuditLogPermissions() {
		auditLogPermissionListFirstElement.click();
		transactionPermissionLabel.clickAllSiblingElements(auditLogFirstElementXpath);
	}

}
