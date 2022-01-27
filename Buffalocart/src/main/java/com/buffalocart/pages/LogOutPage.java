package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffalocart.utility.PageUtilities;
import com.buffalocart.utility.WaitUtilities;

public class LogOutPage {
WebDriver driver;
	
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	boolean display;
	
	@FindBy(xpath = "(//a[text()=' Clock Out'])")
	WebElement clockOutButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clockOutSaveButton;
	@FindBy(xpath = "//a[text()=' Clock In']")
	WebElement clockedOut;
	
	@FindBy(xpath = "(//a[@id='user-dropdown']//parent::a//child::span)[1]")
	WebElement signOutDropdown;
	@FindBy(xpath = "(//a[text()=' Sign Out'])")
	WebElement signOutButton;
	
	public void clockOut() {
		SoftAssert softAssert = new SoftAssert();
		display = PageUtilities.displayed(clockOutButton);
		softAssert.assertTrue(display,"Already Clocked In");
		PageUtilities.clickButton(driver, clockOutButton);
		PageUtilities.clickButton(driver, clockOutSaveButton);
		
		WaitUtilities.waitImplicit(4);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(clockedOut);
		softAssert.assertAll();
	}
	
	public void logOut() {
		PageUtilities.clickButton(driver, signOutDropdown);
		PageUtilities.clickButton(driver, signOutButton);
	}


}
