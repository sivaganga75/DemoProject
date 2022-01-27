package com.buffalocart.scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.buffalocart.pages.EventPage;
import com.buffalocart.pages.Login;
import com.buffalocart.utility.DataRead;
import com.buffalocart.utility.ExcelUtility;

public class EventTestCase extends TestBase{
	DataRead dataRead = new DataRead(driver);
	ExcelUtility excelUtility = new ExcelUtility();
	Login loginPage;
	EventPage eventPage;
	
	ArrayList<String> event;
	
	@Test
	public void addEventTestCase() throws IOException {
		event = new ArrayList<String>();
		eventPage = new EventPage(driver);
		event=excelUtility.readExcel(1, "AddEvent");
		eventPage.addEvent(event);
	}
	
	@Test
	public void navigateEventForwardTestCase() {
		eventPage.navigateEventForward();	
	}
	
	@Test
	public void navigateEventBackwardTestCase(){	
		eventPage.navigateEventBackward();
	}
	
	@Test
	public void eventWeekViewTestCase() {
		eventPage.eventWeekView();
	}
	
	@Test
	public void eventDayViewTestCase() {
		eventPage.eventDayView();
	}
	
	@Test
	public void eventListViewTestCase() {
		eventPage.eventListView();
	}
	
	@Test
	public void eventMonthViewTestCase() {
		eventPage.eventMonthView();
	}

}

