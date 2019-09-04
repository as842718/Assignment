package com.wallethub.assignment_2.WallethubComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;
import com.wallethub.assignment_2.WallethubObject.WallethubHomePageObject;
import com.wallethub.assignment_2.WallethubObject.WallethubReviewPageObject;

public class WallethubComponent extends BaseClass {

	final static Logger logger = Logger.getLogger(WallethubComponent.class);

	public static void hover(WebElement element) {

		WallethubHomePageObject homeobject = new WallethubHomePageObject(driver);
		Actions builder = new Actions(driver);
		Action mousehover = builder.moveToElement(element).build();
		mousehover.perform();

	}

	public static boolean hoverOverRatingStar() throws InterruptedException {

		boolean ispass = false;
		WallethubHomePageObject homeobject = new WallethubHomePageObject(driver);
		Actions builder = new Actions(driver);
		for (int i = 1; i <= 5; i++) {
			WebElement element = driver.findElement(By.xpath(String.format(homeobject.ratingStar, i)));
			Action mousehover = builder.moveToElement(element).build();
			mousehover.perform();
			logger.info("hover done element " + element);

			if (i == 5 && homeobject.ratinghover.size() == 5) {
				element.click();
				ispass = true;
				waitForJStoLoad();
				logger.info("click on " + i + " rating ");

			}

		}

		return ispass;
	}

	public static void waitForSpinner() throws InterruptedException {

		WallethubReviewPageObject reviewPage = new WallethubReviewPageObject(driver);

		try {
			while (reviewPage.spinner.isDisplayed()) {
				Thread.sleep(1000);
				logger.info("Loading..");

			}
		} catch (Exception e) {
			logger.info("spinner not present");
		}
	}

	public String getfileText() throws IOException {

		String everything;
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("ReviewComment.txt").getPath();
		logger.info(path);
		File file = new File(path);

		FileInputStream inputStream = new FileInputStream(file);
		try {
			everything = IOUtils.toString(inputStream);
		} finally {
			inputStream.close();
		}

		logger.info("Getting text from file in resource folder");

		// logger.info(everything);

		return everything;

	}

	public static boolean waitForJStoLoad() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		final JavascriptExecutor js = (JavascriptExecutor) driver;

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) js.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		Thread.sleep(5000);
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return js.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

}
