package com.badandbath.webdriver.utils;

import java.util.ResourceBundle;

/**
 * this class reads values from config.properties file.
 * @author Satheesh Kumar
 *
 */
public class PropertyUtil {

	static ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static String getValue(String key) {
		return bundle.getString(key);
	}

}
