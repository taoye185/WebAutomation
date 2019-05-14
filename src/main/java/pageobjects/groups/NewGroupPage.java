package pageobjects.groups;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class NewGroupPage extends WebPageInit {

	@FindBy(xpath = "/html/body/div[4]/div/div")
	public WebItem divisionDropdown;
	@FindBy(xpath = "//label[contains(text(),'Division')]")
	public WebItem divisionLabel;
	@FindBy(id = "name")
	public WebItem groupNameTxtBox;
	@FindBy(id = "description")
	public WebItem groupDescriptionTxtBox;
	@FindBy(xpath = "//button[contains(text(),'Create group')]")
	public WebItem groupCreateButton;
	
	public void selectGroupOption(){
		WebItem.enter();
	}
	
	
	
	
	
}
