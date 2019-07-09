package pageobjects.portalusers;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import coreutils.AgGridCommon;
import coreutils.Browser;
import coreutils.Log;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class NewPortalUserRegistrationPage extends WebPageInit {

	public static String groupName = "000";
	
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

	@FindBy(xpath = "//*[@id='hiveGroupId']/div/div[1]")
	public WebItem portalGroupDropdown;
	
	@FindBy(xpath = "//button[contains(text(),'Create user')]")
	public WebItem createUserButton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[1]/button")
	public WebItem closeButton;	
	
	@FindBy(xpath = "//*[@id='hiveGroupId']//input[contains(@tabindex,'0')]")
	public WebItem groupNameTextField;
	
	
	/**
	 * Filtering Group by Name 
	 */
	public void filterGroupByName() {
		Log.info("Filter new Group in Portal USers");		
		groupNameTextField.clearAndSendKeys(groupName);
		Browser.sleep(2000);
		groupNameTextField.sendKeys(Keys.TAB);
		Browser.sleep(1000);
	}
	
}
