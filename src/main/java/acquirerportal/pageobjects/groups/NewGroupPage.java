package acquirerportal.pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class NewGroupPage extends WebPageInit {

    @FindBy(id = "divisionId-select")
    public WebItem divisionDropdown;
   
    @FindBy(xpath ="//*[contains(@id,'divisionId-select')]/input")
    public WebItem groupDivisionFilterTextBox;
    
    @FindBy(xpath = "//h4[contains(text(),'New group')]")
    public WebItem newGroupLabel;  
    
    @FindBy(xpath = "//label[contains(text(),'Division')]")
    public WebItem divisionLabel;
  
    // @FindBy(id = "name") // this identifier is geting failed as duplicated id is in group summary page
    @FindBy(xpath ="//label[contains(text(),'Name')]/following::input[@id='name']")    
    public WebItem groupNameTxtBox;
    
    @FindBy(id = "description")
    public WebItem groupDescriptionTxtBox;
    
    @FindBy(xpath = "//button[contains(text(),'Create group')]")
    public WebItem groupCreateButton;
    
    @FindBy(xpath = "//div[contains(text(),'Division not selected')]")
    public WebItem divisionNotSelectedError;
  
    @FindBy(xpath = "//div[contains(text(),'Please enter a name')]")
    public WebItem nameNotSelectedError;
    
    @FindBy(xpath = "//div[contains(text(),'Please enter a description')]")
    public WebItem descriptionNotSelectedError;
    
    
    
}
