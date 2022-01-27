package com.buffalocart.scripts;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.constants.AutomationConstants;
import com.buffalocart.pages.ClientPage;

import com.buffalocart.pages.Login;
import com.buffalocart.pages.NotePage;
import com.buffalocart.pages.TaskPage;
import com.buffalocart.pages.TeamPage;
import com.buffalocart.utility.DataRead;
import com.buffalocart.utility.ExcelUtility;

public class LogInTestClass extends TestBase {

	
	
	DataRead dataRead;
	Login loginPage;

	String emailId;
	String password;
	
	@Test
	public void logInTestCase() throws IOException {
		
		
		dataRead = new DataRead(driver);
		emailId = dataRead.readStringData(1, 1, "LogIn");
		password = dataRead.readStringData(1, 2, "LogIn");
	
		
		loginPage = new Login(driver);
		boolean auth = loginPage.logIn(emailId, password);
		
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertTrue(auth,"Credentials is Wrong");
		System.out.println("Wrong login credentials is entered");
		softAssert.assertAll();}}
		/*@Test
		public void testcase01verifyTitle() {
		Assert.assertEquals(driver.getTitle(), AutomationConstants.EXPECTEDTITLE);
		}
		@Test
		public void testcase06verifyUrl() {
			Assert.assertEquals(driver.getCurrentUrl(), AutomationConstants.EXPECTEDURL);
		}}*/

		/*@Test
		public void testcase07verifyHomeTitle()  throws IOException, InterruptedException {
		objLogin = new Login(driver);
		objHome = new Home(driver);
		
		Assert.assertEquals(objHome.getHomeDashboardMsg(), AutomationConstants.EXPECTEDHOMETITLE);
		}
	}*/
/*
	@Test(priority = 1)
	public void testcase01verifyTitle() {
	Assert.assertEquals(driver.getTitle(), AutomationConstants.EXPECTEDTITLE);
	}
	@Test(priority = 2)
	public void testcase02verifyUsername() throws IOException, InterruptedException {
	objLogin = new Login(driver);
	String username=(DataRead.readStringData(2,0));
	String password=(ExcelUtility.getNumericCellData(1, 1));
	
	objLogin.setUserName(username);     
	objLogin.setUserPassword(password);
	objLogin.clickSignin();	
	Assert.assertEquals(objLogin.getAlertMsg(), AutomationConstants.EXPECTEDALERTMSG);
	}
	
	@Test(priority = 3)
	public void testcase03Invalidpassword()  throws IOException, InterruptedException {
	objLogin = new Login(driver);
	objHome = new Home(driver);
	
	String username=(DataRead.readStringData(1,0));
	String password=(ExcelUtility.getNumericCellData(2, 1));
	
	objLogin.setUserName(username);     
	objLogin.setUserPassword(password);
	objLogin.clickSignin();	
	Assert.assertEquals(objLogin.getAlertMsg(), AutomationConstants.EXPECTEDALERTMSG);
	}
	
	@Test(priority = 4)
	public void testcase04Invalidusernamepassword()  throws IOException, InterruptedException {
	objLogin = new Login(driver);
	objHome = new Home(driver);
	
	String username=(ExcelUtility.getStringCellData(2,0));
	String password=(ExcelUtility.getNumericCellData(2, 1));
	
	objLogin.setUserName(username);     
	objLogin.setUserPassword(password);
	objLogin.clickSignin();	
	Assert.assertEquals(objLogin.getAlertMsg(), AutomationConstants.EXPECTEDALERTMSG);
	}
	@Test
	public void testcase05CreateNewAccount() {
		
	}
	
	@Test(priority = 5)
	public void testcase05verifyLogin() throws IOException, InterruptedException {
	objLogin = new Login(driver);
	
	String username=(ExcelUtility.getStringCellData(1,0));
	String password=(ExcelUtility.getNumericCellData(1, 1));
	
	objLogin.setUserName(username);     
	objLogin.setUserPassword(password);
	objLogin.clickSignin();	
	}
	
	@Test(priority = 6)
	public void testcase06verifyUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), AutomationConstants.EXPECTEDURL);
	}

	@Test(priority = 7)
	public void testcase07verifyHomeTitle()  throws IOException, InterruptedException {
	objLogin = new Login(driver);
	objHome = new Home(driver);
	
	Assert.assertEquals(objHome.getHomeDashboardMsg(), AutomationConstants.EXPECTEDHOMETITLE);
	}
	@Test(priority=14)
	public void testcase08Team() {
		objTeamPage= new TeamPage(driver);
		objTeamPage.clickTeam();
		}
	@Test(priority=9)
	public void testcase09verifyfirstname() {
		objTeamPage= new TeamPage(driver);
		objTeamPage.clickTeam();
		Assert.assertEquals(objTeamPage.getFirstTitle(), AutomationConstants.EXPECTEDFIRSTTITLE);
		}
	@Test(priority=10)
	public void testcase10verifyLastname() {
		objTeamPage= new TeamPage(driver);
		objTeamPage.clickTeam();
		Assert.assertEquals(objTeamPage.getErrorMsg2(), AutomationConstants.EXPECTEDLASTTITE);
		}
	@Test(priority=11)
	public void testcase11verifyradiobutton() {
		objTeamPage= new TeamPage(driver);
		objTeamPage.checkradiobutton();
		Assert.assertEquals(objTeamPage.getradiobutton(), AutomationConstants.EXPECTEDRADIOBUTTON);
		}

	@Test(priority = 9)
	public void testcase09verifyclientdetails() {
		//objHome = new Home(driver);
		objClientPage = new ClientPage(driver);
		objClientPage.AddclientDetails();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);

	}
	@Test(priority = 10)
	public void testcase10Print() {
		objClientPage = new ClientPage(driver);
		objClientPage.print();
		}
	@Test(priority = 11)
	public void testcase11verifyAlertMsg() {
		objHome = new Home(driver);
		objHome.clickClients();
		Assert.assertEquals(objHome.getimportClient(), AutomationConstants.EXPECTEDALERTMSG);
	}
	@Test(priority=12)
	public void testcase12downloadExcel() {
		objTaskPage= new TaskPage(driver);
		objTaskPage.clickTask();
		objTaskPage.clickExcel();
		String downloadPath =System.getProperty("user.dir");
		File file = new File(downloadPath);	
}
		
	@Test(priority = 13)
	public void testcase13verifySales()  throws IOException, InterruptedException {
	//objLogin = new Login(driver);
		//Select dropdown = new Select(driver);
	//	dropdown.selectByIndex(1);
	objHome = new Home(driver);
	objHome.Sales();
	//Assert.assertEquals(objHome.getHomeDashboardMsg(), AutomationConstants.EXPECTEDHOMETITLE);
	}
	
	
	
	@Test(priority=14)
	public void testcase14verifyNotes() {
		objNotePage= new NotePage(driver);
		objNotePage.clickNotes();
		//objNotePage.clickManagelevel();
		//objNotePage.clickManagelevelClose();
	}
	@Test(priority=15)
	public void testcase15verifyTask() {
		objTaskPage= new TaskPage(driver);
		objTaskPage.clickTask();
		
	}
	@Test(priority = 16)
	public void testcase16verifyProjects() {
		objHome = new Home(driver);
		objHome.clickProjects();
		//objClientPage.clickAddclient();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);

	}
	@Test(priority = 17)
	public void testcase17verifyLeads() {
		objHome = new Home(driver);
		objHome.clickLeads();
		//objClientPage.clickAddclient();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);

	} 
	
	@Test(priority = 18)
	public void testcase18verifyTicket() {
		objHome = new Home(driver);
		objHome.clickTickets();
		//objClientPage.clickAddclient();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);

	}
	 
	@Test(priority = 19)
	public void testcase19verifyExpenses() {
		objHome = new Home(driver);
		objHome.clickExpenses();
		//objClientPage.clickAddclient();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);

	} } */
	/*@Test(priority = 20)
	public void testcase20VerifyRememberMe() {
		objLogin = new Login(driver);
		objLogin.selectRememberMe();
		Assert.assertEquals(objLogin.checkIfRememberMeIsChecked(),true,"RememberMe has not been checked");
	}*/
	
	
	/*@Test(priority = 21)
	public void testcase21verifySearchTab() throws IOException {
		//objHome = new Home(driver);
		objClientPage = new ClientPage(driver);
		objClientPage.clickClients();
		String password=(ExcelUtility.getNumericCellData(3, 1));
		objLogin.setUserPassword(password);
		objClientPage.clickSearchTab();
		//Assert.assertEquals(objHome.getHeadingofclientdetails(), AutomationConstants.EXPECTEDHEADINGOFCLIENT);
@Test(priority = 22)
	public void testcase22Forgotpassword()  throws IOException, InterruptedException {
	objLogin = new Login(driver);
	objHome = new Home(driver);
	
	String username=(ExcelUtility.getStringCellData(1,0));
	//String password=(ExcelUtility.getNumericCellData(2, 1));
	
	objLogin.setUserName(username);   
	objLogin.clickSend();
	//objLogin.setUserPassword(password);
	//objLogin.clickSignin();	
	Assert.assertEquals(objHome.getAlertMsg2(), AutomationConstants.EXPECTEDALERTMSG2);
	}
	
	@Test(priority = 23)
	public void testcase23verifyNoOfLinks() {
		//objHome = new Home(driver);
		objLogin.clickNoOfLinks();
		List<WebElement> listofLinks = driver.findElements(By.tagName("a"));
	    int count= listofLinks.size();
		System.out.println("Number of links in the webpage: " +count);
		
		
		Assert.assertEquals(count, AutomationConstants.EXPECTEDNOOFLINKS);
	}
	}*/
	
		
	/*@Test(priority=8)
	public void testcase12downloadExcel() {
		objTaskPage= new TaskPage(driver);
		objTaskPage.clickTask();
		objTaskPage.clickExcel();	

}}*/

/*@Test(priority=2)
public void searchTable()throw Exception {
	TeamPageFactory team= new TeamPageFactory(driver);
	
}*/

 /*
*/
/*@Test(priority = 2)
public void verifyHome() {
	objHome = new Home(driver);
	Assert.assertEquals(objHome.getDashboardMsg(), AutomationConstants.EXPECTEDDASHBOARDMSG);

}

@Test(priority=1)
	public void testcase04verifyclickForgotpassword() {
		objLogin.clickForgotpassword();		
	}
	
	@Test(priority=2)
	public void testcase04verifySignupisclickable() {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
        WebElement elementclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://buffalocart.com/demo/crm/index.php/signup']")));
		objLogin.clickSignup();
		
	}
	
*/