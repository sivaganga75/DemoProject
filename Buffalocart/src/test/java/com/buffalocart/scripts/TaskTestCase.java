package com.buffalocart.scripts;

import org.testng.annotations.Test;

import com.buffalocart.pages.TaskPage;

public class TaskTestCase extends TestBase{
	TaskPage objTaskPage;
	@Test
	public void verifyTask() {
		objTaskPage= new TaskPage(driver);
		objTaskPage.clickTask();
		
	}
}
