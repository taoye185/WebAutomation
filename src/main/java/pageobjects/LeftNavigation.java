package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class LeftNavigation.
 *
 * @author madurajith.p
 */
public class LeftNavigation extends BasePage {

	/**
	 * The user profile.
	 *
	 * @return left navigation link
	 */
	public static WebElement userProfile;

	/** The pin. */
	public static WebElement pin;

	/** The logout. */
	public static WebElement logout;

	/**
	 * Left navigation link.
	 *
	 * @param leftnavItem the leftnav item
	 * @return the web element
	 */
	public WebElement leftNavigationLink(String leftnavItem) {
		String leftnavlink = BasePage.lnk_partial_LeftNav_xpath + leftnavItem + "')]";
		return CommonUtils.IsElementSelectable(By.xpath(leftnavlink), 20);
	}

	/**
	 * Sets the left navigation bottom elements.
	 */
	public static void setLeftNavBottomElements() {
		WebElement parent = CommonUtils.IsElementSelectable(By.xpath(parentlefnav_xpath), 20);
		List<ArrayList> listtemp = CommonUtils.getChildElements(parent);
		userProfile = (WebElement) listtemp.get(25);
		pin = (WebElement) listtemp.get(27);
		logout = (WebElement) listtemp.get(29);
	}
}
