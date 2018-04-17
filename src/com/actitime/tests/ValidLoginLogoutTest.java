package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest {
	
	@Test
	public void testValidLoginLogout() throws InterruptedException
	{
		String loginTitle=ExcelData.getData(file_path, "login", 1, 2);
		String user=ExcelData.getData(file_path, "login", 1, 0);
		String pass=ExcelData.getData(file_path, "login", 1, 1);
		String timeTrackTitle=ExcelData.getData(file_path, "enterTimeTrack", 1, 0);
	
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
	
	Thread.sleep(3000);
	
	//verify enter time track page
	lp.verifyTheTitle(timeTrackTitle);
	
	Thread.sleep(3000);
	
	//click on logout
	ep.clickOnLogout();
	
	//verify login page
	lp.verifyTheTitle(loginTitle);
 }
}

