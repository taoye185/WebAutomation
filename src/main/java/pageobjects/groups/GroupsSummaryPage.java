package pageobjects.groups;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class GroupsSummaryPage extends WebPageInit {

	@FindBy(xpath = "//button[contains(text(),'New portal user')]")
	public WebItem newGroupButton;
	
}
