package pageobjects.email;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class EmailPage extends WebPageInit{

	@FindBy(id = "mailAddress")
	public WebItem mailAddress;

	
	
	@FindBy(id = "messagesList")
	public WebItem mailList;
	
	/*<span class="inc-mail-address">support@mobeewave.com</span>
	<span class="inc-mail-date">Jun 19, 2019 1:07:20 PM</span>
	<span class="inc-mail-subject">User Activation</span>*/
	
	
}
