package pageobjects.merchants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebItem;
import utils.WebPageInit;

public class MerchantsPage extends WebPageInit{

	//@FindBy(linkText = "Madura")
	//public WebItem userLink;	
	
	
	public WebItem userLink;
	
	public void inituserLink(String text){
	String xpath = "//a[contains(text(),'"+text+"')]";
	userLink = new WebItem(By.xpath(xpath));
	}

}
