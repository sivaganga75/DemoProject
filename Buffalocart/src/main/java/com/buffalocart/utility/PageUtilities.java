package com.buffalocart.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities {
static WebDriver driver;
	
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void enterWithoutClearText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void clickButton(WebDriver driver, WebElement element) {
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);	 
	}
	
	public static void clickActionButton(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}
	
	public static String getText(WebElement element) {
		String txt= element.getText();
		return txt;
	}
	
	public static void enterKey(WebElement element) {
		element.clear();
		element.sendKeys(Keys.ENTER);
	}

	public static boolean displayed(WebElement element) {
		boolean b = element.isDisplayed();
		return b;
	}
	
	public static boolean selected(WebElement element) {
		boolean b = element.isSelected();
		return b;
	}

}
	
	
	
	
	
	
	/*public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, int Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element1;
    }
	public WebElement waitForElementTobeClickable(WebDriver driver, WebElement elementToBeClickable, int Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);
        WebElement elementclick = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        return elementclick;
    }
	public void hitenter(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.sendKeys(element,Keys.ENTER).build().perform();;
    	
    }
	public void contextclick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.contextClick(element).build().perform();
    }
	public void doubleclick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.doubleClick(element).build().perform();
    }
	
}*/
