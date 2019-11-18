package com.org.task1.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.org.task1.constants.ConstantPaths;
import com.org.task1.helpers.PageAction;
import com.org.task1.helpers.PageActions;
import com.org.task1.helpers.ReadPropertiesFile;
import com.org.task1.helpers.ValidateTestResult;
import com.org.task1.reports.LogReports;
import com.org.task1.testbase.InvokeBrowser;

public class Homepage extends InvokeBrowser {
	String url, Xpath, exptd;
	PageAction page;
	WebElement Css, inputElement;
	ReadPropertiesFile read;

	@Test(priority = 1)
	public void clickSearchButton() {
		page = new PageAction(driver);
		read = new ReadPropertiesFile();
		// click on search button
		page.click(read.readPropertiesFile("loc.search.xpath", ConstantPaths.LOCATORS_FILE));
		log.info("clicked on the search field");
		// page title validation
//		Xpath = read.readPropertiesFile("loc.validate.title.xpath", ConstantPaths.LOCATORS_FILE);
//		String actualtext = driver.findElement(By.xpath(Xpath)).getText();
//		String exptext = read.readPropertiesFile("exptext", ConstantPaths.LOCATORS_FILE);
//		ValidateTestResult.validateData(actualtext, exptext, "No match");
//		System.out.println(actualtext);
//		log.info("Match found");

	}
}
