package com.buffalocart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='http://buffalocart.com/demo/crm/index.php/team_members']")
	WebElement Team;
	@FindBy(xpath="//*[@id=\"sidebar-menu\"]/li[11]/ul/li[1]/a")
	WebElement TeamMeamber;
	@FindBy(xpath="//*[@id=\"page-content\"]/div/div[1]/div/a[2]")
	WebElement AddMember;
	@FindBy(name = "first_name")
	WebElement Firstname;
	@FindBy(name = "last_name")
	WebElement Lastname;
	@FindBy(name = "address")
	WebElement Mailingaddress;
	@FindBy(name = "phone")
	WebElement phone;
	@FindBy(xpath="//*[@id=\"form-next\"]")
	WebElement Next;
	@FindBy(name = "job_title")
	WebElement jobtitle;
	@FindBy(name = "salary")
	WebElement salary;
	@FindBy(name = "salary_term")
	WebElement salaryterm;
	@FindBy(name = "date_of_hire")
	WebElement date;
	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath="//*[@id=\"form-submit")
	WebElement Save;
	@FindBy(xpath="//span[@id='first_name-error']")
	WebElement FirstTitle;
	@FindBy(xpath="//span[@id='last_name-error']")
	WebElement LastTitle;
	@FindBy(xpath="//*[@id=\"gender_male")
	WebElement radiobutton;
	//*[@id="gender_male"]
	public TeamPage(WebDriver driver) { 
		this.driver = driver;                  // This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstTitle() {
		return FirstTitle.getText();
	}
	public String getErrorMsg2() {
		return LastTitle.getText();
	}
	public String getradiobutton() {
		radiobutton.isSelected();
		return radiobutton.getText();
	}
	public void checkradiobutton() {
		Team.click();
		TeamMeamber.click();
		AddMember.click();
		}
	public void clickTeamm() {
		Team.click();
		TeamMeamber.click();
		AddMember.click();

		}
	public void clickTeam() {
		Team.click();
		TeamMeamber.click();
		AddMember.click();
		Firstname.sendKeys("SIVA");
		Lastname.sendKeys("GANGA");
		Mailingaddress.sendKeys("acss");
		phone.sendKeys("666666666");
		Next.click();
		jobtitle.sendKeys("testing");
		salary.sendKeys("200000");
		salaryterm.sendKeys("fffff");
		date.click();
	email.sendKeys("ssssss@gmail.com");
		password.sendKeys("ddddddd");
		Save.click();
	}
	public void JobTitle() {
		jobtitle.sendKeys("testing");
		salary.sendKeys("200000");
		salaryterm.sendKeys("fffff");
		date.click();
	
		email.sendKeys("ssssss@gmail.com");
		password.sendKeys("ddddddd");
		Save.click();
	}
}
