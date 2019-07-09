package acquirerportal.pageobjects.merchants;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class MerchantRegistrationPage extends WebPageInit {


	/* Label */
	@FindBy(xpath = "//h1[contains(text(),'New merchant registration')]")
	public WebItem newMerchantRegistrationLabel;
	
/* Division*/
	@FindBy(id = "divisionId")
	public WebItem newMerchantRegistrationDivisionDropDown;
	
	@FindBy(id = "error-tooltip")
	public WebItem errortooltiptext;
	
	
	
/* Payment processor credentials*/
	
	
	@FindBy(id = "accountNumber")
	public WebItem MerchantIDTextbox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/div[3]/div[2]/div/div[1]/div")
	public WebItem MerchantIDErrorMessage;
	
	@FindBy(id = "merchantConfigurationTimeZoneId")
	public WebItem MerchantTimeZoneDropdown;
	
/*mPOS administrator*/
	
	@FindBy(id = "mposUserName")
	public WebItem mposUserNameTextbox;
	
	@FindBy(id = "mposUserEmail")
	public WebItem userEmailTextbox;
	
	@FindBy(id = "mposUserPhone")
	public WebItem mposUserPhoneTextbox;
	
	@FindBy(id = "xxxxxxxxxxx")
	public WebItem MerchantLanguageDropdown;
	
/*Business information*/
	@FindBy(id = "businessName")
	public WebItem businessNameTextbox;
	
	@FindBy(id = "address")
	public WebItem addressTextbox;
	
	@FindBy(id = "city")
	public WebItem cityTextbox;
	
	@FindBy(id = "country")
	public WebItem countrydropdown;
	
	@FindBy(id = "Province")
    public WebItem cProvincedropdown;
	
	@FindBy(id = "zipCode")
	public WebItem zipCodeTextbox;
	
/*B*/	
	@FindBy(xpath = "//button[@type='submit']")
	public WebItem MerchantCreateButton;
}
