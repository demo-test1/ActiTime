package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage {
	
	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement helpDM;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutBTN;
	
	@FindBy(xpath="//span[.='(build 40469)']")
	private WebElement build;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement popupCloseBTN;
	
	//Initialization
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickOnLogout()
	{
		logoutBTN.click();
	}

	public void clickOnHelp()
	{
		helpDM.click();
	}
	
	public void clickOnAbout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(aboutBTN).click().perform();
	}
	
	public String verifyBuild()
	{
		String aBuild=build.getText();
		return aBuild;
	}
	
	public void clickOnPopupClose()
	{
		popupCloseBTN.click();
	}
	
}
