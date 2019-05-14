package pageobjects.groups;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class GroupsSummaryPage extends WebPageInit {

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
	@FindBy(xpath = "//*[contains(text(),'AetTest01')]/..")
	public WebItem nameFilterDropdownOption;
	@FindBy(xpath = "//*[@id='Descriptions']/div[1]/div[2]/div/")
	public WebItem descriptionFilterDropdownArrow;
	
	//div[@id='Names']//*[contains(text(),'Select...')]
	
	@FindBy(xpath = "//div[@id='Descriptions']//*[contains(text(),'Select...')]")
	public WebItem descriptionsFilterDropdown;
	
	@FindBy(xpath = "//*[contains(text(),'AetTest01')]")
	public WebItem nameFilterOption;
	@FindBy(xpath = "//*[@id='Names']/div[2]")
	public WebItem nameFilterOptions;
	public String xpath = "//*[@id='Names']/div[2]";
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;
	
	
	
	public void selectNameOption(String groupName){
		//nameFilterDropdownArrow.selectDropDownItem(groupName);
		nameFilterDropdownArrow.selectByValueDynamicDropdown(xpath,groupName);
	}
	
	
	public void setDescriptionOption(String description){
		nameFilterDropdownOption.selectDropDownItem(description);
	}
	
	// //*[contains(text(),'Select...')]
}
