package com.buffalocart.pages;
/* Verify the login flow
 * Hit in http://demo.guru99.com/V4/
 * Verify page title as guru99 bank
 * Login to application "mgr123", "mgr!23"
 * Verify the home page using Dashboard message
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.utility.PageUtilities;
import com.buffalocart.utility.WaitUtilities;

public class Login {
	
	WebDriver driver;

	public Login(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//div[@role='alert']")
	public WebElement authFailed;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement AlertMsg;
	public String getAlertMsg() {
		return AlertMsg.getText();
	}
	public boolean logIn(String email, String password) {

		PageUtilities.enterText(emailField, email);
		PageUtilities.enterText(passwordField, password);
		PageUtilities.clickButton(driver, submitButton);
		WaitUtilities.waitImplicit(4);

		boolean auth =authFailed.isDisplayed(); 
		return auth;

	}}
	
	
	
	
	/*WebDriver driver; // required in all pages

	@FindBy(name = "email")
	WebElement name;
	@FindBy(name = "password") 
	WebElement password;
	@FindBy(xpath = "//button[@class='w-100 btn btn-lg btn-primary']")
	WebElement Signin;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement AlertMsg;
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/crm/index.php/signin/request_reset_password']")
	WebElement Forgotpassword;
	@FindBy(xpath = "//button[@id='request-password-form']")
	WebElement Send;  //*[@id="request-password-form"]/button  
	//List<WebElement> listofLinks = driver.findElements(By.tagName("a"));
	@FindBy(tagName="a")
	WebElement NoOfLinks;
	
	@FindBy(xpath = "//a[@href='http://buffalocart.com/demo/crm/index.php/signup']")
	WebElement Signup;

	public Login(WebDriver driver) { // required in all pages(just change the class name)
		this.driver = driver; // This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Set user name in textbox
	public void setUserName(String strUserName) {
		name.sendKeys(strUserName);
	}

	public void setUserPassword(String strUserPassword) {
		password.sendKeys(strUserPassword);

	}

	public void clickSignin() {
		Signin.click();
	}
	public void clickForgotpassword() {
		Forgotpassword.click();
	}
	public void clickSend() {
		Send.click();
	}

	public String getAlertMsg() {
		return AlertMsg.getText();
	}
	public void clickNoOfLinks() {
		NoOfLinks.click();
	}

	public void clickSignup() {
		Signup.click();
		
	}

	public boolean logIn(String emailId, String password2) {
		// TODO Auto-generated method stub
		return false;
	}

}
*/