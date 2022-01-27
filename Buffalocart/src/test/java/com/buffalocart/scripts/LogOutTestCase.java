package com.buffalocart.scripts;

import org.testng.annotations.Test;

import com.buffalocart.pages.DashBoardPage;
import com.buffalocart.pages.LogOutPage;

public class LogOutTestCase extends TestBase {
	LogOutPage logOutPage;
	DashBoardPage dashboardPage;
	
	@Test
	public void clockOutTestCase() {
		logOutPage = new LogOutPage(driver);
		logOutPage.clockOut();
	}
	
	@Test
	public void logOutTestCase() {
		logOutPage.logOut();
	}

}

