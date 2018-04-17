package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumber extends BaseTest {
	
	@Test
	public void testVerifyBuildNumber() throws InterruptedException
	{
		String loginTitle = ExcelData.getData(file_path, "login", 1, 2);
		String user=ExcelData.getData(file_path, "login", 1, 0);
		String pass=ExcelData.getData(file_path, "login", 1, 1);
		String timeTrackTitle=ExcelData.getData(file_path, "enterTimeTrack", 1, 0);
		String eBuild=ExcelData.getData(file_path, "enterTimeTrack", 1, 1);
	
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		
		//verify login page
		lp.verifyTheTitle(loginTitle);
		
		//enter valid username
		Reporter.log("username is: " +user, true);
		lp.enterUserName(user);
		
		//enter valid password
		Reporter.log("password is: "+pass, true);
		lp.enterPassword(pass);
		
		//click on login
		lp.clickOnLogin();
		
		//verify enter time track page
		lp.verifyTheTitle(timeTrackTitle);
		
		Thread.sleep(5000);
		
		//click on Help
		ep.clickOnHelp();
		
		Thread.sleep(5000);
		
		//click on the About your actitime option
		ep.clickOnAbout();
		
		Thread.sleep(2000);
		
		//verify build
		String aBuild=ep.verifyBuild();
		Thread.sleep(3000);
		Assert.assertEquals(aBuild, eBuild);
		Reporter.log("build is matching; actual build is: " +aBuild, true);
		
		Thread.sleep(2000);
		
		//close the popup
		ep.clickOnPopupClose();
		
		Thread.sleep(2000);
		
		//verify enter time track page
		lp.verifyTheTitle(timeTrackTitle);		
		
		Thread.sleep(2000);
				
		//click on logout
		ep.clickOnLogout();
		
		//verify login page
		lp.verifyTheTitle(loginTitle);

		
		
	}

}
