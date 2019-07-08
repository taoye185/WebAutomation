package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	private static Browser browser;
	private static WebDriver driver;

	public static Browser getBrowser() {
		return browser;
	}

	public static void setBrowser(Browser browser) {
		Browser.browser = browser;
	}

	private void setDriver(WebDriver driver) {
		Browser.driver = driver;
		setPageLoadTime(Global.DEFAULT_IMPLICIT_WAIT);

		Browser.driver.manage().window().maximize();

	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setBrowser(new Browser(Global.BROWSER));
		}
		return driver;
	}

	public Browser(String browserType) {

		Log.info("Creating an instance of a " + browserType + " browser");

		switch (browserType) {
		case Global.CHROME: {
			WebDriverManager.chromedriver().setup();
			// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			// capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
			// "true");
			// ChromeOptions options = new ChromeOptions();
			// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			// options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
			// "true");
			this.setDriver(new ChromeDriver());
		}
			break;
		case Global.FIREFOX: {
			WebDriverManager.firefoxdriver().setup();
			this.setDriver(new FirefoxDriver());
		}
			break;
		case Global.INTERNET_EXPLORER:
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			this.setDriver(new InternetExplorerDriver(options));
			break;

		}
	}

	public static void refresh() {
		Log.info(String.format("Refreshing the Browser url"));
		getDriver().navigate().refresh();
	}

	public static void open(String url, int currentPageLoadWaitTime) {
		setPageLoadTime(currentPageLoadWaitTime);
		try {
			Log.info(String.format("Opening %s url", url));
			getDriver().get(url);
			refresh();

		} catch (TimeoutException ignored) {
		}
		setPageLoadTime(Global.DEFAULT_IMPLICIT_WAIT);
	}

	/**
	 * This method is useful to for Browser top sleep
	 * 
	 * @para time- time to pause browser in millisecond
	 **/
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setPageLoadTime(int pageLoadWaitTime) {
		Log.info(String.format("Setting page load time to %s seconds", pageLoadWaitTime));
		driver.manage().timeouts().pageLoadTimeout(pageLoadWaitTime, TimeUnit.SECONDS);
	}

	public static void setWaitTime(int waitTime) {
		Log.info(String.format("Setting implicit wait time to %s seconds", waitTime));
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public static boolean dynamicElementExists(By by, int seconds) {
		Log.info(String.format("Checking if '%s' text locator exists on the page withing %s seconds", by.toString(),
				seconds));
		try {
			(new WebDriverWait(getDriver(), seconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (TimeoutException ignored) {
		}
		return false;
	}

	public static boolean textExists(String text, int seconds) {
		Log.info(String.format("Checking if '%s' text exists on the page withing %s seconds", text, seconds));
		return dynamicElementExists(By.xpath("//*[contains(text(),'" + text + "')]"), seconds);
	}
}
