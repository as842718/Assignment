package com.wallethub.assignment_1.FacebookTestScript;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;
import com.wallethub.assignment_1.FacebookComponent.FacebookComponents;
import com.wallethub.assignment_1.FacebookObject.FacebookHomePageObject;
import com.wallethub.assignment_1.FacebookObject.FacebookLoginPageObject;

public class FacebookAutomate extends BaseClass {

	final static Logger logger = Logger.getLogger(FacebookAutomate.class);

	@Test(priority = 1, dataProvider = "Testdata")
	public void postMessage(String id, String password) throws InterruptedException {
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		FacebookHomePageObject homePage = new FacebookHomePageObject(driver);
		FacebookLoginPageObject loginPage = new FacebookLoginPageObject(driver);

		logger.info("Initialize driver for homePage , LoginPage");

		logger.info(" Test ID : " + id);

		logger.info("Test Password : " + password);

		// Login into facebook

		loginPage.loginId.clear();

		loginPage.loginId.sendKeys(id);

		loginPage.loginPassword.sendKeys(password);

		loginPage.Submit.click();
		
		logger.info("Login event done");

		String actualpost = "Hello :)  World :)";

		wait.until(ExpectedConditions.visibilityOf(homePage.postRegion));

		// Check for message box
		if (homePage.postRegion.isDisplayed()) {

			homePage.statusBox.sendKeys(actualpost);

			// Post message
			homePage.post.click();

			logger.info("New message post to time line");

			wait.until(ExpectedConditions.visibilityOf(homePage.latestposttext));

			FacebookComponents.waitForPost();

			// Log Out
			homePage.logoutMenu.click();

			homePage.Logout.click();

			// Validation point - 1 (Check for page title)
			Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "LogOut Test Fail");

			logger.info("User Log Out");

		}

	}

	// Test Data
	@DataProvider(name = "Testdata")
	public static Object[][] credentials(Method m) {

		// The number of times data is repeated, test will be executed the same

		// Test Data {login ID , Password}

		return new Object[][] {
			
				//Test data ...
			
				{ "dakari.kalani@zebra.email", "qwert%54321" },

		};

	}
}
