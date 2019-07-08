package pageobjects.global;

public class AcquirerPortalGlobal {
	public static final String URL = "http://virginia-integration-hiveaqp.s3-website-us-east-1.amazonaws.com/";
	public static final String LOGIN_URL= "" + URL +"login";
	public static final String PORTALUSER_URL = "" + URL + "portalusers";
	public static final String MERCHANTS_URL = "" + URL + "merchants";
	public static final String GROUP_URL = "" + URL + "groups";
	public static final String TRANSACTIONS_URL = "" + URL + "transactions";

	//Email
	public static final String EMAIL_URL = "https://10minutemail.com/10MinuteMail/index.html";
	// Merchant Divisions 
	public static final String GLOBAL_PAYMENTS = "Global Payments";
	public static final String NATIONAL_BANK = "National Bank$";
	public static final String GP_CHARITIES = "GP Charities";

	public static final String CBA_ADMIN_USER_NAME = "Marco";
	public static final String CBA_ADMIN_PASSWORD = "Test123$";

	public static final String ROOT_ADMIN_USER_NAME = "rootadmin";
	public static final String ROOT_ADMIN_PASSWORD = "Mobeewave2015";
	public static final String ROOT_ADMIN_LABEL = "Root Administrator";

	public static final String GP_ADMIN_USER_NAME = "Madura";
	public static final String GP_ADMIN_PASSWORD = "Test123$";
	public static final String GP_ADMIN_LABEL = "GP Admin";

	public static final String GP_NEWADMIN_USER_NAME = "GPNewAdmin";
	public static final String GP_NEWADMIN_NAME = "GP New Admin";
	public static final String GP_NEWADMIN_PASSWORD = "Test123$";
	//public static final String GP_NEWADMIN_EMAIL = "AetMWTest@gmail.com";
	//public static final String GP_NEWADMIN_LABEL = "GPNewAdmin";

	public static final String GP_NEWASUPPORT_NAME = "GP New Support";
	public static final String GP_NEWASUPPORT_USER_NAME = "GPNewSupport";
	public static final String GP_NEWSUPPORT_PASSWORD = "Test123$";
	//public static final String GP_NEWSUPPORT_EMAIL = "AetMWTest2@gmail.com";
	//public static final String GP_NEWSUPPORT_LABEL = "GPNewSupport";

	public static final String MERCHNAT_REGISTRATION_TITLE = "New merchant registration";

	public static String GP_GROUP = "All";

	public static String PORTALUSER_PERMISSION_1 = "Allows user to get the public details of all Portal users";
	public static String PORTALUSER_PERMISSION_2 = "Allows user to create new users";
	public static String PORTALUSER_PERMISSION_3 = "Allows user to modify the accounts of other users";
	public static String PORTALUSER_PERMISSION_4 = "Allows user to delete the accounts of other users";
}