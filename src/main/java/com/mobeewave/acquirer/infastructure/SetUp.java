package com.mobeewave.acquirer.infastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.mobeewave.acquirer.utils.DataReader;

import cucumber.api.java.After;

public class SetUp {

	private static WebDriver driver;
	private static String configPrpoertiesFileURL = "resources/config.properties";
	private static String pageObjectsPrpoertiesFileURL;
	private static String browser_GBL = System.getProperty("browser");
	private static String client_GBL = System.getProperty("client");

	/// <summary>
	/// This method set driver with client and browser
	/// </summary>
	/// <param name="client">client need to setup </param>
	/// <param name="browser">browser need to setup</param>
	/// <returns>WebDriver</returns>

	public static WebDriver setupDriver(String client, String browser) {

		String driverPath = "";
		String baseUrl = "";
		init();
		System.out.println("\n Setting up driver ..................\n");

		switch (browser) {
		case "chrome":
			driverPath = DataReader.readProperty(configPrpoertiesFileURL, "chrome.driver.path");
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			// Set Chrome Options and set Headless mode as true
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			//chromeOptions.addArguments("--headless");

			// Instantiate Chrome Web Driver
			driver = new ChromeDriver(chromeOptions);
			System.out.println("Chrome Driver setup successfull.. ");

			// driver.get("http://www.google.com");
			break;

		case "firefox":
			driverPath = DataReader.readProperty(configPrpoertiesFileURL, "firefox.driver.path");
			System.setProperty("webdriver.gecko.driver", driverPath);
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);

			// Instantiate FireFox Web Driver
			driver = new FirefoxDriver(options);
			System.out.println("FireFox Driver setup successfull.. ");
			break;
		}

		switch (client) {
		case "CBA":
			client_GBL = "CBA";

			baseUrl = DataReader.readProperty(configPrpoertiesFileURL, "CBAbaseURL");
			System.out.println("CLIENT IS " + client_GBL + " ...... " + baseUrl);
			break;

		case "":
			client_GBL = "CBA";
			baseUrl = DataReader.readProperty(configPrpoertiesFileURL, "CBAbaseURL");
			System.out.println("CLIENT IS " + client_GBL + " ...... " + baseUrl);
			break;

		case "ABC":
			client_GBL = "ABC";
			System.out.println("CLIENT IS " + client_GBL + " ...... ");
			// implement pageIdentifer class extend Page Class for custom
			// changes
			baseUrl = DataReader.readProperty(configPrpoertiesFileURL, "ABCbaseURL");
			break;

		}

		driver.get(baseUrl);
		System.out.println("User navigate to URL " + baseUrl + "is successfull.. " + driver.getTitle());

		// driver.manage().window().maximize();

		return driver;

	}

	/// <summary>
	/// This method set browser
	/// </summary>
	/// <param name="br">browser need to setup </param>
	/// <returns>String/returns>
	public static String setupBrowser(String br) {

		try {

			switch (br) {

			case "chrome":
				// setupDriver("CBA", "chrome");
				browser_GBL = "chrome";
				System.out.println("BROWSER " + br + " setup  ...... ");
				break;

			case "firefox":
				// setupDriver("CBA", "firefox");
				browser_GBL = "firefox";
				System.out.println("BROWSER " + br + " setup  ...... ");
				break;
			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION  " + " Browser setup failed ...... ");
			System.out.println("====================    " + ex.getMessage() + "   =============================");
		}
		return browser_GBL;
	}

	/// <summary>
	/// This method set client
	/// </summary>
	/// <param name="clnt">client need to setup </param>
	/// <returns>String/returns>
	public static String setupClient(String clnt) {

		try {
			switch (clnt) {
			case "CBA":
				// setupDriver("CBA", "chrome");
				client_GBL = "CBA";
				pageObjectsPrpoertiesFileURL = "resources/CBAPageObjects.properties";
				System.out.println("CLIENT IS " + clnt + " ...... ");
				break;

			case "":
				// setupDriver("CBA", "firefox");
				client_GBL = "CBA";
				pageObjectsPrpoertiesFileURL = "resources/CBAPageObjects.properties";
				System.out.println("BROWSER " + clnt + " setup  ...... ");
				break;
			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION  " + " Client setup failed ...... ");
			System.out.println("====================    " + ex.getMessage() + "   =============================");
		}
		return client_GBL;
	}

	/// <summary>
	/// This method set driver null if it found a driver instant.
	/// </summary>
	/// <returns></returns>

	public static void init() {
		WebDriver _driver = getDriver();
		try {
			if (_driver == null) {
				return;
			}
			if (_driver != null) {
				teardown();

			}
		} catch (Exception ex) {
			System.out.println("EXCEPTION  " + " Driver quit failed ...... ");
			System.out.println("====================    " + ex.getMessage() + "   =============================");
		}

	}

	/// <summary>
	/// This method to get browser. If browser is not Chrome or Firefix, then
	/// it defaults to Chrome.
	/// </summary>
	/// <returns>String/returns>
	public static String getBrowser() {
		
		if ((browser_GBL == null)) {
			System.out.println(" =====browser is set to chrome ===========");
			return browser_GBL = "chrome";
		}

		if (!(browser_GBL.equalsIgnoreCase("chrome") || browser_GBL.equalsIgnoreCase("firefox"))) {
			System.out.println("======browser is set to chrome ===========");
			return browser_GBL = "chrome";
		}
		System.out.println("======browser is   " + browser_GBL + "   =============");
		return browser_GBL;
	}

	/// <summary>
	/// This method use to get client
	/// </summary>
	/// <returns>String/returns>
	public static String getClient() {
		if (client_GBL == null)
			return client_GBL = "CBA";
		return client_GBL;
	}

	/// <summary>
	/// This method use to get page object prpoerty file
	/// </summary>
	/// <returns>String/returns>
	public static String getpageObjectsPropertyfileURL() {
		return pageObjectsPrpoertiesFileURL;
	}

	/// <summary>
	/// This method use to get driver
	/// </summary>
	/// <returns>String/returns>
	public static WebDriver getDriver() {
		return driver;
	}

	/// <summary>
	/// This method use to navigate to a given URL
	/// </summary>
	/// <param name="url">url need to navigate </param>
	/// <returns>String/returns>
	public void navigateToURL(String url) {
		driver.get(url);
	}

	/// <summary>
	/// This method use to quit and make driver null for tests tagged as
	/// @independentTest
	/// </summary>
	/// <returns>String/returns>

	@After("@independentTest")
	public static void teardown() {
		try {
			WebDriver _driver = getDriver();
			if (_driver == null) {
				return;
			}
			_driver.quit();
			_driver = null;
			System.out.println("\n closing browser and Quit driver..................\n");
		} catch (Exception ex) {
			System.out.println("====================    " + ex.getMessage() + "   =============================");
			System.out.println("Driver quit failed ...... ");
		}
	}

}
