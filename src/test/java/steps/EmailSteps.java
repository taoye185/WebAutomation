package steps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import acquirerportal.pageobjects.email.EmailPage;
import coreutils.Browser;
import acquirerportal.CommonUtils;
import coreutils.Log;

public class EmailSteps {

	public static EmailPage emailPage = new EmailPage();
	public static String tempEmailPassword = "";
	public static String tempUserID = "";

	/**
	 * Getting the credentials from user activation email 
	 */
	public static void getPortalUserCredentials() {
		Log.info("Looking for the User Activation - waiting 30 seconds ");
		Browser.sleep(30000);
		emailPage.emailSubject.scrollIntoView();
		emailPage.emailSubject.click();
		Browser.sleep(1000);
		emailPage.portalUserNameText.scrollIntoView();
		tempUserID = emailPage.portalUserNameText.getText();
		tempEmailPassword = emailPage.portalUserPasswordText.getText();
		if(tempEmailPassword.equalsIgnoreCase("")) { // retry capturing password due to 10minutes mail issue 
			Log.info(" retry password capturing ");
			emailPage.portalUserNameText.scrollIntoView();
			tempUserID = emailPage.portalUserNameText.getText();
			tempEmailPassword = emailPage.portalUserPasswordText.getText();
		}
		Log.info(" password is " + tempEmailPassword);
	}
	

	@Given("^Find email by \"([^\"]*)\"$")
	public static void find_email_by(String subject) throws Throwable {
		Log.info("Please send a mail");
		Browser.sleep(40000);
		Log.info("Checking for mails to " + CommonUtils.tempEmail);
		List<WebElement> elements = emailPage.messageList.getAllTheElementsOfTheList("//h3");
		for (int i = 0; i < elements.size(); i++) {
			Log.info("Subject = " + elements.get(i).findElement(By.xpath("//span[@class='inc-mail-subject']")));
		}
	}

}
