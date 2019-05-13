package utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebItem implements WebElement {

    public By locator;
    private WebElement element;
    private WebItem item;

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        Log.info("Getting screenshot");
        return this.getActiveItem().getScreenshotAs(target);
    }

    @Override
    public void click() {
        Log.info("Clicking on '" + locator.toString() + "'");
        getActiveItem().click();
    }

    @Override
    public void submit() {
        Log.info(String.format("Submitting %s", locator.toString()));
        this.getActiveItem().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        Log.info(String.format("Sending %s to the %s", keysToSend.toString(), locator.toString()));
        this.getActiveItem().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        Log.info("Clearing '" + locator.toString() + "'");
        this.getActiveItem().clear();
    }

    @Override
    public String getTagName() {
        Log.info(String.format("Getting tag name from %s", locator.toString()));
        return this.getActiveItem().getTagName();
    }

    @Override
    public String getAttribute(String attributeName) {
        Log.info(String.format("Getting attribute %s from %s", attributeName, locator.toString()));
        return this.getPassiveItem().getAttribute(attributeName);
    }

    @Override
    public boolean isSelected() {
        Log.info(String.format("Check if %s is selected", locator.toString()));
        return this.getActiveItem().isSelected();
    }

    @Override
    public boolean isEnabled() {
        boolean out = this.getPassiveItem().isEnabled();
        Log.info("'" + locator.toString() + "' isEnabled verification: Enabled = " + out);
        return out;
    }

    @Override
    public String getText() {
        String textOut = this.getPassiveItem().getText();
        Log.info("Getting text from '" + locator.toString() + "'. ActualText = " + textOut);
        return textOut;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.getActiveItem().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.getActiveItem().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        boolean out = this.getPassiveItem().isDisplayed();
        Log.info("'" + locator.toString() + "' isDisplayed verification: Displayed = " + out);
        return out;
    }

    @Override
    public Point getLocation() {
        Log.info(String.format("Getting location of %s", locator.toString()));
        return this.getActiveItem().getLocation();
    }

    @Override
    public Dimension getSize() {
        Log.info(String.format("Getting size of %s", locator.toString()));
        return this.getActiveItem().getSize();
    }

    @Override
    public Rectangle getRect() {
        Log.info(String.format("Getting rectangle of %s", locator.toString()));
        return this.getActiveItem().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        Log.info(String.format("Getting css value of %s from %s", propertyName, locator.toString()));
        return this.getActiveItem().getCssValue(propertyName);
    }

    private WebElement getItem(int seconds, ExpectedCondition<WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), seconds);
        element = wait.until(condition);
        return element;
    }

    protected WebElement getActiveItem() {
        return getItem(Global.DEFAULT_EXPLICIT_WAIT, ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement getPassiveItem() {
        return getItem(Global.DEFAULT_EXPLICIT_WAIT, ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebItem(By byID) {
        locator = byID;
    }

    public boolean exists(int... waitTime) {
        int waitValue = waitTime.length == 0 ? 0 : waitTime[0];
        boolean result = false;
        try {
            result = getItem(waitValue, ExpectedConditions.presenceOfElementLocated(locator)) != null;
        } catch (Exception ignored) {
        }
        Log.info("'" + locator.toString() + "' existence verification. Exists = " + result);
        return result;
    }

    /**
     * This method is useful to select one option from drop down list by option text
     * 
     * @para visibleText- text that is used select an option
     **/

    public void select(String visibleText) {
        Log.info("Selecting '" + visibleText + "' in the '" + this.locator.toString() + "' drop down list");
        Select userTypeDropdown = new Select(this.getActiveItem());
        userTypeDropdown.selectByVisibleText(visibleText);
    }

    /**
     * This method is useful to select one item from drop down list
     * 
     * @para text-select option from drop down list with this associated text
     **/

    public void selectDropDownItem(String text) {
        Log.info("Selecting value -'" + text + "' in the '" + this.locator.toString() + "' drop down list");
        String valueOfXpath = "//*[contains(text(),'" + text + "')]";
        getActiveItem().click();// drop down list.
        WebElement element = getItem(Global.DEFAULT_EXPLICIT_WAIT,
                ExpectedConditions.presenceOfElementLocated(By.xpath(valueOfXpath)));
        // JavascriptExecutor javascriptExecutor = (JavascriptExecutor)
        // Browser.getDriver();
        // javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",
        // element);
        element.click(); // element to select from drop down list.

    }

    /**
     * This method is useful to view the hidden elements
     * 
     **/

    public void scrollIntoView() {
        Log.info(String.format("Scrolling into view %s", locator.toString()));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Browser.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getPassiveItem());
    }

    /**
     * This method is useful to select one option from drop down list by option
     * index
     * 
     * @para index- selecting the drop down option by index
     **/
    public void select(int index) {
        Log.info("Selecting index-'" + index + "' in the '" + this.locator.toString() + "' drop down list");
        Select dropDown = new Select(this.getActiveItem());
        dropDown.selectByIndex(index);
    }

    /**
     * This method is useful to select one option from drop down list by option
     * value
     * 
     * @para value- selecting the drop down option by value
     **/
    public void selectByValue(String value) {
        Log.info("Selecting value -'" + value + "' in the '" + this.locator.toString() + "' drop down list");
        Select dropDown = new Select(this.getActiveItem());
        dropDown.selectByValue(value);
    }

    @SuppressWarnings("rawtypes")
    public static List getDropdownOptions(Select dropdown) {
        List<WebElement> options = new ArrayList();
        options = dropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement a = (WebElement) options.get(i);
            Log.info("Select Option " + i + " " + a.getText());
        }
        return options;
    }

	@SuppressWarnings("rawtypes")
	public List getChildElementsintoList(String xpath) {
		List<WebElement> parentElementList = new ArrayList();
		parentElementList = findElements(By.xpath(xpath + "/.//*"));
		for (int i = 0; i < parentElementList.size(); i++) {
			WebElement a = (WebElement) parentElementList.get(i);
			Log.info("element " + i + a.getText() + a.getLocation());
		}
		return parentElementList;
	}

	@SuppressWarnings("rawtypes")
	public List getChildElementsintoList() {
		List<WebElement> parentElementList = new ArrayList();
		parentElementList = findElements(By.xpath("/.//*"));
		for (int i = 0; i < parentElementList.size(); i++) {
			WebElement a = (WebElement) parentElementList.get(i);
			Log.info("element " + i + a.getText() + a.getLocation());
		}
		return parentElementList;
	}
	
    public static void enter() {
		try {
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(200);
		}catch(Exception e){
			
		}
	}
}
