package utils;

import pageobjects.global.AcquirerPortalGlobal;


public class CommonUtils {
	public static String username_GBL = "";
	public static String password_GBL = "";
	public static String userLabel_GBL = "";
	
	public static void setUpUsers(String username) {		
		switch (username) {
		case "GP_Admin":
			username_GBL = AcquirerPortalGlobal.GP_ADMIN_USER_NAME;
			password_GBL= AcquirerPortalGlobal.GP_ADMIN_PASSWORD;
			userLabel_GBL=AcquirerPortalGlobal.GP_ADMIN_LABEL;
			break;
		case "Root_Admin":
			username_GBL = AcquirerPortalGlobal.ROOT_ADMIN_USER_NAME;
			password_GBL= AcquirerPortalGlobal.ROOT_ADMIN_PASSWORD;
			userLabel_GBL = AcquirerPortalGlobal.ROOT_ADMIN_LABEL;
			break;
		}
	}
}

