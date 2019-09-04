package com.wallethub.assignment_1.FacebookComponent;

import org.apache.log4j.Logger;

import com.wallethub.assignment_1.FacebookObject.FacebookHomePageObject;

public class FacebookComponents  {
	
	final static Logger logger = Logger.getLogger(FacebookComponents.class);
	
	public static void waitForPost() throws InterruptedException{	
		FacebookHomePageObject obj = new FacebookHomePageObject(BaseClass.driver);
		Thread.sleep(2000);
		try
		{
		while(!obj.latestposttext.isDisplayed()){		
			Thread.sleep(1000);	
			logger.info("Wait for post to present");
		}
	}catch(Exception e)
		{logger.info("Fail to find latest post");}
	
	
	}
	

}
