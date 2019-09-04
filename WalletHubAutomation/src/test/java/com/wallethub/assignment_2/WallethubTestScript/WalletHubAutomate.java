package com.wallethub.assignment_2.WallethubTestScript;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wallethub.assignment_1.FacebookComponent.BaseClass;
import com.wallethub.assignment_2.WallethubComponent.WallethubComponent;
import com.wallethub.assignment_2.WallethubObject.WallethubHomePageObject;
import com.wallethub.assignment_2.WallethubObject.WallethubLoginPageObject;
import com.wallethub.assignment_2.WallethubObject.WallethubReviewPageObject;
import com.wallethub.assignment_2.WallethubObject.WallethubUserProfilePageObject;

public class WalletHubAutomate extends BaseClass {

	final static Logger logger = Logger.getLogger(WalletHubAutomate.class);
	
	//Parameters passing from .xml file
	@Parameters({"userID","Password"})
	@Test(priority=1,enabled=true)
	public void logInWalletHub(String emailid, String password) throws InterruptedException{
		
		WallethubLoginPageObject login = new WallethubLoginPageObject(driver);
		
		//Login to Wallethub.com
		login.loginlink.click();
			
		login.emailID.sendKeys(emailid);
		
		login.password.sendKeys(password);
		
		login.loginBtn.click();
		
		WallethubComponent.waitForJStoLoad();
		
		logger.info("Login with test user");
		
	}
	
		@Test(priority=2,enabled=true,dependsOnMethods="logInWalletHub")
		public void provideRating() throws InterruptedException{
			
			WallethubHomePageObject homePage = new WallethubHomePageObject(driver);
			
			WallethubComponent.hover(homePage.ratingblock);
			logger.info("Hover Over Rating Stars ");
			
			//validation point
			Assert.assertTrue(WallethubComponent.hoverOverRatingStar(),"Rating Stars are Not getting light Up");
			
			logger.info("hoverOverRating method pass");
			
		}
		
		
		
		
		@Test(priority=3,dependsOnMethods="provideRating")
		public void setPolicy() throws IOException, URISyntaxException, InterruptedException{
			
			WallethubComponent component = new WallethubComponent();
			
			WallethubReviewPageObject reviewpage = new WallethubReviewPageObject(driver);

			// set policy to "Health"
			reviewpage.policyDropdown.click();

			reviewpage.linkHealth.click();
			
			WallethubComponent.waitForJStoLoad();
			
			// Waiting for load spinner to complete
			WallethubComponent.waitForSpinner();
			
			reviewpage.overallRating.click();
			
			logger.info("Overall rating set");		
			WallethubComponent.waitForJStoLoad();
			
			// getting comment from ReviewComment.txt file
			reviewpage.reviewbox.sendKeys(component.getfileText());
			
			logger.info("insert comment in review box ");
			WallethubComponent.waitForJStoLoad();
			
			//Submitting review form
			reviewpage.submitBtn.submit();
			logger.info("Submit Review Done");
	
		}
		
		
		@Test(priority=4,dependsOnMethods="setPolicy")
		public void reviewFeed() throws IOException{
			
			boolean ispass =false;
			
			logger.info("initizeing all driver");
			
			WallethubComponent component = new WallethubComponent();
			
			WallethubReviewPageObject reviewpage = new WallethubReviewPageObject(driver);
			
			WallethubUserProfilePageObject userprofile = new WallethubUserProfilePageObject(driver);
						
			//click on User profile
			//reviewpage.User.click();
			WallethubComponent.hover(reviewpage.User);
			
			reviewpage.profile.click();
			
			logger.info("User Profile");
			
			userprofile.reviewTab.click();
			
			component.refreshPage();
					
			//Validating feed 
			if((userprofile.reviewcomment.getText().equals(component.getfileText())))
				ispass=true;
			//Review Feeder
			Assert.assertTrue(ispass);
			
			logger.info("feeder compare with actaual content");
						
		}
		
		
		@Test(priority=5,dependsOnMethods="logInWalletHub")
		public void logOut(){
			
			WallethubReviewPageObject reviewpage = new WallethubReviewPageObject(driver);
			
			/**working on both chrome and firefox
			 * */
			WallethubComponent.hover(reviewpage.User);
			
			//reviewpage.User.click();
			
			reviewpage.Logout.click();
			
			logger.info("User Log Out");	
		}
		
		
		
	}
	
