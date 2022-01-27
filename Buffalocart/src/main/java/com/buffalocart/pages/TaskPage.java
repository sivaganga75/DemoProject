package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='http://buffalocart.com/demo/crm/index.php/projects/all_tasks']")
	WebElement Task;
	@FindBy(xpath="//button[@id='task-table_wrapper']")
	WebElement Excel;

	public TaskPage(WebDriver driver) { 
		this.driver = driver;                  // This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickTask() {
		Task.click();

	}
	public void clickExcel() {
		Excel.click();

	}


	
}
