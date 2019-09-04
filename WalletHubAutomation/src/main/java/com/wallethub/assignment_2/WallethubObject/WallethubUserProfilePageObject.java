package com.wallethub.assignment_2.WallethubObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class WallethubUserProfilePageObject extends BaseClass {
	

	@FindBy(linkText="Reviews")
	 public WebElement reviewTab;
	
	@FindBy(xpath="//*[@class='reviews']//p")
	public WebElement reviewcomment;
	
	public WallethubUserProfilePageObject(WebDriver driver) {
        this.driver = driver;     
        PageFactory.initElements(driver, this);


}
}
