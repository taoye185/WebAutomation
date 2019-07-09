package pageobjects.groups;


import org.openqa.selenium.support.FindBy;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class GroupDetailPage extends WebPageInit {
	GroupPermissionsPage groupPermissionsPage = new GroupPermissionsPage();

	@FindBy(xpath = "//*[contains(text(),'Delete group')]")
	public WebItem deleteGroupButton;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebItem deleteConfirmationButton;

	@FindBy(xpath = "//h2[contains(text(),'Group permissions')]")
	public WebItem groupPermisionLabel;

	@FindBy(xpath = "//h2[contains(text(),'Group permissions')]//following::button[1]")
	public WebItem groupPermisionEditButton;

}
