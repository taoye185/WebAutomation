package steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import acquirerportal.AcquirerPortalGlobal;
import acquirerportal.pageobjects.LeftNavigation;
import acquirerportal.pageobjects.groups.GroupDetailPage;
import acquirerportal.pageobjects.groups.GroupPermissionsPage;
import acquirerportal.pageobjects.groups.GroupsSummaryPage;
import acquirerportal.pageobjects.groups.NewGroupPage;
import acquirerportal.pageobjects.portalusers.PortalUserDetailPage;
import coreutils.GridCommon;
import coreutils.Browser;
import acquirerportal.CommonUtils;
import coreutils.Log;
import coreutils.TestDataGenerator;

public class GroupSteps {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();
	static TestDataGenerator testDataGenerator = new TestDataGenerator();
	static PortalUserDetailPage PortalUserDetailPage = new PortalUserDetailPage();
	public static String groupName = "";

	@Given("^User successfully navigated to Groups summary Page$")
	public void user_successfully_navigated_to_Groups_summary_Page() {
		Browser.sleep(1000);
		leftNavigation.groupsLink.click();
		Assert.assertTrue("User is unable to navigate to group summary page",
				AcquirerPortalGlobal.GROUP_URL.equalsIgnoreCase(Browser.getDriver().getCurrentUrl()));
	}

	@When("^user click on New Group button$")
	public void user_click_on_New_Group_button() throws Throwable {
		groupsSummaryPage.newGroupButton.exists(5); /* we need have explicit wait */
		groupsSummaryPage.newGroupButton.click();
	}

	@When("^provide details to create a new Group$")
	public void provide_details_to_create_a_new_Group() {
		createSupportGroup();
	}

	@When("^provide details to create a new Admin Group$")
	public void provide_details_to_create_a_new_Admin_Group() throws Throwable {
		createAdminGroup();
	}

	@When("^filter created Group$")
	public void filter_created_Group() throws Throwable {
		filterGroupByName();
	}

	@Then("^verify group is listed down in the results table$")
	public void verify_group_is_listed_down_in_the_results_table() throws Throwable {
		Browser.sleep(2000);
		Assert.assertTrue("Group is not listed",
				GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, groupName).isDisplayed());
	}

	@When("^click on details of the Group$")
	public void click_on_details_of_the_group() throws Throwable {
		groupsSummaryPage.groupsListGrid.exists(5);
		GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, groupName).click();
	}

	@Then("^edit group permissions from group details$")
	public void edit_group_permissions_from_group_details() throws Throwable {
		Browser.sleep(3000);
		groupDetailPage.groupPermisionLabel.exists(5);
		Log.info(groupDetailPage.groupPermisionLabel.getText());
		groupDetailPage.groupPermisionEditButton.exists(3);
		groupDetailPage.groupPermisionEditButton.click();
		Browser.sleep(1000);

	}

	@Then("^assign and revoke screen appears$")
	public void assign_and_rework_screen_appears() throws Throwable {
		Browser.sleep(1000);
		groupPermissionsPage.portalUserPermissionLabel.exists(5);
		Assert.assertTrue("Portal user permissions link not appears",
				groupPermissionsPage.portalUserPermissionLabel.isDisplayed());

	}

	@Then("^set permissions to create support user group$")
	public static void set_permissions_to_create_support_user_group() throws Throwable {
		Browser.sleep(1000);
		if (!groupPermissionsPage.portalUserPermissionLabel.exists(5)) {
			Browser.refresh();
		}
		groupPermissionsPage.portalUserPermissionLabel.exists(5);
		groupPermissionsPage.portalUserPermissionLabel.click();
		groupPermissionsPage.selectAllPortalUserPermissions();
		groupPermissionsPage.DoneBtn.click();
		CommonUtils.supportGroup = groupName;
	}

	@Then("^set permissions to create admin user group$")
	public static void set_permissions_to_create_admin_user_group() throws Throwable {
		groupPermissionsPage.portalUserPermissionLabel.click();
		groupPermissionsPage.selectAllPortalUserPermissions();
		groupPermissionsPage.PortalGroupPermissionsLabel.exists(2);
		groupPermissionsPage.PortalGroupPermissionsLabel.click();
		groupPermissionsPage.selectAllPortalGroupPermissions();
		groupPermissionsPage.merchantPermissionLabel.exists(5);
		groupPermissionsPage.merchantPermissionLabel.click();
		groupPermissionsPage.selectAllMerchantPermissions();
		groupPermissionsPage.transactionPermissionLabel.exists(2);
		groupPermissionsPage.transactionPermissionLabel.click();
		groupPermissionsPage.selectAllTransactionPermissions();
		groupPermissionsPage.onboardingFilePermissionLabel.exists(2);
		groupPermissionsPage.onboardingFilePermissionLabel.click();
		groupPermissionsPage.selectAllOnboardingFilePermissions();
		groupPermissionsPage.auditLogPermissionLabel.exists(2);
		groupPermissionsPage.auditLogPermissionLabel.click();
		groupPermissionsPage.selectAllAuditLogPermissions();
		groupPermissionsPage.DoneBtn.click();
		CommonUtils.adminGroup = groupName;

	}

	/**
	 * Create a support group.
	 */
	public static void createSupportGroup() {
		Log.info("Creating new Support Group");
		groupName = "Support_Group_" + testDataGenerator.timestamp();
		newGroupPage.groupDivisionFilterTextBox.sendKeysToFilter(AcquirerPortalGlobal.GROUP_DIVISION_GOBAL_PAYMENT);
		newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " for Automation");
		newGroupPage.groupCreateButton.exists(5);
		try {
			newGroupPage.groupCreateButton.click();
		} catch (Exception e) {

			if (newGroupPage.divisionNotSelectedError.exists(1)) {
				Log.info("Retry division filter as previous attempt failed");
				newGroupPage.groupDivisionFilterTextBox
						.sendKeysToFilter(AcquirerPortalGlobal.GROUP_DIVISION_GOBAL_PAYMENT);
			}
			if (newGroupPage.nameNotSelectedError.exists(1)) {
				Log.info("Re enter name  as previous attempt failed");
				newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
			}
			if (newGroupPage.descriptionNotSelectedError.exists(1)) {
				Log.info("Re enter description  as previous attempt failed");
				newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " for Automation");
			}
			newGroupPage.groupCreateButton.click();
		}
		Log.info(groupName + ":is created ");
		CommonUtils.Group_GBL.add(groupName);
		Browser.sleep(1000);
	}

	/**
	 * Create an Admin Group
	 */
	public static void createAdminGroup() {
		Log.info("Creating new Admin Group");
		groupName = "Admin_Group_" + testDataGenerator.timestamp();
		newGroupPage.groupDivisionFilterTextBox.clearAndSendKeys(AcquirerPortalGlobal.GROUP_DIVISION_GOBAL_PAYMENT);
		Browser.sleep(1000);
		newGroupPage.groupDivisionFilterTextBox.sendKeys(Keys.ENTER);
		newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " for Automation");
		newGroupPage.groupCreateButton.exists(5);
		try {
			newGroupPage.groupCreateButton.click();
		} catch (Exception e) {
			if (newGroupPage.divisionNotSelectedError.exists(1)) {
				Log.info("Retry division filter as previous attempt failed");
				newGroupPage.groupDivisionFilterTextBox
						.sendKeysToFilter(AcquirerPortalGlobal.GROUP_DIVISION_GOBAL_PAYMENT);
			}
			if (newGroupPage.nameNotSelectedError.exists(1)) {
				Log.info("Re enter name  as previous attempt failed");
				newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
			}
			if (newGroupPage.descriptionNotSelectedError.exists(1)) {
				Log.info("Re enter description  as previous attempt failed");
				newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " for Automation");
			}

			newGroupPage.groupCreateButton.click();
		}
		Log.info(groupName + "is created ");
		CommonUtils.Group_GBL.add(groupName);
		Browser.sleep(2000);
	}

	/**
	 * Filtering Group by Name
	 */
	public static void filterGroupByName() {
		// try {
		Log.info("Filter new Group");
		// Clearing the filter if already selected a value
		if (groupsSummaryPage.clearFilterButton.isClickable(3)) {
			groupsSummaryPage.clearFilterButton.click();
		}
		// groupsSummaryPage.nameTextField.clearAndSendKeys(groupName);
		groupsSummaryPage.nameTextField.sendKeysToFilter(groupName);
		groupsSummaryPage.groupsListGrid.exists(5);
	}

	/**
	 * Just assign few permission to create a support group
	 * 
	 * @throws Throwable
	 */

	public static void selectGroupAndAssignSupportGroupPermisisons() throws Throwable {
		Browser.sleep(1000);
		Log.info("selecting the support group");
		GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, groupName).click();
		Browser.sleep(1000);
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		set_permissions_to_create_support_user_group();

	}

	/**
	 * Assign all the permissions to create an Admin group
	 * 
	 * @throws Throwable
	 */
	public static void selectGroupAndAssignAdminGroupPermisisons() throws Throwable {
		GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, groupName).click();
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		Assert.assertTrue("Portal user permissions link not appears",
				groupPermissionsPage.portalUserPermissionLabel.isDisplayed());
		set_permissions_to_create_admin_user_group();
		Browser.sleep(5000);
		groupDetailPage.backButton.click();
	}
}
