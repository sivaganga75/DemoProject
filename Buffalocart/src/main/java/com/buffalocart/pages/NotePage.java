package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='http://buffalocart.com/demo/crm/index.php/notes']")
	WebElement Notes;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement Managelevel;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement ManagelevelClose;
	
	public NotePage(WebDriver driver) { 
		this.driver = driver;                  // This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	/*public String getHomeDashboardMsg()   {
		return homeDashboardMsg.getText();
		}*/
	public void clickNotes() {
		Notes.click();

	}
	public void clickManagelevel() {
		Managelevel.click();
		
	}
	public void clickManagelevelClose() {
		ManagelevelClose.click();
		
	}
	
}