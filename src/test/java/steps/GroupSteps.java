package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;
import pageobjects.groups.GroupsSummaryPage;
import pageobjects.groups.NewGroupPage;
import pageobjects.login.LoginPage;
import pageobjects.portalusers.NewPortalUserRegistrationPage;
import pageobjects.portalusers.PortalUsersPage;
import utils.Browser;
import utils.CommonUtils;
import utils.Log;
import utils.WebItem;

public class GroupSteps {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static NewGroupPage newGroupPage = new NewGroupPage();
	


	@Given("^User successfully navigated to Groups summary Page$")
	public void user_successfully_navigated_to_Groups_summary_Page() throws Throwable {
		Thread.sleep(3000);
		Browser.open(AcquirerPortalGlobal.GROUP_URL);
		Thread.sleep(1000);
		Assert.assertEquals("User is navigated to Groupc Summary Page", Browser.getDriver().getCurrentUrl(),AcquirerPortalGlobal.GROUP_URL);
		Thread.sleep(2000);
	}
	
	@And("^user click on New Group button$")
	public void user_click_on_New_Group_button() throws Throwable {
		groupsSummaryPage.newGroupButton.click();
	}

	@And("^provide details to create a new Group$")
	public void provide_details_to_create_a_new_Group() throws Throwable {
		Log.info("Creating new Group");
		newGroupPage.divisionDropdown.click();
		Thread.sleep(1000);
		//newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GP_GROUP);
		newGroupPage.selectGroupOption();
		newGroupPage.groupNameTxtBox.sendKeys("AetTest01");
		newGroupPage.groupDescriptionTxtBox.sendKeys("AetTest01 for Automation");
		newGroupPage.groupCreateButton.click();		
		Thread.sleep(1000);
		//selectDropDownItem(Ac.quirerPortalGlobal.GP_GROUP);
	}
	@And("^filter created Group$")
	public void filter_created_Group() throws Throwable {
		Log.info("Filter new Group");
		groupsSummaryPage.filterButton.click();
		groupsSummaryPage.nameFilterDropdown.click();
	}
}

