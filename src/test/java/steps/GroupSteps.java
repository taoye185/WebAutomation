package steps;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
		Assert.assertEquals("User is unable to navigate to group summary page", AcquirerPortalGlobal.GROUP_URL,
				Browser.getDriver().getCurrentUrl());
	}

	@When("^user click on New Group button$")
	public void user_click_on_New_Group_button() throws Throwable {
		groupsSummaryPage.newGroupButton.exists(2); /* we need have explicit wait */
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
		Browser.sleep(3000);
		Assert.assertTrue("Group is not listed",
				((groupsSummaryPage.selectElementintheResultsTabel(groupName)).getText().contentEquals(groupName)));
	}

	@When("^click on details of the Group$")
	public void click_on_details_of_the_group() throws Throwable {
		Browser.sleep(3000);
		groupsSummaryPage.selectElementintheResultsTabel2(groupName, "Details");
	}

	@Then("^edit group permissions from group details$")
	public void edit_group_permissions_from_group_details() throws Throwable {
		Log.info(groupDetailPage.groupPermisionLabel.getText());
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
	}

	@Then("^assign and revoke screen appears$")
	public void assign_and_rework_screen_appears() throws Throwable {
		Assert.assertEquals("Portal user permissions link appears",
				groupPermissionsPage.portalUserPermisionLabel.isDisplayed(), true);

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
	 *  
	 */
	public static void createSupportGroup() {
		Log.info("Creating new Support Group");
		groupName = "Support_Group_" + testDataGenerator.timestamp();
		newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GLOBAL_PAYMENTS);
		newGroupPage.groupNameTxtBox.sendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.sendKeys(groupName + " Support Group for Automation");
		newGroupPage.groupCreateButton.click();
		CommonUtils.Group_GBL.add(groupName); // adding to array list for clean up
		Log.info(groupName + ":is created ");
		Browser.sleep(3000);
	}

	public static void CreateAdminGroup() {
		Log.info("Creating new Admin Group");
		groupName = "Admin_Group_" + testDataGenerator.timestamp();
		newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GLOBAL_PAYMENTS);
		newGroupPage.groupNameTxtBox.sendKeys(groupName);
		newGroupPage.groupDescriptionTxtBox.sendKeys(groupName + " Admin Group for Automation");
		newGroupPage.groupCreateButton.click();
		CommonUtils.Group_GBL.add(groupName);
		Log.info(groupName + "is created ");
		Browser.sleep(3000);
	}

	public static void filterGroupByName() {
		Log.info("Filter new Group");
		groupsSummaryPage.filterButton.click();
		groupsSummaryPage.nameFilterDropdown.click();
		groupsSummaryPage.nameTextField.sendKeys(groupName);
		Browser.sleep(3000);
		groupsSummaryPage.nameTextField.sendKeys(Keys.TAB);
		Browser.sleep(3000);
		groupsSummaryPage.OkFilterButton.click();
		Browser.sleep(3000);
		// i didn't get this assertion?
		Assert.assertTrue("Group is not listed",
				((groupsSummaryPage.selectElementintheResultsTabel(groupName)).getText().contentEquals(groupName)));
	}

	public static void selectGroupandassignSupportGroupPermisisons() {
		groupsSummaryPage.selectElementintheResultsTabel2(groupName, "Details");
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		groupPermissionsPage.portalUserPermisionLabel.exists(2);
		groupPermissionsPage.portalUserPermisionLabel.click();
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_1);
		groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_4);
		groupPermissionsPage.DoneBtn.click();
		CommonUtils.supportGroup = groupName;
	}

	public static void selectGroupandassignAdminGroupPermisisons() throws Throwable {
		groupsSummaryPage.selectElementintheResultsTabel2(groupName, "Details");
		groupDetailPage.groupPermisionEditButton.exists(2);
		groupDetailPage.groupPermisionEditButton.click();
		Assert.assertEquals("Portal user permissions link appears",
				groupPermissionsPage.portalUserPermisionLabel.isDisplayed(), true);
		set_permissions_to_create_admin_user_group();
	}
}
