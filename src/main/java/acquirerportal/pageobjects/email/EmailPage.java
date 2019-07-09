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

	@FindBy(xpath = "//div[contains(text(),'Password:')]/b")
	public WebItem passwordText;

	@FindBy(xpath = "//div[contains(text(),'Login:')]/b")
	public WebItem userNameText;

	// b[contains(text(),'test2222')]

	@FindBy(xpath = "//span[@class='inc-mail-subject' and text()='User Activation']")
	public WebItem emailSubject;

	@FindBy(xpath = "//span[@id='totalMessageCount']")
	public WebItem mailCount;

	@FindBy(xpath = "//div[@id='messagesList']//h3")
	public List<WebItem> mailList;

}
