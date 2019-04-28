package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebItem implements WebElement {

    public By locator;
    private WebElement element;

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
}
