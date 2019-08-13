package acquirerportal;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import coreutils.GridCommon;
import coreutils.Browser;
import coreutils.Log;
import acquirerportal.pageobjects.LeftNavigation;
import acquirerportal.pageobjects.groups.GroupDetailPage;
import acquirerportal.pageobjects.groups.GroupsSummaryPage;
import acquirerportal.pageobjects.login.LoginPage;

public class CleanUp {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static LoginPage loginPage = new LoginPage();
	public static boolean testRunCompleted = true;

	public static void deleteAllGroups() {
		if (!leftNavigation.loggedInUserLink.exists(3)) {
			loginPage.navigateToLoginPage();
			loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			leftNavigation.merchantsLink.exists(5);
		}
		Browser.sleep(2000);
		leftNavigation.groupsLink.click();
		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			if (groupsSummaryPage.clearFilterButton.isClickable(4)) {
				groupsSummaryPage.clearFilterButton.click();
			}
			String tempGroup = CommonUtils.Group_GBL.get(i);
			Log.info(" deleting the created group: " + tempGroup);
			groupsSummaryPage.nameTextField.clearAndSendKeys(tempGroup);
			Browser.sleep(2000);
			groupsSummaryPage.nameTextField.sendKeys(Keys.ENTER);
			Browser.sleep(2000);
			GridCommon.getElementOfRowInTheGrid(groupsSummaryPage.groupsListGrid, tempGroup).click();
			groupDetailPage.deleteGroupButton.exists(3);
			groupDetailPage.deleteGroupButton.click();
			groupDetailPage.deleteConfirmationButton.exists(3);
			groupDetailPage.deleteConfirmationButton.click();
			Assert.assertTrue("group is not deleted", Browser.textExists("Group deleted", 3));
			if (tempGroup.contentEquals(CommonUtils.adminGroup)) {
				CommonUtils.adminGroup = "";
				Log.info(" Admin group " + tempGroup + "set to null" + CommonUtils.adminGroup);
			}
			if (tempGroup.contentEquals(CommonUtils.supportGroup)) {
				CommonUtils.supportGroup = "";
				Log.info(" Admin group " + tempGroup + "set to null" + CommonUtils.supportGroup);
			}
		}

		// Clearing the groups generated while in the test run.
		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			CommonUtils.Group_GBL.remove(i);
		}

	}

}
