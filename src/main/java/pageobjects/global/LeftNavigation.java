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

	public WebItem userLink;
	
	public void inituserLink(String text){
	String xpath = "//a[contains(text(),'"+text+"')]";
	userLink = new WebItem(By.xpath(xpath));
	}
	
}
