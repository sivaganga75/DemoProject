package com.buffalocart.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.buffalocart.utility.PageUtilities;
import com.buffalocart.utility.WaitUtilities;

public class EventPage {
WebDriver driver;
	
	public EventPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	boolean b;
	ArrayList<WebElement> list = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//span[text()='Events']//parent::a")
	WebElement goToEvents;
	@FindBy(xpath = "(//a[@title='Add event'])[2]")
	WebElement addEvent;
	
	@FindBy(id = "title")
	WebElement title;
	@FindBy(id = "description")
	WebElement description;
	@FindBy(id = "start_date")
	WebElement startDate;
	@FindBy(id = "start_time")
	WebElement startTime;
	@FindBy(id = "end_date")
	WebElement endDate;
	@FindBy(id = "end_time")
	WebElement endTime;
	@FindBy(id = "location")
	WebElement location;
	@FindBy(id = "s2id_clients_dropdown")
	WebElement clientSelectionDropdown;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active select2-drop-above']//parent::div//child::input")
	WebElement clientField;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::div//following-sibling::ul")
	WebElement clientClickField;
	
	@FindBy(id = "only_me")
	WebElement onlyMe;
	@FindBy(id = "share_with_all")
	WebElement shareWithAll;
	@FindBy(id = "share_with_specific_radio_button")
	WebElement shareWithSpecific;
	@FindBy(xpath = "(//ul[@class='select2-choices']//parent::ul//child::li//child::label//following-sibling::input)[2]")
	WebElement membersShared;
	
	@FindBy(id="event_recurring")
	WebElement eventRecurring;
	@FindBy(xpath = "(//label[text()='Repeat every']//parent::div//child::div//child::input)[1]")
	WebElement repeatTimes;
	
	@FindBy(id = "s2id_repeat_type")
	WebElement repeatDurationDropdown;
	@FindBy(xpath = "//div[@id='select2-drop']//parent::div//child::label//following-sibling::input")
	WebElement repeatDuration;

	@FindBy(xpath = "//div[@class='col-md-4']//parent::div//child::input")
	WebElement repeatCycles;
	@FindBy(xpath = "(//div[@class='color-palet']//parent::div//child::span)[1]")
	WebElement eventColor;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath = "(//*[contains (text(),'month')]//parent::div//child::button)[1]")
	WebElement monthView;
	@FindBy(xpath = "(//*[contains (text(),'week')]//parent::div//child::button)[2]")
	WebElement weekView;
	@FindBy(xpath = "(//*[contains (text(),'day')]//parent::div//child::button)[3]")
	WebElement dayView;
	@FindBy(xpath = "(//*[contains (text(),'list')]//parent::div//child::button)[4]")
	WebElement listView;
	
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[2]")
	WebElement forwardNavigation;
	@FindBy(xpath = "(//button[@type='button']//parent::div//child::button)[1]")
	WebElement backwardNavigation;
	
	@FindBy(xpath = "(//div[@class='form-group']//parent::div//child::label[text()='Labels'])[1]")
	WebElement clickGeneral;
	
	@FindBy(xpath = "//h1[text()='Event calendar']")
	WebElement finalEventPage;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement returnDashboard;
	
	public void addEvent(ArrayList<String> list1) {
		list.add(onlyMe);
		list.add(shareWithAll);
		list.add(shareWithSpecific);
		
		SoftAssert softAssert = new SoftAssert();
		
		PageUtilities.clickButton(driver, goToEvents);
		
		WaitUtilities.waitExplicitToBeClickable(addEvent);
		PageUtilities.clickButton(driver, addEvent);
		
		PageUtilities.enterText(title, list1.get(1));
		PageUtilities.enterText(description, list1.get(2));
		
		PageUtilities.clickButton(driver, startDate);
		PageUtilities.enterText(startDate, list1.get(3));
		PageUtilities.enterKey(startDate);
		PageUtilities.enterText(startTime, list1.get(4));
		PageUtilities.clickButton(driver, clickGeneral);
		
		PageUtilities.clickButton(driver, endDate);
		PageUtilities.enterText(endDate, list1.get(5));
		PageUtilities.enterKey(endDate);
		PageUtilities.enterText(endTime, list1.get(6));
		PageUtilities.clickButton(driver, clickGeneral);
		
		PageUtilities.clickActionButton(driver, location);
		PageUtilities.enterText(location, list1.get(7));
		
		PageUtilities.clickActionButton(driver, clientSelectionDropdown);
		PageUtilities.enterText(clientField, list1.get(8));
		PageUtilities.enterKey(clientField);
		
		PageUtilities.clickButton(driver, list.get(2));
		b =PageUtilities.selected(list.get(2));
		softAssert.assertTrue(b,"Specific Members");
		PageUtilities.clickActionButton(driver, membersShared);
		PageUtilities.enterText(membersShared, list1.get(9));
		PageUtilities.enterKey(membersShared);
		softAssert.assertAll();

		if(list1.get(10).equalsIgnoreCase("Yes")) {
			WaitUtilities.waitExplicitToBeClickable(eventRecurring);
			PageUtilities.clickActionButton(driver, eventRecurring);
			PageUtilities.enterText(repeatTimes, list1.get(11));
			PageUtilities.clickActionButton(driver, repeatDurationDropdown);
			PageUtilities.enterText(repeatDuration, list1.get(12));
			PageUtilities.enterKey(repeatDuration);
			PageUtilities.enterText(repeatCycles, list1.get(13));
		}
		PageUtilities.clickButton(driver, eventColor);
		
		WaitUtilities.waitExplicitToBeClickable(saveButton);
		PageUtilities.clickButton(driver, saveButton);
		WaitUtilities.waitImplicit(5);
		/*
		 * driver.navigate().refresh();
		 * WaitUtility.waitExplicitToBevisibilityOfAllElements(finalEventPage);
		 */
	}
	
	public void eventMonthView() {
		PageUtilities.clickButton(driver, monthView);
		PageUtilities.clickButton(driver, monthView);
	}
	
	public void eventWeekView() {
		PageUtilities.clickButton(driver, weekView);
		PageUtilities.clickButton(driver, weekView);
	}
	
	public void eventDayView() {
		PageUtilities.clickButton(driver, dayView);
		PageUtilities.clickButton(driver, dayView);
	}
	
	public void eventListView() {
		PageUtilities.clickButton(driver, listView);
		PageUtilities.clickButton(driver, listView);
	}
	
	public void navigateEventForward() {
		PageUtilities.clickButton(driver, forwardNavigation);
		PageUtilities.clickButton(driver, forwardNavigation);
	}
	
	public void navigateEventBackward() {
		PageUtilities.clickButton(driver, backwardNavigation);
		PageUtilities.clickButton(driver, backwardNavigation);
		WaitUtilities.waitImplicit(5);
	}


}

