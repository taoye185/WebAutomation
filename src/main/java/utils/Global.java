package utils;

public class Global {

    // Supported Browsers
    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "FireFox";
    public static final String INTERNET_EXPLORER = "IntenetExplorer";    
    public static String browserType;

    
    // Configurations
    public static final String BROWSER = System.getProperty("GBL_WEB_BROWSER") != null ? System.getProperty("GBL_WEB_BROWSER")
            : CHROME;
    public static final String CLIENTIDENTIFIER = System.getProperty("CLIENT") != null ? System.getProperty("CLIENT")
            : "GP"; 
    

    // Timers
    public static final int DEFAULT_EXPLICIT_WAIT = 5;
    public static final int DEFAULT_IMPLICIT_WAIT = 10;
    public static final int DEFAULT_AJAX_WAIT = 10;
    public static final int DEFAULT_PAGE_LOAD_TIME = 60;
    
    
    

}