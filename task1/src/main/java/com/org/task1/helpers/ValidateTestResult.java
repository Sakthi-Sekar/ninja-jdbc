package com.org.task1.helpers;

import org.testng.Assert;

public class ValidateTestResult {

	public static boolean validateData(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}

}
