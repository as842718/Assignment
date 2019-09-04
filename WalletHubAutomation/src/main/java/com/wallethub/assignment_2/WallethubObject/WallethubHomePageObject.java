package com.wallethub.assignment_2.WallethubObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;

public class WallethubHomePageObject extends BaseClass {
	
	public String ratingStar ="//a[text()='%s']";
	
	@FindBy(xpath="//*[@class='wh-rating rating_5']")
	public WebElement ratingblock;
	
	
	@FindBy(xpath="//a[@class='hover']")
	public List<WebElement> ratinghover;
	
	
	
	public WallethubHomePageObject(WebDriver driver) {
        this.driver = driver;     
        PageFactory.initElements(driver, this);


}
}
