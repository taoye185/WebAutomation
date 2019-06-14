package utils;

import pageobjects.global.LeftNavigation;
import pageobjects.groups.GroupDetailPage;
import pageobjects.groups.GroupsSummaryPage;

public class CleanUp {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static boolean testRunCompleted = true;

	public static void deleteAllGroups() {
		leftNavigation.groupsLink.click();

		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			if (groupsSummaryPage.clearFilterButton.exists(2)) {
				groupsSummaryPage.clearFilterButton.click();
				Browser.sleep(500);
			}

			String tempGroup = CommonUtils.Group_GBL.get(i);
			Log.info(" delete group " + tempGroup);
			groupsSummaryPage.filterButton.click();
			groupsSummaryPage.nameTextField.sendKeys(tempGroup);
			groupsSummaryPage.OkFilterButton.exists(2);
			groupsSummaryPage.OkFilterButton.click();
			Browser.sleep(1000);
			groupsSummaryPage.selectElementintheResultsTabel2(tempGroup, "Details");
			groupDetailPage.deleteGroupButton.exists(2);
			groupDetailPage.deleteGroupButton.click();
			groupDetailPage.deleteConfirmationButton.exists(2);
			groupDetailPage.deleteConfirmationButton.click();

			if (tempGroup.contentEquals(CommonUtils.adminGroup)) {
				CommonUtils.adminGroup = "";
				Log.info(" Admin group " + tempGroup + "set to nul" + CommonUtils.adminGroup);
			}
			if (tempGroup.contentEquals(CommonUtils.supportGroup)) {
				CommonUtils.supportGroup = "";
				Log.info(" Admin group " + tempGroup + "set to nul" + CommonUtils.supportGroup);
			}
			CommonUtils.Group_GBL.remove(i);

		}
	}

}
