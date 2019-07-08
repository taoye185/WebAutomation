package pageobjects.login;

import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class ChangePasswordPage extends WebPageInit {


	@FindBy(id = "oldPassword")
	public WebItem oldPasswordTxtBox;
	
	@FindBy(id = "newPassword")
	public WebItem newPasswordTxtBox;
	
	@FindBy(id = "confirmNewPassword")
	public WebItem confirmNewPasswordTxtBox;
	
	@FindBy(xpath = "//button[contains(text(),'Change password')]")
	public WebItem changePasswordButton;
	
	@FindBy(xpath = "//h4[contains(text(),'Change password')]")
	public WebItem changePasswordLabel;
}
