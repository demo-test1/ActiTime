package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
	
	@Test
	public void testInvalidlogin() throws InterruptedException
	{
		String loginTitle=ExcelData.getData(file_path, "login", 1, 2);
		String eErrorMessage=ExcelData.getData(file_path, "login", 1, 4);
		
		int loginRC=ExcelData.getRowCount(file_path, "login");
		
		LoginPage lp=new LoginPage(driver);
		
		//verify the login page
		lp.verifyTheTitle(loginTitle);
		
		Reporter.log("------------", true);
		for(int i=2;i<=loginRC;i++)
		{
			String user=ExcelData.getData(file_path, "login", i, 0);
			String pass=ExcelData.getData(file_path, "login", i, 1);			
				
		//enter invalid username
		Reporter.log("username is: " +user, true);
		
		//enter invalid username
		Reporter.log("username is: " +user, true);
		lp.enterUserName(user);
		
		//enter invalid password
		Reporter.log("Password is: " +pass, true);
		lp.enterPassword(pass);
		
		//click on Login
		lp.clickOnLogin();
		
		Thread.sleep(2000);
		
		//verify the error message
		String aErrorMessage=lp.verifyErrorMessage();
		Assert.assertEquals(aErrorMessage, eErrorMessage);
		Reporter.log("Message is matching: " +eErrorMessage, true);
		
		Reporter.log("----------", true);
	}
  }
}
