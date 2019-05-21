package pageobjects.groups;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class GroupPermissionsPage extends WebPageInit {
	
	
	@FindBy(xpath = "//h2[contains(text(),'Portal user permissions')]")
	public WebItem portalUserPermisionLabel;
	@FindBy(xpath = "//div[contains(text(),'Allows user to get the public details of all Portal users')]")
	public WebItem portalUserSubPermision1;
	
	public String portalUserSubPermisionsXpath="//div[contains(text(),'Allows user to get the public details of all Portal users')]/.././/*";
		
	@FindBy(xpath = "//h2[contains(text(),'Portal group permissions')]")
	public WebItem PortalGroupPermissionsLabel;
	
	@FindBy(xpath = "//h2[contains(text(),'Merchant permissions')]")
	public WebItem mrchantPermisionLabel;
	
	@FindBy(xpath = "//h2[contains(text(),'Transaction permissions')]")
	public WebItem transactionPermisionLabel;
	
	@FindBy(xpath = "//h2[contains(text(),'Onboarding file permissions")
	public WebItem onboardingFilePermisionLabel;
	
	public void selectPortalUserPermisisons(String permission){
		portalUserSubPermision1.getSiblingElement(portalUserSubPermisionsXpath, permission);
	}

}
