package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest{

	@Test
	public void testVerifyVersion()
	{
		String loginTitle=ExcelData.getData(file_path, "login", 1, 2);
		String eVersion=ExcelData.getData(file_path, "login", 1, 3);
		
		LoginPage lp=new LoginPage(driver);
		
		//verify login page
		lp.verifyTheTitle(loginTitle);
		
		//verify version
		String aVersion=lp.verifyVersion();
		Assert.assertEquals(aVersion, eVersion);
		Reporter.log("version is matching; actual version is: " +aVersion, true);		
	}

}
