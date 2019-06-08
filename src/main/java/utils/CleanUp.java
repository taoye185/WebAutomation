package utils;

import pageobjects.global.LeftNavigation;
import pageobjects.groups.GroupDetailPage;
import pageobjects.groups.GroupsSummaryPage;

public class CleanUp {

	public static GroupsSummaryPage groupsSummaryPage = new GroupsSummaryPage();
	public static GroupDetailPage groupDetailPage = new GroupDetailPage();
	public static LeftNavigation leftNavigation = new LeftNavigation();
	public static boolean testRunCompleted = true;
	
	public static void deleteAllGroups(){	
		leftNavigation.initLeftNavLink("Groups").click();
		
		for (int i = 0; i < CommonUtils.Group_GBL.size(); i++) {
			if(groupsSummaryPage.clearFilterButton.exists(2)){
				groupsSummaryPage.clearFilterButton.click();
				Browser.sleep(500);
			}
			
			String tempGroup =  CommonUtils.Group_GBL.get(i);
			System.out.println(" delete group "  + tempGroup);
			groupsSummaryPage.filterButton.click();
			groupsSummaryPage.nameFilterOptions.selectDropDownItem(tempGroup);	
			Browser.sleep(1000);
			groupsSummaryPage.OkFilterButton.click();
			Browser.sleep(1000);
			groupsSummaryPage.selectElementintheResultsTabel2(tempGroup,"Details");
			Browser.sleep(3000);
			groupDetailPage.deleteGroupButton.click();
			Browser.sleep(3000);
			groupDetailPage.deleteConfirmationButton.click();
			Browser.sleep(3000);
		}
	}
	
}
