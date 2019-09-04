package com.wallethub.assignment_1.FacebookObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class FacebookLoginPageObject extends BaseClass {
	
	
	//Login Page locater
	
	public FacebookLoginPageObject(WebDriver driver) {

	        this.driver = driver;
	        
	        PageFactory.initElements(driver, this);
	    
	}

	@FindBy(id="email")
	public WebElement loginId;
	
	@FindBy(id="pass")
	public	WebElement loginPassword;
	
	@FindBy(xpath="//*[@type='submit' and @value='Log In']")
	public	WebElement Submit;
	

}
