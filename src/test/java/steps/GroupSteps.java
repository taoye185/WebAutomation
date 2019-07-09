package steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;

import pageobjects.groups.GroupDetailPage;
import pageobjects.groups.GroupPermissionsPage;
import pageobjects.groups.GroupsSummaryPage;
import pageobjects.groups.NewGroupPage;
import utils.AgGridCommon;
import utils.Browser;
import utils.CommonUtils;
import utils.Log;
import utils.TestDataGenerator;

public class GroupSteps {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();
	static TestDataGenerator testDataGenerator = new TestDataGenerator();
	public static String groupName = "";

	@Given("^User successfully navigated to Groups summary Page$")
	public void user_successfully_navigated_to_Groups_summary_Page() {
		Browser.sleep(2000);
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
		CreateAdminGroup();
	}

	@When("^filter created Group$")
	public void filter_created_Group() throws Throwable {
		filterGroupByName();
	}

	@Then("^verify group is listed down in the results table$")
	public void verify_group_is_listed_down_in_the_results_table() throws Throwable {
		Browser.sleep(1000);
		Assert.assertTrue("Group is not listed",
				(AgGridCommon.selectAndGetElementInTheGrid(groupsSummaryPage.groupsListGrid, groupName)).isDisplayed());
	}

	@When("^click on details of the Group$")
	public void click_on_details_of_the_group() throws Throwable {
		Browser.sleep(1000);
		AgGridCommon.selectAndGetSiblingElementBySearchText(groupsSummaryPage.groupsListGrid, groupName, "Details");
	}

	@Then("^edit group permissions from group details$")
	public void edit_group_permissions_from_group_details() throws Throwable {
		Log.info(groupDetailPage.groupPermisionLabel.getText());
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
	}

	@Then("^assign and revoke screen appears$")
	public void assign_and_rework_screen_appears() throws Throwable {
		Assert.assertTrue("Portal user permissions link not appears",
				groupPermissionsPage.portalUserPermisionLabel.isDisplayed());

	}

	@Then("^set permissions to create support user group$")
	public void set_permissions_to_create_support_user_group() throws Throwable {
		groupPermissionsPage.portalUserPermisionLabel.click();
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_1);
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_4);
		groupPermissionsPage.DoneBtn.click();
		CommonUtils.supportGroup = groupName;
	}

	@Then("^set permissions to create admin user group$")
	public static void set_permissions_to_create_admin_user_group() throws Throwable {
		groupPermissionsPage.portalUserPermisionLabel.click();
		groupPermissionsPage.selectAllPortalUserPermissions();
		groupPermissionsPage.PortalGroupPermissionsLabel.click();
		groupPermissionsPage.selectAllPortalGroupPermissions();
		groupPermissionsPage.mrchantPermisionLabel.click();
		groupPermissionsPage.selectAllMerchantPermissions();
		groupPermissionsPage.transactionPermisionLabel.click();
		groupPermissionsPage.selectAllTransactionPermissions();
		groupPermissionsPage.onboardingFilePermisionLabel.click();
		groupPermissionsPage.selectAllOnboardingFilePermissions();
		groupPermissionsPage.auditLogPermisionLabel.click();
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
		newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GLOBAL_PAYMENTS);
		newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " Support Group for Automation");
		newGroupPage.groupCreateButton.click();
		CommonUtils.Group_GBL.add(groupName); // adding to array list for clean up
		Log.info(groupName + ":is created ");
		Browser.sleep(3000);
	}

	/**
	 * Create an Admin Group
	 */
	public static void CreateAdminGroup() {
		Log.info("Creating new Admin Group");
		groupName = "Admin_Group_" + testDataGenerator.timestamp();
		newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GLOBAL_PAYMENTS);
		newGroupPage.groupNameTxtBox.clearAndSendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.clearAndSendKeys(groupName + " Admin Group for Automation");
		newGroupPage.groupCreateButton.click();
		CommonUtils.Group_GBL.add(groupName);
		Log.info(groupName + "is created ");
		Browser.sleep(3000);
	}

	/**
	 * Filtering Group by Name
	 */
	public static void filterGroupByName() {
		Log.info("Filter new Group");
		// Clearing the filter if already selected a value
		if (groupsSummaryPage.clearFilterButton.exists(1)) {
			groupsSummaryPage.clearFilterButton.click();
		}
		groupsSummaryPage.filterButton.click();
		groupsSummaryPage.nameFilterDropdown.click();
		groupsSummaryPage.nameTextField.clearAndSendKeys(groupName);
		Browser.sleep(3000);
		groupsSummaryPage.nameTextField.sendKeys(Keys.TAB);
		Browser.sleep(1000);
		groupsSummaryPage.OkFilterButton.click();
		Browser.sleep(1000);
		Assert.assertTrue("Group is not listed",
				AgGridCommon.selectAndGetElementInTheGrid(groupsSummaryPage.groupsListGrid, groupName).isDisplayed());
	}

	/**
	 * Just assign few permission to create a support group
	 */
	public static void selectGroupandassignSupportGroupPermisisons() {
		AgGridCommon.selectAndGetSiblingElementBySearchText(groupsSummaryPage.groupsListGrid, groupName, "Details");
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		groupPermissionsPage.portalUserPermisionLabel.exists(2);
		groupPermissionsPage.portalUserPermisionLabel.click();
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_1);
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_4);
		groupPermissionsPage.DoneBtn.click();
		CommonUtils.supportGroup = groupName;
	}

	/**
	 * Assign all the permissions to create an Admin group
	 * 
	 * @throws Throwable
	 */
	public static void selectGroupandassignAdminGroupPermisisons() throws Throwable {
		AgGridCommon.selectAndGetSiblingElementBySearchText(groupsSummaryPage.groupsListGrid, groupName, "Details");
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		Assert.assertTrue("Portal user permissions link not appears",
				groupPermissionsPage.portalUserPermisionLabel.isDisplayed());
		set_permissions_to_create_admin_user_group();
	}
}
