package com.wallethub.assignment_1.FacebookObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class FacebookHomePageObject extends BaseClass{

	public FacebookHomePageObject(WebDriver driver) {
        this.driver = driver;     
        PageFactory.initElements(driver, this);
}
	
	
	@FindBy(xpath="//*[@aria-label='Create a post']")
	public WebElement postRegion;
	
	
	@FindBy(tagName="textarea")
	public WebElement statusBox;
	
	@FindBy(css="[data-testid='react-composer-post-button']")
	public WebElement post;
	
	
	@FindBy(id="logoutMenu")
	public WebElement logoutMenu;
	
	@FindBy(xpath="//*[text()='Log out']")
	public WebElement Logout;
	
	@FindBy(xpath="//*[@class='timestampContent' and text()='Just Now']")
	public WebElement latestpost;
	
	@FindBy(xpath="(//div[contains(@class,'userContent ')]/div/p)[1]")
	public WebElement latestposttext;
	
	
	
	
	
}
