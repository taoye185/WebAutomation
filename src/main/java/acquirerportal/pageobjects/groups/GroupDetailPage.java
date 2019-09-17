package acquirerportal.pageobjects.groups;


import org.openqa.selenium.support.FindBy;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class GroupDetailPage extends WebPageInit {

	@FindBy(xpath = "//*[contains(text(),'Delete group')]")
	public WebItem deleteGroupButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Group:')]")
	public WebItem groupLabel;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebItem deleteConfirmationButton;

	@FindBy(xpath = "//h2[contains(text(),'Group permissions')]")
	public WebItem groupPermisionLabel;

	@FindBy(xpath = "//h2[contains(text(),'Group permissions')]//following::button[1]")
	public WebItem groupPermisionEditButton;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	public WebItem backButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Group members')]")
	public WebItem groupMembersLink;
	
	@FindBy(xpath = "//h2[contains(text(),'Group members')]//following::div")
	public WebItem groupMembersDropdown;
	
	@FindBy(xpath = "//h2[contains(text(),'Group members')]/strong")
	public WebItem groupMembersCount;
	
	
	@FindBy(xpath = "//button[contains(text(),'Details')]")
	public WebItem groupMembersDetails;
	
	
}
