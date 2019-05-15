package pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class GroupDetail extends WebPageInit {
	@FindBy(xpath = "//*[contains(text(),'Delete group')]")
	public WebItem deleteGroupButton;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebItem deleteConfirmationButton;
	

}
