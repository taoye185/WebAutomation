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
import acquirerportal.pageobjects.portalusers.PortalUserDetailPage;

public class CleanUp {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static PortalUserDetailPage portalUserDetailPage = new PortalUserDetailPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static LoginPage loginPage = new LoginPage();
	public static boolean testRunCompleted = true;

	public static void removePortalUSerfromGroup() {
		Log.info("Removing user from the group");
		Log.info("members count " + groupDetailPage.groupMembersCount.getText());
		if (!(groupDetailPage.groupMembersCount.getText().equalsIgnoreCase("0"))) {
			groupDetailPage.groupMembersDropdown.click();
			Log.info("clicked groupMembersDropdown");
			groupDetailPage.groupMembersDetails.click();
			Browser.sleep(5000);
			portalUserDetailPage.deleteUserButton.click();
			portalUserDetailPage.deleteConfirmationButton.click();
		} else {
			Log.info("No group members to remove");
		}
	}

	public static void deleteAllGroups() {

		/* logged-In user might be support user so need to verify groups exist or not */
		if (!leftNavigation.groupsLink.exists(3) && leftNavigation.loggedInUserLink.exists(3)) {
			leftNavigation.logoutLabel.clickByJavaScript();
			Browser.sleep(1000);
			loginPage.navigateToLoginPage();
			loginPage.usernameTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_USER_NAME);
			loginPage.passwordTxtBox.clearAndSendKeys(AcquirerPortalGlobal.GP_ADMIN_PASSWORD);
			loginPage.signInBtn.click();
			leftNavigation.merchantsLink.exists(5);
		}
		Browser.sleep(2000);
		leftNavigation.groupsLink.click();
		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			Log.info("CLEANING GROUP " + CommonUtils.Group_GBL.get(i));
			if (groupsSummaryPage.clearFilterButton.isClickable(4)) {
				groupsSummaryPage.clearFilterButton.click();
			}
			String tempGroup = CommonUtils.Group_GBL.get(i);
			Log.info(" deleting the created group: " + tempGroup);
			groupsSummaryPage.nameTextField.sendKeysToFilter(tempGroup);
			Log.info("selecting the group");
			GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, tempGroup).click();
			Browser.sleep(1000);
			removePortalUSerfromGroup();
			Browser.sleep(2000);
			leftNavigation.groupsLink.click();
			groupsSummaryPage.nameTextField.sendKeysToFilter(tempGroup);
			GridCommon.getGridRowElement(groupsSummaryPage.groupsListGrid, tempGroup).click();
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
				Log.info(" Support group " + tempGroup + "set to null" + CommonUtils.supportGroup);
			}
		}

		// Clearing the groups generated while in the test run.
		CommonUtils.Group_GBL.clear();
		Assert.assertTrue("Groups are not deleted", CommonUtils.Group_GBL.isEmpty());
	}

}
