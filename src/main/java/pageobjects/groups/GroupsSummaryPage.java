package pageobjects.groups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class GroupsSummaryPage extends WebPageInit {

	String[] groupSummaryPageGridHeaders = { "Name", "User name", "Email", "Group", "Division", "Status",
			"View details" };

	public void navigateToGroupSummaryPage() {
		Browser.open(AcquirerPortalGlobal.GROUP_URL);
		newGroupButton.exists(5);
	}

	@FindBy(id = "hive-groups-list")
	public WebItem groupsListGrid;

	@FindBy(id = "add-group-btn")
	public WebItem newGroupButton;

	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebItem filterButton;

	@FindBy(xpath = "//label[contains(text(),'Names')]")
	public WebItem nameLabel;

	@FindBy(id = "Names")
	public WebItem nameFilterDropdown;

	@FindBy(xpath = "//*[@id='Names']//input[contains(@tabindex,'0')]")
	public WebItem nameTextField;

	@FindBy(xpath = "//*[@id='Names']/div[1]/div[2]/div")
	public WebItem nameFilterDropdownArrow;

	@FindBy(xpath = "//*[@id='Descriptions']/div[1]/div[2]/div/")
	public WebItem descriptionFilterDropdownArrow;

	@FindBy(xpath = "//div[@id='Descriptions']//*[contains(text(),'Select...')]")
	public WebItem descriptionsFilterDropdown;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;

	@FindBy(xpath = "//button[contains(text(),'Clear filters')]")
	public WebItem clearFilterButton;

	// @FindBy(xpath = "//*[.='AetTest01']")
	// public WebItem groupNameResultsCell;

	@FindBy(xpath = "//div[contains(text(),'Name')]")
	public WebItem nameHeaderinResults;

	

	/*
	 * public void selectNameOption(String groupName) { //
	 * nameFilterDropdownArrow.selectDropDownItem(groupName);
	 * nameFilterDropdownArrow.getSiblingElement(namesFilterOptionsXpath,
	 * groupName); }
	 */
	/*
	 * public WebElement selectGeneratedGroupName(String groupName) { return
	 * nameHeaderinResults.getSiblingElementforDynamicallyGeneratedData(groupName);
	 * }
	 */


}
