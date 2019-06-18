package pageobjects.merchants;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class MerchantRegistrationPage extends WebPageInit {

	@FindBy(xpath = "//h1[contains(text(),'New merchant registration')]")
	public WebItem newMerchantRegistrationLabel;

	@FindBy(id = "divisionId")
	public WebItem newMerchantRegistrationDivisionDropDown;
	@FindBy(id = "mposUserEmail")
	public WebItem userEmail;



}
