package pageobjects.global;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//span[contains(text(),'Portal users')]")
	public WebItem portalUserLink;

	@FindBy(xpath = "//span[contains(text(),'Log out')]")
	public WebItem logoutLabel;

	public WebItem leftNavLink;
	
	@FindBy(id="userlink")
	public WebItem loggedInUserLink;
	
	public WebItem initLeftNavLink(String text){
	String xpath = "//*[contains(text(),'"+text+"')]";
	return leftNavLink = new WebItem(By.xpath(xpath));
	}
}
