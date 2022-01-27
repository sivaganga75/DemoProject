package com.buffalocart.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

public class DataUtility {
WebDriver driver;
	
	public DataUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getDate() {
		SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = timeStamp.format(Calendar.getInstance().getTime());
		System.out.println(currentDate);
		return currentDate;
	}
	

}
