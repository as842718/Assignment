package com.wallethub.assignment_2.WallethubObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class WallethubReviewPageObject extends BaseClass {
	
	@FindBy(className="dropdown-title")
	public WebElement policyDropdown;
	
	@FindBy(linkText="Health")
	public WebElement linkHealth;
	
	@FindBy(xpath="//span[text()='5']/ancestor::a")
	public WebElement overallRating;
	
	@FindBy(tagName="textarea")
	public WebElement reviewbox;
	
	@FindBy(css=".btn.blue")
	public WebElement submitBtn;
	
	@FindBy(css=".rating.disable")
	public WebElement spinner;
	
	
	@FindBy(className="user")
	public WebElement User;
	
	@FindBy(linkText="Profile")
	public WebElement profile;
	
	@FindBy(linkText="Logout")
	public WebElement Logout;
	
	
	
	

	public WallethubReviewPageObject(WebDriver driver) {
        this.driver = driver;     
        PageFactory.initElements(driver, this);


}

}
