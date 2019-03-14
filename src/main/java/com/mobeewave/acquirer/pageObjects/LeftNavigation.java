package com.mobeewave.acquirer.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.mobeewave.acquirer.utils.CommonUtils;

/**
 * 
 * @author madurajith.p
 *
 */
public class LeftNavigation extends BasePage {
/**
 * 
 * @param leftnavItem, in run time this will refer final strings mentioned under Left Navigation in Base Page
 * @return left navigation link
 */
	public WebElement leftNavigationLink(String leftnavItem) {
		String leftnavlink = BasePage.lnk_partial_LeftNav_xpath + leftnavItem + "')]";
		return CommonUtils.IsElementSelectable(By.xpath(leftnavlink), 20);
	}

}
