package acquirerportal.pageobjects.merchants;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class MerchantRegistrationPage extends WebPageInit {


	/* Label */
	@FindBy(xpath = "//h1[contains(text(),'New merchant registration')]")
	public WebItem newMerchantRegistrationLabel;
	
	/* Division*/
	@FindBy(id = "divisionId-select")
	public WebItem newMerchantRegistrationDivisionDropDown;
	
	@FindBy(xpath = "//div[@id='divisionId-select']/input")
	public WebItem merchantRegistrationDivisionFilterTexbox;
	
	@FindBy(xpath = " //button[contains(text(),'Back')]")
	public WebItem backButton;
	
/* Payment processor credentials*/
		
	@FindBy(id = "accountNumber")
	public WebItem MerchantIDTextbox;
	
	@FindBy(id = "merchantCategoryCode")
	public WebItem merchantCategoryCode;

	@FindBy(id = "merchantConfigurationTimeZoneId")
	public WebItem MerchantTimeZoneDropdown;
	
	@FindBy(xpath = "//*[@id='merchantConfigurationTimeZoneId-select']/input")
	public WebItem timeZoneTextField;	
	
	@FindBy(xpath = "//label[contains(text(),'Merchant timezone')]")
	public WebItem timeZoneLabel;	
	
	
/*mPOS administrator*/
	
	@FindBy(id = "mposUserName")
	public WebItem mposUserNameTextbox;
	
	@FindBy(id = "mposUserEmail")
	public WebItem userEmailTextbox;
	
	@FindBy(id = "mposUserPhone")
	public WebItem mposUserPhoneTextbox;
	
	@FindBy(xpath ="//div[contains(text(),\"Select language\")]")
	public WebItem userLanguage;
	
	@FindBy(xpath ="//div[@tabindex='-1'][1]")
	public WebItem userLanguageDropDown;
	
	@FindBy(xpath ="//*[@id=\"mposLanguageDefinitionId-select\"]/input")
	public WebItem userLanguageOption;
	
	
/*Business information*/
	
	@FindBy(id = "businessName")
	public WebItem businessNameTextbox;
	
	@FindBy(id = "address")
	public WebItem addressTextbox;
	
	@FindBy(id = "city")
	public WebItem cityTextbox;
	
	@FindBy(id = "country")
	public WebItem countrydropdown;
	
	@FindBy(id = "//div[@role='dialog']/div/div")
	public WebItem stateDropdown;
	
	@FindBy(id = "address")
	public WebItem address;

	@FindBy(id = "city")
	public WebItem city;

	@FindBy(id = "zipCode")
	public WebItem zipCode;

	@FindBy(xpath = "//*[@id='countryDefinitionId-select']/input")
	public WebItem country;

	@FindBy(id= "react-select-2-option-0")
	public WebItem countryDropdown;

	@FindBy(xpath = "//*[@id='provinceStateDefinitionId-select']/input")
	public WebItem state;
	
	@FindBy(xpath = "//input[@placeholder='Select province/state']")
	public WebItem stateOption;
	
	@FindBy(xpath="//div[@tabindex='-1'][1]")
	public WebItem stateDropDown;	
	
	@FindBy(xpath="//label[contains(text(),'Province/State')]")
	public WebItem stateLabel;	
	
	
	
	@FindBy(id = "Province")
    public WebItem cProvincedropdown;
	
	@FindBy(id = "zipCode")
	public WebItem zipCodeTextbox;
	
	/* Processing details */
	@FindBy(xpath = "//label[@label=\"Enable manual PAN entry\"]")
	public WebItem manualEntry;	
	
	/* Terminals */
	@FindBy(id = "terminalIdentifier")
	public WebItem terminalID;
	
	@FindBy(id = "add-terminal-btn")
	public WebItem addTerminalButton;
	
	/*Merchant creation button*/	
	@FindBy(id = "merchant-add-btn")
	public WebItem createMerchant;
	
	/* Error ToolTip */
	@FindBy(className = "error-tooltip")
	public WebItem errorTooltipLabel;
	
	/* Empty Tmezone Error ToolTip */
	@FindBy(xpath = "//div[@class='error-tooltip'][contains(text(),'Please select a timezone')]")
	public WebItem errorTooltipEmptyTimezoneLabel;
	
	
	
	
}
