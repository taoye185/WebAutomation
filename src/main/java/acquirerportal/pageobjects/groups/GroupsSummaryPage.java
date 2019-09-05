package acquirerportal.pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import acquirerportal.AcquirerPortalGlobal;
import coreutils.Browser;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class GroupsSummaryPage extends WebPageInit {

	String[] groupSummaryPageGridHeaders = { "Name", "User name", "Email", "Group", "Division", "Status",
			"View details" };

	public static String GROUP_NAME_COL_ID = "name";
	public static String GROUP_DIVISION_COL_ID = "division";
	public static String GROUP_DESCRIPTION_COL_ID = "description";
	public static String GROUP_USERS_COL_ID = "users";

	public void navigateToGroupSummaryPage() {
		Browser.open(AcquirerPortalGlobal.GROUP_URL);
		newGroupButton.exists(5);
	}

	@FindBy(id = "hive-groups-list")
	public WebItem groupsListGrid;

	@FindBy(id = "add-group-btn") 
	public WebItem newGroupButton;

	@FindBy(id = "name")
	public WebItem nameTextField;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;

	@FindBy(xpath = "//button[contains(text(),'Clear Filters')]")
	public WebItem clearFilterButton;

	@FindBy(xpath = "//span[contains(text(),'Showing results')]")
	public WebItem numberOfResultsLabel;

}
