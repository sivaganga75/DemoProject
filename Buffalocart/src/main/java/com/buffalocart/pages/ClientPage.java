package com.buffalocart.pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.constants.AutomationConstants;
import com.buffalocart.scripts.TestBase;
import com.buffalocart.utility.PageUtilities;
import com.buffalocart.utility.WaitUtilities;


public class ClientPage extends TestBase {
WebDriver driver;
	
	public ClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	AutomationConstants constants = new AutomationConstants();
	
	ArrayList<WebElement> gender = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement mainClient;
	
	@FindBy(xpath = "//a[text()='Overview']")
	WebElement toOverviewPage;
	
	@FindBy(xpath = "//span[text()='Total clients']//parent::div")
	WebElement toTotalClients;
	@FindBy(xpath = "(//th[text()='Company name'])[1]")
	WebElement findCompanyName;
	
	@FindBy(xpath ="//span[text()='Total contacts']//parent::div")
	WebElement toTotalContacts;
	@FindBy(xpath = "(//th[text()='Name'])[1]")
	WebElement findName;
	
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientsFrame;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement addClient;
	
	@FindBy(id = "company_name")
	WebElement companyName;
	
	@FindBy(xpath = "//div[@class='form-group']//parent::div//child::div//child::label//following-sibling::div//child::div//child::a")
	WebElement ownerDropdown;
	@FindBy(xpath = "(//div[@class='select2-search']//parent::div//child::input)[5]")
	WebElement ownerTextField;
	
	@FindBy(id = "address")
	WebElement address;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(id = "state")
	WebElement state;
	@FindBy(id = "zip")
	WebElement zip;
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(id = "website")
	WebElement website;
	
	@FindBy(id = "vat_number")
	WebElement vatNumber;
	
	@FindBy(id = "s2id_group_ids")
	WebElement clientGroups;
	
	@FindBy(id = "save-and-continue-button")
	WebElement saveAndContinueButton;
	
	@FindBy(xpath = "//h4[text()='Add multiple contacts']")
	WebElement waitNextContactsTab;
	
	@FindBy(id = "first_name")
	WebElement contactsFirstName;
	@FindBy(id = "last_name")
	WebElement contactsLastName;
	
	@FindBy(id = "email")
	WebElement contactsEmail;
	
	@FindBy(id = "phone")
	WebElement contactsPhone;
	
	@FindBy(id = "skype")
	WebElement contactsSkype;
	
	@FindBy(id = "job_title")
	WebElement contactsJobTitle;
	
	@FindBy(id = "gender_male")
	WebElement contactsGenderMale;
	@FindBy(id = "gender_female")
	WebElement contactsGenderFemale;
	
	@FindBy(id = "login_password")
	WebElement contactsPassword;
	
	@FindBy(id = "generate_password")
	WebElement contactsGeneratePassword;
	
	@FindBy(id = "email_login_details")
	WebElement contactsEmailLoginDetails;
	
	@FindBy(id = "save-and-add-button")
	WebElement contactsSaveAndAddButton;
	
	@FindBy(xpath = "(//*[contains (text(),'Close')]//parent::div//child::button)[1]")
	WebElement contactsCloseButton;
	
	@FindBy(xpath = "(//div[@class='mr15 DTTT_container']//parent::div//child::div//child::a//child::span)[1]")
	WebElement clientQucikFilterDropdown;
	@FindBy(xpath = "(//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//parent::div//child::div//following-sibling::ul//child::li)[2]")
	WebElement clientQucikFilterField;
	
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement clientExcelButon;
	
	@FindBy(xpath = "//span[text()='Dashboard']//parent::a")
	WebElement returnDashboard;
	@FindBy(xpath = "//h4[text()='Dashboard']")
	WebElement dashboardTitle;
	
	public void goToClient() {
		PageUtilities.clickButton(driver, mainClient);
		PageUtilities.clickButton(driver, toTotalClients);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(findCompanyName);
		WaitUtilities.waitExplicitToBeClickable(toOverviewPage);
		PageUtilities.clickButton(driver, toOverviewPage);
	}
	
	public void goToContacts() {
		PageUtilities.clickButton(driver, toTotalContacts);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(findName);
		WaitUtilities.waitExplicitToBeClickable(toOverviewPage);
		PageUtilities.clickButton(driver, toOverviewPage);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(toTotalClients);
	}
	
	public void addClientAndContacts(ArrayList<String> client, ArrayList<String> contact) {
		gender.add(contactsGenderMale);
		gender.add(contactsGenderFemale);
		
		PageUtilities.clickButton(driver, clientsFrame);
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(findCompanyName);
		
		WaitUtilities.waitExplicitToBeClickable(addClient);
		PageUtilities.clickButton(driver, addClient);
		
		PageUtilities.enterText(companyName, client.get(1));
			
		PageUtilities.clickActionButton(driver, ownerDropdown);
		PageUtilities.enterText(ownerTextField, client.get(2));
		PageUtilities.enterKey(ownerTextField);
		
		PageUtilities.enterText(address, client.get(3));
		PageUtilities.enterText(city, client.get(4));
		PageUtilities.enterText(state, client.get(5));
		PageUtilities.enterText(zip, client.get(6));
		PageUtilities.enterText(country, client.get(7));
		
		PageUtilities.enterText(phone, client.get(8));
		
		PageUtilities.enterText(website, client.get(9));
		
		PageUtilities.enterText(vatNumber, client.get(10));
		
		WaitUtilities.waitExplicitToBeClickable(saveAndContinueButton);
		PageUtilities.clickButton(driver, saveAndContinueButton);
		
		WaitUtilities.waitExplicitToBevisibilityOfAllElements(waitNextContactsTab);
		WaitUtilities.waitImplicit(4);
		
		PageUtilities.enterText(contactsFirstName, contact.get(1));
		PageUtilities.enterText(contactsLastName, contact.get(2));
		
		PageUtilities.enterText(contactsEmail, contact.get(3));
		
		PageUtilities.enterText(contactsPhone, contact.get(4));
		
		PageUtilities.enterText(contactsSkype, contact.get(5));
		
		PageUtilities.enterText(contactsJobTitle, contact.get(6));
			
		if(contact.get(7).equalsIgnoreCase("Male")) {
			PageUtilities.clickButton(driver, gender.get(0));
		}else {
			PageUtilities.clickButton(driver, gender.get(1));
		}
			
		if(contact.get(7).equalsIgnoreCase("-")) {
			PageUtilities.clickActionButton(driver, contactsGeneratePassword);
		}else {
			PageUtilities.clickActionButton(driver, contactsPassword);
			PageUtilities.enterText(contactsPassword, contact.get(8));
		}
		
		WaitUtilities.waitExplicitToBeClickable(contactsSaveAndAddButton);
		PageUtilities.clickButton(driver, contactsSaveAndAddButton);
		WaitUtilities.waitExplicitToBeClickable(contactsCloseButton);
		PageUtilities.clickButton(driver, contactsCloseButton);
	}
	
	
	/*
	 * public void filteringClients(ArrayList<String> filter) {
	 * PageUtility.clickActionButton(driver, clientQucikFilterDropdown);
	 * PageUtility.clickActionButton(driver, clientQucikFilterField); }
	 */
	
	public void downloadExcelClientsFile() {
		PageUtilities.clickButton(driver, clientExcelButon);
		PageUtilities.clickButton(driver, returnDashboard);
	

}
}	
	
	
	
/*	WebDriver driver;
	
	@FindBy(xpath="//a[@href='http://buffalocart.com/demo/crm/index.php/clients']")
	WebElement Clients;
	/*@FindBy(xpath="//input[@class='form-control form-control-sm']")//*[@id="sidebar-menu"]/li[3]/a
	WebElement SearchTab;
	*/
	
	/*@FindBy(xpath="//*[@id=\"client-tabs\"]/div/div/a[2]" ) 
	WebElement addClient;
	@FindBy(xpath="//input[@id='company_name']")
	WebElement companyName;
	@FindBy(xpath="//input[@id='']")////*[@id="s2id_autogen2_search"]
	WebElement owner;
	@FindBy(xpath="//input[@id='']")
	WebElement dropdownValue;
	@FindBy(xpath="//input[@id='address']")
	WebElement address;
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	@FindBy(xpath="//input[@id='zip']")
	WebElement zip;
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='save-and-continue-button']")
	WebElement saveandcontinuebutton;
	@FindBy(xpath="//span[@id='client-table_wrapper']")
	WebElement print;

	public ClientPage(WebDriver driver) {         // required in all pages (just change the class name)
		this.driver = driver;            // This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public void AddclientDetails() {
		Clients.click();
		addClient.click();
	}*/
	/*public void AddaClient(String cN,String add,String cityN,String stateName,String zipname,String cntry,String phoneN)
	{
		AddclientDetails();
		companyName.sendKeys(cN);
		address.sendKeys(add);
		city.sendKeys(cityN);
		state.sendKeys(stateName);
		zip.sendKeys(zipname);
		country.sendKeys(cntry);
		phone.sendKeys(phoneN);
		phone.sendKeys(Keys.TAB);*/
		//website.sensKeys(web);
		
		
	
	/*public void clickClients() {
		Clients.click();
		//addclient.click();
	}*/
	/*public void clickSearchTab() {
		SearchTab.click();
	}*/
	/*public void print() {
		Clients.click();
		print.click();
		
	}*/
	
	
	/*public String getDashboardMsg()   {
		return DashboardMsg.getText();
		}*/
/*public void setName(String strName) {
	companyName.sendKeys(strName);
}

public void setUserName(String strName) {
	companyName.sendKeys(strName);
}*/

