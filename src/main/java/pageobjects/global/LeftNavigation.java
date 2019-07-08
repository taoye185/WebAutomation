package pageobjects.global;

import org.openqa.selenium.support.FindBy;
import utils.WebItem;
import utils.WebPageInit;

// TODO: Auto-generated Javadoc
/**
 * The Class LeftNavigation.
 *
 * @author madurajith.p
 */
public class LeftNavigation extends WebPageInit {

	@FindBy(id = "merchants-link")
	public WebItem merchantsLink;

	@FindBy(id = "transactions-link")
	public WebItem transactionsLink;

	@FindBy(id = "portal-users-link")
	public WebItem portalUserLink;

	@FindBy(id = "groups-link")
	public WebItem groupsLink;

	@FindBy(xpath = "//*[@id='logout-link']/span/div/svg/path")
	public WebItem logoutLabel3;
	
	@FindBy(xpath = "//*[@id='root']/aside/nav/div/div[5]")
	public WebItem logoutLabel2;
	
	@FindBy(id = "logout-link")
	public WebItem logoutLabel;

	
	
	
	
	@FindBy(id = "userlink")
	public WebItem loggedInUserLink;

	@FindBy(id = "division-name")
	public WebItem divisionName;

	@FindBy(id = "payment-processor")
	public WebItem paymentProcessorName;

	@FindBy(xpath = "//a[contains(@tabindex,'0')]")
	public WebItem leftNavLink;
	
	
}
