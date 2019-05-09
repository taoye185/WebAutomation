package pageobjects.merchants;

import org.openqa.selenium.support.FindBy;
import utils.WebItem;
import utils.WebPageInit;

public class MerchantsPage extends WebPageInit{

	@FindBy(xpath = "//*[contains(text(),'New merchant')]")
	public WebItem newMerchantButton;	
	
	
	
}
