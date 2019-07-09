package acquireportal;

import org.openqa.selenium.Keys;
import coreutils.AgGridCommon;
import coreutils.Browser;
import coreutils.Log;
import pageobjects.LeftNavigation;
import acquireportal.pageobjects.groups.GroupDetailPage;
import acquireportal.pageobjects.groups.GroupsSummaryPage;
//import steps.BackgroundSteps;

public class CleanUp {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static boolean testRunCompleted = true;

	public static void deleteAllGroups() {
		// BackgroundSteps.login_As_GP_Admin();
		leftNavigation.groupsLink.click();

		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			if (groupsSummaryPage.clearFilterButton.exists(2)) {
				groupsSummaryPage.clearFilterButton.click();
				Browser.sleep(500);
			}

			String tempGroup = CommonUtils.Group_GBL.get(i);
			Log.info(" delete group " + tempGroup);
			Log.info("Filter new Group");
			groupsSummaryPage.filterButton.click();
			groupsSummaryPage.nameFilterDropdown.click();
			groupsSummaryPage.nameTextField.sendKeys(tempGroup);
			Browser.sleep(2000);
			groupsSummaryPage.nameTextField.sendKeys(Keys.TAB);
			Browser.sleep(2000);
			groupsSummaryPage.OkFilterButton.click();
			Browser.sleep(2000);
			AgGridCommon.selectAndGetSiblingElementBySearchText(groupsSummaryPage.groupsListGrid, tempGroup, "Details");
			groupDetailPage.deleteGroupButton.exists(2);
			groupDetailPage.deleteGroupButton.click();
			Browser.sleep(1000);
			groupDetailPage.deleteConfirmationButton.exists(2);
			groupDetailPage.deleteConfirmationButton.click();
			Browser.sleep(1000);

			if (tempGroup.contentEquals(CommonUtils.adminGroup)) {
				CommonUtils.adminGroup = "";
				Log.info(" Admin group " + tempGroup + "set to nul" + CommonUtils.adminGroup);
			}
			if (tempGroup.contentEquals(CommonUtils.supportGroup)) {
				CommonUtils.supportGroup = "";
				Log.info(" Admin group " + tempGroup + "set to nul" + CommonUtils.supportGroup);
			}
		}

		// clearing the groups generated while in the test run.
		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			CommonUtils.Group_GBL.remove(i);
		}

	}

}
