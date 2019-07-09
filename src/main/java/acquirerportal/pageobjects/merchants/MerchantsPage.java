package pageobjects.merchants;

import org.openqa.selenium.support.FindBy;

import AcquirerPortalGlobal;
import coreutils.Browser;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class MerchantsPage extends WebPageInit {

	public void navigateToMerchantSummaryPage() {
		Browser.open(AcquirerPortalGlobal.MERCHANTS_URL);
		newMerchantButton.exists(5);
	}

	@FindBy(xpath = "//*[contains(text(),'New merchant')]")
	public WebItem newMerchantButton;

}
