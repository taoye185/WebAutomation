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

	@FindBy(id = "logout-link")
	public WebItem logoutLabel;

	@FindBy(id = "userlink")
	public WebItem loggedInUserLink;

	@FindBy(id = "division-name")
	public WebItem divisionName;

	@FindBy(id = "payment-processor")
	public WebItem paymentProcessorName;

	
}
