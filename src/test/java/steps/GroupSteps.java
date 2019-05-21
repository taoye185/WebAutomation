package steps;

import org.junit.Assert;

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
import utils.Log;

public class GroupSteps {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static  GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();

	@Given("^User successfully navigated to Groups summary Page$")
	public void user_successfully_navigated_to_Groups_summary_Page() throws Throwable {
		Thread.sleep(3000);
		groupsSummaryPage.navigateToGroupSummaryPage();
		Assert.assertEquals("User is unable to navigate to group summary page", AcquirerPortalGlobal.GROUP_URL,
				Browser.getDriver().getCurrentUrl());
	}

	@When("^user click on New Group button$")
	public void user_click_on_New_Group_button() throws Throwable {
		groupsSummaryPage.newGroupButton.exists(2000); /* we need have implicit wait */
		groupsSummaryPage.newGroupButton.click();
	}

	@When("^provide details to create a new Group$")
	public void provide_details_to_create_a_new_Group() throws Throwable {
		Log.info("Creating new Group");
		newGroupPage.divisionDropdown.selectDropDownItem("Global Payments");
		newGroupPage.groupNameTxtBox.sendKeys("AetTest01");
		newGroupPage.groupDescriptionTxtBox.sendKeys("AetTest01 for Automation");
		newGroupPage.groupCreateButton.click();
		Thread.sleep(3000);
	}

	@When("^filter created Group$")
	public void filter_created_Group() throws Throwable {
		Log.info("Filter new Group");
		groupsSummaryPage.filterButton.click();
		Thread.sleep(2000);
		groupsSummaryPage.nameFilterDropdownArrow.click();
		groupsSummaryPage.selectNameOption("AetTest01");
		Thread.sleep(2000);
		// groupsSummaryPage.nameLabel.click();
		groupsSummaryPage.OkFilterButton.click();
		Thread.sleep(1000);

	}

	@Then("^verify group is listed down in the results table$")
	public void verify_group_is_listed_down_in_the_results_table() throws Throwable {
		Assert.assertTrue("Group is listed",
				(groupsSummaryPage.groupNameResultsCell.getText().equalsIgnoreCase("AetTest01")));
	}

	@Given("^click on details of the Group$")
	public void click_on_details_of_the_group() throws Throwable {
		groupsSummaryPage.selectElementintheResultsTabel("Details");
		Thread.sleep(3000);
	}
	

@Then("^edit group permissions from group details$")
public void edit_group_permissions_from_group_details() throws Throwable {
	System.out.println(groupDetailPage.groupPermisionLabel.getText());
	groupDetailPage.groupPermisionEditButton.click();
	Thread.sleep(3000);
}

@When("^assign and rework screen appears$")
public void assign_and_rework_screen_appears() throws Throwable {
	groupPermissionsPage.portalUserPermisionLabel.click();
	groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_1);
	groupPermissionsPage.selectPortalUserPermisisons(AcquirerPortalGlobal.PORTALUSER_PERMISSION_4);
	Thread.sleep(3000);
}

@Then("^set permissions to create support user group$")
public void set_permissions_to_create_support_user_group() throws Throwable {
  
}

@Then("^set permissions to create admin user group$")
public void set_permissions_to_create_admin_user_group() throws Throwable {

}



}
