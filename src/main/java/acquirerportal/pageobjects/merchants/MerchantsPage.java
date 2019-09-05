package acquirerportal.pageobjects.merchants;

import org.openqa.selenium.support.FindBy;
import acquirerportal.AcquirerPortalGlobal;
import coreutils.Browser;
import coreutils.WebItem;
import coreutils.WebPageInit;

public class MerchantsPage extends WebPageInit {

	public void navigateToMerchantSummaryPage() {
		Browser.open(AcquirerPortalGlobal.MERCHANTS_URL);
		newMerchantButton.exists(5);
	}

	@FindBy(id = "new-merchant-btn")
	public WebItem newMerchantButton;
	
	@FindBy(id = "merchants-list")
	public WebItem merchantListGrid;
	
	@FindBy(id ="divisions")
	public WebItem merchantDivisionFilterTextField;
	
	@FindBy(id ="ids")
	public WebItem merchantIdFilterTextField;
	
	@FindBy(id ="names")
	public WebItem merchantNameFilterTextField;	
	
	@FindBy(id ="select-menu-item-0\"][1]")
	public WebItem	dropDownItem_businessName;
	
	@FindBy(xpath = " //button[contains(text(),'Unlock merchant')]")
	public WebItem unlockButton;
	
	@FindBy(xpath = " //button[contains(text(),'Lock merchant')]")
	public WebItem lockButton;
	
	@FindBy(xpath = " //button[contains(text(),'Confirm')]")
	public WebItem confirmButton;
	
	@FindBy(xpath = " //span[contains(text(),'Showing results')]")
	public WebItem numberOfResultsLabel;
	
		
}
