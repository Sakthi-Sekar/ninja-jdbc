package com.org.task1.testbase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.task1.constants.ConstantPaths;
import com.org.task1.helpers.PageAction;
import com.org.task1.helpers.ReadPropertiesFile;
import com.org.task1.helpers.ValidateTestResult;
import com.org.task1.reports.LogReports;

public class InvokeBrowser {
	String url;
	public static WebDriver driver;
	Properties config = new Properties();
	public static LogReports log = new LogReports();
	public static ValidateTestResult validate = new ValidateTestResult();
	PageAction action = new PageAction(driver);
	public static ReadPropertiesFile read = new ReadPropertiesFile();

//Invoke IE browser
	@BeforeTest
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
		// driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		url = read.readPropertiesFile("url", ConstantPaths.CONFIG_FILE);
		System.out.println("sakthi");
		driver.get(url);
		driver.manage().window().maximize();
		log.info("Application is open...");
		driver.manage().window().maximize();
		log.info("Browser opened");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}