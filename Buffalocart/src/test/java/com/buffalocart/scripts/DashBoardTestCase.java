package com.buffalocart.scripts;

import org.testng.annotations.Test;

import com.buffalocart.pages.DashBoardPage;
import com.buffalocart.pages.Login;
import com.buffalocart.utility.DataRead;

public class DashBoardTestCase extends TestBase{
	DataRead dataRead = new DataRead(driver);
	Login loginPage;
	DashBoardPage dashboardPage;

	@Test
	public void clockINTestCase() {
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.clockIN();
	}
	
	@Test
	public void openEventTestCase() {
		dashboardPage.openEvent();
		dashboardPage.returnHome();
	}
	
	@Test
	public void openTasksTestCase() {
		dashboardPage.openTasks();
		dashboardPage.returnHome();
	}
	
	@Test
	public void openTeamsTimelineTestCase() {
		dashboardPage.openTeamsTimeline();
		dashboardPage.returnHome();
	}
		
		
}

