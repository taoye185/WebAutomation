package pageobjects.portalusers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

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

	@FindBy(xpath = "//*[@id='hiveGroupId']/div/div[1]")
	public WebItem portalGroupDropdown;

	public void selectGroupDrpdownValue(String value) {
		Select selectPortalGroup = new Select(portalGroupDropdown);
		// List<ArrayList> listtemp = item.getChildElementsintoList();
		// selectPortalGroup.selectByIndex(index);
		selectPortalGroup.selectByValue(value);
	}

}
