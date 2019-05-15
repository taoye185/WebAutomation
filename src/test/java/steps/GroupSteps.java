package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.global.AcquirerPortalGlobal;
import pageobjects.global.LeftNavigation;

import pageobjects.groups.GroupDetail;
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
	public static  GroupDetail groupDetail = new GroupDetail();


	@Given("^User successfully navigated to Groups summary Page$")
	public void user_successfully_navigated_to_Groups_summary_Page() throws Throwable {
		Thread.sleep(3000);
		Browser.open(AcquirerPortalGlobal.GROUP_URL);
		Thread.sleep(1000);
		//Assert.assertEquals("User is navigated to Groupc Summary Page", Browser.getDriver().getCurrentUrl(),AcquirerPortalGlobal.GROUP_URL);
		Thread.sleep(2000);
	}
	
	@And("^user click on New Group button$")
	public void user_click_on_New_Group_button() throws Throwable {
		Thread.sleep(3000);
		groupsSummaryPage.newGroupButton.click();
	}

	@And("^provide details to create a new Group$")
	public void provide_details_to_create_a_new_Group() throws Throwable {
		Log.info("Creating new Group");			
		//newGroupPage.divisionDropdown.selectDropDownItem("Global Payments");
		Thread.sleep(1000);
		//newGroupPage.divisionDropdown.selectDropDownItem(AcquirerPortalGlobal.GP_GROUP);
		newGroupPage.divisionDropdown.click();
		newGroupPage.selectGroupOption("Global Payments");
		newGroupPage.groupNameTxtBox.sendKeys("AetTest01");
		newGroupPage.groupDescriptionTxtBox.sendKeys("AetTest01 for Automation");
		newGroupPage.groupCreateButton.click();		
		Thread.sleep(3000);
		//selectDropDownItem(Ac.quirerPortalGlobal.GP_GROUP);
	}
	@And("^filter created Group$")
	public void filter_created_Group() throws Throwable {
		Log.info("Filter new Group");
		groupsSummaryPage.filterButton.click();
		Thread.sleep(2000);		
		groupsSummaryPage.nameFilterDropdownArrow.click();
		groupsSummaryPage.selectNameOption("AetTest01");
		Thread.sleep(2000);
		//groupsSummaryPage.nameLabel.click();
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
	


}

