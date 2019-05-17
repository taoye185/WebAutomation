package pageobjects.merchants;

import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class MerchantsPage extends WebPageInit {

	public void navigateToMerchantSummaryPage() {
		Browser.open(AcquirerPortalGlobal.MERCHANTS_URL);
		newMerchantButton.exists(5);
	}

	@FindBy(xpath = "//*[contains(text(),'New merchant')]")
	public WebItem newMerchantButton;

}
