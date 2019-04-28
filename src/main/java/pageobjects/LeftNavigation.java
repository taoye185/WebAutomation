package pageobjects;

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

	
	private WebItem webiItem;

	@FindBy(xpath = "//span[contains(text(),'Portal users')]")
	public WebItem portalUserLink;

	
}
