package com.mobeewave.acquirer.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mobeewave.acquirer.infastructure.SetUp;
import com.mobeewave.acquirer.utils.CommonUtils;

public class GmailPage extends BasePage{

	public static final String emailField_xpath = "//input[@id='identifierId']" ; 
	public static final String passwordField_xpath = "//*[@id='password']/div[1]/div/div[1]/input";
	public static final String emailThreads_xpath= "//span[@class='bog']";
	public static final String profileLogo_xpath="//span[@class='gb_bb gbii']";
	

	
	public static WebElement emailTextBox(){
		return CommonUtils.IsElementSelectable(By.xpath(emailField_xpath), 20);
	}
	
	public static WebElement passwordTextBox(){
		return CommonUtils.IsElementSelectable(By.xpath(passwordField_xpath), 20);
	}
	
	public static WebElement emailThread(){
		return CommonUtils.IsElementSelectable(By.xpath(emailThreads_xpath), 20);
	}

	public static WebElement portfolioLogo(){
		return CommonUtils.IsElementSelectable(By.xpath(profileLogo_xpath), 20);
	}

	//List<WebElement> emailThreads;

	 

	public void enterEmail(String emailID)
	{
		
		Actions actions=new Actions(SetUp.getDriver());
		actions.moveToElement(emailTextBox());
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");	
	}
	
	public void enterPassword(String password)
	{
		Actions actions=new Actions(SetUp.getDriver());
		actions.moveToElement(passwordTextBox());
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		System.out.println("Password entered");
	}
	
	public void clickEmail(String emailSubject)
	{
		List<ArrayList> listtemp = CommonUtils.getChildElements(emailThread());
		for (int i = 0; i < listtemp.size(); i++) {
			
			if (((WebElement) listtemp.get(i)).getText().contains(emailSubject)) {
				((WebElement) listtemp.get(i)).click();
				System.out.println("email clicked");
				break;
			}
		}
	}
	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
