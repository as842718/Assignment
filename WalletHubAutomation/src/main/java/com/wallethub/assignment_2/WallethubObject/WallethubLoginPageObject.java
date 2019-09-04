package com.wallethub.assignment_2.WallethubObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class WallethubLoginPageObject extends BaseClass {
	
	@FindBy(className="login")
	public WebElement loginlink;
	
	@FindBy(name="em")
	public WebElement emailID;
	
	@FindBy(name="pw")
	public WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	public WebElement loginBtn;
	
	
	@FindBy(id="recaptcha-anchor")
	public WebElement checkboxcaptcha;
	
	@FindBy(xpath="//h2 [text()='Sorry for the inconvenience!'']")
	public WebElement inconveniencePage;


		public WallethubLoginPageObject(WebDriver driver) {
	        this.driver = driver;     
	        PageFactory.initElements(driver, this);
	
	
	}
	
	
	

}
