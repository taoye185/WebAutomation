package pageobjects.groups;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class NewGroupPage extends WebPageInit {

	@FindBy(xpath = "//*[@id='divisionId']/div/div[1]")
	public WebItem divisionDropdown;
	//*[@id="divisionId"]/following::div/following::div/following::div/following::div/following::div
	@FindBy(xpath = "//label[contains(text(),'Division')]")
	public WebItem divisionLabel;
	@FindBy(id = "name")
	public WebItem groupNameTxtBox;
	@FindBy(id = "description")
	public WebItem groupDescriptionTxtBox;
	@FindBy(xpath = "//button[contains(text(),'Create group')]")
	public WebItem groupCreateButton;
	
	public String groupOptionsXpath="//label[contains(text(),'Division')]//following::div[contains(text(),'Global Payments')]";

	
	
	public void selectGroupOption(String groupName){
		divisionDropdown.getSiblingElement(groupOptionsXpath, groupName);
	}
	
	
	
	
	
}
