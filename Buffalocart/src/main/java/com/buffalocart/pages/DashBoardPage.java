package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffalocart.utility.PageUtilities;
import com.buffalocart.utility.WaitUtilities;

public class DashBoardPage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"js-clock-in-out\"]/div/div[2]/a")
	WebElement clockIn;
	@FindBy(xpath = "//a[text()=' Clock In']")
	WebElement clockedOut;
	@FindBy(xpath = "//*[contains(text(), 'Clock Out')]")
	WebElement clockedIn;
	@FindBy(xpath = "//*[contains (text(),'Clock started at')]")
	WebElement getInTime;

	@FindBy(xpath = "//span[text()='My open tasks']//parent::div")
	WebElement myOpenTasks;
	@FindBy(xpath = "//h4[text()='Tasks']")
	WebElement tasksPageLoad;
	
	@FindBy(xpath = "//span[text()='Events today']//parent::div")
	WebElement eventsToday;
	@FindBy(xpath = "//h1[text()='Event calendar']")
	WebElement eventsPageLoad;
	
	@FindBy(xpath = "//span[text()='New posts']//parent::div")
	WebElement newPosts;
	@FindBy(id = "timeline")
	WebElement timelinePageLoad;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement dashboard;
	
	boolean display;
	
	public void homeDashBoard() {
		PageUtilities.clickButton(driver, dashboard);
	}

	public void clockIN() {
		SoftAssert softAssert = new SoftAssert();
		display = PageUtilities.displayed(clockedOut);
		softAssert.assertTrue(display,"Already Clocked Out");
		PageUtilities.clickButton(driver, clockIn);
		
		WaitUtilities.waitImplicit(4);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(clockedIn);
		
		driver.navigate().refresh();
		
		softAssert.assertAll();
		String time = PageUtilities.getText(getInTime);
		System.out.println("Check In time "+time);
	}
	
	public void openTasks() {
		PageUtilities.clickButton(driver, myOpenTasks);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(tasksPageLoad);
	}
	
	public void openEvent() {
		PageUtilities.clickButton(driver, eventsToday);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(eventsPageLoad);
	}
	
	public void openTeamsTimeline() {
		PageUtilities.clickButton(driver, newPosts);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(timelinePageLoad);
	}
	
	public void returnHome() {
		PageUtilities.clickButton(driver, dashboard);
	}

}
