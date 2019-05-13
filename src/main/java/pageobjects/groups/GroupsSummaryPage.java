package pageobjects.groups;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class GroupsSummaryPage extends WebPageInit {

	@FindBy(xpath = "//button[contains(text(),'New group')]")
	public WebItem newGroupButton;
	
	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebItem filterButton;
	
	@FindBy(xpath = "//div[@id='Names']//*[contains(text(),'Select...')]")
	public WebItem nameFilterDropdown;
	
	@FindBy(xpath = "//div[@id='Descriptions']//*[contains(text(),'Select...')]")
	public WebItem descriptionsFilterDropdown;
	
	
	// //*[contains(text(),'Select...')]
}
