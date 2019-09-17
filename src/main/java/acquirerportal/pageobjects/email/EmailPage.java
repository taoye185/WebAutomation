package acquirerportal.pageobjects.email;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import coreutils.WebItem;
import coreutils.WebPageInit;

public class EmailPage extends WebPageInit {

	@FindBy(id = "mailAddress")
	public WebItem mailAddress;

	@FindBy(id = "messagesList")
	public WebItem messageList;

	@FindBy(xpath = "//div[contains(text(),'Merchant ID:')]/b")
    public WebItem MerchantIDText;
	
	  @FindBy(xpath = "//div[contains(text(),'Merchant ID:')]/following::div[contains(text(),'Password:')]/b")
	    public WebItem MerchantPasswordText;
	
	@FindBy(xpath = "//div[contains(text(),'Login:')]/b")
	public WebItem portalUserNameText;  
	
	@FindBy(xpath = "//div[contains(text(),'Login:')]/following::div[contains(text(),'Password:')]/b")
	public WebItem portalUserPasswordText;

	@FindBy(id = "mail-clock-wrapper")
	public WebItem mailAddressWrapper;

	@FindBy(xpath = "//span[@class='inc-mail-subject' and text()='User Activation']")
	public WebItem emailSubject;
	
	@FindBy(xpath = "//span[@id='totalMessageCount']")
	public WebItem mailCount;

	@FindBy(xpath = "//div[@id='messagesList']//h3")
	public List<WebItem> mailList;

}
