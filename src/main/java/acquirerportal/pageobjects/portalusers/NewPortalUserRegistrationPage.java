package acquirerportal.pageobjects.portalusers;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class NewPortalUserRegistrationPage extends WebPageInit {

	@FindBy(xpath = "//h4[contains(text(),'New portal user')]")
	public WebItem newPortalUserHeading;

	@FindBy(xpath = "//h4[contains(text(),'New portal user')]/../..")
	public WebItem newPortalUserPopup;

	@FindBy(name = "name")
	public WebItem portalNameTxtBox;

	@FindBy(name = "login")
	public WebItem portalUsernameTxtBox;

	@FindBy(name = "email")
	public WebItem portalEmailTxtBox;

	@FindBy(xpath = "//*[@id='hiveGroupId-select']/input")
	public WebItem portalGroupDropdown;	

	@FindBy(xpath = "//button[contains(text(),'Create user')]")
	public WebItem createUserButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[1]/button")
	public WebItem closeButton;

	@FindBy(xpath = "//*[@id='hiveGroupId']//input[contains(@tabindex,'0')]")
	public WebItem groupNameTextField;

}
