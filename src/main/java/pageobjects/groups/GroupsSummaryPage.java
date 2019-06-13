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

	@FindBy(xpath = "//button[contains(text(),'New group')]")
	public WebItem newGroupButton;

	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebItem filterButton;

	@FindBy(xpath = "//label[contains(text(),'Names')]")
	public WebItem nameLabel;
	@FindBy(xpath = "//*[@id='Names']/div[1]/div[1]/div[1]")
	public WebItem nameFilterDropdown;
	@FindBy(xpath = "//*[@id='Names']/div[1]/div[2]/div")
	public WebItem nameFilterDropdownArrow;
	
	//@FindBy(xpath = "//*[contains(text(),'AetTest01')]/..")
	//public WebItem nameFilterDropdownOption;
	
	@FindBy(xpath = "//*[@id='Descriptions']/div[1]/div[2]/div/")
	public WebItem descriptionFilterDropdownArrow;	

	@FindBy(xpath = "//div[@id='Descriptions']//*[contains(text(),'Select...')]")
	public WebItem descriptionsFilterDropdown;

	//@FindBy(xpath = "//*[contains(text(),'AetTest01')]")
	//public WebItem nameFilterOption;
	
	@FindBy(id = "Names")
	public WebItem nameFilterOptions;	


	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;

	@FindBy(xpath = "//button[contains(text(),'Clear filters')]")
	public WebItem clearFilterButton;
	
	//@FindBy(xpath = "//*[.='AetTest01']")
	//public WebItem groupNameResultsCell;
	
	@FindBy(xpath = "//div[contains(text(),'Name')]")
	public WebItem nameHeaderinResults;
	
	public String groupDetailsRowXpath = "";

	/*public void selectNameOption(String groupName) {
		// nameFilterDropdownArrow.selectDropDownItem(groupName);
		nameFilterDropdownArrow.getSiblingElement(namesFilterOptionsXpath, groupName);
	}
*/
	/*public WebElement  selectGeneratedGroupName(String groupName) {
		return nameHeaderinResults.getSiblingElementforDynamicallyGeneratedData(groupName);
	}
	*/
	public WebElement selectElementintheResultsTabel(String text){		
		return nameHeaderinResults.getSiblingElementforDynamicallyGeneratedData(text);
	}

	public void selectElementintheResultsTabel2(String siblingName, String elementText){
		groupDetailsRowXpath = "//*[.='" + siblingName+ "']/following-sibling::*";
		System.out.println(" groupDetailsRowXpath " + groupDetailsRowXpath);
		nameHeaderinResults.getSiblingElement(groupDetailsRowXpath,elementText);
		
	}
	
	public void setDescriptionOption(String description) {
		//nameFilterDropdownOption.selectDropDownItem(description);
	}


}
