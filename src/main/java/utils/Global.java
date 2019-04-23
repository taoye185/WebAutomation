package utils;

public class Global {

    // Supported Browsers
    public static final String CHROME = "Chrome";
    public static final String INTERNET_EXPLORER = "IntenetExplorer";

    // Configurations
    public static final String BROWSER = System.getenv("GBL_WEB_BROWSER") != null ? System.getenv("GBL_WEB_BROWSER")
            : CHROME;

    // Timers
    public static final int DEFAULT_EXPLICIT_WAIT = 5;
    public static final int DEFAULT_IMPLICIT_WAIT = 10;
    public static final int DEFAULT_AJAX_WAIT = 10;
    public static final int DEFAULT_PAGE_LOAD_TIME = 60;
}