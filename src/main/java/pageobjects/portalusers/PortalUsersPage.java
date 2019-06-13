package pageobjects.portalusers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobjects.global.AcquirerPortalGlobal;
import utils.Browser;
import utils.WebItem;
import utils.WebPageInit;

public class PortalUsersPage extends WebPageInit {

	public void navigatePortalUserPage() {
		Browser.open(AcquirerPortalGlobal.PORTALUSER_URL);
		newPortalUserButton.exists(5);
	}

	@FindBy(xpath = "//button[contains(text(),'New portal user')]")
	public WebItem newPortalUserButton;	

	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebItem filterButton;

	@FindBy(xpath = "//label[contains(text(),'Names')]")
	public WebItem nameLabel;
	
	@FindBy(id = "Names")
	public WebItem nameFilterOptions;	

	@FindBy(id = "Emails")
	public WebItem emailFilterOptions;	
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebItem OkFilterButton;
	
	@FindBy(xpath = "//div[contains(text(),'Name')]")
	public WebItem nameHeaderinResults;
	
	@FindBy(xpath = "//div[contains(text(),'Email')]")
	public WebItem emailHeaderinResults;
	
	public String portalUserDetailsRowXpath = "";
	
	public WebElement selectElementintheResultsTabel(String text){
		return nameHeaderinResults.getSiblingElementforDynamicallyGeneratedData(text);
	}
	
	
	
	
	public void selectElementintheResultsTabel2(String siblingName, String elementText){
		portalUserDetailsRowXpath = "//*[.='" + siblingName+ "']/following-sibling::*";
		System.out.println(" groupDetailsRowXpath " + portalUserDetailsRowXpath);
		emailHeaderinResults.getSiblingElement(portalUserDetailsRowXpath,elementText);
		
	}
	
	
}
