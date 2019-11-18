package com.org.task1.testscripts;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.task1.constants.ConstantPaths;
import com.org.task1.helpers.PageAction;
import com.org.task1.helpers.PageActions;
import com.org.task1.helpers.ReadExcelData;
import com.org.task1.helpers.ReadPropertiesFile;
import com.org.task1.helpers.ValidateTestResult;
import com.org.task1.testbase.InvokeBrowser;

public class CartActions extends Homepage {
	String Xpath, exptd;
	String Css;
	WebElement inputElement;
	PageAction page;
	ReadPropertiesFile read;
	static String menuName;

	@BeforeTest
	public static void dataBaseReader() throws SQLException, ClassNotFoundException {
		java.sql.Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// This will load the MySQL driver, each DB has its own driver
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ASSESSMENT1?user=root&password=sakthi17@AKS");
		// Statements allow to issue SQL queries to the database
		statement = connect.createStatement();
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery("select * from NINJA");
		while (resultSet.next()) {

			menuName = resultSet.getString("NAME");

			System.out.println(menuName);
		}
	}

	@Test
	public void enterData() {
		page = new PageAction(driver);
		read = new ReadPropertiesFile();
		// clear the search field
		Xpath = read.readPropertiesFile("loc.search.xpath", ConstantPaths.LOCATORS_FILE);
		inputElement = page.selectLocators(Xpath);
		inputElement.clear();

		// pass value through data provider
		Xpath = read.readPropertiesFile("loc.search.xpath", ConstantPaths.DATA_FILE);
		page.selectLocators(Xpath).sendKeys(menuName);

		// hit search

		page.click(read.readPropertiesFile("loc.button.search.xpath", ConstantPaths.LOCATORS_FILE));
		// click on iphone link

		page.click(read.readPropertiesFile("loc.clickimg.css", ConstantPaths.LOCATORS_FILE));

//		// validate availability
//
//		Css = read.readPropertiesFile("loc.iphone.availability.css", ConstantPaths.LOCATORS_FILE);
//		String actavailabilty = page.selectLocators(Css).getText();
//		ValidateTestResult.validateData(actavailabilty, in[1], "No match");
//		log.info("Availability:In stock");
//
//		// validate price
//		Css = read.readPropertiesFile("loc.iphone.price.css", ConstantPaths.LOCATORS_FILE);
//		String actprice = page.selectLocators(Css).getText();
//		ValidateTestResult.validateData(actprice, in[2], "No match");
//		log.info("Product price");
//
//		// validate Ex.Tax
//		Css = read.readPropertiesFile("loc.iphone.extax.css", ConstantPaths.LOCATORS_FILE);
//		String acttax = page.selectLocators(Css).getText();
//		ValidateTestResult.validateData(acttax, in[3], "No match");
//		log.info("Ex Tax");
//
//		// validate description
//
//		Css = read.readPropertiesFile("loc.description.css", ConstantPaths.LOCATORS_FILE);
//		String actintro = page.selectLocators(Css).getText();
//		System.out.println();
//		ValidateTestResult.validateData(actintro, in[4], "No match");
//		log.info("Description");
//
//		// increase QTY
//
//		page.click(read.readPropertiesFile("loc.click.qty.xpath", ConstantPaths.LOCATORS_FILE));
//		page.selectLocators("loc.click.qty.xpath").clear();
//		page.selectLocators("loc.click.qty.xpath").sendKeys(in[5]);
//		page.click(read.readPropertiesFile("loc.button.click.addtocart.xpath", ConstantPaths.LOCATORS_FILE));
//
//		// click on cart symbol
//		page.click(read.readPropertiesFile("loc.validate.clickoncart.afteradd.css", ConstantPaths.LOCATORS_FILE));
//
//		// click view cart
//		page.click(read.readPropertiesFile("loc.viewcartbtn.click.css", ConstantPaths.LOCATORS_FILE));
	}

//	@Test(priority = 3)
//	public void validateCartAfterAdd() {
//
//		// validate each cart items-product 1
//		Xpath = read.readPropertiesFile("loc.verify.nameaftradd.iphone.xpath", ConstantPaths.LOCATORS_FILE);
//		String actproduct1 = page.selectLocators(Xpath).getText();
//		String exptproduct1 = read.readPropertiesFile("exppro1", ConstantPaths.LOCATORS_FILE);
//		ValidateTestResult.validateData(actproduct1, exptproduct1, "No match");
//		log.info("Product1");
//
//		// product 2
//		Xpath = read.readPropertiesFile("loc.verify.nameaftradd.mac.xpath", ConstantPaths.LOCATORS_FILE);
//		String actproduct2 = page.selectLocators(Xpath).getText();
//		String exptproduct2 = read.readPropertiesFile("exppro2", ConstantPaths.LOCATORS_FILE);
//		ValidateTestResult.validateData(actproduct2, exptproduct2, "No match");
//		log.info("Product2");
//
//		// grand total after adding products
//		Xpath = read.readPropertiesFile("loc.verify.grandtotal.aftradd.xpath", ConstantPaths.LOCATORS_FILE);
//		String actgrandadd = page.selectLocators(Xpath).getText();
//		String exptgrandadd = read.readPropertiesFile("expgrandadd", ConstantPaths.LOCATORS_FILE);
//		ValidateTestResult.validateData(actgrandadd, exptgrandadd, "No match");
//		log.info("Grand total after adding products");
////
//	}

//	@Test(priority = 4)
//	public void validateAfterRemove() {
////		// Css = read.readPropertiesFile("removebutton", ConstantPaths.LOCATORS_FILE);
//		page.click(read.readPropertiesFile("loc.removebutton.css", ConstantPaths.LOCATORS_FILE));
//		System.out.println("REMOVE");
////		// PageActions.clickElement(driver, Css);
////
//		// validate grand after removal of one product
//		Xpath = read.readPropertiesFile("loc.verify.grandtotal.aftrremove.xpath", ConstantPaths.LOCATORS_FILE);
//		String actgrandremove = page.selectLocators(Xpath).getText();
////		// String actgrandremove = driver.findElement(By.xpath(Xpath)).getText();
//		String exptgrandremove = read.readPropertiesFile("expgrandremove", ConstantPaths.LOCATORS_FILE);
//		ValidateTestResult.validateData(actgrandremove, exptgrandremove, "No match");
//		log.info("Grand total after removal of one product");
//	}
////
////	@Test(priority = 6)
////	public void negativeTestCase() {
////		Xpath = read.readPropertiesFile("loc.search.xpath", ConstantPaths.LOCATORS_FILE);
////		PageActions.clickElement(driver, Css);
////		String invalidinput = read.readPropertiesFile("invalidname", ConstantPaths.LOCATORS_FILE);
////		driver.findElement(By.xpath(Xpath)).sendKeys(invalidinput);
////		System.out.println(invalidinput);
////		// validate negative test case output
////
////		Xpath = read.readPropertiesFile("loc.negoutput.xpath", ConstantPaths.LOCATORS_FILE);
////		String actoutput = driver.findElement(By.xpath(Xpath)).getText();
////		String expoutput = read.readPropertiesFile("invalidout", ConstantPaths.LOCATORS_FILE);
////		ValidateTestResult.validateData(actoutput, expoutput, "No match");
////		System.out.println(actoutput);
////
////	}

}
