package pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class NewGroupPage extends WebPageInit {

    @FindBy(id = "divisionId")
    public WebItem divisionDropdown;

    @FindBy(xpath = "//label[contains(text(),'Division')]")
    public WebItem divisionLabel;
    @FindBy(id = "name")
    public WebItem groupNameTxtBox;
    @FindBy(id = "description")
    public WebItem groupDescriptionTxtBox;
    @FindBy(xpath = "//button[contains(text(),'Create group')]")
    public WebItem groupCreateButton;

    //below code can be removed

    public String groupOptionsXpath = "//label[contains(text(),'Division')]//following::div[contains(text(),'Global Payments')]";

    public void selectGroupOption(String groupName) {
        divisionDropdown.getSiblingElement(groupOptionsXpath, groupName);
    }

}
